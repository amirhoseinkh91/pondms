package ir.viratech.pond_ms.model.tour_relations.guide.logic;

import org.json.JSONException;
import org.json.JSONObject;

import ir.viratech.pond_ms.model.tour_relations.base.logic.BaseManager;
import ir.viratech.pond_ms.model.tour_relations.guide.Guide;

public class GuideManager extends BaseManager{

	public static Guide getInstance() throws InstantiationException, IllegalAccessException {
		return Guide.class.newInstance();
	}
	
	public static GuideManager newInstance() throws InstantiationException, IllegalAccessException {
		return GuideManager.class.newInstance();
	}
	
	public Guide parse(JSONObject jsonObject) {
		Guide g = null;
		try {
			g = getInstance();
			g.setImage(jsonObject.getString(Guide.PROP_IMAGE));
			g.setName(jsonObject.getString(Guide.PROP_NAME));
			g.setPhoneNumber(jsonObject.getString(Guide.PROP_PHONE_NUMBER));
		} catch (InstantiationException | IllegalAccessException | JSONException e) {
			e.printStackTrace();
		}
		return g;
	}
}
