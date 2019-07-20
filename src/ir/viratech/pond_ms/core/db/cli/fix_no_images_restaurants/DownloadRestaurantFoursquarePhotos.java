package ir.viratech.pond_ms.core.db.cli.fix_no_images_restaurants;

import com.fasterxml.jackson.databind.JsonNode;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import ir.viratech.commons.cm.model.entity_instance.dao.EntityInstanceDAO;
import ir.viratech.commons.cm.model.entity_type.logic.EntityTypeMgr;
import ir.viratech.commons.persistence.mongo.base.MongoDBManager;
import ir.viratech.pond_ms.core.spring.ApplicationContextUtil;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("Duplicates")
public class DownloadRestaurantFoursquarePhotos {

    private static String restaurantsPath = "/opt/PondMS/Restaurant/";


    public static void main(String[] args) {
        ApplicationContextUtil.initializeCliApplicationContext();
        try {
            List<String> uidList = getNoImageRestaurantUids();
            DBCollection collection = EntityInstanceDAO.getInstance().getCollection(EntityTypeMgr.getInstance().getByKey("Restaurant"));
            DBCursor dbObjects = collection.find();
            int allRestaurantsCount = dbObjects.size();
            char[] animationChars = new char[]{'|', '/', '-', '\\'};
            int i = 0;

            System.out.println("restaurants without images count: " + uidList.size());

            for (DBObject node : dbObjects) {
                String gis_object_uid = MongoDBManager.getInstance().convertToObjectNode(node).get("gis_object_uid").asText();
                if (uidList.contains(gis_object_uid)) {
                    File file = new File(restaurantsPath + node.get("gis_object_uid"));
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    JsonNode foursquarePhotos = MongoDBManager.getInstance().convertToObjectNode(node).get("FoursquarePhotos");
                    if (foursquarePhotos.size() > 0) {
                        int imageCounter = 1;
                        for (JsonNode imageNode : foursquarePhotos) {
                            try {
                                String imageURL = imageNode.asText();
                                downloadImage(file, imageCounter, imageURL);
                                imageCounter++;
                            } catch (Exception ignored) {
                            }
                        }
                    }
                    int percentage = i * 100 / allRestaurantsCount;
                    System.out.print("Processing: " + percentage + "% " + animationChars[i % 4] + "\r");
                }
                i++;
            }
            System.out.println("Processing: Done!          ");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void downloadImage(File file, int imageCounter, String imageURL) {
        try {
            InputStream in = new URL(imageURL).openStream();
            String absolutePath = file.getAbsolutePath();
            FileOutputStream outputStream = new FileOutputStream(absolutePath + "/" + imageCounter + ".jpg");
            OutputStream out = new BufferedOutputStream(outputStream);
            for (int i; (i = in.read()) != -1; ) {
                out.write(i);
            }
            in.close();
            out.close();
        } catch (Exception ignored) {
        }
    }

    private static List<String> getNoImageRestaurantUids() {

        List<String> res = new ArrayList<>();

        try {
            ImageDataChecker imageDataChecker = new ImageDataChecker();
            imageDataChecker.init();
            for (ImageDataChecker.NoImageItemResult item : imageDataChecker.data) {
                if (item.getGisObjectType().equalsIgnoreCase("restaurant")) {
                    List<String> downloadedUids = Arrays.asList(new File(restaurantsPath).list());
                    if (!downloadedUids.contains(item.getGisVectorObjectUid())) {
                        res.add(item.getGisVectorObjectUid());
                    }
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return res;
    }

}
