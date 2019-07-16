package ir.viratech.pond_ms.model.time_series.base;


import ir.viratech.pond_ms.model.time_series.TimeSeriesGroup;
import ir.viratech.pond_ms.model.time_series.dao.TimeSeriesGroupDAO;


/**
 *  Base Mgr class for entity "ir.viratech.pond_ms.model.time_series.TimeSeriesGroup". 
 *  It is an automatically generated file and should not be edited.
 */
public abstract class BaseTimeSeriesGroupMgr extends ir.viratech.base.AbstractEntityMgr<TimeSeriesGroup, java.lang.Long> {


	private TimeSeriesGroupDAO timeSeriesGroupDAO = TimeSeriesGroupDAO.getInstance();	

	@Override
	protected TimeSeriesGroupDAO getDAO() {
		return this.timeSeriesGroupDAO;
	}


	protected BaseTimeSeriesGroupMgr () {}
	



	/**
	 * Gets the Mgr instance from Spring.
	 *
	 * @return the instance of TimeSeriesGroupDAO
	 */
	public static ir.viratech.pond_ms.model.time_series.logic.TimeSeriesGroupMgr getInstance() {
		return ir.viratech.commons.spring.context.ApplicationContextProvider.getInitializedApplicationContext().getBean(ir.viratech.pond_ms.model.time_series.logic.TimeSeriesGroupMgr.class);
	}



	/**
	 * Unique finder method for "extuid".
	 *
	 * @param extuid the value of extuid
	 * @return the unique matching object
	 */
	@ir.viratech.commons.spring.tx.ReadTransactional
	public ir.viratech.pond_ms.model.time_series.TimeSeriesGroup getByExtuid(java.lang.String extuid) {
		return this.getDAO().getByExtuid(extuid);
	}




}