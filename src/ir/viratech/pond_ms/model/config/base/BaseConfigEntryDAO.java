package ir.viratech.pond_ms.model.config.base;




/**
 *  Base DAO class for entity "ir.viratech.pond_ms.model.config.ConfigEntry". 
 *  It is an automatically generated file and should not be edited.
 */
public abstract class BaseConfigEntryDAO extends ir.viratech.base.AbstractEntityDAO<ir.viratech.pond_ms.model.config.ConfigEntry, java.lang.Long> {

	

	// query name references


	/**
	 * Gets the DAO instance from Spring.
	 *
	 * @return the instance of ConfigEntryMgr
	 */
	public static ir.viratech.pond_ms.model.config.dao.ConfigEntryDAO getInstance() {
		return ir.viratech.commons.spring.context.ApplicationContextProvider.getInitializedApplicationContext().getBean(ir.viratech.pond_ms.model.config.dao.ConfigEntryDAO.class);
	}

	/* (non-Javadoc)
	 * @see ir.viratech.commons.persistence.base.BaseAbstractEntityDAO#getReferenceClass()
	 */
	@Override
	public Class<ir.viratech.pond_ms.model.config.ConfigEntry> getReferenceClass() {
		return ir.viratech.pond_ms.model.config.ConfigEntry.class;
	}
	
	/* (non-Javadoc)
	 * @see ir.viratech.commons.persistence.base.BaseAbstractEntityDAO#getId(java.lang.Object)
	 */
	@Override
	public java.lang.Long getId(ir.viratech.pond_ms.model.config.ConfigEntry configEntry) {
		return configEntry.getId();
	}
	




	/**
	 * Unique finder method for "extuid".
	 *
	 * @param extuid the value of extuid
	 * @return the unique matching object
	 */
	public ir.viratech.pond_ms.model.config.ConfigEntry getByExtuid(java.lang.String extuid) {
		return this.getByUniqueProp(ir.viratech.pond_ms.model.config.ConfigEntry.PROP_EXTUID, extuid);
	}

	/**
	 * Unique finder method for "key".
	 *
	 * @param key the value of key
	 * @return the unique matching object
	 */
	public ir.viratech.pond_ms.model.config.ConfigEntry getByKey(java.lang.String key) {
		return this.getByUniqueProp(ir.viratech.pond_ms.model.config.ConfigEntry.PROP_KEY, key);
	}







}