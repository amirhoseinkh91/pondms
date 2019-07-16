package ir.viratech.pond_ms.model.hotel.dao;

import java.io.IOException;
import java.util.List;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

import ir.viratech.commons.persistence.mongo.base.MongoDBManager;
import ir.viratech.commons.util.jackson.JacksonUtils;
import ir.viratech.just_ro.manager.website.hotel.Eghamat24;
import ir.viratech.just_ro.model.information.Information;
import ir.viratech.pond_ms.model.hotel.Hotel;
import ir.viratech.pond_ms.model.hotel.base.BaseHotelDAO;
import ir.viratech.pond_ms.model.layer.logic.LayerMgr;

/**
 * DAO class for entity "ir.viratech.pond_ms.model.hotel.Hotel".
 */
public class HotelDAO extends BaseHotelDAO {


    @Autowired
    private MongoDBManager mongoDBManager;

    public JsonNode getHotelsToScrapeForAndroid_new(int numberOfHotels) throws IOException {
        ArrayNode results = JacksonUtils.createEmptyArrayNode();
        DBCollection hotelCollection = mongoDBManager.getDB().getCollection("hotel_col");
        String query = new StringBuilder("db.getCollection('hotel_col')")
                .append(".find({")
                .append("$query:{").append("$and : [{'_isDeleted' : false}\n" +
                        ", {'lowestPrice' : {$exists:true}}]}, $orderby : [{'lastModified_date': 1},\n" +
                        "{'lastModified_time': 1}]}).limit(" + numberOfHotels + ").toArray()")
                .toString();
        JsonNode jsonNode = mongoDBManager.executeQuery(query);
        return results;
    }

    public JsonNode getHotelsToScrapeForAndroid(int numberOfHotels) {
        int counter = 0;
        int skipCounter = 0;
        ArrayNode results = JacksonUtils.createEmptyArrayNode();
        DBCollection hotelCollection = mongoDBManager.getDB().getCollection("hotel_col");

        DBObject query = new BasicDBObject();
        query.put("_isDeleted" , false);
        query.put("lowestPrice" , new BasicDBObject("$exists", true));

        DBObject sort = new BasicDBObject();
        sort.put("lastModified_date", 1);
        sort.put("lastModified_time", 1);
        while (counter < numberOfHotels){
            DBCursor cursor = hotelCollection.find(query).sort(sort).skip(skipCounter).limit(1);
            DBObject dbObject = cursor.next();
            String name = (String) dbObject.get("name");
            try {
                this.getByName_eghamat24(name);
                ObjectNode hotel = JacksonUtils.createEmptyObjectNode();
                hotel.put("name" , name);
                hotel.put("_uid", (String) dbObject.get("_uid"));
                String city = LayerMgr.getInstance().getByExtuid((String) dbObject.get("layer_uid")).getParentLayer().getName().substring(4);
                String link = new Eghamat24(new Information(city, name)).myMakeURL();
                hotel.put("link", link);
                results.add(hotel);
                counter++;
                skipCounter++;
            } catch (Exception e){
                skipCounter++;
                continue;
            }
        }

        return results;
    }

    public String getByName_eghamat24(String faName) throws IndexOutOfBoundsException, ArrayIndexOutOfBoundsException {
        String queryString = SELECT + Hotel.PROP_EGHAMAT_NAME + FROM + Hotel.REF + WHERE + Hotel.PROP_HOTEL_NAME + " like "
                + "'%" + faName + "%'";
        Query query = getQuery(queryString);
        List<String> list = getList(query);
        return list.get(0);
    }

    public String getCode_iranhotelonline(String faName)
            throws IndexOutOfBoundsException, ArrayIndexOutOfBoundsException {
        String queryString = SELECT + Hotel.PROP_IRANHOTELONLINE_CODE + FROM + Hotel.REF + WHERE
                + Hotel.PROP_IRANHOTELONLINE_NAME + " like " + "'%" + faName + "%'";
        Query query = getQuery(queryString);
        List<String> list = getList(query);
        return list.get(0);
    }

    public String getByName_iranhotelonline(String faName)
            throws IndexOutOfBoundsException, ArrayIndexOutOfBoundsException {
        String queryString = SELECT + Hotel.PROP_IRANHOTELONLINE_NAME + FROM + Hotel.REF + WHERE + Hotel.PROP_HOTEL_NAME
                + "=" + "'" + faName + "'";
        Query query = getQuery(queryString);
        List<String> list = getList(query);
        return list.get(0);
    }

    public String getByName_hotelYarName(String faName)
            throws IndexOutOfBoundsException, ArrayIndexOutOfBoundsException {
        String queryString = SELECT + Hotel.PROP_HOTELYAR_NAME + FROM + Hotel.REF + WHERE + Hotel.PROP_HOTEL_NAME + "="
                + "'" + faName + "'";
        Query query = getQuery(queryString);
        List<String> list = getList(query);
        return list.get(0);
    }

    public String getByName_hotelYarCode(String faName)
            throws IndexOutOfBoundsException, ArrayIndexOutOfBoundsException {
        String queryString = SELECT + Hotel.PROP_HOTELYAR_CODE + FROM + Hotel.REF + WHERE + Hotel.PROP_HOTELYAR_NAME
                + "=" + "'" + faName + "'";
        Query query = getQuery(queryString);
        List<String> list = getList(query);
        return list.get(0);
    }

    public String getByName_pintapin(String faName) throws IndexOutOfBoundsException, ArrayIndexOutOfBoundsException {
        String queryString = SELECT + Hotel.PROP_PINTAPIN_NAME + FROM + Hotel.REF + WHERE + Hotel.PROP_PINTAPIN_NAME
                + "=" + "'" + faName + "'";
        Query query = getQuery(queryString);
        List<String> list = getList(query);
        return list.get(0);
    }

}