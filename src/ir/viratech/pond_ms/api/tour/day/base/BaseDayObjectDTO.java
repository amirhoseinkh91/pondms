package ir.viratech.pond_ms.api.tour.day.base;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.viratech.pond_ms.api.tour.tour.base.BaseTourObjectDTO;

import java.io.Serializable;
import java.util.List;

public class BaseDayObjectDTO extends BaseTourObjectDTO implements Serializable {

    @JsonProperty
    private List<BaseStepObjectsDTO> dayObjects;

    public List<BaseStepObjectsDTO> getDayObjects() {
        return dayObjects;
    }

    public void setDayObjects(List<BaseStepObjectsDTO> day) {
        this.dayObjects = day;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BaseDayObjectDTO that = (BaseDayObjectDTO) o;

        return dayObjects != null ? dayObjects.equals(that.dayObjects) : that.dayObjects == null;
    }

    @Override
    public int hashCode() {
        return dayObjects != null ? dayObjects.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "BaseDayObjectDTO{" +
                "dayObjects=" + dayObjects +
                '}';
    }
}
