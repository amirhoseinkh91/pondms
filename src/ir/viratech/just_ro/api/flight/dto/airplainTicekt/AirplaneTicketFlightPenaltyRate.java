package ir.viratech.just_ro.api.flight.dto.airplainTicekt;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class AirplaneTicketFlightPenaltyRate implements Serializable{

    @JsonProperty("ID")
    private String id;
    @JsonProperty("Airline")
    private String airlineCode;
    @JsonProperty("Class")
    private String classsCode;
    @JsonProperty("threeDaysBefore")
    private String threeDaysBefore;
    @JsonProperty("OneDayBefore")
    private String oneDayBefore;
    @JsonProperty("ThreeHoursBefore")
    private String threeHoursBefore;
    @JsonProperty("ThirtyMinsBefore")
    private String thirtyMinsBefore;
    @JsonProperty("JustBefore")
    private String justBefore;
    @JsonProperty("TwentyFourHoursBefore")
    private String twentyFourHoursBefore;
    @JsonProperty("FourHoursBeforePrice")
    private String fourHoursBeforePrice;
    @JsonProperty("JustBeforePrice")
    private String justBeforePrice;
    @JsonProperty("TwelveHoursBefore")
    private String twelveHoursBefore;
    @JsonProperty("Cancellable")
    private String cancellable;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAirlineCode() {
        return airlineCode;
    }

    public void setAirlineCode(String airlineCode) {
        this.airlineCode = airlineCode;
    }

    public String getClasssCode() {
        return classsCode;
    }

    public void setClasssCode(String classsCode) {
        this.classsCode = classsCode;
    }

    public String getThreeDaysBefore() {
        return threeDaysBefore;
    }

    public void setThreeDaysBefore(String threeDaysBefore) {
        this.threeDaysBefore = threeDaysBefore;
    }

    public String getOneDayBefore() {
        return oneDayBefore;
    }

    public void setOneDayBefore(String oneDayBefore) {
        this.oneDayBefore = oneDayBefore;
    }

    public String getThreeHoursBefore() {
        return threeHoursBefore;
    }

    public void setThreeHoursBefore(String threeHoursBefore) {
        this.threeHoursBefore = threeHoursBefore;
    }

    public String getThirtyMinsBefore() {
        return thirtyMinsBefore;
    }

    public void setThirtyMinsBefore(String thirtyMinsBefore) {
        this.thirtyMinsBefore = thirtyMinsBefore;
    }

    public String getJustBefore() {
        return justBefore;
    }

    public void setJustBefore(String justBefore) {
        this.justBefore = justBefore;
    }

    public String getTwentyFourHoursBefore() {
        return twentyFourHoursBefore;
    }

    public void setTwentyFourHoursBefore(String twentyFourHoursBefore) {
        this.twentyFourHoursBefore = twentyFourHoursBefore;
    }

    public String getFourHoursBeforePrice() {
        return fourHoursBeforePrice;
    }

    public void setFourHoursBeforePrice(String fourHoursBeforePrice) {
        this.fourHoursBeforePrice = fourHoursBeforePrice;
    }

    public String getJustBeforePrice() {
        return justBeforePrice;
    }

    public void setJustBeforePrice(String justBeforePrice) {
        this.justBeforePrice = justBeforePrice;
    }

    public String getTwelveHoursBefore() {
        return twelveHoursBefore;
    }

    public void setTwelveHoursBefore(String twelveHoursBefore) {
        this.twelveHoursBefore = twelveHoursBefore;
    }

    public String getCancellable() {
        return cancellable;
    }

    public void setCancellable(String cancellable) {
        this.cancellable = cancellable;
    }
}
