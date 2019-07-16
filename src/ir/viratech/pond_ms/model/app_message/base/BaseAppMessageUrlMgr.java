package ir.viratech.pond_ms.model.app_message.base;


import ir.viratech.pond_ms.model.app_message.AppMessageUrl;
import ir.viratech.pond_ms.model.app_message.dao.AppMessageUrlDAO;


/**
 *  Base Mgr class for entity "ir.viratech.pond_ms.model.app_message.AppMessageUrl". 
 *  It is an automatically generated file and should not be edited.
 */
public abstract class BaseAppMessageUrlMgr extends ir.viratech.base.AbstractEntityMgr<AppMessageUrl, java.lang.Long> {


	private AppMessageUrlDAO appMessageUrlDAO = AppMessageUrlDAO.getInstance();	

	@Override
	protected AppMessageUrlDAO getDAO() {
		return this.appMessageUrlDAO;
	}


	protected BaseAppMessageUrlMgr () {}
	



	/**
	 * Gets the Mgr instance from Spring.
	 *
	 * @return the instance of AppMessageUrlDAO
	 */
	public static ir.viratech.pond_ms.model.app_message.logic.AppMessageUrlMgr getInstance() {
		return ir.viratech.commons.spring.context.ApplicationContextProvider.getInitializedApplicationContext().getBean(ir.viratech.pond_ms.model.app_message.logic.AppMessageUrlMgr.class);
	}






}