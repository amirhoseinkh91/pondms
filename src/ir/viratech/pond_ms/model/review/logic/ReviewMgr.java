package ir.viratech.pond_ms.model.review.logic;


import ir.viratech.commons.model.EntityObjectNotFoundException;
import ir.viratech.commons.model.ListAndTotalCount;
import ir.viratech.commons.spring.tx.ReadTransactional;
import ir.viratech.commons.spring.tx.WriteTransactional;
import ir.viratech.pond_ms.core.spring.ApplicationContextUtil;
import ir.viratech.pond_ms.model.map_object.vector.GISVectorObject;
import ir.viratech.pond_ms.model.map_object.vector.logic.GISVectorObjectMgr;
import ir.viratech.pond_ms.model.review.ReplyReview;
import ir.viratech.pond_ms.model.review.Review;
import ir.viratech.pond_ms.model.review.base.BaseReviewMgr;
import ir.viratech.pond_ms.model.user.User;
import ir.viratech.pond_ms.model.user.dao.UserDAO;
import ir.viratech.pond_ms.model.user.logic.UserMgr;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Mgr class for entity "ir.viratech.pond_ms.model.review.Review".
 */
public class ReviewMgr extends BaseReviewMgr {


    @ReadTransactional
    public List<Review> getConfirmedByUser(User user, int start, int len) {
        return this.getDAO().getConfirmedByUser(user, start, len);
    }


    @ReadTransactional
    public List<Review> getConfirmedReviews(int start, int len) {
        return this.getDAO().getConfirmedReviews(start, len);
    }

    @ReadTransactional
    public List<Review> getUnConfirmedReviews(int start, int len) {
        return this.getDAO().getUnConfirmedReviews(start, len);
    }

    @ReadTransactional
    public List<Review> getNewReviews(int start, int len) {
        return this.getDAO().getNewReviews(start, len);
    }

    @ReadTransactional
    public List<Review> getAllByUser(User user, int start, int len) {
        return this.getDAO().getAllByUser(user, start, len);
    }

    @ReadTransactional
    public long getCountConfirmedByUser(User user) {
        return this.getDAO().getCountConfirmedByUser(user);
    }

    @ReadTransactional
    public List<Review> getConfirmedByGisVectorObject(GISVectorObject gisVectorObject, int start, int len) {
        return this.getDAO().getConfirmedByGisVectorObject(gisVectorObject, start, len);
    }

    @ReadTransactional
    public long getCountConfirmedByGisVectorObject(GISVectorObject gisVectorObject) {
        return this.getDAO().getCountConfirmedByGisVectorObject(gisVectorObject);
    }

    @ReadTransactional
    public float getAvgConfirmedByGisVectorObject(GISVectorObject gisVectorObject) {
        return this.getDAO().getAvgConfirmedByGisVectorObject(gisVectorObject);
    }

    @WriteTransactional
    public void replyToReview(Review review, ReplyReview reply) {
        review.addToReplies(reply);
        update(review);
    }

    @WriteTransactional
    public void replyToReview(String reviewUid, ReplyReview reply) throws EntityObjectNotFoundException {
        Review review = getExistingByExtuid(reviewUid);
        replyToReview(review, reply);
    }

    @WriteTransactional
    public void addReview(GISVectorObject gisVectorObject, Review review, User user) {
        review.setUser(user);
        gisVectorObject.addToReviews(review);
        user.addToReviews(review);
        UserMgr.getInstance().update(user);
        GISVectorObjectMgr.getInstance().update(gisVectorObject);
    }

    @WriteTransactional
    public void confirm(Review review) {
        review.setConfirmed(1);
        this.getDAO().update(review);
    }

    @WriteTransactional
    public void unConfirm(Review review) {
        review.setConfirmed(-1);
        this.getDAO().update(review);
    }

    @ReadTransactional
    public Long countConfirmed(User user) {
        return this.getDAO().countConfirmed(user);
    }

    @ReadTransactional
    public ListAndTotalCount<Review> pageList_waitingForConfirmation(int start, int len) {
        return getDAO().pageList_waitingForConfirmation(start, len);
    }

    @Transactional
    public long getNewReviewsCountAndUpdateLastSeen(User user) {
        Date lastSeen = user.getLastSeen();
        long newCount = 0;
        if (lastSeen == null)
            newCount = this.getDAO().countAll();
        else
            newCount = this.getDAO().countFromDate(lastSeen);
        user.setLastSeen(ApplicationContextUtil.getCurrentExecutionContext().getTimestamp());
        UserDAO.getInstance().update(user);
        return newCount;
    }
}