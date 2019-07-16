package ir.viratech.pond_ms.model.tour_relations.tour.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.WriteResult;

import ir.viratech.commons.util.jackson.JacksonUtils;
import ir.viratech.just_ro.model.calendar.CalendarTool;
import ir.viratech.pond_ms.core.spring.ApplicationContextUtil;
import ir.viratech.pond_ms.model.tour_relations.tour.CustomerInput;
import ir.viratech.pond_ms.model.tour_relations.tour.MainTourInformation;
import ir.viratech.pond_ms.model.tour_relations.tour.Tour;
import ir.viratech.pond_ms.model.tour_relations.tour.base.BaseTourDAO;
import ir.viratech.pond_ms.model.user.User;
import ir.viratech.pond_ms.model.user.role.UserRole;

public class TourDAO extends BaseTourDAO {

    public void delete(Tour tour) {
        tour.setDeleted(true);
        tour.setEnabled(false);
        this.update(tour);
    }

    public Set<String> getDstCities(String srcCity) {
        Set<String> dstCities = new HashSet<>();
        Query query = initQuery(false, true);
        query.addCriteria(Criteria.where(Tour.PROP_MAIN_INFO_COMPONENT + "." + MainTourInformation.PROP_SRC_CITY).is(srcCity));
        List<Tour> tours = getMongoTemplate().find(query, Tour.class);
        List<Tour> availableTours = checkDateValidation(tours);
        for (Tour tour : availableTours)
            dstCities.addAll(tour.getMainInformation().getDstCities());
        return dstCities;
    }

    public Set<String> getSrcCities() {
        Set<String> srcCities = new HashSet<>();
        Query query = initQuery(false, true);
        List<Tour> tours = getMongoTemplate().find(query, Tour.class);
        List<Tour> availableTours = checkDateValidation(tours);
        for (Tour tour : availableTours)
            srcCities.add(tour.getMainInformation().getSrcCity());
        return srcCities;
    }

    private List<Tour> checkDateValidation(List<Tour> tours) {
        List<Tour> availableTours = new ArrayList<>();
        if (tours.size() > 0)
            for (int i = 0; i < tours.size(); i++)
                if (isTourAvailable(tours.get(i)))
                    availableTours.add(tours.get(i));
        return availableTours;
    }

