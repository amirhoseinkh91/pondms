package ir.viratech.pond_ms.core.ip;

import org.elasticsearch.common.netty.handler.timeout.ReadTimeoutException;

import com.fasterxml.jackson.databind.JsonNode;

import ir.viratech.commons.util.jackson.ObjectMapperProvider;
import ir.viratech.pond_ms.commons.geo.Point;
import ir.viratech.pond_ms.core.web_client.WebPageReader;

public class IPToGeoLocationConverter {
	private static final String URL = "http://ip-api.com/json";
	private static final String PROP_LON = "lon";
	private static final String PROP_LAT = "lat";

	public static Point convertToPoint(String ipAddress) {
		try {
			String jsonText = WebPageReader.readResponse(URL);
			JsonNode jsonNode = ObjectMapperProvider.getObjectMapper().readTree(jsonText);
			return new Point(jsonNode.get(PROP_LAT).asDouble(), jsonNode.get(PROP_LON).asDouble());
		} catch (Exception e) {
			throw new ReadTimeoutException(e);
		}
	}


}
