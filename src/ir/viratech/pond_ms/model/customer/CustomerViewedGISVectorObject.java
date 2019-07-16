package ir.viratech.pond_ms.model.customer;

import ir.viratech.commons.model.UIDAndDisplayStringProvider;
import ir.viratech.pond_ms.model.customer.base.BaseCustomerViewedGISVectorObject;

/**
 * The entity class "CustomerViewedGISVectorObject".
 */

public class CustomerViewedGISVectorObject extends BaseCustomerViewedGISVectorObject implements UIDAndDisplayStringProvider, CustomerBasedProvider {
	private static final long serialVersionUID = 1L;


	@Override
	public String getDisplayString() {
		return getGisVectorObject().getName();
	}


}