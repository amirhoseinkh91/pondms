package ir.viratech.pond_ms.core.db.cli;

import com.mongodb.*;
import ir.viratech.commons.cm.model.entity_instance.dao.EntityInstanceDAO;
import ir.viratech.commons.cm.model.entity_type.logic.EntityTypeMgr;
import ir.viratech.commons.persistence.mongo.base.MongoDBManager;
import ir.viratech.pond_ms.core.spring.ApplicationContextUtil;
import org.apache.commons.lang3.StringUtils;

@SuppressWarnings("all")
public class SplitThingsToDoTags {
    public static void main(String[] args) {
        ApplicationContextUtil.initializeCliApplicationContext();
        try {
            DBCollection collection = EntityInstanceDAO.getInstance().getCollection(EntityTypeMgr.getInstance().getByKey("Things_To_Do"));
            DBCursor dbObjects = collection.find();
            for (DBObject node : dbObjects) {
                if (MongoDBManager.getInstance().convertToObjectNode(node).has("Tags")) {
                    String lists = MongoDBManager.getInstance().convertToObjectNode(node).get("Tags").asText().trim().replaceAll(" {2}", "").replaceAll("\"", " ").replaceAll("٬", ",").replaceAll("،", ",").replaceAll("  ", " ").trim();
                    if (!StringUtils.isEmpty(lists)) {
                        String[] split = lists.split(",");
                        node.removeField("Tags");
                        BasicDBList arrayNode = new BasicDBList();
                        for (String s : split) {
                            arrayNode.add(s.trim());
                        }
                        node.put("Tags", arrayNode);
                        updateMongo(collection, node);
                    }
                }
            }
            BasicDBObject query = new BasicDBObject();
            query.put("_isDeleted", true);
            collection.remove(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static void updateMongo(DBCollection collection, DBObject node) {
        Object id = node.get("_id");
        BasicDBObject oldNode = new BasicDBObject().append("_id", id);
        collection.update(oldNode, node);
    }

}
