package ir.viratech.pond_ms.model.user.base;




/**
 *  Base DAO class for entity "ir.viratech.pond_ms.model.user.User". 
 *  It is an automatically generated file and should not be edited.
 */
public abstract class BaseUserDAO extends ir.viratech.base.AbstractEntityDAO<ir.viratech.pond_ms.model.user.User, java.lang.Long> {

	

	// query name references


	/**
	 * Gets the DAO instance from Spring.
	 *
	 * @return the instance of UserMgr
	 */
	public static ir.viratech.pond_ms.model.user.dao.UserDAO getInstance() {
		return ir.viratech.commons.spring.context.ApplicationContextProvider.getInitializedApplicationContext().getBean(ir.viratech.pond_ms.model.user.dao.UserDAO.class);
	}

	/* (non-Javadoc)
	 * @see ir.viratech.commons.persistence.base.BaseAbstractEntityDAO#getReferenceClass()
	 */
	@Override
	public Class<ir.viratech.pond_ms.model.user.User> getReferenceClass() {
		return ir.viratech.pond_ms.model.user.User.class;
	}
	
	/* (non-Javadoc)
	 * @see ir.viratech.commons.persistence.base.BaseAbstractEntityDAO#getId(java.lang.Object)
	 */
	@Override
	public java.lang.Long getId(ir.viratech.pond_ms.model.user.User user) {
		return user.getId();
	}
	




	/**
	 * Unique finder method for "extuid".
	 *
	 * @param extuid the value of extuid
	 * @return the unique matching object
	 */
	public ir.viratech.pond_ms.model.user.User getByExtuid(java.lang.String extuid) {
		return this.getByUniqueProp(ir.viratech.pond_ms.model.user.User.PROP_EXTUID, extuid);
	}

	/**
	 * Unique finder method for "firebaseId".
	 *
	 * @param firebaseId the value of firebaseId
	 * @return the unique matching object
	 */
	public ir.viratech.pond_ms.model.user.User getByFirebaseId(java.lang.String firebaseId) {
		return this.getByUniqueProp(ir.viratech.pond_ms.model.user.User.PROP_FIREBASE_ID, firebaseId);
	}

	/**
	 * Unique finder method for "authUser".
	 *
	 * @param authUser the value of authUser
	 * @return the unique matching object
	 */
	public ir.viratech.pond_ms.model.user.User getByAuthUser(ir.viratech.pond_ms.model.user.AuthUser authUser) {
		return this.getByUniqueProp(ir.viratech.pond_ms.model.user.User.PROP_AUTH_USER, authUser);
	}




	@Override
	public void initialize(ir.viratech.pond_ms.model.user.User user) {
		super.initialize(user);
		user.setExtuid(this.generateUid());
		user.setEnabled(true);
		user.setUserDefined(true);
	}
	



}