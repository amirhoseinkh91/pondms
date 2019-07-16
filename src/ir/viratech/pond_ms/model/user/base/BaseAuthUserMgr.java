package ir.viratech.pond_ms.model.user.base;


import ir.viratech.pond_ms.model.user.AuthUser;
import ir.viratech.pond_ms.model.user.dao.AuthUserDAO;


/**
 *  Base Mgr class for entity "ir.viratech.pond_ms.model.user.AuthUser". 
 *  It is an automatically generated file and should not be edited.
 */
public abstract class BaseAuthUserMgr extends ir.viratech.base.AbstractEntityMgr<AuthUser, java.lang.Long> {


	private AuthUserDAO authUserDAO = AuthUserDAO.getInstance();	

	@Override
	protected AuthUserDAO getDAO() {
		return this.authUserDAO;
	}


	protected BaseAuthUserMgr () {}
	



	/**
	 * Gets the Mgr instance from Spring.
	 *
	 * @return the instance of AuthUserDAO
	 */
	public static ir.viratech.pond_ms.model.user.logic.AuthUserMgr getInstance() {
		return ir.viratech.commons.spring.context.ApplicationContextProvider.getInitializedApplicationContext().getBean(ir.viratech.pond_ms.model.user.logic.AuthUserMgr.class);
	}



	/**
	 * Unique finder method for "extuid".
	 *
	 * @param extuid the value of extuid
	 * @return the unique matching object
	 */
	@ir.viratech.commons.spring.tx.ReadTransactional
	public ir.viratech.pond_ms.model.user.AuthUser getByExtuid(java.lang.String extuid) {
		return this.getDAO().getByExtuid(extuid);
	}

	/**
	 * Unique finder method for "username".
	 *
	 * @param username the value of username
	 * @return the unique matching object
	 */
	@ir.viratech.commons.spring.tx.ReadTransactional
	public ir.viratech.pond_ms.model.user.AuthUser getByUsername(java.lang.String username) {
		return this.getDAO().getByUsername(username);
	}




}