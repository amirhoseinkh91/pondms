package ir.viratech.pond_ms.model.tour_relations.guide;

import org.json.JSONException;
import org.json.JSONObject;

public class Guide {

	public static final String PROP_NAME = "name";
	public static final String PROP_IMAGE = "image";
	public static final String PROP_PHONE_NUMBER = "phoneNumber";
	
	private String name;
	private String image;
	private String phoneNumber;
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the image
	 */
	public String getImage() {
		return image;
	}

	/**
	 * @param image
	 *            the image to set
	 */
	public void setImage(String image) {
		this.image = image;
	}

	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber
	 *            the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public JSONObject getJSON() {
		JSONObject jsonObj = new JSONObject();
		try {
			jsonObj.put(PROP_NAME, name);
			jsonObj.put(PROP_IMAGE, image);
			jsonObj.put(PROP_PHONE_NUMBER, phoneNumber);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return jsonObj;
	}
	
}
