package ir.viratech.pond_ms.api.report;

import ir.viratech.pond_ms.api.report.base.BaseReportResource;
import ir.viratech.pond_ms.api.report.dto.ReportFullDTO;
import ir.viratech.pond_ms.model.report.Report;
import ir.viratech.pond_ms.model.report.logic.ReportMgr;

import javax.ws.rs.*;
import java.util.List;

/**
 * Created by amir on 9/10/17.
 */
@Path(BaseReportResource.PATH__ITEMS)
public class ReportResource extends BaseReportResource {

    @POST
    public void save(ReportFullDTO r) {
        super.save(ReportFullDTO.parse(r));
    }

    @POST
    @Path("/{uid}")
    public Report update(Report r) {
        super.update(r);
        return r;
    }

    @GET
    @Path("/{uid}")
    public Report getByUid(@PathParam("uid") String uid) {
        return super.getByUid(uid);
    }

    @GET
    public List<Report> list(@QueryParam("start") int start, @QueryParam("len") int len) {
        return super.list(start, len);
    }

    @DELETE
    @Path("/{uid}")
    public void remove(@PathParam("uid") String uid) {
        super.remove(uid);
    }
}
