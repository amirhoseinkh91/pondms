package ir.viratech.pond_ms.model.customer;

import ir.viratech.commons.model.UIDAndDisplayStringProvider;
import ir.viratech.pond_ms.model.customer.base.BaseCustomer;

/**
 * The entity class "Customer".
 */

public class Customer extends BaseCustomer implements UIDAndDisplayStringProvider{
	private static final long serialVersionUID = 1L;

	@Override
	public String getDisplayString() {
		return getUser().getFullName();
	}





}