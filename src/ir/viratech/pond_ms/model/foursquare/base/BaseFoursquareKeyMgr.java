package ir.viratech.pond_ms.model.foursquare.base;


import ir.viratech.pond_ms.model.foursquare.FoursquareKey;
import ir.viratech.pond_ms.model.foursquare.dao.FoursquareKeyDAO;


/**
 *  Base Mgr class for entity "ir.viratech.pond_ms.model.foursquare.FoursquareKey". 
 *  It is an automatically generated file and should not be edited.
 */
public abstract class BaseFoursquareKeyMgr extends ir.viratech.base.AbstractEntityMgr<FoursquareKey, java.lang.Long> {


	private FoursquareKeyDAO foursquareKeyDAO = FoursquareKeyDAO.getInstance();	

	@Override
	protected FoursquareKeyDAO getDAO() {
		return this.foursquareKeyDAO;
	}


	protected BaseFoursquareKeyMgr () {}
	



	/**
	 * Gets the Mgr instance from Spring.
	 *
	 * @return the instance of FoursquareKeyDAO
	 */
	public static ir.viratech.pond_ms.model.foursquare.logic.FoursquareKeyMgr getInstance() {
		return ir.viratech.commons.spring.context.ApplicationContextProvider.getInitializedApplicationContext().getBean(ir.viratech.pond_ms.model.foursquare.logic.FoursquareKeyMgr.class);
	}



	/**
	 * Unique finder method for "extuid".
	 *
	 * @param extuid the value of extuid
	 * @return the unique matching object
	 */
	@ir.viratech.commons.spring.tx.ReadTransactional
	public ir.viratech.pond_ms.model.foursquare.FoursquareKey getByExtuid(java.lang.String extuid) {
		return this.getDAO().getByExtuid(extuid);
	}

	/**
	 * Unique finder method for "clientId".
	 *
	 * @param clientId the value of clientId
	 * @return the unique matching object
	 */
	@ir.viratech.commons.spring.tx.ReadTransactional
	public ir.viratech.pond_ms.model.foursquare.FoursquareKey getByClientId(java.lang.String clientId) {
		return this.getDAO().getByClientId(clientId);
	}

	/**
	 * Unique finder method for "clientSecret".
	 *
	 * @param clientSecret the value of clientSecret
	 * @return the unique matching object
	 */
	@ir.viratech.commons.spring.tx.ReadTransactional
	public ir.viratech.pond_ms.model.foursquare.FoursquareKey getByClientSecret(java.lang.String clientSecret) {
		return this.getDAO().getByClientSecret(clientSecret);
	}




}