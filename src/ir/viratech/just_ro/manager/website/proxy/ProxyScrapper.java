package ir.viratech.just_ro.manager.website.proxy;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import ir.viratech.just_ro.manager.website.proxy.base.BaseProxy;
import ir.viratech.just_ro.model.Website;

public class ProxyScrapper extends BaseProxy {

	public static ProxyScrapper newInstance() throws InstantiationException, IllegalAccessException {
		return ProxyScrapper.class.newInstance();
	}

	private Map<String, Integer> proxies;

	public Map<String, Integer> getProxies() {
		return proxies;
	}

	public void setProxies(Map<String, Integer> proxies) {
		this.proxies = proxies;
	}

	@Override
	public void run() {
		startScrape();
	}
	
	public void startScrape() {
		while (true) {
			try {
				findValidProxies(getConnected().parse());
				ProxyManager.newInstance().setNewProxies(proxies);
				Thread.sleep(WAIT_TIME);
			} catch (Exception e) {
				try {
					Thread.sleep(WAIT_TIME / 100);
				} catch (InterruptedException e1) {

				}
				e.printStackTrace();
			}
		}
	}

	private void findValidProxies(Document document) {
		final String cssQuery = "body";
		if (!document.body().equals("Maximum number of open connections reached.")){
			Elements scripts = document.select(cssQuery).get(0).child(1).getElementsByTag("table").get(0)
					.getElementsByTag("script");
			proxies = new HashMap<>();
			for (Element script : scripts) {
				String ip = null;
				int port = 0;
				try {
					String[] parts = script.html().split(";");
					String x = parts[0].toString().trim().split(" ")[3].trim().substring(1);
					x = x.substring(0, x.indexOf("'"));
					String y = parts[1].toString().trim().split(" ")[3].trim().replaceAll("'", "");
					int p1 = Integer.parseInt(parts[2].toString().trim().split(" ")[3].trim());
					int p2 = Integer.parseInt(parts[2].toString().trim().split(" ")[5].trim());
					ip = reverse(x) + y;
					port = p1 + p2;
					getConnected(ip, port);
					proxies.put(ip, port);
				} catch (Exception e) {
					try {
						Thread.sleep(50);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
					continue;
				}
			}
		}
	}

	private String reverse(String s) {
		return new StringBuilder(s).reverse().toString();
	}

	private Response getConnected(String ip, Integer port) throws Exception {
		final String url = "https://www.youtube.com/";
		Proxy p = new Proxy(Proxy.Type.HTTP, InetSocketAddress.createUnresolved(ip, port));
		return Jsoup.connect(url).userAgent(Website.userAgent).method(Method.GET).proxy(p).execute();
	}

	private Response getConnected() throws Exception {
		final String url = "http://proxydb.net/?protocol=https";
		return Jsoup.connect(url).method(Method.GET).header("Connection", "keep-alive").ignoreContentType(true)
				.ignoreHttpErrors(true).header("Host", "proxydb.net").userAgent(Website.userAgent)
				.execute();
	}
}
