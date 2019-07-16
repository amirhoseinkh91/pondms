package ir.viratech.pond_ms.core.db.cli.four_square_json;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import ir.viratech.commons.util.jackson.JacksonUtils;
import ir.viratech.commons.util.jackson.ObjectMapperProvider;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MergeFourSquaresNewModelFiles {
    private static final String PROVINCES_RESULT_PATH = "/opt/PondMS/restaurants_json/province_result";
    private static final String MERGED_RESTAURANTS = "/opt/PondMS/restaurants_json/merged/";


    public static void main(String[] args) {
        try {
            List<String> venueId = new ArrayList<>();
            File provincesFile = new File(PROVINCES_RESULT_PATH);
            File resultPath = new File(MERGED_RESTAURANTS);
            if (!resultPath.exists()) {
                resultPath.mkdir();
            }
            File mergedFile = new File(resultPath, "merged.json");
            File[] provincesRestaurants = provincesFile.listFiles();
            ArrayNode convertOneRestaurantToListOfRestaurant = JacksonUtils.createEmptyArrayNode();
            if (provincesRestaurants != null && provincesRestaurants.length > 0) {
                for (File provinceRestaurant : provincesRestaurants) {
                    JsonNode citiesArray = ObjectMapperProvider.getObjectMapper().readTree(provinceRestaurant);
                    for (JsonNode cityJson : citiesArray) {
                        for (JsonNode restaurants : cityJson) {
                            String venueID = restaurants.get("VenueId").textValue();
                            if (venueId.contains(venueID)) {
                                continue;
                            }
                            venueId.add(venueID);
                            convertOneRestaurantToListOfRestaurant.add(restaurants);
                        }
                    }
                }
            }
            FileWriter writer = new FileWriter(mergedFile);
            writer.write(convertOneRestaurantToListOfRestaurant.toString());
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
