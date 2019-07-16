package ir.viratech.pond_ms.model.report.base;

import ir.viratech.commons.spring.context.ApplicationContextProvider;
import ir.viratech.pond_ms.core.mongodb.logic.AbstractMongodbMgr;
import ir.viratech.pond_ms.model.report.Report;
import ir.viratech.pond_ms.model.report.dao.ReportDAO;
import ir.viratech.pond_ms.model.report.logic.ReportMgr;

import java.util.List;

/**
 * Created by amir on 9/7/17.
 */
public class BaseReportMgr extends AbstractMongodbMgr<Report> {

    @Override
    protected ReportDAO getDAO() {
        return new ReportDAO();
    }

    public static ReportMgr getInstance() {
        return (ReportMgr) ApplicationContextProvider.getInitializedApplicationContext().getBean(ReportMgr.class);
    }

    @Override
    public Report createNew() {
        return (Report) ApplicationContextProvider.getInitializedApplicationContext().getBean(Report.class);
    }

    @Override
    public void save(Report report) {
        this.getDAO().add(report);
    }

    @Override
    public void update(Report report) {
        this.getDAO().update(report);
    }

    @Override
    public void update(Report report, String uid) {
        this.getDAO().update(uid,report);
    }

    @Override
    public void remove(Report report) {
        this.getDAO().remove(report);
    }

    @Override
    public void remove(String uid) {
        this.getDAO().remove(uid);
    }

    @Override
    public Report getByUid(String uid) {
        return this.getDAO().getByUid(uid);
    }

    @Override
    public List<Report> list() {
        return this.getDAO().getAll();
    }

    @Override
    public List<Report> list(Integer start, Integer len) {
        return this.getDAO().getAll(start, len);
    }
}
