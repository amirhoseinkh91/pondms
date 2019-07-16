package ir.viratech.pond_ms.model.gis_vector_object_new_model;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import ir.viratech.commons.util.jackson.JacksonUtils;
import ir.viratech.commons.util.jackson.ObjectMapperProvider;
import ir.viratech.pond_ms.model.layer.Layer;
import ir.viratech.pond_ms.model.layer.ParentLayer;
import ir.viratech.pond_ms.model.layer.logic.LayerMgr;

import java.util.ArrayList;
import java.util.Arrays;

@SuppressWarnings("all")
public class GisVectorLayerToNewModelV2 {
    public static JsonNode mapperToNewModel(JsonNode input) {
        ArrayNode arrayMapper = ObjectMapperProvider.getObjectMapper().createArrayNode();
        if (input.isArray()) {
            for (JsonNode node : input) {
                ObjectNode mapper = mapper(node);
                arrayMapper.add(mapper);
            }
        } else return mapper(input);
        return arrayMapper;
    }

    private static ObjectNode mapper(JsonNode input) {
        ObjectNode newModel = ObjectMapperProvider.getObjectMapper().createObjectNode();
        restaurantCollectionConvertToNewModel(input, newModel);
        newModel.put("type", "restaurant");
        return newModel;
    }

    private static void restaurantCollectionConvertToNewModel(JsonNode input, ObjectNode newModel) {
        if (input.has("VenueId")) {
            newModel.put("VenueId", input.get("VenueId"));
        } else newModel.put("VenueId", "");

        if (input.has("name")) {
            newModel.put("title", input.get("name").asText());
        } else newModel.put("title", " ");

        if (input.has("Rate")) {
            newModel.put("rate", input.get("Rate").asDouble());
        } else newModel.put("rate", " ");

        if (input.has("Tags")) {
            tagNewModelForAllCollections(input, newModel);
        } else newModel.put("tags", JacksonUtils.createEmptyArrayNode());

        if (input.has("FoursquarePhotos")) {
            newModel.put("FoursquarePhotos", input.get("FoursquarePhotos"));
        } else newModel.put("FoursquarePhotos", JacksonUtils.createEmptyArrayNode());

        if (input.has("Address")) {
            newModel.put("address", input.get("Address"));
        } else newModel.put("address", "");

        if (input.has("TelephoneNum")) {
            newModel.put("telephoneNum", input.get("TelephoneNum"));
        } else newModel.put("telephoneNum", "");

        if (input.has("point")) {
            newModel.put("point", input.get("point"));
        } else newModel.put("point", "");

        if (input.has("Price")) {
            newModel.put("price", input.get("Price"));
        }

        if (input.has("city")) {
            newModel.put("city", input.get("city").textValue());
        }

        if (input.has("province")) {
            newModel.put("province", input.get("province"));
        }

        if (input.has("NearBy")) {
            nearByCollectionMapper(input, newModel);
        }

    }

    private static void tagNewModelForAllCollections(JsonNode input, ObjectNode newModel) {
        ArrayNode tagsNode = ObjectMapperProvider.getObjectMapper().createArrayNode();
        String tags = input.get("Tags").asText();
        ArrayList<String> tagsList = new ArrayList<>(Arrays.asList(tags.trim().split(",")));
        for (String tag : tagsList) {
            tagsNode.add(tag.replaceAll("\"", ""));
        }
        newModel.put("tags", tagsNode);
    }

    private static void nearByCollectionMapper(JsonNode input, ObjectNode newModel) {
        ObjectNode basicNode = ObjectMapperProvider.getObjectMapper().createObjectNode();
        if (input.get("NearBy").has("things-to-do")) {
            JsonNode thingsArray = input.get("NearBy").get("things-to-do");
            nearBy(newModel, basicNode, thingsArray, "Things-To-Do");
        }
        if (input.get("NearBy").has("hotel")) {
            JsonNode thingsArray = input.get("NearBy").get("hotel");
            nearBy(newModel, basicNode, thingsArray, "Hotel");
        }
        if (input.get("NearBy").has("restaurant")) {
            JsonNode thingsArray = input.get("NearBy").get("restaurant");
            nearBy(newModel, basicNode, thingsArray, "Restaurant");
        }
    }

    private static void nearBy(ObjectNode newModel, ObjectNode basicNode, JsonNode thingsArray, String collectionName) {
        ArrayNode basicArrayNode = ObjectMapperProvider.getObjectMapper().createArrayNode();
        for (JsonNode node : thingsArray) {
            basicArrayNode.add(mapper(node));
        }
        basicNode.put(collectionName, basicArrayNode);
        newModel.put("nearbies", basicNode);
    }

    private static void city(String uid, ObjectNode newModel) {
        Layer subLayer = LayerMgr.getInstance().getByExtuid(uid);
        ParentLayer parentLayer = subLayer.getParentLayer();
        String name = parentLayer.getName();
        newModel.put("city", name);
    }

    private static void province(String uid, ObjectNode newModel) {
        Layer subLayer = LayerMgr.getInstance().getByExtuid(uid);
        ParentLayer parentLayer = subLayer.getParentLayer();
        while (parentLayer.getParentLayer() != null) {
            parentLayer = parentLayer.getParentLayer();
        }
        String name = parentLayer.getName();
        newModel.put("province", name);
    }
}
