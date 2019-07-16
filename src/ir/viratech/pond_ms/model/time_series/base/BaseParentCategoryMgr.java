package ir.viratech.pond_ms.model.time_series.base;


import ir.viratech.pond_ms.model.time_series.ParentCategory;
import ir.viratech.pond_ms.model.time_series.dao.ParentCategoryDAO;


/**
 *  Base Mgr class for entity "ir.viratech.pond_ms.model.time_series.ParentCategory". 
 *  It is an automatically generated file and should not be edited.
 */
public abstract class BaseParentCategoryMgr extends ir.viratech.base.AbstractEntityMgr<ParentCategory, java.lang.Long> {


	private ParentCategoryDAO parentCategoryDAO = ParentCategoryDAO.getInstance();	

	@Override
	protected ParentCategoryDAO getDAO() {
		return this.parentCategoryDAO;
	}


	protected BaseParentCategoryMgr () {}
	



	/**
	 * Gets the Mgr instance from Spring.
	 *
	 * @return the instance of ParentCategoryDAO
	 */
	public static ir.viratech.pond_ms.model.time_series.logic.ParentCategoryMgr getInstance() {
		return ir.viratech.commons.spring.context.ApplicationContextProvider.getInitializedApplicationContext().getBean(ir.viratech.pond_ms.model.time_series.logic.ParentCategoryMgr.class);
	}






}