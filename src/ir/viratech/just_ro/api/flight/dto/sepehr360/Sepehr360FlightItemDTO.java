package ir.viratech.just_ro.api.flight.dto.sepehr360;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.viratech.base.SuppressWarningsOption;

import java.util.List;

@SuppressWarnings({SuppressWarningsOption.UNUSED, SuppressWarningsOption.SPELL_CHECKING_INSPECTION})
public class Sepehr360FlightItemDTO {

    @JsonProperty("FlightInfo")
    private Sepehr360FlightItemInfoDTO flightInfo;

    @JsonProperty("FlightInfoList")
    private List<Sepehr360FlightItemInfoDTO> flightItemInfoList;
    @JsonProperty("FreeSeatCount")
    private Integer freeSeatCount;

    @JsonProperty("FlightItemType")
    private String flightItemType;

    public Sepehr360FlightItemInfoDTO getFlightInfo() {
        return flightInfo;
    }

    public void setFlightInfo(Sepehr360FlightItemInfoDTO flightInfo) {
        this.flightInfo = flightInfo;
    }

    public String getFlightItemType() {
        return flightItemType;
    }

    public void setFlightItemType(String flightItemType) {
        this.flightItemType = flightItemType;
    }

    public List<Sepehr360FlightItemInfoDTO> getFlightItemInfoList() {
        return flightItemInfoList;
    }

    public void setFlightItemInfoList(List<Sepehr360FlightItemInfoDTO> flightItemInfoList) {
        this.flightItemInfoList = flightItemInfoList;
    }

    public Integer getFreeSeatCount() {
        return freeSeatCount;
    }

    public void setFreeSeatCount(Integer freeSeatCount) {
        this.freeSeatCount = freeSeatCount;
    }
}
