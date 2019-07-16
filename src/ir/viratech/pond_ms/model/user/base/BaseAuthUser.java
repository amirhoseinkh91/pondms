package ir.viratech.pond_ms.model.user.base;

import java.io.Serializable;


/**
 *  Base class for entity "ir.viratech.pond_ms.model.user.AuthUser".
 *  It is an automatically generated file and should not be edited.
 *
 * @hibernate.class
 *  table="pond_ms.AUTH_USERS"
 */

public abstract class BaseAuthUser  implements Serializable {
	private static final long serialVersionUID = 1L;


	/** The constant referring the name of class "AuthUser". */
	public static final String REF = "AuthUser";
	
	/** The constant referring the property "id". */
	public static final String PROP_ID = "id";
	
	/** The constant referring the property "extuid". */
	public static final String PROP_EXTUID = "extuid";
	
	/** The constant referring the property "username". */
	public static final String PROP_USERNAME = "username";
	
	/** The constant referring the property "password". */
	public static final String PROP_PASSWORD = "password";
	
	/** The constant referring the property "enabled". */
	public static final String PROP_ENABLED = "enabled";
	
	/** The constant referring the property "firstName". */
	public static final String PROP_FIRST_NAME = "firstName";
	
	/** The constant referring the property "lastName". */
	public static final String PROP_LAST_NAME = "lastName";
	
	/** The constant referring the property "phoneNumber". */
	public static final String PROP_PHONE_NUMBER = "phoneNumber";
	
	/** The constant referring the property "userExpirationDate". */
	public static final String PROP_USER_EXPIRATION_DATE = "userExpirationDate";
	
	/** The constant referring the property "passwordExpirationDate". */
	public static final String PROP_PASSWORD_EXPIRATION_DATE = "passwordExpirationDate";
	
	/** The constant referring the property "noLoginExpirationDate". */
	public static final String PROP_NO_LOGIN_EXPIRATION_DATE = "noLoginExpirationDate";
	
	/** The constant referring the property "lastLoginFailureDate". */
	public static final String PROP_LAST_LOGIN_FAILURE_DATE = "lastLoginFailureDate";
	
	/** The constant referring the property "lastConsecutiveLoginFailuresCount". */
	public static final String PROP_LAST_CONSECUTIVE_LOGIN_FAILURES_COUNT = "lastConsecutiveLoginFailuresCount";
	
	
	/** The name of table for this class. */
	public static final String TABLE = "pond_ms.AUTH_USERS";
	
	/** Name of column referring the property "id". */
	public static final String PROPCOLUMN_ID = "id";
	
	/** Name of column referring the property "extuid". */
	public static final String PROPCOLUMN_EXTUID = "extuid";
	
	/** Name of column referring the property "username". */
	public static final String PROPCOLUMN_USERNAME = "username";
	
	/** Name of column referring the property "password". */
	public static final String PROPCOLUMN_PASSWORD = "password";
	
	/** Name of column referring the property "enabled". */
	public static final String PROPCOLUMN_ENABLED = "enabled";
	
	/** Name of column referring the property "firstName". */
	public static final String PROPCOLUMN_FIRST_NAME = "firstName";
	
	/** Name of column referring the property "lastName". */
	public static final String PROPCOLUMN_LAST_NAME = "lastName";
	
	/** Name of column referring the property "phoneNumber". */
	public static final String PROPCOLUMN_PHONE_NUMBER = "phoneNumber";
	
	/** Name of column referring the property "userExpirationDate". */
	public static final String PROPCOLUMN_USER_EXPIRATION_DATE = "userExpirationDate";
	
	/** Name of column referring the property "passwordExpirationDate". */
	public static final String PROPCOLUMN_PASSWORD_EXPIRATION_DATE = "passwordExpirationDate";
	
	/** Name of column referring the property "noLoginExpirationDate". */
	public static final String PROPCOLUMN_NO_LOGIN_EXPIRATION_DATE = "noLoginExpirationDate";
	
	/** Name of column referring the property "lastLoginFailureDate". */
	public static final String PROPCOLUMN_LAST_LOGIN_FAILURE_DATE = "lastLoginFailureDate";
	
