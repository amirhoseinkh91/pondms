package ir.viratech.pond_ms.api.tour.tour.dto;

import ir.viratech.pond_ms.api.tour.agency.dto.AgencyDTO;
import ir.viratech.pond_ms.api.tour.day.dto.DayObjectDTO;
import ir.viratech.pond_ms.api.tour.hotel.dto.HotelDTO;
import ir.viratech.pond_ms.api.tour.mainInformation.dto.MainTourInformationDTO;
import ir.viratech.pond_ms.api.tour.tour.base.BaseTourMediumDTO;
import ir.viratech.pond_ms.api.tour.tourGuide.dto.TourGuideDTO;
import ir.viratech.pond_ms.model.tour_relations.agency.logic.AgencyManager;
import ir.viratech.pond_ms.model.tour_relations.tour.Tour;

import java.util.ArrayList;
import java.util.List;

public class TourMediumDTO extends BaseTourMediumDTO {

//    private List<DayObjectDTO> dayObjectDTO;

    public static TourMediumDTO convertToMediumDTO(Tour tour) {
        TourMediumDTO mediumDTO = new TourMediumDTO();
        mediumDTO.setRate(tour.getRate());
        mediumDTO.setUid(tour.getUid());
        if (tour.getMainInformation() != null)
            mediumDTO.setMainTourInformationDTO(MainTourInformationDTO.convertToDTO(tour.getMainInformation()));
        if (tour.getTourGuide() != null)
            mediumDTO.setTourGuideDTO(TourGuideDTO.convertToDTO(tour.getTourGuide()));
        if (tour.getAgency_username() != null)
            mediumDTO.setAgencyDTO(AgencyDTO.convertToDTO(AgencyManager.newInstance().getByUsername(tour.getAgency_username())));
        if (tour.getHotels() != null)
            if (tour.getHotels().size() > 0)
                mediumDTO.setHotelsDTO(HotelDTO.convertToDto(tour.getHotels()));
        if (tour.getDays() != null && tour.getDays().size() > 0)
            mediumDTO.setDays(DayObjectDTO.convertToDto(tour.getDays()));
        return mediumDTO;
    }


    public static List<TourMediumDTO> convertToMediumDTO(List<Tour> tours) {
        List<TourMediumDTO> dtos = new ArrayList<>();
        for (Tour tour : tours)
            dtos.add(convertToMediumDTO(tour));
        return dtos;
    }
}
