package ir.viratech.pond_ms.core.db.flyway.migrations;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import ir.viratech.base.AbstractEntityDAO;
import ir.viratech.commons.cm.core.db.flyway.migrations.BaseJdbcMigration;
import ir.viratech.commons.cm.model.entity_type.InvalidEntitySchemaException;
import ir.viratech.commons.cm.model.enum_type.DuplicateEnumTypeException;
import ir.viratech.pond_ms.core.cm.entity_type_importer.EntityTypeImporter;
import ir.viratech.pond_ms.model.layer.Layer;
import ir.viratech.pond_ms.model.layer.ParentLayer;
import ir.viratech.pond_ms.model.layer.VectorLayer;
import ir.viratech.pond_ms.model.layer.logic.ParentLayerMgr;
import ir.viratech.pond_ms.model.layer.logic.VectorLayerMgr;
import ir.viratech.pond_ms.model.map_object.vector.GISVectorObject;

public class V23__AddAgencyFormSchemaAndSaveForCities extends BaseJdbcMigration {

	final static String VECTOR_FORMS_FILE = "../../db/flyway/migrations/data/vector_object_forms/vector_objects_forms.json";

	@Override
	public void migrate(Connection connection) throws Exception {
		importForms();
		addAgencyFormsToCities();
	}

	private void importForms() {
		try {
			ir.viratech.commons.cm.util.EntityTypeImporter
					.importFromUrl(EntityTypeImporter.class.getResource(VECTOR_FORMS_FILE));
		} catch (IOException | DuplicateEnumTypeException | InvalidEntitySchemaException e) {
			e.printStackTrace();
		}
	}

	private void addAgencyFormsToCities() {
		AbstractEntityDAO.touchSession();

		List<ParentLayer> layers = ParentLayerMgr.getInstance().list();
		int counter = 0;
		for (ParentLayer layer : layers) {
			if (layer.getType().equals(Layer.TYPE_PARENT) && layer.getName().startsWith("شهر")) {
				System.out.println(layer.getName());
				counter++;
				VectorLayer vectorLayer = VectorLayerMgr.getInstance().createNew();
				vectorLayer.setName("آژانس ها");
				vectorLayer.setVectorObjectsType(GISVectorObject.TYPE__POINT);
				vectorLayer.setLabled(true);
				vectorLayer.setSecret(false);
				vectorLayer.setFormSchemaKey("Agency");
				vectorLayer.setMap(layer.getMap());
				layer.addToSubLayers(vectorLayer);
				ParentLayerMgr.getInstance().update(layer);
				System.out.println((counter) + "\tlayers added.");
			}
		}

		AbstractEntityDAO.closeCurrentThreadSessions();
	}

}
