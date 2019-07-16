package ir.viratech.pond_ms.model.review.base;


import ir.viratech.pond_ms.model.review.Review;
import ir.viratech.pond_ms.model.review.dao.ReviewDAO;


/**
 *  Base Mgr class for entity "ir.viratech.pond_ms.model.review.Review". 
 *  It is an automatically generated file and should not be edited.
 */
public abstract class BaseReviewMgr extends ir.viratech.base.AbstractEntityMgr<Review, java.lang.Long> {


	private ReviewDAO reviewDAO = ReviewDAO.getInstance();	

	@Override
	protected ReviewDAO getDAO() {
		return this.reviewDAO;
	}


	protected BaseReviewMgr () {}
	



	/**
	 * Gets the Mgr instance from Spring.
	 *
	 * @return the instance of ReviewDAO
	 */
	public static ir.viratech.pond_ms.model.review.logic.ReviewMgr getInstance() {
		return ir.viratech.commons.spring.context.ApplicationContextProvider.getInitializedApplicationContext().getBean(ir.viratech.pond_ms.model.review.logic.ReviewMgr.class);
	}



	/**
	 * Unique finder method for "extuid".
	 *
	 * @param extuid the value of extuid
	 * @return the unique matching object
	 */
	@ir.viratech.commons.spring.tx.ReadTransactional
	public ir.viratech.pond_ms.model.review.Review getByExtuid(java.lang.String extuid) {
		return this.getDAO().getByExtuid(extuid);
	}




}