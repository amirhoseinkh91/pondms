package ir.viratech.pond_ms.api.filter;

import ir.viratech.base.SuppressWarningsOption;
import ir.viratech.commons.persistence.mongo.base.MongoDBManager;
import ir.viratech.pond_ms.model.layer.Layer;
import ir.viratech.pond_ms.model.layer.ParentLayer;
import ir.viratech.pond_ms.model.layer.logic.LayerMgr;
import ir.viratech.pond_ms.model.layer.logic.ParentLayerMgr;
import org.apache.commons.lang.StringUtils;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import ir.viratech.pond_ms.api.main_city_config.MainCityConfigService;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@SuppressWarnings(SuppressWarningsOption.ALL)
public class BaseMongoQueries {

    protected static final int onlyName = 1;
    protected static final int onlyNearby = 2;
    protected static final int onlyTag = 3;
    protected static final int onlyRate = 4;
    protected static final int onlyCity = 5;
    protected static final int tagAndName = 6;
    protected static final int cityAndName = 7;
    protected static final int nearbyAndName = 8;
    protected static final int rateAndName = 9;
    protected static final int tagAndRateAndName = 10;
    protected static final int tagAndNearbyAndName = 11;
    protected static final int tagAndcityAndName = 12;
    protected static final int cityAndRateAndName = 13;
    protected static final int nearbyAndRateAndName = 14;
    protected static final int nearbyAndRateAndTagAndName = 15;
    protected static final int tagAndCity = 16;
    protected static final int rateAndCity = 17;
    protected static final int nearbyAndTag = 18;
    protected static final int tagAndRate = 19;
    protected static final int nearbyAndRate = 20;
    protected static final int tagAndRateAndCity = 21;
    protected static final int tagAndRateAndNearby = 22;
    protected static final int noFilter = 23;

    protected int start;
    protected int length;
    protected boolean isManualSort;

    /*
     * By Amir Hosein Khalouei this class searches in mongoDB filtering
     */
    // collection names in mongoDB
    public static final String THINGS_TO_DO_COLLECTION = "things_to_do_col";
    public static final String HOTEL_COLLECTION = "hotel_col";
    public static final String RESTAURANT_COLLECTION = "restaurant_col";
    public static final String TOUR_COLLECTION = "tour_col";
    public static final String AGENCY_COLLECTION = "agency_col";
    public static final String CITY_COLLECTION = "city_col";


    public static final String THINGS_TO_DO_FROM_URL = "things-to-do";
    public static final String HOTEL_FROM_URL = "hotel";
    public static final String RESTAURANT_FROM_URL = "restaurant";
    public static final String TOUR_FROM_URL = "tour";
    public static final String AGENCY_FROM_URL = "agency";
    public static final String CITY_FROM_URL = "city";

    // Dot and Comma variables
    public static final String DOT = ".";
    public static final String COMMA = ",";

    // Maximum and Minimum length and start for pagination
    protected static final int MAX_LENGTH = 50;
    protected static final int MIN_LENGTH = 0;
    protected static final int MIN_START = 0;
    protected static final int ALL_DATA = -1;

    // input tags to search
    protected static final String INPUT_TAG_SPORT_GAME = "ورزش و سرگرمی"; // 6
    protected static final String INPUT_TAG_NATURE = "طبیعت گردی"; // 9
    protected static final String INPUT_TAG_WATER = "تفریحات آبی"; // 8
    protected static final String INPUT_TAG_SHOPPING_CENTER = "مراکز خرید"; // 18
    protected static final String INPUT_TAG_MUSEMN = "موزه"; // 12 DONE
    protected static final String INPUT_TAG_THEATER_CINEMA = "تئاتر و سینما"; // 19
    protected static final String INPUT_TAG_MOUNTAIN_CLIMBING = "کوهنوردی"; // 3
    protected static final String INPUT_TAG_RELIGIOUS_PLACES = "اماکن مذهبی"; // 15
    protected static final String INPUT_TAG_HISTORICAL_PLACES = "بناهای تاریخی"; // 16
    protected static final String INPUT_TAG_AQUARIUM = "آکواریوم"; // 17
    protected static final String INPUT_TAG_AMUSEMENT_PLACES = "جاذبه های تفریحی"; // 20

