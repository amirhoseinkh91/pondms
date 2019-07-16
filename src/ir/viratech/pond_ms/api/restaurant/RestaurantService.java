package ir.viratech.pond_ms.api.restaurant;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import ir.viratech.commons.util.jackson.JacksonUtils;
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

@Path("/restaurant")
@SuppressWarnings({"Duplicates", "unused","SpellCheckingInspection"})
public class RestaurantService extends BaseMongoQueries {
    private static final String STEAK = "استیک و گریل";
    private static final String COFFEE = "کافی شاپ";
    private static final String LEBANESE = "لبنانی";
    private static final String BREAK_FAST = "صبحانه";
    private static final String TURKISH = "ترکیه ای";
    private static final String SEA_FOOD = "دریایی";
    private static final String FOOD_COURT = "فودکورت";
    private static final String SOUP = "آش و حلیم";
    private static final String BYPRODUCTS = "طباخی";
    private static final String NATIONAL_FOOD = "غذای ملل";
    private static final String IRANIAN_FOOD = "ایرانی";
    private static final String VEGETARIAN = "گیاه خواری";
    private static final String NORTHERN_FOOD = "گیلکی";
    private static final String ITALIAN_FOOD = "ایتالیایی";
    private static final String FAST_FOOD = "فست فود";
    private static final String BAKERY = "قنادی و نانوایی";
    private static final String TURKISH_KEBAB = "کباب ترکی";
    private static final String KEBAB = "کباب";
    private static final String BROTH = "دیزی";

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/tags-count")
    public Response tagsCount(@QueryParam("layerUid") String uid,
                              @QueryParam("cityName") String cityName,
                              @QueryParam("x") String x, @QueryParam("y") String y, @QueryParam("dist") String dist) {
        try {
            AllTags allTags = new AllTags();
            Set<String> tagsSet = allTags.getAllTagsForRestaurant("Restaurant");
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
                resUid = equals("layer_uid", city.get(MessageService.getMessage("config.restaurants")));
            } else if (!StringUtils.isEmpty(x) && !StringUtils.isEmpty(y)) {
                resUid = nearby(x, y, dist);
            } else {
                return Response.status(400).build();
            }

            for (String tag : tagsSet) {
                ObjectNode tagsCount = JacksonUtils.createEmptyObjectNode();
                query = makeQuery(find(and(tag(tag, "restaurant"), resUid, isDeleted(false))), "restaurant_col");
                int count = getMongoDBManager().executeQuery(countAndExecute(query)).asInt();
                if (!(count > 0)) {
                    continue;
                }
                tagsCount.put("name", tag);
                tagsCount.put("count", count);
                tagsCount.put("image", getTagImage(tag));
                tagsArray.add(tagsCount);
            }
            return Response.ok(tagsArray).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(400).build();
        }
    }


    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/items")
    public Response getItems(@QueryParam("cityName") String cityName,
                             @QueryParam("layerUid") String layerUid,
                             @QueryParam("x") String x,
                             @QueryParam("y") String y,
                             @QueryParam("dist") String dist,
                             @QueryParam("tag") List<String> tags, @QueryParam("rate") List<Integer> rates,
                             @QueryParam("prices") List<Integer> prices,
                             @QueryParam("rateSort") String rateSort,
                             @QueryParam("nameSort") String nameSort,
                             @DefaultValue("0") @QueryParam("start") String start, @DefaultValue("10") @QueryParam("len") String len) {
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

        if (checkInputValidation(cityName, layerUid, pointParam)) {
            return Response.status(406).build();
        }

        ObjectNode restaurantsResult = JacksonUtils.createEmptyObjectNode();

        paginationConverter(start, len);

        String restUid = "";
        String tagsQuery = "";
        String ratesQuery = "";
        String pricesQuery = "";
        String find;
        ArrayList<String> queries = new ArrayList<>();


        if (!StringUtils.isEmpty(cityName)) {
            restUid = convertCityNameToUid(cityName);
        }

        if (tags != null && tags.size() > 0)
            tagsQuery = tagsQuery(tags);
        if (rates != null && rates.size() > 0)
            ratesQuery = ratesQuery(rates);
        if (prices != null && prices.size() > 0)
            pricesQuery = pricesQuery(prices);

        if (ratesQuery.equals("406")) {
            return Response.status(406).build();
        }

        if (!StringUtils.isEmpty(tagsQuery))
            queries.add(tagsQuery);
        if (!StringUtils.isEmpty(ratesQuery))
            queries.add(ratesQuery);
        if (!StringUtils.isEmpty(pricesQuery))
            queries.add(pricesQuery);
        if (!StringUtils.isEmpty(nameSort))
            queries.add("{ 'name' : { $exists: true, $ne: null }}");

        StringBuilder query = new StringBuilder();
        for (int i = 0; i < queries.size(); i++) {
            if (i < queries.size() - 1) {
                query.append(queries.get(i)).append(COMMA);
            } else
                query.append(queries.get(i));
        }
        try {
            if (!StringUtils.isEmpty(restUid)) {
                find = find(and(equals("layer_uid", restUid), query.toString()));
            } else if (!StringUtils.isEmpty(layerUid)) {
                find = find(and(layerUid(layerUid), query.toString()));
            } else {
                find = find(and(nearby(pointParam.getX() + "", pointParam.getY() + "", pointParam.getRadius() + ""), query.toString()));
            }
            String finalQuery = baseQueryMaker(find, "restaurant", false);
            JsonNode node = getMongoDBManager().executeQuery(finalQuery);
//            for (JsonNode internalNode : node) {
//                if (internalNode.has("FoursquarePhotos")) {
//                    if (!(internalNode.get("FoursquarePhotos").size() > 0)) {
//                        ArrayNode image = JacksonUtils.createEmptyArrayNode();
//                        image.add("TRCP8K44KY0PKA85ISWBVZAJPX2JXIG52RCPZOYB");
//                        ((ObjectNode) internalNode).put("FoursquarePhotos", image);
//                    }
//                } else {
//                    ArrayNode image = JacksonUtils.createEmptyArrayNode();
//                    image.add("TRCP8K44KY0PKA85ISWBVZAJPX2JXIG52RCPZOYB");
//                    ((ObjectNode) internalNode).put("FoursquarePhotos", image);
//                }
//            }
            int countResult = getMongoDBManager().executeQuery(countAndExecute(makeQuery(find, "restaurant_col"))).asInt();
            if (countResult == 0) {
                return Response.ok(JacksonUtils.createEmptyObjectNode()).build();
            }
            JsonNode entity = GisVectorLayerToNewModel.mapperToNewModel(node);
            restaurantsResult.put("totalCount", countResult);
            restaurantsResult.put("items", entity);
            return Response.ok(restaurantsResult).build();
        } catch (InstantiationException | IllegalAccessException | IOException e) {
            e.printStackTrace();
            return Response.status(400).build();
        }
    }


    private String convertCityNameToUid(@QueryParam("cityName") String cityName) {
        Map<String, String> city = FilterConfig.getCity(cityName);
        return city.get(MessageService.getMessage("config.restaurants"));
    }

    private String tagsQuery(List<String> tags) {
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

    private String pricesQuery(List<Integer> prices) {
        try {
            List<String> queries = new ArrayList<>();
            if (prices.size() > 0) {
                if (prices.size() > 1) {
                    for (Integer price : prices) {
                        if (price >= 0 && price <= 4) {
                            queries.add(eq("Price", price + ""));
                        }
                    }
                }
                if (prices.size() == 1) {
                    return eq("Price", prices.get(0) + "");
                }

            }
            if (queries.size() > 0) {
                String[] things = new String[queries.size()];
                for (int i = 0; i < queries.size(); i++) {
                    things[i] = queries.get(i);
                }
                return or_logical(things);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "406";
    }

    private String ratesQuery(List<Integer> rates) {
        try {
            if (rates != null && rates.size() > 0) {
                Collections.sort(rates);
                List<String> queries = new ArrayList<>();
                Integer rateZero = rates.get(0);
                if (rates.size() == 1) {
                    if (rateZero >= 1 && rateZero <= 5)
                        return appendQueries(gte("Rate", ((rateZero * 2) - 1) + "")
                                , lte("Rate", (rateZero * 2) + ""));
                }
                if (rates.size() > 1) {
                    for (Integer rate : rates) {
                        if (rate >= 1 && rate <= 5) {
                            if (rate.equals(1)) {
                                queries.add(and(gte("Rate", "1"), lte("Rate", "2")));
                            }
                            if (rate.equals(2)) {
                                queries.add(and(gte("Rate", "3"), lte("Rate", "4")));
                            }
                            if (rate.equals(3)) {
                                queries.add(and(gte("Rate", "5"), lte("Rate", "6")));
                            }
                            if (rate.equals(4)) {
                                queries.add(and(gte("Rate", "7"), lte("Rate", "8")));
                            }
                            if (rate.equals(5)) {
                                queries.add(and(gte("Rate", "9"), lte("Rate", "10")));
                            }
                        }

                    }

                    if (queries.size() > 1) {
                        String[] things = new String[queries.size()];
                        for (int i = 0; i < queries.size(); i++) {
                            things[i] = queries.get(i);
                        }

                        return or_logical(things);
                    } else return queries.get(0);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "406";
    }


    private Boolean checkInputValidation(String cityName, String layerUid, MakePointParam pointParam) {
        Boolean cityNameExist = false;
        if (cityName != null && !cityName.equals("")) {
            cityNameExist = true;
        }

        Boolean layerUidExist = false;
        if (layerUid != null && !layerUid.equals("")) {
            layerUidExist = true;
        }

        Boolean pointParamExist = false;
        if (pointParam != null) {
            if (pointParam.getX() != 0.0 && pointParam.getY() != 0.0) {
                pointParamExist = true;
            }
        }

        if (cityNameExist && layerUidExist && pointParamExist) {
            return true;
        }

        return !cityNameExist && !layerUidExist && !pointParamExist;

    }

    private String getTagImage(String tag) {
        switch (tag) {
            case STEAK:
                return "6MORVXZ2X350HUSKDMG57TSCP97Q37HPAOLRZJA7";
            case COFFEE:
                return "MMHY4XEBUSDAR0LYHF2KT5CWMBH4PDU0JJP0N9OR";
            case LEBANESE:
                return "BOVK05UVU49DPBLU9P7RU8EMNCMHLD5Q2YWLFE0Q";
            case BREAK_FAST:
                return "IYRMSGR7T93KGWUQ5EJKW1HBXDD05JGD4GVEBNUG";
            case TURKISH:
                return "GCJS94QYXG6KD5TSNPYG4MF3E9PI08NL60UQ9757";
            case SEA_FOOD:
                return "3UY1093DG4BEAD0M0HSZIMSQJ5OOYAXX66QAFZSJ";
            case FOOD_COURT:
                return "GWVMPWM2CHERS4LKINR0IYNWG3AFGK1Z78YVGA6S";
            case BYPRODUCTS:
                return "FHDRPACZLLNO2XCRBFYCZ4ENBDKS6NBNLHBH6CAQ";
            case NATIONAL_FOOD:
                return "T9PD5G69SCNCAKK0KC3C09IOL4MYUW5KPFMLWHMR";
            case IRANIAN_FOOD:
                return "YDIXL5B6ZOGZ3WN42HYO6FWIX02RKK2U06EXN2JS";
            case VEGETARIAN:
                return "WESV2OZHB9FNBNGB5O7YWDAB4DN8HWOMQDRSXFIF";
            case NORTHERN_FOOD:
                return "E2HYS6U3MAH7U56FXYRJ58S656RPX1L5F47IV8BP";
            case ITALIAN_FOOD:
                return "S89A6V98TWDC2LT3RIT07T2JPIAX0F5ZN233QZBN";
            case FAST_FOOD:
                return "MWBQTOQW4SRBEZWN091GJVKDYW3I1QQ90GAXEPQY";
            case BAKERY:
                return "82EM569XEJT8SDMIYA17701R7SSGI5TGZ9OTQOVM";
            case TURKISH_KEBAB:
                return "LFCGSV2YKO5HVGIRFO0MSNEICILA70QCJXKSP64I";
            case KEBAB:
                return "985FD4B0OU072M0AKY97WSRELZ3W9ICYOTG9ULQY";
            case BROTH:
                return "UGB9SI8EJTFPXTJ7K6WXXVHREFQL3NK5SF99EG3Q";
            default:
                return "YK6BHHMEYZ21022D2B5BJCKX2ZDFM5RUZMUF0WSU";
        }
    }
}
