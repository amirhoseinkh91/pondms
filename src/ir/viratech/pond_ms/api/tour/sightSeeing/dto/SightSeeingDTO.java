package ir.viratech.pond_ms.api.tour.sightSeeing.dto;

import com.google.gson.Gson;
import ir.viratech.pond_ms.api.tour.day.base.BaseStepObjectsDTO;
import ir.viratech.pond_ms.api.tour.sightSeeing.base.BaseSightSeeingDTO;
import ir.viratech.pond_ms.model.tour_relations.base.model.ExtendedPointObject;
import ir.viratech.pond_ms.model.tour_relations.sight_seeing.SightSeeing;
import org.json.JSONException;
import org.json.JSONObject;

public class SightSeeingDTO extends BaseSightSeeingDTO {

    public SightSeeingDTO map(SightSeeing sightSeeing) {
        return modelMapper.map(sightSeeing, SightSeeingDTO.class);
    }

    public SightSeeing map(SightSeeingDTO sightSeeingDTO) {
        return modelMapper.map(sightSeeingDTO, SightSeeing.class);
    }

    public SightSeeingDTO mymap(ExtendedPointObject sightSeeing) {
        SightSeeingDTO dto = new SightSeeingDTO();
        System.out.println("========================================");
        System.out.println("========================================");
        System.out.println("========================================");
        System.out.println(sightSeeing);
        System.out.println("========================================");
        System.out.println("========================================");
        System.out.println("========================================");
        dto.setObjectType(ObjectType.sightSeeing);
        try {
            JSONObject json = new JSONObject(new Gson().toJson(sightSeeing));
            if (json.has(SightSeeing.PROP_NAME))
                dto.setName(json.getString(SightSeeing.PROP_NAME));
            if (json.has(SightSeeing.PROP_SPECIAL_NAME))
                dto.setSpecialName(json.getString(SightSeeing.PROP_SPECIAL_NAME));
            if (json.has(SightSeeing.PROP_POINT))
                dto.setPoint(mapJsonToPointDTO(json.getJSONObject(SightSeeing.PROP_POINT)));
            if (json.has(SightSeeing.PROP_CATEGORY))
                dto.setCategory(json.getString(SightSeeing.PROP_CATEGORY));
            if (json.has(SightSeeing.PROP_IMAGES))
                dto.setImages(mapJsonArrayToList(json.getJSONArray(SightSeeing.PROP_IMAGES)));
            if (json.has(SightSeeing.PROP_DESCRIPTION))
                dto.setDescription(json.getString(SightSeeing.PROP_DESCRIPTION));
            if (json.has(SightSeeing.PROP_DURATION))
                dto.setDuration(json.getString(SightSeeing.PROP_DURATION));
            if (json.has(SightSeeing.PROP_START_TIME))
                dto.setStartTime(json.getString(SightSeeing.PROP_START_TIME));
            if (json.has(SightSeeing.PROP_CITY))
                dto.setCity(json.getString(SightSeeing.PROP_CITY));
            if (json.has(SightSeeing.PROP_COUNTRY))
                dto.setCountry(json.getString(SightSeeing.PROP_COUNTRY));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return dto;
    }
}
