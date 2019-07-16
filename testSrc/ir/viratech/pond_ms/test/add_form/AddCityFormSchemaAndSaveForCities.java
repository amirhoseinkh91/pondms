package ir.viratech.pond_ms.test.add_form;

import java.io.IOException;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.mongodb.BasicDBObject;

import ir.viratech.base.AbstractEntityDAO;
import ir.viratech.commons.cm.core.validation.ValidationException;
import ir.viratech.commons.cm.model.entity_instance.EntityInstance;
import ir.viratech.commons.cm.model.entity_instance.logic.EntityInstanceMgr;
import ir.viratech.commons.cm.model.entity_instance.logic.EntityInstanceMgrProvider;
import ir.viratech.commons.cm.model.entity_type.EntityTypeNotFoundException;
import ir.viratech.commons.cm.model.entity_type.InvalidEntitySchemaException;
import ir.viratech.commons.cm.model.enum_type.DuplicateEnumTypeException;
import ir.viratech.commons.persistence.mongo.base.MongoDBManager;
import ir.viratech.commons.util.jackson.JacksonUtils;
import ir.viratech.just_ro.model.Website;
import ir.viratech.pond_ms.commons.geo.Point;
import ir.viratech.pond_ms.core.cm.entity_type_importer.EntityTypeImporter;
import ir.viratech.pond_ms.core.spring.ApplicationContextUtil;
import ir.viratech.pond_ms.model.layer.Layer;
import ir.viratech.pond_ms.model.layer.ParentLayer;
import ir.viratech.pond_ms.model.layer.VectorLayer;
import ir.viratech.pond_ms.model.layer.logic.ParentLayerMgr;
import ir.viratech.pond_ms.model.layer.logic.VectorLayerMgr;
import ir.viratech.pond_ms.model.map_object.vector.GISVectorObject;
import ir.viratech.pond_ms.model.map_object.vector.PointObject;
import ir.viratech.pond_ms.model.map_object.vector.logic.GISVectorObjectMgr;
import ir.viratech.pond_ms.model.map_object.vector.logic.PointObjectMgr;

public class AddCityFormSchemaAndSaveForCities {

	final static String VECTOR_FORMS_FILE = "../../db/flyway/migrations/data/vector_object_forms/vector_objects_forms.json";

	private double lat;
	private double lng;

	private long hotelsCount;
	private long thingsToDoCount;

	public static void main(String[] args) throws Exception {
		ApplicationContextUtil.initializeCliApplicationContext();
		AbstractEntityDAO.touchSession();
		AddCityFormSchemaAndSaveForCities add = new AddCityFormSchemaAndSaveForCities();
		add.addCityFormsToCities();
	}

	private void importForms() {
		try {
			ir.viratech.commons.cm.util.EntityTypeImporter
					.importFromUrl(EntityTypeImporter.class.getResource(VECTOR_FORMS_FILE));
		} catch (IOException | DuplicateEnumTypeException | InvalidEntitySchemaException e) {
			e.printStackTrace();
		}
	}

	private void count(ParentLayer layer) {
		List<Layer> subLayers = layer.getSubLayers();
		MongoDBManager manager = MongoDBManager.getInstance();
		BasicDBObject query = new BasicDBObject();
		query.append("_isDeleted", false);
		countThingsToDo(manager, query, subLayers.get(2).getExtuid());
		countHotels(manager, query, subLayers.get(0).getExtuid());
	}

	private void countHotels(MongoDBManager manager, BasicDBObject query, String extuid) {
		query.append("__type", "Hotel");
		query.append("layer_uid", extuid);
		hotelsCount = manager.getDB().getCollection("hotel_col").getCount(query);
	}

	private void countThingsToDo(MongoDBManager manager, BasicDBObject query, String extuid) {
		query.append("__type", "Things_To_Do");
		query.append("layer_uid", extuid);
		thingsToDoCount = manager.getDB().getCollection("things_to_do_col").getCount(query);
	}

	private void addCityFormsToCities() throws ValidationException, EntityTypeNotFoundException {
		AbstractEntityDAO.touchSession();
		/*
		 * add forms!
		 */
		List<ParentLayer> layers = ParentLayerMgr.getInstance().list();
		int counter = 0;
		for (ParentLayer layer : layers) {
			if (layer.getType().equals(Layer.TYPE_PARENT) && layer.getName().startsWith("شهر")) {
				System.out.print(layer.getName() + "\t");

				VectorLayer vectorLayer = VectorLayerMgr.getInstance().createNew();
				vectorLayer.setName("معرفی شهر");
				vectorLayer.setVectorObjectsType(GISVectorObject.TYPE__POINT);
				vectorLayer.setLabled(true);
				vectorLayer.setSecret(false);
				vectorLayer.setFormSchemaKey("city");
				vectorLayer.setMap(layer.getMap());
				layer.addToSubLayers(vectorLayer);
				ParentLayerMgr.getInstance().update(layer);

				/*
				 * add default pointObject to vectorLayer
				 */
				PointObject p = PointObjectMgr.getInstance().createNew();
				EntityInstanceMgr entityInstanceMgr = EntityInstanceMgrProvider.getMgr(vectorLayer.getFormSchemaKey());
				ObjectNode data = JacksonUtils.createEmptyObjectNode();

				count(layer);
				data.put("name", layer.getName());
				data.put("hotel_count", hotelsCount);
				data.put("things_to_do_count", thingsToDoCount);
				data.put("restaurant_count", 0);
				data.put("Rate", 0);
				data.put("IntrinsicValue", 0);
				data.put("TemporalValue", 0);
				data.put("TotalScore", 0);

				EntityInstance entityInstance = new EntityInstance(vectorLayer.getFormSchemaKey(), data);
				entityInstance = entityInstanceMgr.add(entityInstance, true);
				p.setFormUID(entityInstance.getUid());
				p.setName(layer.getName());
				getCityPoint(layer.getName().substring(4));
				p.setPoint(new Point(lat, lng).getJtsGeometry());
				p.setLayer(vectorLayer);
				GISVectorObjectMgr.getInstance().add(p);
				System.out.println((++counter) + "\tlayers added.");
			}
		}

		AbstractEntityDAO.closeCurrentThreadSessions();
	}

	private void getCityPoint(String name) {
		String baseurl = "http://maps.googleapis.com/maps/api/geocode/json?address=";
		String url = baseurl + name;
		try {
			Response response = Jsoup.connect(url).header("Accept", "application/json;charset=utf-8")
					.ignoreContentType(true).ignoreHttpErrors(true).userAgent(Website.userAgent).method(Method.GET)
					.execute();
			findLatLng(response);
		} catch (IOException | JSONException e) {
			lat = 0.0;
			lng = 0.0;
			e.printStackTrace();
		}
	}

	private void findLatLng(Response response) throws JSONException{
			JSONObject baseJsonObj = new JSONObject(response.body().toString());
			JSONObject locationObj = baseJsonObj.getJSONArray("results").getJSONObject(0).getJSONObject("geometry")
					.getJSONObject("location");
			lng = locationObj.getDouble("lat");
			lat = locationObj.getDouble("lng");
			System.out.println("lat: " + lng + " , lng: " + lat);
	}

}
