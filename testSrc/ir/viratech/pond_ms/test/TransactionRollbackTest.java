package ir.viratech.pond_ms.test;

import ir.viratech.pond_ms.core.spring.ApplicationContextUtil;

/**
 * The Class TransactionRollbackTest.
 */
public class TransactionRollbackTest {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		ApplicationContextUtil.setDefaultApplicationContextUrl(TransactionTest.class.getResource("applicationContext-transactionTest.xml").toString());
		ApplicationContextUtil.initializeCliApplicationContext();
		//ApplicationContextUtil.getApplicationContext().getBean(TransactionTestMgr.class).checkRollback();
		ApplicationContextUtil.getApplicationContext().getBean(TransactionTestMgr.class).checkRollbackWithRuntime();
	}
}
