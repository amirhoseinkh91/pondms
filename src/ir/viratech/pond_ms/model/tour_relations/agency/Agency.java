package ir.viratech.pond_ms.model.tour_relations.agency;

import java.util.ArrayList;
import java.util.List;

import ir.viratech.pond_ms.core.spring.ApplicationContextUtil;
import ir.viratech.pond_ms.model.tour_relations.agency.logic.AgencyManager;
import ir.viratech.pond_ms.model.tour_relations.base.model.ExtendedPointObject;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.fasterxml.jackson.databind.JsonNode;

import ir.viratech.commons.cm.model.entity_instance.EntityInstance;
import ir.viratech.pond_ms.model.map_object.vector.PointObject;

public class Agency extends ExtendedPointObject {
	
	public static final String PROP_ADDRESS = "address";
	public static final String PROP_USER_NAME = "user_name";
	public static final String PROP_INTRUNSIC_VALUE = "TntrinsicValue";
	public static final String PROP_TEMPORAL_VALUE = "TemporalValue";
	public static final String PROP_TOTAL_SCORE = "TotalScore";
	public static final String PROP_WEBSITE = "website";
	public static final String PROP_PHONE_NUMBER = "phoneNumber";
	public static final String PROP_IMAGES = "Images"; // is an array node
	public static final String PROP_UID = "_uid";
	public static final String PROP_EXTUID = "extuid";
	
	private String username;
	private int totalScore;
	private int intrinsicValue;
	private int temporalValue;
	private String website;
	private String phone;
	private String extuid;
	private String image;
	
	public JSONObject getJSON() {
		JSONObject jsonObj = new JSONObject();
		JSONArray imagesJson = new JSONArray();
		JSONArray coordinates = new JSONArray();
		JSONObject pointJson = new JSONObject();
		try {
			jsonObj.put(PROP_NAME, getName());
			jsonObj.put(PROP_UID, this.getExtuid());
			jsonObj.put(PROP_USER_NAME, username);
			jsonObj.put(PROP_TOTAL_SCORE, totalScore);
			jsonObj.put(PROP_RATE, getRate());
			jsonObj.put(PROP_INTRUNSIC_VALUE, intrinsicValue);
			jsonObj.put(PROP_TEMPORAL_VALUE, temporalValue);
			jsonObj.put(PROP_ADDRESS, getAddress());
			jsonObj.put(PROP_WEBSITE, website);
			jsonObj.put(PROP_PHONE_NUMBER, phone);
			for (String imageHash : getImages())
				imagesJson.put(imageHash);
			jsonObj.put("image", imagesJson);
			pointJson.put("type", "Point");
			coordinates.put(getPoint().getX());
			coordinates.put(getPoint().getY());
			pointJson.put("coordinates", coordinates);
			jsonObj.put("point", pointJson);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return jsonObj;
	}

	public void setExtuid(String extuid) {
		this.extuid = extuid;
	}

	public String getExtuid() {
		return extuid;
	}

//	public void initAgencyFromFormInstance() {
////		final EntityInstance formInstance = this.getFormInstance("full", false);
//		this.setUserName(formInstance.get(PROP_USER_NAME).asText());
//		this.setTotalScore(formInstance.get(PROP_TOTAL_SCORE).asInt());
//		this.setRate(formInstance.get(PROP_RATE).asInt());
//		this.setIntrinsicValue(formInstance.get(PROP_INTRUNSIC_VALUE).asInt());
//		this.setTemporalValue(formInstance.get(PROP_TEMPORAL_VALUE).asInt());
//		this.setAddress(formInstance.get(PROP_ADDRESS).asText());
//		this.setWebsite(formInstance.get(PROP_WEBSITE).asText());
//		this.setPhone(formInstance.get(PROP_PHONE_NUMBER).asText());
////		this.setImages(formInstance.get(PROP_IMAGES));
//	}
	
//	public void setImages(JsonNode jsonNode) {
//		List<String> images = new ArrayList<>();
//		for (JsonNode jn : jsonNode) {
//			images.add(jn.asText());
//		}
//		setImages(images);
//	}

	public int getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}

	public int getIntrinsicValue() {
		return intrinsicValue;
	}

	public void setIntrinsicValue(int intrinsicValue) {
		this.intrinsicValue = intrinsicValue;
	}

	public int getTemporalValue() {
		return temporalValue;
	}

	public void setTemporalValue(int temporalValue) {
		this.temporalValue = temporalValue;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
}
