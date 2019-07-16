package ir.viratech.pond_ms.core.spring;

import ir.viratech.commons.execution_context.ExecutionContextHolder;
import ir.viratech.commons.spring.context.ApplicationContextInitializer_Config;
import ir.viratech.commons.spring.context.ApplicationContextProvider;
import ir.viratech.pond_ms.core.execution_context.MyExecutionContext;

import org.springframework.context.ApplicationContext;

/**
 * The Class ApplicationContextUtil.
 */
public final class ApplicationContextUtil {

	/** The Constant DB_URL. */
	public static final String DB_URL = "db.url";
	
	/** The Constant DB_USERNAME. */
	public static final String DB_USERNAME = "db.username";
	
	/** The Constant DB_PASSWORD. */
	public static final String DB_PASSWORD = "db.password";
	
	private static ApplicationContextInitializer_Config aci = new ApplicationContextInitializer_Config();

	
	public static ApplicationContextInitializer_Config getApplicationContextInitializer() {
		return aci;
	}
	
	private ApplicationContextUtil() {
		// private constructor added to hide implicit public one
	}
	
	private static String defaultApplicationContextUrl = ApplicationContextUtil.class.getResource("applicationContext-all.xml").toString();
	
	public static void setDefaultApplicationContextUrl(String applicationContextUrl) {
		ApplicationContextUtil.defaultApplicationContextUrl = applicationContextUrl;
	}
	
	
	public static void initializeCliApplicationContext() {
		ApplicationContextProvider.initializeCliApplicationContext(defaultApplicationContextUrl, aci);
	}
	
	/**
	 * Gets the application context.
	 *
	 * @return the application context
	 */
	public static ApplicationContext getApplicationContext() {
		return ApplicationContextProvider.getApplicationContext(defaultApplicationContextUrl, aci);
	}

	/**
	 * Gets the property.
	 *
	 * @param key the key
	 * @return the property
	 */
	public static String getProperty(String key) {
		return ApplicationContextProvider.getProperty(key);
	}

	
	public static long getPropertyAsLongExpression(String key) {
		return ApplicationContextProvider.getPropertyAsLongExpression(key);
	}
	
	
	
	
	private static ExecutionContextHolder getExecutionContextHolder() {
		return getApplicationContext().getBean(ExecutionContextHolder.class);
	}
	public static MyExecutionContext getCurrentExecutionContext() {
		return (MyExecutionContext) getExecutionContextHolder().getCurrentExecutionContext();
	}
	public static MyExecutionContext acquireAndGetCurrentExecutionContext() {
		MyExecutionContext currentExecutionContext = (MyExecutionContext) getExecutionContextHolder().acquireAndGetCurrentExecutionContext();
		currentExecutionContext.setSource(ApplicationContextUtil.class.getSimpleName());
		return currentExecutionContext;
	}
	public static void disposeCurrentExecutionContext() {
		getExecutionContextHolder().disposeCurrentExecutionContext();
	}

}
