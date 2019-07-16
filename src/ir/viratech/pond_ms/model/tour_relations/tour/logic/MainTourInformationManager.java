package ir.viratech.pond_ms.model.tour_relations.tour.logic;

import ir.viratech.pond_ms.model.tour_relations.base.logic.BaseManager;
import ir.viratech.pond_ms.model.tour_relations.tour.MainTourInformation;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainTourInformationManager extends BaseManager {

    public MainTourInformationManager() {
        super();
    }

    public static MainTourInformation getInstance() throws InstantiationException, IllegalAccessException {
        return MainTourInformation.class.newInstance();
    }

    public static MainTourInformationManager newInstance() {
        try {
            return MainTourInformationManager.class.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            return null;
        }
    }

    public MainTourInformation parse(JSONObject jsonObject) {
        MainTourInformation mainInfo = null;
        try {
            mainInfo = getInstance();
            mainInfo.setName(jsonObject.getString(MainTourInformation.PROP_NAME));
            try {
                mainInfo.setIranian(jsonObject.getBoolean(MainTourInformation.PROP_IS_IRANIAN));
            } catch (NullPointerException | JSONException e) {
                mainInfo.setIranian(true);
            }
            try {
                mainInfo.setType(jsonObject.getString(MainTourInformation.PROP_TYPE).replaceAll("\"" , "").trim());
            } catch (NullPointerException | JSONException e) {

            }
            try {
                mainInfo.setType(jsonObject.getString(MainTourInformation.PROP_TYPE).replaceAll("\"" , "").trim());
            } catch (NullPointerException | JSONException e) {

            }
            try {
                mainInfo.setDuration(jsonObject.getString(MainTourInformation.PROP_DURATION).replaceAll("\"" , "").trim());
            } catch (NullPointerException | JSONException e) {

            }
            try {
                mainInfo.setDate(jsonObject.getString(MainTourInformation.PROP_DATE).replaceAll("\"" , "").trim());
            } catch (NullPointerException | JSONException e) {

            }
            try {
                mainInfo.setPrice(jsonObject.getLong(MainTourInformation.PROP_PRICE));
            } catch (NullPointerException | JSONException e) {
                mainInfo.setPrice(0);
            }
            try {
                mainInfo.setDiscountedPrice(jsonObject.getLong(MainTourInformation.PROP_DISCOUNTED_PRICE));
            } catch (NullPointerException | JSONException e) {
                mainInfo.setDiscountedPrice(0);
            }
            try {
                mainInfo.setServices(jsonObject.getString(MainTourInformation.PROP_SERVICES).replaceAll("\"" , "").trim());
            } catch (NullPointerException | JSONException e) {

            }
            try {
                mainInfo.setSignupRules(jsonObject.getString(MainTourInformation.PROP_SIGNUP_RULES).replaceAll("\"" , "").trim());
            } catch (NullPointerException | JSONException e) {

            }
            try {
                mainInfo.setRequiredTools(jsonObject.getString(MainTourInformation.PROP_REQUIRED_TOOLS).replaceAll("\"" , "").trim());
            } catch (NullPointerException | JSONException e) {

            }
            try {
                mainInfo.setRecommendedTools(jsonObject.getString(MainTourInformation.PROP_RECOMENDED_TOOLS).replaceAll("\"" , "").trim());
            } catch (NullPointerException | JSONException e) {

            }
            try {
                mainInfo.setDescription(jsonObject.getString(MainTourInformation.PROP_DESCRIPTION).replaceAll("\"" , "").trim());
            } catch (NullPointerException | JSONException e) {

            }
            try {
                mainInfo.setSrcCity(jsonObject.getString(MainTourInformation.PROP_SRC_CITY).replaceAll("\"" , "").trim());
            } catch (NullPointerException | JSONException e) {

            }
            try {
                mainInfo.setDstCities(mapJSONArrayToList(jsonObject.getJSONArray(MainTourInformation.PROP_DST_CITIES)));
            } catch (NullPointerException | JSONException e) {

            }
            try {
                mainInfo.setDstCountries(mapJSONArrayToList(jsonObject.getJSONArray(MainTourInformation.PROP_DST_COUNTRIES)));
            } catch (NullPointerException | JSONException e) {

            }
        } catch (InstantiationException | IllegalAccessException | JSONException e) {
            e.printStackTrace();
        }
        return mainInfo;
    }

    private List<String> mapJSONArrayToList(JSONArray jsonArray) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            try {
                list.add(jsonArray.getString(i).replaceAll("\"" , "").trim());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return list;
    }
}
