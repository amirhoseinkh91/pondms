package ir.viratech.just_ro.api.flight.dto.airplainTicekt;

import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings({"SpellCheckingInspection"})
public class AirplainTicketClass {

    @JsonProperty("Business")
    private Integer business;
    @JsonProperty("Type")
    private Integer type;
    @JsonProperty("Class")
    private String classChar;
    @JsonProperty("Price")
    private Integer price;
    @JsonProperty("PenaltyRate")
    private PenaltyRate penaltyRate;
    @JsonProperty("Capacity")
    private String capacity;
    @JsonProperty("Baggage")
    private String baggage;
    @JsonProperty("Wheelchair")
    private Boolean wheelchair;
    @JsonProperty("International")
    private Boolean international;
    @JsonProperty("Packaged")
    private Boolean packaged;



    public Integer getBusiness() {
        return business;
    }

    public void setBusiness(Integer business) {
        this.business = business;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }


    public String getclass() {
        return this.classChar;
    }

    public void setclass(String classChar) {
        this.classChar = classChar;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public PenaltyRate getPenaltyRate() {
        return penaltyRate;
    }

    public void setPenaltyRate(PenaltyRate penaltyRate) {
        this.penaltyRate = penaltyRate;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getBaggage() {
        return baggage;
    }

    public void setBaggage(String baggage) {
        this.baggage = baggage;
    }

    public Boolean getWheelchair() {
        return wheelchair;
    }

    public void setWheelchair(Boolean wheelchair) {
        this.wheelchair = wheelchair;
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
