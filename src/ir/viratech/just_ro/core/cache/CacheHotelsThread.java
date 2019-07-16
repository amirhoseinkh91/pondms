package ir.viratech.just_ro.core.cache;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import ir.viratech.commons.cm.model.entity_instance.EntityInstance;
import ir.viratech.commons.cm.model.entity_instance.logic.EntityInstanceMgr;
import ir.viratech.commons.cm.model.entity_instance.logic.EntityInstanceMgrProvider;
import ir.viratech.commons.cm.model.entity_type.EntityTypeNotFoundException;
import ir.viratech.commons.persistence.base.BaseAbstractEntityDAO;
import ir.viratech.commons.util.jackson.JacksonUtils;
import ir.viratech.just_ro.api.search.Search;
import ir.viratech.just_ro.manager.website.proxy.ProxyManager;
import ir.viratech.just_ro.model.calendar.CalendarTool;
import ir.viratech.just_ro.model.hotel.Hotel;
import ir.viratech.pond_ms.core.spring.ApplicationContextUtil;
import ir.viratech.pond_ms.model.map_object.vector.PointObject;
import ir.viratech.pond_ms.model.map_object.vector.dao.PointObjectDAO;
import ir.viratech.pond_ms.model.map_object.vector.logic.PointObjectMgr;

public class CacheHotelsThread extends Thread {

	private static final String cacheLogFilePath = ApplicationContextUtil.getProperty("cache-Log-File");
	
	private static final String HOTEL_SCHEMA_KEY = "Hotel";
	private static final int MAX_WAIT_TIME = 300000;
	private static final int MIN_WAIT_TIME = 5000;
	private static final int STATIC_WAIT_TIME = 1000;
	
	@Override
	public void run() {
		try {
			cache();
		} catch (IOException e) {
		
		}
	}

	private void cache() throws IOException {
		FileWriter writer = null;
		try {
			writer = getLogFileWriter();
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		while (true) {
			BaseAbstractEntityDAO.touchSession();
			List<PointObject> hotels = getHotels();
			for (PointObject hotel : hotels) {
				EntityInstanceMgr mgr;
				try {
					mgr = EntityInstanceMgrProvider.getMgr(hotel.getLayer().getFormSchemaKey());

					EntityInstance formInstance = hotel.getFormInstance("full", false);
					String city = hotel.getCityFromLayer();
					String hotelName = hotel.getName();
					String today = CalendarTool.class.newInstance().getIranianToday();
					try {
						List<Hotel> searchResult = Search.class.newInstance().searchHotelsNames(city, hotelName, today);
						ArrayNode lowestPricesArray = JacksonUtils.createEmptyArrayNode();
						for (Hotel foundHotel : searchResult) {
							ObjectNode lowestPriceJson = JacksonUtils.createEmptyObjectNode();
							lowestPriceJson.put("price", (long) foundHotel.getLowestPriceValue());
							lowestPriceJson.put("link", foundHotel.getWebUrl());
							lowestPricesArray.add(lowestPriceJson);
						}
						String[] currentTimeParts = CalendarTool.class.newInstance()
								.getCurrentTime("yyyy/MM/dd HH:mm:ss").split(" ");
						String[] timeParts = currentTimeParts[1].split(":");
						String time = timeParts[0] + ":" + timeParts[1];
						if (lowestPricesArray.size() > 0){
							formInstance.set("lowestPrice" , findLowestPrice(lowestPricesArray));
							formInstance.set("lowestPrices", lowestPricesArray);
							formInstance.set("lastModified_time", time);
							formInstance.set("lastModified_date", today);
						}
						else
							if (formInstance.get("lowestPrice") != null || !(formInstance.get("lowestPrice") instanceof NullNode))
								formInstance.remove("lowestPrice");
						
						mgr.edit(formInstance.getUid(), formInstance, true);
						Thread.sleep(ProxyManager.newInstance().getRandomNumber(MIN_WAIT_TIME, MAX_WAIT_TIME));
					} catch (Exception e) {
						writer.append(hotel.getName() + "\t" + "did not cached...");
						writer.flush();
						continue;
					}
				} catch (EntityTypeNotFoundException e1) {
					writer.append(hotel.getName() + "\t" + "did not cached...");
					writer.flush();
					continue;
				} catch (InstantiationException e1) {
					writer.append(hotel.getName() + "\t" + "did not cached...");
					writer.flush();
					continue;
				} catch (IllegalAccessException e1) {
					writer.append(hotel.getName() + "\t" + "did not cached...");
					writer.flush();
					continue;
				}
			}
			BaseAbstractEntityDAO.closeCurrentThreadSessions();
		}
	}

	private long findLowestPrice(ArrayNode lowestPricesArray) {
		long min_price = 900000000;
		for (JsonNode jsonNode : lowestPricesArray) {
			long price = jsonNode.get("price").asLong();
			if (price <= min_price && price > 0)
				min_price = price;
		}
		return min_price;
	}
	
	private final List<PointObject> getHotels() {
		List<PointObject> hotels = new ArrayList<>();
		for (PointObject pointObject : PointObjectMgr.getInstance().list())
			if (pointObject.getLayer().getFormSchemaKey().equals(HOTEL_SCHEMA_KEY))
				hotels.add(pointObject);
		return hotels;
	}

	private final FileWriter getLogFileWriter() throws IOException {
		return new FileWriter(new File(cacheLogFilePath) , true);
	}
}
