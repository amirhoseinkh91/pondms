package ir.viratech.pond_ms.api.tour.point;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.viratech.pond_ms.model.tour_relations.base.model.Point;

import java.util.ArrayList;
import java.util.List;

public class PointDTO {

    @JsonProperty
    private String type;
    @JsonProperty
    private List<Double> coordinates;

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

    public void setCoordinates(Double x , Double y) {
        coordinates = new ArrayList<>();
        this.coordinates.add(0,x);
        this.coordinates.add(1,y);
    }

    public Double getX() {
        return coordinates.get(0);
    }

    public Double getY() {
        return coordinates.get(1);
    }

    @Override
    public String toString() {
        return "PointDTO{" +
                " coordinates=" + coordinates +
                '}';
    }

    public Point convertToEntity(PointDTO dto) {
        Point p = new Point();
        p.setX(getX());
        p.setY(getY());
        return p;
    }

    public PointDTO convertToDto(Point point) {
        PointDTO dto = new PointDTO();
        try {
            dto.setCoordinates(point.getX(), point.getY());
        } catch (NullPointerException e) {
        }
        return dto;
    }
}
