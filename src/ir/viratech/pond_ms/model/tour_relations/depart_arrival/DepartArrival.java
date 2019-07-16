package ir.viratech.pond_ms.model.tour_relations.depart_arrival;

import org.json.JSONException;
import org.json.JSONObject;

import ir.viratech.pond_ms.model.tour_relations.base.model.ExtendedPointObject;

public class DepartArrival extends ExtendedPointObject {



	public JSONObject getJSON() {
		JSONObject jsonObj = new JSONObject();
		try {
			jsonObj.put(PROP_ADDRESS, getAddress());
			jsonObj.put(PROP_TIME, getTime());
			jsonObj.put(PROP_DESCRIPTION, getDescription());
			jsonObj.put(PROP_VEHICLE, getVehicle());
			jsonObj.put(PROP_CITY, getCity());
			jsonObj.put(PROP_POINT, getPointJson());
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return jsonObj;
	}
	
}
