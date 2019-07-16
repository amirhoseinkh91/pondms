package ir.viratech.pond_ms.ui.cli.proxy_test;

import java.net.InetSocketAddress;
import java.net.Proxy;

import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;

public class ProxyTEST {

	public static void main(String[] args) {
		try {
			String ip = "74.56.66.112";
			String portStr = "8080";
			String password = "191257";
			String username = "y194643";
			
			int port = 8080;
			
//            System.setProperty("https.proxyHost", ip);
//            System.setProperty("https.proxyPort", portStr);
//            
//            System.setProperty("http.proxyUser", username);
//            System.setProperty("http.proxyPassword", password);
			
			Proxy p = new Proxy(Proxy.Type.HTTP, InetSocketAddress.createUnresolved(ip, port));
			
			String userAgent = "Mozilla";
			String url = "https://www.youtube.com/";
			System.out.println("connection started......");
			Response response = Jsoup.connect(url).proxy(p).timeout(20000).userAgent(userAgent).method(Method.GET).execute();
			
			System.out.println(response.statusCode() + " --- " + response.statusMessage());
//			System.out.println(response.body());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
