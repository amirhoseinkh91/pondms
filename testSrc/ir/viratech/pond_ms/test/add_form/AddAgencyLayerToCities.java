package ir.viratech.pond_ms.test.add_form;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import ir.viratech.base.AbstractEntityDAO;
import ir.viratech.commons.cm.model.entity_type.logic.EntityTypeMgr;
import ir.viratech.pond_ms.core.cm.entity_type_importer.EntityTypeImporter;
import ir.viratech.pond_ms.core.spring.ApplicationContextUtil;
import ir.viratech.pond_ms.model.layer.Layer;
import ir.viratech.pond_ms.model.layer.ParentLayer;
import ir.viratech.pond_ms.model.layer.VectorLayer;
import ir.viratech.pond_ms.model.layer.logic.ParentLayerMgr;
import ir.viratech.pond_ms.model.layer.logic.VectorLayerMgr;
import ir.viratech.pond_ms.model.map_object.vector.GISVectorObject;

public class AddAgencyLayerToCities {

	final static String VECTOR_FORMS_FILE = "../../db/flyway/migrations/data/vector_object_forms/vector_objects_forms.json";

	@Transactional
	public void main(String[] args) {
		ApplicationContextUtil.initializeCliApplicationContext();
		AbstractEntityDAO.touchSession();
		try {

			ir.viratech.commons.cm.model.entity_type.EntityType entityType = EntityTypeMgr.getInstance()
					.getByKey("Agency");
			String rawJsonSchema = entityType.getRawJsonSchema();
			System.out.println("Agency");
			System.out.println(rawJsonSchema);

			entityType = EntityTypeMgr.getInstance().getByKey("Things_To_Do");
			rawJsonSchema = entityType.getRawJsonSchema();
			System.out.println("Things_To_Do");
			System.out.println(rawJsonSchema);

			entityType = EntityTypeMgr.getInstance().getByKey("Hotel");
			rawJsonSchema = entityType.getRawJsonSchema();
			System.out.println("Hotel");
			System.out.println(rawJsonSchema);

			entityType = EntityTypeMgr.getInstance().getByKey("Restaurant");
			rawJsonSchema = entityType.getRawJsonSchema();
			System.out.println("Restaurant");
			System.out.println(rawJsonSchema);
			
			entityType = EntityTypeMgr.getInstance().getByKey("city");
			rawJsonSchema = entityType.getRawJsonSchema();
			System.out.println("City");
			System.out.println(rawJsonSchema);

//			ir.viratech.commons.cm.util.EntityTypeImporter
//					.importFromUrl(EntityTypeImporter.class.getResource(VECTOR_FORMS_FILE));
//
//			List<ParentLayer> layers = ParentLayerMgr.getInstance().list();
//			int counter = 0;
//			for (ParentLayer layer : layers) {
//				if (layer.getType().equals(Layer.TYPE_PARENT) && layer.getName().startsWith("شهر")) {
//					System.out.println(layer.getName());
//					counter++;
//					VectorLayer vectorLayer = VectorLayerMgr.getInstance().createNew();
//					vectorLayer.setName("آژانس ها");
//					vectorLayer.setVectorObjectsType(GISVectorObject.TYPE__POINT);
//					vectorLayer.setLabled(true);
//					vectorLayer.setSecret(false);
//					vectorLayer.setFormSchemaKey("Agency");
//					vectorLayer.setMap(layer.getMap());
//					layer.addToSubLayers(vectorLayer);
//					ParentLayerMgr.getInstance().update(layer);
//					System.out.println((counter) + "\tlayers added.");
//				}
//			}

			AbstractEntityDAO.closeCurrentThreadSessions();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
