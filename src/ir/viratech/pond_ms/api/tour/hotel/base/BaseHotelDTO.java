package ir.viratech.pond_ms.api.tour.hotel.base;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.viratech.pond_ms.api.tour.hotel.dto.RoomDTO;

import java.io.Serializable;
import java.util.List;

public class BaseHotelDTO implements Serializable {

    @JsonProperty
    private String name;
    @JsonProperty
    private String grade;
    @JsonProperty
    private Integer rate;
    @JsonProperty
    private String city;
    @JsonProperty
    private String country;
    @JsonProperty
    private List<RoomDTO> rooms;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<RoomDTO> getRooms() {
        return rooms;
    }

    public void setRooms(List<RoomDTO> rooms) {
        this.rooms = rooms;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BaseHotelDTO that = (BaseHotelDTO) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (grade != null ? !grade.equals(that.grade) : that.grade != null) return false;
        if (rate != null ? !rate.equals(that.rate) : that.rate != null) return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;
        if (country != null ? !country.equals(that.country) : that.country != null) return false;
        return rooms != null ? rooms.equals(that.rooms) : that.rooms == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (grade != null ? grade.hashCode() : 0);
        result = 31 * result + (rate != null ? rate.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (rooms != null ? rooms.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "BaseHotelDTO{" +
                "name='" + name + '\'' +
                ", grade='" + grade + '\'' +
                ", rate=" + rate +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", rooms=" + rooms +
                '}';
    }
}
