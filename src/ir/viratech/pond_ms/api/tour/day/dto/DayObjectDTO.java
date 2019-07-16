package ir.viratech.pond_ms.api.tour.day.dto;

import ir.viratech.pond_ms.api.tour.Residence.dto.ResidenceDTO;
import ir.viratech.pond_ms.api.tour.day.base.BaseDayObjectDTO;
import ir.viratech.pond_ms.api.tour.day.base.BaseStepObjectsDTO;
import ir.viratech.pond_ms.api.tour.meal.dto.MealDTO;
import ir.viratech.pond_ms.api.tour.move.dto.ArrivalDepartureDTO;
import ir.viratech.pond_ms.api.tour.sightSeeing.dto.SightSeeingDTO;
import ir.viratech.pond_ms.api.tour.transfer.dto.TransferDTO;
import ir.viratech.pond_ms.model.tour_relations.base.model.ExtendedPointObject;
import ir.viratech.pond_ms.model.tour_relations.depart_arrival.DepartArrival;
import ir.viratech.pond_ms.model.tour_relations.meal.Meal;
import ir.viratech.pond_ms.model.tour_relations.residence.Residence;
import ir.viratech.pond_ms.model.tour_relations.sight_seeing.SightSeeing;
import ir.viratech.pond_ms.model.tour_relations.tour.DayTourObject;
import ir.viratech.pond_ms.model.tour_relations.transfer.Transfer;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DayObjectDTO extends BaseDayObjectDTO {


    public List<BaseStepObjectsDTO> convert(JSONObject dayObjectJson) throws JSONException {
        List<BaseStepObjectsDTO> dayObjectDTOList = new ArrayList<>();
        for (int i = 0; i < dayObjectJson.getJSONArray("dayObjects").length(); i++) {
            JSONObject tempJson = dayObjectJson.getJSONArray("dayObjects").getJSONObject(i);
            String type = tempJson.getString(ExtendedPointObject.PROP_OBJECT_TYPE);
            System.out.println("here: " + type);
            switch (type) {
                case "meal":
                    try {
                        dayObjectDTOList.add(i, (MealDTO) new MealDTO().convertJsonToDTO(tempJson , MealDTO.class));
                        System.out.println((MealDTO) new MealDTO().convertJsonToDTO(tempJson , MealDTO.class));
                    } catch (IOException e) {
                        continue;
                    }
                    break;
                case "residence":
                    try {
                        dayObjectDTOList.add(i, (ResidenceDTO) new ResidenceDTO().convertJsonToDTO(tempJson , ResidenceDTO.class));
                        System.out.println((ResidenceDTO) new ResidenceDTO().convertJsonToDTO(tempJson , ResidenceDTO.class));
                    } catch (IOException e) {
                        continue;
                    }
                    break;
                case "transfer":
                    try {
                        dayObjectDTOList.add(i, (TransferDTO) new TransferDTO().convertJsonToDTO(tempJson , TransferDTO.class));
                        System.out.println((TransferDTO) new TransferDTO().convertJsonToDTO(tempJson , TransferDTO.class));
                    } catch (IOException e) {
                        continue;
                    }
                    break;
                case "sightSeeing":
                    try {
                        dayObjectDTOList.add(i, (SightSeeingDTO) new SightSeeingDTO().convertJsonToDTO(tempJson , SightSeeingDTO.class));
                        System.out.println((SightSeeingDTO) new SightSeeingDTO().convertJsonToDTO(tempJson , SightSeeingDTO.class));
                    } catch (IOException e) {
                        continue;
                    }
                    break;
                case "arrival":
                    try {
                        dayObjectDTOList.add(i, (ArrivalDepartureDTO) new ArrivalDepartureDTO().convertJsonToDTO(tempJson , ArrivalDepartureDTO.class));
                        System.out.println((ArrivalDepartureDTO) new ArrivalDepartureDTO().convertJsonToDTO(tempJson , ArrivalDepartureDTO.class));
                    } catch (IOException e) {
                        continue;
                    }
                    break;
                case "departure":
                    try {
                        dayObjectDTOList.add(i, (ArrivalDepartureDTO) new ArrivalDepartureDTO().convertJsonToDTO(tempJson , ArrivalDepartureDTO.class));
                        System.out.println((ArrivalDepartureDTO) new ArrivalDepartureDTO().convertJsonToDTO(tempJson , ArrivalDepartureDTO.class));
                    } catch (IOException e) {
                        continue;
                    }
                    break;
                default:
                    continue;
            }
        }
        return dayObjectDTOList;
    }

    @Override
    public String toString() {
        return "DayObjectDTO{} " + super.toString();
    }

    public static DayObjectDTO convertToDto (DayTourObject dayTourObject) {
        DayObjectDTO dto = new DayObjectDTO();
        List<BaseStepObjectsDTO> stepObjectsDTOS = new ArrayList<>();
        try {
            for (ExtendedPointObject extendedPointObj : dayTourObject.getObjects()) {
                try {
                    stepObjectsDTOS.add(new BaseStepObjectsDTO().map(extendedPointObj));
                } catch (NullPointerException e) {
                    continue;
                }
            }
        } catch (NullPointerException e){
            return null;
        }
        dto.setDayObjects(stepObjectsDTOS);
        return dto;
    }
/*
    public static List<DayObjectDTO> convertToDto(List<DayTourObject> days) {
        List<DayObjectDTO> dtos = new ArrayList<>();
            for (int i = 0; i < days.size(); i++) {
                if (days.get(i) != null)
                    dtos.add(i,convertToDto(days.get(i)));
                else
                    dtos.add(i,null);
            }
        return dtos;
    }*/

    public static List<BaseStepObjectsDTO> convertToDto(List<ExtendedPointObject> extendedPointObjects) {
        List<BaseStepObjectsDTO> dtos = new ArrayList<>();
        for (int i = 0; i < extendedPointObjects.size(); i++)
            dtos.add(i,new BaseStepObjectsDTO().map(extendedPointObjects.get(i)));
        return dtos;
    }

    public static Map<String, List<BaseStepObjectsDTO>> convertToDto(Map<String , List<ExtendedPointObject>> days) {
        Map<String, List<BaseStepObjectsDTO>> result = new HashMap<>();
        List<BaseStepObjectsDTO> value = new ArrayList<>();
        for (String key : days.keySet()) {
            value  = convertToDto(days.get(key));
            result.put(key , value);
        }
        return result;
    }
}
