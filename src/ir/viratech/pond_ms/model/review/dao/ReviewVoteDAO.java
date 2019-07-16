package ir.viratech.pond_ms.model.review.dao;

import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import ir.viratech.pond_ms.model.review.Review;
import ir.viratech.pond_ms.model.review.ReviewVote;
import ir.viratech.pond_ms.model.review.base.BaseReviewVoteDAO;
import ir.viratech.pond_ms.model.user.User;

/**
 * DAO class for entity "ir.viratech.pond_ms.model.review.ReviewVote".
 */
public class ReviewVoteDAO extends BaseReviewVoteDAO {

	public ReviewVote getByReviewAndUser(Review review, User user) {
		return (ReviewVote) this.createCriteria()
				.add(Restrictions.eq(ReviewVote.PROP_REVIEW, review))
				.add(Restrictions.eq(ReviewVote.PROP_USER, user))
				.uniqueResult();
	}

	public long getVoteDownCount(Review review) {
		return (long) this.createCriteria()
				.add(Restrictions.eq(ReviewVote.PROP_REVIEW, review))
				.add(Restrictions.eq(ReviewVote.PROP_VOTE, -1))
				.setProjection(Projections.rowCount())
				.uniqueResult();

	}

	public long getVoteUpCount(Review review) {
		return (long) this.createCriteria()
				.add(Restrictions.eq(ReviewVote.PROP_REVIEW, review))
				.add(Restrictions.eq(ReviewVote.PROP_VOTE, 1))
				.setProjection(Projections.rowCount())
				.uniqueResult();
	}





}