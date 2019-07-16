package ir.viratech.pond_ms.api.tour.Residence.base;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.viratech.pond_ms.api.tour.point.PointDTO;
import ir.viratech.pond_ms.api.tour.day.base.BaseStepObjectsDTO;

import java.util.List;

public class BaseResidenceDTO extends BaseStepObjectsDTO {

    @JsonProperty
    private String name;
    @JsonProperty
    private PointDTO point;
    @JsonProperty
    private List<String> images;
    @JsonProperty
    private String description;
    @JsonProperty
    private String features;
    @JsonProperty("Rate")
    private int rate;
    @JsonProperty
    private String address;
    @JsonProperty
    private String type;
    @JsonProperty
    private String duration;
    @JsonProperty
    private String startTime;
    @JsonProperty
    private String city;
    @JsonProperty
    private String country;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PointDTO getPoint() {
        return point;
    }

    public void setPoint(PointDTO point) {
        this.point = point;
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

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BaseResidenceDTO that = (BaseResidenceDTO) o;

        if (rate != that.rate) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (point != null ? !point.equals(that.point) : that.point != null) return false;
        if (images != null ? !images.equals(that.images) : that.images != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (features != null ? !features.equals(that.features) : that.features != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (duration != null ? !duration.equals(that.duration) : that.duration != null) return false;
        if (startTime != null ? !startTime.equals(that.startTime) : that.startTime != null) return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;
        return country != null ? country.equals(that.country) : that.country == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (point != null ? point.hashCode() : 0);
        result = 31 * result + (images != null ? images.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (features != null ? features.hashCode() : 0);
        result = 31 * result + rate;
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (duration != null ? duration.hashCode() : 0);
        result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "BaseResidenceDTO{" +
                "name='" + name + '\'' +
                ", point=" + point +
                ", images=" + images +
                ", description='" + description + '\'' +
                ", features='" + features + '\'' +
                ", rate=" + rate +
                ", address='" + address + '\'' +
                ", type='" + type + '\'' +
                ", duration='" + duration + '\'' +
                ", startTime='" + startTime + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                '}' + ", " + super.toString();
    }
}
