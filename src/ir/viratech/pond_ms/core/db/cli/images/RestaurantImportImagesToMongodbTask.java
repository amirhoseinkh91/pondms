package ir.viratech.pond_ms.core.db.cli.images;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import ir.viratech.commons.cm.model.entity_instance.dao.EntityInstanceDAO;
import ir.viratech.commons.cm.model.entity_type.logic.EntityTypeMgr;
import ir.viratech.commons.file.cli.FileCli;
import ir.viratech.commons.file.model.AbstractFile;
import ir.viratech.pond_ms.core.spring.ApplicationContextUtil;
import org.apache.commons.io.FilenameUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RestaurantImportImagesToMongodbTask {
    private static File restaurantsUpdated = new File("/opt/PondMS/restaurants_updated.txt");
    private static String restaurantsPath = restaurantsUpdated.getAbsolutePath();

    public static void main(String[] args) {
        ApplicationContextUtil.initializeCliApplicationContext();
        try {
            FileWriter fileWriter = new FileWriter(restaurantsPath, true);
            List<String> saveList = restaurantsIdList(restaurantsUpdated);
            RestaurantImportImagesToMongodbTask mongodbTask = new RestaurantImportImagesToMongodbTask();
            DBCollection collection = EntityInstanceDAO.getInstance().getCollection(EntityTypeMgr.getInstance().getByKey("Restaurant"));
            File downloadedImagesPath = new File("/opt/PondMS/Restaurant");
            File[] restaurantsFolders = downloadedImagesPath.listFiles();
            if (restaurantsFolders != null) {
                int allRestaurants = restaurantsFolders.length;
                int i = 1;
                for (File restaurantFolder : restaurantsFolders) {
                    String fileName = FilenameUtils.getBaseName(restaurantFolder.getAbsolutePath());
                    if (saveList.contains(fileName)) {
                        i++;
                        continue;
                    }
                    fileWriter.write(fileName + "\n");
                    fileWriter.flush();
                    DBObject node = collection.findOne(new BasicDBObject("gis_object_uid", fileName));
                    if (node == null) {
                        continue;
                    }
                    BasicDBList imagesArray = (BasicDBList) node.get("Images");
                    File[] images = restaurantFolder.listFiles();
                    if (images != null) {
                        for (File image : images) {
                            String hashCode = mongodbTask.convertToHashCode(image);
                            imagesArray.add(hashCode);
                        }
                        mongodbTask.updateMongo(collection, node);
                    }
                    System.out.println(i + "\tRestaurant is updated from\t" + allRestaurants);
                    i++;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String convertToHashCode(File image) throws IOException {
        String imageName = FilenameUtils.getName(image.getAbsolutePath());
        AbstractFile imageAbstractFile = FileCli.addFile("image/jpg", imageName, image);
        return imageAbstractFile.getHashCodeString();
    }

    private void updateMongo(DBCollection collection, DBObject node) {
        Object id = node.get("_id");
        BasicDBObject oldNode = new BasicDBObject().append("_id", id);
        collection.update(oldNode, node);
    }

    @SuppressWarnings("Duplicates")
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
