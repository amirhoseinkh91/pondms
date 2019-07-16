package ir.viratech.pond_ms.api.customer.dto;

import com.fasterxml.jackson.annotation.JsonProperty;


public class UserPhoneVerificationDTO {

    private String phoneNumber;
    @JsonProperty
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
