package ir.viratech.pond_ms.model.review.logic;


import org.springframework.transaction.annotation.Transactional;

import ir.viratech.commons.spring.tx.ReadTransactional;
import ir.viratech.pond_ms.model.review.Review;
import ir.viratech.pond_ms.model.review.ReviewVote;
import ir.viratech.pond_ms.model.review.base.BaseReviewVoteMgr;
import ir.viratech.pond_ms.model.user.User;

/**
 * Mgr class for entity "ir.viratech.pond_ms.model.review.ReviewVote".
 */
public class ReviewVoteMgr extends BaseReviewVoteMgr {

	@ReadTransactional
	public ReviewVote getByReviewAndUser(Review review, User user) {
		return this.getDAO().getByReviewAndUser(review,user);
	}

	public ReviewVote createNew(Review review, User user) {
		ReviewVote reviewVote = this.createNew();
		reviewVote.setReview(review);
		reviewVote.setUser(user);
		return reviewVote;
	}

	@Transactional
	public void voteUp(Review review, User user) {
		ReviewVote reviewVote = this.getDAO().getByReviewAndUser(review, user);
		if(reviewVote == null) {
			reviewVote= ReviewVoteMgr.getInstance().createNew(review, user);
			reviewVote.setVote(1);
		}
		else
			if(reviewVote.getVote() == 1)
				reviewVote.setVote(0);
			else
				reviewVote.setVote(1);
		this.getDAO().saveOrUpdate(reviewVote);
	}


	@Transactional
	public void voteDown(Review review, User user) {
		ReviewVote reviewVote = this.getDAO().getByReviewAndUser(review, user);
		if(reviewVote == null) {
			reviewVote= ReviewVoteMgr.getInstance().createNew(review, user);
			reviewVote.setVote(-1);
		}
		else
			if(reviewVote.getVote() == -1)
				reviewVote.setVote(0);
			else
				reviewVote.setVote(-1);
		this.getDAO().saveOrUpdate(reviewVote);
	}



}