package ir.viratech.pond_ms.model.config.base;


import ir.viratech.pond_ms.model.config.ConfigEntry;
import ir.viratech.pond_ms.model.config.dao.ConfigEntryDAO;


/**
 *  Base Mgr class for entity "ir.viratech.pond_ms.model.config.ConfigEntry". 
 *  It is an automatically generated file and should not be edited.
 */
public abstract class BaseConfigEntryMgr extends ir.viratech.base.AbstractEntityMgr<ConfigEntry, java.lang.Long> {


	private ConfigEntryDAO configEntryDAO = ConfigEntryDAO.getInstance();	

	@Override
	protected ConfigEntryDAO getDAO() {
		return this.configEntryDAO;
	}


	protected BaseConfigEntryMgr () {}
	



	/**
	 * Gets the Mgr instance from Spring.
	 *
	 * @return the instance of ConfigEntryDAO
	 */
	public static ir.viratech.pond_ms.model.config.logic.ConfigEntryMgr getInstance() {
		return ir.viratech.commons.spring.context.ApplicationContextProvider.getInitializedApplicationContext().getBean(ir.viratech.pond_ms.model.config.logic.ConfigEntryMgr.class);
	}



	/**
	 * Unique finder method for "extuid".
	 *
	 * @param extuid the value of extuid
	 * @return the unique matching object
	 */
	@ir.viratech.commons.spring.tx.ReadTransactional
	public ir.viratech.pond_ms.model.config.ConfigEntry getByExtuid(java.lang.String extuid) {
		return this.getDAO().getByExtuid(extuid);
	}

	/**
	 * Unique finder method for "key".
	 *
	 * @param key the value of key
	 * @return the unique matching object
	 */
	@ir.viratech.commons.spring.tx.ReadTransactional
	public ir.viratech.pond_ms.model.config.ConfigEntry getByKey(java.lang.String key) {
		return this.getDAO().getByKey(key);
	}




}