package ir.viratech.pond_ms.model.time_series.base;


import ir.viratech.pond_ms.model.time_series.LeafCategory;
import ir.viratech.pond_ms.model.time_series.dao.LeafCategoryDAO;


/**
 *  Base Mgr class for entity "ir.viratech.pond_ms.model.time_series.LeafCategory". 
 *  It is an automatically generated file and should not be edited.
 */
public abstract class BaseLeafCategoryMgr extends ir.viratech.base.AbstractEntityMgr<LeafCategory, java.lang.Long> {


	private LeafCategoryDAO leafCategoryDAO = LeafCategoryDAO.getInstance();	

	@Override
	protected LeafCategoryDAO getDAO() {
		return this.leafCategoryDAO;
	}


	protected BaseLeafCategoryMgr () {}
	



	/**
	 * Gets the Mgr instance from Spring.
	 *
	 * @return the instance of LeafCategoryDAO
	 */
	public static ir.viratech.pond_ms.model.time_series.logic.LeafCategoryMgr getInstance() {
		return ir.viratech.commons.spring.context.ApplicationContextProvider.getInitializedApplicationContext().getBean(ir.viratech.pond_ms.model.time_series.logic.LeafCategoryMgr.class);
	}






}