package ir.viratech.pond_ms.model.customer.base;




/**
 *  Base DAO class for entity "ir.viratech.pond_ms.model.customer.Customer". 
 *  It is an automatically generated file and should not be edited.
 */
public abstract class BaseCustomerDAO extends ir.viratech.base.AbstractEntityDAO<ir.viratech.pond_ms.model.customer.Customer, java.lang.Long> {

	

	// query name references


	/**
	 * Gets the DAO instance from Spring.
	 *
	 * @return the instance of CustomerMgr
	 */
	public static ir.viratech.pond_ms.model.customer.dao.CustomerDAO getInstance() {
		return ir.viratech.commons.spring.context.ApplicationContextProvider.getInitializedApplicationContext().getBean(ir.viratech.pond_ms.model.customer.dao.CustomerDAO.class);
	}

	/* (non-Javadoc)
	 * @see ir.viratech.commons.persistence.base.BaseAbstractEntityDAO#getReferenceClass()
	 */
	@Override
	public Class<ir.viratech.pond_ms.model.customer.Customer> getReferenceClass() {
		return ir.viratech.pond_ms.model.customer.Customer.class;
	}
	
	/* (non-Javadoc)
	 * @see ir.viratech.commons.persistence.base.BaseAbstractEntityDAO#getId(java.lang.Object)
	 */
	@Override
	public java.lang.Long getId(ir.viratech.pond_ms.model.customer.Customer customer) {
		return customer.getId();
	}
	




	/**
	 * Unique finder method for "extuid".
	 *
	 * @param extuid the value of extuid
	 * @return the unique matching object
	 */
	public ir.viratech.pond_ms.model.customer.Customer getByExtuid(java.lang.String extuid) {
		return this.getByUniqueProp(ir.viratech.pond_ms.model.customer.Customer.PROP_EXTUID, extuid);
	}

	/**
	 * Unique finder method for "phoneNumber".
	 *
	 * @param phoneNumber the value of phoneNumber
	 * @return the unique matching object
	 */
	public ir.viratech.pond_ms.model.customer.Customer getByPhoneNumber(java.lang.String phoneNumber) {
		return this.getByUniqueProp(ir.viratech.pond_ms.model.customer.Customer.PROP_PHONE_NUMBER, phoneNumber);
	}

	/**
	 * Unique finder method for "lotteryCode".
	 *
	 * @param lotteryCode the value of lotteryCode
	 * @return the unique matching object
	 */
	public ir.viratech.pond_ms.model.customer.Customer getByLotteryCode(java.lang.String lotteryCode) {
		return this.getByUniqueProp(ir.viratech.pond_ms.model.customer.Customer.PROP_LOTTERY_CODE, lotteryCode);
	}

	/**
	 * Unique finder method for "user".
	 *
	 * @param user the value of user
	 * @return the unique matching object
	 */
	public ir.viratech.pond_ms.model.customer.Customer getByUser(ir.viratech.pond_ms.model.user.User user) {
		return this.getByUniqueProp(ir.viratech.pond_ms.model.customer.Customer.PROP_USER, user);
	}




	@Override
	public void initialize(ir.viratech.pond_ms.model.customer.Customer customer) {
		super.initialize(customer);
		customer.setUser(ir.viratech.pond_ms.model.user.dao.UserDAO.getInstance().createNew());
		customer.setExtuid(this.generateUid());
	}
	



}