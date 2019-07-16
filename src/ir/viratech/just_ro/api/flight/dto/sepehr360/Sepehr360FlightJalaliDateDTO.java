package ir.viratech.just_ro.api.flight.dto.sepehr360;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.viratech.base.SuppressWarningsOption;

@SuppressWarnings({SuppressWarningsOption.UNUSED, SuppressWarningsOption.SPELL_CHECKING_INSPECTION})
public class Sepehr360FlightJalaliDateDTO {

    @JsonProperty("ConvertedDate")
    private String convertedDate;

    @JsonProperty("DayOfWeek")
    private String dayOfWeekStr;

    @JsonProperty("Day")
    private Integer dayOfMonthInt;

    @JsonProperty("MonthName")
    private String monthName;

    @JsonProperty("DateAsYYMonthDDWeekDayname")
    private String longDateString;

    @JsonProperty("DateAsYYYYMMDD")
    private String shortDateString;

    public String getConvertedDate() {
        return convertedDate;
    }

    public void setConvertedDate(String convertedDate) {
        this.convertedDate = convertedDate;
    }

    public String getDayOfWeekStr() {
        return dayOfWeekStr;
    }

    public void setDayOfWeekStr(String dayOfWeekStr) {
        this.dayOfWeekStr = dayOfWeekStr;
    }

    public Integer getDayOfMonthInt() {
        return dayOfMonthInt;
    }

    public void setDayOfMonthInt(Integer dayOfMonthInt) {
        this.dayOfMonthInt = dayOfMonthInt;
    }

    public String getMonthName() {
        return monthName;
    }

    public void setMonthName(String monthName) {
        this.monthName = monthName;
    }

    public String getLongDateString() {
        return longDateString;
    }

    public void setLongDateString(String longDateString) {
        this.longDateString = longDateString;
    }

    public String getShortDateString() {
        return shortDateString;
    }

    public void setShortDateString(String shortDateString) {
        this.shortDateString = shortDateString;
    }
}
