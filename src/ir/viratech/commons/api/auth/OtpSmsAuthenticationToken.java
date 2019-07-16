package ir.viratech.commons.api.auth;

import java.util.Collection;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

public class OtpSmsAuthenticationToken extends AbstractAuthenticationToken{

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;
	public OtpSmsAuthenticationToken(String phoneNumber, String otpToken) {
        super(null);
        this.phoneNumber = phoneNumber;
        this.otpToken = otpToken;
        this.setAuthenticated(false);
    }


    public OtpSmsAuthenticationToken(String phoneNumber, String otpToken, Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        this.phoneNumber = phoneNumber;
        this.otpToken = otpToken;
        this.setAuthenticated(true);
    }





	private String phoneNumber;
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    private String otpToken;
    public void setOtpToken(String otpToken) {
        this.otpToken = otpToken;
    }
    public String getOtpToken() {
        return otpToken;
    }

    @Override
    public Object getCredentials() {
        return this.getOtpToken();
    }

    @Override
    public Object getPrincipal() {
        return this.getPhoneNumber();
    }



}
