package ir.viratech.pond_ms.model.time_series.base;




/**
 *  Base DAO class for entity "ir.viratech.pond_ms.model.time_series.TimeSeriesDateValuePair". 
 *  It is an automatically generated file and should not be edited.
 */
public abstract class BaseTimeSeriesDateValuePairDAO extends ir.viratech.base.AbstractEntityDAO<ir.viratech.pond_ms.model.time_series.TimeSeriesDateValuePair, java.lang.Long> {

	

	// query name references


	/**
	 * Gets the DAO instance from Spring.
	 *
	 * @return the instance of TimeSeriesDateValuePairMgr
	 */
	public static ir.viratech.pond_ms.model.time_series.dao.TimeSeriesDateValuePairDAO getInstance() {
		return ir.viratech.commons.spring.context.ApplicationContextProvider.getInitializedApplicationContext().getBean(ir.viratech.pond_ms.model.time_series.dao.TimeSeriesDateValuePairDAO.class);
	}

	/* (non-Javadoc)
	 * @see ir.viratech.commons.persistence.base.BaseAbstractEntityDAO#getReferenceClass()
	 */
	@Override
	public Class<ir.viratech.pond_ms.model.time_series.TimeSeriesDateValuePair> getReferenceClass() {
		return ir.viratech.pond_ms.model.time_series.TimeSeriesDateValuePair.class;
	}
	
	/* (non-Javadoc)
	 * @see ir.viratech.commons.persistence.base.BaseAbstractEntityDAO#getId(java.lang.Object)
	 */
	@Override
	public java.lang.Long getId(ir.viratech.pond_ms.model.time_series.TimeSeriesDateValuePair timeSeriesDateValuePair) {
		return timeSeriesDateValuePair.getId();
	}
	




	/**
	 * Unique finder method for "extuid".
	 *
	 * @param extuid the value of extuid
	 * @return the unique matching object
	 */
	public ir.viratech.pond_ms.model.time_series.TimeSeriesDateValuePair getByExtuid(java.lang.String extuid) {
		return this.getByUniqueProp(ir.viratech.pond_ms.model.time_series.TimeSeriesDateValuePair.PROP_EXTUID, extuid);
	}




	@Override
	public void initialize(ir.viratech.pond_ms.model.time_series.TimeSeriesDateValuePair timeSeriesDateValuePair) {
		super.initialize(timeSeriesDateValuePair);
		timeSeriesDateValuePair.setExtuid(this.generateUid());
	}
	



}