	/** Name of column referring the property "lastConsecutiveLoginFailuresCount". */
	public static final String PROPCOLUMN_LAST_CONSECUTIVE_LOGIN_FAILURES_COUNT = "lastConsecutiveLoginFailuresCount";
	
	

	
	
	


	private int hashCode_ = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
	private java.lang.String extuid;
	private java.lang.String username;
	private java.lang.String password;
	private boolean enabled;
	private java.lang.String firstName;
	private java.lang.String lastName;
	private java.lang.String phoneNumber;
	private java.util.Date userExpirationDate;
	private java.util.Date passwordExpirationDate;
	private java.util.Date noLoginExpirationDate;
	private java.util.Date lastLoginFailureDate;
	private int lastConsecutiveLoginFailuresCount;



	/**
	 * Returns the identifier.
	 * 
	 * @return the value of id
     * @hibernate.id
     *  generator-class="increment"
     *  column="id"
     */
	public java.lang.Long getId() {
		return id;
	}

	/**
	 * Set the identifier.
	 * 
	 * @param id the new value of id
	 */
	public void setId(java.lang.Long id) {
		this.id = id;
		this.hashCode_ = Integer.MIN_VALUE;
	}




	/**
	 * Getter for "extuid".
	 * column= extuid
	 *
	 * @return the value of extuid
	 */
	public java.lang.String getExtuid() {
		return this.extuid;
	}

	/**
	 * Setter for property "extuid".
	 * column= extuid
	 *
	 * @param extuid the new value for extuid
	 */
	public void setExtuid(java.lang.String extuid) {
		this.extuid = extuid;
		this.hashCode_ = Integer.MIN_VALUE;
	}



	/**
	 * Getter for "username".
	 * column= username
	 *
	 * @return the value of username
	 */
	public java.lang.String getUsername() {
		return this.username;
	}

	/**
	 * Setter for property "username".
	 * column= username
	 *
	 * @param username the new value for username
	 */
	public void setUsername(java.lang.String username) {
		this.username = username;
	}



	/**
	 * Getter for "password".
	 * column= password
	 *
	 * @return the value of password
	 */
	public java.lang.String getPassword() {
		return this.password;
	}

	/**
	 * Setter for property "password".
	 * column= password
	 *
	 * @param password the new value for password
	 */
	public void setPassword(java.lang.String password) {
		this.password = password;
	}



	/**
	 * Getter for "enabled".
	 * column= enabled
	 *
	 * @return the value of enabled
	 */
	public boolean isEnabled() {
		return this.enabled;
	}

