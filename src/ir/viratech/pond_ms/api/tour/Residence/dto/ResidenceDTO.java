package ir.viratech.pond_ms.api.tour.Residence.dto;

import com.google.gson.Gson;
import ir.viratech.pond_ms.api.tour.Residence.base.BaseResidenceDTO;
import ir.viratech.pond_ms.api.tour.day.base.BaseStepObjectsDTO;
import ir.viratech.pond_ms.model.tour_relations.base.model.ExtendedPointObject;
import ir.viratech.pond_ms.model.tour_relations.residence.Residence;
import org.json.JSONException;
import org.json.JSONObject;

public class ResidenceDTO extends BaseResidenceDTO{

    public ResidenceDTO map(Residence residence) {
        return modelMapper.map(residence, ResidenceDTO.class);
    }

    public Residence map(ResidenceDTO residenceDTO) {
        return modelMapper.map(residenceDTO, Residence.class);
    }

    /*
    private PointDTO point;
    private List<String> images;
     */

    public ResidenceDTO mymap(ExtendedPointObject residence) {
        ResidenceDTO dto = new ResidenceDTO();
        dto.setObjectType(ObjectType.residence);
        try {
            JSONObject json = new JSONObject(new Gson().toJson(residence));
            if (json.has(Residence.PROP_NAME))
                dto.setName(json.getString(Residence.PROP_NAME));
            if (json.has(Residence.PROP_DESCRIPTION))
                dto.setDescription(json.getString(Residence.PROP_DESCRIPTION));
            if (json.has(Residence.PROP_FEATURES))
                dto.setFeatures(json.getString(Residence.PROP_FEATURES));
            if (json.has(Residence.PROP_RATE))
                dto.setRate(json.getInt(Residence.PROP_RATE));
            if (json.has(Residence.PROP_ADDRESS))
                dto.setAddress(json.getString(Residence.PROP_ADDRESS));
            if (json.has(Residence.PROP_TYPE))
                dto.setType(json.getString(Residence.PROP_TYPE));
            if (json.has(Residence.PROP_DURATION))
                dto.setDuration(json.getString(Residence.PROP_DURATION));
            if (json.has(Residence.PROP_START_TIME))
                dto.setStartTime(json.getString(Residence.PROP_START_TIME));
            if (json.has(Residence.PROP_CITY))
                dto.setCity(json.getString(Residence.PROP_CITY));
            if (json.has(Residence.PROP_COUNTRY))
                dto.setCountry(json.getString(Residence.PROP_COUNTRY));
            if (json.has(Residence.PROP_POINT))
                dto.setPoint(mapJsonToPointDTO(json.getJSONObject(Residence.PROP_POINT)));
            if (json.has(Residence.PROP_IMAGES))
                dto.setImages(mapJsonArrayToList(json.getJSONArray(Residence.PROP_IMAGES)));
        } catch(JSONException e) {
            e.printStackTrace();
        }


        return dto;
    }
}
