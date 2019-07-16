package ir.viratech.just_ro.api.flight.dto.mrbilit;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.viratech.base.SuppressWarningsOption;

import java.util.List;

@SuppressWarnings({SuppressWarningsOption.SPELL_CHECKING_INSPECTION , SuppressWarningsOption.UNUSED})
public class MrBilitMetaDTO {

    @JsonProperty("MinPrice")
    private Integer minPrice;
    @JsonProperty("MaxPrice")
    private Integer maxPrice;
    @JsonProperty("containIndirect")
    private Boolean containIndirect;
    @JsonProperty("MaxPriceNoFilter")
    private Integer maxPriceNoFilter;
    @JsonProperty("MinPriceNoFilter")
    private Integer minPriceNoFilter;
    @JsonProperty("Count")
    private Integer count;
    @JsonProperty("Airlines")
    private List<String> airlines;
    @JsonProperty("AirlinesInfo")
    private List<MrBilitAirLineInfo> airlinesInfo;

    public Integer getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(Integer minPrice) {
        this.minPrice = minPrice;
    }

    public Integer getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(Integer maxPrice) {
        this.maxPrice = maxPrice;
    }

    public Boolean getContainIndirect() {
        return containIndirect;
    }

    public void setContainIndirect(Boolean containIndirect) {
        this.containIndirect = containIndirect;
    }

    public Integer getMaxPriceNoFilter() {
        return maxPriceNoFilter;
    }

    public void setMaxPriceNoFilter(Integer maxPriceNoFilter) {
        this.maxPriceNoFilter = maxPriceNoFilter;
    }

    public Integer getMinPriceNoFilter() {
        return minPriceNoFilter;
    }

    public void setMinPriceNoFilter(Integer minPriceNoFilter) {
        this.minPriceNoFilter = minPriceNoFilter;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<String> getAirlines() {
        return airlines;
    }

    public void setAirlines(List<String> airlines) {
        this.airlines = airlines;
    }

    public List<MrBilitAirLineInfo> getAirlinesInfo() {
        return airlinesInfo;
    }

    public void setAirlinesInfo(List<MrBilitAirLineInfo> airlinesInfo) {
        this.airlinesInfo = airlinesInfo;
    }
}
