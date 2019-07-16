package ir.viratech.just_ro.api.hotel.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.viratech.base.SuppressWarningsOption;
import ir.viratech.just_ro.api.hotel.dto.HotelDTO;

import java.util.List;

/**
 * Created by justro on 2/11/18.
 */
@SuppressWarnings({SuppressWarningsOption.SPELL_CHECKING_INSPECTION, SuppressWarningsOption.UNUSED})
public class HotelConfigDTO {

    @JsonProperty("Hotels")
    List<HotelDTO> hotels;
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
