package ir.viratech.pond_ms.model.time_series.base;


import ir.viratech.pond_ms.model.time_series.Category;
import ir.viratech.pond_ms.model.time_series.dao.CategoryDAO;


/**
 *  Base Mgr class for entity "ir.viratech.pond_ms.model.time_series.Category". 
 *  It is an automatically generated file and should not be edited.
 */
public abstract class BaseCategoryMgr extends ir.viratech.base.AbstractEntityMgr<Category, java.lang.Long> {


	private CategoryDAO categoryDAO = CategoryDAO.getInstance();	

	@Override
	protected CategoryDAO getDAO() {
		return this.categoryDAO;
	}


	protected BaseCategoryMgr () {}
	



	/**
	 * Gets the Mgr instance from Spring.
	 *
	 * @return the instance of CategoryDAO
	 */
	public static ir.viratech.pond_ms.model.time_series.logic.CategoryMgr getInstance() {
		return ir.viratech.commons.spring.context.ApplicationContextProvider.getInitializedApplicationContext().getBean(ir.viratech.pond_ms.model.time_series.logic.CategoryMgr.class);
	}



	/**
	 * Unique finder method for "extuid".
	 *
	 * @param extuid the value of extuid
	 * @return the unique matching object
	 */
	@ir.viratech.commons.spring.tx.ReadTransactional
	public ir.viratech.pond_ms.model.time_series.Category getByExtuid(java.lang.String extuid) {
		return this.getDAO().getByExtuid(extuid);
	}




}