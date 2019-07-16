package ir.viratech.pond_ms.model.customer.base;


import ir.viratech.pond_ms.model.customer.Customer;
import ir.viratech.pond_ms.model.customer.dao.CustomerDAO;


/**
 *  Base Mgr class for entity "ir.viratech.pond_ms.model.customer.Customer". 
 *  It is an automatically generated file and should not be edited.
 */
public abstract class BaseCustomerMgr extends ir.viratech.base.AbstractEntityMgr<Customer, java.lang.Long> {


	private CustomerDAO customerDAO = CustomerDAO.getInstance();	

	@Override
	protected CustomerDAO getDAO() {
		return this.customerDAO;
	}


	protected BaseCustomerMgr () {}
	



	/**
	 * Gets the Mgr instance from Spring.
	 *
	 * @return the instance of CustomerDAO
	 */
	public static ir.viratech.pond_ms.model.customer.logic.CustomerMgr getInstance() {
		return ir.viratech.commons.spring.context.ApplicationContextProvider.getInitializedApplicationContext().getBean(ir.viratech.pond_ms.model.customer.logic.CustomerMgr.class);
	}



	/**
	 * Unique finder method for "extuid".
	 *
	 * @param extuid the value of extuid
	 * @return the unique matching object
	 */
	@ir.viratech.commons.spring.tx.ReadTransactional
	public ir.viratech.pond_ms.model.customer.Customer getByExtuid(java.lang.String extuid) {
		return this.getDAO().getByExtuid(extuid);
	}

	/**
	 * Unique finder method for "phoneNumber".
	 *
	 * @param phoneNumber the value of phoneNumber
	 * @return the unique matching object
	 */
	@ir.viratech.commons.spring.tx.ReadTransactional
	public ir.viratech.pond_ms.model.customer.Customer getByPhoneNumber(java.lang.String phoneNumber) {
		return this.getDAO().getByPhoneNumber(phoneNumber);
	}

	/**
	 * Unique finder method for "lotteryCode".
	 *
	 * @param lotteryCode the value of lotteryCode
	 * @return the unique matching object
	 */
	@ir.viratech.commons.spring.tx.ReadTransactional
	public ir.viratech.pond_ms.model.customer.Customer getByLotteryCode(java.lang.String lotteryCode) {
		return this.getDAO().getByLotteryCode(lotteryCode);
	}

	/**
	 * Unique finder method for "user".
	 *
	 * @param user the value of user
	 * @return the unique matching object
	 */
	@ir.viratech.commons.spring.tx.ReadTransactional
	public ir.viratech.pond_ms.model.customer.Customer getByUser(ir.viratech.pond_ms.model.user.User user) {
		return this.getDAO().getByUser(user);
	}




}