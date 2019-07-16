package ir.viratech.pond_ms.model.gis_vector_object_new_model;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import ir.viratech.commons.util.jackson.JacksonUtils;
import ir.viratech.commons.util.jackson.ObjectMapperProvider;
import ir.viratech.pond_ms.api.things_to_do.ThingsToDoTagsMapper;
import ir.viratech.pond_ms.model.layer.Layer;
import ir.viratech.pond_ms.model.layer.ParentLayer;
import ir.viratech.pond_ms.model.layer.logic.LayerMgr;
import org.json.JSONArray;

import java.util.ArrayList;
import java.util.Arrays;

public class GisVectorLayerToNewModel {


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
        switch (input.get("__type").asText()) {
            case "city":
                cityCollectionConvertToNewModel(input, newModel);
                newModel.put("type", "city");
                break;
            case "Things_To_Do":
                thingsToDoCollectionConvertToNewModel(input, newModel);
                newModel.put("type", "things-to-do");
                break;
            case "Hotel":
                hotelCollectionConvertToNewModel(input, newModel);
                newModel.put("type", "hotel");
                break;
            case "Restaurant":
                restaurantCollectionConvertToNewModel(input, newModel);
                newModel.put("type", "restaurant");
                break;
        }
        return newModel;
    }


    private static void cityCollectionConvertToNewModel(JsonNode input, ObjectNode newModel) {
        if (input.has("gis_object_uid")) {
            newModel.put("uid", input.get("gis_object_uid"));
        } else newModel.put("uid", "");

        if (input.has("name")) {
            newModel.put("title", input.get("name"));
        } else newModel.put("title", "");

        if (input.has("hotel_count")) {
            newModel.put("hotel_count", input.get("hotel_count"));
        } else newModel.put("hotel_count", "");

        if (input.has("things_to_do_count")) {
            newModel.put("things_to_do_count", input.get("things_to_do_count").asInt());
        } else newModel.put("hotel_count", "");

        if (input.has("Rate")) {
            newModel.put("rate", input.get("Rate"));
        } else newModel.put("rate", " ");

        if (input.has("Description")) {
            newModel.put("description", input.get("Description"));
        } else newModel.put("description", "");

        if (input.has("point")) {
            newModel.put("point", input.get("point"));
        } else newModel.put("point", "");

        if (input.has("tags")) {
            newModel.put("tags", input.get("tags"));
        } else newModel.put("tags", JacksonUtils.createEmptyArrayNode());

        if (input.has("Images")) {
            if (input.get("Images").size() > 0) {
                newModel.put("images", input.get("Images"));
            }
        } else newModel.put("images", JacksonUtils.createEmptyArrayNode());

        if (input.has("layer_uid")) {
            String layer_uid = input.get("layer_uid").asText();
            province(layer_uid, newModel);
        }

        if (input.has("NearBy")) {
            nearByCollectionMapper(input, newModel);
        }
    }

    private static void thingsToDoCollectionConvertToNewModel(JsonNode input, ObjectNode newModel) {
        if (input.has("gis_object_uid")) {
            newModel.put("uid", input.get("gis_object_uid").asText());
        } else newModel.put("uid", "");

        if (input.has("name")) {
            newModel.put("title", input.get("name").asText());
        } else newModel.put("title", "");

        if (input.has("Rate")) {
            newModel.put("rate", input.get("Rate").asInt());
        } else newModel.put("rate", "");

        if (input.has("Tags")) {
            tagNewModelForAllCollections(input, newModel);
        } else newModel.put("tags", JacksonUtils.createEmptyArrayNode());

        if (input.has("Description")) {
            newModel.put("description", input.get("Description"));
        } else newModel.put("description", "");

        if (input.has("Images")) {
            if (input.get("Images").size() > 0) {
                newModel.put("images", input.get("Images"));
            }
        } else newModel.put("images", JacksonUtils.createEmptyArrayNode());

        if (input.has("Website")) {
            newModel.put("website", input.get("Website"));
        } else newModel.put("website", "");

        if (input.has("Address")) {
            newModel.put("address", input.get("Address"));
        } else newModel.put("address", "");

        if (input.has("TelephoneNum")) {
            newModel.put("telephoneNum", input.get("TelephoneNum"));
        } else newModel.put("telephoneNum", "");

        if (input.has("point")) {
            newModel.put("point", input.get("point"));
        } else newModel.put("point", "");

        if (input.has("layer_uid")) {
            String layer_uid = input.get("layer_uid").asText();
            city(layer_uid, newModel);
            province(layer_uid, newModel);
        }

        if (input.has("NearBy")) {
            nearByCollectionMapper(input, newModel);
        }

    }

    private static void hotelCollectionConvertToNewModel(JsonNode input, ObjectNode newModel) {
        if (input.has("gis_object_uid")) {
            newModel.put("uid", input.get("gis_object_uid").asText());
        } else newModel.put("uid", "");

        if (input.has("name")) {
            newModel.put("title", input.get("name").asText());
        } else newModel.put("title", "");

        if (input.has("Rate")) {
            newModel.put("rate", input.get("Rate").asInt());
        } else newModel.put("rate", "");

        if (input.has("Features")) {
            ArrayNode featuresNode = ObjectMapperProvider.getObjectMapper().createArrayNode();
            ArrayList<String> featuresList = new ArrayList<>(Arrays.asList(input.get("Features").asText().trim().replaceAll("\\n", "").replaceAll("\n", "").split("،")));
            for (String feature : featuresList) {
                featuresNode.add(feature.trim());
            }
            newModel.put("facilities", featuresNode);
        } else newModel.put("facilities", JacksonUtils.createEmptyArrayNode());

        if (input.has("Tags")) {
            tagNewModelForAllCollections(input, newModel);
        } else newModel.put("tags", JacksonUtils.createEmptyArrayNode());

        if (input.has("Description")) {
            newModel.put("description", input.get("Description"));
        } else newModel.put("description", "");

        if (input.has("Images")) {
            if (input.get("Images").size() > 0) {
                newModel.put("images", input.get("Images"));
            }
        } else newModel.put("images", JacksonUtils.createEmptyArrayNode());

        if (input.has("Website")) {
            newModel.put("website", input.get("Website"));
        } else newModel.put("website", " ");

        if (input.has("Address")) {
            newModel.put("address", input.get("Address"));
        } else newModel.put("address", "");

        if (input.has("TelephoneNum")) {
            newModel.put("telephoneNum", input.get("TelephoneNum"));
        } else newModel.put("telephoneNum", "");

        if (input.has("point")) {
            newModel.put("point", input.get("point"));
        } else newModel.put("point", "");

        if (input.has("layer_uid")) {
            String layer_uid = input.get("layer_uid").asText();
            city(layer_uid, newModel);
            province(layer_uid, newModel);
        }
    }

    private static void restaurantCollectionConvertToNewModel(JsonNode input, ObjectNode newModel) {
        if (input.has("gis_object_uid")) {
            newModel.put("uid", input.get("gis_object_uid").asText());
        } else newModel.put("uid", " ");

        if (input.has("name")) {
            newModel.put("title", input.get("name").asText());
        } else newModel.put("title", " ");

        if (input.has("Rate")) {
            newModel.put("rate", input.get("Rate").asInt());
        } else newModel.put("rate", " ");

        if (input.has("Tags")) {
            tagNewModelForAllCollections(input, newModel);
        } else newModel.put("tags", JacksonUtils.createEmptyArrayNode());

        if (input.has("Description")) {
            newModel.put("description", input.get("Description"));
        } else newModel.put("description", " ");

        if (input.has("Images")) {
            newModel.put("images", input.get("Images"));
        } else newModel.put("images", JacksonUtils.createEmptyArrayNode());

        if (input.has("Website")) {
            newModel.put("website", input.get("Website"));
        } else newModel.put("website", " ");

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

        if (input.has("layer_uid")) {
            String layer_uid = input.get("layer_uid").asText();
            city(layer_uid, newModel);
            province(layer_uid, newModel);
        }

        if (input.has("NearBy")) {
            nearByCollectionMapper(input, newModel);
        }
    }

    private static void tagNewModelForAllCollections(JsonNode input, ObjectNode newModel) {
        try {
            ArrayNode tagsNode = ObjectMapperProvider.getObjectMapper().createArrayNode();
            if (input.has("Tags") && input.get("Tags") != null){
                ArrayList tagsArray = new ObjectMapper().convertValue(input.get("Tags"), ArrayList.class);
                if (tagsArray != null && tagsArray.size() > 0) {
                    switch (input.get("__type").asText()) {
                        case "Things_To_Do":
                            for (Object aTagsArray : tagsArray) {
                                tagsNode.add(new ThingsToDoTagsMapper().getTagName(String.valueOf(aTagsArray)));
                            }
                            break;
                        default:
                            for (Object aTagsArray : tagsArray) {
                                tagsNode.add(String.valueOf(aTagsArray));
                            }
                            break;
                    }
                }
            }
            newModel.put("tags", tagsNode);
        }catch (Exception e){
            e.printStackTrace();
        }
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
