package ir.viratech.pond_ms.model.organization.base;

import java.io.Serializable;


/**
 *  Base class for entity "ir.viratech.pond_ms.model.organization.Organization".
 *  It is an automatically generated file and should not be edited.
 *
 * @hibernate.class
 *  table="pond_ms.ORGANIZATIONS"
 */

public abstract class BaseOrganization  implements Serializable {
	private static final long serialVersionUID = 1L;


	/** The constant referring the name of class "Organization". */
	public static final String REF = "Organization";
	
	/** The constant referring the property "id". */
	public static final String PROP_ID = "id";
	
	/** The constant referring the property "extuid". */
	public static final String PROP_EXTUID = "extuid";
	
	/** The constant referring the property "name". */
	public static final String PROP_NAME = "name";
	
	/** The constant referring the property "code". */
	public static final String PROP_CODE = "code";
	
	/** The constant referring the property "parent". */
	public static final String PROP_PARENT = "parent";
	
	/** The constant referring the property "users". */
	public static final String PROP_USERS = "users";
	
	/** The constant referring the property "children". */
	public static final String PROP_CHILDREN = "children";
	
	
	/** The name of table for this class. */
	public static final String TABLE = "pond_ms.ORGANIZATIONS";
	
	/** Name of column referring the property "id". */
	public static final String PROPCOLUMN_ID = "id";
	
	/** Name of column referring the property "extuid". */
	public static final String PROPCOLUMN_EXTUID = "extuid";
	
	/** Name of column referring the property "name". */
	public static final String PROPCOLUMN_NAME = "name";
	
	/** Name of column referring the property "code". */
	public static final String PROPCOLUMN_CODE = "code";
	
	/** Name of column referring the property "parent". */
	public static final String PROPCOLUMN_PARENT = "parentId";
	
	

	
	
	


	private int hashCode_ = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
	private java.lang.String extuid;
	private java.lang.String name;
	private java.lang.String code;

	// many to one
	private ir.viratech.pond_ms.model.organization.Organization parent;

	// collections
	private java.util.Set<ir.viratech.pond_ms.model.user.User> users;
	private java.util.Set<ir.viratech.pond_ms.model.organization.Organization> children;



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
	 * Getter for "name".
	 * column= name
	 *
	 * @return the value of name
	 */
	public java.lang.String getName() {
		return this.name;
	}

	/**
	 * Setter for property "name".
	 * column= name
	 *
	 * @param name the new value for name
	 */
	public void setName(java.lang.String name) {
		this.name = name;
	}



	/**
	 * Getter for "code".
	 * column= code
	 *
	 * @return the value of code
	 */
	public java.lang.String getCode() {
		return this.code;
	}

	/**
	 * Setter for property "code".
	 * column= code
	 *
	 * @param code the new value for code
	 */
	public void setCode(java.lang.String code) {
		this.code = code;
	}



	/**
	 * Getter for "parent".
	 * column= parentId
	 *
	 * @return the value of parent
	 */
	public ir.viratech.pond_ms.model.organization.Organization getParent() {
		return this.parent;
	}

	/**
	 * Setter for property "parent".
	 * column= parentId
	 *
	 * @param parent the new value for parent
	 */
	public void setParent(ir.viratech.pond_ms.model.organization.Organization parent) {
		this.parent = parent;
	}



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
	 * Getter for "children".
	 *
	 * @return the value of children
	 */
	public java.util.Set<ir.viratech.pond_ms.model.organization.Organization> getChildren() {
		return this.children;
	}

	/**
	 * Setter for property "children".
	 *
	 * @param children the new value for children
	 */
	public void setChildren(java.util.Set<ir.viratech.pond_ms.model.organization.Organization> children) {
		this.children = children;
	}
	/**
	 * Gets children, and creates and sets a new instance if it is null.
	 *
	 * @return the value of property children
	 */
	public java.util.Set<ir.viratech.pond_ms.model.organization.Organization> getCreatedChildren() {
		if (null == getChildren()) this.setChildren(new java.util.HashSet<ir.viratech.pond_ms.model.organization.Organization>());
		return this.getChildren();
	}
	
	/**
	 * Adds a member to "children".
	 * It creates the collection if it is null.
	 *
	 * @param organization the new member to be added
	 */
	public void addToChildren(ir.viratech.pond_ms.model.organization.Organization organization) {
		this.getCreatedChildren().add(organization);
	}
	
	/**
	 * Adds a member to "children".
	 * It creates the collection if it is null.
	 *
	 * @param organization the new member to be added
	 * @deprecated Use {@link #addToChildren(ir.viratech.pond_ms.model.organization.Organization)} instead.
	 */
	@Deprecated
	public final void addTochildren(ir.viratech.pond_ms.model.organization.Organization organization) {
		this.addToChildren(organization);
	}
	
	/**
	 * Removes a member from "children".
	 * It does nothing if the collection is null.
	 *
	 * @param organization the member to be removed
	 */
	public void removeFromChildren(ir.viratech.pond_ms.model.organization.Organization organization) {
		if (null != this.getChildren()) {
			this.getChildren().remove(organization);
		}
	}
	
	/**
	 * Adds a member to "children" and synchronizes the reverse association.
	 *
	 * @param organization the new member to be added
	 */
	public void addToChildren_AndReverse(ir.viratech.pond_ms.model.organization.Organization organization) {
		this.addToChildren(organization);
		organization.setParent((ir.viratech.pond_ms.model.organization.Organization)this);
	}
	
	/**
	 * Removes a member from "children" and synchronizes the reverse association.
	 *
	 * @param organization the member to be removed
	 */
	public void removeFromChildren_AndReverse(ir.viratech.pond_ms.model.organization.Organization organization) {
		this.removeFromChildren(organization);
		organization.setParent(null);
	}




	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (null == obj) return false;
		if (!(obj instanceof ir.viratech.pond_ms.model.organization.Organization)) return false;
		else {
			ir.viratech.pond_ms.model.organization.Organization organization = (ir.viratech.pond_ms.model.organization.Organization) obj;
			boolean isEqual = true;
			if (null == this.getExtuid() || null == organization.getExtuid()) return false;
			else isEqual = isEqual && (this.getExtuid().equals(organization.getExtuid()));
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