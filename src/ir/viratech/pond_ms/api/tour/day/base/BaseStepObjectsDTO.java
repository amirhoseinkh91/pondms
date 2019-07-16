package ir.viratech.pond_ms.api.tour.day.base;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ir.viratech.pond_ms.api.tour.Residence.dto.ResidenceDTO;
import ir.viratech.pond_ms.api.tour.meal.dto.MealDTO;
import ir.viratech.pond_ms.api.tour.move.dto.ArrivalDepartureDTO;
import ir.viratech.pond_ms.api.tour.point.PointDTO;
import ir.viratech.pond_ms.api.tour.sightSeeing.dto.SightSeeingDTO;
import ir.viratech.pond_ms.api.tour.transfer.dto.TransferDTO;
import ir.viratech.pond_ms.model.tour_relations.base.model.ExtendedPointObject;
import ir.viratech.pond_ms.model.tour_relations.depart_arrival.DepartArrival;
import ir.viratech.pond_ms.model.tour_relations.meal.Meal;
import ir.viratech.pond_ms.model.tour_relations.residence.Residence;
import ir.viratech.pond_ms.model.tour_relations.sight_seeing.SightSeeing;
import ir.viratech.pond_ms.model.tour_relations.transfer.Transfer;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.modelmapper.ModelMapper;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BaseStepObjectsDTO implements Serializable {

    protected ObjectMapper objectMapper;

    protected ModelMapper modelMapper;
    public BaseStepObjectsDTO() {
        modelMapper = new ModelMapper();
        objectMapper = new ObjectMapper();
    }

    public Object convertJsonToDTO (JSONObject inputJsonObject , Class outputClazz) throws IOException {
        return objectMapper.readValue(inputJsonObject.toString() , outputClazz);
    }

    public BaseStepObjectsDTO map(ExtendedPointObject extendedPointObject) {
        String type = extendedPointObject.getObjectType();
                switch (type) {
                    case "meal" :
                        return new MealDTO().mymap(extendedPointObject);
                    case "residence":
                        return new ResidenceDTO().mymap(extendedPointObject);
                    case "transfer":
                        return new TransferDTO().mymap(extendedPointObject);
                    case "sightSeeing":
                        return new SightSeeingDTO().mymap(extendedPointObject);
                    case "arrival":
                        return new ArrivalDepartureDTO().mymap(extendedPointObject);
                    case "departure" :
                        return new ArrivalDepartureDTO().mymap(extendedPointObject);
                    default:
                        break;
                }
        return modelMapper.map(extendedPointObject, BaseStepObjectsDTO.class);
    }

    public ExtendedPointObject map(BaseStepObjectsDTO stepObjectsDTO) {
        return modelMapper.map(stepObjectsDTO, ExtendedPointObject.class);
    }

    public BaseStepObjectsDTO convertToDTO(ExtendedPointObject extendedPointObject) {
        try {
            String jsonString = objectMapper.writeValueAsString(extendedPointObject);
            return (BaseStepObjectsDTO) convertJsonToDTO(new JSONObject(jsonString), BaseStepObjectsDTO.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public enum ObjectType {
        meal , arrival , departure, residence, sightSeeing, transfer
    }

    @JsonProperty
    private ObjectType objectType;

    public ObjectType getObjectType() {
        return objectType;
    }

    public void setObjectType(ObjectType objectType) {
        this.objectType = objectType;
    }

    public Object map (Object inputObject , Class outputClazz) {
        return modelMapper.map(inputObject, outputClazz);
    }

    @Override
    public String toString() {
        return "BaseStepObjectsDTO{" +
                "objectType=" + objectType +
                '}';
    }

    protected List<String> mapJsonArrayToList (JSONArray jsonArray) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i <jsonArray.length(); i++) {
            try {
                list.add(jsonArray.getString(i));
            } catch (JSONException e) {
                e.printStackTrace();
                continue;
            }
        }
        return list;
    }
    protected PointDTO mapJsonToPointDTO(JSONObject pointJsonObject) {
        PointDTO pointDTO = new PointDTO();
        pointDTO.setType("Point");
        try {
            Double x = pointJsonObject.getJSONArray("coordinates").getDouble(0);
            Double y = pointJsonObject.getJSONArray("coordinates").getDouble(1);
            pointDTO.setCoordinates(x,y);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return pointDTO;
    }

}
