package ir.viratech.pond_ms.model.map_object.vector.dao;

import java.io.IOException;

import org.json.JSONException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

import ir.viratech.commons.persistence.mongo.base.MongoDBManager;
import ir.viratech.commons.spring.tx.ReadTransactional;
import ir.viratech.just_ro.model.calendar.CalendarTool;
import ir.viratech.pond_ms.model.map_object.vector.PointObject;
import ir.viratech.pond_ms.model.map_object.vector.base.BasePointObjectDAO;

/**
 * DAO class for entity
 * "ir.viratech.pond_ms.model.map_object.vector.PointObject".
 */
public class PointObjectDAO extends BasePointObjectDAO {

    @ReadTransactional
    public JsonNode getByName(String name) throws JsonProcessingException, IOException, InstantiationException,
            IllegalAccessException, JSONException, NullPointerException {
        MongoDBManager manager = MongoDBManager.getInstance();
        String query = "db.things_to_do_col.find({'name' : '" + name + "'}).toArray()";
        return manager.executeQuery(query).get(0);
    }

    public PointObject getPointObjectByName(String name) {
        return this.getByUniqueProp(PointObject.PROPCOLUMN_NAME, name);
    }

    public static class PointObjectFormDAO {
        MongoDBManager mgr = MongoDBManager.getInstance();

        /**
         * method for mongo db
         */
        public ArrayNode getSortedByModifiedDate(int count) {
            ArrayNode responseNode = ir.viratech.commons.util.jackson.JacksonUtils.createEmptyArrayNode();
            String today = new CalendarTool().getIranianToday();
            DBObject query = new BasicDBObject();
            DBObject sort = new BasicDBObject();
            DBCollection collection = mgr.getCollection("hotel_col");
            sort.put("lastModified_date", 1);
            query.put("_isDeleted",false);
            DBCursor cursor = collection.find(query).sort(sort).limit(count);
            while (cursor.hasNext()) {

                DBObject dbObject = cursor.next();
                ObjectNode emptyObjectNode = ir.viratech.commons.util.jackson.JacksonUtils.createEmptyObjectNode();

                String gisObjectUid = (String) dbObject.get("gis_object_uid");
                emptyObjectNode.put("Uid", gisObjectUid);
                String hotelName = (String) dbObject.get("HotelName");
                emptyObjectNode.put("layer_uid", (String) dbObject.get("layer_uid"));
                emptyObjectNode.put("hotelName", hotelName);

                // update modified date
                BasicDBObject newDocument = new BasicDBObject();
                newDocument.put("$set", new BasicDBObject().append("lastModified_date", today));
                collection.update(dbObject, newDocument);
                responseNode.add(emptyObjectNode);
            }
            return responseNode;
        }

    }
}