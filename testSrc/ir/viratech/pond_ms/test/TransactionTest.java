package ir.viratech.pond_ms.test;

import ir.viratech.pond_ms.core.spring.ApplicationContextUtil;








/**
 * The Class TransactionTest.
 */
public class TransactionTest {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws InterruptedException the interrupted exception
	 */
	public static void main(String... args) throws InterruptedException{
		ApplicationContextUtil.setDefaultApplicationContextUrl(TransactionTest.class.getResource("applicationContext-transactionTest.xml").toString());
		ApplicationContextUtil.initializeCliApplicationContext();
		//		ApplicationContextUtil.getApplicationContext().getBean(TransactionTestMgr.class).checkTransaction();
		//		ApplicationContextUtil.getApplicationContext().getBean(TransactionTestMgr.class).checkTransactionWithLogicalError();
		//		ApplicationContextUtil.getApplicationContext().getBean(TransactionTestMgr.class).checkTransactionDBError();
		//
		//
		//
		ApplicationContextUtil.getApplicationContext().getBean(TransactionTestMgr.class)._checkTransaction();
		//		ApplicationContextUtil.getApplicationContext().getBean(TransactionTestMgr.class)._checkTransactionDBError();
		//		ApplicationContextUtil.getApplicationContext().getBean(TransactionTestMgr.class)._checkTransactionWithLogicalError();
		//		ApplicationContextUtil.getApplicationContext().getBean(TransactionTestMgr.class)._checkTransactionRollBack();

		//		Thread.sleep(900000l);

	}
}
