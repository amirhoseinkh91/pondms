package ir.viratech.pond_ms.model.tour_relations.meal;

import org.json.JSONException;
import org.json.JSONObject;

import ir.viratech.pond_ms.model.tour_relations.base.model.ExtendedPointObject;

public class Meal extends ExtendedPointObject {
	

	
	public JSONObject getJSON() {
		JSONObject jsonObj = new JSONObject();
		try {
			jsonObj.put(PROP_NAME, getName());
			jsonObj.put(PROP_MEAL_NAME, getMealName());
			jsonObj.put(PROP_IMAGES, getImages());
			jsonObj.put(PROP_START_TIME, getStartTime());
			jsonObj.put(PROP_DESCRIPTION, getDescription());
			jsonObj.put(PROP_DURATION, getDuration());
			jsonObj.put(PROP_CITY, getCity());
			jsonObj.put(PROP_COUNTRY, getCountry());
			jsonObj.put(PROP_POINT, getPointJson());
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return jsonObj;
	}

	@Override
	public String toString() {
		return "Meal{" +
				"mealName='" + getMealName() + '\'' +
				"} " + super.toString();
	}
}
