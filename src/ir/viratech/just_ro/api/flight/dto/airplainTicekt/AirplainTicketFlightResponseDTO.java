package ir.viratech.just_ro.api.flight.dto.airplainTicekt;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings({"SpellCheckingInspection"})
public class AirplainTicketFlightResponseDTO implements Serializable{

    @JsonProperty("FlightInfo")
    private List<AirplainTicketFlightInfoDTO> responseDTOList;

    @JsonProperty("Meta")
    private AirplainTicketMeta airplainTicketMeta;

    public List<AirplainTicketFlightInfoDTO> getResponseDTOList() {
        return responseDTOList;
    }

    public void setResponseDTOList(List<AirplainTicketFlightInfoDTO> responseDTOList) {
        this.responseDTOList = responseDTOList;
    }

    public AirplainTicketMeta getAirplainTicketMeta() {
        return airplainTicketMeta;
    }

    public void setAirplainTicketMeta(AirplainTicketMeta airplainTicketMeta) {
        this.airplainTicketMeta = airplainTicketMeta;
    }
}
