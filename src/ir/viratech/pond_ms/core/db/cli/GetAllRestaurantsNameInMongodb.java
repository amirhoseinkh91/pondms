package ir.viratech.pond_ms.core.db.cli;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import ir.viratech.commons.cm.model.entity_instance.dao.EntityInstanceDAO;
import ir.viratech.commons.cm.model.entity_type.EntityType;
import ir.viratech.commons.cm.model.entity_type.logic.EntityTypeMgr;
import ir.viratech.commons.persistence.mongo.base.MongoDBManager;
import ir.viratech.pond_ms.core.spring.ApplicationContextUtil;
import ir.viratech.pond_ms.model.layer.logic.ParentLayerMgr;

import java.io.File;
import java.io.FileWriter;

@SuppressWarnings("Duplicates")
public class GetAllRestaurantsNameInMongodb {
    public static void main(String[] args) {
        ApplicationContextUtil.initializeCliApplicationContext();
        try {
            File file = new File("/opt/PondMS/RestaurantsName_sari_16_03_19.txt");
            FileWriter writer = new FileWriter(file);

            String layer = ParentLayerMgr.getInstance().getByCityName("شهر ساری").getSubLayers().get(1).getExtuid();

            BasicDBObject query = new BasicDBObject();
            query.put("layer_uid", layer);

            EntityType typeKey = EntityTypeMgr.getInstance().getByKey("Restaurant");
            DBCollection collection = EntityInstanceDAO.getInstance().getCollection(typeKey);
            DBCursor dbObjects = collection.find(query).sort(new BasicDBObject("Rate", -1));
            int i = 1;
            for (DBObject node : dbObjects) {
                if (!MongoDBManager.getInstance().convertToObjectNode(node).has("name")) {
                    continue;
                }
                writer.write(i++ + "_\t" + MongoDBManager.getInstance().convertToObjectNode(node).get("name").asText() + "\n");
                writer.flush();
            }
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
