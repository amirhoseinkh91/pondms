package ir.viratech.pond_ms.model.tour_relations.tour.logic;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.json.JSONException;
import org.json.JSONObject;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.gson.Gson;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;

import ir.viratech.commons.persistence.mongo.base.MongoDBManager;
import ir.viratech.pond_ms.api.filter.BaseMongoQueries;
import ir.viratech.pond_ms.core.spring.ApplicationContextUtil;
import ir.viratech.pond_ms.model.tour_relations.agency.logic.AgencyManager;
import ir.viratech.pond_ms.model.tour_relations.base.logic.BaseManager;
import ir.viratech.pond_ms.model.tour_relations.tour.CustomerInput;
import ir.viratech.pond_ms.model.tour_relations.tour.MainTourInformation;
import ir.viratech.pond_ms.model.tour_relations.tour.Tour;
import ir.viratech.pond_ms.model.tour_relations.tour.dao.TourDAO;
import ir.viratech.pond_ms.model.user.User;
import ir.viratech.pond_ms.model.user.role.UserRole;

public class TourManager extends BaseManager {

	// TODO implement methods to add, update, remove, get and listAll
	@Deprecated
	public void add(Tour tour) {

	}

	public JsonNode getAll(CustomerInput input, String start, String len) {
		return this.getDAO().getAll(input, start, len);
	}

	public String add(JSONObject t) {
		DBCollection collection = MongoDBManager.getInstance().getCollection(BaseMongoQueries.TOUR_COLLECTION);
		User user = ApplicationContextUtil.getCurrentExecutionContext().getUser();
		String uid = null;

		try {
			uid = getUid();
			t.put(Tour.PROP_UID, uid);
			t.put(Tour.PROP_IS_DELETED, false);
			t.put(Tour.PROP_IS_ENABLED, false);
			t.put(Tour.PROP_RATE, 0);
			t.put(Tour.PROP_INTRNSIC_VALUE, 0);
			t.put(Tour.PROP_TOTAL_SCORE, 0);
			t.put(Tour.PROP_TEMPORAL_VALUE, 0);
			t.put(Tour.PROP_AGENCY_USERNAME, user.getUsername());
			t.put(Tour.PROP_TYPE_KEY, Tour.PROP_TYPE_VALUE);
			t.put(Tour.PROP_AGENCY_COMPONENT, AgencyManager.class.newInstance().getAgencyJson(user.getUsername()));

			DBObject dbObject = (DBObject) JSON.parse(t.toString());
			collection.insert(dbObject);
		} catch (InstantiationException | IllegalAccessException | JSONException e) {
			e.printStackTrace();
		}
		return uid;
	}

	public JsonNode getAll(String start, String len, String extent) {
		try {
			return this.getDAO().getAll(start, len, extent);
		} catch (InstantiationException | IllegalAccessException | IOException e) {
			return null;
		}
	}

	protected TourDAO getDAO() {
		try {
			return TourDAO.class.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			return null;
		}
	}

	public static TourManager getInstance() {
		try {
			return TourManager.class.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			return  null;
		}
	}

	public void deleteByUid(String uid) {
		this.getDAO().deleteByUid(uid);
	}

	public void deleteDayByUid(String uid, String day) {
		this.getDAO().deleteDayByUid(uid, day);
	}

	public JsonNode getByUid(String uid) {
//		return this.getDAO().getByUid(uid);
		return null;
	}

	private String componentMapper(String input) {
		return null;
	}

	private Tour parse(JSONObject json) {
		Gson gson = new Gson();
		return (Tour) gson.fromJson(json.toString(), Tour.class);
	}

