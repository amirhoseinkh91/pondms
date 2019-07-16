package ir.viratech.pond_ms.model.organization.base;


import ir.viratech.pond_ms.model.organization.Organization;
import ir.viratech.pond_ms.model.organization.dao.OrganizationDAO;


/**
 *  Base Mgr class for entity "ir.viratech.pond_ms.model.organization.Organization". 
 *  It is an automatically generated file and should not be edited.
 */
public abstract class BaseOrganizationMgr extends ir.viratech.base.AbstractEntityMgr<Organization, java.lang.Long> {


	private OrganizationDAO organizationDAO = OrganizationDAO.getInstance();	

	@Override
	protected OrganizationDAO getDAO() {
		return this.organizationDAO;
	}


	protected BaseOrganizationMgr () {}
	



	/**
	 * Gets the Mgr instance from Spring.
	 *
	 * @return the instance of OrganizationDAO
	 */
	public static ir.viratech.pond_ms.model.organization.logic.OrganizationMgr getInstance() {
		return ir.viratech.commons.spring.context.ApplicationContextProvider.getInitializedApplicationContext().getBean(ir.viratech.pond_ms.model.organization.logic.OrganizationMgr.class);
	}



	/**
	 * Unique finder method for "extuid".
	 *
	 * @param extuid the value of extuid
	 * @return the unique matching object
	 */
	@ir.viratech.commons.spring.tx.ReadTransactional
	public ir.viratech.pond_ms.model.organization.Organization getByExtuid(java.lang.String extuid) {
		return this.getDAO().getByExtuid(extuid);
	}




}