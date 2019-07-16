package ir.viratech.just_ro.api.flight.dto.sepehr360;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.viratech.base.SuppressWarningsOption;

@SuppressWarnings(SuppressWarningsOption.ALL)
public class Sepehr360MinPriceByDayDTO {

    @JsonProperty("Id")
    private String id;
    @JsonProperty("Selected")
    private Boolean selected;
    @JsonProperty("DayDate")
    private String dayDate;
    @JsonProperty("DayName")
    private String dayName;
    @JsonProperty("DayMinPrice")
    private String dayMinPrice;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getSelected() {
        return selected;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }

    public String getDayDate() {
        return dayDate;
    }

    public void setDayDate(String dayDate) {
        this.dayDate = dayDate;
    }

    public String getDayName() {
        return dayName;
    }

    public void setDayName(String dayName) {
        this.dayName = dayName;
    }

    public String getDayMinPrice() {
        return dayMinPrice;
    }

    public void setDayMinPrice(String dayMinPrice) {
        this.dayMinPrice = dayMinPrice;
    }
}
