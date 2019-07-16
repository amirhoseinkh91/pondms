package ir.viratech.pond_ms.model.city.base;


import ir.viratech.pond_ms.model.city.City;
import ir.viratech.pond_ms.model.city.dao.CityDAO;


/**
 *  Base Mgr class for entity "ir.viratech.pond_ms.model.city.City". 
 *  It is an automatically generated file and should not be edited.
 */
public abstract class BaseCityMgr extends ir.viratech.base.AbstractEntityMgr<City, java.lang.Long> {


	private CityDAO cityDAO = CityDAO.getInstance();	

	@Override
	protected CityDAO getDAO() {
		return this.cityDAO;
	}


	protected BaseCityMgr () {}
	



	/**
	 * Gets the Mgr instance from Spring.
	 *
	 * @return the instance of CityDAO
	 */
	public static ir.viratech.pond_ms.model.city.logic.CityMgr getInstance() {
		return ir.viratech.commons.spring.context.ApplicationContextProvider.getInitializedApplicationContext().getBean(ir.viratech.pond_ms.model.city.logic.CityMgr.class);
	}



	/**
	 * Unique finder method for "extuid".
	 *
	 * @param extuid the value of extuid
	 * @return the unique matching object
	 */
	@ir.viratech.commons.spring.tx.ReadTransactional
	public ir.viratech.pond_ms.model.city.City getByExtuid(java.lang.String extuid) {
		return this.getDAO().getByExtuid(extuid);
	}




}