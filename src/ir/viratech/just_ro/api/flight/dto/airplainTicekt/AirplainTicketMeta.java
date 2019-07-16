package ir.viratech.just_ro.api.flight.dto.airplainTicekt;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by justro on 2/6/18.
 */
@SuppressWarnings({"SpellCheckingInspection"})
public class AirplainTicketMeta {

    @JsonProperty("MinPrice")
    private String minPrice;
    @JsonProperty("MaxPrice")
    private String maxPrice;
    @JsonProperty("containIndirect")
    private Boolean containIndirect;
    @JsonProperty("MaxPriceNoFilter")
    private String maxPriceNoFilter;
    @JsonProperty("MinPriceNoFilter")
    private String minPriceNoFilter;
    @JsonProperty("Count")
    private Integer count;
    @JsonProperty("Airlines")
    private List<String> airLines;
    @JsonProperty("AirlinesInfo")
    private List<AirplaneTicketAirLineInfo> airlinesInfo;

    public String getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(String minPrice) {
        this.minPrice = minPrice;
    }

    public String getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(String maxPrice) {
        this.maxPrice = maxPrice;
    }

    public Boolean getContainIndirect() {
        return containIndirect;
    }

    public void setContainIndirect(Boolean containIndirect) {
        this.containIndirect = containIndirect;
    }

    public String getMaxPriceNoFilter() {
        return maxPriceNoFilter;
    }

    public void setMaxPriceNoFilter(String maxPriceNoFilter) {
        this.maxPriceNoFilter = maxPriceNoFilter;
    }

    public String getMinPriceNoFilter() {
        return minPriceNoFilter;
    }

    public void setMinPriceNoFilter(String minPriceNoFilter) {
        this.minPriceNoFilter = minPriceNoFilter;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<String> getAirLines() {
        return airLines;
    }

    public void setAirLines(List<String> airLines) {
        this.airLines = airLines;
    }

    public List<AirplaneTicketAirLineInfo> getAirlinesInfo() {
        return airlinesInfo;
    }

    public void setAirlinesInfo(List<AirplaneTicketAirLineInfo> airlinesInfo) {
        this.airlinesInfo = airlinesInfo;
    }
}
