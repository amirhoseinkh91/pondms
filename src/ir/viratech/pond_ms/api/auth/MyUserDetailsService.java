package ir.viratech.pond_ms.api.auth;

import ir.viratech.commons.api.auth.OtpSmsAuthenticationToken;
import ir.viratech.pond_ms.core.spring.ApplicationContextUtil;
import ir.viratech.pond_ms.model.customer.Customer;
import ir.viratech.pond_ms.model.customer.logic.CustomerMgr;
import ir.viratech.pond_ms.model.user.User;
import ir.viratech.pond_ms.model.user.exception.UserNotFoundException;
import ir.viratech.pond_ms.model.user.logic.UserMgr;
import org.apache.log4j.Logger;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.RememberMeAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * The Class MyUserDetailsService.
 */
public class MyUserDetailsService implements UserDetailsService {

    private static final Logger logger = Logger.getLogger(MyUserDetailsService.class);

    /**
     * Instantiates a new my user details service.
     */
    public MyUserDetailsService() {
        logger.debug("MyUserDetailsService created.");
    }

    /**
     * This function load the user by extuid not by the username.
     *
     * @param s the s
     * @return the my user details
     */
    @Override
    public MyUserDetails loadUserByUsername(String s) {
        logger.debug("loadUserByUsername: " + s);
        User user = null;
        try {
            user = UserMgr.getInstance().getDetachedUserByUsername(s);
        } catch (UserNotFoundException e) {
            logger.debug("User not found with the given username: " + s);
            throw new UsernameNotFoundException(e.getMessage(), e);
        }
        return new MyUserDetails(user);
    }

    /**
     * Gets the current user.
     *
     * @return the current user
     */
    @SuppressWarnings("Duplicates")
    public static User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User currentUser;
        if (authentication == null) {
            logger.error("SecurityContextHolder.getContext().getAuthentication() returns null!", new Exception());
            currentUser = null;
        } else if (authentication instanceof AnonymousAuthenticationToken) {
            //This case happens when the user is not logged in
            logger.debug("it is anonymous");
            currentUser = null;
        } else if (authentication instanceof OtpSmsAuthenticationToken) {
            String phoneNumber = (String) authentication.getPrincipal();
            Customer customer = CustomerMgr.getInstance().getByPhoneNumber(phoneNumber);
            currentUser = customer.getUser();
            ApplicationContextUtil.getCurrentExecutionContext().setUser(currentUser);
        } else {
            Object obj = authentication.getPrincipal();
            if (obj == null) {
                logger.error("authentication.getPrincipal() == null", new Exception());
                currentUser = null;
            } else if (obj instanceof MyUserDetails) {
                currentUser = ((MyUserDetails) obj).getUser();
            } else {
                logger.error("authentication.getPrincipal() is not an instance of " + MyUserDetails.class + "\n" + "It is " + obj + " of type " + obj.getClass());
                currentUser = null;
            }
        }
        return currentUser;
    }

    /**
     * Gets the current user username.
     *
     * @return the current user username
     */
    public static String getCurrentUserUsername() {
        User currentUser = getCurrentUser();
        return (currentUser == null) ? null : currentUser.getUsername();
    }

    /**
     * Gets the current user attached.
     *
     * @return the current user attached
     */
    public static User getCurrentUserAttached() {
        return UserMgr.getInstance().getAttached(getCurrentUser());
    }

}
