package ir.viratech.pond_ms.core.db.cli.fix_no_images_restaurants;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import ir.viratech.commons.file.model.AbstractFile;
import ir.viratech.commons.file.model.logic.AbstractFileMgr;
import ir.viratech.commons.persistence.mongo.base.MongoDBManager;
import ir.viratech.commons.spring.context.ApplicationContextProvider;
import ir.viratech.pond_ms.core.spring.ApplicationContextUtil;
import org.apache.commons.collections.CollectionUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class NoImageRestaurantFinder {

    private MongoDBManager mongoDBManager = (MongoDBManager) ApplicationContextProvider.getInitializedApplicationContext().getBean("mongoDBManager");
    private File file = new File("/home/tikbed40/Desktop/data.json");

    private List<NoImageItemResult> results = new ArrayList<>();

    private static Logger logger = Logger.getLogger(NoImageRestaurantFinder.class.getName());

    public static void main(String[] args) {
        ApplicationContextUtil.initializeCliApplicationContext();

        try {
            NoImageRestaurantFinder finder = new NoImageRestaurantFinder();
            finder.findNoImageRestaurants();

            finder.writeToFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeToFile() throws IOException {
        Writer writer = new BufferedWriter(new FileWriter(file));
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        gson.toJson(new FinalResult(results), writer);
        writer.flush();
    }

    private void findNoImageRestaurants() throws IOException {


        String[] collectionNames = {"restaurant_col", "hotel_col", "things_to_do_col"};

        long objCounter = 0;

        for (String collection : collectionNames) {


            String objType;

            switch (collection) {

                case "restaurant_col":
                    objType = "RESTAURANT";
                    break;
                case "hotel_col":
                    objType = "HOTEL";
                    break;
                case "things_to_do_col":
                    objType = "THINGS_TO_DO";
                    break;
                default:
                    objType = "UNKNOWN";
            }
            if (collection.equalsIgnoreCase("restaurant_col"))
                objType = "RESTAURANT";


            DBCursor restaurants = mongoDBManager.getCollection(collection).find();


            for (DBObject item : restaurants) {

                String objUid = (String) item.get("gis_object_uid");

                logger.info("item #" + (++objCounter) + "\ttype: " + objType + "\tobjUID: " + objUid);


                List<String> imagesHashes = (List<String>) item.get("Images");
                List<String> nullHashes = new ArrayList<>();


                if (imagesHashes != null) {
                    for (int i = 0; i < imagesHashes.size(); i++) {
                        String hash = imagesHashes.get(i);
                        AbstractFile file = AbstractFileMgr.getInstance().getByHashCodeString(hash);
                        if (file == null) {
                            nullHashes.add(hash);
                        }
                    }

                    if (!CollectionUtils.isEmpty(nullHashes)) {
                        results.add(new NoImageItemResult(objUid, nullHashes, objType));
                    }
                }

            }

        }
    }

    private static class NoImageItemResult {


        @SerializedName("objectUid")
        private String gisVectorObjectUid;

        @SerializedName("nullHashes")
        private List<String> nullHashes;

        @SerializedName("objectType")
        private String gisObjectType;

        private NoImageItemResult(String gisVectorObjectUid, List<String> nullHashes, String gisObjectType) {
            this.gisVectorObjectUid = gisVectorObjectUid;
            this.nullHashes = nullHashes;
            this.gisObjectType = gisObjectType;
        }

        public String getGisVectorObjectUid() {
            return gisVectorObjectUid;
        }

        public void setGisVectorObjectUid(String gisVectorObjectUid) {
            this.gisVectorObjectUid = gisVectorObjectUid;
        }

        public List<String> getNullHashes() {
            return nullHashes;
        }

        public void setNullHashes(List<String> nullHashes) {
            this.nullHashes = nullHashes;
        }

        public String getGisObjectType() {
            return gisObjectType;
        }

        public void setGisObjectType(String gisObjectType) {
            this.gisObjectType = gisObjectType;
        }
    }

    private static class FinalResult {

        @SerializedName("count")
        private int itemsCount;

        @SerializedName("items")
        private List<NoImageItemResult> results;

        private FinalResult(List<NoImageItemResult> results) {
            this.results = results;
            this.itemsCount = results.size();
        }

        public List<NoImageItemResult> getResults() {
            return results;
        }

        public void setResults(List<NoImageItemResult> results) {
            this.results = results;
        }

        public int getItemsCount() {
            return itemsCount;
        }

        public void setItemsCount(int itemsCount) {
            this.itemsCount = itemsCount;
        }
    }

}
