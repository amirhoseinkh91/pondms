package ir.viratech.just_ro.api.hotel.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by justro on 2/11/18.
 */
public class HotelResponseDTO {

    @JsonProperty("Hotels")
    private List<HotelDTO> hotels;
    @JsonProperty("HotelsCount")
    private Integer hotelsCount;

    public List<HotelDTO> getHotels() {
        return hotels;
    }

    public void setHotels(List<HotelDTO> hotels) {
        this.hotels = hotels;
    }

    public Integer getHotelsCount() {
        return hotelsCount;
    }

    public void setHotelsCount(Integer hotelsCount) {
        this.hotelsCount = hotelsCount;
    }


}
