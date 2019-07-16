package ir.viratech.pond_ms.api.tour.tour.dto;

import ir.viratech.pond_ms.api.tour.tour.base.BaseTourLightDTO;
import ir.viratech.pond_ms.model.tour_relations.tour.Tour;

import java.util.ArrayList;
import java.util.List;

public class TourLightDTO extends BaseTourLightDTO {


    public static TourLightDTO convertToLightDTO(Tour tour) {
        TourLightDTO lightDTO = new TourLightDTO();
        System.out.println(tour);
        lightDTO.setUid(tour.getUid());
        lightDTO.setName(tour.getMainInformation().getName());
        return lightDTO;
    }

    public static List<TourLightDTO> convertToLightDTO(List<Tour> tours) {
        List<TourLightDTO> lightDTOS = new ArrayList<>();
        for (Tour t : tours)
            lightDTOS.add(convertToLightDTO(t));
        return lightDTOS;
    }
}
