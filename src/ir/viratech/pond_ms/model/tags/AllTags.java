package ir.viratech.pond_ms.model.tags;

import com.fasterxml.jackson.databind.JsonNode;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import ir.viratech.commons.cm.model.entity_instance.dao.EntityInstanceDAO;
import ir.viratech.commons.cm.model.entity_type.EntityType;
import ir.viratech.commons.cm.model.entity_type.logic.EntityTypeMgr;
import ir.viratech.commons.persistence.mongo.base.MongoDBManager;
import org.apache.commons.lang3.StringUtils;

import java.util.HashSet;
import java.util.Set;

public class AllTags {
    public Set<String> getAllTagsForRestaurant(String entityTypeKey) {
        Set<String> tagSets = new HashSet<>();
        EntityType typeKey = EntityTypeMgr.getInstance().getByKey(entityTypeKey);
        DBCollection collection = EntityInstanceDAO.getInstance().getCollection(typeKey);
        DBCursor dbObjects = collection.find();
        for (DBObject node : dbObjects) {
            if (!MongoDBManager.getInstance().convertToObjectNode(node).has("Tags"))
                continue;
            String tags = MongoDBManager.getInstance().convertToObjectNode(node).get("Tags").asText().trim();
            if (!StringUtils.isEmpty(tags)) {
                String[] split = tags.split("،");
                for (String s : split) {
                    tagSets.add(s.trim());
                }
            }
        }
        return tagSets;
    }

    public Set<String> getAllTagsForThingsToDo(String entityTypeKey) {
        Set<String> tagSets = new HashSet<>();
        DBCursor dbObjects = EntityInstanceDAO.getInstance().getCollection(EntityTypeMgr.getInstance().getByKey(entityTypeKey)).find();
        for (DBObject node : dbObjects) {
            JsonNode tags = MongoDBManager.getInstance().convertToObjectNode(node).get("Tags");
            if (tags != null) {
                String stringTags = tags.toString().trim().replaceAll(" {2}", "").replaceAll("\"", " ").replaceAll("٬", ",").replaceAll("،", ",").replaceAll("  ", " ").trim();
                String[] split = stringTags.split(",");
                for (String tag : split) {
                    tagSets.add(tag.trim());
                }
            }
        }
        return tagSets;
    }
}
