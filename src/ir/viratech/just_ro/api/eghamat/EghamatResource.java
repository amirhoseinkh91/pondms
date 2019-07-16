package ir.viratech.just_ro.api.eghamat;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.fasterxml.jackson.databind.JsonNode;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;

import ir.viratech.commons.persistence.mongo.base.MongoDBManager;
import ir.viratech.just_ro.manager.website.hotel.Eghamat24;

/**
 * Created by amir on 8/30/17.
 */

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/hotel-data")
public class EghamatResource {

    public static class EghamatDAO {
        public void addOrUpdate(JSONObject jsonObject) {
            try {
                DBObject prevObj = new BasicDBObject("_uid" , jsonObject.getString("_uid"));
                MongoDBManager manager = MongoDBManager.getInstance();
                DBObject newObj = (DBObject) JSON.parse(jsonObject.toString());
                manager.getCollection("eghamat_col").update(prevObj, newObj,true, false);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        public JSONObject getByName(String name){
            DBObject query = new BasicDBObject("name" , name);
            MongoDBManager manager = MongoDBManager.getInstance();
            DBCursor cursor = manager.getCollection("eghamat_col").find(query);
            while (cursor.hasNext()) {
                try {
                    return new JSONObject(cursor.next().toString());
                } catch (JSONException e) {
                    return null;
                }
            }
            return null;
        }
    }

    @POST
    @Path("/add")
    public void add(String s) {
        try {
            JSONArray jsonArray = new JSONArray(s);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                EghamatDAO eghamatDAO = new EghamatDAO();
                eghamatDAO.addOrUpdate(jsonObject);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @GET
    @Path("/get-for-update")
    public JsonNode getHotelsToUpdate() {
        try {
            return Eghamat24.class.newInstance().getHotelsToScrapeForAndroid();
        } catch (InstantiationException | IllegalAccessException e) {
            return null;
        }
    }

}