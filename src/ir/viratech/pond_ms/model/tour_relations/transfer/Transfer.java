package ir.viratech.pond_ms.model.tour_relations.transfer;

import org.json.JSONException;
import org.json.JSONObject;

import ir.viratech.pond_ms.model.tour_relations.base.model.ExtendedPointObject;

public class Transfer extends ExtendedPointObject {
	
	public JSONObject getJSON() {
		JSONObject jsonObj = new JSONObject();
		try {
			jsonObj.put(PROP_DURATION, getDuration());
			jsonObj.put(PROP_VEHICLE, getVehicle());
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return jsonObj;
	}
}
