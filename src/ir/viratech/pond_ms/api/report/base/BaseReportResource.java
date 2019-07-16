package ir.viratech.pond_ms.api.report.base;

import ir.viratech.pond_ms.api.AbstractMongoObjectResource;
import ir.viratech.pond_ms.model.report.Report;
import ir.viratech.pond_ms.model.report.logic.ReportMgr;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by amir on 9/10/17.
 */
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class BaseReportResource extends AbstractMongoObjectResource<Report>{

    public final static String PATH__ITEMS = "/report/items";

    @Override
    public Report save(Report r){
        ReportMgr.getInstance().save(r);
        return null;
    }

    @Override
    public Report update(Report r) {
        ReportMgr.getInstance().update(r);
        return null;
    }

    @Override
    public Report getByUid(String uid) {
        return ReportMgr.getInstance().getByUid(uid);
    }

    @Override
    public List<Report> list(Integer start, Integer len) {
        return ReportMgr.getInstance().list(start ,len);
    }

    @Override
    public void remove(String uid) {
        ReportMgr.getInstance().remove(uid);
    }
}
