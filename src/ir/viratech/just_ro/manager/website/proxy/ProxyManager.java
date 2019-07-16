package ir.viratech.just_ro.manager.website.proxy;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.Map;
import java.util.Random;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import ir.viratech.just_ro.manager.website.proxy.base.BaseProxy;


public class ProxyManager extends BaseProxy {

	public static Proxy getInstance() throws InstantiationException, IllegalAccessException{
		return Proxy.class.newInstance();
	}
	
	public static ProxyManager newInstance() throws InstantiationException, IllegalAccessException {
		return ProxyManager.class.newInstance();
	}
	
	private JSONArray readFromFile() throws FileNotFoundException, IOException, ParseException {
		org.json.simple.JSONArray jsonarr = (org.json.simple.JSONArray) new JSONParser().parse(new FileReader(FILE_PATH));
		return new JSONArray(jsonarr);
	}
	
	public void setNewProxies(Map<String, Integer> proxies) {
		JSONArray proxiesArr = new JSONArray();
		for (String host : proxies.keySet()) {
			JSONObject proxyObj = new JSONObject();
			try {
				proxyObj.put(HOST_KEY, host);
				proxyObj.put(PORT_KEY, proxies.get(host));
			} catch (JSONException e) {
				e.printStackTrace();
				continue;
			}
			proxiesArr.put(proxyObj);
		}
		try {
			writeProxiesToFile(proxiesArr);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void writeProxiesToFile(JSONArray proxiesArr) throws IOException{
		try {
			File f = new File(FILE_PATH);
			FileWriter writer = new FileWriter(f);
			writer.append(proxiesArr.toString());
			writer.flush();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private void getRandomHostPort(JSONArray json) {
		int i = getRandomNumber(json.length());
		try {
			port =  json.getJSONObject(i).getInt(PORT_KEY);
			host = json.getJSONObject(i).getString(HOST_KEY);
		} catch (JSONException e) {
			port = DEFAULT_PORT;
			host = DEFAULT_HOST;
		} 
	}
	
	public long getRandomNumber(int minimum, int maximum){
		while (true) {
			long randomNumber =(long) new Random().nextInt(maximum);
			if (randomNumber >= minimum)
				return randomNumber;
		}
	}
	
	private int getRandomNumber(int maximum){
		if(maximum == 1)
			return 1;
		return new Random().nextInt(maximum);
	}
	
	public Proxy getRandomProxy() {
		try {
			getRandomHostPort(readFromFile());
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
		return new Proxy(Proxy.Type.HTTP, InetSocketAddress.createUnresolved(host, port));
	}
}
