package ir.viratech.just_ro.api.flight.dto.airplainTicekt;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@SuppressWarnings("unused")
public class AirplaneTicketFlightClassesDTO implements Serializable {

    @JsonProperty("Business")
    private Boolean business;
    @JsonProperty("Type")
    private Integer type;
    @JsonProperty("Class")
    private String classCode;
    @JsonProperty("Price")
    private Integer price;
    @JsonProperty("PenaltyRate")
    private AirplaneTicketFlightPenaltyRate penaltyRate;
    @JsonProperty("Capacity")
    private String capacityNumber;
    @JsonProperty("Baggage")
    private String baggageCapacity;
    @JsonProperty("Wheelchair")
    private Boolean wheelchairAllowed;
    @JsonProperty("International")
    private Boolean international;
    @JsonProperty("Packaged")
    private Boolean packaged;

    public Boolean getBusiness() {
        return business;
    }

    public void setBusiness(Boolean business) {
        this.business = business;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getClassCode() {
        return classCode;
    }

    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public AirplaneTicketFlightPenaltyRate getPenaltyRate() {
        return penaltyRate;
    }

    public void setPenaltyRate(AirplaneTicketFlightPenaltyRate penaltyRate) {
        this.penaltyRate = penaltyRate;
    }

    public String getCapacityNumber() {
        return capacityNumber;
    }

    public void setCapacityNumber(String capacityNumber) {
        this.capacityNumber = capacityNumber;
    }

    public String getBaggageCapacity() {
        return baggageCapacity;
    }

    public void setBaggageCapacity(String baggageCapacity) {
        this.baggageCapacity = baggageCapacity;
    }

    public Boolean getWheelchairAllowed() {
        return wheelchairAllowed;
    }

    public void setWheelchairAllowed(Boolean wheelchairAllowed) {
        this.wheelchairAllowed = wheelchairAllowed;
    }

    public Boolean getInternational() {
        return international;
    }

    public void setInternational(Boolean international) {
        this.international = international;
    }

    public Boolean getPackaged() {
        return packaged;
    }

    public void setPackaged(Boolean packaged) {
        this.packaged = packaged;
    }
}
