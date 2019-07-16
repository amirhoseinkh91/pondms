package ir.viratech.pond_ms.model.foursquare.base;

import java.io.Serializable;


/**
 *  Base class for entity "ir.viratech.pond_ms.model.foursquare.FoursquareKey".
 *  It is an automatically generated file and should not be edited.
 *
 * @hibernate.class
 *  table="foursquare.FOURSQUARE_KEYS"
 */

public abstract class BaseFoursquareKey  implements Serializable {
	private static final long serialVersionUID = 1L;


	/** The constant referring the name of class "FoursquareKey". */
	public static final String REF = "FoursquareKey";
	
	/** The constant referring the property "id". */
	public static final String PROP_ID = "id";
	
	/** The constant referring the property "extuid". */
	public static final String PROP_EXTUID = "extuid";
	
	/** The constant referring the property "clientId". */
	public static final String PROP_CLIENT_ID = "clientId";
	
	/** The constant referring the property "clientSecret". */
	public static final String PROP_CLIENT_SECRET = "clientSecret";
	
	/** The constant referring the property "usedCount". */
	public static final String PROP_USED_COUNT = "usedCount";
	
	/** The constant referring the property "maxUsage". */
	public static final String PROP_MAX_USAGE = "maxUsage";
	
	/** The constant referring the property "busy". */
	public static final String PROP_BUSY = "busy";
	
	/** The constant referring the property "lastUsedDate". */
	public static final String PROP_LAST_USED_DATE = "lastUsedDate";
	
	
	/** The name of table for this class. */
	public static final String TABLE = "foursquare.FOURSQUARE_KEYS";
	
	/** Name of column referring the property "id". */
	public static final String PROPCOLUMN_ID = "id";
	
	/** Name of column referring the property "extuid". */
	public static final String PROPCOLUMN_EXTUID = "extuid";
	
	/** Name of column referring the property "clientId". */
	public static final String PROPCOLUMN_CLIENT_ID = "client_id";
	
	/** Name of column referring the property "clientSecret". */
	public static final String PROPCOLUMN_CLIENT_SECRET = "client_secret";
	
	/** Name of column referring the property "usedCount". */
	public static final String PROPCOLUMN_USED_COUNT = "used_count";
	
	/** Name of column referring the property "maxUsage". */
	public static final String PROPCOLUMN_MAX_USAGE = "max_usage";
	
	/** Name of column referring the property "busy". */
	public static final String PROPCOLUMN_BUSY = "busy";
	
	/** Name of column referring the property "lastUsedDate". */
	public static final String PROPCOLUMN_LAST_USED_DATE = "last_used_date";
	
	

	
	
	


	private int hashCode_ = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
	private java.lang.String extuid;
	private java.lang.String clientId;
	private java.lang.String clientSecret;
	private java.lang.Integer usedCount;
	private java.lang.Integer maxUsage;
	private boolean busy;
	private java.util.Date lastUsedDate;



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
	 * Getter for "clientId".
	 * column= client_id
	 *
	 * @return the value of clientId
	 */
	public java.lang.String getClientId() {
		return this.clientId;
	}

	/**
	 * Setter for property "clientId".
	 * column= client_id
	 *
	 * @param clientId the new value for clientId
	 */
	public void setClientId(java.lang.String clientId) {
		this.clientId = clientId;
	}



	/**
	 * Getter for "clientSecret".
	 * column= client_secret
	 *
	 * @return the value of clientSecret
	 */
	public java.lang.String getClientSecret() {
		return this.clientSecret;
	}

	/**
	 * Setter for property "clientSecret".
	 * column= client_secret
	 *
	 * @param clientSecret the new value for clientSecret
	 */
	public void setClientSecret(java.lang.String clientSecret) {
		this.clientSecret = clientSecret;
	}



	/**
	 * Getter for "usedCount".
	 * column= used_count
	 *
	 * @return the value of usedCount
	 */
	public java.lang.Integer getUsedCount() {
		return this.usedCount;
	}

	/**
	 * Setter for property "usedCount".
	 * column= used_count
	 *
	 * @param usedCount the new value for usedCount
	 */
	public void setUsedCount(java.lang.Integer usedCount) {
		this.usedCount = usedCount;
	}



	/**
	 * Getter for "maxUsage".
	 * column= max_usage
	 *
	 * @return the value of maxUsage
	 */
	public java.lang.Integer getMaxUsage() {
		return this.maxUsage;
	}

	/**
	 * Setter for property "maxUsage".
	 * column= max_usage
	 *
	 * @param maxUsage the new value for maxUsage
	 */
	public void setMaxUsage(java.lang.Integer maxUsage) {
		this.maxUsage = maxUsage;
	}



	/**
	 * Getter for "busy".
	 * column= busy
	 *
	 * @return the value of busy
	 */
	public boolean isBusy() {
		return this.busy;
	}

	/**
	 * Setter for property "busy".
	 * column= busy
	 *
	 * @param busy the new value for busy
	 */
	public void setBusy(boolean busy) {
		this.busy = busy;
	}



	/**
	 * Getter for "lastUsedDate".
	 * column= last_used_date
	 *
	 * @return the value of lastUsedDate
	 */
	public java.util.Date getLastUsedDate() {
		return this.lastUsedDate;
	}

	/**
	 * Setter for property "lastUsedDate".
	 * column= last_used_date
	 *
	 * @param lastUsedDate the new value for lastUsedDate
	 */
	public void setLastUsedDate(java.util.Date lastUsedDate) {
		this.lastUsedDate = lastUsedDate;
	}




	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (null == obj) return false;
		if (!(obj instanceof ir.viratech.pond_ms.model.foursquare.FoursquareKey)) return false;
		else {
			ir.viratech.pond_ms.model.foursquare.FoursquareKey foursquareKey = (ir.viratech.pond_ms.model.foursquare.FoursquareKey) obj;
			boolean isEqual = true;
			if (null == this.getExtuid() || null == foursquareKey.getExtuid()) return false;
			else isEqual = isEqual && (this.getExtuid().equals(foursquareKey.getExtuid()));
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