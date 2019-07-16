package ir.viratech.pond_ms.api.filter;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import ir.viratech.commons.util.jackson.JacksonUtils;
import ir.viratech.commons.util.jackson.ObjectMapperProvider;
import ir.viratech.pond_ms.api.main_city_config.MainCityConfigService;
import ir.viratech.pond_ms.api.main_city_config.MakePointParam;
import ir.viratech.pond_ms.api.main_city_config.dto.ConfigDTO;
import ir.viratech.pond_ms.core.i18n.MessageService;
import ir.viratech.pond_ms.model.gis_vector_object_new_model.GisVectorLayerToNewModel;
import ir.viratech.pond_ms.model.layer.Layer;
import ir.viratech.pond_ms.model.layer.ParentLayer;
import ir.viratech.pond_ms.model.layer.logic.LayerMgr;
import ir.viratech.pond_ms.model.layer.logic.ParentLayerMgr;
import ir.viratech.pond_ms.model.main_city_config.ChildCityConfig;
import org.apache.commons.lang3.StringUtils;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Path("/layerId")
public class VectorObjectProvider extends BaseMongoQueries {

    private static final String COLLECTION_HOTEL = "hotel";
    private static final String COLLECTION_THINGS_TO_DO = "things-to-do";
    private static final String COLLECTION_RESTAURANT = "restaurant";

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/city")
    public JsonNode getLayer(@QueryParam("cityName") String cityName
            , @QueryParam("cityUid") String cityUid
            , @QueryParam("type") String type) {

        if (!StringUtils.isEmpty(cityName)) {
            if (!cityName.startsWith(MessageService.getMessage("city.space"))) {
                String trim = cityName.trim();
                cityName = trim.replaceAll("\"", "");
                cityName = MessageService.getMessage("city.space") + cityName;
            }
        }

        Map<String, String> city = ChildCityConfig.getCity(cityName, cityUid);
        ObjectNode finalUid = ObjectMapperProvider.getObjectMapper().createObjectNode();
        String col = "mainCity";
        String uID = "";


        if (type != null && !type.equals("") && !StringUtils.isEmpty(type)) {
            String collection = collectionMapper(type);

            switch (collection) {
                case CITY_COLLECTION:
                    col = "city";
                    uID = city.get(MessageService.getMessage("config.city"));
                    break;
                case HOTEL_COLLECTION:
                    col = "hotel";
                    uID = city.get(MessageService.getMessage("config.hotels"));
                    break;
                case THINGS_TO_DO_COLLECTION:
                    col = "things-to-do";
                    uID = city.get(MessageService.getMessage("config.things"));
                    break;
                case RESTAURANT_COLLECTION:
                    col = "restaurant";
                    uID = city.get(MessageService.getMessage("config.restaurants"));
                    break;
            }

        } else {
            ParentLayer parentLayer = ParentLayerMgr.getInstance().getByCityName(cityName);
            uID = parentLayer.getExtuid();
        }


        return finalUid.put(col, uID);
    }


    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/Point")
    public JsonNode getPoint(@QueryParam("uid") String uid) {
        List<String> availableCollections = new ArrayList<>(Arrays.asList(COLLECTION_HOTEL, COLLECTION_THINGS_TO_DO, COLLECTION_RESTAURANT));

        paginationConverter("0", "10");
        JsonNode node = makePlaceJsonNodeBaseOnCollection(availableCollections, uid);

        if (node.get(0).has("point")) {
            ((ObjectNode) node.get(0)).put("NearBy", makeNearbiesWithPointOnCollections(availableCollections
                    , uid, makePointParamWithDoubleCoordinates(node.get(0).get("point"))));
            JsonNode placeDetail = GisVectorLayerToNewModel.mapperToNewModel(node).get(0);

            ((ObjectNode) placeDetail).put("cityUid"
                    , getCityUid(node.get(0).get("layer_uid").asText()));

            ArrayNode simillarPlaces = makeSimilarPlaces(
                    makeConfigDTO(makeTagsArrayListWithJsonNode(placeDetail.get("tags"))
                    , getCityUid(node.get(0).get("layer_uid").asText())
                            , makeCollectionWithType(node.get(0).get("__type").asText())));

            if (simillarPlaces != null && simillarPlaces.size() > 0) {
                ((ObjectNode) placeDetail).put("similarPlaces", simillarPlaces.get(0));
            }
            return placeDetail;
        } else {
            return JacksonUtils.createEmptyObjectNode();
        }
    }

