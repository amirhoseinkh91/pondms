package ir.viratech.pond_ms.core.db.cli.four_square_json;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import ir.viratech.commons.util.jackson.JacksonUtils;
import ir.viratech.commons.util.jackson.ObjectMapperProvider;
import ir.viratech.pond_ms.model.gis_vector_object_new_model.GisVectorLayerToNewModelV2;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class convertRestaurantsJsonToNewModel {
    private static final String RESTAURANTS_CITY_PATH = "/opt/PondMS/restaurants_json/provinces";
    private static final String RESTAURANTS_RESULT_PATH = "/opt/PondMS/restaurants_json/province_result";

    public static void main(String[] args) {
        try {
            ArrayNode allRestaurants = JacksonUtils.createEmptyArrayNode();
            List<String> venueId = new ArrayList<>();
            File provincesDir = new File(RESTAURANTS_CITY_PATH);
            File resultPath = new File(RESTAURANTS_RESULT_PATH);
            File[] provinces = provincesDir.listFiles();
            if (provinces != null) {
                for (File province : provinces) {
                    String provinceName = FilenameUtils.getName(province.getAbsolutePath());
                    File mergedFile = new File(resultPath, "Meta_" + provinceName + ".json");
                    ArrayNode provinceJson = JacksonUtils.createEmptyArrayNode();
                    File[] cities = province.listFiles();
                    for (File city : cities) {
                        if (!city.isDirectory()) {
                            continue;
                        }
                        String cityName = FilenameUtils.getName(city.getAbsolutePath());
                        if (Files.notExists(resultPath.toPath())) {
                            resultPath.mkdir();
                        }
                        File[] listRestaurants = city.listFiles();
                        ArrayNode convertOneRestaurantToListOfRestaurant = JacksonUtils.createEmptyArrayNode();
                        if (listRestaurants != null && listRestaurants.length > 0) {
                            for (File restaurant : listRestaurants) {
                                JsonNode restaurantData = ObjectMapperProvider.getObjectMapper().readTree(restaurant);
                                convertOneRestaurantToListOfRestaurant.add(restaurantData);
                            }
                        }
                        for (JsonNode restaurant : convertOneRestaurantToListOfRestaurant) {
                            mapRestaurant(restaurant, allRestaurants, venueId, cityName, provinceName);
                        }
                        provinceJson.add(GisVectorLayerToNewModelV2.mapperToNewModel(allRestaurants));

                    }
                    FileWriter writer = new FileWriter(mergedFile);
                    writer.write(provinceJson.toString());
                    writer.flush();
                    writer.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void mapRestaurant(JsonNode restaurantData, ArrayNode allRestaurants, List<String> venueID, String cityName, String provinceName) {
        if (restaurantData.has("response")) {
            JsonNode response = restaurantData.get("response");
            if (response.has("group")) {
                JsonNode group = response.get("group");
                if (group.has("results")) {
                    JsonNode results = group.get("results");
                    for (JsonNode result : results) {
                        ObjectNode restaurantNode = JacksonUtils.createEmptyObjectNode();
                        if (!result.get("displayType").asText().equals("venue")) {
                            continue;
                        }
                        JsonNode venue = result.get("venue");
                        String id = venue.get("id").textValue();
                        if (venueID.contains(id)) {
                            continue;
                        }
                        venueID.add(id);
                        restaurantNode.put("VenueId", id);
                        restaurantNode.put("name", mapName(venue));
                        restaurantNode.put("Rate", mapRate(venue));
                        restaurantNode.put("Tags", mapTag(venue));
                        restaurantNode.put("Price", mapPrice(venue));
                        restaurantNode.put("point", mapPoint(venue));
                        restaurantNode.put("Address", mapAddress(venue));
                        restaurantNode.put("city", "شهر" + " " + cityName);
                        restaurantNode.put("province", "استان" + " " + provinceName);
                        //restaurantNode.put("city", mapCity(venue));
                        //restaurantNode.put("province", mapProvince(venue));
                        restaurantNode.put("FoursquarePhotos", mapPhoto(result));
                        restaurantNode.put("__type", "Restaurant");
                        allRestaurants.add(restaurantNode);
                    }
                }
            }
        }
    }


    private static ArrayNode mapPhoto(JsonNode result) {
        ArrayNode photoArray = JacksonUtils.createEmptyArrayNode();
        if (result.has("photo")) {
            String urlImage = "";
            JsonNode photo = result.get("photo");
            if (photo.has("prefix")) {
                urlImage += photo.get("prefix").asText();
            }
            if (photo.has("width")) {
                urlImage += photo.get("width").asText();
            }
            if (photo.has("height")) {
                urlImage += photo.get("height").asText();
            }
            if (photo.has("suffix")) {
                urlImage += photo.get("suffix").asText();
            }
            photoArray.add(urlImage);
        }
        return photoArray;
    }

    private static String mapTag(JsonNode venue) {
        if (venue.has("categories")) {
            StringBuilder tags = new StringBuilder();
            JsonNode categories = venue.get("categories");
            for (JsonNode category : categories) {
                tags.append(category.get("name").toString());
            }
            return tags.toString();
        }
        return "";
    }

    private static ObjectNode mapPoint(JsonNode venue) {
        if (venue.has("location")) {
            ObjectNode point = JacksonUtils.createEmptyObjectNode();
            ArrayNode coordinates = JacksonUtils.createEmptyArrayNode();

            if (venue.get("location").has("lng")) {
                coordinates.add(venue.get("location").get("lng").asDouble());
            }
            if (venue.get("location").has("lng")) {
                coordinates.add(venue.get("location").get("lat").asDouble());
            }
            point.put("type", "Point");
            point.put("coordinates", coordinates);
            return point;
        }
        return JacksonUtils.createEmptyObjectNode();
    }

    private static String mapCity(JsonNode venue) {
        if (venue.has("location")) {
            if (venue.get("location").has("city")) {
                return venue.get("location").get("city").textValue();
            }
        }
        return "";
    }

    private static String mapProvince(JsonNode venue) {
        if (venue.has("location")) {
            if (venue.get("location").has("state")) {
                return venue.get("location").get("state").asText().replaceAll("Province", "");
            }
        }
        return "";
    }

    private static String mapAddress(JsonNode venue) {
        StringBuilder address = new StringBuilder();
        if (venue.has("location")) {
            if (venue.get("location").has("address")) {
                address.append(venue.get("location").get("address").textValue());
            }
            if (venue.get("location").has("crossStreet")) {
                address.append(venue.get("location").get("crossStreet").textValue());
            }
            return address.toString();
        }
        return "";
    }

    private static int mapPrice(JsonNode venue) {
        if (venue.has("price")) {
            if (venue.get("price").has("tier")) {
                return venue.get("price").get("tier").asInt();
            }
        }
        return 0;
    }

    private static double mapRate(JsonNode venue) {
        if (venue.has("rating")) {
            return venue.get("rating").asDouble();
        }
        return 0.0;
    }

    private static JsonNode mapName(JsonNode venue) {
        if (venue.has("name")) {
            return venue.get("name");
        }
        return JacksonUtils.createEmptyObjectNode();
    }
}