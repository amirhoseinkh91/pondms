package ir.viratech.pond_ms.model.organization.base;




/**
 *  Base DAO class for entity "ir.viratech.pond_ms.model.organization.Organization". 
 *  It is an automatically generated file and should not be edited.
 */
public abstract class BaseOrganizationDAO extends ir.viratech.base.AbstractEntityDAO<ir.viratech.pond_ms.model.organization.Organization, java.lang.Long> {

	

	// query name references


	/**
	 * Gets the DAO instance from Spring.
	 *
	 * @return the instance of OrganizationMgr
	 */
	public static ir.viratech.pond_ms.model.organization.dao.OrganizationDAO getInstance() {
		return ir.viratech.commons.spring.context.ApplicationContextProvider.getInitializedApplicationContext().getBean(ir.viratech.pond_ms.model.organization.dao.OrganizationDAO.class);
	}

	/* (non-Javadoc)
	 * @see ir.viratech.commons.persistence.base.BaseAbstractEntityDAO#getReferenceClass()
	 */
	@Override
	public Class<ir.viratech.pond_ms.model.organization.Organization> getReferenceClass() {
		return ir.viratech.pond_ms.model.organization.Organization.class;
	}
	
	/* (non-Javadoc)
	 * @see ir.viratech.commons.persistence.base.BaseAbstractEntityDAO#getId(java.lang.Object)
	 */
	@Override
	public java.lang.Long getId(ir.viratech.pond_ms.model.organization.Organization organization) {
		return organization.getId();
	}
	




	/**
	 * Unique finder method for "extuid".
	 *
	 * @param extuid the value of extuid
	 * @return the unique matching object
	 */
	public ir.viratech.pond_ms.model.organization.Organization getByExtuid(java.lang.String extuid) {
		return this.getByUniqueProp(ir.viratech.pond_ms.model.organization.Organization.PROP_EXTUID, extuid);
	}




	@Override
	public void initialize(ir.viratech.pond_ms.model.organization.Organization organization) {
		super.initialize(organization);
		organization.setExtuid(this.generateUid());
	}
	



}