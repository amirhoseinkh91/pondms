package ir.viratech.just_ro.api.flight.dto.sepehr360;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.viratech.base.SuppressWarningsOption;

@SuppressWarnings({SuppressWarningsOption.SPELL_CHECKING_INSPECTION, SuppressWarningsOption.UNUSED})
public class Sepehr360FlightByFareClassDTO {

    // todo
    @JsonProperty("FlightNo")
    private Object flightNo;
    // todo
    @JsonProperty("ResBookDesgiCodeRph")
    private Object resBookDesgiCodeRph;
    @JsonProperty("FareClassTitle")
    private String fareClassTitle;
    // todo
    @JsonProperty("ClassMessage")
    private Object classMessage;

    public Object getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(Object flightNo) {
        this.flightNo = flightNo;
    }

    public Object getResBookDesgiCodeRph() {
        return resBookDesgiCodeRph;
    }

    public void setResBookDesgiCodeRph(Object resBookDesgiCodeRph) {
        this.resBookDesgiCodeRph = resBookDesgiCodeRph;
    }

    public String getFareClassTitle() {
        return fareClassTitle;
    }

    public void setFareClassTitle(String fareClassTitle) {
        this.fareClassTitle = fareClassTitle;
    }

    public Object getClassMessage() {
        return classMessage;
    }

    public void setClassMessage(Object classMessage) {
        this.classMessage = classMessage;
    }
}
