package ir.viratech.pond_ms.api.search_on_map;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import ir.viratech.commons.util.jackson.ObjectMapperProvider;
import ir.viratech.pond_ms.api.filter.BaseMongoQueries;
import org.apache.commons.lang3.StringUtils;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Path("/search-on-map")
public class SearchMapService extends BaseMongoQueries {
    private static final String COLLECTION_HOTEL = "hotel";
    private static final String COLLECTION_THINGS_TO_DO = "things-to-do";
    private static final String COLLECTION_RESTAURANT = "restaurant";
    private static final String COLLECTION_TOUR = "tour";
    private static final String COLLECTION_CITY = "city";


    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/point-type")
    public Response r(@QueryParam("x") String x, @QueryParam("y") String y, @QueryParam("dist") String dist,
                      @QueryParam("collection") List<String> collections,
                      @DefaultValue("0") @QueryParam("start") String start, @DefaultValue("10") @QueryParam("len") String len,
                      @DefaultValue("DSC") @QueryParam("rate") String order) {
        try {
            ObjectNode finalResult = ObjectMapperProvider.getObjectMapper().createObjectNode();
            List<String> availableCollections = new ArrayList<>(Arrays.asList(new String[]{COLLECTION_HOTEL, COLLECTION_THINGS_TO_DO, COLLECTION_RESTAURANT, COLLECTION_TOUR, COLLECTION_CITY}));
            if (collections != null && collections.size() != 0)
                collections.retainAll(availableCollections);
            else
                collections = availableCollections;

            if (StringUtils.isEmpty(x) && StringUtils.isEmpty(y)) {
                return Response.status(406).build();
            }

            paginationConverterForSearchAll(start, Integer.valueOf(len) * 2 + "");
            isManualSort = isManualSort("Rate", order);
            if (StringUtils.isEmpty(dist)) {
                dist = "3000";
            }
            for (String collection : collections) {
                String query = baseQueryMaker(find(nearby(x, y, dist)), collection, false);
                JsonNode executeQuery = getMongoDBManager().executeQuery(query);
                finalResult.put(collection, executeQuery);
            }
            return Response.ok(finalResult).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(400).build();
        }

    }
}
