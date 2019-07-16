package ir.viratech.pond_ms.model.review.base;




/**
 *  Base DAO class for entity "ir.viratech.pond_ms.model.review.ReviewVote". 
 *  It is an automatically generated file and should not be edited.
 */
public abstract class BaseReviewVoteDAO extends ir.viratech.base.AbstractEntityDAO<ir.viratech.pond_ms.model.review.ReviewVote, java.lang.Long> {

	

	// query name references


	/**
	 * Gets the DAO instance from Spring.
	 *
	 * @return the instance of ReviewVoteMgr
	 */
	public static ir.viratech.pond_ms.model.review.dao.ReviewVoteDAO getInstance() {
		return ir.viratech.commons.spring.context.ApplicationContextProvider.getInitializedApplicationContext().getBean(ir.viratech.pond_ms.model.review.dao.ReviewVoteDAO.class);
	}

	/* (non-Javadoc)
	 * @see ir.viratech.commons.persistence.base.BaseAbstractEntityDAO#getReferenceClass()
	 */
	@Override
	public Class<ir.viratech.pond_ms.model.review.ReviewVote> getReferenceClass() {
		return ir.viratech.pond_ms.model.review.ReviewVote.class;
	}
	
	/* (non-Javadoc)
	 * @see ir.viratech.commons.persistence.base.BaseAbstractEntityDAO#getId(java.lang.Object)
	 */
	@Override
	public java.lang.Long getId(ir.viratech.pond_ms.model.review.ReviewVote reviewVote) {
		return reviewVote.getId();
	}
	




	/**
	 * Unique finder method for "extuid".
	 *
	 * @param extuid the value of extuid
	 * @return the unique matching object
	 */
	public ir.viratech.pond_ms.model.review.ReviewVote getByExtuid(java.lang.String extuid) {
		return this.getByUniqueProp(ir.viratech.pond_ms.model.review.ReviewVote.PROP_EXTUID, extuid);
	}




	@Override
	public void initialize(ir.viratech.pond_ms.model.review.ReviewVote reviewVote) {
		super.initialize(reviewVote);
		reviewVote.setExtuid(this.generateUid());
		reviewVote.setDate(new java.util.Date());
	}
	



}