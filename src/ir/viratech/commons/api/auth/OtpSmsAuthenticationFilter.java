package ir.viratech.commons.api.auth;

import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class OtpSmsAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    public OtpSmsAuthenticationFilter() {
        super("/j_spring_otptoken_security_check");
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
        if (!request.getMethod().equals("POST")) {
            throw new AuthenticationServiceException("Authentication method not supported: " + request.getMethod());
        }
        String phoneNumber = request.getParameter("j_phoneNumber");
        String otpToken = request.getParameter("j_otpToken");

        if (phoneNumber == null || otpToken == null) {
            throw new AuthenticationServiceException("Parameters phoneNumber and optToken must be not null");
        }

        OtpSmsAuthenticationToken otpSmsAuthenticationToken = new OtpSmsAuthenticationToken(phoneNumber, otpToken);
        SecurityContextHolder.getContext().setAuthentication(otpSmsAuthenticationToken);

        return this.getAuthenticationManager().authenticate(otpSmsAuthenticationToken);
    }

}
