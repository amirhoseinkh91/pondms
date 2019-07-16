package ir.viratech.pond_ms.core.lottery;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

import ir.viratech.base.AbstractEntityDAO;
import ir.viratech.commons.persistence.mongo.base.MongoDBManager;
import ir.viratech.just_ro.core.sms.SmsUtils;
import ir.viratech.pond_ms.model.customer.Customer;
import ir.viratech.pond_ms.model.customer.logic.CustomerMgr;

public class LotteryMessageManager implements Runnable{

	private static final String KEY_PHONE_NUMBER = "phoneNumber";
	private static final String KEY_REGISTER_DATE = "registerDate";

	private DBCollection getDbCollection() {
		return MongoDBManager.getInstance().getCollection("lotteryMessageQueue");
	}
	@Override
	public void run() {
		AbstractEntityDAO.touchSession();
		try {
			List<String> phoneNumbers = getPhoneNumbersInQueue();
			sendLoterryMessageToCustomers(phoneNumbers);
			removePhoneNumbersFromQueue(phoneNumbers);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		AbstractEntityDAO.closeCurrentThreadSessions();
	}

	protected void sendLoterryMessageToCustomers(List<String> phoneNumbers) {
		for (String phoneNumber : phoneNumbers) {
			Customer customer = CustomerMgr.getInstance().getByPhoneNumber(phoneNumber);
			sendLotteryMessageToCustomer(customer);
		}
	}

	protected void sendLotteryMessageToCustomer(Customer customer) {
		if(customer != null)
			SmsUtils.sendLotteryCodeSmsToCustomer(customer);
	}

	private void removePhoneNumbersFromQueue(List<String> phoneNumbers) {
		for (String phoneNumber : phoneNumbers) {
			removePhoneNumberFromQueue(phoneNumber);
		}
	}

	private void removePhoneNumberFromQueue(String phoneNumber) {
		getDbCollection().remove(new BasicDBObject(KEY_PHONE_NUMBER, phoneNumber));
	}

	private List<String> getPhoneNumbersInQueue() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MINUTE, -5);
		DBObject query = new BasicDBObject(KEY_REGISTER_DATE, new BasicDBObject("$lte", calendar.getTime()));
		DBCursor cursor = getDbCollection().find(query);
		List<String> result = new ArrayList<>();
		while (cursor.hasNext()) {
			DBObject next = cursor.next();
			result.add(next.get(KEY_PHONE_NUMBER).toString());
		}
		return result;
	}

	public void addCustomerPhoneNumberToQueue(Customer customer) {
		DBObject dbObject = new BasicDBObject();
		dbObject.put(KEY_PHONE_NUMBER, customer.getPhoneNumber());
		dbObject.put(KEY_REGISTER_DATE, new Date());
		getDbCollection().insert(dbObject);
	}

}
