package ir.viratech.pond_ms.core.db.flyway.migrations.data.vector_object_forms.field_type_handler;

import com.fasterxml.jackson.databind.JsonNode;
import ir.viratech.commons.cm.core.field_type.AbstractFieldTypeHandler;
import ir.viratech.commons.cm.core.schema.PropertyInfo;
import ir.viratech.commons.cm.core.validation.ValidationErrorEntry;
import ir.viratech.commons.cm.model.entity_instance.SinglePropertyInstance;

import java.util.Map;

public class PlacesUidFieldTypeHandler extends AbstractFieldTypeHandler {

    public static final String TYPE = "placeUid";
    private static final String PROP_NAME = "name";
    private static final String PROP_UID = "UID";

    @Override
    public boolean canHandle(PropertyInfo propertyInfo) {
        if (TYPE.equals(propertyInfo.getType())) {
            return true;
        }
        return false;
    }

    @Override
    public ValidationErrorEntry validate(SinglePropertyInstance singlePropertyInstance) {
        JsonNode data = singlePropertyInstance.getData();
        if (!data.has(PROP_NAME)) {
            return new ValidationErrorEntry("name is null, pleas fill it!", singlePropertyInstance);
        } else {
            if (!data.get(PROP_NAME).isTextual()) {
                return new ValidationErrorEntry("name type is wrong, change is to string", singlePropertyInstance);
            }
        }
        if (!data.has(PROP_UID)) {
            return new ValidationErrorEntry("UID is null, pleas fill it!", singlePropertyInstance);
        } else {
            if (!data.get(PROP_UID).isTextual()) {
                return new ValidationErrorEntry("UID type is wrong, change is to string", singlePropertyInstance);
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
