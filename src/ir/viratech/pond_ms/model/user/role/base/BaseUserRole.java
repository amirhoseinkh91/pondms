package ir.viratech.pond_ms.model.user.role.base;

import java.io.Serializable;


/**
 *  Base class for entity "ir.viratech.pond_ms.model.user.role.UserRole".
 *  It is an automatically generated file and should not be edited.
 *
 * @hibernate.class
 *  table="pond_ms.ROLES"
 */

public abstract class BaseUserRole extends ir.viratech.pond_ms.model.user.role.Role  implements Serializable {
	private static final long serialVersionUID = 1L;


	/** The constant referring the name of class "UserRole". */
	public static final String REF = "UserRole";
	
	/** The constant referring the property "id". */
	public static final String PROP_ID = "id";
	
	/** The constant referring the property "users". */
	public static final String PROP_USERS = "users";
	
	
	/** The name of table for this class. */
	public static final String TABLE = "pond_ms.ROLES";
	
	/** Name of column referring the property "id". */
	public static final String PROPCOLUMN_ID = "id";
	
	/** Name of table referring the property "users". */
	public static final String PROPTABLE_USERS = "pond_ms.USER_ROLES";
	
	

	
	
	


	private int hashCode_ = Integer.MIN_VALUE;


	// collections
	private java.util.Set<ir.viratech.pond_ms.model.user.User> users;






	/**
	 * Getter for "users".
	 *
	 * @return the value of users
	 */
	public java.util.Set<ir.viratech.pond_ms.model.user.User> getUsers() {
		return this.users;
	}

	/**
	 * Setter for property "users".
	 *
	 * @param users the new value for users
	 */
	public void setUsers(java.util.Set<ir.viratech.pond_ms.model.user.User> users) {
		this.users = users;
	}
	/**
	 * Gets users, and creates and sets a new instance if it is null.
	 *
	 * @return the value of property users
	 */
	public java.util.Set<ir.viratech.pond_ms.model.user.User> getCreatedUsers() {
		if (null == getUsers()) this.setUsers(new java.util.HashSet<ir.viratech.pond_ms.model.user.User>());
		return this.getUsers();
	}
	
	/**
	 * Adds a member to "users".
	 * It creates the collection if it is null.
	 *
	 * @param user the new member to be added
	 */
	public void addToUsers(ir.viratech.pond_ms.model.user.User user) {
		this.getCreatedUsers().add(user);
	}
	
	/**
	 * Adds a member to "users".
	 * It creates the collection if it is null.
	 *
	 * @param user the new member to be added
	 * @deprecated Use {@link #addToUsers(ir.viratech.pond_ms.model.user.User)} instead.
	 */
	@Deprecated
	public final void addTousers(ir.viratech.pond_ms.model.user.User user) {
		this.addToUsers(user);
	}
	
	/**
	 * Removes a member from "users".
	 * It does nothing if the collection is null.
	 *
	 * @param user the member to be removed
	 */
	public void removeFromUsers(ir.viratech.pond_ms.model.user.User user) {
		if (null != this.getUsers()) {
			this.getUsers().remove(user);
		}
	}
	
	/**
	 * Adds a member to "users" and synchronizes the reverse association.
	 *
	 * @param user the new member to be added
	 */
	public void addToUsers_AndReverse(ir.viratech.pond_ms.model.user.User user) {
		this.addToUsers(user);
		user.addToRoles((ir.viratech.pond_ms.model.user.role.UserRole)this);
	}
	
	/**
	 * Removes a member from "users" and synchronizes the reverse association.
	 *
	 * @param user the member to be removed
	 */
	public void removeFromUsers_AndReverse(ir.viratech.pond_ms.model.user.User user) {
		this.removeFromUsers(user);
		user.removeFromRoles((ir.viratech.pond_ms.model.user.role.UserRole)this);
	}




	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (null == obj) return false;
		if (!(obj instanceof ir.viratech.pond_ms.model.user.role.UserRole)) return false;
		else {
			ir.viratech.pond_ms.model.user.role.UserRole userRole = (ir.viratech.pond_ms.model.user.role.UserRole) obj;
			return (this.getId() == userRole.getId());
		}
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		if (Integer.MIN_VALUE == this.hashCode_) {
			return (int) this.getId();
		}
		return this.hashCode_;
	}


	



}