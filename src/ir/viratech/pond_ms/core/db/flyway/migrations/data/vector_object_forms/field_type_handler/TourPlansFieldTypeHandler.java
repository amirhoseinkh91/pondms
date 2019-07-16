package ir.viratech.pond_ms.core.db.flyway.migrations.data.vector_object_forms.field_type_handler;

import com.fasterxml.jackson.databind.JsonNode;
import ir.viratech.commons.cm.core.field_type.AbstractFieldTypeHandler;
import ir.viratech.commons.cm.core.schema.PropertyInfo;
import ir.viratech.commons.cm.core.validation.ValidationErrorEntry;
import ir.viratech.commons.cm.model.entity_instance.SinglePropertyInstance;

import java.util.Map;

public class TourPlansFieldTypeHandler extends AbstractFieldTypeHandler {
    public static final String TYPE = "tourPlan";
    private static final String PROP_DEPARTURE_DATE = "departure_date";
    private static final String PROP_ARRIVING_DATE = "arriving_date";
    private static final String PROP_RESORT_NAME = "resort_name";
    private static final String PROP_RATE = "rate";
    private static final String PROP_SERVICES = "services";
    private static final String PROP_PRICES = "prices";
    private static final String PROP_KIND = "kind";
    private static final String PROP_PRICE = "price";

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
        if (!data.has(PROP_DEPARTURE_DATE)) {
            return new ValidationErrorEntry("departure date must not be null", singlePropertyInstance);
        }
        if (!data.get(PROP_DEPARTURE_DATE).isLong()) {
            return new ValidationErrorEntry("departure date must  be time stamp", singlePropertyInstance);
        }
        if (!data.has(PROP_ARRIVING_DATE)) {
            return new ValidationErrorEntry("arriving date must not be null", singlePropertyInstance);
        }
        if (!data.get(PROP_ARRIVING_DATE).isLong()) {
            return new ValidationErrorEntry("arriving date must be time stamp", singlePropertyInstance);
        }
        if (!data.has(PROP_RESORT_NAME)) {
            return new ValidationErrorEntry("resort name must not be null", singlePropertyInstance);
        }
        if (!data.get(PROP_RESORT_NAME).isTextual()) {
            return new ValidationErrorEntry("resort name must be string", singlePropertyInstance);
        }
        if (!data.has(PROP_RATE)) {
            return new ValidationErrorEntry("rate must not be null", singlePropertyInstance);
        }
        if (!data.get(PROP_RATE).isInt()) {
            return new ValidationErrorEntry("rate must not be null", singlePropertyInstance);
        }
        if (!(data.get(PROP_RATE).asInt() >= 0) || !(data.get(PROP_RATE).asInt() <= 10)) {
            return new ValidationErrorEntry("rate is not between 0 to 10", singlePropertyInstance);
        }
        if (!data.has(PROP_SERVICES)) {
            return new ValidationErrorEntry("services must not be null", singlePropertyInstance);
        }
        if (!data.get(PROP_SERVICES).isTextual()) {
            return new ValidationErrorEntry("services is not string", singlePropertyInstance);
        }
        if (!data.has(PROP_PRICES)) {
            return new ValidationErrorEntry("prices must not be null", singlePropertyInstance);
        }
        if (data.has(PROP_PRICES)) {
            if (!data.get(PROP_PRICES).isArray()) {
                return new ValidationErrorEntry("prices is not array", singlePropertyInstance);
            }
            if (data.get(PROP_PRICES).isArray()) {
                for (JsonNode internalObject : data.get(PROP_PRICES)) {
                    if (!internalObject.has(PROP_KIND)) {
                        return new ValidationErrorEntry("kind must not be null", singlePropertyInstance);
                    }
                    if (!internalObject.get(PROP_KIND).isTextual()) {
                        return new ValidationErrorEntry("kind is not string", singlePropertyInstance);
                    }
                    if (!internalObject.has(PROP_PRICE)) {
                        return new ValidationErrorEntry("price must not be null", singlePropertyInstance);
                    }
                    if (!internalObject.get(PROP_PRICE).isDouble()) {
                        return new ValidationErrorEntry("price is not double", singlePropertyInstance);
                    }
                }
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
