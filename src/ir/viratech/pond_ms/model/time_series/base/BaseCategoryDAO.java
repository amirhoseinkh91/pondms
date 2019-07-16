package ir.viratech.pond_ms.model.time_series.base;




/**
 *  Base DAO class for entity "ir.viratech.pond_ms.model.time_series.Category". 
 *  It is an automatically generated file and should not be edited.
 */
public abstract class BaseCategoryDAO extends ir.viratech.base.AbstractEntityDAO<ir.viratech.pond_ms.model.time_series.Category, java.lang.Long> {

	

	// query name references


	/**
	 * Gets the DAO instance from Spring.
	 *
	 * @return the instance of CategoryMgr
	 */
	public static ir.viratech.pond_ms.model.time_series.dao.CategoryDAO getInstance() {
		return ir.viratech.commons.spring.context.ApplicationContextProvider.getInitializedApplicationContext().getBean(ir.viratech.pond_ms.model.time_series.dao.CategoryDAO.class);
	}

	/* (non-Javadoc)
	 * @see ir.viratech.commons.persistence.base.BaseAbstractEntityDAO#getReferenceClass()
	 */
	@Override
	public Class<ir.viratech.pond_ms.model.time_series.Category> getReferenceClass() {
		return ir.viratech.pond_ms.model.time_series.Category.class;
	}
	
	/* (non-Javadoc)
	 * @see ir.viratech.commons.persistence.base.BaseAbstractEntityDAO#getId(java.lang.Object)
	 */
	@Override
	public java.lang.Long getId(ir.viratech.pond_ms.model.time_series.Category category) {
		return category.getId();
	}
	




	/**
	 * Unique finder method for "extuid".
	 *
	 * @param extuid the value of extuid
	 * @return the unique matching object
	 */
	public ir.viratech.pond_ms.model.time_series.Category getByExtuid(java.lang.String extuid) {
		return this.getByUniqueProp(ir.viratech.pond_ms.model.time_series.Category.PROP_EXTUID, extuid);
	}




	@Override
	public void initialize(ir.viratech.pond_ms.model.time_series.Category category) {
		super.initialize(category);
		category.setExtuid(this.generateUid());
	}
	



}