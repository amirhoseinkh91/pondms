package ir.viratech.pond_ms.model.time_series.base;




/**
 *  Base DAO class for entity "ir.viratech.pond_ms.model.time_series.TimeSeriesGroup". 
 *  It is an automatically generated file and should not be edited.
 */
public abstract class BaseTimeSeriesGroupDAO extends ir.viratech.base.AbstractEntityDAO<ir.viratech.pond_ms.model.time_series.TimeSeriesGroup, java.lang.Long> {

	

	// query name references


	/**
	 * Gets the DAO instance from Spring.
	 *
	 * @return the instance of TimeSeriesGroupMgr
	 */
	public static ir.viratech.pond_ms.model.time_series.dao.TimeSeriesGroupDAO getInstance() {
		return ir.viratech.commons.spring.context.ApplicationContextProvider.getInitializedApplicationContext().getBean(ir.viratech.pond_ms.model.time_series.dao.TimeSeriesGroupDAO.class);
	}

	/* (non-Javadoc)
	 * @see ir.viratech.commons.persistence.base.BaseAbstractEntityDAO#getReferenceClass()
	 */
	@Override
	public Class<ir.viratech.pond_ms.model.time_series.TimeSeriesGroup> getReferenceClass() {
		return ir.viratech.pond_ms.model.time_series.TimeSeriesGroup.class;
	}
	
	/* (non-Javadoc)
	 * @see ir.viratech.commons.persistence.base.BaseAbstractEntityDAO#getId(java.lang.Object)
	 */
	@Override
	public java.lang.Long getId(ir.viratech.pond_ms.model.time_series.TimeSeriesGroup timeSeriesGroup) {
		return timeSeriesGroup.getId();
	}
	




	/**
	 * Unique finder method for "extuid".
	 *
	 * @param extuid the value of extuid
	 * @return the unique matching object
	 */
	public ir.viratech.pond_ms.model.time_series.TimeSeriesGroup getByExtuid(java.lang.String extuid) {
		return this.getByUniqueProp(ir.viratech.pond_ms.model.time_series.TimeSeriesGroup.PROP_EXTUID, extuid);
	}




	@Override
	public void initialize(ir.viratech.pond_ms.model.time_series.TimeSeriesGroup timeSeriesGroup) {
		super.initialize(timeSeriesGroup);
		timeSeriesGroup.setExtuid(this.generateUid());
	}
	



}