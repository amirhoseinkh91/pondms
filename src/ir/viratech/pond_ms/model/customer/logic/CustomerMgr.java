package ir.viratech.pond_ms.model.customer.logic;


import org.springframework.beans.factory.annotation.Autowired;

import ir.viratech.commons.spring.tx.ReadTransactional;
import ir.viratech.commons.spring.tx.WriteTransactional;
import ir.viratech.just_ro.core.customer.lottery.LotteryCodeGenerator;
import ir.viratech.pond_ms.api.customer.dto.ProfileDTO;
import ir.viratech.pond_ms.model.customer.Customer;
import ir.viratech.pond_ms.model.customer.base.BaseCustomerMgr;
import ir.viratech.pond_ms.model.user.User;
import ir.viratech.pond_ms.model.user.dao.UserDAO;
import ir.viratech.pond_ms.model.user.role.UserRole;
import ir.viratech.pond_ms.model.user.role.logic.RoleMgr;

/**
 * Mgr class for entity "ir.viratech.pond_ms.model.customer.Customer".
 */
public class CustomerMgr extends BaseCustomerMgr {


	public static final String CUSTOMER_DEFAULT_ROLE_NAME = "customer";

	@Autowired
	private LotteryCodeGenerator lotteryCodeGenerator;

	@ReadTransactional
	 public User getUserByPhoneNumber(String phoneNumber) {
        //For now only customer user can login with phone number
        Customer cust = CustomerMgr.getInstance().getByPhoneNumber(phoneNumber);
        if (cust == null)
            return null;
        return cust.getUser();
    }

    @WriteTransactional
    public Customer createNewWithPhoneNumber(String phoneNumber){
        Customer newCustomer = this.getDAO().createNew();
        newCustomer.setPhoneNumber(phoneNumber);
        UserRole customerRole = (UserRole) RoleMgr.getInstance().getByName(CUSTOMER_DEFAULT_ROLE_NAME);
        newCustomer.getUser().addToRoles_AndReverse(customerRole);
        String lotteryCode = lotteryCodeGenerator.genrateLotteryCode();
        while(this.getDAO().getByLotteryCode(lotteryCode) != null)
        	lotteryCode = lotteryCodeGenerator.genrateLotteryCode();
        newCustomer.setLotteryCode(lotteryCode);
        this.getDAO().save(newCustomer);
        return newCustomer;
    }

    @WriteTransactional
	public void update(Customer customer, ProfileDTO profileDTO) {
		customer.setName(profileDTO.getName());
		customer.setEmail(profileDTO.getEmail());
		customer.setBiography(profileDTO.getBiography());
		customer.setGender(profileDTO.getGender());
		customer.setAge(profileDTO.getAge());
		customer.setLocality(profileDTO.getLocality());
		customer.getUser().setAvatar(profileDTO.getAvatarHash());
		customer.getUser().setFirebaseId(profileDTO.getFirebaseId());
		UserDAO.getInstance().update(customer.getUser());
		this.getDAO().update(customer);
	}




}