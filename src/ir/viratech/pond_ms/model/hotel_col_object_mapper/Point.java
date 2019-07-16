package ir.viratech.pond_ms.model.hotel_col_object_mapper;

import java.util.List;

public class Point{
    private String type;
    List<Double> coordinates;


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Double> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(List<Double> coordinates) {
        this.coordinates = coordinates;
    }
}
