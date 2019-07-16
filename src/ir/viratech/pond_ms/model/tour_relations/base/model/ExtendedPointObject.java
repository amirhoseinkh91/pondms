package ir.viratech.pond_ms.model.tour_relations.base.model;

import java.io.Serializable;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import ir.viratech.pond_ms.model.map_object.vector.PointObject;
import org.springframework.data.mongodb.core.mapping.Field;

public class ExtendedPointObject implements Serializable {

	public static final String PROP_UID = "uid";
	public static final String PROP_NAME = "name";
	public static final String PROP_POINT = "point";
	public static final String PROP_DAY = "day";
	public static final String PROP_CITY = "city";
	public static final String PROP_COUNTRY = "country";
	public static final String PROP_DESCRIPTION = "description";
	public static final String PROP_VEHICLE = "vehicle";
	public static final String PROP_IMAGES = "images";
	public static final String PROP_DURATION = "duration";
	public static final String PROP_START_TIME = "startTime";
	public static final String PROP_OBJECT_TYPE = "objectType";

	public static final String PROP_MEAL_NAME = "mealName";

	public static final String PROP_SPECIAL_NAME = "specialName";
	public static final String PROP_CATEGORY = "category";
	public static final String PROP_FEATURES = "features";
	public static final String PROP_RATE = "rate";
	public static final String PROP_TYPE = "type";
	public static final String PROP_ADDRESS = "address";
	public static final String PROP_TIME = "time";

	private String time;

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	private String features;
	private int rate;
	private String address;
	private String type;

	public String getFeatures() {
		return features;
	}

	public void setFeatures(String features) {
		this.features = features;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	private String specialName;
	private String category;

	public String getSpecialName() {
		return specialName;
	}

	public void setSpecialName(String specialName) {
		this.specialName = specialName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	private String mealName;

	public String getMealName() {
		return mealName;
	}

	public void setMealName(String mealName) {
		this.mealName = mealName;
	}
	private String name;
	private String startTime;
	private String duration;
	private List<String> images;
	private String uid;
	private String city;
	private String country;
	private String description;
	private String vehicle;
	private String objectType;
	private Point point;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Point getPoint() {
		return point;
	}

	public void setPoint(Point point) {
		this.point = point;
	}

	/**
	 * @return the objectType
	 */
	public String getObjectType() {
		return objectType;
	}

	/**
	 * @param objectType the objectType to set
	 */
	public void setObjectType(String objectType) {
		this.objectType = objectType;
	}

	/**
	 * @return the startTime
	 */
	public String getStartTime() {
		return startTime;
	}

	/**
	 * @param startTime the startTime to set
	 */
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	/**
	 * @return the duration
	 */
	public String getDuration() {
		return duration;
	}

	/**
	 * @param duration
	 *            the duration to set
	 */
	public void setDuration(String duration) {
		this.duration = duration;
	}
	
	/**
	 * @return the images
	 */
	public List<String> getImages() {
		return images;
	}
	
	/**
	 * @param list of images to set
	 */
	public void setImages(List<String> images){
		this.images = images;
	}
	

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city
	 *            the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country
	 *            the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the vehicle
	 */
	public String getVehicle() {
		return vehicle;
	}

	/**
	 * @param vehicle
	 *            the vehicle to set
	 */
	public void setVehicle(String vehicle) {
		this.vehicle = vehicle;
	}
	
	/**
	 * @return the uid
	 */
	public String getUid() {
		return uid;
	}

	/**
	 * @param uid the uid to set
	 */
	public void setUid(String uid) {
		this.uid = uid;
	}

	public JSONObject getPointJson() {
		JSONObject jsonObj = new JSONObject();
		JSONArray jsonArray = new JSONArray();
		try {
			jsonObj.put("type", "Point");
			jsonArray.put(getPoint().getX());
			jsonArray.put(getPoint().getY());
			jsonObj.put("coordinates", jsonArray);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return jsonObj;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		if (!super.equals(o)) return false;

		ExtendedPointObject that = (ExtendedPointObject) o;

		if (startTime != null ? !startTime.equals(that.startTime) : that.startTime != null) return false;
		if (duration != null ? !duration.equals(that.duration) : that.duration != null) return false;
		if (images != null ? !images.equals(that.images) : that.images != null) return false;
		if (uid != null ? !uid.equals(that.uid) : that.uid != null) return false;
		if (city != null ? !city.equals(that.city) : that.city != null) return false;
		if (country != null ? !country.equals(that.country) : that.country != null) return false;
		if (description != null ? !description.equals(that.description) : that.description != null) return false;
		if (vehicle != null ? !vehicle.equals(that.vehicle) : that.vehicle != null) return false;
		return objectType == that.objectType;
	}

	@Override
	public int hashCode() {
		int result = super.hashCode();
		result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
		result = 31 * result + (duration != null ? duration.hashCode() : 0);
		result = 31 * result + (images != null ? images.hashCode() : 0);
		result = 31 * result + (uid != null ? uid.hashCode() : 0);
		result = 31 * result + (city != null ? city.hashCode() : 0);
		result = 31 * result + (country != null ? country.hashCode() : 0);
		result = 31 * result + (description != null ? description.hashCode() : 0);
		result = 31 * result + (vehicle != null ? vehicle.hashCode() : 0);
		result = 31 * result + (objectType != null ? objectType.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "ExtendedPointObject{" +
				"name='" + name + '\'' +
				", startTime='" + startTime + '\'' +
				", duration='" + duration + '\'' +
				", images=" + images +
				", uid='" + uid + '\'' +
				", city='" + city + '\'' +
				", country='" + country + '\'' +
				", description='" + description + '\'' +
				", vehicle='" + vehicle + '\'' +
				", objectType='" + objectType + '\'' +
				", point=" + point +
				'}';
	}
}
