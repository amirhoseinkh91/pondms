package ir.viratech.just_ro.api.flight.dto.sepehr360;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.viratech.base.SuppressWarningsOption;

@SuppressWarnings({SuppressWarningsOption.SPELL_CHECKING_INSPECTION, SuppressWarningsOption.UNUSED})
public class Sepehr360FlightPriceDTO {

    @JsonProperty("FareType")
    private String fareType;
    @JsonProperty("FlightPolicyWarning")
    private Sepehr360FlightPolicyWarningDTO flightPolicyWarning;
    @JsonProperty("PriceByFareClass")
    private Sepehr360FlightByFareClassDTO flightByFareClass;
    @JsonProperty("Amount")
    private Double amount;
    @JsonProperty("FormatedAmount")
    private String formatedAmount;

    public String getFareType() {
        return fareType;
    }

    public void setFareType(String fareType) {
        this.fareType = fareType;
    }

    public Sepehr360FlightPolicyWarningDTO getFlightPolicyWarning() {
        return flightPolicyWarning;
    }

    public void setFlightPolicyWarning(Sepehr360FlightPolicyWarningDTO flightPolicyWarning) {
        this.flightPolicyWarning = flightPolicyWarning;
    }

    public Sepehr360FlightByFareClassDTO getFlightByFareClass() {
        return flightByFareClass;
    }

    public void setFlightByFareClass(Sepehr360FlightByFareClassDTO flightByFareClass) {
        this.flightByFareClass = flightByFareClass;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getFormatedAmount() {
        return formatedAmount;
    }

    public void setFormatedAmount(String formatedAmount) {
        this.formatedAmount = formatedAmount;
    }
}
