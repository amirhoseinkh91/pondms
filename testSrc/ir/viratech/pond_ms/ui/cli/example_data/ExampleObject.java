package ir.viratech.pond_ms.ui.cli.example_data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.PrecisionModel;

import ir.viratech.commons.cm.core.validation.ValidationException;
import ir.viratech.commons.cm.model.entity_instance.EntityInstance;
import ir.viratech.commons.cm.model.entity_instance.logic.EntityInstanceMgr;
import ir.viratech.commons.cm.model.entity_instance.logic.EntityInstanceMgrProvider;
import ir.viratech.commons.cm.model.entity_type.EntityType;
import ir.viratech.commons.cm.model.entity_type.EntityTypeNotFoundException;
import ir.viratech.commons.cm.model.entity_type.InvalidEntitySchemaException;
import ir.viratech.commons.cm.model.entity_type.logic.EntityTypeMgr;
import ir.viratech.commons.cm.model.enum_type.DuplicateEnumTypeException;
import ir.viratech.pond_ms.commons.geo.LineString;
import ir.viratech.pond_ms.commons.geo.Point;
import ir.viratech.pond_ms.commons.geo.Polygon;
import ir.viratech.pond_ms.core.cm.entity_type_importer.EntityTypeImporter;
import ir.viratech.pond_ms.core.spring.ApplicationContextUtil;
import ir.viratech.pond_ms.model.layer.VectorLayer;
import ir.viratech.pond_ms.model.layer.base.BaseVectorLayerMgr;
import ir.viratech.pond_ms.model.layer.logic.VectorLayerMgr;
import ir.viratech.pond_ms.model.map_object.vector.LineObject;
import ir.viratech.pond_ms.model.map_object.vector.PointObject;
import ir.viratech.pond_ms.model.map_object.vector.PolygonObject;
import ir.viratech.pond_ms.model.map_object.vector.base.BaseLineObjectMgr;
import ir.viratech.pond_ms.model.map_object.vector.base.BasePointObjectMgr;
import ir.viratech.pond_ms.model.map_object.vector.base.BasePolygonObjectMgr;
import ir.viratech.pond_ms.model.map_object.vector.logic.LineObjectMgr;
import ir.viratech.pond_ms.model.map_object.vector.logic.PointObjectMgr;
import ir.viratech.pond_ms.model.map_object.vector.logic.PolygonObjectMgr;

public class ExampleObject {

	private static final String FILE_NAME = "entityTypeInfo.json";

	protected void addData(VectorLayer vectorLayer1 , VectorLayer vectorLayer2) throws EntityTypeNotFoundException, ValidationException, JsonProcessingException, IOException, DuplicateEnumTypeException, InvalidEntitySchemaException {


		//============== make CM schemas and form instances ================
		ir.viratech.commons.cm.util.EntityTypeImporter.importFromUrl(EntityTypeImporter.class.getResource(FILE_NAME));
		ObjectMapper mapper = new ObjectMapper();

		//station
		ObjectNode objectNode = (ObjectNode)mapper.readTree(new File(getClass().getResource("../../../data/station.json").getFile()));
		EntityInstanceMgr mgr = EntityInstanceMgrProvider.getMgr("station");
		EntityType entityType = EntityTypeMgr.getInstance().getByKey("station");
		EntityInstance ei = new EntityInstance(entityType,objectNode);
		ei = mgr.add(ei, true);

		//river
        ObjectNode objectNode1 = (ObjectNode)mapper.readTree(new File(getClass().getResource("../../../data/river.json").getFile()));
		EntityInstanceMgr mgr1 = EntityInstanceMgrProvider.getMgr("river");
		EntityType entityType1 = EntityTypeMgr.getInstance().getByKey("river");
		EntityInstance ei1 = new EntityInstance(entityType1,objectNode1);
		ei1 = mgr1.add(ei1, true);
		//========================

		BaseVectorLayerMgr.getInstance().update(vectorLayer1);
		PointObject pointObject = PointObjectMgr.getInstance().createNew();
		pointObject.setLayer(vectorLayer1);
		pointObject.setName("test station");
		pointObject.setOrganization(vectorLayer1.getOrganization());
		pointObject.setProvider("testStationProvider");
		pointObject.setFormUID(ei.getExtuid());
		pointObject.setPoint(new Point(50.941433, 35.839854).getJtsGeometry());
		BasePointObjectMgr.getInstance().add(pointObject);
		vectorLayer1 = VectorLayerMgr.getInstance().reget(vectorLayer1);
		vectorLayer1.addToVectorObjects(pointObject);
		BaseVectorLayerMgr.getInstance().update(vectorLayer1);

		LineObject lineObject = LineObjectMgr.getInstance().createNew();
		lineObject.setLayer(vectorLayer2);
		lineObject.setName("test river");
		lineObject.setOrganization(vectorLayer2.getOrganization());
		lineObject.setProvider("testRiverProvider");
		lineObject.setFormUID(ei1.getExtuid());
		Coordinate[] coorArray = new Coordinate[2];
		coorArray[0] = (new Coordinate(50.941433, 35.839854));
		coorArray[1] = (new Coordinate(50.924184, 35.828888));
		GeometryFactory factory = new GeometryFactory(new PrecisionModel(), 4326);

		//commons.geo.LineString is used intentionally to make sure SRID and other things is correct.
		lineObject.setLine(new LineString(factory.createLineString(coorArray)).getJtsGeometry());
		BaseLineObjectMgr.getInstance().add(lineObject);

		vectorLayer2 = VectorLayerMgr.getInstance().reget(vectorLayer2);
		vectorLayer2.addToVectorObjects(lineObject);
		BaseVectorLayerMgr.getInstance().update(vectorLayer2);
	}

