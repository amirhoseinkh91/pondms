package ir.viratech.pond_ms.model.customer.logic;


import ir.viratech.commons.spring.tx.WriteTransactional;
import ir.viratech.pond_ms.core.spring.ApplicationContextUtil;
import ir.viratech.pond_ms.model.customer.Customer;
import ir.viratech.pond_ms.model.customer.CustomerViewedGISVectorObject;
import ir.viratech.pond_ms.model.customer.base.BaseCustomerViewedGISVectorObjectMgr;
import ir.viratech.pond_ms.model.map_object.vector.GISVectorObject;

/**
 * Mgr class for entity "ir.viratech.pond_ms.model.customer.CustomerViewedGISVectorObject".
 */
public class CustomerViewedGISVectorObjectMgr extends BaseCustomerViewedGISVectorObjectMgr {

	@WriteTransactional
	public void add(Customer customer, GISVectorObject gisVectorObject) {
		CustomerViewedGISVectorObject customerViewedGISVectorObject = this.createNew();
		customerViewedGISVectorObject.setCustomer(customer);
		customerViewedGISVectorObject.setViewDate(ApplicationContextUtil.getCurrentExecutionContext().getTimestamp());
		customerViewedGISVectorObject.setGisVectorObject(gisVectorObject);
		this.getDAO().save(customerViewedGISVectorObject);
	}




}