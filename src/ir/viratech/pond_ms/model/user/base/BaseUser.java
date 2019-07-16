package ir.viratech.pond_ms.model.user.base;

import java.io.Serializable;


/**
 *  Base class for entity "ir.viratech.pond_ms.model.user.User".
 *  It is an automatically generated file and should not be edited.
 *
 * @hibernate.class
 *  table="pond_ms.USERS"
 */

public abstract class BaseUser  implements Serializable {
	private static final long serialVersionUID = 1L;


	/** The constant referring the name of class "User". */
	public static final String REF = "User";
	
	/** The constant referring the property "id". */
	public static final String PROP_ID = "id";
	
	/** The constant referring the property "extuid". */
	public static final String PROP_EXTUID = "extuid";
	
	/** The constant referring the property "enabled". */
	public static final String PROP_ENABLED = "enabled";
	
	/** The constant referring the property "userDefined". */
	public static final String PROP_USER_DEFINED = "userDefined";
	
	/** The constant referring the property "avatar". */
	public static final String PROP_AVATAR = "avatar";
	
	/** The constant referring the property "lastSeen". */
	public static final String PROP_LAST_SEEN = "lastSeen";
	
	/** The constant referring the property "firebaseId". */
	public static final String PROP_FIREBASE_ID = "firebaseId";
	
	/** The constant referring the property "authUser". */
	public static final String PROP_AUTH_USER = "authUser";
	
	/** The constant referring the property "organization". */
	public static final String PROP_ORGANIZATION = "organization";
	
	/** The constant referring the property "customer". */
	public static final String PROP_CUSTOMER = "customer";
	
	/** The constant referring the property "roles". */
	public static final String PROP_ROLES = "roles";
	
	/** The constant referring the property "reviews". */
	public static final String PROP_REVIEWS = "reviews";
	
	
	/** The name of table for this class. */
	public static final String TABLE = "pond_ms.USERS";
	
	/** Name of column referring the property "id". */
	public static final String PROPCOLUMN_ID = "id";
	
	/** Name of column referring the property "extuid". */
	public static final String PROPCOLUMN_EXTUID = "extuid";
	
	/** Name of column referring the property "enabled". */
	public static final String PROPCOLUMN_ENABLED = "enabled";
	
	/** Name of column referring the property "userDefined". */
	public static final String PROPCOLUMN_USER_DEFINED = "userDefined";
	
	/** Name of column referring the property "avatar". */
	public static final String PROPCOLUMN_AVATAR = "avatar";
	
	/** Name of column referring the property "lastSeen". */
	public static final String PROPCOLUMN_LAST_SEEN = "lastSeen";
	
	/** Name of column referring the property "firebaseId". */
	public static final String PROPCOLUMN_FIREBASE_ID = "firebaseId";
	
	/** Name of column referring the property "authUser". */
	public static final String PROPCOLUMN_AUTH_USER = "authUserId";
	
	/** Name of column referring the property "organization". */
	public static final String PROPCOLUMN_ORGANIZATION = "organizationId";
	
	/** Name of table referring the property "roles". */
	public static final String PROPTABLE_ROLES = "pond_ms.USER_ROLES";
	
	

	
	
	


	private int hashCode_ = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
	private java.lang.String extuid;
	private boolean enabled;
	private boolean userDefined;
	private java.lang.String avatar;
	private java.util.Date lastSeen;
	private java.lang.String firebaseId;

	// one to one
	private ir.viratech.pond_ms.model.customer.Customer customer;

	// many to one
	private ir.viratech.pond_ms.model.user.AuthUser authUser;
	private ir.viratech.pond_ms.model.organization.Organization organization;

	// collections
	private java.util.Set<ir.viratech.pond_ms.model.user.role.UserRole> roles;
	private java.util.Set<ir.viratech.pond_ms.model.review.Review> reviews;



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
	 * Getter for "userDefined".
	 * column= userDefined
	 *
	 * @return the value of userDefined
	 */
	public boolean isUserDefined() {
		return this.userDefined;
	}

	/**
	 * Setter for property "userDefined".
	 * column= userDefined
	 *
	 * @param userDefined the new value for userDefined
	 */
	public void setUserDefined(boolean userDefined) {
		this.userDefined = userDefined;
	}



