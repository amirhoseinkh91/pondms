package ir.viratech.just_ro.core.sms;

import org.apache.log4j.Logger;

import com.kavenegar.sdk.KavenegarApi;

import ir.viratech.commons.spring.context.ApplicationContextProvider;
import ir.viratech.pond_ms.model.customer.Customer;

public class SmsUtils {
	private static final transient Logger logger = Logger.getLogger(SmsUtils.class);
	public static void sendLotteryCodeSmsToCustomer(Customer customer) {
		try {
			KavenegarApi kavenegarApi = new KavenegarApi(ApplicationContextProvider.getProperty("sms.remoteServiceApi.kaveNegar.key"));
			String lotteryTemplate = ApplicationContextProvider.getProperty("sms.remoteServiceApi.kaveNegar.lotteryTemplate");
			kavenegarApi.verifyLookup(customer.getPhoneNumber(), customer.getLotteryCode(), lotteryTemplate);
		}
		catch (Exception e) {
			logger.warn("Failed to send lotter code to customer \"" + customer.getPhoneNumber() + "\"" , e);
		}
	}
}
