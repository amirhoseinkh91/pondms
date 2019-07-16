package ir.viratech.pond_ms.model.hotel.base;


import ir.viratech.pond_ms.model.hotel.Hotel;
import ir.viratech.pond_ms.model.hotel.dao.HotelDAO;


/**
 *  Base Mgr class for entity "ir.viratech.pond_ms.model.hotel.Hotel". 
 *  It is an automatically generated file and should not be edited.
 */
public abstract class BaseHotelMgr extends ir.viratech.base.AbstractEntityMgr<Hotel, java.lang.Long> {


	private HotelDAO hotelDAO = HotelDAO.getInstance();	

	@Override
	protected HotelDAO getDAO() {
		return this.hotelDAO;
	}


	protected BaseHotelMgr () {}
	



	/**
	 * Gets the Mgr instance from Spring.
	 *
	 * @return the instance of HotelDAO
	 */
	public static ir.viratech.pond_ms.model.hotel.logic.HotelMgr getInstance() {
		return ir.viratech.commons.spring.context.ApplicationContextProvider.getInitializedApplicationContext().getBean(ir.viratech.pond_ms.model.hotel.logic.HotelMgr.class);
	}



	/**
	 * Unique finder method for "extuid".
	 *
	 * @param extuid the value of extuid
	 * @return the unique matching object
	 */
	@ir.viratech.commons.spring.tx.ReadTransactional
	public ir.viratech.pond_ms.model.hotel.Hotel getByExtuid(java.lang.String extuid) {
		return this.getDAO().getByExtuid(extuid);
	}




}