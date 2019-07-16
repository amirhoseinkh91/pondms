package ir.viratech.pond_ms.model.main_city_config;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import ir.viratech.commons.util.jackson.JacksonUtils;
import ir.viratech.commons.util.jackson.ObjectMapperProvider;
import ir.viratech.pond_ms.api.filter.BaseMongoQueries;
import ir.viratech.pond_ms.core.i18n.MessageService;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

public class MainPageCityDetail extends BaseMongoQueries {

    public JsonNode cityDetail(String cityName) {
        try {
            ObjectNode cityDetails = ObjectMapperProvider.getObjectMapper().createObjectNode();
            if (!StringUtils.isEmpty(cityName)) {
                if (!cityName.startsWith(MessageService.getMessage("city.space"))) {
                    String trim = cityName.trim();
                    cityName = trim.replaceAll("\"", "");
                    cityName = MessageService.getMessage("city.space") + cityName;
                }
                Map<String, String> city = ChildCityConfig.getCity(cityName, "");
                if (city.size() > 0) {
                    String layerValue = city.get(MessageService.getMessage("config.city"));
                    String layer_uid = makeQuery(find(equals("layer_uid", layerValue)), collectionMapper("city"));
                    if (!StringUtils.isEmpty(layer_uid)) {
                        layer_uid = layer_uid.concat(DOT).concat(toArray());
                    }
                    JsonNode node = getMongoDBManager().executeQuery(layer_uid);
                    cityDetails.put("cityDetail", node);
                }
            }
            return cityDetails;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JacksonUtils.createEmptyObjectNode();
    }
}
