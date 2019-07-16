package ir.viratech.just_ro.core.cache;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import ir.viratech.just_ro.core.cache.proxy.ProxyCacher;

public class StartCache implements ServletContextListener {

	Thread hotelsCacheThread = null;

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		try {
			hotelsCacheThread.stop();
			hotelsCacheThread.interrupt();
		} catch (Exception ex) {

		}
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
//		startCacheHotels();
//		startCacheProxies();
	}

	private void startCacheProxies(){
		ProxyCacher.startCache();
	}
	
	private void startCacheHotels() {
		try {
			hotelsCacheThread = CacheHotelsThread.class.newInstance();
			hotelsCacheThread.start();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
}
