package ir.viratech.pond_ms.model.feed_back.base;




/**
 *  Base DAO class for entity "ir.viratech.pond_ms.model.feed_back.FeedBack". 
 *  It is an automatically generated file and should not be edited.
 */
public abstract class BaseFeedBackDAO extends ir.viratech.base.AbstractEntityDAO<ir.viratech.pond_ms.model.feed_back.FeedBack, java.lang.Long> {

	

	// query name references


	/**
	 * Gets the DAO instance from Spring.
	 *
	 * @return the instance of FeedBackMgr
	 */
	public static ir.viratech.pond_ms.model.feed_back.dao.FeedBackDAO getInstance() {
		return ir.viratech.commons.spring.context.ApplicationContextProvider.getInitializedApplicationContext().getBean(ir.viratech.pond_ms.model.feed_back.dao.FeedBackDAO.class);
	}

	/* (non-Javadoc)
	 * @see ir.viratech.commons.persistence.base.BaseAbstractEntityDAO#getReferenceClass()
	 */
	@Override
	public Class<ir.viratech.pond_ms.model.feed_back.FeedBack> getReferenceClass() {
		return ir.viratech.pond_ms.model.feed_back.FeedBack.class;
	}
	
	/* (non-Javadoc)
	 * @see ir.viratech.commons.persistence.base.BaseAbstractEntityDAO#getId(java.lang.Object)
	 */
	@Override
	public java.lang.Long getId(ir.viratech.pond_ms.model.feed_back.FeedBack feedBack) {
		return feedBack.getId();
	}
	




	/**
	 * Unique finder method for "extuid".
	 *
	 * @param extuid the value of extuid
	 * @return the unique matching object
	 */
	public ir.viratech.pond_ms.model.feed_back.FeedBack getByExtuid(java.lang.String extuid) {
		return this.getByUniqueProp(ir.viratech.pond_ms.model.feed_back.FeedBack.PROP_EXTUID, extuid);
	}




	@Override
	public void initialize(ir.viratech.pond_ms.model.feed_back.FeedBack feedBack) {
		super.initialize(feedBack);
		feedBack.setExtuid(this.generateUid());
		feedBack.setDate(new java.util.Date());
	}
	



}