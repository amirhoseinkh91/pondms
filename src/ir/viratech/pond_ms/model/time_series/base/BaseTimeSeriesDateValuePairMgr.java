package ir.viratech.pond_ms.model.time_series.base;


import ir.viratech.pond_ms.model.time_series.TimeSeriesDateValuePair;
import ir.viratech.pond_ms.model.time_series.dao.TimeSeriesDateValuePairDAO;


/**
 *  Base Mgr class for entity "ir.viratech.pond_ms.model.time_series.TimeSeriesDateValuePair". 
 *  It is an automatically generated file and should not be edited.
 */
public abstract class BaseTimeSeriesDateValuePairMgr extends ir.viratech.base.AbstractEntityMgr<TimeSeriesDateValuePair, java.lang.Long> {


	private TimeSeriesDateValuePairDAO timeSeriesDateValuePairDAO = TimeSeriesDateValuePairDAO.getInstance();	

	@Override
	protected TimeSeriesDateValuePairDAO getDAO() {
		return this.timeSeriesDateValuePairDAO;
	}


	protected BaseTimeSeriesDateValuePairMgr () {}
	



	/**
	 * Gets the Mgr instance from Spring.
	 *
	 * @return the instance of TimeSeriesDateValuePairDAO
	 */
	public static ir.viratech.pond_ms.model.time_series.logic.TimeSeriesDateValuePairMgr getInstance() {
		return ir.viratech.commons.spring.context.ApplicationContextProvider.getInitializedApplicationContext().getBean(ir.viratech.pond_ms.model.time_series.logic.TimeSeriesDateValuePairMgr.class);
	}



	/**
	 * Unique finder method for "extuid".
	 *
	 * @param extuid the value of extuid
	 * @return the unique matching object
	 */
	@ir.viratech.commons.spring.tx.ReadTransactional
	public ir.viratech.pond_ms.model.time_series.TimeSeriesDateValuePair getByExtuid(java.lang.String extuid) {
		return this.getDAO().getByExtuid(extuid);
	}




}