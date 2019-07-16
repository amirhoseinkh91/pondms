package ir.viratech.pond_ms.model.tour_relations.agency.logic;

import java.io.IOException;
import java.util.List;

import ir.viratech.commons.cm.model.entity_instance.EntityInstance;
import ir.viratech.pond_ms.model.map_object.vector.PointObject;
import ir.viratech.pond_ms.model.map_object.vector.logic.PointObjectMgr;
import ir.viratech.pond_ms.model.tour_relations.base.model.Point;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;

import ir.viratech.pond_ms.api.filter.BaseMongoQueries;
import ir.viratech.pond_ms.model.map_object.vector.logic.GISVectorObjectMgr;
import ir.viratech.pond_ms.model.tour_relations.agency.Agency;
import ir.viratech.pond_ms.model.tour_relations.base.logic.BaseManager;

public class AgencyManager extends BaseManager {

    private Agency agency;

    public static Agency getInstance() throws InstantiationException, IllegalAccessException {
        return Agency.class.newInstance();
    }

    public static AgencyManager newInstance(){
        try {
            return AgencyManager.class.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Agency getByExtuid(String extuid) {
        System.out.println("extuid: " + extuid);
        PointObject pointObject = PointObjectMgr.getInstance().getByExtuid(extuid);
        return mapPointObjectToAgency(pointObject);
    }

    private Agency mapPointObjectToAgency(PointObject pointObject) {
        Agency agency = new Agency();
        System.out.println(pointObject);
        EntityInstance formInstance = pointObject.getFormInstance("full", false);
        agency.setUid(pointObject.getExtuid());
        agency.setName(pointObject.getName());

        for (String key : formInstance.getAllFieldNames()) {
            if (key.equalsIgnoreCase(Agency.PROP_RATE)) {
                try {
                    agency.setRate(formInstance.get(key, Integer.class));
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                }
            }

            if (key.equalsIgnoreCase(Agency.PROP_INTRUNSIC_VALUE)) {
                try {
                    agency.setIntrinsicValue(formInstance.get(key, Integer.class));
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                }
            }

            if (key.equalsIgnoreCase(Agency.PROP_TOTAL_SCORE)) {
                try {
                    agency.setTotalScore(formInstance.get(key, Integer.class));
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                }
            }

            if (key.equalsIgnoreCase(Agency.PROP_TEMPORAL_VALUE)) {
                try {
                    agency.setTemporalValue(formInstance.get(key, Integer.class));
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                }
            }

            if (key.equalsIgnoreCase(Agency.PROP_WEBSITE)) {
                try {
                    agency.setWebsite(formInstance.get(key, String.class));
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                }
            }

            if (key.equalsIgnoreCase(Agency.PROP_PHONE_NUMBER)) {
                try {
                    agency.setPhone(formInstance.get(key, String.class));
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                }
            }

            if (key.equalsIgnoreCase(Agency.PROP_ADDRESS)){
                try {
                    agency.setAddress(formInstance.get(key, String.class));
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                }
            }

            if (key.equalsIgnoreCase(Agency.PROP_IMAGES)) {
                try {
                    List<String> images = formInstance.getList(key,String.class);
                    if (images.size() > 0 && images != null)
                        agency.setImage(images.get(0));
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                }
            }

            if (key.equalsIgnoreCase(Agency.PROP_POINT)) {
                try {
                    Double x = formInstance.get(key,Point.class).getX();
                    Double y = formInstance.get(key, Point.class).getY();
                    agency.setPoint(new Point(x,y));
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                }
            }

        }


        return agency;
    }


    public Agency parse(JSONObject jsonObject) {
        try {
            agency = getInstance();


        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return agency;
    }

    public JSONObject getAgencyJson(String agency_username) throws JSONException, InstantiationException, IllegalAccessException {
        Agency agency = getByUsername(agency_username);
        JSONObject agencyJson = new JSONObject();
        agencyJson.put(Agency.PROP_NAME, agency.getName());
        agencyJson.put(Agency.PROP_ADDRESS, agency.getAddress());
        agencyJson.put(Agency.PROP_WEBSITE, agency.getWebsite());
        agencyJson.put(Agency.PROP_PHONE_NUMBER, agency.getPhone());
        agencyJson.put(Agency.PROP_IMAGES, agency.getImages());

        JSONObject geoJsonPoint = new JSONObject();
        geoJsonPoint.put("type", "Point");
        JSONArray pointCoordinateArray = new JSONArray();
        pointCoordinateArray.put(agency.getPoint().getX());
        pointCoordinateArray.put(agency.getPoint().getY());
        geoJsonPoint.put("coordinates", pointCoordinateArray);
        agencyJson.put(Agency.PROP_POINT, geoJsonPoint);

        return agencyJson;
    }

    public Agency getByUsername(String username) {
        try {
            System.out.println("username:" + username);
            JsonNode result = GISVectorObjectMgr.getInstance().getByUsername(BaseMongoQueries.AGENCY_COLLECTION, username);
            return mapJsonNodeToAgency(result);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Agency mapJsonNodeToAgency(JsonNode input) throws InstantiationException, IllegalAccessException {
        agency = Agency.class.newInstance();
        JsonNode agencyJson = input.get(0);
        try {
            agency.setAddress(agencyJson.get(Agency.PROP_ADDRESS).asText());
        } catch (NullPointerException e) {

        }
        agency.setName(agencyJson.get(Agency.PROP_NAME).asText());
        agency.setExtuid(agencyJson.get(Agency.PROP_UID).asText());
        agency.setUsername(agencyJson.get(Agency.PROP_USER_NAME).asText());
        try {
            agency.setIntrinsicValue(agencyJson.get(Agency.PROP_INTRUNSIC_VALUE).asInt());
        } catch (NullPointerException e) {
            agency.setIntrinsicValue(0);
        }
        try {
            agency.setRate(agencyJson.get(Agency.PROP_RATE).asInt());
        } catch (NullPointerException e) {
            agency.setRate(0);
        }
        try {
            agency.setTemporalValue(agencyJson.get(Agency.PROP_TEMPORAL_VALUE).asInt());
        } catch (NullPointerException e) {
            agency.setTemporalValue(0);
        }

        agency.setTotalScore(agency.getIntrinsicValue() + agency.getRate() + agency.getTemporalValue());


        agency.setWebsite(agencyJson.get(Agency.PROP_WEBSITE).asText());
        agency.setPhone(agencyJson.get(Agency.PROP_PHONE_NUMBER).asText());
        try {
            JSONArray array = new JSONArray(agencyJson.get(Agency.PROP_IMAGES).toString());
            if (array.length() > 0)
			    agency.setImage(array.getString(0));
        } catch (NullPointerException e) {
            e.printStackTrace();
			agency.setImage(null);
        } catch (JSONException e) {
            e.printStackTrace();
            agency.setImage(null);
        }
        double x = getCoordinateFromJsonNode('x', agencyJson);
        double y = getCoordinateFromJsonNode('y', agencyJson);
        agency.setPoint(new Point(x, y));

        return agency;
    }

    private double getCoordinateFromJsonNode(char coord, JsonNode agencyJson) {
        if (coord == 'x') {
            return agencyJson.get("point").get("coordinates").get(0).asDouble();
        } else if (coord == 'y') {
            return agencyJson.get("point").get("coordinates").get(1).asDouble();
        } else {
            return 2.0;
        }
    }
}
