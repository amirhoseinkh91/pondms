package ir.viratech.pond_ms.core.db.cli.four_square_json;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import ir.viratech.commons.cm.model.entity_instance.EntityInstance;
import ir.viratech.commons.cm.model.entity_instance.dao.EntityInstanceDAO;
import ir.viratech.commons.cm.model.entity_instance.logic.EntityInstanceMgr;
import ir.viratech.commons.cm.model.entity_instance.logic.EntityInstanceMgrProvider;
import ir.viratech.commons.cm.model.entity_type.EntityType;
import ir.viratech.commons.cm.model.entity_type.logic.EntityTypeMgr;
import ir.viratech.commons.persistence.mongo.base.MongoDBManager;
import ir.viratech.commons.util.jackson.JacksonUtils;
import ir.viratech.commons.util.jackson.ObjectMapperProvider;
import ir.viratech.pond_ms.commons.geo.Point;
import ir.viratech.pond_ms.core.spring.ApplicationContextUtil;
import ir.viratech.pond_ms.model.layer.Layer;
import ir.viratech.pond_ms.model.layer.ParentLayer;
import ir.viratech.pond_ms.model.layer.VectorLayer;
import ir.viratech.pond_ms.model.layer.logic.ParentLayerMgr;
import ir.viratech.pond_ms.model.layer.logic.VectorLayerMgr;
import ir.viratech.pond_ms.model.map_object.vector.PointObject;
import ir.viratech.pond_ms.model.map_object.vector.logic.PointObjectMgr;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PushAllRestaurantsToDB {

    private static final String RESTAURANT = "Restaurant";
    private static final String VENUE_ID = "VenueId";
    private static final String MERGED_RESTAURANTS = "/opt/PondMS/restaurants_json/merged/merged.json";
    private static final String FAILED_RESTAURANTS_ID = "/opt/PondMS/restaurants_json/failed/";
    private static EntityInstance restaurantEntityInstance;

    public static void main(String[] args) {
        ApplicationContextUtil.initializeCliApplicationContext();
        PushAllRestaurantsToDB restaurantsToDB = new PushAllRestaurantsToDB();
        restaurantsToDB.makeDirectories();
        List allVenueIDs = restaurantsToDB.getAllVenueIDs();
        for (JsonNode restaurantNode : restaurantsToDB.getRestaurantJsonsFromFile()) {
            try {
                if (allVenueIDs.contains(restaurantNode.get(VENUE_ID).asText())) {
                    continue;
                }
                VectorLayer restaurantVectorLayer = restaurantsToDB.makeVectorLayer(restaurantNode.get("city").asText());
                restaurantsToDB.fillGisVectorObject(restaurantVectorLayer, restaurantNode);
            } catch (Exception e) {
                restaurantsToDB.failedRestaurantsWriter(restaurantNode);
                e.printStackTrace();
            }
        }
    }

    private void failedRestaurantsWriter(JsonNode restaurantNode) {
        try {
            String venueId = restaurantNode.get("VenueId").asText().concat(".json");
            File failed = new File(FAILED_RESTAURANTS_ID + venueId);
            FileWriter writer = new FileWriter(failed);
            String restaurantPrettyView = ObjectMapperProvider.getObjectMapper().writeValueAsString(restaurantNode);
            writer.write(restaurantPrettyView);
            writer.flush();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void makeDirectories() {
        File file = new File(FAILED_RESTAURANTS_ID);
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    private List getAllVenueIDs() {
        List venueIDs = new ArrayList();
        EntityType typeKey = EntityTypeMgr.getInstance().getByKey(RESTAURANT);
        DBCollection collection = EntityInstanceDAO.getInstance().getCollection(typeKey);
        DBCursor dbObjects = collection.find();
        for (DBObject node : dbObjects) {
            if (!MongoDBManager.getInstance().convertToObjectNode(node).has(VENUE_ID)) {
                continue;
            }
            String venueId = MongoDBManager.getInstance().convertToObjectNode(node).get(VENUE_ID).asText();
            venueIDs.add(venueId);
        }
        return venueIDs;
    }

    private JsonNode getRestaurantJsonsFromFile() {
        try {
            File mergedRestaurantsFile = new File(MERGED_RESTAURANTS);
            return ObjectMapperProvider.getObjectMapper().readTree(mergedRestaurantsFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JacksonUtils.createEmptyObjectNode();
    }

    private VectorLayer makeVectorLayer(String cityName) throws Exception {
        ParentLayer parentLayer = ParentLayerMgr.getInstance().getByCityName(cityName);
        if (parentLayer == null) {
            parentLayer = ParentLayerMgr.getInstance().getByCityNameLike(cityName);
            Optional<ParentLayer> optional = Optional.ofNullable(parentLayer);
            if (!optional.isPresent())
                throw new Exception();
        }
        VectorLayer restaurantVectorLayer = getRestaurantVectorLayer(parentLayer);
        if (restaurantVectorLayer == null) {
            throw new Exception();
        }

        return restaurantVectorLayer;
    }

    private VectorLayer getRestaurantVectorLayer(ParentLayer parentLayer) {
        List<Layer> citySubLayers = parentLayer.getSubLayers();
        for (Layer subLayer : citySubLayers) {
            VectorLayer subLayerVector = (VectorLayer) subLayer;
            if (subLayerVector.getFormSchemaKey().equals("Restaurant")) {
                return subLayerVector;
            }
        }
        return null;
    }

    private VectorLayer fillGisVectorObject(VectorLayer restaurantVectorLayer, JsonNode restaurantNode) {
        PointObject gisVectorObject = PointObjectMgr.getInstance().createNew();
        gisVectorObject.setPoint(mapCoordinateToPoint(restaurantNode.get("point").get("coordinates")));
        gisVectorObject.setLayer(restaurantVectorLayer);
        gisVectorObject.setName(restaurantNode.get("title").asText());
        gisVectorObject.setOrganization(restaurantVectorLayer.getOrganization());
        addRestaurantWithRestaurantMgr(restaurantNode, restaurantVectorLayer, gisVectorObject);
        gisVectorObject.setFormUID(restaurantEntityInstance.getUid());
        return finalizeRestaurantObject(restaurantVectorLayer, gisVectorObject);
    }

    @SuppressWarnings("Duplicates")
    private VectorLayer finalizeRestaurantObject(VectorLayer restaurantVectorLayer, PointObject gisVectorObject) {
        VectorLayerMgr.getInstance().update(restaurantVectorLayer);
        PointObjectMgr.getInstance().add(gisVectorObject);
        restaurantVectorLayer = VectorLayerMgr.getInstance().reget(restaurantVectorLayer);
        restaurantVectorLayer.addToVectorObjects(gisVectorObject);
        VectorLayerMgr.getInstance().update(restaurantVectorLayer);
        return restaurantVectorLayer;
    }

    private com.vividsolutions.jts.geom.Point mapCoordinateToPoint(JsonNode coordinates) {
        Double x = coordinates.get(0).asDouble();
        Double y = coordinates.get(1).asDouble();
        return new Point(x, y).getJtsGeometry();
    }

    private void addRestaurantWithRestaurantMgr(JsonNode restaurantNode, VectorLayer restaurantVectorLayer, PointObject gisVectorObject) {
        try {
            EntityInstanceMgr restaurantMgr = EntityInstanceMgrProvider.getMgr("Restaurant");
            EntityType restaurantEntityType = EntityTypeMgr.getInstance().getByKey("Restaurant");
            ObjectNode mongodbModel = mapRestaurantsToMongodbModel(restaurantNode, restaurantVectorLayer, gisVectorObject);
            restaurantEntityInstance = new EntityInstance(restaurantEntityType, mongodbModel);
            restaurantMgr.add(restaurantEntityInstance, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private ObjectNode mapRestaurantsToMongodbModel(JsonNode restaurantNode, VectorLayer cityLayer, PointObject gisVectorObject) {
        ObjectNode validRestaurantNode = JacksonUtils.createEmptyObjectNode();
        validRestaurantNode.put("name", restaurantNode.get("title"));
        validRestaurantNode.put("RestaurantName", restaurantNode.get("title"));
        validRestaurantNode.put("VenueId", restaurantNode.get("VenueId"));
        validRestaurantNode.put("Rate", restaurantNode.get("rate").asInt());
        validRestaurantNode.put("IntrinsicValue", 0);
        validRestaurantNode.put("TemporalValue", 0);
        validRestaurantNode.put("FoursquarePhotos", restaurantNode.get("FoursquarePhotos"));
        validRestaurantNode.put("Price", restaurantNode.get("price"));
        validRestaurantNode.put("TotalScore", 0);
        validRestaurantNode.put("point", restaurantNode.get("point"));
        validRestaurantNode.put("Images", JacksonUtils.createEmptyArrayNode());
        validRestaurantNode.put("Address", restaurantNode.get("address"));
        validRestaurantNode.put("layer_uid", cityLayer.getExtuid());
        validRestaurantNode.put("gis_object_uid", gisVectorObject.getExtuid());
        validRestaurantNode.put("TelephoneNum", restaurantNode.get("telephoneNum"));
        validRestaurantNode.put("Website", "");
        validRestaurantNode.put("Tags", convertJsonNodeTagsToString(restaurantNode));
        validRestaurantNode.put("FoursquareTags", convertJsonNodeTagsToString(restaurantNode));
        validRestaurantNode.put("Description", "");
        validRestaurantNode.put("HotelFeatures", "");
        return validRestaurantNode;
    }

    private String convertJsonNodeTagsToString(JsonNode restaurantNode) {
        StringBuilder stringBuilder = new StringBuilder();
        JsonNode tags = restaurantNode.get("tags");
        for (JsonNode tag : tags) {
            stringBuilder.append(tag.asText());
        }
        return stringBuilder.toString();
    }
}
