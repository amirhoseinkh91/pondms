package ir.viratech.pond_ms.model.feed_back.base;


import ir.viratech.pond_ms.model.feed_back.FeedBack;
import ir.viratech.pond_ms.model.feed_back.dao.FeedBackDAO;


/**
 *  Base Mgr class for entity "ir.viratech.pond_ms.model.feed_back.FeedBack". 
 *  It is an automatically generated file and should not be edited.
 */
public abstract class BaseFeedBackMgr extends ir.viratech.base.AbstractEntityMgr<FeedBack, java.lang.Long> {


	private FeedBackDAO feedBackDAO = FeedBackDAO.getInstance();	

	@Override
	protected FeedBackDAO getDAO() {
		return this.feedBackDAO;
	}


	protected BaseFeedBackMgr () {}
	



	/**
	 * Gets the Mgr instance from Spring.
	 *
	 * @return the instance of FeedBackDAO
	 */
	public static ir.viratech.pond_ms.model.feed_back.logic.FeedBackMgr getInstance() {
		return ir.viratech.commons.spring.context.ApplicationContextProvider.getInitializedApplicationContext().getBean(ir.viratech.pond_ms.model.feed_back.logic.FeedBackMgr.class);
	}



	/**
	 * Unique finder method for "extuid".
	 *
	 * @param extuid the value of extuid
	 * @return the unique matching object
	 */
	@ir.viratech.commons.spring.tx.ReadTransactional
	public ir.viratech.pond_ms.model.feed_back.FeedBack getByExtuid(java.lang.String extuid) {
		return this.getDAO().getByExtuid(extuid);
	}




}