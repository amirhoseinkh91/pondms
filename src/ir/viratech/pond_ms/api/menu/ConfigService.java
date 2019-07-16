package ir.viratech.pond_ms.api.menu;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.geom.PrecisionModel;

import ir.viratech.commons.api.service.AbstractJsonService;
import ir.viratech.pond_ms.api.auth.MyUserDetailsService;
import ir.viratech.pond_ms.api.menu.dto.ConfigDTO;
import ir.viratech.pond_ms.core.spring.ApplicationContextUtil;
import ir.viratech.pond_ms.model.gismap.GISMap;
import ir.viratech.pond_ms.model.gismap.logic.GISMapMgr;
import ir.viratech.pond_ms.model.user.User;

/**
 * The Class ConfigService.
 */
@Path("/config")
public class ConfigService extends AbstractJsonService {

	/**
	 * Gets the current user info.
	 *
	 * @return the current user info
	 */
	@GET
	public ConfigDTO getCurrentUserInfo() {
		ConfigDTO config = new ConfigDTO();
		User user = MyUserDetailsService.getCurrentUserAttached();
		config.setUserConfig(user);

		Map<String, String> dynamicConfigs = new HashMap<>();
		dynamicConfigs.putAll(getMapConfig(user));

		config.setDynamicConfig(dynamicConfigs);

		// TODO don't send all configuration

		// Server configuration
		config.putServerConfig("server", ApplicationContextUtil.getProperty("server.protocol"),
				ApplicationContextUtil.getProperty("server.port"), ApplicationContextUtil.getProperty("server.host"),
				ApplicationContextUtil.getProperty("server.contextPath"));

		// authServer configuration
		config.putServerConfig("authServer", ApplicationContextUtil.getProperty("authServer.protocol"),
				ApplicationContextUtil.getProperty("authServer.port"),
				ApplicationContextUtil.getProperty("authServer.host"),
				ApplicationContextUtil.getProperty("authServer.contextPath"));

		return config;
	}

	private Map<String, String> getMapConfig(User user) {
		int minZoom, maxZoom, defaultZoom;
		Point center = null;
		if (user != null && user.getOrganization() != null) {
			GISMap map = GISMapMgr.getInstance().getByOrganization(user.getOrganization());
			minZoom = map.getMinZoom();
			maxZoom = map.getMaxZoom();
			defaultZoom = map.getDefaultZoom();
			center = map.getCenter();
		} else {
			minZoom = 10;
			maxZoom = 17;
			defaultZoom = 12;
			//TODO Please, please, correct it! it must have a default in config file!
			center = new GeometryFactory(new PrecisionModel(), 4326).createPoint(new Coordinate(51, 35));
		}

		Map<String, String> dynamicConfigs = new HashMap<>();
		dynamicConfigs.put("map_min_zoom", Integer.toString(minZoom));
		dynamicConfigs.put("map_max_zoom", Integer.toString(maxZoom));
		dynamicConfigs.put("map_default_zoom", Integer.toString(defaultZoom));
		dynamicConfigs.put("map_center", Double.toString(center.getX()) + ", " + Double.toString(center.getY()));

		return dynamicConfigs;
	}

}
