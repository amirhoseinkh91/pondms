package ir.viratech.pond_ms.api.filter;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import ir.viratech.commons.persistence.mongo.base.MongoDBManager;
import ir.viratech.commons.util.jackson.JacksonUtils;
import ir.viratech.commons.util.jackson.ObjectMapperProvider;
import ir.viratech.pond_ms.commons.geo.Point;
import ir.viratech.pond_ms.core.i18n.MessageService;
import ir.viratech.pond_ms.core.ip.IPToGeoLocationConverter;
import ir.viratech.pond_ms.core.spring.ApplicationContextUtil;
import ir.viratech.pond_ms.model.gis_vector_object_new_model.GisVectorLayerToNewModel;
import ir.viratech.pond_ms.model.layer.Layer;
import ir.viratech.pond_ms.model.layer.ParentLayer;
import ir.viratech.pond_ms.model.layer.VectorLayer;
import ir.viratech.pond_ms.model.layer.logic.LayerMgr;
import ir.viratech.pond_ms.model.layer.logic.ParentLayerMgr;
import ir.viratech.pond_ms.model.map_object.vector.GISVectorObject;
import ir.viratech.pond_ms.model.map_object.vector.logic.GISVectorObjectMgr;
import org.apache.commons.lang3.StringUtils;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Path("/filter")
public class FilterService extends BaseMongoQueries {

    private static final String COLLECTION_HOTEL = "hotel";
    private static final String COLLECTION_THINGS_TO_DO = "things-to-do";
    private static final String COLLECTION_RESTAURANT = "restaurant";
    private static final String COLLECTION_TOUR = "tour";
    private static final String COLLECTION_CITY = "city";

