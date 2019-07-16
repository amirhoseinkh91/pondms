package ir.viratech.pond_ms.api.main_city_config;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import ir.viratech.commons.util.jackson.JacksonUtils;
import ir.viratech.commons.util.jackson.ObjectMapperProvider;
import ir.viratech.pond_ms.api.filter.BaseMongoQueries;
import ir.viratech.pond_ms.api.filter.SortHotelsByPrice;
import ir.viratech.pond_ms.api.main_city_config.dto.ConfigDTO;
import ir.viratech.pond_ms.api.main_city_config.dto.ConfigFileModel;
import ir.viratech.pond_ms.api.things_to_do.ThingsToDoTagsMapper;
import ir.viratech.pond_ms.model.gis_vector_object_new_model.GisVectorLayerToNewModel;
import ir.viratech.pond_ms.model.main_city_config.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

@Path("/new-config")
public class MainCityConfigService {

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/main/mainPage")
    public static JsonNode getMainFromUi(@QueryParam("cityName") String cityName
            , @QueryParam("cityUid") String cityUid
            , @BeanParam MakePointParam point) {

        try {

            ConfigFileModel model = new ConfigFileModel(cityName , cityUid , "" , point);
            ConfigDTO[] dtoList = makeDTOListFromModel(model);
            return convertItemsToNewModel(newSeeMoreTagModel((ArrayNode)
                    makeArrayNodeWithConfigDTOList(dtoList, cityName, cityUid, point)));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return JacksonUtils.createEmptyArrayNode();
    }


    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{collection}/mainPage")
    public static JsonNode getMainWithCollection(@PathParam("collection") String collection
            , @QueryParam("cityUid") String cityUid
            , @QueryParam("cityName") String cityName
            , @QueryParam("collectionLayerId") String collectionLayerUid
            , @BeanParam MakePointParam point ) {

        try {
            ConfigFileModel model = new ConfigFileModel(cityName , cityUid , collection , point);
            ConfigDTO[] dtoList = makeDTOListFromModel(model);
            return convertItemsToNewModel(newSeeMoreTagModel((ArrayNode) makeArrayNodeWithConfigDTOList(dtoList, cityName, cityUid, point)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JacksonUtils.createEmptyArrayNode();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/main/seeMore")
    public static JsonNode getSeeMore(@RequestBody ConfigDTO dto, @QueryParam("start") String start, @QueryParam("length") String length) {
        try {

            ConfigDTO.Filter filter = dto.getFilter();
            ConfigPoint configPoint = makeConfigPointWithPoint(dto.getFilter().getPoint());


            if (dto.getType() != null
                    && dto.getType().equals("hotel")
                    && filter.getTags() != null
                    && filter.getTags().size() > 0) {
                return JacksonUtils.createEmptyArrayNode();
            }

            ConfigFilter configFilter = makeConfigFilterWithConfigDTO(dto
                    , dto.getFilter().getCityUid()
                    , configPoint
                    , dto.getFilter().getCityName());


            MainConfigFormat mainConfigFormat =
                    makeMainConfigFormatWithConfigDTO(dto, configFilter);

            ConfigSort configSort = null;
            if (dto.getSortBy() != null) {
                Map<String, Integer> validSort = validSort(dto.getSortBy());
                configSort = new ConfigSort(validSort);
            }

            MapMainConfig mapMainConfig = new MapMainConfig();
            ArrayNode mapper = mapMainConfig.mapper(mainConfigFormat, configSort, start, length);

            if (mapper != null && mapper.size() > 0) {
                if (dto.getType().equals("hotel") && configSort != null) {
                    for (String key : configSort.getSort_order().keySet()) {
                        if (key.equals("Price")) {
                            if (configSort.getSort_order().get(key).equals(-1)) {
                                String sortedByPrice = SortHotelsByPrice.hotelResultSortByPrice(mapper, "DSC");
                                return convertItemsToNewModelForSeeMore(ObjectMapperProvider.getObjectMapper().readTree(sortedByPrice));
                            } else if (configSort.getSort_order().get(key).equals(1)) {
                                String sortedByPrice = SortHotelsByPrice.hotelResultSortByPrice(mapper, "ASC");
                                return convertItemsToNewModelForSeeMore(ObjectMapperProvider.getObjectMapper().readTree(sortedByPrice));
                            }
                        } else {
                            return convertItemsToNewModelForSeeMore(mapper);
                        }
                    }
                } else {
                    return convertItemsToNewModelForSeeMore(mapper);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return JacksonUtils.createEmptyArrayNode();
    }


    private static ConfigDTO[] makeDTOListFromModel(ConfigFileModel fileModel) {

        if (fileModel.isGlobal()) {
            return makeFormatConfig(fileModel.withAffectOf());
        } else {
            return makeFormatConfigForCollection(fileModel.withAffectOf()
                    , fileModel.getWhichCollection());
        }

    }

    public static ArrayNode makeArrayNodeWithConfigDTOList(ConfigDTO[] configDTOS
            , String cityName, String cityUid
            , MakePointParam point) {

        ArrayNode finalArray = ObjectMapperProvider.getObjectMapper().createArrayNode();
        try {

            if (configDTOS != null) {


                JsonNode cityDetailNode = JacksonUtils.createEmptyObjectNode();
                if (cityName != null && !cityName.equals("")) {
                    cityDetailNode = makeCityDetailByCityName(cityName);
                } else if (cityUid != null && !cityUid.equals("")) {
                    cityDetailNode = makeCityDetailByCityUid(cityUid);
                }

                if (cityDetailNode != null && cityDetailNode.size() >= 1) {
                    finalArray.add(cityDetailNode);
                }


                for (ConfigDTO dto : configDTOS) {

                    ConfigPoint configPoint = makeConfigPointWithPoint(point);
                    ConfigFilter configFilter = makeConfigFilterWithConfigDTO(dto, cityUid, configPoint, cityName);
                    MainConfigFormat mainConfigFormat = makeMainConfigFormatWithConfigDTO(dto, configFilter);

                    ConfigSort configSort = null;
                    if (dto.getSortBy() != null && dto.getSortBy().size() > 0) {
                        Map<String, Integer> validSort = validSort(dto.getSortBy());
                        configSort = new ConfigSort(validSort);
                    }

                    ArrayNode mapper = new MapMainConfig().mapper(mainConfigFormat, configSort, "0", "10");
                    ConfigModel configModel = sortByHotelPriceAndConfigModel(dto, configFilter, mainConfigFormat, configSort, mapper);
                    JsonNode node = new MapConfigModel().mapper(configModel);
                    finalArray.add(node);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return finalArray;
    }

    private static JsonNode makeCityDetailByCityName(String cityName) {
        JsonNode cityDetailNode = JacksonUtils.createEmptyObjectNode();
        if (!StringUtils.isEmpty(cityName)) {
            MainPageCityDetail cityDetail = new MainPageCityDetail();
            cityDetailNode = cityDetail.cityDetail(cityName);
        }
        return cityDetailNode;
    }

    private static JsonNode makeCityDetailByCityUid(String cityUid) {
        BaseMongoQueries mongoQueries = new BaseMongoQueries();
        ObjectNode cityDetails = ObjectMapperProvider.getObjectMapper().createObjectNode();
        try {
            JsonNode node = mongoQueries.getMongoDBManager().executeQuery(cityUid);
            cityDetails.put("cityDetail", node);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cityDetails;
    }

    private static ConfigPoint makeConfigPointWithPoint(MakePointParam point) {
        if (point != null
                && point.getX() != null
                && point.getY() != null
                && point.getX() != 0) {
            return new ConfigPoint(point.getX(), point.getY(), point.getRadius());
        } else {
            return null;
        }
    }

    private static ConfigFilter makeConfigFilterWithConfigDTO(ConfigDTO configDTO, String cityUid, ConfigPoint configPoint, String cityName) {

        if (configDTO.getFilter() != null) {
            ConfigFilter configFilter = new ConfigFilter();

            if (configDTO.getVisitPage() != 1) {
                configFilter.setCityName(cityName);
                configFilter.setPoint(configPoint);
                configFilter.setCityUid(cityUid);
            }


            configFilter.setFeatures(configDTO.getFilter().getFeatures());
            configFilter.setPrices(configDTO.getFilter().getPrices());
            configFilter.setRates(configDTO.getFilter().getRates());
            if (configDTO.getFilter().getTags() != null
                    && configDTO.getFilter().getTags().size() > 0){
                ThingsToDoTagsMapper mapper = new ThingsToDoTagsMapper();
                String mainTag = mapper.getTagName(configDTO.getFilter().getTags().get(0));
                List<String> tags = mapper.getTagListOfMainTag(mainTag);
                configFilter.setTags(tags);
            }else{
                configFilter.setTags(configDTO.getFilter().getTags());
            }

            return configFilter;
        } else {
            return null;
        }
    }


    private static MainConfigFormat makeMainConfigFormatWithConfigDTO(ConfigDTO configDTO, ConfigFilter filter) {

        MainConfigFormat mainConfigFormat = new MainConfigFormat();

        mainConfigFormat.setConfigFilter(filter);
        mainConfigFormat.setName(configDTO.getName());
        mainConfigFormat.setType(configDTO.getType());
        mainConfigFormat.setVisitPage(configDTO.getVisitPage());

        return mainConfigFormat;
    }


    private static ConfigModel sortByHotelPriceAndConfigModel(ConfigDTO dto, ConfigFilter configFilter, MainConfigFormat mainConfigFormat, ConfigSort configSort, ArrayNode mapper) throws IOException {
        ConfigModel configModel = null;
        if (dto.getType().equals("hotel") && configSort != null) {
            for (String key : configSort.getSort_order().keySet()) {
                if (key.equals("Price")) {
                    if (configSort.getSort_order().get(key).equals(-1)) {
                        String sortedByPrice = SortHotelsByPrice.hotelResultSortByPrice(mapper, "DSC");
                        ArrayNode jsonNodes = (ArrayNode) ObjectMapperProvider.getObjectMapper().readTree(sortedByPrice);
                        configModel = new ConfigModel(mainConfigFormat.getName(), jsonNodes, mainConfigFormat.getVisitPage(), mainConfigFormat.getType(), configFilter, configSort);
                    } else if (configSort.getSort_order().get(key).equals(1)) {
                        String sortedByPrice = SortHotelsByPrice.hotelResultSortByPrice(mapper, "ASC");
                        ArrayNode jsonNodes = (ArrayNode) ObjectMapperProvider.getObjectMapper().readTree(sortedByPrice);
                        configModel = new ConfigModel(mainConfigFormat.getName(), jsonNodes, mainConfigFormat.getVisitPage(), mainConfigFormat.getType(), configFilter, configSort);
                    }
                } else {
                    configModel = new ConfigModel(mainConfigFormat.getName(), mapper, mainConfigFormat.getVisitPage(), mainConfigFormat.getType(), configFilter, configSort);
                }

            }
        } else {
            configModel = new ConfigModel(mainConfigFormat.getName(), mapper, mainConfigFormat.getVisitPage(), mainConfigFormat.getType(), configFilter, configSort);
        }
        return configModel;
    }


    private static ConfigDTO[] makeFormatConfig(int whichFile) {
        try {
            String osName = System.getProperty("os.name").toLowerCase();
            String pathToFile = "";
            if (whichFile == 0) {
                if (osName.contains("windows")) {
                    pathToFile = "C:\\PondMS\\mainConfig.json";
                }
                if (osName.contains("linux") || osName.contains("mac os")) {
                    pathToFile = "/opt/PondMS/mainConfig.json";
                }
            } else if (whichFile == 1) {
                if (osName.contains("windows")) {
                    pathToFile = "C:\\PondMS\\mainCityConfig.json";
                }
                if (osName.contains("linux") || osName.contains("mac os")) {
                    pathToFile = "/opt/PondMS/mainCityConfig.json";
                }
            }else if (whichFile == 2){
                if (osName.contains("windows")) {
                    pathToFile = "C:\\PondMS\\nearby.json";
                }
                if (osName.contains("linux") || osName.contains("mac os")) {
                    pathToFile = "/opt/PondMS/nearby.json";
                }
            }
            File file = new File(pathToFile);
            return ObjectMapperProvider.getObjectMapper().readValue(file, ConfigDTO[].class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static ConfigDTO[] makeFormatConfigForCollection(int whichFile, String collection) {
        try {
            String osName = System.getProperty("os.name").toLowerCase();
            String pathToFile = "";
            if (whichFile == 0) {
                if (collection.equals("hotel")) {
                    if (osName.contains("windows")) {
                        pathToFile = "C:\\PondMS\\hotelConfig.json";
                    }
                    if (osName.contains("linux") || osName.contains("mac os")) {
                        pathToFile = "/opt/PondMS/hotelConfig.json";
                    }
                }
                if (collection.equals("restaurant")) {
                    if (osName.contains("windows")) {
                        pathToFile = "C:\\PondMS\\restaurantConfig.json";
                    }
                    if (osName.contains("linux") || osName.contains("mac os")) {
                        pathToFile = "/opt/PondMS/restaurantConfig.json";
                    }

                }
                if (collection.equals("things-to-do")) {
                    if (osName.contains("windows")) {
                        pathToFile = "C:\\PondMS\\things-to-doConfig.json";
                    }
                    if (osName.contains("linux") || osName.contains("mac os")) {
                        pathToFile = "/opt/PondMS/things-to-doConfig.json";
                    }
                }
            } else if (whichFile == 1) {
                if (collection.equals("hotel")) {
                    if (osName.contains("windows")) {
                        pathToFile = "C:\\PondMS\\hotelCityConfig.json";
                    }
                    if (osName.contains("linux") || osName.contains("mac os")) {
                        pathToFile = "/opt/PondMS/hotelCityConfig.json";
                    }
                }
                if (collection.equals("restaurant")) {
                    if (osName.contains("windows")) {
                        pathToFile = "C:\\PondMS\\restaurantCityConfig.json";
                    }
                    if (osName.contains("linux") || osName.contains("mac os")) {
                        pathToFile = "/opt/PondMS/restaurantCityConfig.json";
                    }
                }
                if (collection.equals("things-to-do")) {
                    if (osName.contains("windows")) {
                        pathToFile = "C:\\PondMS\\things-to-doCityConfig.json";
                    }
                    if (osName.contains("linux") || osName.contains("mac os")) {
                        pathToFile = "/opt/PondMS/things-to-doCityConfig.json";
                    }
                }
            }else if (whichFile == 2){
                if (collection.equals("hotel")) {
                    if (osName.contains("windows")) {
                        pathToFile = "C:\\PondMS\\hotel-Nearby.json";
                    }
                    if (osName.contains("linux") || osName.contains("mac os")) {
                        pathToFile = "/opt/PondMS/hotel-Nearby.json";
                    }
                }
                if (collection.equals("restaurant")) {
                    if (osName.contains("windows")) {
                        pathToFile = "C:\\PondMS\\restaurant-Nearby.json";
                    }
                    if (osName.contains("linux") || osName.contains("mac os")) {
                        pathToFile = "/opt/PondMS/restaurant-Nearby.json";
                    }
                }
                if (collection.equals("things-to-do")) {
                    if (osName.contains("windows")) {
                        pathToFile = "C:\\PondMS\\things-to-do-Nearby.json";
                    }
                    if (osName.contains("linux") || osName.contains("mac os")) {
                        pathToFile = "/opt/PondMS/things-to-do-Nearby.json";
                    }
                }
            }
            File file = new File(pathToFile);
            return ObjectMapperProvider.getObjectMapper().readValue(file, ConfigDTO[].class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


    private static Map<String, Integer> validSort(Map<String, String> sortBy) {
        Map<String, Integer> validSort = new HashMap<>();
        for (String key : sortBy.keySet()) {
            String value = sortBy.get(key);
            if (value.equalsIgnoreCase("dsc")) {
                validSort.put(key, -1);
            }
            if (value.equalsIgnoreCase("asc")) {
                validSort.put(key, 1);
            }
        }
        return validSort;
    }


    private static ArrayNode newSeeMoreTagModel(ArrayNode arrayNode) {
        try {
            ArrayNode newArrayNode = JacksonUtils.createEmptyArrayNode();

            for (JsonNode node : arrayNode) {
                if (node.has("filter")) {
                    JsonNode filterJsonNode = node.get("filter");
                    if (filterJsonNode.has("tags")) {
                        JsonNode newJsonNode = makeNewModelWithNewTags(filterJsonNode);
                        ((ObjectNode) node).remove("filter");
                        ((ObjectNode) node).put("filter", newJsonNode);
                    }
                }
                newArrayNode.add(node);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return arrayNode;
    }

    private static JsonNode makeNewModelWithNewTags(JsonNode filterJsonNode){
        ArrayNode tags = (ArrayNode) filterJsonNode.get("tags");
        HashSet<String> newTags = makeNewArrayNodeFromTags(tags);

        if (newTags.size() > 0) {
            ArrayNode newFormatTags = JacksonUtils.createEmptyArrayNode();
            for (String name : newTags) {
                newFormatTags.add(name);
            }
            ((ObjectNode) filterJsonNode).put("new-tags", newFormatTags);
        }

        return filterJsonNode;
    }

    private static HashSet<String> makeNewArrayNodeFromTags(ArrayNode tags){
        HashSet<String> newTags = new HashSet<>();
        for (JsonNode tag : tags) {
            String newTag = returnConvertedTag(tag.asText());
            newTags.add(newTag);
        }

        return newTags;
    }

    private static String returnConvertedTag(String tag){
        return new ThingsToDoTagsMapper().getTagName(tag);
    }

    public static ArrayNode convertItemsToNewModel(JsonNode items) {
        ArrayNode responseNode = JacksonUtils.createEmptyArrayNode();
        for (JsonNode node : items) {
            if (node.get("cityDetail") != null) {
                JsonNode finalNode = GisVectorLayerToNewModel.mapperToNewModel(node.get("cityDetail"));
                for (JsonNode city : node) {
                    JsonNode cityDetail = GisVectorLayerToNewModel.mapperToNewModel(city);
                    ArrayNode cityOld = (ArrayNode) city;
                    cityOld.add(cityDetail);
                }
                ((ObjectNode) node).put("cityDetail", finalNode);
            }
            if (node.get("items") != null) {
                JsonNode finalNode = GisVectorLayerToNewModel.mapperToNewModel(node.get("items"));
                ((ObjectNode) node).put("items", finalNode);
            }

            responseNode.add(node);
        }
        return responseNode;
    }

    private static ArrayNode convertItemsToNewModelForSeeMore(JsonNode items) {
        ArrayNode newItems = JacksonUtils.createEmptyArrayNode();
        for (JsonNode node : items) {
            JsonNode jsonNode = GisVectorLayerToNewModel.mapperToNewModel(node);
            newItems.add(jsonNode);
        }
        return newItems;
    }

}

