package ir.viratech.pond_ms.model.map_object.vector.logic;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ir.viratech.pond_ms.model.hotel.Hotel;
import ir.viratech.pond_ms.model.map_object.vector.PointObject;
import org.json.JSONException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

import ir.viratech.pond_ms.core.spring.ApplicationContextUtil;
import ir.viratech.pond_ms.model.map_object.vector.base.BasePointObjectMgr;

/**
 * Mgr class for entity
 * "ir.viratech.pond_ms.model.map_object.vector.PointObject".
 */
public class PointObjectMgr extends BasePointObjectMgr {

	private static final String topPlacesFilepath = "topPlaces";

	public ArrayNode getTopPlaces()
			throws JsonProcessingException, IOException, InstantiationException, IllegalAccessException, JSONException {
		ObjectMapper mapper = new ObjectMapper();
		ArrayNode node = mapper.createArrayNode();
		for (String name : readTopPlacesNamesFromFile()) {
			try {
				node.add(getDAO().getByName(name));
			} catch (Exception e) {
				continue;
			}
		}
		return node;
	}

	private List<String> readTopPlacesNamesFromFile() throws FileNotFoundException {
		List<String> names = new ArrayList<>();
		File file = new File(ApplicationContextUtil.getProperty(topPlacesFilepath));
		Scanner scanner = new Scanner(file);
		while (scanner.hasNextLine()) {
			names.add(scanner.nextLine());
		}
		scanner.close();
		return names;
	}

	public PointObject getPointObjectByName(String name) {
		return this.getDAO().getPointObjectByName(name);
	}
}