    private static final String HOTEL = MessageService.getMessage("config.hotels");
    private static final String RESTAURANT = MessageService.getMessage("config.restaurants");
    private static final String THING_TO_DO = MessageService.getMessage("config.things");
    private static final String CITY_DETAIL = MessageService.getMessage("config.city");


    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("placeSearch")
    public JsonNode placeUid(@QueryParam("q") String q,
                             @DefaultValue("0") @QueryParam("start") String start,
                             @DefaultValue("10") @QueryParam("len") String len) {
        try {
            paginationConverter(start, len);
            isManualSort = isManualSort("Rate", "DSC");
            List<String> collections = new ArrayList<>(Arrays.asList(COLLECTION_HOTEL, COLLECTION_THINGS_TO_DO, COLLECTION_RESTAURANT, COLLECTION_CITY));
            ArrayNode response = ObjectMapperProvider.getObjectMapper().createArrayNode();
            for (String collection : collections) {
                String nameQuery = query(collection, null, null, null, null, null, null, q);
                JsonNode result = getMongoDBManager().executeQuery(nameQuery);
                if (!result.isNull()) {
                    for (JsonNode node : result) {
                        System.out.println(node.get("name"));
                        ObjectNode favoriteJson = JacksonUtils.createEmptyObjectNode();
                        if (!node.has("layer_uid")) {
                            continue;
                        }
                        String layer_uid = node.get("layer_uid").asText();
                        ParentLayer cityLayer = LayerMgr.getInstance().getByExtuid(layer_uid).getParentLayer();
                        ParentLayer provinceLayer = cityLayer.getParentLayer();
                        String jsonName = node.get("name").asText() + " " + COMMA + cityLayer.getName() + COMMA + " " + provinceLayer.getName();
                        favoriteJson.put("name", jsonName);
                        favoriteJson.put("UID", node.get("gis_object_uid"));
                        response.add(favoriteJson);
                    }
                }
            }
            return response;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JacksonUtils.createEmptyArrayNode();
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{cityName}")
    public JsonNode searchByName(
            @PathParam("cityName") String cityName, @QueryParam("collection") String collection,
            @QueryParam("start") String start, @QueryParam("len") String len, @QueryParam("sort") String sort, @QueryParam("order") String order) {
        try {

            if (!cityName.startsWith(MessageService.getMessage("city.space"))) {
                cityName = cityName.trim();
                cityName = MessageService.getMessage("city.space") + cityName;
            }

            if (!StringUtils.isEmpty(start) && !StringUtils.isEmpty(len))
                paginationConverter(start, len);
            else {
                paginationConverter("0", "10");
            }
            Map<String, String> city = FilterConfig.getCity(cityName);
            String hotel = city.get(HOTEL);
            String restaurant = city.get(RESTAURANT);
            String things = city.get(THING_TO_DO);
            String details = city.get(CITY_DETAIL);
            JsonNode node = JacksonUtils.createEmptyObjectNode();
            if (StringUtils.isEmpty(sort) && StringUtils.isEmpty(order))
                isManualSort = isManualSort("Rate", "DSC");
            else
                isManualSort = isManualSort(sort, order);
            MongoDBManager manager = MongoDBManager.getInstance();

            if (!StringUtils.isEmpty(collection)) {
                if (collection.equals(COLLECTION_CITY)) {
                    String cityDetail = baseQueryMaker(find(eq("layer_uid", details)), COLLECTION_CITY, false);
                    node = manager.executeQuery(cityDetail);
                }
                if (collection.equals(COLLECTION_HOTEL)) {
                    String cityHotel = baseQueryMaker(find(eq("layer_uid", hotel)), COLLECTION_HOTEL, false);
                    node = manager.executeQuery(cityHotel);
                }
                if (collection.equals(COLLECTION_THINGS_TO_DO)) {
                    String cityThingsToDo = baseQueryMaker(find(eq("layer_uid", things)), COLLECTION_THINGS_TO_DO, false);
                    node = manager.executeQuery(cityThingsToDo);
                }
                if (collection.equals(COLLECTION_RESTAURANT)) {
                    String cityRestaurant = baseQueryMaker(find(eq("layer_uid", restaurant)), COLLECTION_RESTAURANT, false);
                    node = manager.executeQuery(cityRestaurant);
                }
            }

            return node;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JacksonUtils.createEmptyObjectNode();

    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/place_detail")
    public JsonNode placeDetails(@QueryParam("placeUid") String objectUid) throws IllegalAccessException, InstantiationException, IOException {
        List<String> availableCollections = new ArrayList<>(Arrays.asList(COLLECTION_HOTEL, COLLECTION_THINGS_TO_DO, COLLECTION_RESTAURANT, COLLECTION_TOUR, COLLECTION_CITY));
        String lat = "";
        String lon = "";
        String radius = "2000";
        String type = "";
        if (!StringUtils.isEmpty(objectUid)) {
            String place = equals("gis_object_uid", objectUid);
            String point = multiple_Column_Filter("point", "_id");
            for (String collection : availableCollections) {
                String mapper = collectionMapper(collection);
                String finalQuery = appendQueries(place, point);
                String query = makeQuery(find(finalQuery), mapper) + DOT + toArray();
                JsonNode node = getMongoDBManager().executeQuery(query);
                if (node.size() >= 1) {
                    JsonNode pointNode = node.get(0);
                    JsonNode coordinates = pointNode.get("point").get("coordinates");
                    lon = coordinates.get(0).toString();
                    lat = coordinates.get(1).toString();
                    type = mapper;
                    break;
                }
            }
            String nearby = nearby(lat.substring(0, 5), lon.substring(0, 5), radius);
            String finalQuery = makeQuery(find(nearby), type) + DOT + toArray();

            JsonNode finalNode = getMongoDBManager().executeQuery(finalQuery);
            if (finalNode.size() >= 1)
                return finalNode;
        }
        return JacksonUtils.createEmptyObjectNode();
    }


    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/all")
    public JsonNode searchAllWithoutName(
            @QueryParam("tag") String tag, @QueryParam("rate") String rate, @QueryParam("x") String x,
            @QueryParam("y") String y, @QueryParam("dist") String dist, @QueryParam("layerUid") String layerUid,
            @QueryParam("start") String start, @QueryParam("len") String len, @QueryParam("sortBy") String sortBy,
            @QueryParam("order") String order, @DefaultValue("false") @QueryParam("searchByIp") boolean searchByIp,
            @QueryParam("collection") List<String> collectionsToSearch)

            throws InstantiationException, IllegalAccessException, IOException {
        return searchAll("", tag, rate, x, y, dist, layerUid, start, len, sortBy, order, searchByIp, collectionsToSearch);
    }


    private String getCollectionLayerUIDByUid(String uid, String type) {
        ParentLayer parentLayer = ParentLayerMgr.getInstance().getByExtuid(uid);
        String layerUid = "";
        if (parentLayer != null)
            switch (type) {
                case COLLECTION_CITY:
                    layerUid = fillMap(parentLayer, MessageService.getMessage("config.city"));
                    break;
                case COLLECTION_HOTEL:
                    layerUid = fillMap(parentLayer, MessageService.getMessage("config.hotels"));
                    break;
                case COLLECTION_RESTAURANT:
                    layerUid = fillMap(parentLayer, MessageService.getMessage("config.restaurants"));
                    break;
                case COLLECTION_THINGS_TO_DO:
                    layerUid = fillMap(parentLayer, MessageService.getMessage("config.things"));
                    break;
            }

        return layerUid;
    }

    private String fillMap(ParentLayer parentLayer, String collection) {
        String uid = "";
        for (Layer sublayer : parentLayer.getSubLayers()) {
            String name = sublayer.getName();
            uid = sublayer.getExtuid();
            if (name.equals(collection)) {
                return uid;
            }
        }
        return uid;
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/all/{name}")
    public JsonNode searchAll(@PathParam("name") String name,
                              @QueryParam("tag") String tag, @QueryParam("rate") String rate, @QueryParam("x") String x,
                              @QueryParam("y") String y, @QueryParam("dist") String dist, @QueryParam("layerUid") String layerUid,
                              @QueryParam("start") String start, @QueryParam("len") String len, @QueryParam("sortBy") String sortBy,
                              @QueryParam("order") String order, @DefaultValue("false") @QueryParam("searchByIp") boolean searchByIp,
                              @QueryParam("collection") List<String> collectionsToSearch)

            throws InstantiationException, IllegalAccessException, IOException {

        List<String> availableCollections = new ArrayList<>(Arrays.asList(COLLECTION_HOTEL, COLLECTION_THINGS_TO_DO, COLLECTION_RESTAURANT, COLLECTION_TOUR, COLLECTION_CITY));
        if (collectionsToSearch != null && collectionsToSearch.size() != 0)
            collectionsToSearch.retainAll(availableCollections);
        else
            collectionsToSearch = availableCollections;
        paginationConverterForSearchAll(start, len);
        MongoDBManager manager = MongoDBManager.getInstance();
        ArrayNode finalResult = JacksonUtils.createEmptyArrayNode();
        isManualSort = isManualSort(sortBy, order);
        for (String collection : collectionsToSearch) {
            String tagQuery = tag(tag, collection);
            if (tag != null && tagQuery == null)
                continue;
            if (dist != null && !COLLECTION_HOTEL.equals(collection) && !COLLECTION_THINGS_TO_DO.equals(collection) && !COLLECTION_RESTAURANT.equals(collection))
                continue;
            String query;
            if (searchByIp) {
                Point point = IPToGeoLocationConverter
                        .convertToPoint(ApplicationContextUtil.getCurrentExecutionContext().getIpAddress());
                query = query(collection, tag, rate, point.getJtsGeometry().getX() + "",
                        point.getJtsGeometry().getY() + "", dist, layerUid, name);
            } else {
                if (layerUid != null && !StringUtils.isEmpty(layerUid)) {
                    String tempLayerUid = "";
                    switch (collection) {
                        case COLLECTION_HOTEL:
                            tempLayerUid = getCollectionLayerUIDByUid(layerUid, COLLECTION_HOTEL);
                            break;
                        case COLLECTION_RESTAURANT:
                            tempLayerUid = getCollectionLayerUIDByUid(layerUid, COLLECTION_RESTAURANT);
                            break;
                        case COLLECTION_THINGS_TO_DO:
                            tempLayerUid = getCollectionLayerUIDByUid(layerUid, COLLECTION_THINGS_TO_DO);
                            break;
                        case COLLECTION_CITY:
                            tempLayerUid = getCollectionLayerUIDByUid(layerUid, COLLECTION_CITY);
                            break;
                    }
                    query = query(collection, tag, rate, x, y, dist, tempLayerUid, name);
                } else {
                    query = query(collection, tag, rate, x, y, dist, null, name);
                }
            }
            if (query == null) {
                continue;
            }
            JsonNode res = manager.executeQuery(query);
            for (int i = 0; i < res.size(); i++)
                finalResult.add(res.get(i));
        }
        return finalResult;
    }

    @GET
    @Path("/{collection}/items")
    public JsonNode filter(@PathParam("collection") String collection, @QueryParam("tag") String tag,
                           @QueryParam("rate") String rate, @QueryParam("x") String x, @QueryParam("y") String y,
                           @QueryParam("dist") String dist, @QueryParam("layerUid") String layerUid, @QueryParam("start") String start,
                           @QueryParam("len") String len, @QueryParam("sortBy") String sortBy, @QueryParam("order") String order,
                           @QueryParam("name") String name, @DefaultValue("false") @QueryParam("searchByIp") boolean searchByIp)
            throws IOException, InstantiationException, IllegalAccessException {

        String query = null;
        paginationConverter(start, len);
        isManualSort = isManualSort(sortBy, order);
        if (searchByIp) {
            Point point = IPToGeoLocationConverter.convertToPoint(ApplicationContextUtil.getCurrentExecutionContext().getIpAddress());
            query = query(collection, tag, rate, point.getJtsGeometry().getX() + "", point.getJtsGeometry().getY() + "", dist, layerUid, name);
        } else {
            query = query(collection, tag, rate, x, y, dist, layerUid, name);
        }
        if (query == null) {
            return JacksonUtils.createEmptyArrayNode();
        }
        JsonNode result = getMongoDBManager().executeQuery(query);
        if (collection.equals("hotel") && layerUid != null && !layerUid.equals("") && sortBy != null && sortBy.equals("price")) {
            String s = SortHotelsByPrice.hotelResultSortByPrice(result, order);
            result = JacksonUtils.convertStringToJsonNode(s);
        }
        return result;
    }

    @GET
    @Path("/city")
    public Response searchAllUsingCity(@QueryParam("cityName") String cityName, @QueryParam("layerUid") String uid,
                                       @QueryParam("rate") String order,
                                       @QueryParam("name") String name,
                                       @DefaultValue("0") @QueryParam("start") String start, @DefaultValue("10") @QueryParam("len") String len,
                                       @QueryParam("collection") List<String> collectionsToSearch) throws IOException {
        ArrayNode finalResult = JacksonUtils.createEmptyArrayNode();
        ObjectNode countNode = JacksonUtils.createEmptyObjectNode();
        ArrayNode responseNode = JacksonUtils.createEmptyArrayNode();

        if (!StringUtils.isEmpty(cityName) && !StringUtils.isEmpty(uid)) {
            return Response.status(400).build();
        }

        isManualSort = isManualSort("Rate", order);
        paginationConverter(start, len);

        collectionsToSearch = retainAllCollection(collectionsToSearch, Arrays.asList(COLLECTION_HOTEL, COLLECTION_THINGS_TO_DO, COLLECTION_RESTAURANT, COLLECTION_CITY));

        String tempLayerUID;
        String query;

        Map<String, String> city = null;

        if (!StringUtils.isEmpty(cityName)) {
            if (!cityName.startsWith(MessageService.getMessage("city.space"))) {
                cityName = MessageService.getMessage("city.space") + cityName.trim().replaceAll("\"", "");
            }
            city = FilterConfig.getCity(cityName);
        }

        for (String collection : collectionsToSearch) {
            ObjectNode convertTonItemsCount = JacksonUtils.createEmptyObjectNode();
            int count;
            switch (collection) {
                case COLLECTION_RESTAURANT:
                    if (city != null) {
                        tempLayerUID = city.get(RESTAURANT);
                    } else {
                        tempLayerUID = getCollectionLayerUIDByUid(uid, COLLECTION_RESTAURANT);
                    }

                    if (StringUtils.isEmpty(tempLayerUID)) {
                        return Response.status(400).build();
                    }
                    query = query(collection, null, null, null, null, null, tempLayerUID, name);
                    count = getMongoDBManager().executeQuery(replaceToArrayWithCount(query)).asInt();
                    convertTonItemsCount.put("totalCount", count);
                    convertTonItemsCount.put("items", runInMongoDbManagerAndMapToNewModel(query));
                    convertTonItemsCount.put("type", collection);
                    countNode.put(collection, count);
                    responseNode.add(convertTonItemsCount);
                    break;
                case COLLECTION_CITY:
                    if (city != null) {
                        tempLayerUID = city.get(CITY_DETAIL);
                    } else {
                        tempLayerUID = getCollectionLayerUIDByUid(uid, COLLECTION_CITY);
                    }
                    if (StringUtils.isEmpty(tempLayerUID)) {
                        return Response.status(400).build();
                    }
                    query = query(collection, null, null, null, null, null, tempLayerUID, name);
                    count = getMongoDBManager().executeQuery(replaceToArrayWithCount(query)).asInt();
                    convertTonItemsCount.put("totalCount", count);
                    convertTonItemsCount.put("items", runInMongoDbManagerAndMapToNewModel(query));
                    convertTonItemsCount.put("type", collection);
                    countNode.put(collection, count);
                    responseNode.add(convertTonItemsCount);
                    break;
                case COLLECTION_THINGS_TO_DO:
                    if (city != null) {
                        tempLayerUID = city.get(THING_TO_DO);
                    } else {
                        tempLayerUID = getCollectionLayerUIDByUid(uid, COLLECTION_THINGS_TO_DO);
                    }
                    if (StringUtils.isEmpty(tempLayerUID)) {
                        return Response.status(400).build();
                    }
                    query = query(collection, null, null, null, null, null, tempLayerUID, name);
                    count = getMongoDBManager().executeQuery(replaceToArrayWithCount(query)).asInt();
                    convertTonItemsCount.put("totalCount", count);
                    convertTonItemsCount.put("items", runInMongoDbManagerAndMapToNewModel(query));
                    convertTonItemsCount.put("type", collection);
                    countNode.put(collection, count);
                    responseNode.add(convertTonItemsCount);
                    break;
                case COLLECTION_HOTEL:
                    if (city != null) {
                        tempLayerUID = city.get(HOTEL);
                    } else {
                        tempLayerUID = getCollectionLayerUIDByUid(uid, COLLECTION_HOTEL);
                    }
                    if (StringUtils.isEmpty(tempLayerUID)) {
                        return Response.status(400).build();
                    }
                    query = query(collection, null, null, null, null, null, tempLayerUID, name);
                    count = getMongoDBManager().executeQuery(replaceToArrayWithCount(query)).asInt();
                    convertTonItemsCount.put("totalCount", count);
                    convertTonItemsCount.put("items", runInMongoDbManagerAndMapToNewModel(query));
                    convertTonItemsCount.put("type", collection);
                    countNode.put(collection, count);
                    responseNode.add(convertTonItemsCount);
                    break;
            }
        }

        finalResult.add(countNode);
        finalResult.add(responseNode);
        return Response.ok(finalResult).build();
    }

    private List<String> retainAllCollection(@QueryParam("collection") List<String> collectionsToSearch, List<String> strings) {
        List<String> availableCollections = new ArrayList<>(strings);
        if (collectionsToSearch != null && collectionsToSearch.size() != 0)
            collectionsToSearch.retainAll(availableCollections);
        else
            collectionsToSearch = availableCollections;
        return collectionsToSearch;
    }


    @GET
    @Path("/point")
    public JsonNode searchAllByPoint(@QueryParam("x") String x, @QueryParam("y") String y, @DefaultValue("3000") @QueryParam("dist") String dist,
                                     @QueryParam("rate") String order,
                                     @QueryParam("name") String name,
                                     @DefaultValue("0") @QueryParam("start") String start, @DefaultValue("10") @QueryParam("len") String len,
                                     @QueryParam("collection") List<String> collectionsToSearch) throws IOException {
        isManualSort = isManualSort("Rate", order);
        paginationConverter(start, len);
        collectionsToSearch = retainAllCollection(collectionsToSearch, Arrays.asList(COLLECTION_HOTEL, COLLECTION_THINGS_TO_DO, COLLECTION_RESTAURANT));

        String query;
        ArrayNode finalResult = JacksonUtils.createEmptyArrayNode();
        ObjectNode countNode = JacksonUtils.createEmptyObjectNode();
        ArrayNode responseNode = JacksonUtils.createEmptyArrayNode();
        int count;
        for (String collection : collectionsToSearch) {
            switch (collection) {
                case COLLECTION_RESTAURANT:
                    query = query(collection, null, null, x, y, dist, null, name);
                    responseNode.add(freeModeQueryBodyInSwitchCase(query, collection));
                    count = getMongoDBManager().executeQuery(query.replaceAll("toArray", "count")).asInt();
                    countNode.put(collection, count);
                    break;
                case COLLECTION_THINGS_TO_DO:
                    query = query(collection, null, null, x, y, dist, null, name);
                    responseNode.add(freeModeQueryBodyInSwitchCase(query, collection));
                    count = getMongoDBManager().executeQuery(query.replaceAll("toArray", "count")).asInt();
                    countNode.put(collection, count);
                    break;
                case COLLECTION_HOTEL:
                    query = query(collection, null, null, x, y, dist, null, name);
                    responseNode.add(freeModeQueryBodyInSwitchCase(query, collection));
                    count = getMongoDBManager().executeQuery(query.replaceAll("toArray", "count")).asInt();
                    countNode.put(collection, count);
                    break;
            }
        }
        finalResult.add(countNode);
        finalResult.add(responseNode);
        return finalResult;

    }

    @GET
    @Path("/free-mode")
    public JsonNode searchAllWithoutPointAndCity(@QueryParam("rate") String order,
                                                 @QueryParam("name") String name,
                                                 @DefaultValue("0") @QueryParam("start") String start, @DefaultValue("10") @QueryParam("len") String len,
                                                 @QueryParam("collection") List<String> collectionsToSearch) throws IOException {
        if (!StringUtils.isEmpty(name)) {
            if (name.length() < 2) {
                return JacksonUtils.createEmptyArrayNode();
            }
        }
        isManualSort = isManualSort("Rate", order);
        paginationConverter(start, len);
        collectionsToSearch = retainAllCollection(collectionsToSearch, Arrays.asList(COLLECTION_HOTEL, COLLECTION_THINGS_TO_DO, COLLECTION_RESTAURANT, COLLECTION_CITY));

        ArrayNode finalResult = JacksonUtils.createEmptyArrayNode();
        ObjectNode countNode = JacksonUtils.createEmptyObjectNode();
        ArrayNode responseNode = JacksonUtils.createEmptyArrayNode();
        String query;
        int count;
        for (String collection : collectionsToSearch) {
            switch (collection) {
                case COLLECTION_RESTAURANT:
                    query = query(collection, null, null, null, null, null, null, name);
                    responseNode.add(freeModeQueryBodyInSwitchCase(query, collection));
                    count = getMongoDBManager().executeQuery(query.replaceAll("toArray", "count")).asInt();
                    countNode.put(collection, count);
                    break;
                case COLLECTION_CITY:
                    query = query(collection, null, null, null, null, null, null, name);
                    responseNode.add(freeModeQueryBodyInSwitchCase(query, collection));
                    count = getMongoDBManager().executeQuery(query.replaceAll("toArray", "count")).asInt();
                    countNode.put(collection, count);
                    break;
                case COLLECTION_THINGS_TO_DO:
                    query = query(collection, null, null, null, null, null, null, name);
                    responseNode.add(freeModeQueryBodyInSwitchCase(query, collection));
                    count = getMongoDBManager().executeQuery(query.replaceAll("toArray", "count")).asInt();
                    countNode.put(collection, count);
                    break;
                case COLLECTION_HOTEL:
                    query = query(collection, null, null, null, null, null, null, name);
                    responseNode.add(freeModeQueryBodyInSwitchCase(query, collection));
                    count = getMongoDBManager().executeQuery(query.replaceAll("toArray", "count")).asInt();
                    countNode.put(collection, count);
                    break;
            }
        }
        finalResult.add(countNode);
        finalResult.add(responseNode);
        return finalResult;

    }

    @GET
    @Path("/collection")
    public Response searchAllByCollection(@QueryParam("layerUid") String uid, @QueryParam("collection") String collection,
                                          @QueryParam("rate") String order,
                                          @QueryParam("name") String name,
                                          @DefaultValue("0") @QueryParam("start") String start, @DefaultValue("10") @QueryParam("len") String len) throws IOException {
        isManualSort = isManualSort("Rate", order);
        paginationConverter(start, len);
        List<String> availableCollections = new ArrayList<>(Arrays.asList(COLLECTION_HOTEL, COLLECTION_THINGS_TO_DO, COLLECTION_RESTAURANT, COLLECTION_CITY));
        List<String> collectionsToSearch = new ArrayList<>(Arrays.asList(collection));
        if (collectionsToSearch != null && collectionsToSearch.size() != 0)
            collectionsToSearch.retainAll(availableCollections);
        else
            collectionsToSearch = availableCollections;

        String tempLayerUid = "";
        ArrayNode finalResult = JacksonUtils.createEmptyArrayNode();
        ObjectNode countNode = JacksonUtils.createEmptyObjectNode();
        ArrayNode responseNode = JacksonUtils.createEmptyArrayNode();
        String query = "";

        for (String coll : collectionsToSearch) {
            JsonNode node;
            int count;
            switch (coll) {
                case COLLECTION_RESTAURANT:
                    tempLayerUid = getCollectionLayerUIDByUid(uid, COLLECTION_RESTAURANT);
                    if (StringUtils.isEmpty(tempLayerUid))
                        return Response.status(400).build();
                    query = query(collection, null, null, null, null, null, tempLayerUid, name);
                    count = getMongoDBManager().executeQuery(query.replaceAll("toArray", "count")).asInt();
                    node = runInMongoDbManagerAndMapToNewModel(query);
                    if (node.size() > 0) {
                        responseNode.add(node);
                        countNode.put(collection, count);
                    }
                    break;
                case COLLECTION_THINGS_TO_DO:
                    tempLayerUid = getCollectionLayerUIDByUid(uid, COLLECTION_THINGS_TO_DO);
                    if (StringUtils.isEmpty(tempLayerUid))
                        return Response.status(400).build();
                    query = query(collection, null, null, null, null, null, tempLayerUid, name);
                    count = getMongoDBManager().executeQuery(query.replaceAll("toArray", "count")).asInt();
                    node = runInMongoDbManagerAndMapToNewModel(query);
                    if (node.size() > 0) {
                        responseNode.add(node);
                        countNode.put(collection, count);
                    }
                    break;
                case COLLECTION_HOTEL:
                    tempLayerUid = getCollectionLayerUIDByUid(uid, COLLECTION_HOTEL);
                    if (StringUtils.isEmpty(tempLayerUid))
                        return Response.status(400).build();
                    query = query(collection, null, null, null, null, null, tempLayerUid, name);
                    count = getMongoDBManager().executeQuery(query.replaceAll("toArray", "count")).asInt();
                    node = runInMongoDbManagerAndMapToNewModel(query);
                    if (node.size() > 0) {
                        responseNode.add(node);
                        countNode.put(collection, count);
                    }
                    break;
            }
        }
        finalResult.add(countNode);
        finalResult.add(responseNode);
        return Response.ok(finalResult).build();
    }

    private String query(String collection, String tag, String rate, String x, String y, String dist, String layerUid, String name) {
        String query = null;

        try {
            switch (intValueOfCLientRequest(collection, tag, rate, x, y, dist, layerUid, name)) {
                case onlyName:
                    query = queryMaker_name(collection, name);
                    break;
                case tagAndName:
                    query = queryMaker_tagAndName(collection, tag, name);
                    break;
                case cityAndName:
                    query = queryMaker_cityAndName(collection, layerUid, name);
                    break;
                case nearbyAndName:
                    query = queryMaker_nearbyAndName(collection, x, y, dist, name);
                    break;
                case rateAndName:
                    query = queryMaker_rateAndName(collection, rate, name);
                    break;
                case tagAndRateAndName:
                    query = queryMaker_tagAndRateAndName(collection, tag, rate, name);
                    break;
                case tagAndNearbyAndName:
                    query = queryMaker_tagAndNearbyAndName(collection, tag, x, y, dist, name);
                    break;
                case tagAndcityAndName:
                    query = queryMaker_tagAndcityAndName(collection, tag, layerUid, name);
                    break;
                case cityAndRateAndName:
                    query = queryMaker_cityAndRateAndName(collection, layerUid, rate, name);
                    break;
                case nearbyAndRateAndName:
                    query = queryMaker_nearbyAndRateAndName(collection, x, y, dist, rate, name);
                    break;
                case nearbyAndRateAndTagAndName:
                    query = queryMaker_nearbyAndRateAndTagAndName(collection, x, y, dist, rate, tag, name);
                    break;
                case onlyNearby:
                    query = queryMaker_nearby(collection, x, y, dist);
                    break;
                case onlyTag:
                    query = queryMaker_tag(collection, tag);
                    break;
                case onlyCity:
                    query = queryMaker_city(collection, layerUid);
                    break;
                case onlyRate:
                    query = queryMaker_rate(collection, rate);
                    break;
                case nearbyAndTag:
                    query = queryMaker_nearbyAndTag(collection, x, y, dist, tag);
                    break;
                case tagAndRate:
                    query = queryMaker_tagAndRate(collection, tag, rate);
                    break;
                case nearbyAndRate:
                    query = queryMaker_nearbyAndRate(collection, rate, x, y, dist);
                    break;
                case tagAndCity:
                    query = queryMaker_tagAndCity(collection, tag, layerUid);
                    break;
                case rateAndCity:
                    query = queryMaker_rateAndCity(collection, rate, layerUid);
                    break;
                case tagAndRateAndNearby:
                    query = queryMaker_tagAndRateAndNearby(collection, tag, rate, x, y, dist);
                    break;
                case tagAndRateAndCity:
                    query = queryMaker_tagAndRateAndCity(collection, tag, rate, layerUid);
                    break;
                case noFilter:
                    query = queryMaker_noFilter(collection);
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
            query = null;
        }
        return query;
    }

    private String queryMaker_name(String collection, String name)
            throws InstantiationException, IllegalAccessException {
        return baseQueryMaker(find(and(regex("name", name), isDeleted(false))), collection, true);
    }

    private String queryMaker_nearbyAndRateAndTagAndName(String collection, String x, String y, String dist,
                                                         String rate, String tag, String name) throws InstantiationException, IllegalAccessException {
        return baseQueryMaker(
                find(and(nearby(x, y, dist), rate(collection, rate), tag(tag, collection), regex("name", name), isDeleted(false))),
                collection, false);
    }

    private String queryMaker_nearbyAndRateAndName(String collection, String x, String y, String dist, String rate,
                                                   String name) throws InstantiationException, IllegalAccessException {
        return baseQueryMaker(
                find(and(nearby(x, y, dist), rate(collection, rate), regex("name", name), isDeleted(false))),
                collection, false);
    }

    private String queryMaker_cityAndRateAndName(String collection, String layerUid, String rate, String name)
            throws InstantiationException, IllegalAccessException {
        return baseQueryMaker(
                find(and(layerUid(layerUid), rate(collection, rate), regex("name", name), isDeleted(false))),
                collection, true);
    }

    private String queryMaker_tagAndcityAndName(String collection, String tag, String layerUid, String name)
            throws InstantiationException, IllegalAccessException {
        return baseQueryMaker(find(and(tag(tag, collection), layerUid(layerUid), regex("name", name), isDeleted(false))),
                collection, true);
    }

    private String queryMaker_tagAndNearbyAndName(String collection, String tag, String x, String y, String dist,
                                                  String name) throws InstantiationException, IllegalAccessException {
        return baseQueryMaker(find(and(tag(tag, collection), nearby(x, y, dist), regex("name", name), isDeleted(false))),
                collection, true);
    }

    private String queryMaker_tagAndRateAndName(String collection, String tag, String rate, String name)
            throws InstantiationException, IllegalAccessException {
        return baseQueryMaker(find(and(tag(tag, collection), rate(collection, rate), regex("name", name), isDeleted(false))),
                collection, true);
    }

    private String queryMaker_rateAndName(String collection, String rate, String name)
            throws InstantiationException, IllegalAccessException {
        return baseQueryMaker(find(and(rate(collection, rate), regex("name", name), isDeleted(false))), collection,
                true);
    }

    private String queryMaker_nearbyAndName(String collection, String x, String y, String dist, String name)
            throws InstantiationException, IllegalAccessException {
        return baseQueryMaker(find(and(nearby(x, y, dist), regex("name", name), isDeleted(false))), collection, false);
    }

    private String queryMaker_cityAndName(String collection, String layerUid, String name)
            throws InstantiationException, IllegalAccessException {
        return baseQueryMaker(find(and(layerUid(layerUid), regex("name", name), isDeleted(false))), collection, true);
    }

    private String queryMaker_tagAndName(String collection, String tag, String name)
            throws InstantiationException, IllegalAccessException {
        return baseQueryMaker(find(and(tag(tag, collection), regex("name", name), isDeleted(false))), collection, true);
    }

    private String queryMaker_tagAndRateAndCity(String collection, String tag, String rate, String layerUid)
            throws InstantiationException, IllegalAccessException {
        return baseQueryMaker(find(and(tag(tag, collection), rate(collection, rate), layerUid(layerUid), isDeleted(false))),
                collection, true);
    }

    private String queryMaker_rateAndCity(String collection, String rate, String layerUid)
            throws InstantiationException, IllegalAccessException {
        return baseQueryMaker(find(and(rate(collection, rate), layerUid(layerUid), isDeleted(false))), collection,
                true);
    }

    private String queryMaker_tagAndCity(String collection, String tag, String layerUid)
            throws InstantiationException, IllegalAccessException {

        return baseQueryMaker(find(and(tag(tag, collection), layerUid(layerUid), isDeleted(false))), collection, true);
    }

    private String queryMaker_city(String collection, String layerUid)
            throws InstantiationException, IllegalAccessException {
        return baseQueryMaker(find(and(layerUid(layerUid), isDeleted(false))), collection, true);
    }

    private String queryMaker_nearby(String collection, String x, String y, String dist)
            throws InstantiationException, IllegalAccessException {
        return baseQueryMaker(find(and(nearby(x, y, dist), isDeleted(false))), collection, false);
    }

    private String queryMaker_tag(String collection, String tag) throws
            InstantiationException, IllegalAccessException {
        return baseQueryMaker(find(and(tag(tag, collection), isDeleted(false))), collection, true);

    }

    private String queryMaker_rate(String collection, String rate)
            throws InstantiationException, IllegalAccessException {
        return baseQueryMaker(find(and(rate(collection, rate), isDeleted(false))), collection, true);
    }

    private String queryMaker_tagAndRate(String collection, String tag, String rate)
            throws InstantiationException, IllegalAccessException {
        return baseQueryMaker(find(and(rate(collection, rate), tag(tag, collection), isDeleted(false))), collection, true);
    }

    private String queryMaker_nearbyAndTag(String collection, String x, String y, String dist, String tag)
            throws InstantiationException, IllegalAccessException {
        return baseQueryMaker(find(and(tag(tag, collection), nearby(x, y, dist), isDeleted(false))), collection, false);
    }

    private String queryMaker_nearbyAndRate(String collection, String rate, String x, String y, String dist)
            throws InstantiationException, IllegalAccessException {
        return baseQueryMaker(find(and(rate(collection, rate), nearby(x, y, dist), isDeleted(false))), collection,
                false);
    }

    private String queryMaker_tagAndRateAndNearby(String collection, String tag, String rate, String x, String y,
                                                  String dist) throws InstantiationException, IllegalAccessException {
        return baseQueryMaker(find(and(rate(collection, rate), tag(tag, collection), nearby(x, y, dist), isDeleted(false))),
                collection, false);
    }

    private String queryMaker_noFilter(String collection) throws InstantiationException, IllegalAccessException {
        return baseQueryMaker(find(and(isDeleted(false))), collection, true);
    }


    @SuppressWarnings("static-access")
    private int intValueOfCLientRequest(String collection, String tag, String rate, String x, String y, String
            dist,
                                        String layerUid, String name) {

        boolean onlyName = tag == null && rate == null && x == null && y == null && dist == null
                && layerUid == null && name != null;
        boolean onlyNearby = tag == null && rate == null && x != null && y != null && dist != null
                && layerUid == null && name == null;
        boolean onlyTag = tag != null && rate == null && x == null && y == null && dist == null
                && layerUid == null && name == null;
        boolean onlyRate = tag == null && rate != null && x == null && y == null && dist == null
                && layerUid == null && name == null;
        boolean onlyCity = tag == null && rate == null && x == null && y == null && dist == null
                && layerUid != null && name == null;

        boolean tagAndName = tag != null && rate == null && x == null && y == null && dist == null
                && layerUid == null && name != null;
        boolean cityAndName = tag == null && rate == null && x == null && y == null && dist == null
                && layerUid != null && name != null;
        boolean nearbyAndName = tag == null && rate == null && x != null && y != null && dist != null
                && layerUid == null && name != null;
        boolean rateAndName = tag == null && rate != null && x == null && y == null && dist == null
                && layerUid == null && name != null;


        boolean tagAndRateAndName = tag != null && rate != null && x == null && y == null && dist == null
                && layerUid == null && name != null;
        boolean tagAndNearbyAndName = tag != null && rate == null && x != null && y != null && dist != null
                && layerUid == null && name != null;
        boolean tagAndcityAndName = tag != null && rate == null && x == null && y == null && dist == null
                && layerUid != null && name != null;
        boolean cityAndRateAndName = tag == null && rate != null && x == null && y == null && dist == null
                && layerUid != null && name != null;
        boolean nearbyAndRateAndName = tag == null && rate != null && x != null && y != null && dist != null
                && layerUid == null && name != null;

        boolean nearbyAndRateAndTagAndName = tag != null && rate != null && x != null && y != null && dist != null
                && layerUid == null && name != null;

        boolean tagAndCity = tag != null && rate == null && x == null && y == null && dist == null
                && layerUid != null && name == null;
        boolean rateAndCity = tag == null && rate != null && x == null && y == null && dist == null
                && layerUid != null && name == null;
        boolean nearbyAndTag = tag != null && rate == null && x != null && y != null && dist != null
                && layerUid == null && name == null;
        boolean tagAndRate = tag != null && rate != null && x == null && y == null && dist == null
                && layerUid == null && name == null;
        boolean nearbyAndRate = tag == null && rate != null && x != null && y != null && dist != null
                && layerUid == null && name == null;

        boolean tagAndRateAndCity = tag != null && rate != null && x == null && y == null && dist == null
                && layerUid != null && name == null;
        boolean tagAndRateAndNearby = tag != null && rate != null && x != null && y != null && dist != null
                && layerUid == null && name == null;

        boolean noFilter = tag == null && rate == null && x == null && y == null && dist == null
                && layerUid == null && name == null;

        try {
            if (onlyName)
                return this.onlyName;
            else if (tagAndName)
                return this.tagAndName;
            else if (cityAndName)
                return this.cityAndName;
            else if (nearbyAndName)
                return this.nearbyAndName;
            else if (rateAndName)
                return this.rateAndName;
            else if (tagAndRateAndName)
                return this.tagAndRateAndCity;
            else if (tagAndNearbyAndName)
                return this.tagAndNearbyAndName;
            else if (tagAndcityAndName)
                return this.tagAndcityAndName;
            else if (cityAndRateAndName)
                return this.cityAndRateAndName;
            else if (nearbyAndRateAndName)
                return this.nearbyAndRateAndName;
            else if (nearbyAndRateAndTagAndName)
                return this.nearbyAndRateAndTagAndName;
            else if (onlyNearby)
                return this.onlyNearby;
            else if (onlyTag)
                return this.onlyTag;
            else if (onlyCity)
                return this.onlyCity;
            else if (onlyRate)
                return this.onlyRate;
            else if (nearbyAndTag)
                return this.nearbyAndTag;
            else if (tagAndRate)
                return this.tagAndRate;
            else if (nearbyAndRate)
                return this.nearbyAndRate;
            else if (tagAndCity)
                return this.tagAndCity;
            else if (rateAndCity)
                return this.rateAndCity;
            else if (tagAndRateAndNearby)
                return this.tagAndRateAndNearby;
            else if (tagAndRateAndCity)
                return this.tagAndRateAndCity;
            else if (noFilter)
                return this.noFilter;
        } catch (Exception e) {
            return this.noFilter;
        }
        return this.noFilter;
    }

    private JsonNode runInMongoDbManagerAndMapToNewModel(String query) throws
            IOException {
        JsonNode node = getMongoDBManager().executeQuery(query);
        return GisVectorLayerToNewModel.mapperToNewModel(node);
    }

    private JsonNode freeModeQueryBodyInSwitchCase(String query, String collection) throws IOException {
        ObjectNode newModelWithCount = JacksonUtils.createEmptyObjectNode();
        JsonNode jsonNode = runInMongoDbManagerAndMapToNewModel(query);
        if (collection.equals(COLLECTION_CITY) && jsonNode != null && jsonNode.size() > 0) {
            String uid = jsonNode.get(0).get("uid").textValue();
            GISVectorObject vectorObject = GISVectorObjectMgr.getInstance().getByExtuid(uid);
            VectorLayer layer = vectorObject.getLayer();
            String extuid = layer.getParentLayer().getExtuid();
            ((ObjectNode) jsonNode.get(0)).put("uid", extuid);
        }
        newModelWithCount.put("totalCount", (getMongoDBManager().executeQuery(replaceToArrayWithCount(query))).asInt());
        newModelWithCount.put("items", jsonNode);
        newModelWithCount.put("type", collection);
        return newModelWithCount;
    }

    private String replaceToArrayWithCount(String toArrayQuery) {
        return toArrayQuery.replaceAll("toArray()", "count");
    }
}
