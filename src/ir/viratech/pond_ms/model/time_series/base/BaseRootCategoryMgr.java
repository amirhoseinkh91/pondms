package ir.viratech.pond_ms.model.time_series.base;


import ir.viratech.pond_ms.model.time_series.RootCategory;
import ir.viratech.pond_ms.model.time_series.dao.RootCategoryDAO;


/**
 *  Base Mgr class for entity "ir.viratech.pond_ms.model.time_series.RootCategory". 
 *  It is an automatically generated file and should not be edited.
 */
public abstract class BaseRootCategoryMgr extends ir.viratech.base.AbstractEntityMgr<RootCategory, java.lang.Long> {


	private RootCategoryDAO rootCategoryDAO = RootCategoryDAO.getInstance();	

	@Override
	protected RootCategoryDAO getDAO() {
		return this.rootCategoryDAO;
	}


	protected BaseRootCategoryMgr () {}
	



	/**
	 * Gets the Mgr instance from Spring.
	 *
	 * @return the instance of RootCategoryDAO
	 */
	public static ir.viratech.pond_ms.model.time_series.logic.RootCategoryMgr getInstance() {
		return ir.viratech.commons.spring.context.ApplicationContextProvider.getInitializedApplicationContext().getBean(ir.viratech.pond_ms.model.time_series.logic.RootCategoryMgr.class);
	}



	/**
	 * Unique finder method for "dataFile".
	 *
	 * @param dataFile the value of dataFile
	 * @return the unique matching object
	 */
	@ir.viratech.commons.spring.tx.ReadTransactional
	public ir.viratech.pond_ms.model.time_series.RootCategory getByDataFile(ir.viratech.pond_ms.model.file.DataFile dataFile) {
		return this.getDAO().getByDataFile(dataFile);
	}




}