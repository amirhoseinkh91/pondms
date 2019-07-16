package ir.viratech.pond_ms.core.db.flyway.migrations.data.vector_object_forms.field_type_handler;

import com.fasterxml.jackson.databind.JsonNode;
import ir.viratech.commons.cm.core.field_type.AbstractFieldTypeHandler;
import ir.viratech.commons.cm.core.schema.PropertyInfo;
import ir.viratech.commons.cm.core.validation.ValidationErrorEntry;
import ir.viratech.commons.cm.model.entity_instance.SinglePropertyInstance;

import java.util.Map;

public class LocationFieldTypeHandler extends AbstractFieldTypeHandler {
    public static final String TYPE = "location";
    private static final String PROP_TYPE = "type";
    private static final String PROP_COORDINATES = "coordinates";


    @Override
    public boolean canHandle(PropertyInfo propertyInfo) {
        if (propertyInfo.getType().equals(TYPE)) {
            return true;
        }
        return false;
    }

    @Override
    public ValidationErrorEntry validate(SinglePropertyInstance singlePropertyInstance) {
        JsonNode data = singlePropertyInstance.getData();
        if (!data.has(PROP_TYPE)) {
            return new ValidationErrorEntry("type of point must not be empty", singlePropertyInstance);
        }
        if (!data.get(PROP_TYPE).isTextual()) {
            return new ValidationErrorEntry("type is string! fix it", singlePropertyInstance);
        }
        if (!data.get(PROP_TYPE).asText().equals("Point")) {
            return new ValidationErrorEntry("point type is wrong", singlePropertyInstance);
        }
        if (!data.has(PROP_COORDINATES)) {
            return new ValidationErrorEntry("type of point must not be empty", singlePropertyInstance);
        }
        if (!data.get(PROP_COORDINATES).isArray()) {
            return new ValidationErrorEntry("coordinates must be array node", singlePropertyInstance);
        }
        return null;
    }

    @Override
    public Map<String, Object> getSearchMappingDefinition(PropertyInfo propertyInfo) {
        return null;
    }

    @Override
    public Object getSearchDocumentDefinition(SinglePropertyInstance singlePropertyInstance) {
        return null;
    }
}
