package ir.viratech.pond_ms.ui.cli.test;

import ir.viratech.pond_ms.core.spring.ApplicationContextUtil;

import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;

/**
 * The Class TestEnvironment.
 */
public class TestEnvironment {


	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		System.out.println(System.getenv());
		ApplicationContext applicationContext = ApplicationContextUtil.getApplicationContext();
		Environment env = applicationContext.getEnvironment();
		System.out.println("active profiles: "+ Arrays.toString(env.getActiveProfiles()));
		System.out.println("default profiles: "+ Arrays.toString(env.getDefaultProfiles()));
		System.out.println("db.username: "+env.getProperty("db.username"));
		System.out.println("execution.type: "+ApplicationContextUtil.getProperty("execution.type"));
		System.out.println("getBean(\"authServerNonSecureUrl\"): "+applicationContext.getBean("authServerNonSecureUrl"));
	}
}
