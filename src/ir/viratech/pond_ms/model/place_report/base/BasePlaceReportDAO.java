package ir.viratech.pond_ms.model.place_report.base;




/**
 *  Base DAO class for entity "ir.viratech.pond_ms.model.place_report.PlaceReport". 
 *  It is an automatically generated file and should not be edited.
 */
public abstract class BasePlaceReportDAO extends ir.viratech.base.AbstractEntityDAO<ir.viratech.pond_ms.model.place_report.PlaceReport, java.lang.Long> {

	

	// query name references


	/**
	 * Gets the DAO instance from Spring.
	 *
	 * @return the instance of PlaceReportMgr
	 */
	public static ir.viratech.pond_ms.model.place_report.dao.PlaceReportDAO getInstance() {
		return ir.viratech.commons.spring.context.ApplicationContextProvider.getInitializedApplicationContext().getBean(ir.viratech.pond_ms.model.place_report.dao.PlaceReportDAO.class);
	}

	/* (non-Javadoc)
	 * @see ir.viratech.commons.persistence.base.BaseAbstractEntityDAO#getReferenceClass()
	 */
	@Override
	public Class<ir.viratech.pond_ms.model.place_report.PlaceReport> getReferenceClass() {
		return ir.viratech.pond_ms.model.place_report.PlaceReport.class;
	}
	
	/* (non-Javadoc)
	 * @see ir.viratech.commons.persistence.base.BaseAbstractEntityDAO#getId(java.lang.Object)
	 */
	@Override
	public java.lang.Long getId(ir.viratech.pond_ms.model.place_report.PlaceReport placeReport) {
		return placeReport.getId();
	}
	




	/**
	 * Unique finder method for "extuid".
	 *
	 * @param extuid the value of extuid
	 * @return the unique matching object
	 */
	public ir.viratech.pond_ms.model.place_report.PlaceReport getByExtuid(java.lang.String extuid) {
		return this.getByUniqueProp(ir.viratech.pond_ms.model.place_report.PlaceReport.PROP_EXTUID, extuid);
	}




	@Override
	public void initialize(ir.viratech.pond_ms.model.place_report.PlaceReport placeReport) {
		super.initialize(placeReport);
		placeReport.setExtuid(this.generateUid());
		placeReport.setCreationDate(new java.util.Date());
	}
	



}