package ir.viratech.pond_ms.model.app_message.base;


import ir.viratech.pond_ms.model.app_message.AppMessage;
import ir.viratech.pond_ms.model.app_message.dao.AppMessageDAO;


/**
 *  Base Mgr class for entity "ir.viratech.pond_ms.model.app_message.AppMessage". 
 *  It is an automatically generated file and should not be edited.
 */
public abstract class BaseAppMessageMgr extends ir.viratech.base.AbstractEntityMgr<AppMessage, java.lang.Long> {


	private AppMessageDAO appMessageDAO = AppMessageDAO.getInstance();	

	@Override
	protected AppMessageDAO getDAO() {
		return this.appMessageDAO;
	}


	protected BaseAppMessageMgr () {}
	



	/**
	 * Gets the Mgr instance from Spring.
	 *
	 * @return the instance of AppMessageDAO
	 */
	public static ir.viratech.pond_ms.model.app_message.logic.AppMessageMgr getInstance() {
		return ir.viratech.commons.spring.context.ApplicationContextProvider.getInitializedApplicationContext().getBean(ir.viratech.pond_ms.model.app_message.logic.AppMessageMgr.class);
	}



	/**
	 * Unique finder method for "extuid".
	 *
	 * @param extuid the value of extuid
	 * @return the unique matching object
	 */
	@ir.viratech.commons.spring.tx.ReadTransactional
	public ir.viratech.pond_ms.model.app_message.AppMessage getByExtuid(java.lang.String extuid) {
		return this.getDAO().getByExtuid(extuid);
	}




}