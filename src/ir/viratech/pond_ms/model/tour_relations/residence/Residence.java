package ir.viratech.pond_ms.model.tour_relations.residence;

import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;

import ir.viratech.pond_ms.model.tour_relations.base.model.ExtendedPointObject;

public class Residence extends ExtendedPointObject {



	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Residence [features=" + getFeatures() + ", rate=" + getRate() + ", address=" + getAddress() + ", type=" + getType()
				+ "getCity()=" + getCity() + ", getCountry()="
				+ getCountry() + ", getDescription()=" + getDescription() + ", getVehicle()=" + getVehicle()
				+ ", getName()=" + getName() + "]";
	}
	public JSONObject getJSON() {
		JSONObject jsonObj = new JSONObject();
		try {
			jsonObj.put(PROP_NAME, getName());
			jsonObj.put(PROP_IMAGES, getImages());
			jsonObj.put(PROP_POINT, getPointJson());
			jsonObj.put(PROP_DESCRIPTION, getDescription());
			jsonObj.put(PROP_START_TIME, getStartTime());
			jsonObj.put(PROP_FEATURES, getFeatures());
			jsonObj.put(PROP_RATE, getRate());
			jsonObj.put(PROP_ADDRESS, getAddress());
			jsonObj.put(PROP_TYPE, getType());
			jsonObj.put(PROP_DURATION, getDuration());
			jsonObj.put(PROP_CITY, getCity());
			jsonObj.put(PROP_COUNTRY, getCountry());
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return jsonObj;
	}
	
}