	protected void addAnotherData(VectorLayer vectorLayer1 , VectorLayer vectorLayer2) throws FileNotFoundException, IOException, DuplicateEnumTypeException, InvalidEntitySchemaException, EntityTypeNotFoundException, ValidationException {


		//============== make CM schemas and form instances ================
		ir.viratech.commons.cm.util.EntityTypeImporter.importFromUrl(EntityTypeImporter.class.getResource(FILE_NAME));
		ObjectMapper mapper = new ObjectMapper();

		//road
		ObjectNode objectNode = (ObjectNode)mapper.readTree(new File(getClass().getResource("../../../data/road.json").getFile()));
		EntityInstanceMgr mgr = EntityInstanceMgrProvider.getMgr("road");
		EntityType entityType = EntityTypeMgr.getInstance().getByKey("road");
		EntityInstance ei = new EntityInstance(entityType,objectNode);
		ei = mgr.add(ei, true);

		//garden
        ObjectNode objectNode1 = (ObjectNode)mapper.readTree(new File(getClass().getResource("../../../data/garden.json").getFile()));
		EntityInstanceMgr mgr1 = EntityInstanceMgrProvider.getMgr("garden");
		EntityType entityType1 = EntityTypeMgr.getInstance().getByKey("garden");
		EntityInstance ei1 = new EntityInstance(entityType1,objectNode1);
		ei1 = mgr1.add(ei1, true);
		//========================


		LineObject lineObject = LineObjectMgr.getInstance().createNew();
		lineObject.setLayer(vectorLayer1);
		lineObject.setName("test road");
		lineObject.setOrganization(vectorLayer1.getOrganization());
		lineObject.setFormUID(ei.getExtuid());
		Coordinate[] coorArray = new Coordinate[2];
		coorArray[0] = (new Coordinate(50.843400, 36.137366));
		coorArray[1] = (new Coordinate(50.810560, 36.538201));
		GeometryFactory factory = new GeometryFactory(new PrecisionModel(), 4326);

		//commons.geo.LineString is used intentionally to make sure SRID and other things is correct.
		lineObject.setLine(new LineString(factory.createLineString(coorArray)).getJtsGeometry());
		lineObject.setProvider("testRoadProvider");
		BaseLineObjectMgr.getInstance().add(lineObject);
		vectorLayer1 = VectorLayerMgr.getInstance().reget(vectorLayer1);
		vectorLayer1.addToVectorObjects(lineObject);
		BaseVectorLayerMgr.getInstance().update(vectorLayer1);

		PolygonObject polygonObject = PolygonObjectMgr.getInstance().createNew();
		polygonObject.setLayer(vectorLayer2);
		polygonObject.setFormUID(ei1.getExtuid());
		polygonObject.setName("test garden");
		polygonObject.setOrganization(vectorLayer2.getOrganization());
		Coordinate[] coorArray2 = new Coordinate[6];
		coorArray2[0] = (new Coordinate(51.251628, 35.707687));
		coorArray2[1] = (new Coordinate(51.336826, 35.699532));
		coorArray2[2] = (new Coordinate(51.340613, 35.680187));
		coorArray2[3] = (new Coordinate(51.325228, 35.674740));
		coorArray2[4] = (new Coordinate(51.233572, 35.683612));
		coorArray2[5] = (new Coordinate(51.251628, 35.707687));
		polygonObject.setPolygon(new Polygon(factory.createPolygon(factory.createLinearRing(coorArray2), null)).getJtsGeometry());
		polygonObject.setProvider("testGardenProvider");
		BasePolygonObjectMgr.getInstance().add(polygonObject);

		vectorLayer2 = VectorLayerMgr.getInstance().reget(vectorLayer2);
		vectorLayer2.addToVectorObjects(polygonObject);
		BaseVectorLayerMgr.getInstance().update(vectorLayer2);
	}


	public static void main(String... args) throws EntityTypeNotFoundException, ValidationException, JsonProcessingException, IOException, DuplicateEnumTypeException, InvalidEntitySchemaException {
		ApplicationContextUtil.initializeCliApplicationContext();
		List<VectorLayer> vectorLayers = VectorLayerMgr.getInstance().list();
		if(vectorLayers.size() < 4){
			ExampleLayer.main(args);
			vectorLayers = VectorLayerMgr.getInstance().list();
		}
		new ExampleObject().addData(vectorLayers.get(0), vectorLayers.get(1));
		new ExampleObject().addAnotherData(vectorLayers.get(2), vectorLayers.get(3));
	}

}
