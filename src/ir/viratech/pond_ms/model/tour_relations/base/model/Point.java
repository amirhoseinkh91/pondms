package ir.viratech.pond_ms.model.tour_relations.base.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Point implements Serializable {

    private String type = "Point" ;
    private List<Double> coordinates;

    public Point() {
        coordinates = new ArrayList<>(2);
    }

    public Point(Double x, Double y) {
        coordinates = new ArrayList<>(2);
        coordinates.add(0,x);
        coordinates.add(1,y);
    }


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

    public Double getX() {
        return coordinates.get(0);
    }

    public Double getY() {
        return coordinates.get(1);
    }

    public void setX(Double x) {
        coordinates.add(0,x);
    }

    public void setY(Double y) {
        coordinates.add(1 , y);
    }

    public void setPoint(Double x , Double y) {
        setX(x);
        setY(y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Point point = (Point) o;

        if (type != null ? !type.equals(point.type) : point.type != null) return false;
        return coordinates != null ? coordinates.equals(point.coordinates) : point.coordinates == null;
    }

    @Override
    public int hashCode() {
        int result = type != null ? type.hashCode() : 0;
        result = 31 * result + (coordinates != null ? coordinates.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Point{" +
                "type='" + type + '\'' +
                ", coordinates=" + coordinates +
                '}';
    }
}
