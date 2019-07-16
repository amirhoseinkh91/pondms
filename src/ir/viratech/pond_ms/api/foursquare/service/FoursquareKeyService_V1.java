package ir.viratech.pond_ms.api.foursquare.service;

import ir.viratech.commons.api.dto.DtoUtil;
import ir.viratech.commons.utils.MyDateUtils;
import ir.viratech.pond_ms.api.foursquare.dto.FoursquareKeyFullDTO;
import ir.viratech.pond_ms.model.foursquare.FoursquareKey;
import ir.viratech.pond_ms.model.foursquare.exception.NoAvailableFoursquareKeyFoundException;
import ir.viratech.pond_ms.model.foursquare.logic.FoursquareKeyMgr;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/foursquare-key")
public class FoursquareKeyService_V1 {

    @GET
    @Path("/available")
    public FoursquareKeyFullDTO getAvailable(){
        FoursquareKey foursquareKey;
        try {
            foursquareKey = FoursquareKeyMgr.getInstance().getAvailable();
            return DtoUtil.createAndLoadDto(FoursquareKeyFullDTO.class, foursquareKey);
        } catch (NoAvailableFoursquareKeyFoundException e) {
            System.out.println(e.getMessage());
        }
        return new FoursquareKeyFullDTO();
    }

    @POST
    @Path("/update")
    public void updateUsage(FoursquareKeyFullDTO fullDTO) {
        FoursquareKey key = DtoUtil.saveDtoAndGetObject(fullDTO, FoursquareKeyMgr.getInstance().getByExtuid(fullDTO.getUid()));
        key.setLastUsedDate(MyDateUtils.now());
        key.setBusy(false);
        FoursquareKeyMgr.getInstance().update(key);
    }

}
