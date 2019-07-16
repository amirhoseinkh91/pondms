package ir.viratech.pond_ms.api.top_place_search;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import ir.viratech.commons.util.jackson.JacksonUtils;
import ir.viratech.pond_ms.api.filter.BaseMongoQueries;
import ir.viratech.pond_ms.model.gis_vector_object_new_model.GisVectorLayerToNewModel;
import ir.viratech.pond_ms.model.layer.Layer;
import ir.viratech.pond_ms.model.layer.ParentLayer;
import ir.viratech.pond_ms.model.layer.logic.LayerMgr;
import org.apache.commons.lang3.StringUtils;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.*;

@Path("/top-place")
public class TopPlaceSearchService extends BaseMongoQueries {
    private static final String COLLECTION_THINGS_TO_DO = "things-to-do";
    private static final String COLLECTION_RESTAURANT = "restaurant";
    private static final String COLLECTION_CITY = "city";

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/find")
    public Response placeSearch(@QueryParam("name") String q, @QueryParam("cityUid") String layerUid) {
        try {
            if (StringUtils.isEmpty(q)) {
                return Response.status(406).build();
            }
            ObjectNode finalResult = JacksonUtils.createEmptyObjectNode();
            paginationConverter("0", "1");
            List<String> availableCollections;
            String find;
            if (!StringUtils.isEmpty(layerUid)) {
                availableCollections = new ArrayList<>(Arrays.asList(COLLECTION_THINGS_TO_DO, COLLECTION_RESTAURANT));
                find = find(and(regex("name", q), layerUid(layerUid),isDeleted(false)));
            } else {
                availableCollections = new ArrayList<>(Arrays.asList(COLLECTION_CITY, COLLECTION_THINGS_TO_DO, COLLECTION_RESTAURANT));
                find = find(and(regex("name", q),isDeleted(false)));
            }
            for (String collection : availableCollections) {
                Map<String, Integer> sort = new HashMap<>();
                sort.put("Rate", -1);
                String sortBy = sortBy(sort);
                String query = executableQuery(makeQuery(find, collectionMapper(collection)), sortBy);
                JsonNode itemsNode = getMongoDBManager().executeQuery(query);
                if (itemsNode.size()>0) {
                    if (collection.equals(COLLECTION_CITY)) {
                        String extuid = itemsNode.get(0).get("layer_uid").asText();
                        Layer cityDetails = LayerMgr.getInstance().getByExtuid(extuid);
                        ParentLayer city = cityDetails.getParentLayer();
                        String cityExtuid = city.getExtuid();
                        ((ObjectNode) itemsNode.get(0)).put("gis_object_uid", cityExtuid);
                    }
                }
                if (!(itemsNode.size() > 0)) {
                    continue;
                }
                JsonNode newModel = GisVectorLayerToNewModel.mapperToNewModel(itemsNode.get(0));
                finalResult.put(collection, newModel);
            }
            return Response.ok(finalResult).build();

        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(500).build();
        }
    }
}
