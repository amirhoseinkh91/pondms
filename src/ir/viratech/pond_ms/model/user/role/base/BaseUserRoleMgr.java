package ir.viratech.pond_ms.model.user.role.base;


import ir.viratech.pond_ms.model.user.role.UserRole;
import ir.viratech.pond_ms.model.user.role.dao.UserRoleDAO;


/**
 *  Base Mgr class for entity "ir.viratech.pond_ms.model.user.role.UserRole". 
 *  It is an automatically generated file and should not be edited.
 */
public abstract class BaseUserRoleMgr extends ir.viratech.base.AbstractEntityMgr<UserRole, java.lang.Long> {


	private UserRoleDAO userRoleDAO = UserRoleDAO.getInstance();	

	@Override
	protected UserRoleDAO getDAO() {
		return this.userRoleDAO;
	}


	protected BaseUserRoleMgr () {}
	



	/**
	 * Gets the Mgr instance from Spring.
	 *
	 * @return the instance of UserRoleDAO
	 */
	public static ir.viratech.pond_ms.model.user.role.logic.UserRoleMgr getInstance() {
		return ir.viratech.commons.spring.context.ApplicationContextProvider.getInitializedApplicationContext().getBean(ir.viratech.pond_ms.model.user.role.logic.UserRoleMgr.class);
	}






}