package ir.viratech.pond_ms.core.db.flyway.migrations.data.vector_object_forms.field_type_handler;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import ir.viratech.commons.cm.core.field_type.AbstractFieldTypeHandler;
import ir.viratech.commons.cm.core.schema.PropertyInfo;
import ir.viratech.commons.cm.core.validation.ValidationErrorEntry;
import ir.viratech.commons.cm.model.entity_instance.SinglePropertyInstance;

import java.util.Map;

public class PlacesPlanFieldTypeHandler extends AbstractFieldTypeHandler {

    public static final String TYPE = "placesPlan";
    private static final String PROP_PRICE = "price";
    private static final String PROP_START_DATE = "startDate";
    private static final String PROP_END_DATE = "endDate";
    private static final String PROP_RESERVE = "reserve";

    @Override
    public boolean canHandle(PropertyInfo propertyInfo) {
        if (TYPE.equals(propertyInfo.getType()))
            return true;
        return false;
    }

    @Override
    public ValidationErrorEntry validate(SinglePropertyInstance singlePropertyInstance) {
        JsonNode data = singlePropertyInstance.getData();
        if (!data.has(PROP_PRICE)) {
            return new ValidationErrorEntry("price must not be null", singlePropertyInstance);
        }
        if (data.has(PROP_PRICE)) {
            if (data.get(PROP_PRICE).isInt()) {
                ((ObjectNode) data).put(PROP_PRICE, data.get(PROP_PRICE).asDouble());
            }
            if (!data.get(PROP_PRICE).isDouble())
                return new ValidationErrorEntry("price must be double", singlePropertyInstance);
        }
        if (!data.has(PROP_START_DATE)) {
            return new ValidationErrorEntry("startDate must not be null", singlePropertyInstance);
        }
        if (data.has(PROP_START_DATE)) {
            if (!data.get(PROP_START_DATE).isLong())
                return new ValidationErrorEntry("startDate must be long", singlePropertyInstance);
        }
        if (!data.has(PROP_END_DATE)) {
            return new ValidationErrorEntry("endDate must not be null", singlePropertyInstance);
        }
        if (data.has(PROP_END_DATE)) {
            if (!data.get(PROP_END_DATE).isLong())
                return new ValidationErrorEntry("endDate must be long", singlePropertyInstance);
        }
        if (!data.has(PROP_RESERVE)) {
            return new ValidationErrorEntry("reserve must not be null", singlePropertyInstance);
        }
        if (data.has(PROP_RESERVE)) {
            if (!data.get(PROP_RESERVE).isTextual())
                return new ValidationErrorEntry("endDate must be string", singlePropertyInstance);
        }
        return null;
    }

    @Override
    public Object getSearchDocumentDefinition(SinglePropertyInstance arg0) {
        return null;
    }

    @Override
    public Map<String, Object> getSearchMappingDefinition(PropertyInfo arg0) {
        return null;
    }
}
