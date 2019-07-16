package ir.viratech.just_ro.core.cache.proxy;

import ir.viratech.just_ro.manager.website.proxy.ProxyScrapper;

public class ProxyCacher {

	public static void startCache()  {
		try {
			ProxyScrapper.newInstance().start();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}

}
