package ir.viratech.pond_ms.api.feed_back;

import ir.viratech.commons.api.ResponseException;
import ir.viratech.commons.api.dto.UI_MetadataDTO;
import ir.viratech.commons.model.InvalidEntityModificationException;
import ir.viratech.pond_ms.api.feed_back.base.BaseFeedBackResource;
import ir.viratech.pond_ms.api.feed_back.dto.FeedBackFullDTO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 * This is a REST Resource class for entity "FeedBack".
 */
@Component
@Path(BaseFeedBackResource.RESOURCE_PATH)
public class FeedBackResource extends BaseFeedBackResource {
    @Override
    protected boolean hasAccessToAdd(FeedBackFullDTO fullDto) {
        return true;
    }

    public FeedBackResource() {
        this.addFieldInfoContext("full", FeedBackFullDTO.FieldInfoContext.class);
    }

    @Override
    protected void validate_Add(FeedBackFullDTO fullDto) throws InvalidEntityModificationException {
        if (StringUtils.isBlank(fullDto.getComment())) {
//            throw new InvalidEntityModificationException("please fill comment");
            throw new ResponseException(Response
                    .status(Response.Status.NOT_ACCEPTABLE)
                    .entity(UI_MetadataDTO.createWith_i18n("feed-back.error", UI_MetadataDTO.MessageDTO.MessageType.ERROR, getMessageTranslator()))
                    .build());
        }
    }
}
