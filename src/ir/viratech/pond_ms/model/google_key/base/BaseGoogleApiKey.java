package ir.viratech.pond_ms.model.google_key.base;

import java.io.Serializable;


/**
 *  Base class for entity "ir.viratech.pond_ms.model.google_key.GoogleApiKey".
 *  It is an automatically generated file and should not be edited.
 *
 * @hibernate.class
 *  table="pond_ms.Google_Api_Keys"
 */

public abstract class BaseGoogleApiKey  implements Serializable {
	private static final long serialVersionUID = 1L;


	/** The constant referring the name of class "GoogleApiKey". */
	public static final String REF = "GoogleApiKey";
	
	/** The constant referring the property "id". */
	public static final String PROP_ID = "id";
	
	/** The constant referring the property "extuid". */
	public static final String PROP_EXTUID = "extuid";
	
	/** The constant referring the property "key". */
	public static final String PROP_KEY = "key";
	
	/** The constant referring the property "lastUsedDate". */
	public static final String PROP_LAST_USED_DATE = "lastUsedDate";
	
	/** The constant referring the property "usedCounter". */
	public static final String PROP_USED_COUNTER = "usedCounter";
	
	/** The constant referring the property "busy". */
	public static final String PROP_BUSY = "busy";
	
	
	/** The name of table for this class. */
	public static final String TABLE = "pond_ms.Google_Api_Keys";
	
	/** Name of column referring the property "id". */
	public static final String PROPCOLUMN_ID = "id";
	
	/** Name of column referring the property "extuid". */
	public static final String PROPCOLUMN_EXTUID = "extuid";
	
	/** Name of column referring the property "key". */
	public static final String PROPCOLUMN_KEY = "key";
	
	/** Name of column referring the property "lastUsedDate". */
	public static final String PROPCOLUMN_LAST_USED_DATE = "last_used_date";
	
	/** Name of column referring the property "usedCounter". */
	public static final String PROPCOLUMN_USED_COUNTER = "usedCounter";
	
	/** Name of column referring the property "busy". */
	public static final String PROPCOLUMN_BUSY = "busy";
	
	

	
	
	


	private int hashCode_ = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
	private java.lang.String extuid;
	private java.lang.String key;
	private java.util.Date lastUsedDate;
	private java.lang.Integer usedCounter;
	private boolean busy;



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
	 * Getter for "key".
	 * column= key
	 *
	 * @return the value of key
	 */
	public java.lang.String getKey() {
		return this.key;
	}

	/**
	 * Setter for property "key".
	 * column= key
	 *
	 * @param key the new value for key
	 */
	public void setKey(java.lang.String key) {
		this.key = key;
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



	/**
	 * Getter for "usedCounter".
	 * column= usedCounter
	 *
	 * @return the value of usedCounter
	 */
	public java.lang.Integer getUsedCounter() {
		return this.usedCounter;
	}

	/**
	 * Setter for property "usedCounter".
	 * column= usedCounter
	 *
	 * @param usedCounter the new value for usedCounter
	 */
	public void setUsedCounter(java.lang.Integer usedCounter) {
		this.usedCounter = usedCounter;
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




	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (null == obj) return false;
		if (!(obj instanceof ir.viratech.pond_ms.model.google_key.GoogleApiKey)) return false;
		else {
			ir.viratech.pond_ms.model.google_key.GoogleApiKey googleApiKey = (ir.viratech.pond_ms.model.google_key.GoogleApiKey) obj;
			boolean isEqual = true;
			if (null == this.getExtuid() || null == googleApiKey.getExtuid()) return false;
			else isEqual = isEqual && (this.getExtuid().equals(googleApiKey.getExtuid()));
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