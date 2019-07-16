package ir.viratech.pond_ms.model.review.base;


import ir.viratech.pond_ms.model.review.ReplyReview;
import ir.viratech.pond_ms.model.review.dao.ReplyReviewDAO;


/**
 *  Base Mgr class for entity "ir.viratech.pond_ms.model.review.ReplyReview". 
 *  It is an automatically generated file and should not be edited.
 */
public abstract class BaseReplyReviewMgr extends ir.viratech.base.AbstractEntityMgr<ReplyReview, java.lang.Long> {


	private ReplyReviewDAO replyReviewDAO = ReplyReviewDAO.getInstance();	

	@Override
	protected ReplyReviewDAO getDAO() {
		return this.replyReviewDAO;
	}


	protected BaseReplyReviewMgr () {}
	



	/**
	 * Gets the Mgr instance from Spring.
	 *
	 * @return the instance of ReplyReviewDAO
	 */
	public static ir.viratech.pond_ms.model.review.logic.ReplyReviewMgr getInstance() {
		return ir.viratech.commons.spring.context.ApplicationContextProvider.getInitializedApplicationContext().getBean(ir.viratech.pond_ms.model.review.logic.ReplyReviewMgr.class);
	}



	/**
	 * Unique finder method for "extuid".
	 *
	 * @param extuid the value of extuid
	 * @return the unique matching object
	 */
	@ir.viratech.commons.spring.tx.ReadTransactional
	public ir.viratech.pond_ms.model.review.ReplyReview getByExtuid(java.lang.String extuid) {
		return this.getDAO().getByExtuid(extuid);
	}




}