    private boolean isTourAvailable(Tour tour) {
        CalendarTool calendarTool = new CalendarTool();
        String today = calendarTool.getIranianToday();
        try {
            if (Integer.parseInt(tour.getMainInformation().getDate().replaceAll("/", "")) >= Integer.parseInt(today.replaceAll("/", "")))
                return true;
            else
                return false;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public List<Tour> getAll(CustomerInput customerInput) {
        paginationConverter(customerInput.getStart(), customerInput.getLen());
        Query query = this.roleHandler();
        if (customerInput.getSrcCity() != null)
            query.addCriteria(Criteria.where(Tour.PROP_MAIN_INFO_COMPONENT + "." + MainTourInformation.PROP_SRC_CITY).is(customerInput.getSrcCity()));
        if (customerInput.getDstCity() != null)
            query.addCriteria(Criteria.where(Tour.PROP_MAIN_INFO_COMPONENT + "." + MainTourInformation.PROP_DST_CITIES).in(customerInput.getDstCity()));
        query.skip(super.start).limit(super.length);
        return getMongoTemplate().find(query, Tour.class);
    }


    private Map<String, Integer> options = new HashMap<>();
//    private MongoDBManager manager;
//
//    public TourDAO() {
//        this.manager = MongoDBManager.getInstance();
//    }

    public JsonNode getAll(CustomerInput input, String start, String len) {
        ArrayNode results = JacksonUtils.createEmptyArrayNode();
        paginationConverter(Integer.parseInt(start), Integer.parseInt(len));
        DBCollection collection = getCollection();
        DBObject query = new BasicDBObject();
        List<String> fields = input.getNotNullFields();
        for (int i = 0; i < fields.size(); i++) {
            if (fields.get(i).equals("dstCity"))
                query.put(Tour.PROP_MAIN_INFO_COMPONENT + super.baseMongoQueries.DOT + MainTourInformation.PROP_DST_CITIES, input.get(fields.get(i)));
            if (fields.get(i).equals("dstCountry"))
                query.put(Tour.PROP_MAIN_INFO_COMPONENT + super.baseMongoQueries.DOT + MainTourInformation.PROP_DST_COUNTRIES, input.get(fields.get(i)));
            if (fields.get(i).equals("srcCity"))
                query.put(Tour.PROP_MAIN_INFO_COMPONENT + super.baseMongoQueries.DOT + MainTourInformation.PROP_SRC_CITY, input.get(fields.get(i)));
        }
        DBObject sort = new BasicDBObject();
        sort.put(Tour.PROP_TOTAL_SCORE, super.baseMongoQueries.INT_DSC);
        DBCursor dbCursor = collection.find(query).sort(sort).skip(super.start).limit(super.length);
        while (dbCursor.hasNext()) {
            DBObject dbObject = dbCursor.next();
            try {
                results.add(JacksonUtils.convertStringToJsonNode(dbObject.toString()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return results;
    }

    public JsonNode getAll(String start, String len, String extent) throws IllegalArgumentException,
            InstantiationException, IllegalAccessException, IOException {
        super.paginationConverter(Integer.parseInt(start), Integer.parseInt(len));
        boolean isSysadmin = false;
        boolean isAgency = false;
        User user = ApplicationContextUtil.getCurrentExecutionContext().getUser();
        Set<UserRole> roles = user.getRoles();
        for (UserRole userRole : roles) {
            if (userRole.getName().equals("sysadmin"))
                isSysadmin = true;
            if (userRole.getName().equals("AGENCY_ROLE"))
                isAgency = true;
        }
        options.put("_id", 0);

        if (isSysadmin) {
            extentHandler(extent, options);
            return super.baseMongoQueries.getMongoDBManager().executeQuery(baseMongoQueries.baseQueryMaker(baseMongoQueries.find(null, options), baseMongoQueries.TOUR_FROM_URL, true));
        } else if (isAgency) {
            if (extent == null)
                extentHandler(extent, options);
            else if (extent.equals("full"))
                setQueryOptionsForNonAdmins(options);
            return super.baseMongoQueries.getMongoDBManager()
                    .executeQuery(baseMongoQueries.baseQueryMaker(
                            baseMongoQueries.find(baseMongoQueries.and(baseMongoQueries.equals(Tour.PROP_IS_DELETED, false),
                                    baseMongoQueries.equals(Tour.PROP_AGENCY_USERNAME, user.getUsername())), options),
                            baseMongoQueries.TOUR_FROM_URL, false));
        } else {
            if (extent == null)
                extentHandler(extent, options);
            else if (extent.equals("full"))
                setQueryOptionsForNonAdmins(options);
            return super.baseMongoQueries.getMongoDBManager().executeQuery(baseMongoQueries.baseQueryMaker(
                    baseMongoQueries.find(baseMongoQueries.and(baseMongoQueries.equals(Tour.PROP_IS_DELETED, false), baseMongoQueries.equals(Tour.PROP_IS_ENABLED, true)), options),
                    baseMongoQueries.TOUR_FROM_URL, true));
        }
    }

    private void extentHandler(String extent, Map<String, Integer> options2) throws IllegalArgumentException {
        if (extent == null) {
            options.put(Tour.PROP_UID, 1);
            options.put(Tour.PROP_MAIN_INFO_COMPONENT + baseMongoQueries.DOT + MainTourInformation.PROP_NAME, 1);
        } else if (extent != null && (!extent.equals("full")))
            throw new IllegalArgumentException();
    }

    private Map<String, Integer> setQueryOptionsForNonAdmins(Map<String, Integer> options) {
        options.put(Tour.PROP_IS_ENABLED, 0);
        options.put(Tour.PROP_IS_DELETED, 0);
        options.put(Tour.PROP_AGENCY_USERNAME, 0);
        options.put(Tour.PROP_INTRNSIC_VALUE, 0);
        options.put(Tour.PROP_TOTAL_SCORE, 0);
        options.put(Tour.PROP_RATE, 0);
        options.put(Tour.PROP_TEMPORAL_VALUE, 0);
        return options;
    }

    public void deleteByUid(String uid) {
        try {
            Map<String, Object> sets = new java.util.HashMap<>();
            sets.put(Tour.PROP_IS_DELETED, true);
            sets.put(Tour.PROP_IS_ENABLED, false);
            super.baseMongoQueries.getMongoDBManager().executeQuery(baseMongoQueries.baseMongoUpdateQuery(baseMongoQueries.TOUR_FROM_URL, baseMongoQueries.equals(Tour.PROP_UID, uid), baseMongoQueries.set(sets), false));
        } catch (IOException e) {

        }
    }

    public void deleteDayByUid(String uid, String day) {
        DBCollection collection = baseMongoQueries.getMongoDBManager().getCollection("tour_col");
        DBObject query = new BasicDBObject(Tour.PROP_UID, uid);
        DBObject update = new BasicDBObject();
        update.put("$unset", new BasicDBObject(day, 1));
        WriteResult result = collection.update(query, update);
    }

    public JSONObject getByUid_asJSONObject(String uid) {
        try {
            String res = super.baseMongoQueries.getMongoDBManager()
                    .executeQuery(baseMongoQueries.baseQueryMaker(baseMongoQueries.find(baseMongoQueries.and(baseMongoQueries.equals(Tour.PROP_UID, uid))), baseMongoQueries.TOUR_FROM_URL, true)).get(0)
                    .toString();
            return new JSONObject(res);
        } catch (InstantiationException | IllegalAccessException | IOException | JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Tour addAndReturn(Tour tour) {
        super.add(tour);
        return this.getByUid(super.getUid());
    }

}
