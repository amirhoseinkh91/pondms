package ir.viratech.pond_ms.model.place_report.base;


import ir.viratech.pond_ms.model.place_report.PlaceReport;
import ir.viratech.pond_ms.model.place_report.dao.PlaceReportDAO;


/**
 *  Base Mgr class for entity "ir.viratech.pond_ms.model.place_report.PlaceReport". 
 *  It is an automatically generated file and should not be edited.
 */
public abstract class BasePlaceReportMgr extends ir.viratech.base.AbstractEntityMgr<PlaceReport, java.lang.Long> {


	private PlaceReportDAO placeReportDAO = PlaceReportDAO.getInstance();	

	@Override
	protected PlaceReportDAO getDAO() {
		return this.placeReportDAO;
	}


	protected BasePlaceReportMgr () {}
	



	/**
	 * Gets the Mgr instance from Spring.
	 *
	 * @return the instance of PlaceReportDAO
	 */
	public static ir.viratech.pond_ms.model.place_report.logic.PlaceReportMgr getInstance() {
		return ir.viratech.commons.spring.context.ApplicationContextProvider.getInitializedApplicationContext().getBean(ir.viratech.pond_ms.model.place_report.logic.PlaceReportMgr.class);
	}



	/**
	 * Unique finder method for "extuid".
	 *
	 * @param extuid the value of extuid
	 * @return the unique matching object
	 */
	@ir.viratech.commons.spring.tx.ReadTransactional
	public ir.viratech.pond_ms.model.place_report.PlaceReport getByExtuid(java.lang.String extuid) {
		return this.getDAO().getByExtuid(extuid);
	}




}