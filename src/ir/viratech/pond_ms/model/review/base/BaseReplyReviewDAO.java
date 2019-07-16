package ir.viratech.pond_ms.model.review.base;




/**
 *  Base DAO class for entity "ir.viratech.pond_ms.model.review.ReplyReview". 
 *  It is an automatically generated file and should not be edited.
 */
public abstract class BaseReplyReviewDAO extends ir.viratech.base.AbstractEntityDAO<ir.viratech.pond_ms.model.review.ReplyReview, java.lang.Long> {

	

	// query name references


	/**
	 * Gets the DAO instance from Spring.
	 *
	 * @return the instance of ReplyReviewMgr
	 */
	public static ir.viratech.pond_ms.model.review.dao.ReplyReviewDAO getInstance() {
		return ir.viratech.commons.spring.context.ApplicationContextProvider.getInitializedApplicationContext().getBean(ir.viratech.pond_ms.model.review.dao.ReplyReviewDAO.class);
	}

	/* (non-Javadoc)
	 * @see ir.viratech.commons.persistence.base.BaseAbstractEntityDAO#getReferenceClass()
	 */
	@Override
	public Class<ir.viratech.pond_ms.model.review.ReplyReview> getReferenceClass() {
		return ir.viratech.pond_ms.model.review.ReplyReview.class;
	}
	
	/* (non-Javadoc)
	 * @see ir.viratech.commons.persistence.base.BaseAbstractEntityDAO#getId(java.lang.Object)
	 */
	@Override
	public java.lang.Long getId(ir.viratech.pond_ms.model.review.ReplyReview replyReview) {
		return replyReview.getId();
	}
	




	/**
	 * Unique finder method for "extuid".
	 *
	 * @param extuid the value of extuid
	 * @return the unique matching object
	 */
	public ir.viratech.pond_ms.model.review.ReplyReview getByExtuid(java.lang.String extuid) {
		return this.getByUniqueProp(ir.viratech.pond_ms.model.review.ReplyReview.PROP_EXTUID, extuid);
	}




	@Override
	public void initialize(ir.viratech.pond_ms.model.review.ReplyReview replyReview) {
		super.initialize(replyReview);
		replyReview.setExtuid(this.generateUid());
		replyReview.setCreationDate(new java.util.Date());
		replyReview.setConfirmed(false);
	}
	



}