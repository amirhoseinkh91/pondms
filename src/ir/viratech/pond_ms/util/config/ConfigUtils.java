package ir.viratech.pond_ms.util.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;

import org.apache.log4j.Logger;

import ir.viratech.pond_ms.model.layer.Layer;

public class ConfigUtils {

	private static final transient Logger logger = Logger.getLogger(ConfigUtils.class);

	public static String getPropertyFromConfigFile(String propertyFileName, String propName) 
			throws UnsupportedEncodingException, IOException {
		String prop;
		FileInputStream input = new FileInputStream(propertyFileName);
		try {
			Properties properties = new Properties();
			properties.load(input);		
			prop = properties.getProperty(propName);
		}finally {
			if(input != null)
				input.close();
		}

		return prop;
	}

	public static Map<String, String> getPropertyFromConfigFile(String propertyFileName, List<String> propNameList) 
			throws UnsupportedEncodingException, IOException {
		Map<String, String> propMap = new HashMap<String, String>();
		FileInputStream input = new FileInputStream(propertyFileName);
		try {
			Properties properties = new Properties();
			properties.load(input);
			for (String propName : propNameList) {
				propMap.put(propName, properties.getProperty(propName));
			}
		} finally {
			if(input != null)
				input.close();
		}
		return propMap;
	}

	public static String getServerAddress() {
		final String configFileAddress 		= ConfigUtils.class.getResource("/config.properties").getFile();
		final String protocol 				= "server.protocol";
		final String host 					= "server.host";
		final String port 					= "server.port";
		final String contextPath 			= "server.contextPath";
		return getAddress(configFileAddress, protocol, host, port, contextPath);		
	}

	public static String getAuthServerAddress() {
		final String configFileAddress 		= ConfigUtils.class.getResource("/config.properties").getFile();
		final String protocol 				= "authServer.protocol";
		final String host 					= "authServer.host";
		final String port 					= "authServer.port";
		final String contextPath 			= "authServer.contextPath";
		return getAddress(configFileAddress, protocol, host, port, contextPath);		
	}

	private static String getAddress(
			String configFileAddress, String protocol, String host, String port, String contextPath) {
		Map<String, String> list;
		try {
			list = getPropertyFromConfigFile(configFileAddress, Arrays.asList(protocol, host, port, contextPath));
		} catch (IOException e) {
			logger.error("failed to parse config file!" + e.getMessage());
			return null;
		}
		return list.get(protocol) + "://" + list.get(host) + ":" + list.get(port) + "/" + list.get(contextPath) + "/";
	}

	public static String get(String key){
		try{
			String configFileAddress = ConfigUtils.class.getResource("/constants.properties").getFile();
			return getPropertyFromConfigFile(configFileAddress, key);
		}catch(IOException ex){
			logger.error(ex);
			return null;
		}
	}
	
	public static Boolean getAsBoolean(String key) {
		return Boolean.valueOf(get(key));
	}
	
	public static Integer getAsInteger(String key) {
		return Integer.valueOf(get(key));
	}
	
	public static Integer getGISMapMinZoomThreshold() {
		return getAsInteger(get(ConfigConstants.GIS_MAP_MIN_ZOOM_THRESHOLD));
	}
	
	public static Integer getGISMapMaxZoomThreshold() {
		return getAsInteger(get(ConfigConstants.GIS_MAP_MAX_ZOOM_THRESHOLD));
	}
	
	public static Map<String, Set<String>> getValidDataFileExtensions() {
		
		Scanner scanner = null;
		scanner = new Scanner(ConfigUtils.class.getResource("/validDataFileExtensions.txt").getFile());
		ArrayList<String> lines = new ArrayList<>();
		while (scanner.hasNextLine()) {
			lines.add(scanner.nextLine());
		}
		scanner.close();
		if (lines.size() != 2)
			return getDefaultValidDataFileExtensions();
		
		Map<String, Set<String>> result = new HashMap<>();
		Set<String> vector = new HashSet<>();
		for (String str: lines.get(1).split(","))
			vector.add(str);
		Set<String> raster = new HashSet<>();
		for (String str: lines.get(0).split(","))
			raster.add(str);
		result.put(Layer.TYPE_RASTER, raster);
		result.put(Layer.TYPE_VECTOR, vector);
		return result;
	}
	
	private static Map<String, Set<String>> getDefaultValidDataFileExtensions() {
		Map<String, Set<String>> map = new HashMap<>();
		Set<String> vector = new HashSet<>();
		Set<String> raster = new HashSet<>();
		vector.add("shp");
//		vector.add("shx");
//		vector.add("dbf");
		raster.add("tif");
//		raster.add("tfw");
		map.put(Layer.TYPE_VECTOR, vector);
		map.put(Layer.TYPE_RASTER, raster);
		return map;
	}

}
