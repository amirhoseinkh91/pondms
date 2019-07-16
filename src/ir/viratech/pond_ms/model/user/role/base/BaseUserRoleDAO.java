package ir.viratech.pond_ms.model.user.role.base;




/**
 *  Base DAO class for entity "ir.viratech.pond_ms.model.user.role.UserRole". 
 *  It is an automatically generated file and should not be edited.
 */
public abstract class BaseUserRoleDAO extends ir.viratech.base.AbstractEntityDAO<ir.viratech.pond_ms.model.user.role.UserRole, java.lang.Long> {

	

	// query name references


	/**
	 * Gets the DAO instance from Spring.
	 *
	 * @return the instance of UserRoleMgr
	 */
	public static ir.viratech.pond_ms.model.user.role.dao.UserRoleDAO getInstance() {
		return ir.viratech.commons.spring.context.ApplicationContextProvider.getInitializedApplicationContext().getBean(ir.viratech.pond_ms.model.user.role.dao.UserRoleDAO.class);
	}

	/* (non-Javadoc)
	 * @see ir.viratech.commons.persistence.base.BaseAbstractEntityDAO#getReferenceClass()
	 */
	@Override
	public Class<ir.viratech.pond_ms.model.user.role.UserRole> getReferenceClass() {
		return ir.viratech.pond_ms.model.user.role.UserRole.class;
	}
	
	/* (non-Javadoc)
	 * @see ir.viratech.commons.persistence.base.BaseAbstractEntityDAO#getId(java.lang.Object)
	 */
	@Override
	public java.lang.Long getId(ir.viratech.pond_ms.model.user.role.UserRole userRole) {
		return userRole.getId();
	}
	







	@Override
	public void initialize(ir.viratech.pond_ms.model.user.role.UserRole userRole) {
		ir.viratech.pond_ms.model.user.role.dao.RoleDAO.getInstance().initialize(userRole); 
	}
	



}