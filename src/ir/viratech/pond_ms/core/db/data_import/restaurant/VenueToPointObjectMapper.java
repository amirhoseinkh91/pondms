package ir.viratech.pond_ms.core.db.data_import.restaurant;

import java.util.List;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import ir.viratech.base.SuppressWarningsOption;
import ir.viratech.commons.cm.core.validation.ValidationException;
import ir.viratech.commons.cm.model.entity_instance.EntityInstance;
import ir.viratech.commons.cm.model.entity_instance.logic.EntityInstanceMgr;
import ir.viratech.commons.cm.model.entity_instance.logic.EntityInstanceMgrProvider;
import ir.viratech.commons.cm.model.entity_type.EntityType;
import ir.viratech.commons.cm.model.entity_type.EntityTypeNotFoundException;
import ir.viratech.commons.cm.model.entity_type.logic.EntityTypeMgr;
import ir.viratech.commons.util.jackson.JacksonUtils;
import ir.viratech.just_ro.model.restaurant.Restaurant;
import ir.viratech.pond_ms.commons.geo.Point;
import ir.viratech.pond_ms.core.db.data_import.restaurant.foursquare.FoursquareCategory;
import ir.viratech.pond_ms.core.db.data_import.restaurant.foursquare.FoursquareVenue;
import ir.viratech.pond_ms.model.layer.VectorLayer;
import ir.viratech.pond_ms.model.map_object.vector.PointObject;
import ir.viratech.pond_ms.model.map_object.vector.logic.PointObjectMgr;

@SuppressWarnings(SuppressWarningsOption.ALL)
public class VenueToPointObjectMapper {

    private FoursquareVenue venue;
    private PointObject pointObject;
    private VectorLayer vectorLayer;

    VenueToPointObjectMapper(FoursquareVenue venue, VectorLayer vectorLayer) {
        this.venue = venue;
        this.pointObject = PointObjectMgr.getInstance().createNew();
        this.vectorLayer = vectorLayer;
    }

    private void map() {
        ObjectNode objectNode = createObjectNode();
        try {
            EntityInstance formInstance = createNewFormInstance(objectNode);
            formInstance = saveFormInstance(formInstance);
            makePointObjectReady(formInstance);
        } catch (EntityTypeNotFoundException e) {
            e.printStackTrace();
        } catch (ValidationException e) {
            e.printStackTrace();
        }
    }

    public PointObject getPointObject() {
        this.map();
        return this.pointObject;
    }

    private void makePointObjectReady(EntityInstance formInstance) {
        pointObject.setLayer(vectorLayer);
        pointObject.setName(new FoursquareNameHandler().check(venue.getName()));
        pointObject.setOrganization(vectorLayer.getOrganization());
        pointObject.setFormUID(formInstance.getExtuid());
        pointObject.setPoint(new Point(venue.getLocation().getLng(), venue.getLocation().getLat()).getJtsGeometry());
    }

    private ObjectNode createObjectNode() {
        ObjectNode objectNode = JacksonUtils.createEmptyObjectNode();
        String name = new FoursquareNameHandler().check(venue.getName());
        objectNode.put("name", name);
        objectNode.put("RestaurantName", name);
        objectNode.put("VenueId", venue.getId());
        if (venue.getRating() != null)
            objectNode.put("Rate", Math.round(venue.getRating()));
        else
            objectNode.put("Rate", 0);
        objectNode.put("IntrinsicValue", 0);
        objectNode.put("TemporalValue", 0);
        objectNode.put("FoursquarePhotos", createPhotosArrayNode());
        try {
            objectNode.put("Price", venue.getPrice().getTier());
        } catch (NullPointerException e) {
        }
        objectNode.put("TotalScore", (objectNode.get("Rate").asInt()));
        objectNode.put("point", createPointObjectNode());
        objectNode.put("Images", JacksonUtils.createEmptyArrayNode());
        objectNode.put("Address", createAddress());
        objectNode.put("layer_uid", vectorLayer.getExtuid());
        objectNode.put("gis_object_uid", pointObject.getExtuid());

        try {
            objectNode.put("TelephoneNum", venue.getContact().getPhone());
        } catch (NullPointerException e) {

        }
        try {
            objectNode.put("Website", venue.getUrl());
        } catch (NullPointerException e) {

        }
        objectNode.put("FoursquareTags", getTags());
        objectNode.put("Tags", getPersianTags());
        objectNode.put("Description", "");
        objectNode.put("HotelFeatures", "");
        return objectNode;
    }

    private String getPersianTags() {
        StringBuilder builder = new StringBuilder();
        List<FoursquareCategory> categoryList = venue.getCategories();
        for (int i = 0; i < categoryList.size(); i++) {
            String persianTag = new Restaurant().mapFoursquareTag(categoryList.get(i));
            if (persianTag != null) {
                builder.append(persianTag);
                if (i < categoryList.size() - 1)
                    builder.append(" ،");
            }
        }
        return builder.toString();
    }

    private String getTags() {
        StringBuilder builder = new StringBuilder();
        List<FoursquareCategory> categoryList = venue.getCategories();
        for (int i = 0; i < categoryList.size(); i++) {
            builder.append(categoryList.get(i).getName());
            if (i < categoryList.size() - 1)
                builder.append(" ،");
        }
        return builder.toString();
    }

    private EntityInstance saveFormInstance(EntityInstance formInstance) throws ValidationException, EntityTypeNotFoundException {
        EntityInstanceMgr mgr = EntityInstanceMgrProvider.getMgr("Restaurant");
        return mgr.add(formInstance, true);
    }

    private EntityInstance createNewFormInstance(ObjectNode objectNode) throws EntityTypeNotFoundException {
        EntityType entityType = EntityTypeMgr.getInstance().getByKey("Restaurant");
        return new EntityInstance(entityType, objectNode);
    }

    private ObjectNode createPointObjectNode() {
        ObjectNode objectNode = JacksonUtils.createEmptyObjectNode();
        ArrayNode arrayNode = JacksonUtils.createEmptyArrayNode();
        arrayNode.add(this.venue.getLocation().getLng());
        arrayNode.add(this.venue.getLocation().getLat());
        objectNode.put("type", "Point");
        objectNode.put("coordinates", arrayNode);
        return objectNode;
    }

    private ArrayNode createPhotosArrayNode() {
        ArrayNode arrayNode = JacksonUtils.createEmptyArrayNode();
        if (venue.getFoursquarePhoto() != null)
            for (String str : venue.getFoursquarePhoto().getPhotos())
                arrayNode.add(str);
        return arrayNode;
    }

    private String createAddress() {
        StringBuilder builder = new StringBuilder();
        if (this.venue.getLocation().getCountry() != null)
            builder.append(this.venue.getLocation().getCountry() + "،");
        if (this.venue.getLocation().getState() != null)
            builder.append(this.venue.getLocation().getState() + "،");
        if (this.venue.getLocation().getCity() != null)
            builder.append(this.venue.getLocation().getCity() + "،");
        if (this.venue.getLocation().getCrossStreet() != null)
            builder.append(this.venue.getLocation().getCrossStreet() + "،");
        if (this.venue.getLocation().getAddress() != null)
            builder.append(this.venue.getLocation().getAddress());
        return builder.toString();
    }
}
