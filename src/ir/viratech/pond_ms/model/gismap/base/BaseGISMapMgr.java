package ir.viratech.pond_ms.model.gismap.base;


import ir.viratech.pond_ms.model.gismap.GISMap;
import ir.viratech.pond_ms.model.gismap.dao.GISMapDAO;


/**
 *  Base Mgr class for entity "ir.viratech.pond_ms.model.gismap.GISMap". 
 *  It is an automatically generated file and should not be edited.
 */
public abstract class BaseGISMapMgr extends ir.viratech.base.AbstractEntityMgr<GISMap, java.lang.Long> {


	private GISMapDAO gISMapDAO = GISMapDAO.getInstance();	

	@Override
	protected GISMapDAO getDAO() {
		return this.gISMapDAO;
	}


	protected BaseGISMapMgr () {}
	



	/**
	 * Gets the Mgr instance from Spring.
	 *
	 * @return the instance of GISMapDAO
	 */
	public static ir.viratech.pond_ms.model.gismap.logic.GISMapMgr getInstance() {
		return ir.viratech.commons.spring.context.ApplicationContextProvider.getInitializedApplicationContext().getBean(ir.viratech.pond_ms.model.gismap.logic.GISMapMgr.class);
	}



	/**
	 * Unique finder method for "extuid".
	 *
	 * @param extuid the value of extuid
	 * @return the unique matching object
	 */
	@ir.viratech.commons.spring.tx.ReadTransactional
	public ir.viratech.pond_ms.model.gismap.GISMap getByExtuid(java.lang.String extuid) {
		return this.getDAO().getByExtuid(extuid);
	}

	/**
	 * Unique finder method for "organization".
	 *
	 * @param organization the value of organization
	 * @return the unique matching object
	 */
	@ir.viratech.commons.spring.tx.ReadTransactional
	public ir.viratech.pond_ms.model.gismap.GISMap getByOrganization(ir.viratech.pond_ms.model.organization.Organization organization) {
		return this.getDAO().getByOrganization(organization);
	}




}