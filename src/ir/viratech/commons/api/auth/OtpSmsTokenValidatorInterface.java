package ir.viratech.commons.api.auth;

public interface OtpSmsTokenValidatorInterface {
    public boolean isTokenValid(String phoneNumber, String token);
}
