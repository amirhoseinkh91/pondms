package ir.viratech.just_ro.manager.website.proxy.base;

import ir.viratech.pond_ms.core.spring.ApplicationContextUtil;

public class BaseProxy extends Thread{

	protected static final long WAIT_TIME = 3600000;
	
	protected static final int DEFAULT_PORT = 8080;
	protected static final String DEFAULT_HOST = "104.236.54.196";
	
	protected String host;
	protected int port;
	protected final static String FILE_PATH = ApplicationContextUtil.getProperty("proxy-file"); 
	protected final static String PORT_KEY = "port";
	protected final static String HOST_KEY = "host";
	
}
