package ir.viratech.pond_ms.model.customer.base;

import java.io.Serializable;


/**
 *  Base class for entity "ir.viratech.pond_ms.model.customer.Customer".
 *  It is an automatically generated file and should not be edited.
 *
 * @hibernate.class
 *  table="pond_ms.CUSTOMERS"
 */

public abstract class BaseCustomer  implements Serializable {
	private static final long serialVersionUID = 1L;


	/** The constant referring the name of class "Customer". */
	public static final String REF = "Customer";
	
	/** The constant referring the property "id". */
	public static final String PROP_ID = "id";
	
	/** The constant referring the property "extuid". */
	public static final String PROP_EXTUID = "extuid";
	
	/** The constant referring the property "phoneNumber". */
	public static final String PROP_PHONE_NUMBER = "phoneNumber";
	
	/** The constant referring the property "email". */
	public static final String PROP_EMAIL = "email";
	
	/** The constant referring the property "biography". */
	public static final String PROP_BIOGRAPHY = "biography";
	
	/** The constant referring the property "name". */
	public static final String PROP_NAME = "name";
	
	/** The constant referring the property "age". */
	public static final String PROP_AGE = "age";
	
	/** The constant referring the property "gender". */
	public static final String PROP_GENDER = "gender";
	
	/** The constant referring the property "locality". */
	public static final String PROP_LOCALITY = "locality";
	
	/** The constant referring the property "lotteryCode". */
	public static final String PROP_LOTTERY_CODE = "lotteryCode";
	
	/** The constant referring the property "user". */
	public static final String PROP_USER = "user";
	
	/** The constant referring the property "viewdGisVectorObjects". */
	public static final String PROP_VIEWD_GIS_VECTOR_OBJECTS = "viewdGisVectorObjects";
	
	/** The constant referring the property "favoriteGisVectorObjects". */
	public static final String PROP_FAVORITE_GIS_VECTOR_OBJECTS = "favoriteGisVectorObjects";
	
	
	/** The name of table for this class. */
	public static final String TABLE = "pond_ms.CUSTOMERS";
	
	/** Name of column referring the property "id". */
	public static final String PROPCOLUMN_ID = "id";
	
	/** Name of column referring the property "extuid". */
	public static final String PROPCOLUMN_EXTUID = "extuid";
	
	/** Name of column referring the property "phoneNumber". */
	public static final String PROPCOLUMN_PHONE_NUMBER = "phoneNumber";
	
	/** Name of column referring the property "email". */
	public static final String PROPCOLUMN_EMAIL = "email";
	
	/** Name of column referring the property "biography". */
	public static final String PROPCOLUMN_BIOGRAPHY = "biography";
	
	/** Name of column referring the property "name". */
	public static final String PROPCOLUMN_NAME = "name";
	
	/** Name of column referring the property "age". */
	public static final String PROPCOLUMN_AGE = "age";
	
	/** Name of column referring the property "gender". */
	public static final String PROPCOLUMN_GENDER = "gender";
	
	/** Name of column referring the property "locality". */
	public static final String PROPCOLUMN_LOCALITY = "locality";
	
	/** Name of column referring the property "lotteryCode". */
	public static final String PROPCOLUMN_LOTTERY_CODE = "lotteryCode";
	
	/** Name of column referring the property "user". */
	public static final String PROPCOLUMN_USER = "userId";
	
	

	
	
	


	private int hashCode_ = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
	private java.lang.String extuid;
	private java.lang.String phoneNumber;
	private java.lang.String email;
	private java.lang.String biography;
	private java.lang.String name;
	private java.lang.String age;
	private java.lang.String gender;
	private java.lang.String locality;
	private java.lang.String lotteryCode;

	// many to one
	private ir.viratech.pond_ms.model.user.User user;

	// collections
	private java.util.Set<ir.viratech.pond_ms.model.customer.CustomerViewedGISVectorObject> viewdGisVectorObjects;
	private java.util.Set<ir.viratech.pond_ms.model.customer.CustomerFavoriteGISVectorObject> favoriteGisVectorObjects;



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
	 * Getter for "email".
	 * column= email
	 *
	 * @return the value of email
	 */
	public java.lang.String getEmail() {
		return this.email;
	}

	/**
	 * Setter for property "email".
	 * column= email
	 *
	 * @param email the new value for email
	 */
	public void setEmail(java.lang.String email) {
		this.email = email;
	}



