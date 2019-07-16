package ir.viratech.pond_ms.api.tour.move.base;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.viratech.pond_ms.api.tour.point.PointDTO;
import ir.viratech.pond_ms.api.tour.day.base.BaseStepObjectsDTO;

public class BaseArrivalDepartureDTO extends BaseStepObjectsDTO {

    @JsonProperty
    private String name;
    @JsonProperty
    private String city;
    @JsonProperty
    private String address;
    @JsonProperty
    private PointDTO point;
    @JsonProperty
    private String time;
    @JsonProperty
    private String description;
    @JsonProperty
    private String vehicle;
    @JsonProperty
    private String duration;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public PointDTO getPoint() {
        return point;
    }

    public void setPoint(PointDTO point) {
        this.point = point;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BaseArrivalDepartureDTO that = (BaseArrivalDepartureDTO) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (point != null ? !point.equals(that.point) : that.point != null) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (vehicle != null ? !vehicle.equals(that.vehicle) : that.vehicle != null) return false;
        return duration != null ? duration.equals(that.duration) : that.duration == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (point != null ? point.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (vehicle != null ? vehicle.hashCode() : 0);
        result = 31 * result + (duration != null ? duration.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "BaseArrivalDepartureDTO{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", address='" + address + '\'' +
                ", point=" + point +
                ", time='" + time + '\'' +
                ", description='" + description + '\'' +
                ", vehicle='" + vehicle + '\'' +
                ", duration='" + duration + '\'' +
                '}' + ", " + super.toString();
    }
}
