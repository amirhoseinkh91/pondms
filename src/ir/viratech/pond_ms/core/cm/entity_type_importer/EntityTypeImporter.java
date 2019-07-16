package ir.viratech.pond_ms.core.cm.entity_type_importer;

import java.io.IOException;

import ir.viratech.commons.cm.model.entity_type.InvalidEntitySchemaException;
import ir.viratech.commons.cm.model.enum_type.DuplicateEnumTypeException;
import ir.viratech.pond_ms.core.spring.ApplicationContextUtil;

public class EntityTypeImporter {
	
	private static final String FILE_NAME = "entityTypeInfo.json";
	public static void main(String[] args) throws IOException, DuplicateEnumTypeException, InvalidEntitySchemaException {
		ApplicationContextUtil.initializeCliApplicationContext();
		ir.viratech.commons.cm.util.EntityTypeImporter.importFromUrl(EntityTypeImporter.class.getResource(FILE_NAME));
	}
}