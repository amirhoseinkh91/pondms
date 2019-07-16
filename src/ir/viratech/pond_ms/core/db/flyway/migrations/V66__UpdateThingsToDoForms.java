package ir.viratech.pond_ms.core.db.flyway.migrations;

import ir.viratech.pond_ms.core.cm.entity_type_importer.EntityTypeImporter;

import java.sql.Connection;

public class V66__UpdateThingsToDoForms extends BaseJdbcMigration {
    final static String VECTOR_FORMS_FILE = "../../db/flyway/migrations/data/vector_object_forms/update_things_to_do_form.json";

    @Override
    public void migrate(Connection connection) throws Exception {
        ir.viratech.commons.cm.util.EntityTypeImporter.importFromUrl(EntityTypeImporter.class.getResource(VECTOR_FORMS_FILE));
    }
}
