package ir.viratech.pond_ms.model.user.base;




/**
 *  Base DAO class for entity "ir.viratech.pond_ms.model.user.AuthUser". 
 *  It is an automatically generated file and should not be edited.
 */
public abstract class BaseAuthUserDAO extends ir.viratech.base.AbstractEntityDAO<ir.viratech.pond_ms.model.user.AuthUser, java.lang.Long> {

	

	// query name references


	/**
	 * Gets the DAO instance from Spring.
	 *
	 * @return the instance of AuthUserMgr
	 */
	public static ir.viratech.pond_ms.model.user.dao.AuthUserDAO getInstance() {
		return ir.viratech.commons.spring.context.ApplicationContextProvider.getInitializedApplicationContext().getBean(ir.viratech.pond_ms.model.user.dao.AuthUserDAO.class);
	}

	/* (non-Javadoc)
	 * @see ir.viratech.commons.persistence.base.BaseAbstractEntityDAO#getReferenceClass()
	 */
	@Override
	public Class<ir.viratech.pond_ms.model.user.AuthUser> getReferenceClass() {
		return ir.viratech.pond_ms.model.user.AuthUser.class;
	}
	
	/* (non-Javadoc)
	 * @see ir.viratech.commons.persistence.base.BaseAbstractEntityDAO#getId(java.lang.Object)
	 */
	@Override
	public java.lang.Long getId(ir.viratech.pond_ms.model.user.AuthUser authUser) {
		return authUser.getId();
	}
	




	/**
	 * Unique finder method for "extuid".
	 *
	 * @param extuid the value of extuid
	 * @return the unique matching object
	 */
	public ir.viratech.pond_ms.model.user.AuthUser getByExtuid(java.lang.String extuid) {
		return this.getByUniqueProp(ir.viratech.pond_ms.model.user.AuthUser.PROP_EXTUID, extuid);
	}

	/**
	 * Unique finder method for "username".
	 *
	 * @param username the value of username
	 * @return the unique matching object
	 */
	public ir.viratech.pond_ms.model.user.AuthUser getByUsername(java.lang.String username) {
		return this.getByUniqueProp(ir.viratech.pond_ms.model.user.AuthUser.PROP_USERNAME, username);
	}




	@Override
	public void initialize(ir.viratech.pond_ms.model.user.AuthUser authUser) {
		super.initialize(authUser);
		authUser.setExtuid(this.generateUid());
		authUser.setEnabled(true);
	}
	



}