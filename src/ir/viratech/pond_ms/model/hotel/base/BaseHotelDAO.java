package ir.viratech.pond_ms.model.hotel.base;




/**
 *  Base DAO class for entity "ir.viratech.pond_ms.model.hotel.Hotel". 
 *  It is an automatically generated file and should not be edited.
 */
public abstract class BaseHotelDAO extends ir.viratech.base.AbstractEntityDAO<ir.viratech.pond_ms.model.hotel.Hotel, java.lang.Long> {

	

	// query name references


	/**
	 * Gets the DAO instance from Spring.
	 *
	 * @return the instance of HotelMgr
	 */
	public static ir.viratech.pond_ms.model.hotel.dao.HotelDAO getInstance() {
		return ir.viratech.commons.spring.context.ApplicationContextProvider.getInitializedApplicationContext().getBean(ir.viratech.pond_ms.model.hotel.dao.HotelDAO.class);
	}

	/* (non-Javadoc)
	 * @see ir.viratech.commons.persistence.base.BaseAbstractEntityDAO#getReferenceClass()
	 */
	@Override
	public Class<ir.viratech.pond_ms.model.hotel.Hotel> getReferenceClass() {
		return ir.viratech.pond_ms.model.hotel.Hotel.class;
	}
	
	/* (non-Javadoc)
	 * @see ir.viratech.commons.persistence.base.BaseAbstractEntityDAO#getId(java.lang.Object)
	 */
	@Override
	public java.lang.Long getId(ir.viratech.pond_ms.model.hotel.Hotel hotel) {
		return hotel.getId();
	}
	




	/**
	 * Unique finder method for "extuid".
	 *
	 * @param extuid the value of extuid
	 * @return the unique matching object
	 */
	public ir.viratech.pond_ms.model.hotel.Hotel getByExtuid(java.lang.String extuid) {
		return this.getByUniqueProp(ir.viratech.pond_ms.model.hotel.Hotel.PROP_EXTUID, extuid);
	}




	@Override
	public void initialize(ir.viratech.pond_ms.model.hotel.Hotel hotel) {
		super.initialize(hotel);
		hotel.setExtuid(this.generateUid());
	}
	



}