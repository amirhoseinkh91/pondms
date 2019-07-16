package ir.viratech.pond_ms.core.db.cli.four_square_json;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import ir.viratech.commons.persistence.mongo.base.MongoDBManager;
import ir.viratech.pond_ms.core.spring.ApplicationContextUtil;
import ir.viratech.pond_ms.model.map_object.vector.GISVectorObject;
import ir.viratech.pond_ms.model.map_object.vector.logic.GISVectorObjectMgr;

import java.util.List;

public class RestaurantDuplicateRemover {
    public static void main(String[] args) {
        ApplicationContextUtil.initializeCliApplicationContext();
        List<GISVectorObject> list = GISVectorObjectMgr.getInstance().list();
        DBCollection restaurant_col = MongoDBManager.getInstance().getCollection("restaurant_col");
        for (GISVectorObject gisVectorObject : list) {
            if (gisVectorObject.getLayer().getFormSchemaKey().equals("Restaurant")) {
                DBObject restaurantNode = restaurant_col.findOne(new BasicDBObject("gis_object_uid", gisVectorObject.getExtuid()));
                if (restaurantNode == null) {
                    System.out.print("deleting gis with uid:\t" + gisVectorObject.getExtuid());
                    GISVectorObjectMgr.getInstance().delete(gisVectorObject);
                    System.out.println("\tis successfully...!");
                }
            }
        }
    }
}