    // tags stored in DB
    protected static final String SEARCH_TAG_BALL_SPORTS = "ورزش توپی"; // 1
    protected static final String SEARCH_TAG_RACKET = "ورزش های راکتی"; // 2
    protected static final String SEARCH_TAG_MOUNTAIN_CLIMBING = "کوهنوردی"; // 3
    protected static final String SEARCH_TAG_HORSE_RIDING = "سوارکاری"; // 4
    protected static final String SEARCH_TAG_GAME = "بازی"; // 5
    protected static final String SEARCH_TAG_HOBBY = "سرگرمی"; // 6
    protected static final String SEARCH_TAG_OTHER = "ورزش ها و بازی های دیگر"; // 7
    protected static final String SEARCH_TAG_WATER_SPORTS = "ورزش های آبی"; // 8
    protected static final String SEARCH_TAG_NATURE = "جاذبه های طبیعت"; // 9
    protected static final String SEARCH_TAG_HANDMADE_PRODUCTS = "صنایع دستی"; // 10
    protected static final String SEARCH_TAG_SHOPPING_CENTER = "مراکز خرید"; // 11
    protected static final String SEARCH_TAG_MUSEMN = "موزه های ایران"; // 12
    protected static final String SEARCH_TAG_THEATER = "تئاتر و نمایش"; // 13
    protected static final String SEARCH_TAG_CINEMA = "فیلم و سینما";// 14
    protected static final String SEARCH_TAG_RELIGIOUS = "اماکن مذهبی"; // 15
    protected static final String SEARCH_TAG_CULTURAL_HERITAGE = "میراث فرهنگی"; // 16
    protected static final String SEARCH_TAG_AQUARIUM = "آکواریوم های ایران"; // 17
    protected static final String SEARCH_TAG_SHOPPING_FASHION = "خرید و مد"; // 18
    protected static final String SEARCH_TAG_ART_CULTURE = "فرهنگ و هنر"; // 19
    protected static final String SEARCH_TAG_AMUSEMENT_PLACES = "جاذبه های تفریحی"; // 20

    // Entity Type keys
    public static final String Things_To_Do_Entity_Type_Key = "Things_To_Do";
    public static final String Hotel_Entity_Type_Key = "Hotel";
    public static final String Restauran_Entity_Type_Key = "Restaurant";
    public static final String Agency_Entity_Type_Key = "Agency";

    // Manual Sorting
    public static final String ASC = "ASC";
    public static final int INT_ASC = 1;
    public static final String DSC = "DSC";
    public static final int INT_DSC = -1;


    private String sortBy;
    private String order;

    // basic methods
    public final MongoDBManager getMongoDBManager() {
        return MongoDBManager.getInstance();
    }

    public final String collectionMapper(String collection) {
        if (collection.equals(THINGS_TO_DO_FROM_URL))
            return THINGS_TO_DO_COLLECTION;
        else if (collection.equals(HOTEL_FROM_URL))
            return HOTEL_COLLECTION;
        else if (collection.equals(RESTAURANT_FROM_URL))
            return RESTAURANT_COLLECTION;
        else if (collection.equals(TOUR_FROM_URL))
            return TOUR_COLLECTION;
        else if (collection.equals(AGENCY_COLLECTION))
            return AGENCY_COLLECTION;
        else if (collection.equals(CITY_FROM_URL))
            return CITY_COLLECTION;
        else
            throw new IllegalArgumentException();
    }

