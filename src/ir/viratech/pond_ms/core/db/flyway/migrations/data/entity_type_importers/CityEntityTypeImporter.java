package ir.viratech.pond_ms.core.db.flyway.migrations.data.entity_type_importers;

import ir.viratech.commons.cm.model.entity_type.InvalidEntitySchemaException;
import ir.viratech.commons.cm.model.enum_type.DuplicateEnumTypeException;
import ir.viratech.pond_ms.core.cm.entity_type_importer.EntityTypeImporter;
import ir.viratech.pond_ms.core.spring.ApplicationContextUtil;

import java.io.FileNotFoundException;
import java.io.IOException;

public class CityEntityTypeImporter {

    private static final String FILE_NAME = "../../db/flyway/migrations/data/vector_object_forms/cityEntityTypeInfo.json";

    public static void main(String[] args) throws FileNotFoundException, IOException, DuplicateEnumTypeException, InvalidEntitySchemaException {
        ApplicationContextUtil.initializeCliApplicationContext();
        ir.viratech.commons.cm.util.EntityTypeImporter.importFromUrl(EntityTypeImporter.class.getResource(FILE_NAME));
    }
}