	/**
	 * Setter for property "enabled".
	 * column= enabled
	 *
	 * @param enabled the new value for enabled
	 */
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}



	/**
	 * Getter for "firstName".
	 * column= firstName
	 *
	 * @return the value of firstName
	 */
	public java.lang.String getFirstName() {
		return this.firstName;
	}

	/**
	 * Setter for property "firstName".
	 * column= firstName
	 *
	 * @param firstName the new value for firstName
	 */
	public void setFirstName(java.lang.String firstName) {
		this.firstName = firstName;
	}



	/**
	 * Getter for "lastName".
	 * column= lastName
	 *
	 * @return the value of lastName
	 */
	public java.lang.String getLastName() {
		return this.lastName;
	}

	/**
	 * Setter for property "lastName".
	 * column= lastName
	 *
	 * @param lastName the new value for lastName
	 */
	public void setLastName(java.lang.String lastName) {
		this.lastName = lastName;
	}



	/**
	 * Getter for "phoneNumber".
	 * column= phoneNumber
	 *
	 * @return the value of phoneNumber
	 */
	public java.lang.String getPhoneNumber() {
		return this.phoneNumber;
	}

	/**
	 * Setter for property "phoneNumber".
	 * column= phoneNumber
	 *
	 * @param phoneNumber the new value for phoneNumber
	 */
	public void setPhoneNumber(java.lang.String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}



	/**
	 * Getter for "userExpirationDate".
	 * column= userExpirationDate
	 *
	 * @return the value of userExpirationDate
	 */
	public java.util.Date getUserExpirationDate() {
		return this.userExpirationDate;
	}

	/**
	 * Setter for property "userExpirationDate".
	 * column= userExpirationDate
	 *
	 * @param userExpirationDate the new value for userExpirationDate
	 */
	public void setUserExpirationDate(java.util.Date userExpirationDate) {
		this.userExpirationDate = userExpirationDate;
	}



	/**
	 * Getter for "passwordExpirationDate".
	 * column= passwordExpirationDate
	 *
	 * @return the value of passwordExpirationDate
	 */
	public java.util.Date getPasswordExpirationDate() {
		return this.passwordExpirationDate;
	}

	/**
	 * Setter for property "passwordExpirationDate".
	 * column= passwordExpirationDate
	 *
	 * @param passwordExpirationDate the new value for passwordExpirationDate
	 */
	public void setPasswordExpirationDate(java.util.Date passwordExpirationDate) {
		this.passwordExpirationDate = passwordExpirationDate;
	}



	/**
	 * Getter for "noLoginExpirationDate".
	 * column= noLoginExpirationDate
	 *
	 * @return the value of noLoginExpirationDate
	 */
	public java.util.Date getNoLoginExpirationDate() {
		return this.noLoginExpirationDate;
	}

	/**
	 * Setter for property "noLoginExpirationDate".
	 * column= noLoginExpirationDate
	 *
	 * @param noLoginExpirationDate the new value for noLoginExpirationDate
	 */
	public void setNoLoginExpirationDate(java.util.Date noLoginExpirationDate) {
		this.noLoginExpirationDate = noLoginExpirationDate;
	}



	/**
	 * Getter for "lastLoginFailureDate".
	 * column= lastLoginFailureDate
	 *
	 * @return the value of lastLoginFailureDate
	 */
	public java.util.Date getLastLoginFailureDate() {
		return this.lastLoginFailureDate;
	}

	/**
	 * Setter for property "lastLoginFailureDate".
	 * column= lastLoginFailureDate
	 *
	 * @param lastLoginFailureDate the new value for lastLoginFailureDate
	 */
	public void setLastLoginFailureDate(java.util.Date lastLoginFailureDate) {
		this.lastLoginFailureDate = lastLoginFailureDate;
	}



	/**
	 * Getter for "lastConsecutiveLoginFailuresCount".
	 * column= lastConsecutiveLoginFailuresCount
	 *
	 * @return the value of lastConsecutiveLoginFailuresCount
	 */
	public int getLastConsecutiveLoginFailuresCount() {
		return this.lastConsecutiveLoginFailuresCount;
	}

	/**
	 * Setter for property "lastConsecutiveLoginFailuresCount".
	 * column= lastConsecutiveLoginFailuresCount
	 *
	 * @param lastConsecutiveLoginFailuresCount the new value for lastConsecutiveLoginFailuresCount
	 */
	public void setLastConsecutiveLoginFailuresCount(int lastConsecutiveLoginFailuresCount) {
		this.lastConsecutiveLoginFailuresCount = lastConsecutiveLoginFailuresCount;
	}




	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (null == obj) return false;
		if (!(obj instanceof ir.viratech.pond_ms.model.user.AuthUser)) return false;
		else {
			ir.viratech.pond_ms.model.user.AuthUser authUser = (ir.viratech.pond_ms.model.user.AuthUser) obj;
			boolean isEqual = true;
			if (null == this.getExtuid() || null == authUser.getExtuid()) return false;
			else isEqual = isEqual && (this.getExtuid().equals(authUser.getExtuid()));
			return isEqual;
		}
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		if (Integer.MIN_VALUE == this.hashCode_) {
			StringBuilder hashStr = new StringBuilder();
			hashStr.append(this.getClass().getName() + ":");
			if (null == this.getExtuid()) return super.hashCode();
			else hashStr.append(this.getExtuid().toString() + ":");
			this.hashCode_ = hashStr.toString().hashCode();
		}
		return this.hashCode_;
	}


	
	protected String toStringData() {
		return "id: " + this.getId();
	}
	
	@Override
	public String toString() {
		return this.getClass().getSimpleName() + "{" + this.toStringData() + "}";
	}



}