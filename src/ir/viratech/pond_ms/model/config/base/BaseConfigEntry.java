package ir.viratech.pond_ms.model.config.base;

import java.io.Serializable;


/**
 *  Base class for entity "ir.viratech.pond_ms.model.config.ConfigEntry".
 *  It is an automatically generated file and should not be edited.
 *
 * @hibernate.class
 *  table="pond_ms.CONFIG_ENTRIES"
 */

public abstract class BaseConfigEntry  implements Serializable {
	private static final long serialVersionUID = 1L;


	/** The constant referring the name of class "ConfigEntry". */
	public static final String REF = "ConfigEntry";
	
	/** The constant referring the property "id". */
	public static final String PROP_ID = "id";
	
	/** The constant referring the property "extuid". */
	public static final String PROP_EXTUID = "extuid";
	
	/** The constant referring the property "title". */
	public static final String PROP_TITLE = "title";
	
	/** The constant referring the property "key". */
	public static final String PROP_KEY = "key";
	
	/** The constant referring the property "value". */
	public static final String PROP_VALUE = "value";
	
	
	/** The name of table for this class. */
	public static final String TABLE = "pond_ms.CONFIG_ENTRIES";
	
	/** Name of column referring the property "id". */
	public static final String PROPCOLUMN_ID = "id";
	
	/** Name of column referring the property "extuid". */
	public static final String PROPCOLUMN_EXTUID = "extuid";
	
	/** Name of column referring the property "title". */
	public static final String PROPCOLUMN_TITLE = "title";
	
	/** Name of column referring the property "key". */
	public static final String PROPCOLUMN_KEY = "configKey";
	
	/** Name of column referring the property "value". */
	public static final String PROPCOLUMN_VALUE = "configValue";
	
	

	
	
	


	private int hashCode_ = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
	private java.lang.String extuid;
	private java.lang.String title;
	private java.lang.String key;
	private java.lang.String value;



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
	 * Getter for "title".
	 * column= title
	 *
	 * @return the value of title
	 */
	public java.lang.String getTitle() {
		return this.title;
	}

	/**
	 * Setter for property "title".
	 * column= title
	 *
	 * @param title the new value for title
	 */
	public void setTitle(java.lang.String title) {
		this.title = title;
	}



	/**
	 * Getter for "key".
	 * column= configKey
	 *
	 * @return the value of key
	 */
	public java.lang.String getKey() {
		return this.key;
	}

	/**
	 * Setter for property "key".
	 * column= configKey
	 *
	 * @param key the new value for key
	 */
	public void setKey(java.lang.String key) {
		this.key = key;
	}



	/**
	 * Getter for "value".
	 * column= configValue
	 *
	 * @return the value of value
	 */
	public java.lang.String getValue() {
		return this.value;
	}

	/**
	 * Setter for property "value".
	 * column= configValue
	 *
	 * @param value the new value for value
	 */
	public void setValue(java.lang.String value) {
		this.value = value;
	}




	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (null == obj) return false;
		if (!(obj instanceof ir.viratech.pond_ms.model.config.ConfigEntry)) return false;
		else {
			ir.viratech.pond_ms.model.config.ConfigEntry configEntry = (ir.viratech.pond_ms.model.config.ConfigEntry) obj;
			boolean isEqual = true;
			if (null == this.getExtuid() || null == configEntry.getExtuid()) return false;
			else isEqual = isEqual && (this.getExtuid().equals(configEntry.getExtuid()));
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