	/**
	 * Getter for "biography".
	 * column= biography
	 *
	 * @return the value of biography
	 */
	public java.lang.String getBiography() {
		return this.biography;
	}

	/**
	 * Setter for property "biography".
	 * column= biography
	 *
	 * @param biography the new value for biography
	 */
	public void setBiography(java.lang.String biography) {
		this.biography = biography;
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
	 * Getter for "age".
	 * column= age
	 *
	 * @return the value of age
	 */
	public java.lang.String getAge() {
		return this.age;
	}

	/**
	 * Setter for property "age".
	 * column= age
	 *
	 * @param age the new value for age
	 */
	public void setAge(java.lang.String age) {
		this.age = age;
	}



	/**
	 * Getter for "gender".
	 * column= gender
	 *
	 * @return the value of gender
	 */
	public java.lang.String getGender() {
		return this.gender;
	}

	/**
	 * Setter for property "gender".
	 * column= gender
	 *
	 * @param gender the new value for gender
	 */
	public void setGender(java.lang.String gender) {
		this.gender = gender;
	}



	/**
	 * Getter for "locality".
	 * column= locality
	 *
	 * @return the value of locality
	 */
	public java.lang.String getLocality() {
		return this.locality;
	}

	/**
	 * Setter for property "locality".
	 * column= locality
	 *
	 * @param locality the new value for locality
	 */
	public void setLocality(java.lang.String locality) {
		this.locality = locality;
	}



	/**
	 * Getter for "lotteryCode".
	 * column= lotteryCode
	 *
	 * @return the value of lotteryCode
	 */
	public java.lang.String getLotteryCode() {
		return this.lotteryCode;
	}

	/**
	 * Setter for property "lotteryCode".
	 * column= lotteryCode
	 *
	 * @param lotteryCode the new value for lotteryCode
	 */
	public void setLotteryCode(java.lang.String lotteryCode) {
		this.lotteryCode = lotteryCode;
	}



	/**
	 * Getter for "user".
	 * column= userId
	 *
	 * @return the value of user
	 */
	public ir.viratech.pond_ms.model.user.User getUser() {
		return this.user;
	}

	/**
	 * Setter for property "user".
	 * column= userId
	 *
	 * @param user the new value for user
	 */
	public void setUser(ir.viratech.pond_ms.model.user.User user) {
		this.user = user;
	}



	/**
	 * Getter for "viewdGisVectorObjects".
	 *
	 * @return the value of viewdGisVectorObjects
	 */
	public java.util.Set<ir.viratech.pond_ms.model.customer.CustomerViewedGISVectorObject> getViewdGisVectorObjects() {
		return this.viewdGisVectorObjects;
	}

	/**
	 * Setter for property "viewdGisVectorObjects".
	 *
	 * @param viewdGisVectorObjects the new value for viewdGisVectorObjects
	 */
	public void setViewdGisVectorObjects(java.util.Set<ir.viratech.pond_ms.model.customer.CustomerViewedGISVectorObject> viewdGisVectorObjects) {
		this.viewdGisVectorObjects = viewdGisVectorObjects;
	}
	/**
	 * Gets viewdGisVectorObjects, and creates and sets a new instance if it is null.
	 *
	 * @return the value of property viewdGisVectorObjects
	 */
	public java.util.Set<ir.viratech.pond_ms.model.customer.CustomerViewedGISVectorObject> getCreatedViewdGisVectorObjects() {
		if (null == getViewdGisVectorObjects()) this.setViewdGisVectorObjects(new java.util.HashSet<ir.viratech.pond_ms.model.customer.CustomerViewedGISVectorObject>());
		return this.getViewdGisVectorObjects();
	}
	
	/**
	 * Adds a member to "viewdGisVectorObjects".
	 * It creates the collection if it is null.
	 *
	 * @param customerViewedGISVectorObject the new member to be added
	 */
	public void addToViewdGisVectorObjects(ir.viratech.pond_ms.model.customer.CustomerViewedGISVectorObject customerViewedGISVectorObject) {
		this.getCreatedViewdGisVectorObjects().add(customerViewedGISVectorObject);
	}
	
	/**
	 * Adds a member to "viewdGisVectorObjects".
	 * It creates the collection if it is null.
	 *
	 * @param customerViewedGISVectorObject the new member to be added
	 * @deprecated Use {@link #addToViewdGisVectorObjects(ir.viratech.pond_ms.model.customer.CustomerViewedGISVectorObject)} instead.
	 */
	@Deprecated
	public final void addToviewdGisVectorObjects(ir.viratech.pond_ms.model.customer.CustomerViewedGISVectorObject customerViewedGISVectorObject) {
		this.addToViewdGisVectorObjects(customerViewedGISVectorObject);
	}
	
	/**
	 * Removes a member from "viewdGisVectorObjects".
	 * It does nothing if the collection is null.
	 *
	 * @param customerViewedGISVectorObject the member to be removed
	 */
	public void removeFromViewdGisVectorObjects(ir.viratech.pond_ms.model.customer.CustomerViewedGISVectorObject customerViewedGISVectorObject) {
		if (null != this.getViewdGisVectorObjects()) {
			this.getViewdGisVectorObjects().remove(customerViewedGISVectorObject);
		}
	}



	/**
	 * Getter for "favoriteGisVectorObjects".
	 *
	 * @return the value of favoriteGisVectorObjects
	 */
	public java.util.Set<ir.viratech.pond_ms.model.customer.CustomerFavoriteGISVectorObject> getFavoriteGisVectorObjects() {
		return this.favoriteGisVectorObjects;
	}

	/**
	 * Setter for property "favoriteGisVectorObjects".
	 *
	 * @param favoriteGisVectorObjects the new value for favoriteGisVectorObjects
	 */
	public void setFavoriteGisVectorObjects(java.util.Set<ir.viratech.pond_ms.model.customer.CustomerFavoriteGISVectorObject> favoriteGisVectorObjects) {
		this.favoriteGisVectorObjects = favoriteGisVectorObjects;
	}
	/**
	 * Gets favoriteGisVectorObjects, and creates and sets a new instance if it is null.
	 *
	 * @return the value of property favoriteGisVectorObjects
	 */
	public java.util.Set<ir.viratech.pond_ms.model.customer.CustomerFavoriteGISVectorObject> getCreatedFavoriteGisVectorObjects() {
		if (null == getFavoriteGisVectorObjects()) this.setFavoriteGisVectorObjects(new java.util.HashSet<ir.viratech.pond_ms.model.customer.CustomerFavoriteGISVectorObject>());
		return this.getFavoriteGisVectorObjects();
	}
	
	/**
	 * Adds a member to "favoriteGisVectorObjects".
	 * It creates the collection if it is null.
	 *
	 * @param customerFavoriteGISVectorObject the new member to be added
	 */
	public void addToFavoriteGisVectorObjects(ir.viratech.pond_ms.model.customer.CustomerFavoriteGISVectorObject customerFavoriteGISVectorObject) {
		this.getCreatedFavoriteGisVectorObjects().add(customerFavoriteGISVectorObject);
	}
	
	/**
	 * Adds a member to "favoriteGisVectorObjects".
	 * It creates the collection if it is null.
	 *
	 * @param customerFavoriteGISVectorObject the new member to be added
	 * @deprecated Use {@link #addToFavoriteGisVectorObjects(ir.viratech.pond_ms.model.customer.CustomerFavoriteGISVectorObject)} instead.
	 */
	@Deprecated
	public final void addTofavoriteGisVectorObjects(ir.viratech.pond_ms.model.customer.CustomerFavoriteGISVectorObject customerFavoriteGISVectorObject) {
		this.addToFavoriteGisVectorObjects(customerFavoriteGISVectorObject);
	}
	
	/**
	 * Removes a member from "favoriteGisVectorObjects".
	 * It does nothing if the collection is null.
	 *
	 * @param customerFavoriteGISVectorObject the member to be removed
	 */
	public void removeFromFavoriteGisVectorObjects(ir.viratech.pond_ms.model.customer.CustomerFavoriteGISVectorObject customerFavoriteGISVectorObject) {
		if (null != this.getFavoriteGisVectorObjects()) {
			this.getFavoriteGisVectorObjects().remove(customerFavoriteGISVectorObject);
		}
	}




	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (null == obj) return false;
		if (!(obj instanceof ir.viratech.pond_ms.model.customer.Customer)) return false;
		else {
			ir.viratech.pond_ms.model.customer.Customer customer = (ir.viratech.pond_ms.model.customer.Customer) obj;
			boolean isEqual = true;
			if (null == this.getExtuid() || null == customer.getExtuid()) return false;
			else isEqual = isEqual && (this.getExtuid().equals(customer.getExtuid()));
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