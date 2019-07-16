package ir.viratech.pond_ms.model.foursquare.base;




/**
 *  Base DAO class for entity "ir.viratech.pond_ms.model.foursquare.FoursquareKey". 
 *  It is an automatically generated file and should not be edited.
 */
public abstract class BaseFoursquareKeyDAO extends ir.viratech.base.AbstractEntityDAO<ir.viratech.pond_ms.model.foursquare.FoursquareKey, java.lang.Long> {

	

	// query name references


	/**
	 * Gets the DAO instance from Spring.
	 *
	 * @return the instance of FoursquareKeyMgr
	 */
	public static ir.viratech.pond_ms.model.foursquare.dao.FoursquareKeyDAO getInstance() {
		return ir.viratech.commons.spring.context.ApplicationContextProvider.getInitializedApplicationContext().getBean(ir.viratech.pond_ms.model.foursquare.dao.FoursquareKeyDAO.class);
	}

	/* (non-Javadoc)
	 * @see ir.viratech.commons.persistence.base.BaseAbstractEntityDAO#getReferenceClass()
	 */
	@Override
	public Class<ir.viratech.pond_ms.model.foursquare.FoursquareKey> getReferenceClass() {
		return ir.viratech.pond_ms.model.foursquare.FoursquareKey.class;
	}
	
	/* (non-Javadoc)
	 * @see ir.viratech.commons.persistence.base.BaseAbstractEntityDAO#getId(java.lang.Object)
	 */
	@Override
	public java.lang.Long getId(ir.viratech.pond_ms.model.foursquare.FoursquareKey foursquareKey) {
		return foursquareKey.getId();
	}
	




	/**
	 * Unique finder method for "extuid".
	 *
	 * @param extuid the value of extuid
	 * @return the unique matching object
	 */
	public ir.viratech.pond_ms.model.foursquare.FoursquareKey getByExtuid(java.lang.String extuid) {
		return this.getByUniqueProp(ir.viratech.pond_ms.model.foursquare.FoursquareKey.PROP_EXTUID, extuid);
	}

	/**
	 * Unique finder method for "clientId".
	 *
	 * @param clientId the value of clientId
	 * @return the unique matching object
	 */
	public ir.viratech.pond_ms.model.foursquare.FoursquareKey getByClientId(java.lang.String clientId) {
		return this.getByUniqueProp(ir.viratech.pond_ms.model.foursquare.FoursquareKey.PROP_CLIENT_ID, clientId);
	}

	/**
	 * Unique finder method for "clientSecret".
	 *
	 * @param clientSecret the value of clientSecret
	 * @return the unique matching object
	 */
	public ir.viratech.pond_ms.model.foursquare.FoursquareKey getByClientSecret(java.lang.String clientSecret) {
		return this.getByUniqueProp(ir.viratech.pond_ms.model.foursquare.FoursquareKey.PROP_CLIENT_SECRET, clientSecret);
	}




	@Override
	public void initialize(ir.viratech.pond_ms.model.foursquare.FoursquareKey foursquareKey) {
		super.initialize(foursquareKey);
		foursquareKey.setExtuid(this.generateUid());
		foursquareKey.setUsedCount(0);
		foursquareKey.setMaxUsage(0);
		foursquareKey.setBusy(false);
		foursquareKey.setLastUsedDate(ir.viratech.commons.utils.MyDateUtils.yesterday());
	}
	



}