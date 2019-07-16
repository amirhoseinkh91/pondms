package ir.viratech.just_ro.api.flight.dto.alibaba;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@SuppressWarnings({"unused", "SpellCheckingInspection"})
public class AlibabaResponseDTO {

    private List<AlibabaFlightDTO> availableFlights;
    private Integer faranegarAvailableCount;
    private Integer show;


    @JsonProperty("SearchFlightId")
    private String searchFlightId;

    public String getSearchFlightId() {
        return searchFlightId;
    }

    public void setSearchFlightId(String searchFlightId) {
        this.searchFlightId = searchFlightId;
    }


    @JsonProperty("AvailableFlights")
    public List<AlibabaFlightDTO> getAvailableFlights() {
        return availableFlights;
    }

    public void setAvailableFlights(List<AlibabaFlightDTO> availableFlights) {
        this.availableFlights = availableFlights;
    }

    @JsonProperty("FaranegarAvailableCount")
    public Integer getFaranegarAvailableCount() {
        return faranegarAvailableCount;
    }

    public void setFaranegarAvailableCount(Integer faranegarAvailableCount) {
        this.faranegarAvailableCount = faranegarAvailableCount;
    }

    @JsonProperty("Show")
    public Integer getShow() {
        return show;
    }

    public void setShow(Integer show) {
        this.show = show;
    }
}
