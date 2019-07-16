package ir.viratech.pond_ms.model.user.role.base;




/**
 *  Base DAO class for entity "ir.viratech.pond_ms.model.user.role.NullUserRole". 
 *  It is an automatically generated file and should not be edited.
 */
public abstract class BaseNullUserRoleDAO extends ir.viratech.base.AbstractEntityDAO<ir.viratech.pond_ms.model.user.role.NullUserRole, java.lang.Long> {

	

	// query name references


	/**
	 * Gets the DAO instance from Spring.
	 *
	 * @return the instance of NullUserRoleMgr
	 */
	public static ir.viratech.pond_ms.model.user.role.dao.NullUserRoleDAO getInstance() {
		return ir.viratech.commons.spring.context.ApplicationContextProvider.getInitializedApplicationContext().getBean(ir.viratech.pond_ms.model.user.role.dao.NullUserRoleDAO.class);
	}

	/* (non-Javadoc)
	 * @see ir.viratech.commons.persistence.base.BaseAbstractEntityDAO#getReferenceClass()
	 */
	@Override
	public Class<ir.viratech.pond_ms.model.user.role.NullUserRole> getReferenceClass() {
		return ir.viratech.pond_ms.model.user.role.NullUserRole.class;
	}
	
	/* (non-Javadoc)
	 * @see ir.viratech.commons.persistence.base.BaseAbstractEntityDAO#getId(java.lang.Object)
	 */
	@Override
	public java.lang.Long getId(ir.viratech.pond_ms.model.user.role.NullUserRole nullUserRole) {
		return nullUserRole.getId();
	}
	







	@Override
	public void initialize(ir.viratech.pond_ms.model.user.role.NullUserRole nullUserRole) {
		ir.viratech.pond_ms.model.user.role.dao.RoleDAO.getInstance().initialize(nullUserRole); 
	}
	



}