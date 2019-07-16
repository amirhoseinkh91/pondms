package ir.viratech.pond_ms.model.user.role.base;

import java.io.Serializable;


/**
 *  Base class for entity "ir.viratech.pond_ms.model.user.role.Role".
 *  It is an automatically generated file and should not be edited.
 *
 * @hibernate.class
 *  table="pond_ms.ROLES"
 */

public abstract class BaseRole  implements Serializable {
	private static final long serialVersionUID = 1L;


	/** The constant referring the name of class "Role". */
	public static final String REF = "Role";
	
	/** The constant referring the property "id". */
	public static final String PROP_ID = "id";
	
	/** The constant referring the property "extuid". */
	public static final String PROP_EXTUID = "extuid";
	
	/** The constant referring the property "name". */
	public static final String PROP_NAME = "name";
	
	/** The constant referring the property "description". */
	public static final String PROP_DESCRIPTION = "description";
	
	/** The constant referring the property "userDefined". */
	public static final String PROP_USER_DEFINED = "userDefined";
	
	/** The constant referring the property "availableFeatures". */
	public static final String PROP_AVAILABLE_FEATURES = "availableFeatures";
	
	
	/** The name of table for this class. */
	public static final String TABLE = "pond_ms.ROLES";
	
	/** Name of column referring the property "id". */
	public static final String PROPCOLUMN_ID = "id";
	
	/** Name of column referring the property "extuid". */
	public static final String PROPCOLUMN_EXTUID = "extuid";
	
	/** Name of column referring the property "name". */
	public static final String PROPCOLUMN_NAME = "name";
	
	/** Name of column referring the property "description". */
	public static final String PROPCOLUMN_DESCRIPTION = "description";
	
	/** Name of column referring the property "userDefined". */
	public static final String PROPCOLUMN_USER_DEFINED = "userDefined";
	
	/** Name of table referring the property "availableFeatures". */
	public static final String PROPTABLE_AVAILABLE_FEATURES = "pond_ms.ROLE_FEATURES";
	
	

	
	
	


	private int hashCode_ = Integer.MIN_VALUE;

	// primary key
	private long id;

	// fields
	private java.lang.String extuid;
	private java.lang.String name;
	private java.lang.String description;
	private boolean userDefined;

	// collections
	private java.util.Set<ir.viratech.pond_ms.model.user.Feature> availableFeatures;



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
	 * Getter for "availableFeatures".
	 *
	 * @return the value of availableFeatures
	 */
	public java.util.Set<ir.viratech.pond_ms.model.user.Feature> getAvailableFeatures() {
		return this.availableFeatures;
	}

	/**
	 * Setter for property "availableFeatures".
	 *
	 * @param availableFeatures the new value for availableFeatures
	 */
	public void setAvailableFeatures(java.util.Set<ir.viratech.pond_ms.model.user.Feature> availableFeatures) {
		this.availableFeatures = availableFeatures;
	}
	/**
	 * Gets availableFeatures, and creates and sets a new instance if it is null.
	 *
	 * @return the value of property availableFeatures
	 */
	public java.util.Set<ir.viratech.pond_ms.model.user.Feature> getCreatedAvailableFeatures() {
		if (null == getAvailableFeatures()) this.setAvailableFeatures(new java.util.HashSet<ir.viratech.pond_ms.model.user.Feature>());
		return this.getAvailableFeatures();
	}
	
	/**
	 * Adds a member to "availableFeatures".
	 * It creates the collection if it is null.
	 *
	 * @param feature the new member to be added
	 */
	public void addToAvailableFeatures(ir.viratech.pond_ms.model.user.Feature feature) {
		this.getCreatedAvailableFeatures().add(feature);
	}
	
	/**
	 * Adds a member to "availableFeatures".
	 * It creates the collection if it is null.
	 *
	 * @param feature the new member to be added
	 * @deprecated Use {@link #addToAvailableFeatures(ir.viratech.pond_ms.model.user.Feature)} instead.
	 */
	@Deprecated
	public final void addToavailableFeatures(ir.viratech.pond_ms.model.user.Feature feature) {
		this.addToAvailableFeatures(feature);
	}
	
	/**
	 * Removes a member from "availableFeatures".
	 * It does nothing if the collection is null.
	 *
	 * @param feature the member to be removed
	 */
	public void removeFromAvailableFeatures(ir.viratech.pond_ms.model.user.Feature feature) {
		if (null != this.getAvailableFeatures()) {
			this.getAvailableFeatures().remove(feature);
		}
	}
	
	/**
	 * Adds a member to "availableFeatures" and synchronizes the reverse association.
	 *
	 * @param feature the new member to be added
	 */
	public void addToAvailableFeatures_AndReverse(ir.viratech.pond_ms.model.user.Feature feature) {
		this.addToAvailableFeatures(feature);
		feature.addToUsingRoles((ir.viratech.pond_ms.model.user.role.Role)this);
	}
	
	/**
	 * Removes a member from "availableFeatures" and synchronizes the reverse association.
	 *
	 * @param feature the member to be removed
	 */
	public void removeFromAvailableFeatures_AndReverse(ir.viratech.pond_ms.model.user.Feature feature) {
		this.removeFromAvailableFeatures(feature);
		feature.removeFromUsingRoles((ir.viratech.pond_ms.model.user.role.Role)this);
	}




	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (null == obj) return false;
		if (!(obj instanceof ir.viratech.pond_ms.model.user.role.Role)) return false;
		else {
			ir.viratech.pond_ms.model.user.role.Role role = (ir.viratech.pond_ms.model.user.role.Role) obj;
			boolean isEqual = true;
			if (null == this.getExtuid() || null == role.getExtuid()) return false;
			else isEqual = isEqual && (this.getExtuid().equals(role.getExtuid()));
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