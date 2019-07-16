package ir.viratech.pond_ms.api.review;

import ir.viratech.pond_ms.api.review.base.BaseReviewResource;

import javax.ws.rs.Path;

import ir.viratech.pond_ms.api.review.dto.ReviewFullDTO;
import org.springframework.stereotype.Component;

/**
 *  This is a REST Resource class for entity "Review".
 *
 */
@Component
@Path(BaseReviewResource.RESOURCE_PATH)
public class ReviewResource extends BaseReviewResource {

    public ReviewResource() {
        this.addFieldInfoContext("full" , ReviewFullDTO.FieldInfoContext.class);
    }

}
