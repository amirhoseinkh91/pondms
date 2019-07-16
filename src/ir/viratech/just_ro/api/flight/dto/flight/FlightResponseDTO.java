package ir.viratech.just_ro.api.flight.dto.flight;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.viratech.base.SuppressWarningsOption;

import java.util.List;

@SuppressWarnings({SuppressWarningsOption.SPELL_CHECKING_INSPECTION, SuppressWarningsOption.UNUSED})
public class FlightResponseDTO {

    @JsonProperty("ItemsCount")
    private Integer size;

    @JsonProperty("Flights")
    private List<FlightDTO> flights;


    public Integer getItemsCount() {
        return size;
    }

    public void setItemsCount(Integer size) {
        this.size = size;
    }

    public List<FlightDTO> getFlightDTOS() {
        return flights;
    }

    public void setFlightDTOS(List<FlightDTO> flights) {
        this.flights = flights;
        this.setItemsCount(flights.size());
    }
}
