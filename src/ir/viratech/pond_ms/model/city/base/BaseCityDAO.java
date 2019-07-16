package ir.viratech.pond_ms.model.city.base;




/**
 *  Base DAO class for entity "ir.viratech.pond_ms.model.city.City". 
 *  It is an automatically generated file and should not be edited.
 */
public abstract class BaseCityDAO extends ir.viratech.base.AbstractEntityDAO<ir.viratech.pond_ms.model.city.City, java.lang.Long> {

	

	// query name references


	/**
	 * Gets the DAO instance from Spring.
	 *
	 * @return the instance of CityMgr
	 */
	public static ir.viratech.pond_ms.model.city.dao.CityDAO getInstance() {
		return ir.viratech.commons.spring.context.ApplicationContextProvider.getInitializedApplicationContext().getBean(ir.viratech.pond_ms.model.city.dao.CityDAO.class);
	}

	/* (non-Javadoc)
	 * @see ir.viratech.commons.persistence.base.BaseAbstractEntityDAO#getReferenceClass()
	 */
	@Override
	public Class<ir.viratech.pond_ms.model.city.City> getReferenceClass() {
		return ir.viratech.pond_ms.model.city.City.class;
	}
	
	/* (non-Javadoc)
	 * @see ir.viratech.commons.persistence.base.BaseAbstractEntityDAO#getId(java.lang.Object)
	 */
	@Override
	public java.lang.Long getId(ir.viratech.pond_ms.model.city.City city) {
		return city.getId();
	}
	




	/**
	 * Unique finder method for "extuid".
	 *
	 * @param extuid the value of extuid
	 * @return the unique matching object
	 */
	public ir.viratech.pond_ms.model.city.City getByExtuid(java.lang.String extuid) {
		return this.getByUniqueProp(ir.viratech.pond_ms.model.city.City.PROP_EXTUID, extuid);
	}




	@Override
	public void initialize(ir.viratech.pond_ms.model.city.City city) {
		super.initialize(city);
		city.setExtuid(this.generateUid());
	}
	



}