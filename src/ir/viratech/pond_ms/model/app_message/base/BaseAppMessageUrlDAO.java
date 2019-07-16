package ir.viratech.pond_ms.model.app_message.base;




/**
 *  Base DAO class for entity "ir.viratech.pond_ms.model.app_message.AppMessageUrl". 
 *  It is an automatically generated file and should not be edited.
 */
public abstract class BaseAppMessageUrlDAO extends ir.viratech.base.AbstractEntityDAO<ir.viratech.pond_ms.model.app_message.AppMessageUrl, java.lang.Long> {

	

	// query name references


	/**
	 * Gets the DAO instance from Spring.
	 *
	 * @return the instance of AppMessageUrlMgr
	 */
	public static ir.viratech.pond_ms.model.app_message.dao.AppMessageUrlDAO getInstance() {
		return ir.viratech.commons.spring.context.ApplicationContextProvider.getInitializedApplicationContext().getBean(ir.viratech.pond_ms.model.app_message.dao.AppMessageUrlDAO.class);
	}

	/* (non-Javadoc)
	 * @see ir.viratech.commons.persistence.base.BaseAbstractEntityDAO#getReferenceClass()
	 */
	@Override
	public Class<ir.viratech.pond_ms.model.app_message.AppMessageUrl> getReferenceClass() {
		return ir.viratech.pond_ms.model.app_message.AppMessageUrl.class;
	}
	
	/* (non-Javadoc)
	 * @see ir.viratech.commons.persistence.base.BaseAbstractEntityDAO#getId(java.lang.Object)
	 */
	@Override
	public java.lang.Long getId(ir.viratech.pond_ms.model.app_message.AppMessageUrl appMessageUrl) {
		return appMessageUrl.getId();
	}
	










}