	@Deprecated
	public void testUpdate(String uid, JSONObject t, String day) {
		DBCollection collection = MongoDBManager.getInstance().getCollection(BaseMongoQueries.TOUR_COLLECTION);
		User user = ApplicationContextUtil.getCurrentExecutionContext().getUser();
		boolean isAgency = false;
		for (UserRole role : user.getRoles()) {
			if (role.getName().equals("AGENCY_ROLE"))
				isAgency = true;
		}
		try {
			if (isAgency) {
				JSONObject jsonObject = this.getDAO().getByUid_asJSONObject(uid);
				t.put(Tour.PROP_IS_ENABLED, jsonObject.getBoolean(Tour.PROP_IS_ENABLED));
				t.put(Tour.PROP_IS_DELETED, jsonObject.getBoolean(Tour.PROP_IS_ENABLED));
				t.put(Tour.PROP_AGENCY_USERNAME, jsonObject.getString(Tour.PROP_AGENCY_USERNAME));
				t.put(Tour.PROP_INTRNSIC_VALUE, jsonObject.getInt(Tour.PROP_INTRNSIC_VALUE));
				t.put(Tour.PROP_TOTAL_SCORE, jsonObject.getInt(Tour.PROP_TOTAL_SCORE));
				t.put(Tour.PROP_RATE, jsonObject.getInt(Tour.PROP_RATE));
				t.put(Tour.PROP_TEMPORAL_VALUE, jsonObject.getInt(Tour.PROP_TEMPORAL_VALUE));
			}
//			this.getDAO().removeByUid(uid);
			t.put(Tour.PROP_UID, uid);
			t.put(Tour.PROP_TYPE_KEY, Tour.PROP_TYPE_VALUE);
			DBObject dbObject = (DBObject) JSON.parse(t.toString());
			collection.insert(dbObject);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	public void update(String uid, JSONObject newJson, String q) {
		DBCollection collection = MongoDBManager.getInstance().getCollection(BaseMongoQueries.TOUR_COLLECTION);
		User user = ApplicationContextUtil.getCurrentExecutionContext().getUser();
		JSONObject prevJson = this.getDAO().getByUid_asJSONObject(uid);
		boolean isAgency = false;
		boolean isSysadmin = false;
		for (UserRole role : user.getRoles()) {
			if (role.getName().equals("AGENCY_ROLE"))
				isAgency = true;
			if (role.getName().equals("sysadmin"))
				isSysadmin = true;
		}
		try {
			if (isAgency) {
				newJson.put(Tour.PROP_IS_ENABLED, false);
				updateOperation(newJson, prevJson, uid, q);
			} else if (isSysadmin) {
				updateOperation(newJson, prevJson, uid, q);
			}
//			this.getDAO().removeByUid(uid);
			newJson.put(Tour.PROP_UID, uid);
			newJson.put(Tour.PROP_TYPE_KEY, Tour.PROP_TYPE_VALUE);
			DBObject dbObject = (DBObject) JSON.parse(newJson.toString());
			collection.insert(dbObject);
		} catch ( JSONException e) {
			e.printStackTrace();
		}
	}

	private void updateOperation(JSONObject newJson, JSONObject prevJson, String uid, String q) throws JSONException {

		newJson.put(Tour.PROP_IS_DELETED, prevJson.getBoolean(Tour.PROP_IS_DELETED));
		newJson.put(Tour.PROP_AGENCY_USERNAME, prevJson.getString(Tour.PROP_AGENCY_USERNAME));
		newJson.put(Tour.PROP_INTRNSIC_VALUE, prevJson.getInt(Tour.PROP_INTRNSIC_VALUE));
		newJson.put(Tour.PROP_TOTAL_SCORE, prevJson.getInt(Tour.PROP_TOTAL_SCORE));
		newJson.put(Tour.PROP_RATE, prevJson.getInt(Tour.PROP_RATE));
		newJson.put(Tour.PROP_TEMPORAL_VALUE, prevJson.getInt(Tour.PROP_TEMPORAL_VALUE));
		newJson.put(Tour.PROP_AGENCY_COMPONENT , prevJson.getJSONObject(Tour.PROP_AGENCY_COMPONENT));
		if (prevJson.has(Tour.PROP_TOUR_GUIDE_COMPONENT))
			newJson.put(Tour.PROP_TOUR_GUIDE_COMPONENT,
					prevJson.getJSONObject(Tour.PROP_TOUR_GUIDE_COMPONENT));
		else if (newJson.has(Tour.PROP_TOUR_GUIDE_COMPONENT)) {
			prevJson.put(Tour.PROP_TOUR_GUIDE_COMPONENT , newJson.getJSONObject(Tour.PROP_TOUR_GUIDE_COMPONENT));
		}
		Iterator keys = prevJson.keys();
		while (true) {
			String key = keys.next().toString();

			if (q != null) {
				if (prevJson.has(Tour.PROP_MAIN_INFO_COMPONENT))
					newJson.put(Tour.PROP_MAIN_INFO_COMPONENT,
							prevJson.getJSONObject(Tour.PROP_MAIN_INFO_COMPONENT));
				if (prevJson.has(Tour.PROP_AGENCY_COMPONENT))
					newJson.put(Tour.PROP_AGENCY_COMPONENT, prevJson.getJSONObject(Tour.PROP_AGENCY_COMPONENT));
				if (prevJson.has(Tour.PROP_HOTELS_COMPONENT))
					newJson.put(Tour.PROP_HOTELS_COMPONENT, prevJson.getJSONArray(Tour.PROP_HOTELS_COMPONENT));
				if (key.substring(0, 3).equals("day"))
					if (!key.equals(q))
						newJson.put(key, prevJson.getJSONArray(key));
			} else {
				if (newJson.has(Tour.PROP_MAIN_INFO_COMPONENT)) {
					int prevDays = Integer.parseInt(prevJson.getJSONObject(Tour.PROP_MAIN_INFO_COMPONENT).getString(MainTourInformation.PROP_DURATION));

					int newDays = Integer.parseInt(newJson.getJSONObject(Tour.PROP_MAIN_INFO_COMPONENT)
							.getString(MainTourInformation.PROP_DURATION));
					if (newDays < prevDays)
						for (int i = prevDays; i > newDays; i--)
							deleteDayByUid(newJson, "day" + i);
					if (prevJson.has(Tour.PROP_AGENCY_COMPONENT))
						newJson.put(Tour.PROP_AGENCY_COMPONENT, prevJson.getJSONObject(Tour.PROP_AGENCY_COMPONENT));
					if (prevJson.has(Tour.PROP_HOTELS_COMPONENT))
						newJson.put(Tour.PROP_HOTELS_COMPONENT, prevJson.getJSONArray(Tour.PROP_HOTELS_COMPONENT));
				} else {
					newJson.put(Tour.PROP_MAIN_INFO_COMPONENT, prevJson.getJSONObject(Tour.PROP_MAIN_INFO_COMPONENT));
					if (prevJson.has(Tour.PROP_AGENCY_COMPONENT))
						newJson.put(Tour.PROP_AGENCY_COMPONENT, prevJson.getJSONObject(Tour.PROP_AGENCY_COMPONENT));
					if (prevJson.has(Tour.PROP_HOTELS_COMPONENT))
						newJson.put(Tour.PROP_HOTELS_COMPONENT, prevJson.getJSONArray(Tour.PROP_HOTELS_COMPONENT));
				}

				if (key.substring(0, 3).equals("day"))
					newJson.put(key, prevJson.getJSONArray(key));

			}

			if (!keys.hasNext())
				break;
		}
	}

	private JSONObject deleteDayByUid(JSONObject newJson, String day) {
		newJson.remove(day);
		return  newJson;
	}

    public Set<String> getSrcCities() {
        return this.getDAO().getSrcCities();
	}

    public Set<String> getDstCities(String srcCity) {
        return this.getDAO().getDstCities(srcCity);
	}

	/*public void addDayToTour(String tourUid, Integer day, DayTourObject dayTourObject) {
		this.getDAO().addDayToTour(tourUid, day, dayTourObject);
	}*/
}
