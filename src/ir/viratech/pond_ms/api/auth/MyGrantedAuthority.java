package ir.viratech.pond_ms.api.auth;

import org.springframework.security.core.GrantedAuthority;


/**
 * The Class MyGrantedAuthority.
 */
public class MyGrantedAuthority implements GrantedAuthority {
	private static final long serialVersionUID = 1L;

	private final String authority;

	/**
	 * Instantiates a new my granted authority.
	 *
	 * @param authority the authority
	 */
	public MyGrantedAuthority(String authority) {
		this.authority = authority;
	}
	
	/* (non-Javadoc)
	 * @see org.springframework.security.core.GrantedAuthority#getAuthority()
	 */
	@Override
	public String getAuthority() {
		return this.authority;
	}

}