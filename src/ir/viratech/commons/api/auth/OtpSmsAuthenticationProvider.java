package ir.viratech.commons.api.auth;

import java.util.ArrayList;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import ir.viratech.pond_ms.api.auth.MyGrantedAuthority;
import ir.viratech.pond_ms.core.lottery.LotteryMessageManager;
import ir.viratech.pond_ms.model.customer.Customer;
import ir.viratech.pond_ms.model.customer.logic.CustomerMgr;
import ir.viratech.pond_ms.model.user.Feature;
import ir.viratech.pond_ms.model.user.User;
import ir.viratech.pond_ms.model.user.logic.UserMgr;


public class OtpSmsAuthenticationProvider implements AuthenticationProvider{

    @Autowired
    private OtpSmsTokenValidatorInterface otpSmsTokenValidatorInterface;

    @Autowired
    private LotteryMessageManager lotteryMessageManager;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        if (!(authentication instanceof OtpSmsAuthenticationToken))
            return null;

        OtpSmsAuthenticationToken otpAuth = (OtpSmsAuthenticationToken) authentication;
        String otpToken = otpAuth.getOtpToken();
        String phoneNumber = otpAuth.getPhoneNumber();
        if (this.isOtpCorrect(phoneNumber, otpToken)){
            User customerUser = CustomerMgr.getInstance().getUserByPhoneNumber(phoneNumber);
            if (customerUser == null){ //New Customer registration
                Customer newCustomer = CustomerMgr.getInstance().createNewWithPhoneNumber(phoneNumber);
                customerUser = newCustomer.getUser();
                lotteryMessageManager.addCustomerPhoneNumberToQueue(newCustomer);
            }
            ArrayList<MyGrantedAuthority> authorities = new ArrayList<>();
            Set<Feature> features = UserMgr.getInstance().getFeaturesOf(customerUser);
            for (Feature feature : features) {
                authorities.add(new MyGrantedAuthority(feature.getName()));
            }
            Authentication resultAuth = new OtpSmsAuthenticationToken(phoneNumber, otpToken, authorities);
            return resultAuth;
        }else{
            throw new BadCredentialsException("The provided token is not valid. It may be expired or incorrect");
        }
    }

	private boolean isOtpCorrect(String phoneNumber, String otpToken) {
        return otpSmsTokenValidatorInterface.isTokenValid(phoneNumber, otpToken);
    }


    @Override
    public boolean supports(Class<?> authentication) {
        return OtpSmsAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
