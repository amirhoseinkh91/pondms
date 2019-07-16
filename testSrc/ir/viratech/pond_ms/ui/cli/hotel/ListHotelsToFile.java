package ir.viratech.pond_ms.ui.cli.hotel;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ir.viratech.base.AbstractEntityDAO;
import ir.viratech.commons.cm.model.entity_instance.EntityInstance;
import ir.viratech.commons.cm.model.entity_type.EntityType;
import ir.viratech.commons.cm.model.entity_type.logic.EntityTypeMgr;
import ir.viratech.pond_ms.core.spring.ApplicationContextUtil;
import ir.viratech.pond_ms.model.hotel.dao.HotelDAO;
import ir.viratech.pond_ms.model.map_object.vector.PointObject;
import ir.viratech.pond_ms.model.map_object.vector.logic.PointObjectMgr;
import ir.viratech.pond_ms.ui.cli.main_test.Main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ListHotelsToFile {

    private static List<Hotel> hotels;
    private static File file;
    public static void main(String[] args) {
        ApplicationContextUtil.initializeCliApplicationContext();
        AbstractEntityDAO.touchSession();
        hotels = new ArrayList<>();
        start();
        AbstractEntityDAO.closeCurrentThreadSessions();
    }

    private static void start() {
        System.out.println("==========================");
        System.out.println("starting....");
        file = new File("/home/amir/Desktop/hotelssss.txt");
        if (file.exists())
            file.delete();
        List<PointObject> pointObjects = PointObjectMgr.getInstance().list();
        System.out.println("point objects found: " + pointObjects.size());
        for (PointObject pointObject : pointObjects) {
            if (isHotel(pointObject)) {
                check(pointObject);
            }
        }
        System.out.println("hotels found and added to array: " + hotels.size());
//        writeHotelsToFile();
        System.out.println("finish....");
        System.out.println("==========================");

    }
    private static void check(PointObject pointObject) {
        Set<String> names = new HashSet<>();
        try {
            HotelDAO.getInstance().getByName_iranhotelonline(pointObject.getName());
        } catch (IndexOutOfBoundsException e){
            names.add(pointObject.getName());
        }
        try {
            HotelDAO.getInstance().getByName_pintapin(pointObject.getName());
        } catch (IndexOutOfBoundsException e){
            names.add(pointObject.getName());
        }
        try {
            HotelDAO.getInstance().getByName_hotelYarName(pointObject.getName());
        } catch (IndexOutOfBoundsException e){
            names.add(pointObject.getName());
        }
        try {
            HotelDAO.getInstance().getByName_eghamat24(pointObject.getName());
        } catch (IndexOutOfBoundsException e){
            names.add(pointObject.getName());
        }
        writeToFile(names);
    }

    private static void writeToFile(Set<String> stringSet) {
        try {
            FileWriter writer = new FileWriter(file, true);
            for (String s : stringSet) {
                writer.append(s + "\n");
                writer.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeHotelsToFile() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Writer writer = null;
        try {
            writer = new FileWriter("/home/amir/Desktop/Hotels-Iran.json");
            Response response = new Response(hotels, hotels.size());
            gson.toJson(response, writer);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (writer != null)
                    writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static Hotel convertToHotel(PointObject pointObject) {
        EntityInstance form = pointObject.getFormInstance("full", false);
        if (form != null) {
            Hotel h = new Hotel();
            h.setName(pointObject.getName());
            if (form.has("Rate"))
                h.setStars(form.get("Rate").asInt());
            else
                h.setStars(null);
            h.setLat(pointObject.getPoint().getX());
            h.setLng(pointObject.getPoint().getY());
            return h;
        }
        return null;
    }

    private static boolean isHotel(PointObject pointObject) {
        EntityType hotelEntityType = EntityTypeMgr.getInstance().getByKey("Hotel");
        return pointObject.getFormInstance("full", false).getEntityType().equals(hotelEntityType);
    }

    private static class Response {
        private int itemsCount;
        private List<Hotel> hotels;

        public Response(List<Hotel> hotels, int itemsCount) {
            this.hotels = hotels;
            this.itemsCount = itemsCount;
        }

        public List<Hotel> getHotels() {
            return hotels;
        }

        public void setHotels(List<Hotel> hotels) {
            this.hotels = hotels;
        }

        public int getItemsCount() {
            return itemsCount;
        }

        public void setItemsCount(int itemsCount) {
            this.itemsCount = itemsCount;
        }
    }

    private static class Hotel {
        private String name;
        private Integer stars;
        private Double lat;
        private Double lng;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getStars() {
            return stars;
        }

        public void setStars(Integer stars) {
            this.stars = stars;
        }

        public Double getLat() {
            return lat;
        }

        public void setLat(Double lat) {
            this.lat = lat;
        }

        public Double getLng() {
            return lng;
        }

        public void setLng(Double lng) {
            this.lng = lng;
        }
    }

}
