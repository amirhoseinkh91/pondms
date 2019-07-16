package ir.viratech.pond_ms.api.place_report;

import ir.viratech.commons.api.dto.DtoUtil;
import ir.viratech.pond_ms.api.place_report.dto.PlaceReportLightDTO;
import ir.viratech.pond_ms.model.place_report.PlaceReport;
import ir.viratech.pond_ms.model.place_report.logic.PlaceReportMgr;
import org.springframework.web.bind.annotation.RequestBody;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/place-report")
public class PlaceReportService {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/add")
    public Response tagsCount(@RequestBody PlaceReportLightDTO lightDTO) {
        PlaceReport placeReport = DtoUtil.saveDtoAndGetObject(lightDTO, PlaceReportMgr.getInstance().createNew());
        PlaceReportMgr.getInstance().add(placeReport);
        return Response.ok(DtoUtil.createAndLoadDto(PlaceReportLightDTO.class,placeReport)).build();
    }
}
