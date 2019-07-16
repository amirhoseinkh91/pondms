package ir.viratech.pond_ms.model.main_city_config;

import ir.viratech.pond_ms.api.filter.BaseMongoQueries;
import ir.viratech.pond_ms.core.i18n.MessageService;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@SuppressWarnings("Duplicates")
public class MakeQuery extends BaseMongoQueries {


    public String getMainConfig(MainConfigFormat mainConfigFormat) {

        try {

            String query;
            if (mainConfigFormat.getConfigFilter().getCityName() != null
                    && !mainConfigFormat.getConfigFilter().getCityName().equals("")) {
                query = makeQueryWithCityNameAffect(mainConfigFormat);
            } else if (mainConfigFormat.getConfigFilter().getCityUid() != null
                    && !mainConfigFormat.getConfigFilter().getCityUid().equals("")) {
                query = makeQueryWithCityUidAffect(mainConfigFormat.getConfigFilter(), mainConfigFormat.getType());
            } else if (mainConfigFormat.getConfigFilter().getPoint() != null
                    && mainConfigFormat.getConfigFilter().getPoint().getX() != 0) {
                query = makeQueryWithPointAffect(mainConfigFormat.getConfigFilter(), mainConfigFormat.getType());
            } else {
                query = makeQueryWithoutAnyAffect(mainConfigFormat.getConfigFilter(), mainConfigFormat.getType());
            }
            return makePrimaryQuery(query, collectionMapper(mainConfigFormat.getType()));

        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    private String makeQueryWithCityNameAffect(MainConfigFormat mainConfigFormat) {
        String defaultStructuredCityName = makeCityNameWithDefaultStructure(mainConfigFormat.getConfigFilter().getCityName());

        try {
            if (collectionMapper(mainConfigFormat.getType()).equals(CITY_COLLECTION)) {
                return eq("layer_uid", "\'" + collectionUid(defaultStructuredCityName
                        , "", MessageService.getMessage("config.city")) + "\'");
            } else {
                String query = makeQueryFromQueriesList(makeQueryBaseOnFilters(mainConfigFormat.getConfigFilter(), mainConfigFormat.getType()));
                return and(eq("layer_uid", "\'" + getCityUidFromCollectionType(collectionMapper(mainConfigFormat.getType())
                        , "", defaultStructuredCityName) + "\'"), query);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    private String makeQueryWithCityUidAffect(ConfigFilter filter, String type) {
        try {

            if (collectionMapper(type).equals(CITY_COLLECTION)) {
                return eq("layer_uid", "\'" + collectionUid("", filter.getCityUid()
                        , MessageService.getMessage("config.city")) + "\'");
            } else {
                return and(eq("layer_uid", "\'" + getCityUidFromCollectionType(collectionMapper(type), filter.getCityUid()
                        , filter.getCityName()) + "\'")
                        , makeQueryFromQueriesList(makeQueryBaseOnFilters(filter, type)));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }


    private String makeQueryWithPointAffect(ConfigFilter configFilter, String type) {
        try {
            if (configFilter.getPoint().getRadius() == 0L || configFilter.getPoint().getRadius() < 1L) {
                configFilter.getPoint().setRadius(3000L);
            }
            String nearby = nearby(configFilter.getPoint().getX() + ""
                    , configFilter.getPoint().getY() + ""
                    , configFilter.getPoint().getRadius() + "");

            ArrayList<String> queries = makeQueryBaseOnFilters(configFilter, type);

            if (!StringUtils.isEmpty(nearby)) {
                queries.add(nearby);
            }

            return and(makeQueryFromQueriesList(queries));
        }catch (Exception e){
            e.printStackTrace();
        }

        return "";
    }

    private String makeQueryWithoutAnyAffect(ConfigFilter configFilter, String type) {

        try {
            if (configFilter.getLayer() != null && !configFilter.getLayer().equals("")) {
                return and(eq("layer_uid", "\'" + configFilter.getLayer() + "\'")
                        , makeQueryFromQueriesList(makeQueryBaseOnFilters(configFilter, type)));
            } else {
                ArrayList<String> filters = makeQueryBaseOnFilters(configFilter, type);
                if (filters.size() > 0){
                    return and(makeQueryFromQueriesList(filters));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "";
    }

    private String getCityUidFromCollectionType(String type, String cityUid, String cityName) {
        switch (type) {
            case THINGS_TO_DO_COLLECTION:
                return collectionUid(cityName
                        , cityUid, MessageService.getMessage("config.things"));
            case RESTAURANT_COLLECTION:
                return collectionUid(cityName
                        , cityUid, MessageService.getMessage("config.restaurants"));
            default:
                return collectionUid(cityName
                        , cityUid, MessageService.getMessage("config.hotels"));
        }
    }


    private String collectionUid(String cityName, String cityUid, String collection) {
        Map<String, String> city = ChildCityConfig.getCity(cityName, cityUid);
        if (collection.equals(MessageService.getMessage("config.restaurants"))) {
            return city.get(MessageService.getMessage("config.restaurants"));
        } else if (collection.equals(MessageService.getMessage("config.city"))) {
            return city.get(MessageService.getMessage("config.city"));
        } else if (collection.equals(MessageService.getMessage("config.things"))) {
            return city.get(MessageService.getMessage("config.things"));
        } else {
            return city.get(MessageService.getMessage("config.hotels"));
        }
    }

    private String makeCityNameWithDefaultStructure(String cityName) {
        if (!cityName.startsWith(MessageService.getMessage("city.space"))) {
            String trim = cityName.trim();
            trim = trim.replaceAll("\"", "");
            return MessageService.getMessage("city.space") + trim;

        } else {
            return cityName;
        }
    }



    private String makeQueryFromQueriesList(ArrayList<String> queries) {
        StringBuilder query = new StringBuilder();
        for (int i = 0; i < queries.size(); i++) {
            if (i < queries.size() - 1) {
                query.append(queries.get(i)).append(COMMA);
            } else
                query.append(queries.get(i));
        }
        return query.toString();
    }


    private ArrayList<String> makeQueryBaseOnFilters(ConfigFilter configFilter, String type) {


        ArrayList<String> queries = new ArrayList<>();

        //making tags query
        if (configFilter.getTags() != null && configFilter.getTags().size() > 0) {
            String tagQuery = makeTagQuery(configFilter.getTags());
            if (!StringUtils.isEmpty(tagQuery)) {
                queries.add(tagQuery);
            }
        }

        //making prices query
        if (configFilter.getPrices() != null && configFilter.getPrices().size() > 0) {
            String priceQuery = makePriceQuery(configFilter.getPrices());
            if (!StringUtils.isEmpty(priceQuery)) {
                queries.add(priceQuery);
            }
        }

        //making features query
        if (configFilter.getFeatures() != null && configFilter.getFeatures().size() > 0) {
            String featuresQuery = makeFeaturesQuery(configFilter.getFeatures());
            if (!StringUtils.isEmpty(featuresQuery)) {
                queries.add(featuresQuery);
            }
        }

        //making rate query
        if (configFilter.getRates() != null && configFilter.getRates().size() > 0) {
            String rateQuery;
            if (collectionMapper(type).equals(HOTEL_COLLECTION)) {
                rateQuery = makeRateQueryForHotel(configFilter.getRates());
            } else {
                rateQuery = makeRateQueryForThingsToDoOrRestaurants(configFilter.getRates());
            }


            if (!StringUtils.isEmpty(rateQuery)) {
                queries.add(rateQuery);
            }
        }

        //making queryName query
        if (configFilter.getQueryName() != null
                && !StringUtils.isEmpty(configFilter.getQueryName())) {

            String nameQuery = makeNameQuery(configFilter.getQueryName());

            if (!StringUtils.isEmpty(nameQuery)) {
                queries.add(nameQuery);
            }
        }

        return queries;
    }




    private String makePriceQuery(List<Integer> prices) {
        try {
            if (prices != null) {
                List<String> queries = new ArrayList<>();

                if (prices.size() > 0 && prices.size() > 1) {
                    for (Integer price : prices) {
                        if (price >= 0 && price <= 4) {
                            queries.add(eq("Price", price + ""));
                        }
                    }
                } else {
                    queries.add(eq("Price", prices.get(0) + ""));
                }

                return makeQueryWithListOfQueriesByOrLogic(queries);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    private String makeFeaturesQuery(List<String> features) {
        try {
            if (features != null) {
                List<String> queries = new ArrayList<>();

                if (features.size() > 0) {
                    for (String hotelFeature : features) {
                        queries.add(regex("Features", hotelFeature));
                    }
                }

                return makeQueryWithListOfQueriesByOrLogic(queries);
            } else {
                return "";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }


    private String makeQueryWithListOfQueriesByOrLogic(List<String> queries) {
        if (queries.size() > 1) {
            String[] things = new String[queries.size()];
            for (int i = 0; i < queries.size(); i++) {
                things[i] = queries.get(i);
            }
            return or_logical(things);
        } else if (queries.get(0) != null && !queries.get(0).equals("")) {
            return queries.get(0);
        } else {
            return "";
        }
    }

    private java.lang.String makeRateQueryForHotel(List<Integer> rates) {

        Collections.sort(rates);
        Integer rateZero = rates.get(0);

        if (rates.size() == 1) {
            return eq("Rate", rateZero + "");
        } else {
            String[] things = new String[rates.size()];
            for (int i = 0; i < rates.size(); i++) {
                if (rates.get(i) >= 3 && rates.get(i) <= 5) {
                    things[i] = eq("Rate", rates.get(i) + "");
                }
            }
            return or_logical(things);
        }
    }

    private java.lang.String makeRateQueryForThingsToDoOrRestaurants(List<Integer> rates) {

        try {
            Collections.sort(rates);
            List<String> queries = new ArrayList<>();
            Integer rateZero = rates.get(0);


            if (rates.size() > 1) {
                for (Integer rate : rates) {
                    if (rate >= 3 && rate <= 5) {
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

                return makeQueryWithListOfQueriesByOrLogic(queries);
            } else {
                if (rateZero >= 3 && rateZero <= 5) {
                    return appendQueries(gte("Rate", ((rateZero * 2) - 1) + ""), lte("Rate", (rateZero * 2) + ""));
                } else {
                    return "";
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }


    private String makeTagQuery(List<String> tags) {
        if (tags != null && tags.size() > 0) {
            String[] strings = new String[tags.size()];
            for (int i = 0; i < tags.size(); i++) {
                strings[i] = regex("Tags", tags.get(i));
            }
            return or_logical(strings);
        } else {
            return "";
        }
    }

    private String makeNameQuery(String queryName) {
        if (!StringUtils.isEmpty(queryName)) {
            return regex_For_Tag("name", queryName);
        }
        return "";
    }

    private String makePrimaryQuery(String finaQuery, String mappedCollection) {
        try {
            if (!StringUtils.isEmpty(finaQuery)) {
                String find = find(finaQuery);
                return makeQuery(find, mappedCollection);
            } else {
                return makeQuery(find(""), mappedCollection);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
