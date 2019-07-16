package ir.viratech.just_ro.cli;

import ir.viratech.just_ro.core.sms.SmsUtils;
import ir.viratech.pond_ms.core.spring.ApplicationContextUtil;
import ir.viratech.pond_ms.model.customer.Customer;
import ir.viratech.pond_ms.model.customer.logic.CustomerMgr;

public class SendLotteryCodeToAllCustomers {
	public static void main(String[] args) {
		ApplicationContextUtil.initializeCliApplicationContext();
		for (Customer customer : CustomerMgr.getInstance().list())
			SmsUtils.sendLotteryCodeSmsToCustomer(customer);
	}
}
