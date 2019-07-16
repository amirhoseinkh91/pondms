package ir.viratech.pond_ms.model.app_message.base;




/**
 *  Base DAO class for entity "ir.viratech.pond_ms.model.app_message.AppMessage". 
 *  It is an automatically generated file and should not be edited.
 */
public abstract class BaseAppMessageDAO extends ir.viratech.base.AbstractEntityDAO<ir.viratech.pond_ms.model.app_message.AppMessage, java.lang.Long> {

	

	// query name references


	/**
	 * Gets the DAO instance from Spring.
	 *
	 * @return the instance of AppMessageMgr
	 */
	public static ir.viratech.pond_ms.model.app_message.dao.AppMessageDAO getInstance() {
		return ir.viratech.commons.spring.context.ApplicationContextProvider.getInitializedApplicationContext().getBean(ir.viratech.pond_ms.model.app_message.dao.AppMessageDAO.class);
	}

	/* (non-Javadoc)
	 * @see ir.viratech.commons.persistence.base.BaseAbstractEntityDAO#getReferenceClass()
	 */
	@Override
	public Class<ir.viratech.pond_ms.model.app_message.AppMessage> getReferenceClass() {
		return ir.viratech.pond_ms.model.app_message.AppMessage.class;
	}
	
	/* (non-Javadoc)
	 * @see ir.viratech.commons.persistence.base.BaseAbstractEntityDAO#getId(java.lang.Object)
	 */
	@Override
	public java.lang.Long getId(ir.viratech.pond_ms.model.app_message.AppMessage appMessage) {
		return appMessage.getId();
	}
	




	/**
	 * Unique finder method for "extuid".
	 *
	 * @param extuid the value of extuid
	 * @return the unique matching object
	 */
	public ir.viratech.pond_ms.model.app_message.AppMessage getByExtuid(java.lang.String extuid) {
		return this.getByUniqueProp(ir.viratech.pond_ms.model.app_message.AppMessage.PROP_EXTUID, extuid);
	}




	@Override
	public void initialize(ir.viratech.pond_ms.model.app_message.AppMessage appMessage) {
		super.initialize(appMessage);
		appMessage.setExtuid(this.generateUid());
		appMessage.setCreationDate(new java.util.Date());
		appMessage.setEnabled(true);
	}
	



}