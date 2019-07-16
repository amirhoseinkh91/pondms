package ir.viratech.pond_ms.core.db.cli.images;

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
import java.util.List;

@SuppressWarnings("Duplicates")
public class RestaurantDownloadImagesTask {
    private static File restaurantsId = new File("/opt/PondMS/restaurantsId.txt");
    private static String restaurantsPath = restaurantsId.getAbsolutePath();

    public static void main(String[] args) {
        ApplicationContextUtil.initializeCliApplicationContext();
        try {
            FileWriter fileWriter = new FileWriter(restaurantsPath, true);
            List<String> saveList = restaurantsIdList(restaurantsId);
            DBCollection collection = EntityInstanceDAO.getInstance().getCollection(EntityTypeMgr.getInstance().getByKey("Restaurant"));
            DBCursor dbObjects = collection.find();
            int allRestaurantsCount = dbObjects.size();
            char[] animationChars = new char[]{'|', '/', '-', '\\'};
            int i = 0;
            for (DBObject node : dbObjects) {
                String gis_object_uid = MongoDBManager.getInstance().convertToObjectNode(node).get("gis_object_uid").asText();
                if (saveList.contains(gis_object_uid)) {
                    i++;
                    continue;
                }
                fileWriter.write(gis_object_uid + "\n");
                fileWriter.flush();
                File file = new File("/opt/PondMS/Restaurant/" + node.get("gis_object_uid"));
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

    private static List<String> restaurantsIdList(File file) {
        String path = file.getAbsolutePath();
        String line;
        List<String> restaurantsId = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(path);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while (null != (line = bufferedReader.readLine())) {
                restaurantsId.add(line);
            }
            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" + path + "'");
        } catch (IOException ex) {
            System.out.println("Error reading file\t" + path);

        } catch (NumberFormatException e) {
            System.out.println("format number");
        }
        return restaurantsId;
    }

}
