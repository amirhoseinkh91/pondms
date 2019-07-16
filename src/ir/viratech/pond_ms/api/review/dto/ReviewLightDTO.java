package ir.viratech.pond_ms.api.review.dto;

import ir.viratech.commons.api.dto.PlainCollectionDTO;
import ir.viratech.pond_ms.api.review.base.BaseReviewLightDTO;
import ir.viratech.pond_ms.model.review.ReplyReview;
import ir.viratech.pond_ms.model.review.Review;


/**
 * A DTO for class Review.
 *
 */
public class ReviewLightDTO extends BaseReviewLightDTO {

    @Override
    protected PlainCollectionDTO<ReplyReview, ReplyReviewViewDTO> load_Replies(Review review) {
        return PlainCollectionDTO.createAndLoad(review.getCreatedReplies(), ReplyReviewViewDTO.class);
    }
}
