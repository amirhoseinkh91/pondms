package ir.viratech.pond_ms.model.hotel_col_object_mapper;

import java.util.ArrayList;
import java.util.List;

public class HotelColPojo {


    private String hotelName;
    private List<String> images;
    private String description;
    private String __type;
    private String features;
    private String address;
    private String gisObject;
    private Point point;
    private double rate;
    private double lowestPrice;
    private ArrayList<LowestPrices> lowestPrices;

    public String getHotelName() {
        return hotelName;
    }

    public String get__type() {
        return __type;
    }

    public void set__type(String __type) {
        this.__type = __type;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGisObject() {
        return gisObject;
    }

    public void setGisObject(String gisObject) {
        this.gisObject = gisObject;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getLowestPrice() {
        return lowestPrice;
    }

    public void setLowestPrice(double lowestPrice) {
        this.lowestPrice = lowestPrice;
    }

    public ArrayList<LowestPrices> getLowestPrices() {
        return lowestPrices;
    }

    public void setLowestPrices(ArrayList<LowestPrices> lowestPrices) {
        this.lowestPrices = lowestPrices;
    }
}

