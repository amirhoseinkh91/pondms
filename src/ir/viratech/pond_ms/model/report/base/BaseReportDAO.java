package ir.viratech.pond_ms.model.report.base;

import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import ir.viratech.commons.spring.tx.ReadTransactional;
import ir.viratech.commons.spring.tx.WriteTransactional;
import ir.viratech.pond_ms.core.mongodb.dao.AbstractMongodbDAO;
import ir.viratech.pond_ms.core.spring.ApplicationContextUtil;
import ir.viratech.pond_ms.model.report.Report;

/**
 * Created by amir on 9/7/17.
 */
@ReadTransactional
@WriteTransactional
public class BaseReportDAO extends AbstractMongodbDAO<Report> {

    public static final String REPORT_COLLECTION = "report_col";

    @Override
    public String getCollectionName() {
        return REPORT_COLLECTION;
    }

    @Override
    protected Query roleHandler() {
        super.roleHandler();
        return null;
    }


    @Override
    protected void add(Report report) {
        report.setUid(generateUid());
        report.setCreationDate(new Date());
        if (ApplicationContextUtil.getCurrentExecutionContext().getUsername() != null)
            report.setCreator(ApplicationContextUtil.getCurrentExecutionContext().getUsername());
        else
            report.setCreator(Report.UNKNOWN_FA);
        report.setId(new ObjectId());
        getMongoTemplate().insert(report);
    }

    @Override
    protected void update(Report report) {
        this.update(report.getUid(), report);
    }

    @Override
    protected void update(String uid, Report report) {
        Report oldObj = this.getByUid(uid);
        oldObj = report;
        getMongoTemplate().save(oldObj);
    }


    @Override
    protected void remove(String uid) {
        this.remove(this.getByUid(uid));
    }

    @Override
    protected void remove(Report report) {
        getMongoTemplate().remove(new Query(Criteria.where(Report.PROP_ID).is(report.getId())), Report.class);
    }

    @Override
    protected Report getByUid(String uid) {
        return getMongoTemplate().findOne(new Query(Criteria.where(Report.PROP_UID).is(uid)), Report.class);
    }

    @Override
    protected List<Report> getAll() {
        return getMongoTemplate().findAll(Report.class);
    }

    @Override
    protected List<Report> getAll(Integer start, Integer len) {
        paginationConverter(start, len);
        return getMongoTemplate().find(new Query().skip(super.start).limit(super.length), Report.class);
    }

}
