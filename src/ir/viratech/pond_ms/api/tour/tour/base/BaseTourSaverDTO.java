package ir.viratech.pond_ms.api.tour.tour.base;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import ir.viratech.pond_ms.api.tour.hotel.dto.HotelDTO;
import ir.viratech.pond_ms.api.tour.mainInformation.base.BaseMainTourInformationDTO;
import ir.viratech.pond_ms.api.tour.mainInformation.dto.MainTourInformationDTO;
import ir.viratech.pond_ms.api.tour.tourGuide.dto.TourGuideDTO;
import ir.viratech.pond_ms.model.tour_relations.guide.Guide;
import ir.viratech.pond_ms.model.tour_relations.hotel.Hotel;
import org.modelmapper.ModelMapper;

import java.io.Serializable;
import java.util.List;

public class BaseTourSaverDTO implements Serializable {

    protected ModelMapper modelMapper;

    public BaseTourSaverDTO () {
        modelMapper = new ModelMapper();
    }

    public Object map(Object sourceObject, Class outputClass) {
        return modelMapper.map(sourceObject, outputClass);
    }

    @JsonProperty
    private MainTourInformationDTO mainInformation;
    @JsonProperty
    private List<HotelDTO> hotels;
    @JsonProperty
    private TourGuideDTO tourGuide;

    public MainTourInformationDTO getMainInformation() {
        return mainInformation;
    }

    public void setMainInformation(MainTourInformationDTO mainInformation) {
        this.mainInformation = mainInformation;
    }

    public List<HotelDTO> getHotels() {
        return hotels;
    }

    public void setHotels(List<HotelDTO> hotels) {
        this.hotels = hotels;
    }

    public TourGuideDTO getTourGuide() {
        return tourGuide;
    }

    public void setTourGuide(TourGuideDTO tourGuide) {
        this.tourGuide = tourGuide;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BaseTourSaverDTO that = (BaseTourSaverDTO) o;

        if (mainInformation != null ? !mainInformation.equals(that.mainInformation) : that.mainInformation != null)
            return false;
        if (hotels != null ? !hotels.equals(that.hotels) : that.hotels != null) return false;
        return tourGuide != null ? tourGuide.equals(that.tourGuide) : that.tourGuide == null;
    }

    @Override
    public int hashCode() {
        int result = mainInformation != null ? mainInformation.hashCode() : 0;
        result = 31 * result + (hotels != null ? hotels.hashCode() : 0);
        result = 31 * result + (tourGuide != null ? tourGuide.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "BaseTourSaverDTO{" +
                "mainInformation=" + mainInformation +
                ", hotels=" + hotels +
                ", tourGuide=" + tourGuide +
                '}';
    }
}
