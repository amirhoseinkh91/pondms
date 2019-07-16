package ir.viratech.pond_ms.api.tour.mainInformation.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.viratech.pond_ms.api.tour.mainInformation.base.BaseMainTourInformationDTO;
import ir.viratech.pond_ms.model.tour_relations.tour.MainTourInformation;

import java.util.List;

public class MainTourInformationDTO extends BaseMainTourInformationDTO {

    @Override
    public String toString() {
        return "MainTourInformationDTO{} " + super.toString();
    }

    public MainTourInformation map (MainTourInformationDTO dto) {
        return modelMapper.map(dto, MainTourInformation.class);
    }

    public MainTourInformationDTO map (MainTourInformation mainTourInformation) {
        return modelMapper.map(mainTourInformation, MainTourInformationDTO.class);
    }

    public static MainTourInformationDTO convertToDTO(MainTourInformation mainTourInformation) {
        MainTourInformationDTO dto = new MainTourInformationDTO();
        try {
            dto.setDiscountedPrice(mainTourInformation.getDiscountedPrice());
        } catch (NullPointerException e) {
        }
        try {
            dto.setServices(mainTourInformation.getServices());
        } catch (NullPointerException e) {
        }
        try {
            dto.setSignupRules(mainTourInformation.getSignupRules());
        } catch (NullPointerException e) {
        }
        try {
            dto.setIranian(mainTourInformation.isIranian());
        } catch (NullPointerException e) {
        }
        try {
            dto.setName(mainTourInformation.getName());
        } catch (NullPointerException e) {
        }
        try {
            dto.setType(mainTourInformation.getType());
        } catch (NullPointerException e) {
        }
        try {
            dto.setDuration(mainTourInformation.getDuration());
        } catch (NullPointerException e) {
        }
        try {
            dto.setDate(mainTourInformation.getDate());
        } catch (NullPointerException e) {
        }
        try {
            dto.setPrice(mainTourInformation.getPrice());
        } catch (NullPointerException e) {
        }
        try {
            dto.setDstCountries(mainTourInformation.getDstCountries());
        } catch (NullPointerException e) {
        }
        try {
            dto.setDstCities(mainTourInformation.getDstCities());
        } catch (NullPointerException e) {
        }
        try {
            dto.setSrcCity(mainTourInformation.getSrcCity());
        } catch (NullPointerException e) {
        }
        try {
            dto.setImages(mainTourInformation.getImages());
        } catch (NullPointerException e) {
        }
        try {
            dto.setDescription(mainTourInformation.getDescription());
        } catch (NullPointerException e) {
        }
        try {
            dto.setRecommendedTools(mainTourInformation.getRecommendedTools());
        } catch (NullPointerException e) {
        }
        try {
            dto.setRequiredTools(mainTourInformation.getRequiredTools());
        } catch (NullPointerException e) {
        }
        return dto;
    }

    public static MainTourInformation convertToEntity(MainTourInformationDTO informationDTO) {
        MainTourInformation mainTourInformation = new MainTourInformation();
        mainTourInformation.setIranian(informationDTO.isIranian());
        if (informationDTO.getName() != null)
            mainTourInformation.setName(informationDTO.getName());
        if (informationDTO.getType()!= null)
            mainTourInformation.setType(informationDTO.getType());
        if (informationDTO.getDuration() != null)
            mainTourInformation.setDuration(informationDTO.getDuration());
        if (informationDTO.getDate() != null)
            mainTourInformation.setDate(informationDTO.getDate());
        if (informationDTO.getPrice() != null)
            mainTourInformation.setPrice(informationDTO.getPrice());
        if (informationDTO.getDiscountedPrice() != null)
            mainTourInformation.setDiscountedPrice(informationDTO.getDiscountedPrice());
        if (informationDTO.getServices() != null)
            mainTourInformation.setServices(informationDTO.getServices());
        if (informationDTO.getSignupRules() != null)
            mainTourInformation.setSignupRules(informationDTO.getSignupRules());
        if (informationDTO.getRequiredTools() != null)
            mainTourInformation.setRequiredTools(informationDTO.getRequiredTools());
        if (informationDTO.getRecommendedTools() != null)
            mainTourInformation.setRecommendedTools(informationDTO.getRecommendedTools());
        if (informationDTO.getDescription() != null)
            mainTourInformation.setDescription(informationDTO.getDescription());
        if (informationDTO.getImages() != null && informationDTO.getImages().size() > 0)
            mainTourInformation.setImages(informationDTO.getImages());
        if (informationDTO.getSrcCity() != null)
            mainTourInformation.setSrcCity(informationDTO.getSrcCity());
        if (informationDTO.getDstCities() != null && informationDTO.getDstCities().size() > 0)
            mainTourInformation.setDstCities(informationDTO.getDstCities());
        if (informationDTO.getDstCountries() != null && informationDTO.getDstCountries().size() > 0)
            mainTourInformation.setDstCountries(informationDTO.getDstCountries());
        return mainTourInformation;
    }


}