    private ArrayList<String> makeTagsArrayListWithJsonNode(JsonNode tagsNode){
        ArrayList<String> tags = new ArrayList<>();
        for (int i = 0; i < tagsNode.size(); i++){
            tags.add(tagsNode.get(i).asText());
        }
        return tags;
    }

    private String getCityUid(String uid) {
        Layer subLayer = LayerMgr.getInstance().getByExtuid(uid);
        ParentLayer parentLayer = subLayer.getParentLayer();
        return parentLayer.getExtuid();
    }

    private ArrayNode makeSimilarPlaces(ConfigDTO configDTO) {
        try {
            ConfigDTO[] configDTOS = new ConfigDTO[1];
            configDTOS[0] = configDTO;
            JsonNode modelMapper = MainCityConfigService
                    .makeArrayNodeWithConfigDTOList(configDTOS, ""
                            , configDTO.getFilter().getCityUid(), new MakePointParam());
            return MainCityConfigService.convertItemsToNewModel(modelMapper);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return JacksonUtils.createEmptyArrayNode();
    }


    private ConfigDTO makeConfigDTO(ArrayList<String> tags, String cityUid, String type) {
        ConfigDTO configDTO = new ConfigDTO();
        configDTO.setName("محل های مشابه");
        configDTO.setType(type);
        configDTO.setVisitPage(0);
        ConfigDTO.Filter filter = new ConfigDTO.Filter();
        filter.setCityUid(cityUid);
        filter.setTags(tags);
        configDTO.setFilter(filter);
        return configDTO;
    }


    private JsonNode makePlaceJsonNodeBaseOnCollection(List<String> availableCollections, String uid) {

        JsonNode node = JacksonUtils.createEmptyObjectNode();

        for (String collection : availableCollections) {
            try {
                String queryMaker = makeQuery(find(eq("gis_object_uid", "\'" + uid + "\'")), collectionMapper(collection));
                String withoutSort = executableQueryWithoutSort(queryMaker);
                node = getMongoDBManager().executeQuery(withoutSort);
                if (node.size() > 0) {
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return node;
    }

    private ArrayList<String> makePointParamWithDoubleCoordinates(JsonNode point) {
        ArrayList<String> coordinatesArray = new ArrayList<>();
        if (point.has("coordinates")) {
            JsonNode coordinates = point.get("coordinates");
            coordinatesArray.add(coordinates.get(1).asText());
            coordinatesArray.add(coordinates.get(0).asText());
        }
        return coordinatesArray;
    }


    private JsonNode makeNearbiesWithPointOnCollections(List<String> availableCollections, String uid, ArrayList<String> point) {
        ObjectNode objectNode = ObjectMapperProvider.getObjectMapper().createObjectNode();

        try {
            for (String collection : availableCollections) {
                String makeQuery = makeQuery(find(makeNearbyQuery(point)), collectionMapper(collection));
                String withoutSort = executableQueryWithoutSort(makeQuery);
                JsonNode executeQuery = getMongoDBManager().executeQuery(withoutSort);
                ArrayNode internalObject = ObjectMapperProvider.getObjectMapper().createArrayNode();
                for (JsonNode internalNode : executeQuery) {
                    if (internalNode.has("gis_object_uid") && internalNode.get("gis_object_uid").asText().equals(uid))
                        continue;
                    internalObject.add(internalNode);
                }
                if (internalObject.size() > 0) {
                    objectNode.put(collection, internalObject);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return objectNode;
    }

    private String makeNearbyQuery(ArrayList<String> point) {
        return nearby(point.get(0), point.get(1), "2000");
    }

    private String makeCollectionWithType(String type){
        String collection = "";
        switch (type){
            case "Things_To_Do":
                collection = "things-to-do";
                break;
            case "Restaurant":
                collection = "restaurant";
                break;
            case "Hotel":
                collection = "hotel";
                break;
        }
        return collection;
    }
}


