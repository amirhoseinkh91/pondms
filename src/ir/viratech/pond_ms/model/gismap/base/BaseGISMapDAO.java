package ir.viratech.pond_ms.model.gismap.base;




/**
 *  Base DAO class for entity "ir.viratech.pond_ms.model.gismap.GISMap". 
 *  It is an automatically generated file and should not be edited.
 */
public abstract class BaseGISMapDAO extends ir.viratech.base.AbstractEntityDAO<ir.viratech.pond_ms.model.gismap.GISMap, java.lang.Long> {

	

	// query name references


	/**
	 * Gets the DAO instance from Spring.
	 *
	 * @return the instance of GISMapMgr
	 */
	public static ir.viratech.pond_ms.model.gismap.dao.GISMapDAO getInstance() {
		return ir.viratech.commons.spring.context.ApplicationContextProvider.getInitializedApplicationContext().getBean(ir.viratech.pond_ms.model.gismap.dao.GISMapDAO.class);
	}

	/* (non-Javadoc)
	 * @see ir.viratech.commons.persistence.base.BaseAbstractEntityDAO#getReferenceClass()
	 */
	@Override
	public Class<ir.viratech.pond_ms.model.gismap.GISMap> getReferenceClass() {
		return ir.viratech.pond_ms.model.gismap.GISMap.class;
	}
	
	/* (non-Javadoc)
	 * @see ir.viratech.commons.persistence.base.BaseAbstractEntityDAO#getId(java.lang.Object)
	 */
	@Override
	public java.lang.Long getId(ir.viratech.pond_ms.model.gismap.GISMap gISMap) {
		return gISMap.getId();
	}
	




	/**
	 * Unique finder method for "extuid".
	 *
	 * @param extuid the value of extuid
	 * @return the unique matching object
	 */
	public ir.viratech.pond_ms.model.gismap.GISMap getByExtuid(java.lang.String extuid) {
		return this.getByUniqueProp(ir.viratech.pond_ms.model.gismap.GISMap.PROP_EXTUID, extuid);
	}

	/**
	 * Unique finder method for "organization".
	 *
	 * @param organization the value of organization
	 * @return the unique matching object
	 */
	public ir.viratech.pond_ms.model.gismap.GISMap getByOrganization(ir.viratech.pond_ms.model.organization.Organization organization) {
		return this.getByUniqueProp(ir.viratech.pond_ms.model.gismap.GISMap.PROP_ORGANIZATION, organization);
	}




	@Override
	public void initialize(ir.viratech.pond_ms.model.gismap.GISMap gISMap) {
		super.initialize(gISMap);
		gISMap.setExtuid(this.generateUid());
		gISMap.setCreationDate(new java.util.Date());
	}
	



}