package ir.viratech.pond_ms.model.tour_relations.tour.base;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;

import ir.viratech.just_ro.model.calendar.CalendarTool;
import ir.viratech.pond_ms.api.filter.BaseMongoQueries;
import ir.viratech.pond_ms.core.mongodb.dao.AbstractMongodbDAO;
import ir.viratech.pond_ms.core.spring.ApplicationContextUtil;
import ir.viratech.pond_ms.model.tour_relations.tour.MainTourInformation;
import ir.viratech.pond_ms.model.tour_relations.tour.Tour;

/**
 * Created by amir on 9/6/17.
 */
public class BaseTourDAO extends AbstractMongodbDAO<Tour> {

    public static final String TOUR_COLLECTION = "tour_col";
    private String uid;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    protected BaseMongoQueries baseMongoQueries = new BaseMongoQueries();

    protected DBCollection getCollection() {
        return baseMongoQueries.getMongoDBManager().getCollection(TOUR_COLLECTION);
    }

    private void initialize(Tour tour) {
        this.uid = super.generateUid();
        tour.setUid(uid);
        tour.setEnabled(false);
        tour.setDeleted(false);
        tour.setIntrinsicValue(0);
        tour.setRate(0);
        tour.setTemporalValue(0);
        tour.setCreationDate(new Date());
        tour.setCreator(ApplicationContextUtil.getCurrentExecutionContext().getUsername());
        try {
            super.roleHandler();
            if (isAgency)
                tour.setAgency_username(ApplicationContextUtil.getCurrentExecutionContext().getUser().getUsername());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected Query initQuery(boolean isDeleted, boolean isEnabled) {
        Query query = new Query();
        query.addCriteria(Criteria.where(Tour.PROP_IS_ENABLED).is(isEnabled));
        query.addCriteria(Criteria.where(Tour.PROP_IS_DELETED).is(isDeleted));
        return query;
    }

    protected DBObject initQuery() {
        DBObject query = new BasicDBObject();
        query.put(Tour.PROP_IS_DELETED, false);
        query.put(Tour.PROP_IS_ENABLED, true);
        return query;
    }

    @Override
    protected void add(Tour tour) {
        initialize(tour);
        getMongoTemplate().insert(tour);
    }

    @Override
    protected void update(Tour tour) {
        this.update(tour.getUid(), tour);
    }

    @Override
    protected void update(String uid, Tour tour) {
        Tour oldObject = this.getByUid(uid);
        tour.setId(oldObject.getId());
        tour.setUid(uid);
        if (tour.getMainInformation() != null)
            this.removeExtraDays(this.getByUid(uid), tour);
        getMongoTemplate().save(tour);
    }

    private void removeExtraDays(Tour oldTour, Tour newTour) {
        Integer oldDays = Integer.parseInt(oldTour.getMainInformation().getDuration());
        Integer newDays = Integer.parseInt(newTour.getMainInformation().getDuration());
        if (newDays < oldDays)
            newTour.removeExtraDays(oldDays - newDays);
    }

    @Override
    protected void remove(String uid) {
        getMongoTemplate().remove(new Query(Criteria.where(Tour.PROP_UID).is(uid)), Tour.class);
    }

    @Override
    protected void remove(Tour tour) {
        this.remove(tour.getUid());
    }

    @Override
    protected Tour getByUid(String uid) {
        Query query = this.roleHandler();
        query.addCriteria(Criteria.where(Tour.PROP_UID).is(uid));
        return getMongoTemplate().findOne(query, Tour.class);
    }

    @Override
    protected List<Tour> getAll() {
        return getMongoTemplate().find(new Query().with(this.sort(Sort.Direction.DESC, Tour.PROP_TOTAL_SCORE)),Tour.class);
    }

    @Override
    protected List<Tour> getAll(Integer start, Integer len) {
        paginationConverter(start, len);
        Query query = this.roleHandler();
        query = query.with(this.sort(Sort.Direction.DESC, Tour.PROP_TOTAL_SCORE));
        return getMongoTemplate().find(query, Tour.class);
    }

    @Override
    public String getCollectionName() {
        return TOUR_COLLECTION;
    }

    @Override
    protected Query roleHandler() {
        super.roleHandler();
        Query query = new Query();
        try {
            if (isNormUser || isProUser || isMobileAdmin)
                query = initQuery(false, true);
            if (isAgency)
                query = new Query(Criteria.where(Tour.PROP_AGENCY_USERNAME)
                        .is(ApplicationContextUtil.getCurrentExecutionContext().getUsername()))
                        .addCriteria(Criteria.where(Tour.PROP_IS_DELETED).is(false));
        } catch (NullPointerException e) {
        }
        query = query.addCriteria(Criteria.where(Tour.PROP_MAIN_INFO_COMPONENT + "." + MainTourInformation.PROP_DATE)
                .gte(new CalendarTool().getIranianToday()));
        return query;
    }
}
