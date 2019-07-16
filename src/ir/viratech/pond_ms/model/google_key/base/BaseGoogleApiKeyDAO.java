package ir.viratech.pond_ms.model.google_key.base;




/**
 *  Base DAO class for entity "ir.viratech.pond_ms.model.google_key.GoogleApiKey". 
 *  It is an automatically generated file and should not be edited.
 */
public abstract class BaseGoogleApiKeyDAO extends ir.viratech.base.AbstractEntityDAO<ir.viratech.pond_ms.model.google_key.GoogleApiKey, java.lang.Long> {

	

	// query name references


	/**
	 * Gets the DAO instance from Spring.
	 *
	 * @return the instance of GoogleApiKeyMgr
	 */
	public static ir.viratech.pond_ms.model.google_key.dao.GoogleApiKeyDAO getInstance() {
		return ir.viratech.commons.spring.context.ApplicationContextProvider.getInitializedApplicationContext().getBean(ir.viratech.pond_ms.model.google_key.dao.GoogleApiKeyDAO.class);
	}

	/* (non-Javadoc)
	 * @see ir.viratech.commons.persistence.base.BaseAbstractEntityDAO#getReferenceClass()
	 */
	@Override
	public Class<ir.viratech.pond_ms.model.google_key.GoogleApiKey> getReferenceClass() {
		return ir.viratech.pond_ms.model.google_key.GoogleApiKey.class;
	}
	
	/* (non-Javadoc)
	 * @see ir.viratech.commons.persistence.base.BaseAbstractEntityDAO#getId(java.lang.Object)
	 */
	@Override
	public java.lang.Long getId(ir.viratech.pond_ms.model.google_key.GoogleApiKey googleApiKey) {
		return googleApiKey.getId();
	}
	




	/**
	 * Unique finder method for "extuid".
	 *
	 * @param extuid the value of extuid
	 * @return the unique matching object
	 */
	public ir.viratech.pond_ms.model.google_key.GoogleApiKey getByExtuid(java.lang.String extuid) {
		return this.getByUniqueProp(ir.viratech.pond_ms.model.google_key.GoogleApiKey.PROP_EXTUID, extuid);
	}

	/**
	 * Unique finder method for "key".
	 *
	 * @param key the value of key
	 * @return the unique matching object
	 */
	public ir.viratech.pond_ms.model.google_key.GoogleApiKey getByKey(java.lang.String key) {
		return this.getByUniqueProp(ir.viratech.pond_ms.model.google_key.GoogleApiKey.PROP_KEY, key);
	}




	@Override
	public void initialize(ir.viratech.pond_ms.model.google_key.GoogleApiKey googleApiKey) {
		super.initialize(googleApiKey);
		googleApiKey.setExtuid(this.generateUid());
		googleApiKey.setLastUsedDate(new java.util.Date());
		googleApiKey.setBusy(false);
	}
	



}