package ir.viratech.pond_ms.ui.cli.test;

import java.util.Date;

import ir.viratech.pond_ms.core.execution_context.MyExecutionContext;
import ir.viratech.pond_ms.core.spring.ApplicationContextUtil;

public class TestExecutionContext {
	
	protected static void printExecutionContext() {
		MyExecutionContext c = ApplicationContextUtil.getCurrentExecutionContext();
		System.out.println("ExecutionContext = " + c);
		System.out.println("timestamp = " + c.getTimestamp());
		System.out.println("username = " + c.getUsername());
		System.out.println("user = " + c.getUser());
	}
	
	public static void main(String[] args) throws InterruptedException {
		ApplicationContextUtil.initializeCliApplicationContext();
		MyExecutionContext executionContext = ApplicationContextUtil.acquireAndGetCurrentExecutionContext();
		Date date = new Date();
		executionContext.setTimestamp(date);
		executionContext.setUserAndUsername("admin");
		System.out.println("date = " + date);
		
		Thread.sleep(2000);
		
		printExecutionContext();
		
		ApplicationContextUtil.disposeCurrentExecutionContext();
		
		printExecutionContext();
	}

}
