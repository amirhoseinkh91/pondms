package ir.viratech.pond_ms.api.tour.move.dto;

import com.google.gson.Gson;
import ir.viratech.pond_ms.api.tour.day.base.BaseStepObjectsDTO;
import ir.viratech.pond_ms.api.tour.move.base.BaseArrivalDepartureDTO;
import ir.viratech.pond_ms.model.tour_relations.base.model.ExtendedPointObject;
import ir.viratech.pond_ms.model.tour_relations.depart_arrival.DepartArrival;
import org.json.JSONException;
import org.json.JSONObject;
import org.modelmapper.ModelMapper;

public class ArrivalDepartureDTO extends BaseArrivalDepartureDTO {

    public DepartArrival map (ArrivalDepartureDTO arrivalDepartureDTO) {
        return modelMapper.map(arrivalDepartureDTO, DepartArrival.class);
    }

    public ArrivalDepartureDTO map (DepartArrival departArrival) {
        return modelMapper.map(departArrival, ArrivalDepartureDTO.class);
    }

    public DepartArrival convertToEntity(ArrivalDepartureDTO dto) {
        DepartArrival departArrival = new DepartArrival();
        departArrival.setObjectType(dto.getObjectType().toString());
        departArrival.setName(dto.getName());
        departArrival.setCity(dto.getCity());
        departArrival.setAddress(dto.getAddress());
        return departArrival;
    }

    public ArrivalDepartureDTO mymap(ExtendedPointObject arrivalDeparture) {
        ArrivalDepartureDTO dto = new ArrivalDepartureDTO();
        try {
            JSONObject json = new JSONObject(new Gson().toJson(arrivalDeparture));
            if (json.has(DepartArrival.PROP_OBJECT_TYPE)) {
                if (json.getString(DepartArrival.PROP_OBJECT_TYPE).equalsIgnoreCase(ObjectType.arrival.toString()))
                    dto.setObjectType(ObjectType.arrival);
                if (json.getString(DepartArrival.PROP_OBJECT_TYPE).equalsIgnoreCase(ObjectType.departure.toString()))
                    dto.setObjectType(ObjectType.departure);
            }
            if (json.has(DepartArrival.PROP_NAME))
                dto.setName(json.getString(DepartArrival.PROP_NAME));
            if (json.has(DepartArrival.PROP_CITY))
                dto.setCity(json.getString(DepartArrival.PROP_CITY));
            if (json.has(DepartArrival.PROP_ADDRESS))
                dto.setAddress(json.getString(DepartArrival.PROP_ADDRESS));
            if (json.has(DepartArrival.PROP_POINT))
                dto.setPoint(mapJsonToPointDTO(json.getJSONObject(DepartArrival.PROP_POINT)));
            if (json.has(DepartArrival.PROP_TIME))
                dto.setTime(json.getString(DepartArrival.PROP_TIME));
            if (json.has(DepartArrival.PROP_DESCRIPTION))
                dto.setDescription(json.getString(DepartArrival.PROP_DESCRIPTION));
            if (json.has(DepartArrival.PROP_VEHICLE))
                dto.setVehicle(json.getString(DepartArrival.PROP_VEHICLE));
            if (json.has(DepartArrival.PROP_DURATION))
                dto.setDuration(json.getString(DepartArrival.PROP_DURATION));

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return dto;
    }
}
