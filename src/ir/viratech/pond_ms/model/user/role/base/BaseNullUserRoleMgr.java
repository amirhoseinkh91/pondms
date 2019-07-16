package ir.viratech.pond_ms.model.user.role.base;


import ir.viratech.pond_ms.model.user.role.NullUserRole;
import ir.viratech.pond_ms.model.user.role.dao.NullUserRoleDAO;


/**
 *  Base Mgr class for entity "ir.viratech.pond_ms.model.user.role.NullUserRole". 
 *  It is an automatically generated file and should not be edited.
 */
public abstract class BaseNullUserRoleMgr extends ir.viratech.base.AbstractEntityMgr<NullUserRole, java.lang.Long> {


	private NullUserRoleDAO nullUserRoleDAO = NullUserRoleDAO.getInstance();	

	@Override
	protected NullUserRoleDAO getDAO() {
		return this.nullUserRoleDAO;
	}


	protected BaseNullUserRoleMgr () {}
	



	/**
	 * Gets the Mgr instance from Spring.
	 *
	 * @return the instance of NullUserRoleDAO
	 */
	public static ir.viratech.pond_ms.model.user.role.logic.NullUserRoleMgr getInstance() {
		return ir.viratech.commons.spring.context.ApplicationContextProvider.getInitializedApplicationContext().getBean(ir.viratech.pond_ms.model.user.role.logic.NullUserRoleMgr.class);
	}






}