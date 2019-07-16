package ir.viratech.pond_ms.api.tour.tourGuide.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.viratech.pond_ms.api.tour.tourGuide.base.BaseTourGuideDTO;
import ir.viratech.pond_ms.model.tour_relations.guide.Guide;

public class TourGuideDTO extends BaseTourGuideDTO {

    public TourGuideDTO map(Guide tourGuide) {
        return modelMapper.map(tourGuide, TourGuideDTO.class);
    }

    public Guide map(TourGuideDTO tourGuideDTO) {
        return modelMapper.map(tourGuideDTO, Guide.class);
    }

    public static Guide convertToEntity (TourGuideDTO guideDTO) {
        Guide tourGuide = new Guide();
        if (guideDTO.getName() != null)
            tourGuide.setName(guideDTO.getName());
        if (guideDTO.getPhoneNumber() != null)
            tourGuide.setPhoneNumber(guideDTO.getPhoneNumber());
        if (guideDTO.getImage() != null)
            tourGuide.setImage(guideDTO.getImage());
        return tourGuide;
    }

    public static TourGuideDTO convertToDTO(Guide tourGuide) {
        TourGuideDTO dto = new TourGuideDTO();
        try {
            dto.setName(tourGuide.getName());
        } catch (NullPointerException e){
        }
        try {
            dto.setPhoneNumber(tourGuide.getPhoneNumber());
        } catch (NullPointerException e){
        }
        try {
            dto.setImage(tourGuide.getImage());
        } catch (NullPointerException e){
        }
        return dto;
    }

}
