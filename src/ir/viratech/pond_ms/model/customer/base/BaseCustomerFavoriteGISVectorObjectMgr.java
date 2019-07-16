package ir.viratech.pond_ms.model.customer.base;


import ir.viratech.pond_ms.model.customer.CustomerFavoriteGISVectorObject;
import ir.viratech.pond_ms.model.customer.dao.CustomerFavoriteGISVectorObjectDAO;


/**
 *  Base Mgr class for entity "ir.viratech.pond_ms.model.customer.CustomerFavoriteGISVectorObject". 
 *  It is an automatically generated file and should not be edited.
 */
public abstract class BaseCustomerFavoriteGISVectorObjectMgr extends ir.viratech.base.AbstractEntityMgr<CustomerFavoriteGISVectorObject, java.lang.Long> {


	private CustomerFavoriteGISVectorObjectDAO customerFavoriteGISVectorObjectDAO = CustomerFavoriteGISVectorObjectDAO.getInstance();	

	@Override
	protected CustomerFavoriteGISVectorObjectDAO getDAO() {
		return this.customerFavoriteGISVectorObjectDAO;
	}


	protected BaseCustomerFavoriteGISVectorObjectMgr () {}
	



	/**
	 * Gets the Mgr instance from Spring.
	 *
	 * @return the instance of CustomerFavoriteGISVectorObjectDAO
	 */
	public static ir.viratech.pond_ms.model.customer.logic.CustomerFavoriteGISVectorObjectMgr getInstance() {
		return ir.viratech.commons.spring.context.ApplicationContextProvider.getInitializedApplicationContext().getBean(ir.viratech.pond_ms.model.customer.logic.CustomerFavoriteGISVectorObjectMgr.class);
	}



	/**
	 * Unique finder method for "extuid".
	 *
	 * @param extuid the value of extuid
	 * @return the unique matching object
	 */
	@ir.viratech.commons.spring.tx.ReadTransactional
	public ir.viratech.pond_ms.model.customer.CustomerFavoriteGISVectorObject getByExtuid(java.lang.String extuid) {
		return this.getDAO().getByExtuid(extuid);
	}




}