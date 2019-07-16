package ir.viratech.pond_ms.api.tour.meal.dto;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.gson.Gson;
import ir.viratech.commons.util.jackson.JacksonUtils;
import ir.viratech.pond_ms.api.tour.meal.base.BaseMealDTO;
import ir.viratech.pond_ms.api.tour.point.PointDTO;
import ir.viratech.pond_ms.model.tour_relations.base.model.ExtendedPointObject;
import ir.viratech.pond_ms.model.tour_relations.base.model.Point;
import ir.viratech.pond_ms.model.tour_relations.meal.Meal;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MealDTO extends BaseMealDTO {

    public Meal map(MealDTO mealDTO) {
        return modelMapper.map(mealDTO, Meal.class);
    }

    /*public MealDTO map(Meal meal) {
        return modelMapper.map(meal, MealDTO.class);
    }*/


    public MealDTO mymap(ExtendedPointObject meal) {
       MealDTO dto = new MealDTO();
       dto.setObjectType(ObjectType.meal);
        try {
            JSONObject json = new JSONObject(new Gson().toJson(meal));
            if (json.has(Meal.PROP_COUNTRY))
                dto.setCountry(json.getString(Meal.PROP_COUNTRY));
            if (json.has(Meal.PROP_CITY))
                dto.setCity(json.getString(Meal.PROP_CITY));
            if (json.has(Meal.PROP_DESCRIPTION))
                dto.setDescription(json.getString(Meal.PROP_DESCRIPTION));
            if (json.has(Meal.PROP_DURATION))
                dto.setDuration(json.getString(Meal.PROP_DURATION));
            if (json.has(Meal.PROP_NAME))
                dto.setName(json.getString(Meal.PROP_NAME));
            if (json.has(Meal.PROP_IMAGES)) {
                List<String> imagesList = new ArrayList<>();
                JSONArray array = json.getJSONArray(Meal.PROP_IMAGES);
                for (int i = 0; i < array.length(); i++)
                    imagesList.add(array.getString(i));
                dto.setImages(imagesList);
            }
            if (json.has(Meal.PROP_START_TIME))
                dto.setStartTime(json.getString(Meal.PROP_START_TIME));
            if (json.has(Meal.PROP_MEAL_NAME))
                dto.setMealName(json.getString(Meal.PROP_MEAL_NAME));
            if (json.has(Meal.PROP_POINT)) {
                PointDTO pointDTO = new PointDTO();
                Double x = json.getJSONObject(Meal.PROP_POINT).getJSONArray("coordinates").getDouble(0);
                Double y = json.getJSONObject(Meal.PROP_POINT).getJSONArray("coordinates").getDouble(1);
                pointDTO.setType("Point");
                pointDTO.setCoordinates(x, y);
                dto.setPoint(pointDTO);
            }
            System.out.println("my meal:   " + dto);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return  dto;
    }


    public Meal convertToEntity(MealDTO dto) {
        Meal meal = new Meal();
        meal.setObjectType(ObjectType.meal.toString());
        meal.setName(dto.getName());
        meal.setImages(dto.getImages());
        meal.setPoint(new PointDTO().convertToEntity(dto.getPoint()));
        meal.setStartTime(dto.getStartTime());
        meal.setMealName(dto.getMealName());
        meal.setDescription(dto.getDescription());
        meal.setDuration(dto.getDuration());
        meal.setCity(dto.getCity());
        meal.setCountry(dto.getCountry());
        return meal;
    }
}
