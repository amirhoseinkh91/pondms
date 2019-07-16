package ir.viratech.pond_ms.api.review.dto;

import ir.viratech.commons.api.dto.DtoUtil;
import ir.viratech.commons.api.dto.PlainCollectionDTO;
import ir.viratech.commons.api.entity_modifier.BadDtoEntityModificationException;
import ir.viratech.commons.api.search.EntityByDtoFinder;
import ir.viratech.commons.api.search.EntityByDtoFinder_ByUid;
import ir.viratech.commons.api.search.InvalidDtoException;
import ir.viratech.pond_ms.api.map_object.vector.dto.GISVectorObjectFullDTO;
import ir.viratech.pond_ms.api.review.base.BaseReviewFullDTO;
import ir.viratech.pond_ms.api.user.dto.UserReviewDTO;
import ir.viratech.pond_ms.model.map_object.vector.GISVectorObject;
import ir.viratech.pond_ms.model.map_object.vector.logic.GISVectorObjectMgr;
import ir.viratech.pond_ms.model.review.ReplyReview;
import ir.viratech.pond_ms.model.review.Review;
import ir.viratech.pond_ms.model.review.logic.ReplyReviewMgr;
import ir.viratech.pond_ms.model.user.User;
import ir.viratech.pond_ms.model.user.logic.UserMgr;

import java.util.Collection;


/**
 * A DTO for class Review.
 */
public class ReviewFullDTO extends BaseReviewFullDTO {

    /**
     * FieldInfoContext for ReviewFullDTO
     */
    public static class FieldInfoContext extends BaseReviewFullDTO.BaseFieldInfoContext {

        @Override
        protected EntityByDtoFinder<User, UserReviewDTO> createEntityByDtoFinder_User() {
            return new EntityByDtoFinder_ByUid<User, UserReviewDTO>(UserMgr.getInstance());
        }

        @Override
        protected EntityByDtoFinder<GISVectorObject, GISVectorObjectFullDTO> createEntityByDtoFinder_GisVectorObject() {
            return new EntityByDtoFinder_ByUid<>(GISVectorObjectMgr.getInstance());
        }
    }

    @Override
    protected PlainCollectionDTO<ReplyReview, ReplyReviewFullDTO> load_Replies(Review review) {
        return PlainCollectionDTO.createAndLoad(review.getCreatedReplies(), ReplyReviewFullDTO.class);
    }

    @Override
    protected void save_Replies(Review review, PlainCollectionDTO<ReplyReview, ReplyReviewFullDTO> replies) throws BadDtoEntityModificationException {
        review.getCreatedReplies().clear();
        try {
            Collection<ReplyReview> items = PlainCollectionDTO.getEntities_Nullable(replies, ReplyReviewMgr.getInstance());
            review.getReplies().addAll(items);
        } catch (InvalidDtoException e) {
            throw new BadDtoEntityModificationException(e);
        }
    }

    @Override
    protected UserReviewDTO load_User(Review review) {
        return DtoUtil.createAndLoadDto(UserReviewDTO.class, review.getUser());
    }


}
