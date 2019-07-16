package ir.viratech.pond_ms.api.feed_back;

import ir.viratech.commons.api.ResponseException;
import ir.viratech.commons.api.dto.DtoUtil;
import ir.viratech.commons.api.dto.UI_MetadataDTO;
import ir.viratech.pond_ms.api.PaginationParam;
import ir.viratech.pond_ms.api.feed_back.dto.FeedBackFullDTO;
import ir.viratech.pond_ms.model.feed_back.FeedBack;
import ir.viratech.pond_ms.model.feed_back.logic.FeedBackMgr;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

import static ir.viratech.pond_ms.core.i18n.MessageService.getMessageTranslator;

@Path("/feedBack")
public class FeedBackService {

    @GET
    @Path("/feedBackList")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFeedBackList(@BeanParam PaginationParam paginationParam) {
        try {

            List<FeedBack> list = FeedBackMgr.getInstance().pageList(paginationParam.getStart(), paginationParam.getLen());
            return Response.ok(DtoUtil.convertCollection(list, FeedBackFullDTO.class)).build();
        } catch (Exception e) {
            throw new ResponseException(Response
                    .status(Response.Status.NOT_ACCEPTABLE)
                    .entity(UI_MetadataDTO.createWith_i18n("feed-back.error", UI_MetadataDTO.MessageDTO.MessageType.ERROR, getMessageTranslator()))
                    .build());
        }

    }

    @GET
    @Path("/oneFeedBack")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFeedBack(@QueryParam("uid") String uid) {
        try {
            if (uid.equals("")) {
                throw new ResponseException(Response
                        .status(Response.Status.NOT_ACCEPTABLE)
                        .entity(UI_MetadataDTO.createWith_i18n("feed-back.error", UI_MetadataDTO.MessageDTO.MessageType.ERROR, getMessageTranslator()))
                        .build());
            }
            FeedBack feedBack = FeedBackMgr.getInstance().getByExtuid(uid);
            return Response.ok(DtoUtil.createAndLoadDto(FeedBackFullDTO.class, feedBack)).build();
        } catch (Exception e) {
            throw new ResponseException(Response
                    .status(Response.Status.NOT_ACCEPTABLE)
                    .entity(UI_MetadataDTO.createWith_i18n("feed-back.error", UI_MetadataDTO.MessageDTO.MessageType.ERROR, getMessageTranslator()))
                    .build());
        }
    }

}
