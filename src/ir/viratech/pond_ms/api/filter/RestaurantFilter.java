package ir.viratech.pond_ms.api.filter;

import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.fasterxml.jackson.databind.JsonNode;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;

import ir.viratech.commons.persistence.mongo.base.MongoDBManager;

@Path("/filter/restaurantitmexfkjsdf")
public class RestaurantFilter {

    private MongoDBManager mongoDBManager = MongoDBManager.getInstance();

    @GET
    @Path("/items")
    public JsonNode filter(@BeanParam RestaurantSearchQuery searchQuery) {
        DBCollection restaurantCol = mongoDBManager.getCollection("restaurant_col");
        DBObject query = createQuery(searchQuery);

        return null;
    }

    private DBObject createQuery(RestaurantSearchQuery searchQuery){
        DBObject query = new BasicDBObject();
        if (searchQuery.getName() != null)
            query.put("$regex" , new BasicDBObject("name" , ".*" +  searchQuery.getName() + ".*"));
        if (searchQuery.getLayerUid() != null)
            query.put("layer_uid" , searchQuery.getLayerUid());
        if (searchQuery.getTag() != null)
            query.put("$regex" , new BasicDBObject("Tags" , ".*" +  searchQuery.getTag() + ".*"));
        if (searchQuery.getPriceRate() != null)
            query.put("$or" ,or(createPriceRateQuery(searchQuery.getPriceRate())));
        if (searchQuery.getRate() != null)
            query.put("Rate" , new BaseMongoQueries().rate_ThingsToDo(String.valueOf(searchQuery.getRate())));

        return query;
    }

    private DBObject[] createPriceRateQuery(String priceRate) {
        if (priceRate.contains(",")){
            String[] parts = priceRate.split(",");
            BasicDBObject[] dbObjects = new BasicDBObject[parts.length];
            for (int i = 0; i < dbObjects.length; i++)
                dbObjects[i] = new BasicDBObject("Price" , parts[i]);
            return dbObjects;
        } else {
            BasicDBObject[] dbObjects = new BasicDBObject[1];
            dbObjects[0] = new BasicDBObject("Price" , priceRate);
            return dbObjects;
        }
    }

    private DBObject or(DBObject... dbObjects){
        DBObject or = new BasicDBList();
        for (DBObject d : dbObjects)
            or.putAll(d);
        return or;
    }

}
