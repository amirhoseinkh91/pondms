package ir.viratech.pond_ms.core.db.flyway.migrations.data.vector_object_forms.field_type_handler;

import com.fasterxml.jackson.databind.JsonNode;
import ir.viratech.commons.cm.core.field_type.AbstractFieldTypeHandler;
import ir.viratech.commons.cm.core.schema.PropertyInfo;
import ir.viratech.commons.cm.core.validation.ValidationErrorEntry;
import ir.viratech.commons.cm.model.entity_instance.SinglePropertyInstance;

import java.util.Map;

public class CustomPointFieldTypeHandler extends AbstractFieldTypeHandler {
    public static final String TYPE = "point";
    private static final String PROP_NAME = "name";
    private static final String PROP_POINT = "point";


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
        if (!data.has(PROP_NAME)) {
            return new ValidationErrorEntry("name must not be empty", singlePropertyInstance);
        }
        if (!data.has(PROP_POINT)) {
            return new ValidationErrorEntry("point must not be null", singlePropertyInstance);
        }
        if (data.has(PROP_POINT)) {
            if (!data.get(PROP_POINT).isObject()) {
                return new ValidationErrorEntry("point must be object", singlePropertyInstance);
            }
            if (!data.get(PROP_POINT).has("type")) {
                return new ValidationErrorEntry("type of point must not be empty", singlePropertyInstance);
            }
            if (!data.get(PROP_POINT).get("type").asText().equals("Point")) {
                return new ValidationErrorEntry("point type is wrong", singlePropertyInstance);
            }
            if (!data.get(PROP_POINT).has("coordinates")) {
                return new ValidationErrorEntry("type of point must not be empty", singlePropertyInstance);
            }
            if (!data.get(PROP_POINT).get("coordinates").isArray()) {
                return new ValidationErrorEntry("coordinates must be array node", singlePropertyInstance);
            }
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
