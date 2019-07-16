package ir.viratech.just_ro.api.flight.dto.sepehr360;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Sepehr360MinPriceTitleDTO {

    @JsonProperty("EarlyMorning_MinPrice")
    private String earlyMorning_MinPrice;

    @JsonProperty("Morning_MinPrice")
    private String morning_MinPrice;

    @JsonProperty("Midday_MinPrice")
    private String midday_MinPrice;

    @JsonProperty("Afternoon_MinPrice")
    private String afternoon_MinPrice;

    @JsonProperty("Evening_MinPrice")
    private String evening_MinPrice;

    @JsonProperty("Night_MinPrice")
    private String night_MinPrice;

    public String getEarlyMorning_MinPrice() {
        return earlyMorning_MinPrice;
    }

    public void setEarlyMorning_MinPrice(String earlyMorning_MinPrice) {
        this.earlyMorning_MinPrice = earlyMorning_MinPrice;
    }

    public String getMorning_MinPrice() {
        return morning_MinPrice;
    }

    public void setMorning_MinPrice(String morning_MinPrice) {
        this.morning_MinPrice = morning_MinPrice;
    }

    public String getMidday_MinPrice() {
        return midday_MinPrice;
    }

    public void setMidday_MinPrice(String midday_MinPrice) {
        this.midday_MinPrice = midday_MinPrice;
    }

    public String getAfternoon_MinPrice() {
        return afternoon_MinPrice;
    }

    public void setAfternoon_MinPrice(String afternoon_MinPrice) {
        this.afternoon_MinPrice = afternoon_MinPrice;
    }

    public String getEvening_MinPrice() {
        return evening_MinPrice;
    }

    public void setEvening_MinPrice(String evening_MinPrice) {
        this.evening_MinPrice = evening_MinPrice;
    }

    public String getNight_MinPrice() {
        return night_MinPrice;
    }

    public void setNight_MinPrice(String night_MinPrice) {
        this.night_MinPrice = night_MinPrice;
    }
}
