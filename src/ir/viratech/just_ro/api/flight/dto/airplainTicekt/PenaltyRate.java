package ir.viratech.just_ro.api.flight.dto.airplainTicekt;

import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings({"SpellCheckingInspection"})
public class PenaltyRate {

    @JsonProperty("ID")
    private Integer ID;
    @JsonProperty("Airline")
    private Integer Airline;
    @JsonProperty("Class")
    private String clas;
    @JsonProperty("ThreeDaysBefore")
    private Integer ThreeDaysBefore;
    @JsonProperty("OneDayBefore")
    private Integer OneDayBefore;
    @JsonProperty("ThreeHoursBefore")
    private Integer ThreeHoursBefore;
    @JsonProperty("ThirtyMinsBefore")
    private Integer ThirtyMinsBefore;
    @JsonProperty("JustBefore")
    private Integer JustBefore;
    @JsonProperty("TwentyFourHoursBefore")
    private Integer TwentyFourHoursBefore;
    @JsonProperty("FourHoursBeforePrice")
    private Integer FourHoursBeforePrice;
    @JsonProperty("JustBeforePrice")
    private Integer JustBeforePrice;
    @JsonProperty("TwelveHoursBefore")
    private Integer TwelveHoursBefore;
    @JsonProperty("Cancellable")
    private Integer Cancellable;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getAirline() {
        return Airline;
    }

    public void setAirline(Integer airline) {
        Airline = airline;
    }


    public String getClas() {
        return clas;
    }

    public void setClass(String clas) {
        this.clas = clas;
    }

    public Integer getThreeDaysBefore() {
        return ThreeDaysBefore;
    }

    public void setThreeDaysBefore(Integer threeDaysBefore) {
        ThreeDaysBefore = threeDaysBefore;
    }

    public Integer getOneDayBefore() {
        return OneDayBefore;
    }

    public void setOneDayBefore(Integer oneDayBefore) {
        OneDayBefore = oneDayBefore;
    }

    public Integer getThreeHoursBefore() {
        return ThreeHoursBefore;
    }

    public void setThreeHoursBefore(Integer threeHoursBefore) {
        ThreeHoursBefore = threeHoursBefore;
    }

    public Integer getThirtyMinsBefore() {
        return ThirtyMinsBefore;
    }

    public void setThirtyMinsBefore(Integer thirtyMinsBefore) {
        ThirtyMinsBefore = thirtyMinsBefore;
    }

    public Integer getJustBefore() {
        return JustBefore;
    }

    public void setJustBefore(Integer justBefore) {
        JustBefore = justBefore;
    }

    public Integer getTwentyFourHoursBefore() {
        return TwentyFourHoursBefore;
    }

    public void setTwentyFourHoursBefore(Integer twentyFourHoursBefore) {
        TwentyFourHoursBefore = twentyFourHoursBefore;
    }

    public Integer getFourHoursBeforePrice() {
        return FourHoursBeforePrice;
    }

    public void setFourHoursBeforePrice(Integer fourHoursBeforePrice) {
        FourHoursBeforePrice = fourHoursBeforePrice;
    }

    public Integer getJustBeforePrice() {
        return JustBeforePrice;
    }

    public void setJustBeforePrice(Integer justBeforePrice) {
        JustBeforePrice = justBeforePrice;
    }

    public Integer getTwelveHoursBefore() {
        return TwelveHoursBefore;
    }

    public void setTwelveHoursBefore(Integer twelveHoursBefore) {
        TwelveHoursBefore = twelveHoursBefore;
    }

    public Integer getCancellable() {
        return Cancellable;
    }

    public void setCancellable(Integer cancellable) {
        Cancellable = cancellable;
    }



}
