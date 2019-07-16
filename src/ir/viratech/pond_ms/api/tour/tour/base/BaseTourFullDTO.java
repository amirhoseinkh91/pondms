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

public class BaseTourFullDTO extends BaseTourDTO {

    public static final String PROP_NAME = "name";
    public static final String PROP_IS_DELETED = "_isDeleted";
    public static final String PROP_IS_ENABLED = "isEnabled";
    public static final String PROP_RATE = "Rate";
    public static final String PROP_INTRNSIC_VALUE = "IntrinsicValue";
    public static final String PROP_TOTAL_SCORE = "TotalScore";
    public static final String PROP_TEMPORAL_VALUE = "TemporalValue";

    public static final String PROP_MAIN_INFO_COMPONENT = "mainInformation";
    public static final String PROP_HOTELS_COMPONENT = "hotels";
    public static final String PROP_TOUR_GUIDE_COMPONENT = "tourGuide";
    public static final String PROP_AGENCY_COMPONENT = "agency";
    public static final String PROP_DAYS_COMPONENT = "days";

    @JsonProperty
    private Boolean isEnabled;
    @JsonProperty
    private Boolean _isDeleted;
    @JsonProperty
    private int rate;
    @JsonProperty
    private int intrinsicValue;
    @JsonProperty
    private int temporalValue;
    @JsonProperty
    private int totalScore;
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

    public Boolean getEnabled() {
        return isEnabled;
    }

    public void setEnabled(Boolean enabled) {
        isEnabled = enabled;
    }

    public Boolean get_isDeleted() {
        return _isDeleted;
    }

    public void set_isDeleted(Boolean _isDeleted) {
        this._isDeleted = _isDeleted;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public int getIntrinsicValue() {
        return intrinsicValue;
    }

    public void setIntrinsicValue(int intrinsicValue) {
        this.intrinsicValue = intrinsicValue;
    }

    public int getTemporalValue() {
        return temporalValue;
    }

    public void setTemporalValue(int temporalValue) {
        this.temporalValue = temporalValue;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
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

    public Map<String, List<BaseStepObjectsDTO>> getDays() {
        return days;
    }

    public void setDays(Map<String, List<BaseStepObjectsDTO>> days) {
        this.days = days;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BaseTourFullDTO that = (BaseTourFullDTO) o;

        if (rate != that.rate) return false;
        if (intrinsicValue != that.intrinsicValue) return false;
        if (temporalValue != that.temporalValue) return false;
        if (totalScore != that.totalScore) return false;
        if (isEnabled != null ? !isEnabled.equals(that.isEnabled) : that.isEnabled != null) return false;
        if (_isDeleted != null ? !_isDeleted.equals(that._isDeleted) : that._isDeleted != null) return false;
        if (mainTourInformationDTO != null ? !mainTourInformationDTO.equals(that.mainTourInformationDTO) : that.mainTourInformationDTO != null)
            return false;
        if (hotelsDTO != null ? !hotelsDTO.equals(that.hotelsDTO) : that.hotelsDTO != null) return false;
        if (tourGuideDTO != null ? !tourGuideDTO.equals(that.tourGuideDTO) : that.tourGuideDTO != null) return false;
        if (agencyDTO != null ? !agencyDTO.equals(that.agencyDTO) : that.agencyDTO != null) return false;
        return days != null ? days.equals(that.days) : that.days == null;
    }

    @Override
    public int hashCode() {
        int result = isEnabled != null ? isEnabled.hashCode() : 0;
        result = 31 * result + (_isDeleted != null ? _isDeleted.hashCode() : 0);
        result = 31 * result + rate;
        result = 31 * result + intrinsicValue;
        result = 31 * result + temporalValue;
        result = 31 * result + totalScore;
        result = 31 * result + (mainTourInformationDTO != null ? mainTourInformationDTO.hashCode() : 0);
        result = 31 * result + (hotelsDTO != null ? hotelsDTO.hashCode() : 0);
        result = 31 * result + (tourGuideDTO != null ? tourGuideDTO.hashCode() : 0);
        result = 31 * result + (agencyDTO != null ? agencyDTO.hashCode() : 0);
        result = 31 * result + (days != null ? days.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "BaseTourFullDTO{" +
                "isEnabled=" + isEnabled +
                ", _isDeleted=" + _isDeleted +
                ", rate=" + rate +
                ", intrinsicValue=" + intrinsicValue +
                ", temporalValue=" + temporalValue +
                ", totalScore=" + totalScore +
                ", mainTourInformationDTO=" + mainTourInformationDTO +
                ", hotelsDTO=" + hotelsDTO +
                ", tourGuideDTO=" + tourGuideDTO +
                ", agencyDTO=" + agencyDTO +
                ", days=" + days +
                "} " + super.toString();
    }
}


