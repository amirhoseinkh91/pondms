package ir.viratech.pond_ms.model.google_key.base;


import ir.viratech.pond_ms.model.google_key.GoogleApiKey;
import ir.viratech.pond_ms.model.google_key.dao.GoogleApiKeyDAO;


/**
 *  Base Mgr class for entity "ir.viratech.pond_ms.model.google_key.GoogleApiKey". 
 *  It is an automatically generated file and should not be edited.
 */
public abstract class BaseGoogleApiKeyMgr extends ir.viratech.base.AbstractEntityMgr<GoogleApiKey, java.lang.Long> {


	private GoogleApiKeyDAO googleApiKeyDAO = GoogleApiKeyDAO.getInstance();	

	@Override
	protected GoogleApiKeyDAO getDAO() {
		return this.googleApiKeyDAO;
	}


	protected BaseGoogleApiKeyMgr () {}
	



	/**
	 * Gets the Mgr instance from Spring.
	 *
	 * @return the instance of GoogleApiKeyDAO
	 */
	public static ir.viratech.pond_ms.model.google_key.logic.GoogleApiKeyMgr getInstance() {
		return ir.viratech.commons.spring.context.ApplicationContextProvider.getInitializedApplicationContext().getBean(ir.viratech.pond_ms.model.google_key.logic.GoogleApiKeyMgr.class);
	}



	/**
	 * Unique finder method for "extuid".
	 *
	 * @param extuid the value of extuid
	 * @return the unique matching object
	 */
	@ir.viratech.commons.spring.tx.ReadTransactional
	public ir.viratech.pond_ms.model.google_key.GoogleApiKey getByExtuid(java.lang.String extuid) {
		return this.getDAO().getByExtuid(extuid);
	}

	/**
	 * Unique finder method for "key".
	 *
	 * @param key the value of key
	 * @return the unique matching object
	 */
	@ir.viratech.commons.spring.tx.ReadTransactional
	public ir.viratech.pond_ms.model.google_key.GoogleApiKey getByKey(java.lang.String key) {
		return this.getDAO().getByKey(key);
	}




}