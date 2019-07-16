package ir.viratech.pond_ms.model.review.base;


import ir.viratech.pond_ms.model.review.ReviewVote;
import ir.viratech.pond_ms.model.review.dao.ReviewVoteDAO;


/**
 *  Base Mgr class for entity "ir.viratech.pond_ms.model.review.ReviewVote". 
 *  It is an automatically generated file and should not be edited.
 */
public abstract class BaseReviewVoteMgr extends ir.viratech.base.AbstractEntityMgr<ReviewVote, java.lang.Long> {


	private ReviewVoteDAO reviewVoteDAO = ReviewVoteDAO.getInstance();	

	@Override
	protected ReviewVoteDAO getDAO() {
		return this.reviewVoteDAO;
	}


	protected BaseReviewVoteMgr () {}
	



	/**
	 * Gets the Mgr instance from Spring.
	 *
	 * @return the instance of ReviewVoteDAO
	 */
	public static ir.viratech.pond_ms.model.review.logic.ReviewVoteMgr getInstance() {
		return ir.viratech.commons.spring.context.ApplicationContextProvider.getInitializedApplicationContext().getBean(ir.viratech.pond_ms.model.review.logic.ReviewVoteMgr.class);
	}



	/**
	 * Unique finder method for "extuid".
	 *
	 * @param extuid the value of extuid
	 * @return the unique matching object
	 */
	@ir.viratech.commons.spring.tx.ReadTransactional
	public ir.viratech.pond_ms.model.review.ReviewVote getByExtuid(java.lang.String extuid) {
		return this.getDAO().getByExtuid(extuid);
	}




}