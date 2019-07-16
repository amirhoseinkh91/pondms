package ir.viratech.pond_ms.api.auth;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import ir.viratech.pond_ms.model.user.Feature;
import ir.viratech.pond_ms.model.user.User;
import ir.viratech.pond_ms.model.user.logic.UserMgr;

/**
 * The Class MyUserDetails.
 */
public class MyUserDetails implements UserDetails {
	private static final long serialVersionUID = 1L;

	private static final transient Logger logger = Logger.getLogger(MyUserDetails.class);

	/**
	 * It used to be "ROLE_".
	 */
	private static final String FEATURE_PREFIX = "";//"ROLE_";


	private User user = null;

	/**
	 * Instantiates a new MyUserDetails.
	 *
	 * @param user the user
	 */
	public MyUserDetails(User user) {
		super();
		this.user = user;
	}


	/**
	 * Updates user.
	 */
	public void updateUser() {
		this.user = UserMgr.getInstance().getDetached(this.user.getId());
	}

	/**
	 * Gets the user.
	 *
	 * @return the user
	 */
	public User getUser() {
		return this.user;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Long getId() {
		return (this.user == null) ? null : this.user.getId();
	}

	// the following method is written for ACEGI, to recognize which pages the user can view
	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetails#getAuthorities()
	 */
	@Override
	public Collection<GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		UserMgr userMgr = UserMgr.getInstance();
		for (Feature feature : userMgr.getFeaturesOf(userMgr.reget(this.user))) {
		   	if (logger.isDebugEnabled()) {
		   		logger.debug("feature: "+feature.getName());
		   	}
		   	authorities.add(new MyGrantedAuthority(FEATURE_PREFIX + feature.getName()));
		}
		return authorities;
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetails#getPassword()
	 */
	@Override
	public String getPassword() {
		return (this.user == null) ? "" : this.user.getPassword();
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetails#getUsername()
	 */
	@Override
	public String getUsername() {
		return (this.user == null) ? "" : this.user.getUsername();
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetails#isAccountNonExpired()
	 */
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetails#isAccountNonLocked()
	 */
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetails#isCredentialsNonExpired()
	 */
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetails#isEnabled()
	 */
	@Override
	public boolean isEnabled() {
		return this.user.isEnabled();
	}

	/**
	 * Gets the first name.
	 *
	 * @return the first name
	 */
	public String getFirstName(){
		return this.user.getFirstName();
	}

	/**
	 * Gets the last name.
	 *
	 * @return the last name
	 */
	public String getLastName(){
		return this.user.getLastName();
	}

}