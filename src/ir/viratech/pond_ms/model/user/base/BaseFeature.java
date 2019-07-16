package ir.viratech.pond_ms.model.user.base;

import java.io.Serializable;


/**
 *  Base class for entity "ir.viratech.pond_ms.model.user.Feature".
 *  It is an automatically generated file and should not be edited.
 *
 * @hibernate.class
 *  table="pond_ms.FEATURES"
 */

public abstract class BaseFeature  implements Serializable {
	private static final long serialVersionUID = 1L;


	/** The constant referring the name of class "Feature". */
	public static final String REF = "Feature";
	
	/** The constant referring the property "id". */
	public static final String PROP_ID = "id";
	
	/** The constant referring the property "extuid". */
	public static final String PROP_EXTUID = "extuid";
	
	/** The constant referring the property "name". */
	public static final String PROP_NAME = "name";
	
	/** The constant referring the property "description". */
	public static final String PROP_DESCRIPTION = "description";
	
	/** The constant referring the property "exposable". */
	public static final String PROP_EXPOSABLE = "exposable";
	
	/** The constant referring the property "usingRoles". */
	public static final String PROP_USING_ROLES = "usingRoles";
	
	
	/** The name of table for this class. */
	public static final String TABLE = "pond_ms.FEATURES";
	
	/** Name of column referring the property "id". */
	public static final String PROPCOLUMN_ID = "id";
	
	/** Name of column referring the property "extuid". */
	public static final String PROPCOLUMN_EXTUID = "extuid";
	
	/** Name of column referring the property "name". */
	public static final String PROPCOLUMN_NAME = "name";
	
	/** Name of column referring the property "description". */
	public static final String PROPCOLUMN_DESCRIPTION = "description";
	
	/** Name of column referring the property "exposable". */
	public static final String PROPCOLUMN_EXPOSABLE = "exposable";
	
	/** Name of table referring the property "usingRoles". */
	public static final String PROPTABLE_USING_ROLES = "pond_ms.ROLE_FEATURES";
	
	

	
	
	


	private int hashCode_ = Integer.MIN_VALUE;

	// primary key
	private long id;

	// fields
	private java.lang.String extuid;
	private java.lang.String name;
	private java.lang.String description;
	private boolean exposable;

	// collections
	private java.util.Set<ir.viratech.pond_ms.model.user.role.Role> usingRoles;



	/**
	 * Returns the identifier.
	 * 
	 * @return the value of id
     * @hibernate.id
     *  generator-class="increment"
     *  column="id"
     */
	public long getId() {
		return id;
	}

	/**
	 * Set the identifier.
	 * 
	 * @param id the new value of id
	 */
	public void setId(long id) {
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
	 * Getter for "description".
	 * column= description
	 *
	 * @return the value of description
	 */
	public java.lang.String getDescription() {
		return this.description;
	}

	/**
	 * Setter for property "description".
	 * column= description
	 *
	 * @param description the new value for description
	 */
	public void setDescription(java.lang.String description) {
		this.description = description;
	}



	/**
	 * Getter for "exposable".
	 * column= exposable
	 *
	 * @return the value of exposable
	 */
	public boolean isExposable() {
		return this.exposable;
	}

	/**
	 * Setter for property "exposable".
	 * column= exposable
	 *
	 * @param exposable the new value for exposable
	 */
	public void setExposable(boolean exposable) {
		this.exposable = exposable;
	}



	/**
	 * Getter for "usingRoles".
	 *
	 * @return the value of usingRoles
	 */
	public java.util.Set<ir.viratech.pond_ms.model.user.role.Role> getUsingRoles() {
		return this.usingRoles;
	}

	/**
	 * Setter for property "usingRoles".
	 *
	 * @param usingRoles the new value for usingRoles
	 */
	public void setUsingRoles(java.util.Set<ir.viratech.pond_ms.model.user.role.Role> usingRoles) {
		this.usingRoles = usingRoles;
	}
	/**
	 * Gets usingRoles, and creates and sets a new instance if it is null.
	 *
	 * @return the value of property usingRoles
	 */
	public java.util.Set<ir.viratech.pond_ms.model.user.role.Role> getCreatedUsingRoles() {
		if (null == getUsingRoles()) this.setUsingRoles(new java.util.HashSet<ir.viratech.pond_ms.model.user.role.Role>());
		return this.getUsingRoles();
	}
	
	/**
	 * Adds a member to "usingRoles".
	 * It creates the collection if it is null.
	 *
	 * @param role the new member to be added
	 */
	public void addToUsingRoles(ir.viratech.pond_ms.model.user.role.Role role) {
		this.getCreatedUsingRoles().add(role);
	}
	
	/**
	 * Adds a member to "usingRoles".
	 * It creates the collection if it is null.
	 *
	 * @param role the new member to be added
	 * @deprecated Use {@link #addToUsingRoles(ir.viratech.pond_ms.model.user.role.Role)} instead.
	 */
	@Deprecated
	public final void addTousingRoles(ir.viratech.pond_ms.model.user.role.Role role) {
		this.addToUsingRoles(role);
	}
	
	/**
	 * Removes a member from "usingRoles".
	 * It does nothing if the collection is null.
	 *
	 * @param role the member to be removed
	 */
	public void removeFromUsingRoles(ir.viratech.pond_ms.model.user.role.Role role) {
		if (null != this.getUsingRoles()) {
			this.getUsingRoles().remove(role);
		}
	}
	
	/**
	 * Adds a member to "usingRoles" and synchronizes the reverse association.
	 *
	 * @param role the new member to be added
	 */
	public void addToUsingRoles_AndReverse(ir.viratech.pond_ms.model.user.role.Role role) {
		this.addToUsingRoles(role);
		role.addToAvailableFeatures((ir.viratech.pond_ms.model.user.Feature)this);
	}
	
	/**
	 * Removes a member from "usingRoles" and synchronizes the reverse association.
	 *
	 * @param role the member to be removed
	 */
	public void removeFromUsingRoles_AndReverse(ir.viratech.pond_ms.model.user.role.Role role) {
		this.removeFromUsingRoles(role);
		role.removeFromAvailableFeatures((ir.viratech.pond_ms.model.user.Feature)this);
	}




	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (null == obj) return false;
		if (!(obj instanceof ir.viratech.pond_ms.model.user.Feature)) return false;
		else {
			ir.viratech.pond_ms.model.user.Feature feature = (ir.viratech.pond_ms.model.user.Feature) obj;
			boolean isEqual = true;
			if (null == this.getExtuid() || null == feature.getExtuid()) return false;
			else isEqual = isEqual && (this.getExtuid().equals(feature.getExtuid()));
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