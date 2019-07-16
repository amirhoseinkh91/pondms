package ir.viratech.pond_ms.api.tour.tour.base;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.viratech.pond_ms.api.tour.agency.dto.AgencyDTO;
import ir.viratech.pond_ms.api.tour.day.base.BaseStepObjectsDTO;
import ir.viratech.pond_ms.api.tour.day.dto.DayObjectDTO;
import ir.viratech.pond_ms.api.tour.hotel.dto.HotelDTO;
import ir.viratech.pond_ms.api.tour.mainInformation.dto.MainTourInformationDTO;
import ir.viratech.pond_ms.api.tour.tourGuide.dto.TourGuideDTO;

import java.util.List;
import java.util.Map;

public class BaseTourMediumDTO extends BaseTourDTO {

    @JsonProperty
    private int rate;
    @JsonProperty("mainInformation")
    private MainTourInformationDTO mainTourInformationDTO;
    @JsonProperty("hotels")
    private List<HotelDTO> hotelsDTO;
    @JsonProperty("tourGuide")
    private TourGuideDTO tourGuideDTO;
    @JsonProperty("agency")
    private AgencyDTO agencyDTO;
    @JsonProperty("days")
    private Map<String, List<BaseStepObjectsDTO>> days;

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public MainTourInformationDTO getMainTourInformationDTO() {
        return mainTourInformationDTO;
    }

    public void setMainTourInformationDTO(MainTourInformationDTO mainTourInformationDTO) {
        this.mainTourInformationDTO = mainTourInformationDTO;
    }

    public List<HotelDTO> getHotelsDTO() {
        return hotelsDTO;
    }

    public void setHotelsDTO(List<HotelDTO> hotelsDTO) {
        this.hotelsDTO = hotelsDTO;
    }

    public TourGuideDTO getTourGuideDTO() {
        return tourGuideDTO;
    }

    public void setTourGuideDTO(TourGuideDTO tourGuideDTO) {
        this.tourGuideDTO = tourGuideDTO;
    }

    public AgencyDTO getAgencyDTO() {
        return agencyDTO;
    }

    public void setAgencyDTO(AgencyDTO agencyDTO) {
        this.agencyDTO = agencyDTO;
    }

    public  Map<String, List<BaseStepObjectsDTO>> getDayObjectDTO() {
        return days;
    }

    public void setDays( Map<String, List<BaseStepObjectsDTO>> days) {
        this.days = days;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BaseTourMediumDTO that = (BaseTourMediumDTO) o;

        if (rate != that.rate) return false;
        if (mainTourInformationDTO != null ? !mainTourInformationDTO.equals(that.mainTourInformationDTO) : that.mainTourInformationDTO != null)
            return false;
        if (hotelsDTO != null ? !hotelsDTO.equals(that.hotelsDTO) : that.hotelsDTO != null) return false;
        if (tourGuideDTO != null ? !tourGuideDTO.equals(that.tourGuideDTO) : that.tourGuideDTO != null) return false;
        if (agencyDTO != null ? !agencyDTO.equals(that.agencyDTO) : that.agencyDTO != null) return false;
        return days != null ? days.equals(that.days) : that.days == null;
    }

    @Override
    public int hashCode() {
        int result = rate;
        result = 31 * result + (mainTourInformationDTO != null ? mainTourInformationDTO.hashCode() : 0);
        result = 31 * result + (hotelsDTO != null ? hotelsDTO.hashCode() : 0);
        result = 31 * result + (tourGuideDTO != null ? tourGuideDTO.hashCode() : 0);
        result = 31 * result + (agencyDTO != null ? agencyDTO.hashCode() : 0);
        result = 31 * result + (days != null ? days.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "BaseTourMediumDTO{" +
                "rate=" + rate +
                ", mainTourInformationDTO=" + mainTourInformationDTO +
                ", hotelsDTO=" + hotelsDTO +
                ", tourGuideDTO=" + tourGuideDTO +
                ", agencyDTO=" + agencyDTO +
                ", days=" + days +
                "} " + super.toString();
    }
}
