package ir.viratech.pond_ms.ui.cli.pointTester;

import ir.viratech.commons.persistence.base.BaseAbstractEntityDAO;
import ir.viratech.just_ro.model.Website;
import ir.viratech.pond_ms.core.spring.ApplicationContextUtil;
import ir.viratech.pond_ms.model.map_object.vector.PointObject;
import ir.viratech.pond_ms.model.map_object.vector.logic.PointObjectMgr;
import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by amir on 8/27/17.
 */
public class PointsAccuracyChecker {

    private static final double MIN_DISTANCE = 1000.0;
    private static final double MAX_DISTANCE = 100000.0;

    private double lat;
    private double lng;
    private String foundName;

    private double storedX;
    private double storedY;

    private double distance;

    private int counter;
    private int keysCounter = 0;
    private List<String> keys;

    public static void main(String[] args) {
        ApplicationContextUtil.initializeCliApplicationContext();
        BaseAbstractEntityDAO.touchSession();

        new PointsAccuracyChecker().start(PointObjectMgr.getInstance().list());

        BaseAbstractEntityDAO.closeCurrentThreadSessions();
    }

    public void start(List<PointObject> pointObjects) {
       this.counter = 1;
       fillKeysList();
        for (PointObject p : pointObjects) {
            if(p.getLayer().getFormSchemaKey().equals("Hotel") || p.getLayer().getFormSchemaKey().equals("Things_To_Do")) {
                String name = p.getName();
                if (!(name.contains("جاده") || name.contains("جنگل") || name.contains("دریاچه") || name.contains("کویر") || name.contains("صحرا"))) {
                    System.out.println("Object #" + (++counter) + "\t" + name);
                    try {
                        boolean isValid = checkValidation(p);
                        if (!isValid) {
                            writeToUpdatbleFile(p);
                        } else {
                            writeToNoProblemFile(p);
                        }

                    } catch (IndexOutOfBoundsException e) {
                        System.err.println(e.getMessage());
                        writeToNotFoundFile(p);
                        continue;
                    } catch (Exception e) {
                        System.err.println(e.getClass().getSimpleName());
                        continue;
                    }
                }
            }
        }
    }

    private void writeToNoProblemFile(PointObject p) {
        try {
            String filePath = ApplicationContextUtil.getProperty("noProblemPointsFile");
            FileWriter writer = new FileWriter(new File(filePath), true);
            writer.append(p.getName() + " --- " + p.getCityFromLayer() + "\n");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeToNotFoundFile(PointObject p) {
        try {
            String filePath = ApplicationContextUtil.getProperty("notFoundPointsFile");
            FileWriter writer = new FileWriter(new File(filePath), true);
            writer.append(p.getName() + " --- " + p.getCityFromLayer() + "\n");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeToUpdatbleFile(PointObject p) {
        try {
            String filePath = ApplicationContextUtil.getProperty("updatblePointsFile");
            FileWriter writer = new FileWriter(new File(filePath), true);
            writer.append("-----------------------------------------" + "\n");
            writer.append(p.getName() + " " + p.getCityFromLayer() + " --------- " + foundName + "\n");
            writer.append("stored lat: " + storedX + " stored lng: " + storedY + " newLat: " + lat + " newLng: " + lng + " dist: " + distance +  "\n" );
            writer.append("-----------------------------------------" + "\n");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean checkValidation(PointObject p) throws IndexOutOfBoundsException,IOException, JSONException {
        storedX = p.getPoint().getX();
        storedY = p.getPoint().getY();
        if (p.getLayer().getFormSchemaKey().equals("Hotel"))
            search(p.getName());
        else
            search(p.getName() + " " + p.getCityFromLayer());
        return checkValidation();
    }

    private boolean checkValidation() {
        double distance = distance();
        if (distance > MIN_DISTANCE && distance < MAX_DISTANCE)
            return false;
        else
            return true;
    }

    private void fillKeysList() {
        keys = new ArrayList<>();
        keys.add("AIzaSyCMu_BL4xXGjgfhGuHDqZBaAMRfc4xZZzo");
        keys.add("AIzaSyAMWceoa3czTfVOcV1bjAs9F6Y_iGbEvrM");
        keys.add("AIzaSyB3aj05lw_XrCOfEbes8qvqRjDGlHNNfME");
        keys.add("AIzaSyBv8X9F3O0gNxYUHhQ_a2u9DRS7PLbDUH8");
    }

    private void search(String name) throws IndexOutOfBoundsException, IOException, JSONException {
        String key;
        key = keys.get(keysCounter);
        if (counter % 2000 == 0)
            keysCounter++;
        String baseUrl = "https://maps.googleapis.com/maps/api/geocode/json?key=" + key + "&address=";
        String url = baseUrl + name;
        Connection.Response res = Jsoup.connect(url).userAgent(Website.userAgent).method(Connection.Method.GET).ignoreContentType(true).execute();
        if (new JSONObject(res.body().toString()).getJSONArray("results").length() > 0) {
            JSONObject baseJsonObj = new JSONObject(res.body().toString()).getJSONArray("results").getJSONObject(0);
            JSONObject locationObj = baseJsonObj.getJSONObject("geometry").getJSONObject("location");
            foundName = baseJsonObj.getJSONArray("address_components").getJSONObject(0).getString("short_name");
            lng = locationObj.getDouble("lat");
            lat = locationObj.getDouble("lng");
        } else {
            throw new IndexOutOfBoundsException("ZERO_RESULTS");
        }
    }

    /**
     * Calculate distance between two points in latitude and longitude taking
     * into account height difference. If you are not interested in height
     * difference pass 0.0. Uses Haversine method as its base.
     * <p>
     * lat1, lon1 Start point lat2, lon2 End point
     *
     * @returns Distance in Meters
     */
    public double distance() {

        final int R = 6371; // Radius of the earth

        double latDistance = Math.toRadians(lat - storedX);
        double lonDistance = Math.toRadians(lng - storedY);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat)) * Math.cos(Math.toRadians(storedX))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        distance = R * c * 1000; // convert to meters
        return R * c * 1000; // convert to meters;
    }

}
