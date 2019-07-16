package ir.viratech.pond_ms.model.customer.base;




/**
 *  Base DAO class for entity "ir.viratech.pond_ms.model.customer.CustomerViewedGISVectorObject". 
 *  It is an automatically generated file and should not be edited.
 */
public abstract class BaseCustomerViewedGISVectorObjectDAO extends ir.viratech.base.AbstractEntityDAO<ir.viratech.pond_ms.model.customer.CustomerViewedGISVectorObject, java.lang.Long> {

	

	// query name references


	/**
	 * Gets the DAO instance from Spring.
	 *
	 * @return the instance of CustomerViewedGISVectorObjectMgr
	 */
	public static ir.viratech.pond_ms.model.customer.dao.CustomerViewedGISVectorObjectDAO getInstance() {
		return ir.viratech.commons.spring.context.ApplicationContextProvider.getInitializedApplicationContext().getBean(ir.viratech.pond_ms.model.customer.dao.CustomerViewedGISVectorObjectDAO.class);
	}

	/* (non-Javadoc)
	 * @see ir.viratech.commons.persistence.base.BaseAbstractEntityDAO#getReferenceClass()
	 */
	@Override
	public Class<ir.viratech.pond_ms.model.customer.CustomerViewedGISVectorObject> getReferenceClass() {
		return ir.viratech.pond_ms.model.customer.CustomerViewedGISVectorObject.class;
	}
	
	/* (non-Javadoc)
	 * @see ir.viratech.commons.persistence.base.BaseAbstractEntityDAO#getId(java.lang.Object)
	 */
	@Override
	public java.lang.Long getId(ir.viratech.pond_ms.model.customer.CustomerViewedGISVectorObject customerViewedGISVectorObject) {
		return customerViewedGISVectorObject.getId();
	}
	




	/**
	 * Unique finder method for "extuid".
	 *
	 * @param extuid the value of extuid
	 * @return the unique matching object
	 */
	public ir.viratech.pond_ms.model.customer.CustomerViewedGISVectorObject getByExtuid(java.lang.String extuid) {
		return this.getByUniqueProp(ir.viratech.pond_ms.model.customer.CustomerViewedGISVectorObject.PROP_EXTUID, extuid);
	}




	@Override
	public void initialize(ir.viratech.pond_ms.model.customer.CustomerViewedGISVectorObject customerViewedGISVectorObject) {
		super.initialize(customerViewedGISVectorObject);
		customerViewedGISVectorObject.setExtuid(this.generateUid());
	}
	



}