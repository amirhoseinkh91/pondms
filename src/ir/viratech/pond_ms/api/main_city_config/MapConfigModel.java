package ir.viratech.pond_ms.api.main_city_config;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import ir.viratech.commons.util.jackson.JacksonUtils;
import ir.viratech.commons.util.jackson.ObjectMapperProvider;
import ir.viratech.pond_ms.model.main_city_config.ConfigFilter;
import ir.viratech.pond_ms.model.main_city_config.ConfigModel;
import ir.viratech.pond_ms.model.main_city_config.ConfigPoint;
import ir.viratech.pond_ms.model.main_city_config.ConfigSort;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Map;

public class MapConfigModel {
    public JsonNode mapper(ConfigModel configModel) {

        ObjectNode configModelObject = ObjectMapperProvider.getObjectMapper().createObjectNode();
        configModelObject.put("name", configModel.getName());
        configModelObject.put("items", configModel.getItems());
        configModelObject.put("visitPage", configModel.getVisitPage());
        configModelObject.put("type", configModel.getType());
        configModelObject.put("sortBy", sortObject(configModel.getConfigSort()));
        configModelObject.put("filter", returnArrayFilterConfig(configModel.getFilter()));

        return configModelObject;
    }

    private JsonNode returnArrayFilterConfig(ConfigFilter filter) {
        if (filter != null) {
            String cityName = filter.getCityName();
            ConfigPoint point = filter.getPoint();
            List<Integer> prices = null;
            if (filter.getPrices() != null)
                prices = filter.getPrices();
            List<Integer> rates = null;
            if (filter.getRates() != null)
                rates = filter.getRates();
            List<String> tags = filter.getTags();
            List<String> features = filter.getFeatures();

            JsonNode pointObject = null;
            if (point != null)
                if (point.getX() > 1 && point.getY() > 1 && point.getRadius() > 1) {
                    pointObject = pointObject(point);
                }

            ArrayNode rateArrays = null;
            if (rates != null)
                if (rates.size() > 0) {
                    rateArrays = rateArray(rates);
                }
            ArrayNode priceArrays = null;
            if (prices != null)
                if (prices.size() > 0) {
                    priceArrays = priceArray(prices);
                }

            ArrayNode tagsArray = null;
            if (tags != null)
                if (tags.size() > 0) {
                    tagsArray = tagsArray(tags);
                }

            ArrayNode featuresArray = null;
            if (features != null) {
                if (features.size() > 0) {
                    featuresArray = featuresArray(features);
                }
            }

            ObjectNode filterObject = ObjectMapperProvider.getObjectMapper().createObjectNode();
            if (!StringUtils.isEmpty(cityName))
                filterObject.put("cityName", cityName);
            if (pointObject != null)
                filterObject.put("point", pointObject);
            if (priceArrays != null)
                filterObject.put("prices", priceArrays);
            if (rateArrays != null)
                filterObject.put("rates", rateArrays);
            if (tagsArray != null)
                filterObject.put("tags", tagsArray);
            if (featuresArray != null)
                filterObject.put("features", featuresArray);

            return filterObject;
        } else return JacksonUtils.createEmptyObjectNode();
    }

    private ArrayNode priceArray(List<Integer> prices) {
        ArrayNode pricesArray = ObjectMapperProvider.getObjectMapper().createArrayNode();
        for (Integer price : prices) {
            pricesArray.add(price);
        }
        return pricesArray;
    }

    private ArrayNode rateArray(List<Integer> rates) {
        ArrayNode ratesArray = ObjectMapperProvider.getObjectMapper().createArrayNode();
        for (Integer rate : rates) {
            ratesArray.add(rate);
        }
        return ratesArray;
    }

    private ArrayNode featuresArray(List<String> features) {
        ArrayNode featuresArray = ObjectMapperProvider.getObjectMapper().createArrayNode();

        for (String feature : features) {
            featuresArray.add(feature);
        }
        return featuresArray;
    }

    private ArrayNode tagsArray(List<String> tags) {
        ArrayNode tagsArray = ObjectMapperProvider.getObjectMapper().createArrayNode();
        for (String tag : tags) {
            tagsArray.add(tag);
        }
        return tagsArray;
    }

    private JsonNode pointObject(ConfigPoint point) {
        long radius = point.getRadius();
        double x = point.getX();
        double y = point.getY();
        ObjectNode pointObject = ObjectMapperProvider.getObjectMapper().createObjectNode();
        pointObject.put("x", x);
        pointObject.put("y", y);
        pointObject.put("radius", radius);
        return pointObject;
    }

    private JsonNode sortObject(ConfigSort configSort) {
        if (configSort != null && configSort.getSort_order().size() > 0) {
            Map<String, Integer> sort_order = configSort.getSort_order();
            ObjectNode sortObject = ObjectMapperProvider.getObjectMapper().createObjectNode();
            for (String key : sort_order.keySet()) {
                Integer integer = sort_order.get(key);
                if (integer.equals(-1)) {
                    sortObject.put(key, "DSC");
                }
                if (integer.equals(1)) {
                    sortObject.put(key, "ASC");
                }
            }
            return sortObject;

        }
        return JacksonUtils.createEmptyObjectNode();
    }

}
