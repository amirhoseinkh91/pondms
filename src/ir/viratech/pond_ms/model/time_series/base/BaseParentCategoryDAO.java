package ir.viratech.pond_ms.model.time_series.base;




/**
 *  Base DAO class for entity "ir.viratech.pond_ms.model.time_series.ParentCategory". 
 *  It is an automatically generated file and should not be edited.
 */
public abstract class BaseParentCategoryDAO extends ir.viratech.base.AbstractEntityDAO<ir.viratech.pond_ms.model.time_series.ParentCategory, java.lang.Long> {

	

	// query name references


	/**
	 * Gets the DAO instance from Spring.
	 *
	 * @return the instance of ParentCategoryMgr
	 */
	public static ir.viratech.pond_ms.model.time_series.dao.ParentCategoryDAO getInstance() {
		return ir.viratech.commons.spring.context.ApplicationContextProvider.getInitializedApplicationContext().getBean(ir.viratech.pond_ms.model.time_series.dao.ParentCategoryDAO.class);
	}

	/* (non-Javadoc)
	 * @see ir.viratech.commons.persistence.base.BaseAbstractEntityDAO#getReferenceClass()
	 */
	@Override
	public Class<ir.viratech.pond_ms.model.time_series.ParentCategory> getReferenceClass() {
		return ir.viratech.pond_ms.model.time_series.ParentCategory.class;
	}
	
	/* (non-Javadoc)
	 * @see ir.viratech.commons.persistence.base.BaseAbstractEntityDAO#getId(java.lang.Object)
	 */
	@Override
	public java.lang.Long getId(ir.viratech.pond_ms.model.time_series.ParentCategory parentCategory) {
		return parentCategory.getId();
	}
	







	@Override
	public void initialize(ir.viratech.pond_ms.model.time_series.ParentCategory parentCategory) {
		ir.viratech.pond_ms.model.time_series.dao.CategoryDAO.getInstance().initialize(parentCategory); 
	}
	



}