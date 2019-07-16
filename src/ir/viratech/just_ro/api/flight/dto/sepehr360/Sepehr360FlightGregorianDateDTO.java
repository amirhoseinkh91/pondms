package ir.viratech.just_ro.api.flight.dto.sepehr360;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.viratech.base.SuppressWarningsOption;

@SuppressWarnings({SuppressWarningsOption.SPELL_CHECKING_INSPECTION, SuppressWarningsOption.UNUSED})
public class Sepehr360FlightGregorianDateDTO {

    @JsonProperty("Date")
    private String date;

    @JsonProperty("DayOfWeek")
    private String dayOfWeek;

    @JsonProperty("DateAsYYYYMonDD")
    private String mediumDateString;

    @JsonProperty("DateAsMonDDYYYY")
    private String mediumFormatedDateString;

    @JsonProperty("DateAsDayMonth")
    private String shortDateString;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public String getMediumDateString() {
        return mediumDateString;
    }

    public void setMediumDateString(String mediumDateString) {
        this.mediumDateString = mediumDateString;
    }

    public String getMediumFormatedDateString() {
        return mediumFormatedDateString;
    }

    public void setMediumFormatedDateString(String mediumFormatedDateString) {
        this.mediumFormatedDateString = mediumFormatedDateString;
    }

    public String getShortDateString() {
        return shortDateString;
    }

    public void setShortDateString(String shortDateString) {
        this.shortDateString = shortDateString;
    }
}
