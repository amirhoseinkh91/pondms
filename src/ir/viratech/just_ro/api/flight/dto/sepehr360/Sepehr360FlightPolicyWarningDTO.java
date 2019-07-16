package ir.viratech.just_ro.api.flight.dto.sepehr360;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.viratech.base.SuppressWarningsOption;

@SuppressWarnings({SuppressWarningsOption.UNUSED , SuppressWarningsOption.SPELL_CHECKING_INSPECTION})
public class Sepehr360FlightPolicyWarningDTO {

    @JsonProperty("PolicyWarning")
    private String policyWarning;

    @JsonProperty("Message")
    private String message;

    public String getPolicyWarning() {
        return policyWarning;
    }

    public void setPolicyWarning(String policyWarning) {
        this.policyWarning = policyWarning;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
