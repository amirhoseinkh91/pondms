package ir.viratech.pond_ms.api.tour.sightSeeing.base;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.viratech.pond_ms.api.tour.point.PointDTO;
import ir.viratech.pond_ms.api.tour.day.base.BaseStepObjectsDTO;

import java.util.List;

public class BaseSightSeeingDTO extends BaseStepObjectsDTO {

    @JsonProperty
    private String name;
    @JsonProperty
    private String specialName;
    @JsonProperty
    private PointDTO point;
    @JsonProperty
    private String category;
    @JsonProperty
    private List<String> images;
    @JsonProperty
    private String description;
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

    public String getSpecialName() {
        return specialName;
    }

    public void setSpecialName(String specialName) {
        this.specialName = specialName;
    }

    public PointDTO getPoint() {
        return point;
    }

    public void setPoint(PointDTO point) {
        this.point = point;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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

        BaseSightSeeingDTO that = (BaseSightSeeingDTO) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (specialName != null ? !specialName.equals(that.specialName) : that.specialName != null) return false;
        if (point != null ? !point.equals(that.point) : that.point != null) return false;
        if (category != null ? !category.equals(that.category) : that.category != null) return false;
        if (images != null ? !images.equals(that.images) : that.images != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (duration != null ? !duration.equals(that.duration) : that.duration != null) return false;
        if (startTime != null ? !startTime.equals(that.startTime) : that.startTime != null) return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;
        return country != null ? country.equals(that.country) : that.country == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (specialName != null ? specialName.hashCode() : 0);
        result = 31 * result + (point != null ? point.hashCode() : 0);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (images != null ? images.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (duration != null ? duration.hashCode() : 0);
        result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "BaseSightSeeingDTO{" +
                "name='" + name + '\'' +
                ", specialName='" + specialName + '\'' +
                ", point=" + point +
                ", category='" + category + '\'' +
                ", images=" + images +
                ", description='" + description + '\'' +
                ", duration='" + duration + '\'' +
                ", startTime='" + startTime + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                '}' + ", " + super.toString();
    }
}
