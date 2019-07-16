package ir.viratech.pond_ms.model.customer.base;




/**
 *  Base DAO class for entity "ir.viratech.pond_ms.model.customer.CustomerFavoriteGISVectorObject". 
 *  It is an automatically generated file and should not be edited.
 */
public abstract class BaseCustomerFavoriteGISVectorObjectDAO extends ir.viratech.base.AbstractEntityDAO<ir.viratech.pond_ms.model.customer.CustomerFavoriteGISVectorObject, java.lang.Long> {

	

	// query name references


	/**
	 * Gets the DAO instance from Spring.
	 *
	 * @return the instance of CustomerFavoriteGISVectorObjectMgr
	 */
	public static ir.viratech.pond_ms.model.customer.dao.CustomerFavoriteGISVectorObjectDAO getInstance() {
		return ir.viratech.commons.spring.context.ApplicationContextProvider.getInitializedApplicationContext().getBean(ir.viratech.pond_ms.model.customer.dao.CustomerFavoriteGISVectorObjectDAO.class);
	}

	/* (non-Javadoc)
	 * @see ir.viratech.commons.persistence.base.BaseAbstractEntityDAO#getReferenceClass()
	 */
	@Override
	public Class<ir.viratech.pond_ms.model.customer.CustomerFavoriteGISVectorObject> getReferenceClass() {
		return ir.viratech.pond_ms.model.customer.CustomerFavoriteGISVectorObject.class;
	}
	
	/* (non-Javadoc)
	 * @see ir.viratech.commons.persistence.base.BaseAbstractEntityDAO#getId(java.lang.Object)
	 */
	@Override
	public java.lang.Long getId(ir.viratech.pond_ms.model.customer.CustomerFavoriteGISVectorObject customerFavoriteGISVectorObject) {
		return customerFavoriteGISVectorObject.getId();
	}
	




	/**
	 * Unique finder method for "extuid".
	 *
	 * @param extuid the value of extuid
	 * @return the unique matching object
	 */
	public ir.viratech.pond_ms.model.customer.CustomerFavoriteGISVectorObject getByExtuid(java.lang.String extuid) {
		return this.getByUniqueProp(ir.viratech.pond_ms.model.customer.CustomerFavoriteGISVectorObject.PROP_EXTUID, extuid);
	}




	@Override
	public void initialize(ir.viratech.pond_ms.model.customer.CustomerFavoriteGISVectorObject customerFavoriteGISVectorObject) {
		super.initialize(customerFavoriteGISVectorObject);
		customerFavoriteGISVectorObject.setExtuid(this.generateUid());
	}
	



}