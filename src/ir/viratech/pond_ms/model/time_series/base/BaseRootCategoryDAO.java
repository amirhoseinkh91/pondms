package ir.viratech.pond_ms.model.time_series.base;




/**
 *  Base DAO class for entity "ir.viratech.pond_ms.model.time_series.RootCategory". 
 *  It is an automatically generated file and should not be edited.
 */
public abstract class BaseRootCategoryDAO extends ir.viratech.base.AbstractEntityDAO<ir.viratech.pond_ms.model.time_series.RootCategory, java.lang.Long> {

	

	// query name references


	/**
	 * Gets the DAO instance from Spring.
	 *
	 * @return the instance of RootCategoryMgr
	 */
	public static ir.viratech.pond_ms.model.time_series.dao.RootCategoryDAO getInstance() {
		return ir.viratech.commons.spring.context.ApplicationContextProvider.getInitializedApplicationContext().getBean(ir.viratech.pond_ms.model.time_series.dao.RootCategoryDAO.class);
	}

	/* (non-Javadoc)
	 * @see ir.viratech.commons.persistence.base.BaseAbstractEntityDAO#getReferenceClass()
	 */
	@Override
	public Class<ir.viratech.pond_ms.model.time_series.RootCategory> getReferenceClass() {
		return ir.viratech.pond_ms.model.time_series.RootCategory.class;
	}
	
	/* (non-Javadoc)
	 * @see ir.viratech.commons.persistence.base.BaseAbstractEntityDAO#getId(java.lang.Object)
	 */
	@Override
	public java.lang.Long getId(ir.viratech.pond_ms.model.time_series.RootCategory rootCategory) {
		return rootCategory.getId();
	}
	




	/**
	 * Unique finder method for "dataFile".
	 *
	 * @param dataFile the value of dataFile
	 * @return the unique matching object
	 */
	public ir.viratech.pond_ms.model.time_series.RootCategory getByDataFile(ir.viratech.pond_ms.model.file.DataFile dataFile) {
		return this.getByUniqueProp(ir.viratech.pond_ms.model.time_series.RootCategory.PROP_DATA_FILE, dataFile);
	}




	@Override
	public void initialize(ir.viratech.pond_ms.model.time_series.RootCategory rootCategory) {
		ir.viratech.pond_ms.model.time_series.dao.ParentCategoryDAO.getInstance().initialize(rootCategory); 
	}
	



}