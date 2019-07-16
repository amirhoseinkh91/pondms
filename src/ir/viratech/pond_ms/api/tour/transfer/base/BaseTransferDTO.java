package ir.viratech.pond_ms.api.tour.transfer.base;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.viratech.pond_ms.api.tour.day.base.BaseStepObjectsDTO;

public class BaseTransferDTO extends BaseStepObjectsDTO {

    @JsonProperty
    private String duration;
    @JsonProperty
    private String vehicle;

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BaseTransferDTO that = (BaseTransferDTO) o;

        if (duration != null ? !duration.equals(that.duration) : that.duration != null) return false;
        return vehicle != null ? vehicle.equals(that.vehicle) : that.vehicle == null;
    }

    @Override
    public int hashCode() {
        int result = duration != null ? duration.hashCode() : 0;
        result = 31 * result + (vehicle != null ? vehicle.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "BaseTransferDTO{" +
                "duration='" + duration + '\'' +
                ", vehicle='" + vehicle + '\'' +
                '}' + ", " + super.toString();
    }
}