	/**
	 * Getter for "avatar".
	 * column= avatar
	 *
	 * @return the value of avatar
	 */
	public java.lang.String getAvatar() {
		return this.avatar;
	}

	/**
	 * Setter for property "avatar".
	 * column= avatar
	 *
	 * @param avatar the new value for avatar
	 */
	public void setAvatar(java.lang.String avatar) {
		this.avatar = avatar;
	}



	/**
	 * Getter for "lastSeen".
	 * column= lastSeen
	 *
	 * @return the value of lastSeen
	 */
	public java.util.Date getLastSeen() {
		return this.lastSeen;
	}

	/**
	 * Setter for property "lastSeen".
	 * column= lastSeen
	 *
	 * @param lastSeen the new value for lastSeen
	 */
	public void setLastSeen(java.util.Date lastSeen) {
		this.lastSeen = lastSeen;
	}



	/**
	 * Getter for "firebaseId".
	 * column= firebaseId
	 *
	 * @return the value of firebaseId
	 */
	public java.lang.String getFirebaseId() {
		return this.firebaseId;
	}

	/**
	 * Setter for property "firebaseId".
	 * column= firebaseId
	 *
	 * @param firebaseId the new value for firebaseId
	 */
	public void setFirebaseId(java.lang.String firebaseId) {
		this.firebaseId = firebaseId;
	}



	/**
	 * Getter for "customer".
	 *
	 * @return the value of customer
	 */
	public ir.viratech.pond_ms.model.customer.Customer getCustomer() {
		return this.customer;
	}

	/**
	 * Setter for property "customer".
	 *
	 * @param customer the new value for customer
	 */
	public void setCustomer(ir.viratech.pond_ms.model.customer.Customer customer) {
		this.customer = customer;
	}



	/**
	 * Getter for "authUser".
	 * column= authUserId
	 *
	 * @return the value of authUser
	 */
	public ir.viratech.pond_ms.model.user.AuthUser getAuthUser() {
		return this.authUser;
	}

	/**
	 * Setter for property "authUser".
	 * column= authUserId
	 *
	 * @param authUser the new value for authUser
	 */
	public void setAuthUser(ir.viratech.pond_ms.model.user.AuthUser authUser) {
		this.authUser = authUser;
	}



	/**
	 * Getter for "organization".
	 * column= organizationId
	 *
	 * @return the value of organization
	 */
	public ir.viratech.pond_ms.model.organization.Organization getOrganization() {
		return this.organization;
	}

	/**
	 * Setter for property "organization".
	 * column= organizationId
	 *
	 * @param organization the new value for organization
	 */
	public void setOrganization(ir.viratech.pond_ms.model.organization.Organization organization) {
		this.organization = organization;
	}



	/**
	 * Getter for "roles".
	 *
	 * @return the value of roles
	 */
	public java.util.Set<ir.viratech.pond_ms.model.user.role.UserRole> getRoles() {
		return this.roles;
	}

	/**
	 * Setter for property "roles".
	 *
	 * @param roles the new value for roles
	 */
	public void setRoles(java.util.Set<ir.viratech.pond_ms.model.user.role.UserRole> roles) {
		this.roles = roles;
	}
	/**
	 * Gets roles, and creates and sets a new instance if it is null.
	 *
	 * @return the value of property roles
	 */
	public java.util.Set<ir.viratech.pond_ms.model.user.role.UserRole> getCreatedRoles() {
		if (null == getRoles()) this.setRoles(new java.util.HashSet<ir.viratech.pond_ms.model.user.role.UserRole>());
		return this.getRoles();
	}
	
	/**
	 * Adds a member to "roles".
	 * It creates the collection if it is null.
	 *
	 * @param userRole the new member to be added
	 */
	public void addToRoles(ir.viratech.pond_ms.model.user.role.UserRole userRole) {
		this.getCreatedRoles().add(userRole);
	}
	
	/**
	 * Adds a member to "roles".
	 * It creates the collection if it is null.
	 *
	 * @param userRole the new member to be added
	 * @deprecated Use {@link #addToRoles(ir.viratech.pond_ms.model.user.role.UserRole)} instead.
	 */
	@Deprecated
	public final void addToroles(ir.viratech.pond_ms.model.user.role.UserRole userRole) {
		this.addToRoles(userRole);
	}
	
