package ir.viratech.pond_ms.core.db.cli.fix_no_images_restaurants;

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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("Duplicates")
public class ImportRestaurantFoursquarePhotosToDB {


    public static void main(String[] args) {
        ApplicationContextUtil.initializeCliApplicationContext();
        try {
            ImportRestaurantFoursquarePhotosToDB instance = new ImportRestaurantFoursquarePhotosToDB();
            DBCollection collection = EntityInstanceDAO.getInstance().getCollection(EntityTypeMgr.getInstance().getByKey("Restaurant"));
            File downloadedImagesPath = new File("/opt/PondMS/Restaurant");
            File[] restaurantsFolders = downloadedImagesPath.listFiles();

            List<String> saveList = getNoImageRestaurantUids();


            if (restaurantsFolders != null) {
                int allRestaurants = restaurantsFolders.length;
                int i = 1;
                for (File restaurantFolder : restaurantsFolders) {
                    String fileName = FilenameUtils.getBaseName(restaurantFolder.getAbsolutePath());
                    if (saveList.contains(fileName)) {
                        DBObject node = collection.findOne(new BasicDBObject("gis_object_uid", fileName));
                        if (node == null) {
                            continue;
                        }
                        BasicDBList imagesArray = (BasicDBList) node.get("Images");
                        File[] images = restaurantFolder.listFiles();
                        if (images != null) {
                            for (File image : images) {
                                String hashCode = instance.convertToHashCode(image);
                                imagesArray.add(hashCode);
                            }
                            instance.updateMongo(collection, node);
                        }
                        System.out.println(i + "\tRestaurant with uid: " + fileName + " is updated from\t" + allRestaurants);
                        i++;
                    }
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

    private static List<String> getNoImageRestaurantUids() {

        List<String> res = new ArrayList<>();

        try {
            ImageDataChecker imageDataChecker = new ImageDataChecker();
            imageDataChecker.init();
            for (ImageDataChecker.NoImageItemResult item : imageDataChecker.data) {
                if (item.getGisObjectType().equalsIgnoreCase("restaurant")) {
                    res.add(item.getGisVectorObjectUid());
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return res;
    }

}
