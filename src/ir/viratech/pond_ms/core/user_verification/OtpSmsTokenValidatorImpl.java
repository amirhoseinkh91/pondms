package ir.viratech.pond_ms.core.user_verification;

import ir.viratech.commons.api.auth.OtpSmsTokenValidatorInterface;
import ir.viratech.commons.user_verification.core.UserSmsVerificationManager;
import org.springframework.beans.factory.annotation.Autowired;

public class OtpSmsTokenValidatorImpl implements OtpSmsTokenValidatorInterface {

    @Autowired
    private UserSmsVerificationManager userSmsVerificationManager;


    @Override
    public boolean isTokenValid(String phoneNumber, String token) {
        return userSmsVerificationManager.isTokenValid(phoneNumber, token);
    }
}
