package ir.viratech.pond_ms.model.tour_relations.sight_seeing;

import org.json.JSONException;
import org.json.JSONObject;

import ir.viratech.pond_ms.model.tour_relations.base.model.ExtendedPointObject;

public class SightSeeing extends ExtendedPointObject {


	public JSONObject getJSON() {
		JSONObject jsonObj = new JSONObject();
		try {
			jsonObj.put(PROP_NAME, getName());
			jsonObj.put(PROP_SPECIAL_NAME, getSpecialName());
			jsonObj.put(PROP_CATEGORY, getCategory());
			jsonObj.put(PROP_IMAGES, getImages());
			jsonObj.put(PROP_DESCRIPTION, getDescription());
			jsonObj.put(PROP_CITY, getCity());
			jsonObj.put(PROP_COUNTRY, getCountry());
			jsonObj.put(PROP_DURATION, getDuration());
			jsonObj.put(PROP_START_TIME, getStartTime());
			jsonObj.put(PROP_POINT, getPointJson());
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return jsonObj;
	}
	
}
