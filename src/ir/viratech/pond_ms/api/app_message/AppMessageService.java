package ir.viratech.pond_ms.api.app_message;

import ir.viratech.commons.api.dto.DtoUtil;
import ir.viratech.commons.api.dto.SimpleTabularCollectionDTO_NoFieldInfo;
import ir.viratech.commons.api.service.AbstractJsonService;
import ir.viratech.pond_ms.api.PaginationParam;
import ir.viratech.pond_ms.api.app_message.base.BaseAppMessageResource;
import ir.viratech.pond_ms.api.app_message.dto.AppMessageFullDTO;
import ir.viratech.pond_ms.api.app_message.dto.AppMessageViewDTO;
import ir.viratech.pond_ms.model.app_message.AppMessage;
import ir.viratech.pond_ms.model.app_message.logic.AppMessageMgr;
import org.springframework.stereotype.Component;

import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.util.Collection;
import java.util.List;

/**
 *  This is a REST Resource class for entity "AppMessage".
 *
 */
@Path("/app-message")
public class AppMessageService extends AbstractJsonService{

    @GET
    @Path("/available")
    public Response getAllActivated(@BeanParam PaginationParam paginationParam) {
        SimpleTabularCollectionDTO_NoFieldInfo responseDto = new SimpleTabularCollectionDTO_NoFieldInfo();
        List<AppMessage> appMessageList = AppMessageMgr.getInstance().getActivatedAndUnexpired(paginationParam.getStart() , paginationParam.getLen());
        long totalCount = AppMessageMgr.getInstance().getActivatedAndUnexpiredCount();
        Collection<AppMessageViewDTO> items = DtoUtil.convertCollection(appMessageList, AppMessageViewDTO.class);
        responseDto.loadFrom(items, totalCount);
        return Response.status(200).entity(responseDto).build();
    }

}
