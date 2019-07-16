package ir.viratech.pond_ms.core.db.cli;

import com.fasterxml.jackson.databind.JsonNode;
import ir.viratech.commons.persistence.mongo.base.MongoDBManager;
import ir.viratech.pond_ms.api.filter.BaseMongoQueries;
import ir.viratech.pond_ms.core.spring.ApplicationContextUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CreatePointIndexForGisVectorObjects extends BaseMongoQueries {

    public static void main(String[] args) {
        ApplicationContextUtil.initializeCliApplicationContext();
        CreatePointIndexForGisVectorObjects createPointIndexForGisVectorObjects = new CreatePointIndexForGisVectorObjects();
        createPointIndexForGisVectorObjects.create();
    }

    private static final String COLLECTION_HOTEL = "hotel_col";
    private static final String COLLECTION_THINGS_TO_DO = "things_to_do_col";
    private static final String COLLECTION_RESTAURANT = "restaurant_col";

    private void create() {
        MongoDBManager mgr = MongoDBManager.getInstance();
        try {
            JsonNode jsonNode = mgr.executeQuery("db.getCollectionNames()");
            System.out.println("collections\t######\t" + jsonNode + "\n\n");
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<String> collections = new ArrayList<>();
        collections.add(COLLECTION_HOTEL);
        collections.add(COLLECTION_RESTAURANT);
        collections.add(COLLECTION_THINGS_TO_DO);
        for (String collection : collections) {
            String point = makeQuery(create_index("point", "2dsphere"), collection);
            System.out.println("point query\t####\t " + point);
            try {
                JsonNode jsonNode = mgr.executeQuery(point);
                System.out.println(jsonNode.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
