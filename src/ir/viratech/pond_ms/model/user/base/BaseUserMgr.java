package ir.viratech.pond_ms.model.user.base;


import ir.viratech.pond_ms.model.user.User;
import ir.viratech.pond_ms.model.user.dao.UserDAO;


/**
 *  Base Mgr class for entity "ir.viratech.pond_ms.model.user.User". 
 *  It is an automatically generated file and should not be edited.
 */
public abstract class BaseUserMgr extends ir.viratech.base.AbstractEntityMgr<User, java.lang.Long> {


	private UserDAO userDAO = UserDAO.getInstance();	

	@Override
	protected UserDAO getDAO() {
		return this.userDAO;
	}


	protected BaseUserMgr () {}
	



	/**
	 * Gets the Mgr instance from Spring.
	 *
	 * @return the instance of UserDAO
	 */
	public static ir.viratech.pond_ms.model.user.logic.UserMgr getInstance() {
		return ir.viratech.commons.spring.context.ApplicationContextProvider.getInitializedApplicationContext().getBean(ir.viratech.pond_ms.model.user.logic.UserMgr.class);
	}



	/**
	 * Unique finder method for "extuid".
	 *
	 * @param extuid the value of extuid
	 * @return the unique matching object
	 */
	@ir.viratech.commons.spring.tx.ReadTransactional
	public ir.viratech.pond_ms.model.user.User getByExtuid(java.lang.String extuid) {
		return this.getDAO().getByExtuid(extuid);
	}

	/**
	 * Unique finder method for "firebaseId".
	 *
	 * @param firebaseId the value of firebaseId
	 * @return the unique matching object
	 */
	@ir.viratech.commons.spring.tx.ReadTransactional
	public ir.viratech.pond_ms.model.user.User getByFirebaseId(java.lang.String firebaseId) {
		return this.getDAO().getByFirebaseId(firebaseId);
	}

	/**
	 * Unique finder method for "authUser".
	 *
	 * @param authUser the value of authUser
	 * @return the unique matching object
	 */
	@ir.viratech.commons.spring.tx.ReadTransactional
	public ir.viratech.pond_ms.model.user.User getByAuthUser(ir.viratech.pond_ms.model.user.AuthUser authUser) {
		return this.getDAO().getByAuthUser(authUser);
	}




}