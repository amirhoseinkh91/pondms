package ir.viratech.just_ro.api.flight.dto.sepehr360;

import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("ALL")
public class Sepehr360MinPriceByFareClassDTO {

    @JsonProperty("Id")
    private String id;
    @JsonProperty("selected")
    private Boolean selected;
    @JsonProperty("Title")
    private String title;
    @JsonProperty("MinPrice")
    private String minPrice;
    @JsonProperty("DisplayTitle")
    private String displayTitle;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(String minPrice) {
        this.minPrice = minPrice;
    }

    public String getDisplayTitle() {
        return displayTitle;
    }

    public void setDisplayTitle(String displayTitle) {
        this.displayTitle = displayTitle;
    }
}
