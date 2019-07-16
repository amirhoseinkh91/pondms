package ir.viratech.pond_ms.api.city;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import ir.viratech.commons.util.jackson.JacksonUtils;
import ir.viratech.pond_ms.api.filter.BaseMongoQueries;
import ir.viratech.pond_ms.model.gis_vector_object_new_model.GisVectorLayerToNewModel;
import ir.viratech.pond_ms.model.layer.Layer;
import ir.viratech.pond_ms.model.layer.ParentLayer;
import ir.viratech.pond_ms.model.layer.logic.LayerMgr;
import ir.viratech.pond_ms.model.layer.logic.ParentLayerMgr;
import org.apache.commons.lang3.StringUtils;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Path("/city")
public class CityService extends BaseMongoQueries {
    private static final String COLLECTION_CITY = "city";

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/city-names")
    public Response finder(@QueryParam("q") String name) {
        try {
            if (name.matches("[A-Za-z]+") || name.matches("[0-9]+")) {
                return Response.status(400).build();
            }
            if (StringUtils.isEmpty(name)) {
                return Response.status(400).build();
            }
            isManualSort = isManualSort("Rate", "DSC");
            String regex = regex("name", name);
            String filterResult = multiple_Column_Filter("name", "_id", "layer_uid");
            String append = appendQueries(regex, filterResult);
            String query = baseQueryMaker(find(append), COLLECTION_CITY, false);
            JsonNode node = getMongoDBManager().executeQuery(query);
            for (JsonNode child : node) {
                if (!child.has("layer_uid")) {
                    continue;
                }
                String uid = child.get("layer_uid").asText();
                Layer subLayer = LayerMgr.getInstance().getByExtuid(uid);
                ParentLayer parentLayer = subLayer.getParentLayer();
                String layerUid = parentLayer.getExtuid();
                while (parentLayer.getParentLayer() != null) {
                    parentLayer = parentLayer.getParentLayer();
                }
                ObjectNode childNode = (ObjectNode) child;
                childNode.put("layer_uid", layerUid);
                childNode.put("parent", parentLayer.getName());
            }
            return Response.ok(node).build();

        } catch (IOException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
            return Response.ok(JacksonUtils.createEmptyArrayNode()).build();
        }
    }

    @GET
    @Path("/latLong")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public JsonNode returnLatLong(@QueryParam("city") String cityName) {
        try {
            String query = baseQueryMaker(find(eq("name", cityName) + "," + multiple_Column_Filter("name", "_id", "point")), COLLECTION_CITY, false);
            JsonNode node = getMongoDBManager().executeQuery(query);
            return node.get(0);
        } catch (InstantiationException | IllegalAccessException | IOException e) {
            e.printStackTrace();
        }
        return JacksonUtils.createEmptyObjectNode();
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/topCities")
    public Response getTopCities(@QueryParam("tag") List<String> tags) {
        isManualSort = isManualSort("Rate", "DSC");
        paginationConverter("0", "10");
        String tagsQuery = tagsQuery(tags);
        try {
            String query = baseQueryMaker(find(and(eq("Rate", "10"), tagsQuery))
                    , "city", false);
            JsonNode jsonNode = getMongoDBManager().executeQuery(query);
            JsonNode entity = GisVectorLayerToNewModel.mapperToNewModel(jsonNode);
            return Response.ok(entity).build();
        } catch (InstantiationException | IllegalAccessException | IOException e) {
            e.printStackTrace();
        }
        return Response.status(500).build();
    }


    @GET
    @Path("/get-city-by-province")
    public Response getProvinceCities(@QueryParam("uid") String uid, @QueryParam("name") String name) {
        Set<Layer> selectedCities = new HashSet<>();
        if (StringUtils.isEmpty(uid)) {
            Response.status(406).build();
        }
        ParentLayer province = ParentLayerMgr.getInstance().getByExtuid(uid);
        if (province.getSubLayers() != null) {
            List<Layer> cities = province.getSubLayers();
            if (!StringUtils.isEmpty(name)) {
                for (Layer city : cities) {
                    if (city.getName().contains(name)) {
                        selectedCities.add(city);
                    }
                }
            } else {
                selectedCities.addAll(cities);
            }
            return Response.ok(convertAllCitiesToJsonObject(selectedCities)).build();
        }
        return Response.status(406).build();
    }

    @SuppressWarnings("Duplicates")
    private String tagsQuery(List<String> tags) {
        try {
            if (tags != null && tags.size() > 0) {
                String[] strings = new String[tags.size()];
                for (int i = 0; i < tags.size(); i++) {
                    strings[i] = regex("tags", tags.get(i));
                }
                return or_logical(strings);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    private JsonNode convertAllCitiesToJsonObject(Set<Layer> cities) {
        ArrayNode citiesNode = JacksonUtils.createEmptyArrayNode();
        for (Layer city : cities) {
            ObjectNode cityNode = JacksonUtils.createEmptyObjectNode();
            cityNode.put("uid", city.getExtuid());
            cityNode.put("name", city.getName());
            citiesNode.add(cityNode);
        }
        return citiesNode;
    }
}
