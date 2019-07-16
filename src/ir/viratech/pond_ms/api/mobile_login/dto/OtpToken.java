package ir.viratech.pond_ms.api.mobile_login.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OtpToken {

    @JsonProperty("j_phoneNumber")
    private String phoneNumber;
    @JsonProperty("j_otpToken")
    private String tokenNumber;


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getTokenNumber() {
        return tokenNumber;
    }

    public void setTokenNumber(String tokenNumber) {
        this.tokenNumber = tokenNumber;
    }
}
