package ir.viratech.pond_ms.model.user.role.base;


import ir.viratech.pond_ms.model.user.role.Role;
import ir.viratech.pond_ms.model.user.role.dao.RoleDAO;


/**
 *  Base Mgr class for entity "ir.viratech.pond_ms.model.user.role.Role". 
 *  It is an automatically generated file and should not be edited.
 */
public abstract class BaseRoleMgr extends ir.viratech.base.AbstractEntityMgr<Role, java.lang.Long> {


	private RoleDAO roleDAO = RoleDAO.getInstance();	

	@Override
	protected RoleDAO getDAO() {
		return this.roleDAO;
	}


	protected BaseRoleMgr () {}
	



	/**
	 * Gets the Mgr instance from Spring.
	 *
	 * @return the instance of RoleDAO
	 */
	public static ir.viratech.pond_ms.model.user.role.logic.RoleMgr getInstance() {
		return ir.viratech.commons.spring.context.ApplicationContextProvider.getInitializedApplicationContext().getBean(ir.viratech.pond_ms.model.user.role.logic.RoleMgr.class);
	}



	/**
	 * Unique finder method for "extuid".
	 *
	 * @param extuid the value of extuid
	 * @return the unique matching object
	 */
	@ir.viratech.commons.spring.tx.ReadTransactional
	public ir.viratech.pond_ms.model.user.role.Role getByExtuid(java.lang.String extuid) {
		return this.getDAO().getByExtuid(extuid);
	}

	/**
	 * Unique finder method for "name".
	 *
	 * @param name the value of name
	 * @return the unique matching object
	 */
	@ir.viratech.commons.spring.tx.ReadTransactional
	public ir.viratech.pond_ms.model.user.role.Role getByName(java.lang.String name) {
		return this.getDAO().getByName(name);
	}




}