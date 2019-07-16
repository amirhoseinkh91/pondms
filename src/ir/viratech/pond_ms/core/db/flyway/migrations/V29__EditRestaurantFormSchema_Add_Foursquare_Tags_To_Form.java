package ir.viratech.pond_ms.core.db.flyway.migrations;

import ir.viratech.base.SuppressWarningsOption;
import ir.viratech.pond_ms.core.cm.entity_type_importer.EntityTypeImporter;
import ir.viratech.pond_ms.core.spring.ApplicationContextUtil;

import java.sql.Connection;

@SuppressWarnings(SuppressWarningsOption.ALL)
public class V29__EditRestaurantFormSchema_Add_Foursquare_Tags_To_Form extends BaseJdbcMigration {

    final static String VECTOR_FORMS_FILE = "../../db/flyway/migrations/data/vector_object_forms/vector_objects_forms.json";

    @Override
    public void migrate(Connection conn) throws Exception {
        ir.viratech.commons.cm.util.EntityTypeImporter.importFromUrl(EntityTypeImporter.class.getResource(VECTOR_FORMS_FILE));
    }
}