	/**
	 * Removes a member from "roles".
	 * It does nothing if the collection is null.
	 *
	 * @param userRole the member to be removed
	 */
	public void removeFromRoles(ir.viratech.pond_ms.model.user.role.UserRole userRole) {
		if (null != this.getRoles()) {
			this.getRoles().remove(userRole);
		}
	}
	
	/**
	 * Adds a member to "roles" and synchronizes the reverse association.
	 *
	 * @param userRole the new member to be added
	 */
	public void addToRoles_AndReverse(ir.viratech.pond_ms.model.user.role.UserRole userRole) {
		this.addToRoles(userRole);
		userRole.addToUsers((ir.viratech.pond_ms.model.user.User)this);
	}
	
	/**
	 * Removes a member from "roles" and synchronizes the reverse association.
	 *
	 * @param userRole the member to be removed
	 */
	public void removeFromRoles_AndReverse(ir.viratech.pond_ms.model.user.role.UserRole userRole) {
		this.removeFromRoles(userRole);
		userRole.removeFromUsers((ir.viratech.pond_ms.model.user.User)this);
	}



	/**
	 * Getter for "reviews".
	 *
	 * @return the value of reviews
	 */
	public java.util.Set<ir.viratech.pond_ms.model.review.Review> getReviews() {
		return this.reviews;
	}

	/**
	 * Setter for property "reviews".
	 *
	 * @param reviews the new value for reviews
	 */
	public void setReviews(java.util.Set<ir.viratech.pond_ms.model.review.Review> reviews) {
		this.reviews = reviews;
	}
	/**
	 * Gets reviews, and creates and sets a new instance if it is null.
	 *
	 * @return the value of property reviews
	 */
	public java.util.Set<ir.viratech.pond_ms.model.review.Review> getCreatedReviews() {
		if (null == getReviews()) this.setReviews(new java.util.HashSet<ir.viratech.pond_ms.model.review.Review>());
		return this.getReviews();
	}
	
	/**
	 * Adds a member to "reviews".
	 * It creates the collection if it is null.
	 *
	 * @param review the new member to be added
	 */
	public void addToReviews(ir.viratech.pond_ms.model.review.Review review) {
		this.getCreatedReviews().add(review);
	}
	
	/**
	 * Adds a member to "reviews".
	 * It creates the collection if it is null.
	 *
	 * @param review the new member to be added
	 * @deprecated Use {@link #addToReviews(ir.viratech.pond_ms.model.review.Review)} instead.
	 */
	@Deprecated
	public final void addToreviews(ir.viratech.pond_ms.model.review.Review review) {
		this.addToReviews(review);
	}
	
	/**
	 * Removes a member from "reviews".
	 * It does nothing if the collection is null.
	 *
	 * @param review the member to be removed
	 */
	public void removeFromReviews(ir.viratech.pond_ms.model.review.Review review) {
		if (null != this.getReviews()) {
			this.getReviews().remove(review);
		}
	}
	
	/**
	 * Adds a member to "reviews" and synchronizes the reverse association.
	 *
	 * @param review the new member to be added
	 */
	public void addToReviews_AndReverse(ir.viratech.pond_ms.model.review.Review review) {
		this.addToReviews(review);
		review.setUser((ir.viratech.pond_ms.model.user.User)this);
	}
	
	/**
	 * Removes a member from "reviews" and synchronizes the reverse association.
	 *
	 * @param review the member to be removed
	 */
	public void removeFromReviews_AndReverse(ir.viratech.pond_ms.model.review.Review review) {
		this.removeFromReviews(review);
		review.setUser(null);
	}




	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (null == obj) return false;
		if (!(obj instanceof ir.viratech.pond_ms.model.user.User)) return false;
		else {
			ir.viratech.pond_ms.model.user.User user = (ir.viratech.pond_ms.model.user.User) obj;
			boolean isEqual = true;
			if (null == this.getExtuid() || null == user.getExtuid()) return false;
			else isEqual = isEqual && (this.getExtuid().equals(user.getExtuid()));
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