    public String ThingsToDoTagMapper(String inputTag) {
        if (inputTag == null)
            return null;
        if (inputTag.equals(INPUT_TAG_SPORT_GAME))
            return SEARCH_TAG_HOBBY;

        if (inputTag.equals(INPUT_TAG_NATURE))
            return SEARCH_TAG_NATURE;

        if (inputTag.equals(INPUT_TAG_WATER))
            return SEARCH_TAG_WATER_SPORTS;

        if (inputTag.equals(INPUT_TAG_SHOPPING_CENTER))
            return SEARCH_TAG_SHOPPING_FASHION;

        if (inputTag.equals(INPUT_TAG_MUSEMN))
            return SEARCH_TAG_MUSEMN;

        if (inputTag.equals(INPUT_TAG_THEATER_CINEMA))
            return SEARCH_TAG_ART_CULTURE;

        if (inputTag.equals(INPUT_TAG_MOUNTAIN_CLIMBING))
            return SEARCH_TAG_MOUNTAIN_CLIMBING;

        if (inputTag.equals(INPUT_TAG_RELIGIOUS_PLACES))
            return SEARCH_TAG_RELIGIOUS;

        if (inputTag.equals(INPUT_TAG_HISTORICAL_PLACES))
            return SEARCH_TAG_CULTURAL_HERITAGE;

        if (inputTag.equals(INPUT_TAG_AQUARIUM))
            return SEARCH_TAG_AQUARIUM;

        if (inputTag.equals(INPUT_TAG_AMUSEMENT_PLACES))
            return SEARCH_TAG_AMUSEMENT_PLACES;

        return null;
    }

    public final String rate(String collection, String rateStr) {
        if (collectionMapper(collection).equals(HOTEL_COLLECTION))
            return rate_Hotel(rateStr);

        if (collectionMapper(collection).equals(THINGS_TO_DO_COLLECTION))
            return rate_ThingsToDo(rateStr);

        if (collectionMapper(collection).equals(RESTAURANT_COLLECTION))
            return rate_Restaurant(rateStr);
        return null;
    }

