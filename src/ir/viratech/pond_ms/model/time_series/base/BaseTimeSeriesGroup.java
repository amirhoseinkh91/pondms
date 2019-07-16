package ir.viratech.pond_ms.model.time_series.base;

import java.io.Serializable;


/**
 *  Base class for entity "ir.viratech.pond_ms.model.time_series.TimeSeriesGroup".
 *  It is an automatically generated file and should not be edited.
 *
 * @hibernate.class
 *  table="pond_ms.TIME_SERIES_GROUP"
 */

public abstract class BaseTimeSeriesGroup  implements Serializable {
	private static final long serialVersionUID = 1L;


	/** The constant referring the name of class "TimeSeriesGroup". */
	public static final String REF = "TimeSeriesGroup";
	
	/** The constant referring the property "id". */
	public static final String PROP_ID = "id";
	
	/** The constant referring the property "extuid". */
	public static final String PROP_EXTUID = "extuid";
	
	/** The constant referring the property "name". */
	public static final String PROP_NAME = "name";
	
	/** The constant referring the property "description". */
	public static final String PROP_DESCRIPTION = "description";
	
	
	/** The name of table for this class. */
	public static final String TABLE = "pond_ms.TIME_SERIES_GROUP";
	
	/** Name of column referring the property "id". */
	public static final String PROPCOLUMN_ID = "id";
	
	/** Name of column referring the property "extuid". */
	public static final String PROPCOLUMN_EXTUID = "extuid";
	
	/** Name of column referring the property "name". */
	public static final String PROPCOLUMN_NAME = "name";
	
	/** Name of column referring the property "description". */
	public static final String PROPCOLUMN_DESCRIPTION = "description";
	
	

	
	
	


	private int hashCode_ = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
	private java.lang.String extuid;
	private java.lang.String name;
	private java.lang.String description;



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




	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (null == obj) return false;
		if (!(obj instanceof ir.viratech.pond_ms.model.time_series.TimeSeriesGroup)) return false;
		else {
			ir.viratech.pond_ms.model.time_series.TimeSeriesGroup timeSeriesGroup = (ir.viratech.pond_ms.model.time_series.TimeSeriesGroup) obj;
			boolean isEqual = true;
			if (null == this.getExtuid() || null == timeSeriesGroup.getExtuid()) return false;
			else isEqual = isEqual && (this.getExtuid().equals(timeSeriesGroup.getExtuid()));
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