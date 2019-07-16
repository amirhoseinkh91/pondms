package ir.viratech.pond_ms.core.db.flyway.migrations;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;

import ir.viratech.commons.cm.model.entity_type.InvalidEntitySchemaException;
import ir.viratech.commons.cm.model.enum_type.DuplicateEnumTypeException;
import ir.viratech.pond_ms.core.cm.entity_type_importer.EntityTypeImporter;
import ir.viratech.pond_ms.core.spring.ApplicationContextUtil;

public class V5__DefaultFormSchemas extends BaseJdbcMigration {

	@Override
	public void migrate(Connection arg0) throws Exception {

//		final String ENUM_TPES_FILE = "../../db/flyway/migrations/data/enum_types/enum_types.json";
//		final String POND_FORMS_FILE = "../../db/flyway/migrations/data/pond_forms/pond_forms.json";
//		final String VECTOR_FORMS_FILE = "../../db/flyway/migrations/data/vector_object_forms/vector_objects_forms.json";
		final String VECTOR_FORMS_FILE = "../../db/flyway/migrations/data/vector_object_forms/vector_objects_forms.json";

//		ir.viratech.commons.cm.util.EntityTypeImporter
//				.importFromUrl(EntityTypeImporter.class.getResource(ENUM_TPES_FILE));
//		ir.viratech.commons.cm.util.EntityTypeImporter
//				.importFromUrl(EntityTypeImporter.class.getResource(POND_FORMS_FILE));
		ir.viratech.commons.cm.util.EntityTypeImporter
				.importFromUrl(EntityTypeImporter.class.getResource(VECTOR_FORMS_FILE));

	}

	public static void main(String[] args)
			throws FileNotFoundException, IOException, DuplicateEnumTypeException, InvalidEntitySchemaException {
		ApplicationContextUtil.initializeCliApplicationContext();
		final String FILE_NAME = "../../db/flyway/migrations/data/pondFormSchemas.json";
		ir.viratech.commons.cm.util.EntityTypeImporter.importFromUrl(EntityTypeImporter.class.getResource(FILE_NAME));

	}
}
