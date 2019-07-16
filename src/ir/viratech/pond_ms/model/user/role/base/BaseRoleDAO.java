package ir.viratech.pond_ms.model.user.role.base;




/**
 *  Base DAO class for entity "ir.viratech.pond_ms.model.user.role.Role". 
 *  It is an automatically generated file and should not be edited.
 */
public abstract class BaseRoleDAO extends ir.viratech.base.AbstractEntityDAO<ir.viratech.pond_ms.model.user.role.Role, java.lang.Long> {

	

	// query name references


	/**
	 * Gets the DAO instance from Spring.
	 *
	 * @return the instance of RoleMgr
	 */
	public static ir.viratech.pond_ms.model.user.role.dao.RoleDAO getInstance() {
		return ir.viratech.commons.spring.context.ApplicationContextProvider.getInitializedApplicationContext().getBean(ir.viratech.pond_ms.model.user.role.dao.RoleDAO.class);
	}

	/* (non-Javadoc)
	 * @see ir.viratech.commons.persistence.base.BaseAbstractEntityDAO#getReferenceClass()
	 */
	@Override
	public Class<ir.viratech.pond_ms.model.user.role.Role> getReferenceClass() {
		return ir.viratech.pond_ms.model.user.role.Role.class;
	}
	
	/* (non-Javadoc)
	 * @see ir.viratech.commons.persistence.base.BaseAbstractEntityDAO#getId(java.lang.Object)
	 */
	@Override
	public java.lang.Long getId(ir.viratech.pond_ms.model.user.role.Role role) {
		return role.getId();
	}
	




	/**
	 * Unique finder method for "extuid".
	 *
	 * @param extuid the value of extuid
	 * @return the unique matching object
	 */
	public ir.viratech.pond_ms.model.user.role.Role getByExtuid(java.lang.String extuid) {
		return this.getByUniqueProp(ir.viratech.pond_ms.model.user.role.Role.PROP_EXTUID, extuid);
	}

	/**
	 * Unique finder method for "name".
	 *
	 * @param name the value of name
	 * @return the unique matching object
	 */
	public ir.viratech.pond_ms.model.user.role.Role getByName(java.lang.String name) {
		return this.getByUniqueProp(ir.viratech.pond_ms.model.user.role.Role.PROP_NAME, name);
	}




	@Override
	public void initialize(ir.viratech.pond_ms.model.user.role.Role role) {
		super.initialize(role);
		role.setExtuid(this.generateUid());
		role.setUserDefined(true);
	}
	



}