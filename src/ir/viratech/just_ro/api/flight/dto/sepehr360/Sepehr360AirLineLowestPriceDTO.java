package ir.viratech.just_ro.api.flight.dto.sepehr360;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Sepehr360AirLineLowestPriceDTO {

    private String airLineName;
    private String minPrice;
    private Double minPriceDecimal;
    private String id;
    private Boolean isChecked;

    @JsonProperty("AirLineName")
    public String getAirLineName() {
        return airLineName;
    }

    public void setAirLineName(String airLineName) {
        this.airLineName = airLineName;
    }

    @JsonProperty("MinPrice")
    public String getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(String minPrice) {
        this.minPrice = minPrice;
    }

    @JsonProperty("MinPriceDecimal")
    public Double getMinPriceDecimal() {
        return minPriceDecimal;
    }

    public void setMinPriceDecimal(Double minPriceDecimal) {
        this.minPriceDecimal = minPriceDecimal;
    }

    @JsonProperty("Id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("IsChecked")
    public Boolean getChecked() {
        return isChecked;
    }

    public void setChecked(Boolean checked) {
        isChecked = checked;
    }
}
