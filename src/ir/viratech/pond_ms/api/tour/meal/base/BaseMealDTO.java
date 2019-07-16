package ir.viratech.pond_ms.api.tour.meal.base;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.viratech.pond_ms.api.tour.point.PointDTO;
import ir.viratech.pond_ms.api.tour.day.base.BaseStepObjectsDTO;

import java.util.ArrayList;
import java.util.List;

public class BaseMealDTO extends BaseStepObjectsDTO {

    public static final String PROP_NAME = "name";
    public static final String PROP_IMAGES = "images";
    public static final String PROP_POINT = "point";
    public static final String PROP_START_TIME = "startTime";
    public static final String PROP_MEAL_NAME = "mealName";
    public static final String PROP_DESCRIPTION = "description";
    public static final String PROP_DURATION = "duration";
    public static final String PROP_CITY = "city";
    public static final String PROP_COUNTRY = "country";


    public List<String> getProps() {
        List<String> props = new ArrayList<>();
        props.add(PROP_NAME);
        props.add(PROP_IMAGES);
        props.add(PROP_POINT);
        props.add(PROP_START_TIME);
        props.add(PROP_MEAL_NAME);
        props.add(PROP_DESCRIPTION);
        props.add(PROP_DURATION);
        props.add(PROP_CITY);
        props.add(PROP_COUNTRY);
        return props;
    }

    @JsonProperty
    private String name;
    @JsonProperty
    private List<String> images;
    @JsonProperty
    private PointDTO point;
    @JsonProperty
    private String startTime;
    @JsonProperty
    private String mealName;
    @JsonProperty
    private String description;
    @JsonProperty
    private String duration;
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

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public PointDTO getPoint() {
        return point;
    }

    public void setPoint(PointDTO point) {
        this.point = point;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
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

        BaseMealDTO that = (BaseMealDTO) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (images != null ? !images.equals(that.images) : that.images != null) return false;
        if (point != null ? !point.equals(that.point) : that.point != null) return false;
        if (startTime != null ? !startTime.equals(that.startTime) : that.startTime != null) return false;
        if (mealName != null ? !mealName.equals(that.mealName) : that.mealName != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (duration != null ? !duration.equals(that.duration) : that.duration != null) return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;
        return country != null ? country.equals(that.country) : that.country == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (images != null ? images.hashCode() : 0);
        result = 31 * result + (point != null ? point.hashCode() : 0);
        result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
        result = 31 * result + (mealName != null ? mealName.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (duration != null ? duration.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "BaseMealDTO{" +
                "name='" + name + '\'' +
                ", images=" + images +
                ", point=" + point +
                ", startTime='" + startTime + '\'' +
                ", mealName='" + mealName + '\'' +
                ", description='" + description + '\'' +
                ", duration='" + duration + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                '}' + ", " + super.toString();
    }
}
