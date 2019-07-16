package ir.viratech.pond_ms.core.execution_context;

import ir.viratech.commons.execution_context.ExecutionContext;
import ir.viratech.pond_ms.model.customer.CurrentUserIsNotCustomerException;
import ir.viratech.pond_ms.model.customer.Customer;
import ir.viratech.pond_ms.model.user.User;
import ir.viratech.pond_ms.model.user.logic.UserMgr;

public class MyExecutionContext extends ExecutionContext {

	private User user = null;
	public User getUser() {
		return this.user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	public void setUser(String username) {
		this.setUser((username == null) ? null : UserMgr.getInstance().getByUsername(username));
	}
	public void setUsername(User user) {
		this.setUsername((user == null) ? null : user.getUsername());
	}

	public void setUserAndUsername(String username) {
		this.setUsername(username);
		this.setUser(username);
	}
	public void setUserAndUsername(User user) {
		this.setUsername(user);
		this.setUser(user);
	}
	public Customer getCustomer() throws CurrentUserIsNotCustomerException{
		Customer customer = this.getUser().getCustomer();
		if(customer == null)
			throw new CurrentUserIsNotCustomerException();
		return customer;
	}
}
