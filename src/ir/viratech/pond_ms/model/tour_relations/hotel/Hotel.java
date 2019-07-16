package ir.viratech.pond_ms.model.tour_relations.hotel;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import ir.viratech.pond_ms.model.tour_relations.base.model.ExtendedPointObject;
import ir.viratech.pond_ms.model.tour_relations.room.Room;

public class Hotel extends ExtendedPointObject {

	public static final String PROP_STARS = "stars";
	public static final String PROP_GRADE = "grade";
	public static final String PROP_ROOMS = "rooms";
	
	private int stars;

	public int getStars() {
		return stars;
	}

	public void setStars(int stars) {
		this.stars = stars;
	}

	private String grade;

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	private List<Room> rooms;

	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

	@Override
	public String toString() {
		return "Hotel [stars=" + stars + ", grade=" + grade + ", rooms=" + rooms + "]";
	}
	
	public JSONObject getJSON() {
		JSONObject jsonObj = new JSONObject();
		try {
			jsonObj.put(PROP_CITY, getCity());
			jsonObj.put(PROP_COUNTRY, getCountry());
			jsonObj.put(PROP_ROOMS,GetRoomsJSON());
			jsonObj.put(PROP_STARS, stars);
			jsonObj.put(PROP_GRADE, grade);
			// TODO what about point?! is it needed?
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return jsonObj;
	}
	
	private JSONArray GetRoomsJSON() {
		JSONArray roomsJS = new JSONArray();
		JSONObject roomObj = null;
		for (Room room : rooms) {
			 roomObj = new JSONObject();
			 try {
				roomObj.put(Room.PROP_TYPE, room.getType());
				roomObj.put(Room.PROP_PRICE, room.getPrice());
				roomObj.put(Room.PROP_DISCOUNTED_PRICE, room.getDiscountedPrice());
			} catch (JSONException e) {
				e.printStackTrace();
			}
			roomsJS.put(roomObj);
		}
		return roomsJS;
	}
}
