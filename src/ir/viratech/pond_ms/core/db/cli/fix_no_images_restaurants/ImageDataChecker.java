package ir.viratech.pond_ms.core.db.cli.fix_no_images_restaurants;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import ir.viratech.commons.file.model.AbstractFile;
import ir.viratech.commons.file.model.logic.AbstractFileMgr;
import ir.viratech.commons.persistence.mongo.base.MongoDBManager;
import ir.viratech.commons.spring.context.ApplicationContextProvider;
import ir.viratech.pond_ms.core.spring.ApplicationContextUtil;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class ImageDataChecker {

    private static Logger logger = Logger.getLogger(NoImageRestaurantFinder.class.getName());


    public File dataFile;

    public List<NoImageItemResult> data;

    private MongoDBManager mongoDBManager = (MongoDBManager) ApplicationContextProvider.getInitializedApplicationContext().getBean("mongoDBManager");

    public static void main(String[] args) throws FileNotFoundException {

        ApplicationContextUtil.initializeCliApplicationContext();
        new ImageDataChecker().start();
    }

    private void start() throws FileNotFoundException {
        loadFile();
        loadDataFromFile();
        checkCrashedData();
    }

    private void checkCrashedData() {

        for (NoImageItemResult item : data) {

            String collectionName;
            String objectType = item.getGisObjectType();


            switch (objectType) {
                case "RESTAURANT":
                    collectionName = "restaurant_col";
                    break;
                /*case "HOTEL":
                    collectionName = "hotel_col";
                    break;
                case "THINGS_TO_DO":
                    collectionName = "things_to_do_col";
                    break;*/
                default:
                    continue;
            }
            String objectUid = item.getGisVectorObjectUid();

            DBObject query = new BasicDBObject("gis_object_uid", objectUid);
            DBCursor foundItems = mongoDBManager.getCollection(collectionName).find(query);

            for (DBObject var : foundItems) {

                System.out.println("item type: " + objectType + "\tobjUID: " + objectUid + "");


                List<String> imagesHashes = (List<String>) var.get("Images");



            }


        }

    }

    public void init() throws FileNotFoundException {
        loadFile();
        loadDataFromFile();
    }

    private void loadFile() {

        dataFile = new File("/opt/PondMS/data.json");

    }

    private void loadDataFromFile() throws FileNotFoundException {

        FinalResult finalResult = new Gson().fromJson(new FileReader(dataFile), FinalResult.class);
        this.data = finalResult.results;

    }

    static class NoImageItemResult {


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
        private List<ImageDataChecker.NoImageItemResult> results;

        private FinalResult(List<ImageDataChecker.NoImageItemResult> results) {
            this.results = results;
            this.itemsCount = results.size();
        }

        public List<ImageDataChecker.NoImageItemResult> getResults() {
            return results;
        }

        public void setResults(List<ImageDataChecker.NoImageItemResult> results) {
            this.results = results;
        }

        public int getItemsCount() {
            return itemsCount;
        }

        public void setItemsCount(int itemsCount) {
            this.itemsCount = itemsCount;
        }
    }

    private static class NoImageItemResultWithFoursquarePhotos {

        @SerializedName("objectUid")
        private String gisVectorObjectUid;

        @SerializedName("nullHashes")
        private List<String> nullHashes;

        @SerializedName("objectType")
        private String gisObjectType;

        @SerializedName("fsPhotos")
        private List<String> fsPhotos;


    }

}
