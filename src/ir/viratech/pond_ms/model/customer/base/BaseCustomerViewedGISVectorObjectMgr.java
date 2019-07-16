package ir.viratech.pond_ms.model.customer.base;


import ir.viratech.pond_ms.model.customer.CustomerViewedGISVectorObject;
import ir.viratech.pond_ms.model.customer.dao.CustomerViewedGISVectorObjectDAO;


/**
 *  Base Mgr class for entity "ir.viratech.pond_ms.model.customer.CustomerViewedGISVectorObject". 
 *  It is an automatically generated file and should not be edited.
 */
public abstract class BaseCustomerViewedGISVectorObjectMgr extends ir.viratech.base.AbstractEntityMgr<CustomerViewedGISVectorObject, java.lang.Long> {


	private CustomerViewedGISVectorObjectDAO customerViewedGISVectorObjectDAO = CustomerViewedGISVectorObjectDAO.getInstance();	

	@Override
	protected CustomerViewedGISVectorObjectDAO getDAO() {
		return this.customerViewedGISVectorObjectDAO;
	}


	protected BaseCustomerViewedGISVectorObjectMgr () {}
	



	/**
	 * Gets the Mgr instance from Spring.
	 *
	 * @return the instance of CustomerViewedGISVectorObjectDAO
	 */
	public static ir.viratech.pond_ms.model.customer.logic.CustomerViewedGISVectorObjectMgr getInstance() {
		return ir.viratech.commons.spring.context.ApplicationContextProvider.getInitializedApplicationContext().getBean(ir.viratech.pond_ms.model.customer.logic.CustomerViewedGISVectorObjectMgr.class);
	}



	/**
	 * Unique finder method for "extuid".
	 *
	 * @param extuid the value of extuid
	 * @return the unique matching object
	 */
	@ir.viratech.commons.spring.tx.ReadTransactional
	public ir.viratech.pond_ms.model.customer.CustomerViewedGISVectorObject getByExtuid(java.lang.String extuid) {
		return this.getDAO().getByExtuid(extuid);
	}




}