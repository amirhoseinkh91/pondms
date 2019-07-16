package ir.viratech.pond_ms.api.review.dto;

import ir.viratech.commons.api.entity_modifier.BadDtoEntityModificationException;
import ir.viratech.pond_ms.api.review.base.BaseReviewSaveDTO;
import ir.viratech.pond_ms.model.review.Review;

import java.util.Date;


/**
 * A DTO for class Review.
 *
 */
public class ReviewSaveDTO extends BaseReviewSaveDTO {

    @Override
    public void saveTo(Review review) throws BadDtoEntityModificationException {
        review.setDeleted(false);
        review.setConfirmed(0);
        review.setCreationDate(new Date());
        super.saveTo(review);
    }
}
