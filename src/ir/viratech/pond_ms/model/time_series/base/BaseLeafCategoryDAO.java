package ir.viratech.pond_ms.model.time_series.base;




/**
 *  Base DAO class for entity "ir.viratech.pond_ms.model.time_series.LeafCategory". 
 *  It is an automatically generated file and should not be edited.
 */
public abstract class BaseLeafCategoryDAO extends ir.viratech.base.AbstractEntityDAO<ir.viratech.pond_ms.model.time_series.LeafCategory, java.lang.Long> {

	

	// query name references


	/**
	 * Gets the DAO instance from Spring.
	 *
	 * @return the instance of LeafCategoryMgr
	 */
	public static ir.viratech.pond_ms.model.time_series.dao.LeafCategoryDAO getInstance() {
		return ir.viratech.commons.spring.context.ApplicationContextProvider.getInitializedApplicationContext().getBean(ir.viratech.pond_ms.model.time_series.dao.LeafCategoryDAO.class);
	}

	/* (non-Javadoc)
	 * @see ir.viratech.commons.persistence.base.BaseAbstractEntityDAO#getReferenceClass()
	 */
	@Override
	public Class<ir.viratech.pond_ms.model.time_series.LeafCategory> getReferenceClass() {
		return ir.viratech.pond_ms.model.time_series.LeafCategory.class;
	}
	
	/* (non-Javadoc)
	 * @see ir.viratech.commons.persistence.base.BaseAbstractEntityDAO#getId(java.lang.Object)
	 */
	@Override
	public java.lang.Long getId(ir.viratech.pond_ms.model.time_series.LeafCategory leafCategory) {
		return leafCategory.getId();
	}
	







	@Override
	public void initialize(ir.viratech.pond_ms.model.time_series.LeafCategory leafCategory) {
		ir.viratech.pond_ms.model.time_series.dao.CategoryDAO.getInstance().initialize(leafCategory); 
	}
	



}