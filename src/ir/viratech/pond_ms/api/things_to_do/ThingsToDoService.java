package ir.viratech.pond_ms.api.things_to_do;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.collect.Lists;
import ir.viratech.commons.util.jackson.JacksonUtils;
import ir.viratech.commons.util.jackson.ObjectMapperProvider;
import ir.viratech.pond_ms.api.filter.BaseMongoQueries;
import ir.viratech.pond_ms.api.filter.FilterConfig;
import ir.viratech.pond_ms.api.main_city_config.MakePointParam;
import ir.viratech.pond_ms.core.i18n.MessageService;
import ir.viratech.pond_ms.model.gis_vector_object_new_model.GisVectorLayerToNewModel;
import ir.viratech.pond_ms.model.tags.AllTags;
import org.apache.commons.lang3.StringUtils;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.*;

@Path("/things-to-do")
@SuppressWarnings("Duplicates")
public class ThingsToDoService extends BaseMongoQueries {

    private HashMap<String , Integer> similarTagsCounts = new HashMap<>();

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/tags-count")
    public Response tagsCount(@QueryParam("layerUid") String uid,
                              @QueryParam("cityName") String cityName,
                              @QueryParam("x") String x, @QueryParam("y") String y, @QueryParam("dist") String dist) {
        try {
            AllTags allTags = new AllTags();
            Set<String> tagsSet = allTags.getAllTagsForThingsToDo("Things_To_Do");
            ArrayNode tagsArray = JacksonUtils.createEmptyArrayNode();
            String query;
            String resUid;

            if (StringUtils.isEmpty(dist)) {
                dist = 3000 + "";
            }

            if (!StringUtils.isEmpty(uid)) {
                resUid = layerUid(uid);
            } else if (!StringUtils.isEmpty(cityName)) {
                Map<String, String> city = FilterConfig.getCity(cityName);
                resUid = equals("layer_uid", city.get(MessageService.getMessage("config.things")));
            } else if (!StringUtils.isEmpty(x) && !StringUtils.isEmpty(y)) {
                resUid = nearby(x, y, dist);
            } else {
                return Response.status(400).build();
            }

            for (String tag : tagsSet) {
                ObjectNode tagsCount = JacksonUtils.createEmptyObjectNode();
                query = makeQuery(find(and(resUid, regexForTagBy(tag.trim()), isDeleted(false))), "things_to_do_col");
                int count = getMongoDBManager().executeQuery(countAndExecute(query)).asInt();
                if (!(count > 0)) {
                    continue;
                }
                tagsCount.put("name", tag.trim());
                tagsCount.put("count", count);
                tagsArray.add(tagsCount);
            }
            ArrayNode mergedTags = mergeSimilarTags(tagsArray);
            List<JsonNode> list = Lists.newArrayList((mergedTags).iterator());
            sort(list);
            Collections.reverse(list);
            JsonNode sortedNode = ObjectMapperProvider.getObjectMapper().valueToTree(list);
            return Response.ok(sortedNode).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(400).build();
        }
    }

    private ArrayNode mergeSimilarTags(ArrayNode tags){
        ArrayNode similarTags = JacksonUtils.createEmptyArrayNode();

        for (JsonNode tag : tags){
            ThingsToDoTagsMapper mapper = new ThingsToDoTagsMapper();
            String name = mapper.getTagName(tag.get("name").asText());
            if (name != null && !name.equals("")){
                addCountToTagsCount(name, tag.get("count").asInt());
            }
        }

        for (String name : similarTagsCounts.keySet()) {
            ObjectNode node = JacksonUtils.createEmptyObjectNode();
            node.put("name", name);
            node.put("count" , similarTagsCounts.get(name));
            similarTags.add(node);
        }

        return similarTags;
    }


