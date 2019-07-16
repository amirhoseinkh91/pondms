package ir.viratech.pond_ms.model.review.base;




/**
 *  Base DAO class for entity "ir.viratech.pond_ms.model.review.Review". 
 *  It is an automatically generated file and should not be edited.
 */
public abstract class BaseReviewDAO extends ir.viratech.base.AbstractEntityDAO<ir.viratech.pond_ms.model.review.Review, java.lang.Long> {

	

	// query name references


	/**
	 * Gets the DAO instance from Spring.
	 *
	 * @return the instance of ReviewMgr
	 */
	public static ir.viratech.pond_ms.model.review.dao.ReviewDAO getInstance() {
		return ir.viratech.commons.spring.context.ApplicationContextProvider.getInitializedApplicationContext().getBean(ir.viratech.pond_ms.model.review.dao.ReviewDAO.class);
	}

	/* (non-Javadoc)
	 * @see ir.viratech.commons.persistence.base.BaseAbstractEntityDAO#getReferenceClass()
	 */
	@Override
	public Class<ir.viratech.pond_ms.model.review.Review> getReferenceClass() {
		return ir.viratech.pond_ms.model.review.Review.class;
	}
	
	/* (non-Javadoc)
	 * @see ir.viratech.commons.persistence.base.BaseAbstractEntityDAO#getId(java.lang.Object)
	 */
	@Override
	public java.lang.Long getId(ir.viratech.pond_ms.model.review.Review review) {
		return review.getId();
	}
	




	/**
	 * Unique finder method for "extuid".
	 *
	 * @param extuid the value of extuid
	 * @return the unique matching object
	 */
	public ir.viratech.pond_ms.model.review.Review getByExtuid(java.lang.String extuid) {
		return this.getByUniqueProp(ir.viratech.pond_ms.model.review.Review.PROP_EXTUID, extuid);
	}




	@Override
	public void initialize(ir.viratech.pond_ms.model.review.Review review) {
		super.initialize(review);
		review.setExtuid(this.generateUid());
		review.setRate(0);
		review.setCreationDate(new java.util.Date());
		review.setLastModifiedDate(review.getCreationDate());
		review.setVisitedDate(new java.util.Date());
		review.setConfirmed(0);
		review.setDeleted(false);
	}
	



}