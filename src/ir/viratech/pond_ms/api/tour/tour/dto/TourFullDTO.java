package ir.viratech.pond_ms.api.tour.tour.dto;

import ir.viratech.pond_ms.api.tour.agency.dto.AgencyDTO;
import ir.viratech.pond_ms.api.tour.day.dto.DayObjectDTO;
import ir.viratech.pond_ms.api.tour.hotel.dto.HotelDTO;
import ir.viratech.pond_ms.api.tour.mainInformation.dto.MainTourInformationDTO;
import ir.viratech.pond_ms.api.tour.tour.base.BaseTourFullDTO;
import ir.viratech.pond_ms.api.tour.tourGuide.dto.TourGuideDTO;
import ir.viratech.pond_ms.model.tour_relations.agency.logic.AgencyManager;
import ir.viratech.pond_ms.model.tour_relations.tour.Tour;

import java.util.ArrayList;
import java.util.List;

public class TourFullDTO extends BaseTourFullDTO {

    public TourFullDTO convertToFullDTO(Tour tour) {
        TourFullDTO fullDTO = new TourFullDTO();
        fullDTO.setEnabled(tour.isEnabled());
        fullDTO.setUid(tour.getUid());
        fullDTO.set_isDeleted(tour.isDeleted());
        fullDTO.setRate(tour.getRate());
        fullDTO.setIntrinsicValue(tour.getIntrinsicValue());
        fullDTO.setTemporalValue(tour.getTemporalValue());
        fullDTO.setTotalScore(tour.getTotalScore());
        if (tour.getMainInformation() != null)
            fullDTO.setMainTourInformationDTO(MainTourInformationDTO.convertToDTO(tour.getMainInformation()));
        if (tour.getTourGuide() != null)
            fullDTO.setTourGuideDTO(TourGuideDTO.convertToDTO(tour.getTourGuide()));
        if (tour.getAgencyUid() != null)
            fullDTO.setAgencyDTO(AgencyDTO.convertToDTO(AgencyManager.newInstance().getByUsername(tour.getAgency_username())));
        if (tour.getHotels() != null)
            if (tour.getHotels().size() > 0)
                fullDTO.setHotelsDTO(HotelDTO.convertToDto(tour.getHotels()));
        if (tour.getDays() != null && tour.getDays().size() > 0)
            fullDTO.setDays(DayObjectDTO.convertToDto(tour.getDays()));
        return fullDTO;
    }

    public List<TourFullDTO> convertToFullDTO(List<Tour> tours) {
        List<TourFullDTO> dtos = new ArrayList<>();
        for (Tour tour : tours) {
            dtos.add(convertToFullDTO(tour));
        }
        return dtos;
    }
}