    public final String rate_Hotel(String rateStr) {
        try {
            return "{Rate:" + Integer.parseInt(rateStr) + "}";
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public final String gte(String field, String value) {
        try {
            return "{" + field + ":" + "{$gte:" + Integer.parseInt(value) + "}}";
        } catch (NumberFormatException e) {
            return null;
        }
    }


    public final String lte(String field, String value) {
        try {
            return "{" + field + ":" + "{$lte:" + Integer.parseInt(value) + "}}";
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public final String hotel_Rate(String score) {
        try {
            return "{Score:" + "{$gte:" + Integer.parseInt(score) + "}}";
        } catch (Exception e) {
            return null;
        }
    }

    public final String rate_Restaurant(String rateStr) {
        if (!rateStr.contains(",")) {
            return "{Price:" + Integer.parseInt(rateStr.trim()) + "}";
        } else {
            String[] parts = rateStr.split(",");
            Integer[] rates = new Integer[parts.length];
            for (int i = 0; i < parts.length; i++)
                rates[i] = Integer.parseInt(parts[i].trim());
            return or("Price", rates);
        }
    }

    public String or(String field, Integer... values) {
        StringBuilder builder = new StringBuilder("{$or : [");
        for (int i = 0; i < values.length; i++) {
            builder.append("{" + field + ":" + values[i] + "}");
            if (i < values.length - 1)
                builder.append(",");
        }
        builder.append("]}");
        return builder.toString();
    }

    public String or(String field, String[] values) {
        StringBuilder builder = new StringBuilder("{$or : [");
        for (int i = 0; i < values.length; i++) {
            builder.append("{" + field + ":" + "\"" + values[i] + "\"" + "}");
            if (i < values.length - 1)
                builder.append(",");
        }
        builder.append("]}");
        return builder.toString();
    }

    public String or_logical(String[] values) {
        StringBuilder builder = new StringBuilder("{$or : [");
        for (int i = 0; i < values.length; i++) {
            builder.append("" + values[i] + "");
            if (i < values.length - 1)
                builder.append(",");
        }
        builder.append("]}");
        return builder.toString();
    }

    public final String rate_ThingsToDo(String rateStr) {
        int rate = Integer.parseInt(rateStr);
        switch (rate) {
            case 2:
                return "{$or : [{Rate : " + 3 + "} , {Rate : " + 4 + "}]}";
            case 3:
                return "{$or : [{Rate : " + 5 + "} , {Rate : " + 6 + "}]}";
            case 4:
                return "{$or : [{Rate : " + 7 + "} , {Rate : " + 8 + "}]}";
            case 5:
                return "{$or : [{Rate : " + 9 + "} , {Rate : " + 10 + "}]}";
            default:
                return null;
        }
    }

    public final String pagination() {
        if (this.length == 0 && this.start == 0)
            return "skip(" + start + ")";

        if (this.length == -1)
            return "skip(" + start + ")";
        return "skip(" + start + ").limit(" + length + ")";
    }

    public final String sortBy(Map<String, Integer> keyValues) {
        // -1 is default
        if (keyValues.containsKey("Rate") && keyValues.get("Rate").equals(-1)){
            keyValues.remove("Rate");
        }
        keyValues.put("IntrinsicValue", -1);
        StringBuilder builder = new StringBuilder("sort(");
        int counter = 0;
        for (String field : keyValues.keySet()) {
            builder.append("{'" + field + "' : " + keyValues.get(field) + "}");
            if ((++counter) < keyValues.size())
                builder.append(",");
        }
        builder.append(")");
        return builder.toString();
    }

    public String set(Map<String, Object> keyValues) {
        StringBuilder builder = new StringBuilder("{$set : {");
        int counter = 0;
        for (String key : keyValues.keySet()) {
            builder.append(key + ":" + keyValues.get(key));
            if ((counter++) < keyValues.size() - 1)
                builder.append(COMMA);
        }
        builder.append("}}");
        return builder.toString();
    }

    public String unset(Map<String, Object> keyValues) {
        StringBuilder builder = new StringBuilder("{$unset : {");
        int counter = 0;
        for (String key : keyValues.keySet()) {
            if (keyValues.get(key) != null)
                builder.append("'" + key + "'" + ":" + keyValues.get(key));
            else
                builder.append("'" + key + "'" + ":" + "\"\"");
            if ((counter++) < keyValues.size() - 1)
                builder.append(COMMA);
        }
        builder.append("}}");
        return builder.toString();
    }

    private String update(String query, String set, boolean multi) {
        StringBuilder builder = new StringBuilder("update(");
        builder.append(query + COMMA);
        builder.append(set + COMMA);
        builder.append("{ multi:" + multi + "}");
        builder.append(")");
        return builder.toString();
    }

    public String baseMongoUpdateQuery(String collection, String query, String set, boolean multi) {
        return db() + DOT + getCollection(collection) + DOT + update(query, set, multi);
    }

    public final String nearby(String x, String y, String dist) {
        try {
            return "{point:{$near:{$geometry:{type:\"Point\",coordinates:[" + y + "," + x + "]},$maxDistance:" + dist
                    + "}}}";
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public final String tag(String inputTag, String collection) {
        if (collection.equals(RESTAURANT_FROM_URL)) {
            return restaurantTagMapper(inputTag);
        } else if (collection.equals(THINGS_TO_DO_FROM_URL))
            return "{\"Tags\" :{$regex : \".*" + ThingsToDoTagMapper(inputTag) + ".*\"}}";
        else
            return null;
    }

    private String restaurantTagMapper(String inputTag) {
        return "{\"Tags\" :{$regex : \".*" + inputTag + ".*\"}}";
    }

    public final String toArray() {
        return "toArray()";
    }

    public final String getCollection(String collection) {
        return "getCollection('" + collectionMapper(collection) + "')";
    }

    public final String isDeleted(boolean b) {
        return "{'_isDeleted' : " + b + "}";
    }

    public final String layerUid(String uid) {
        Layer layer = LayerMgr.getInstance().getByExtuid(uid);
        List<Layer> subLayers = LayerMgr.getInstance().getAllSubLayers(layer);
        if (subLayers.size() == 1)
            return "{\"layer_uid\" : \"" + subLayers.get(0).getExtuid() + "\"}";
        ParentLayer parentLayer = ParentLayerMgr.getInstance().getByExtuid(uid);
        String query = "{\"layer_uid\" : {\"$in\" : [";
        boolean first = true;
        for (Layer subLayer : subLayers) {
            if (first) {
                query += "\"" + subLayer.getExtuid() + "\"";
                first = false;
            } else
                query += ",\"" + subLayer.getExtuid() + "\"";
        }
        query += "]}}";
        return query;
    }

    public final String db() {
        return "db";
    }

    public final String regex(String field, String value) {
        return "{'" + field + "':{$regex : \".*" + value + ".*\"}}";
    }

    public final String regex_For_Tag(String field, String value) {
        return "{'" + field + "':{$regex : \".*" + value + ".*\"}}";
    }

    public final String equals(String field, String value) {
        return "{'" + field + "': '" + value + "'}";
    }

    public final String eq(String field, String value) {
        return "{" + field + ": " + value + "}";
    }

    public final String equals(String field, int value) {
        return "{'" + field + "': " + value + " }";
    }

    public final String equals(String field, double value) {
        return "{'" + field + "': " + value + " }";
    }

    public final String equals(String field, boolean value) {
        return "{'" + field + "': " + value + " }";
    }

    public final String appendQueries(String... queries) {
        String query = "";
        for (int i = 0; i < queries.length; i++) {
            if (i < queries.length - 1)
                query += queries[i] + COMMA;
            if (i == queries.length - 1)
                query += queries[i];
        }
        return query;
    }

    public final String and(Object... objects) throws InstantiationException, IllegalAccessException {
        StringBuilder builder = StringBuilder.class.newInstance();
        builder.append("{$and :[");
        if (isManualSort) {
            if (StringUtils.isEmpty(sortBy)) {
                builder.append(exists("lowestPrice", true) + COMMA);
                builder.append("{\"lowestPrice\":{$ne:null}}" + COMMA);
            }
        }
        for (int i = 0; i < objects.length; i++) {
            if (objects[i] != null) {
                builder.append(objects[i].toString());
                if (i < objects.length - 1)
                    builder.append(COMMA);
            }
        }
        builder.append("]}");
        return builder.toString();
    }

    public final String exists(String field, boolean b) {
        return "{'" + field + "' : {$exists : " + b + " } }";
    }

    public final String find(String query, Map<String, Integer> options) throws InstantiationException, IllegalAccessException {
        StringBuilder builder = StringBuilder.class.newInstance();
        builder.append("find(");
        builder.append(query + "" + COMMA);
        int counter = 0;
        builder.append("{");
        for (String key : options.keySet()) {
            builder.append("'" + key + "':" + options.get(key));
            if ((counter++) < options.size() - 1)
                builder.append(COMMA);
        }
        builder.append("})");


        return builder.toString();
    }

    public final String create_index(String field, String value) {
        return "createIndex({" + field + ":\"" + value + "\"})";
    }

    public final String find(String query) throws InstantiationException, IllegalAccessException {
        StringBuilder builder = StringBuilder.class.newInstance();
        builder.append("find(");

        if (query.equals("") || query == null || query.trim().equals(""))
            builder.append("{}");
        else
            builder.append(query);

        builder.append(")");
        return builder.toString();
    }

    public final String column_Filter(String column) {
        return "{" + column + ":" + "1}";
    }

    public final String multiple_Column_Filter(String... columns) {
        String query = "";
        for (int i = 0; i < columns.length; i++) {

            if (i == 0) {
                query += "{";
            }

            if (i < columns.length - 1) {
                if (columns[i].equals("_id")) {
                    query += columns[i] + ":" + 0 + ",";
                    continue;
                }
                query += columns[i] + ":" + 1 + ",";
            } else {
                if (columns[i].equals("_id")) {
                    query += columns[i] + ":" + 0 + "}";
                    continue;
                }
                query += columns[i] + ":" + 1 + "}";
            }

        }
        return query;
    }

    public final String remove(String collection, String query, boolean justOne) {
        StringBuilder builder = new StringBuilder(db() + DOT + getCollection(collection) + DOT);
        builder.append("remove(");
        builder.append(query + COMMA);
        builder.append("{justOne:" + justOne + "}");
        builder.append(")");
        return builder.toString();

    }

    public final String baseQueryMaker(String find, String collection, boolean sortByTotalscore) {

        int order = -1;
        Map<String, Integer> map = new HashMap<>();
        map.put("IntrinsicValue", -1);
        if (isManualSort) {
            if (this.order.equals(ASC))
                order = 1;
            if (this.order.equals(DSC))
                order = -1;
            if (StringUtils.isEmpty(sortBy)) {
                if (collection.equals("hotel"))
                    map.put("lowestPrices", order);
            } else if (!StringUtils.isEmpty(sortBy)) {
                if (!sortBy.equals("Rate") || order != -1) {
                    map.put(sortBy, order);
                }
            }
            return db() + DOT + getCollection(collection) + DOT + find + DOT + pagination() + DOT + sortBy(map) + DOT
                    + toArray();
        } else {
            if (sortByTotalscore) {
                map.put("TotalScore", -1);
                return db() + DOT + getCollection(collection) + DOT + find + DOT + pagination() + DOT + sortBy(map)
                        + DOT + toArray();
            } else {
                return db() + DOT + getCollection(collection) + DOT + find + DOT + pagination() + DOT + toArray();
            }
        }
    }

    public final String makeQuery(String find, String collection) {
        return db() + DOT + "getCollection('" + collection + "')" + DOT + find;
    }


    public final String executableQuery(String makeQuery, String sortBy) {
        return makeQuery + DOT + sortBy + DOT + pagination() + DOT + toArray();
    }

    public final String executableQueryWithoutSort(String makeQuery) {
        return makeQuery + DOT + sortBy(new HashMap<>()) + DOT + pagination() + DOT + toArray();
    }

    public void paginationConverter(String start, String len) {
        try {
            int s = Integer.parseInt(start);
            if (s < MIN_START)
                this.start = MIN_START;
            else
                this.start = Integer.parseInt(start);
        } catch (Exception e) {
            this.start = MIN_START;
        }

        try {
            int l = Integer.parseInt(len);
            if (l <= MAX_LENGTH && l >= MIN_LENGTH)
                this.length = l;
            else
                this.length = MAX_LENGTH;
        } catch (Exception e) {
            this.length = MAX_LENGTH;
        }
    }

    public void paginationConverterForSearchAll(String start, String len) {
        try {
            int s = Integer.parseInt(start) / 2;
            if (s < MIN_START / 2)
                this.start = MIN_START;
            else
                this.start = s;
        } catch (Exception e) {
            this.start = MIN_START;
        }

        try {
            int l = Integer.parseInt(len) / 2;
            if (l <= MAX_LENGTH / 2 && l >= MIN_LENGTH / 2)
                this.length = l;
            else
                this.length = MAX_LENGTH / 2;
        } catch (Exception e) {
            this.length = MAX_LENGTH / 2;
        }
    }

    public final String countAndExecute(String makeQuery) {
        return makeQuery + DOT + "count()";
    }

    public boolean isManualSort(String sortBy, String order) {
        try {
            if (sortBy != null)
                this.sortBy = sortBy;
            else
                return false;
            if (order.equals(ASC) || order.equals(DSC))
                this.order = order;
            else
                return false;
            return true;
        } catch (Exception e) {
            return false;
        }

    }

}