    private void addCountToTagsCount(String tagName , Integer tagCount){
        if (similarTagsCounts.containsKey(tagName)){
            Integer newCount = similarTagsCounts.get(tagName) + tagCount;
            similarTagsCounts.put(tagName , newCount);
        }else {
            similarTagsCounts.put(tagName , tagCount);
        }
    }


    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/items")
    public Response test(@QueryParam("cityName") String cityName,
                         @QueryParam("layerUid") String uid,
                         @QueryParam("x") String x,
                         @QueryParam("y") String y,
                         @QueryParam("dist") String dist,
                         @QueryParam("tag") List<String> tags,
                         @QueryParam("rate") List<Integer> rates,
                         @QueryParam("nameSort") String nameSort,
                         @QueryParam("rateSort") String rateSort,
                         @DefaultValue("0") @QueryParam("start") String start,
                         @DefaultValue("10") @QueryParam("len") String len) {

        MakePointParam pointParam = null;
        if (!StringUtils.isEmpty(x) && !StringUtils.isEmpty(y)) {
            pointParam = new MakePointParam();
            pointParam.setX(Double.valueOf(x));
            pointParam.setY(Double.valueOf(y));
            if (!StringUtils.isEmpty(dist)) {
                pointParam.setRadius(Long.valueOf(dist));
            } else pointParam.setRadius(3000L);
        }

        if (!StringUtils.isEmpty(rateSort) && !StringUtils.isEmpty(nameSort)) {
            return Response.status(406).build();
        }

        if (!StringUtils.isEmpty(rateSort)) {
            isManualSort = isManualSort("Rate", rateSort);
        }
        if (!StringUtils.isEmpty(nameSort)) {
            isManualSort = isManualSort("name", nameSort);
        }

        if (!StringUtils.isEmpty(cityName) && !StringUtils.isEmpty(uid)) {
            return Response.status(400).build();
        } else if (StringUtils.isEmpty(cityName) && StringUtils.isEmpty(uid) && pointParam == null) {
            return Response.status(406).build();
        }

        ObjectNode thingdToDoResult = JacksonUtils.createEmptyObjectNode();

        paginationConverter(start, len);
        String thingsToDoUid = "";
        String tagsQuery = "";
        String ratesQuery = "";
        ArrayList<String> queries = new ArrayList<>();

        if (!StringUtils.isEmpty(cityName)) {
            thingsToDoUid = convertCityNameToUid(cityName);
        }

        if (tags != null && tags.size() > 0)
            tagsQuery = makeTagsQueryWithListOf(makeCorrectTagsListWithListOf(tags));
        if (rates != null && rates.size() > 0)
            ratesQuery = makeRatesQueryWithListOf(rates);

        if (ratesQuery.equals("406")) {
            return Response.status(406).build();
        }

        if (!StringUtils.isEmpty(tagsQuery)) {
            queries.add(tagsQuery);
        }

        if (!StringUtils.isEmpty(ratesQuery)) {
            queries.add(ratesQuery);
        }

        if (!StringUtils.isEmpty(nameSort)) {
            queries.add("{ 'name' : { $exists: true, $ne: null }}");
        }

        StringBuilder query = makeQueryWithListOfQueries(queries);

        try {

            String find;
            if (!StringUtils.isEmpty(thingsToDoUid)) {
                find = find(and(equals("layer_uid", thingsToDoUid), query.toString()));
            } else if (!StringUtils.isEmpty(uid)) {
                find = find(and(layerUid(uid), query.toString()));
            } else {
                find = find(and(nearby(pointParam.getX() + "", pointParam.getY() + "", pointParam.getRadius() + ""), query.toString()));
            }

            String m = baseQueryMaker(find, "things-to-do", false);
            JsonNode node = getMongoDBManager().executeQuery(m);

//            for (JsonNode internalNode : node) {
//                if (internalNode.has("Images")) {
//                    if (!(internalNode.get("Images").size() > 0)) {
//                        ArrayNode image = JacksonUtils.createEmptyArrayNode();
//                        image.add("Y9ER457OR3IJAVCGFOIIW4GWWWG03FXRX4MNPL3C");
//                        ((ObjectNode) internalNode).put("Images", image);
//                    }
//                } else {
//                    ArrayNode image = JacksonUtils.createEmptyArrayNode();
//                    image.add("Y9ER457OR3IJAVCGFOIIW4GWWWG03FXRX4MNPL3C");
//                    ((ObjectNode) internalNode).put("Images", image);
//                }
//            }

            JsonNode entity = GisVectorLayerToNewModel.mapperToNewModel(node);

            int countResult = getMongoDBManager().executeQuery(countAndExecute(makeQuery(find, "things_to_do_col"))).asInt();
            if (countResult == 0) {
                return Response.ok(JacksonUtils.createEmptyObjectNode()).build();
            }
            thingdToDoResult.put("totalCount", countResult);
            thingdToDoResult.put("items", entity);

            return Response.ok(thingdToDoResult)
                    .build();

        } catch (InstantiationException | IllegalAccessException | IOException e) {
            e.printStackTrace();
            return Response.status(400).build();
        }
    }


