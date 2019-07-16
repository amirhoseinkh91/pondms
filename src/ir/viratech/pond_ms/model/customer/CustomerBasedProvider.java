package ir.viratech.pond_ms.model.customer;

import ir.viratech.commons.model.UIDAndDisplayStringProvider;
import ir.viratech.pond_ms.model.customer.Customer;

public interface CustomerBasedProvider extends UIDAndDisplayStringProvider {

	public Customer getCustomer();
	public void setCustomer(Customer customer);

}