    private String convertCityNameToUid(String cityName) {
        Map<String, String> city = FilterConfig.getCity(cityName);
        return city.get(MessageService.getMessage("config.things"));
    }

    private StringBuilder makeQueryWithListOfQueries(ArrayList<String> queries) {
        StringBuilder query = new StringBuilder();
        for (int i = 0; i < queries.size(); i++) {
            if (i < queries.size() - 1) {
                query.append(queries.get(i)).append(COMMA);
            } else {
                query.append(queries.get(i));
            }
        }

        return query;
    }

    private List<String> makeCorrectTagsListWithListOf(List<String> tags){
        try{
            ArrayList<String> newTags = new ArrayList<>();
            ThingsToDoTagsMapper thingsToDoTagsMapper = new ThingsToDoTagsMapper();
            for (String tag : tags){
                String mainTag = thingsToDoTagsMapper.getTagName(tag);
                List<String> mainTagCollection;
                if (mainTag != null && !mainTag.equals("")){
                     mainTagCollection = thingsToDoTagsMapper
                            .getTagListOfMainTag(mainTag);
                }else{
                    mainTagCollection = thingsToDoTagsMapper.getTagListOfMainTag(tag);
                }
                newTags.addAll(mainTagCollection);
            }

            return newTags;
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    private String makeTagsQueryWithListOf(List<String> tags) {
        try {
            if (tags != null && tags.size() > 0) {
                String[] strings = new String[tags.size()];
                for (int i = 0; i < tags.size(); i++) {
                    strings[i] = regex("Tags", tags.get(i));
                }
                return or_logical(strings);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    private String makeRatesQueryWithListOf(List<Integer> rates) {
        try {
            if (rates != null && rates.size() > 0) {
                Collections.sort(rates);
                List<String> queries = new ArrayList<>();

                if (rates.size() == 1) {
                    Integer rateZero = rates.get(0);
                    if (rateZero >= 1 && rateZero <= 5) {
                        return appendQueries(
                                gte("Rate", ((rateZero * 2) - 1) + "")
                                , lte("Rate", (rateZero * 2) + ""));
                    }
                } else {
                    for (Integer rate : rates) {
                        switch (rate) {
                            case 1:
                                queries.add(and(gte("Rate", "1"), lte("Rate", "2")));
                                break;
                            case 2:
                                queries.add(and(gte("Rate", "3"), lte("Rate", "4")));
                                break;
                            case 3:
                                queries.add(and(gte("Rate", "5"), lte("Rate", "6")));
                                break;
                            case 4:
                                queries.add(and(gte("Rate", "7"), lte("Rate", "8")));
                                break;
                            case 5:
                                queries.add(and(gte("Rate", "9"), lte("Rate", "10")));
                                break;
                            default:
                                break;
                        }
                    }

                    if (queries.size() > 1) {
                        String[] things = new String[queries.size()];
                        for (int i = 0; i < queries.size(); i++) {
                            things[i] = queries.get(i);
                        }
                        return or_logical(things);
                    } else {
                        return queries.get(0);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "406";
    }

    private String regexForTagBy(String tagName) {
        return "{\"Tags\" :{$regex : \".*" + tagName + ".*\"}}";
    }


    private void sort(List<JsonNode> list) {
        Collections.sort(list, (first, second) -> {
            Integer a = first.get("count").asInt();
            Integer b = second.get("count").asInt();
            return a.compareTo(b);
        });
    }


}
