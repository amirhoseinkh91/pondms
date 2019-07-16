package ir.viratech.pond_ms.model.time_series.base;

import java.io.Serializable;


/**
 *  Base class for entity "ir.viratech.pond_ms.model.time_series.LeafCategory".
 *  It is an automatically generated file and should not be edited.
 *
 * @hibernate.class
 *  table="pond_ms.LEAF_CATEGORY"
 */

public abstract class BaseLeafCategory extends ir.viratech.pond_ms.model.time_series.Category  implements Serializable {
	private static final long serialVersionUID = 1L;


	/** The constant referring the name of class "LeafCategory". */
	public static final String REF = "LeafCategory";
	
	/** The constant referring the property "id". */
	public static final String PROP_ID = "id";
	
	/** The constant referring the property "timeSeriesValueType". */
	public static final String PROP_TIME_SERIES_VALUE_TYPE = "timeSeriesValueType";
	
	/** The constant referring the property "timeSeriesValues". */
	public static final String PROP_TIME_SERIES_VALUES = "timeSeriesValues";
	
	
	/** The name of table for this class. */
	public static final String TABLE = "pond_ms.LEAF_CATEGORY";
	
	/** Name of column referring the property "id". */
	public static final String PROPCOLUMN_ID = "id";
	
	/** Name of column referring the property "timeSeriesValueType". */
	public static final String PROPCOLUMN_TIME_SERIES_VALUE_TYPE = "timeSeriesValueType";
	
	/** Name of table referring the property "timeSeriesValues". */
	public static final String PROPTABLE_TIME_SERIES_VALUES = "pond_ms.TIME_SERIES_DATE_VALUE_PAIR";
	
	

	
	
	


	private int hashCode_ = Integer.MIN_VALUE;


	// fields
	private java.lang.String timeSeriesValueType;

	// collections
	private java.util.Set<ir.viratech.pond_ms.model.time_series.TimeSeriesDateValuePair> timeSeriesValues;






	/**
	 * Getter for "timeSeriesValueType".
	 * column= timeSeriesValueType
	 *
	 * @return the value of timeSeriesValueType
	 */
	public java.lang.String getTimeSeriesValueType() {
		return this.timeSeriesValueType;
	}

	/**
	 * Setter for property "timeSeriesValueType".
	 * column= timeSeriesValueType
	 *
	 * @param timeSeriesValueType the new value for timeSeriesValueType
	 */
	public void setTimeSeriesValueType(java.lang.String timeSeriesValueType) {
		this.timeSeriesValueType = timeSeriesValueType;
	}



	/**
	 * Getter for "timeSeriesValues".
	 *
	 * @return the value of timeSeriesValues
	 */
	public java.util.Set<ir.viratech.pond_ms.model.time_series.TimeSeriesDateValuePair> getTimeSeriesValues() {
		return this.timeSeriesValues;
	}

	/**
	 * Setter for property "timeSeriesValues".
	 *
	 * @param timeSeriesValues the new value for timeSeriesValues
	 */
	public void setTimeSeriesValues(java.util.Set<ir.viratech.pond_ms.model.time_series.TimeSeriesDateValuePair> timeSeriesValues) {
		this.timeSeriesValues = timeSeriesValues;
	}
	/**
	 * Gets timeSeriesValues, and creates and sets a new instance if it is null.
	 *
	 * @return the value of property timeSeriesValues
	 */
	public java.util.Set<ir.viratech.pond_ms.model.time_series.TimeSeriesDateValuePair> getCreatedTimeSeriesValues() {
		if (null == getTimeSeriesValues()) this.setTimeSeriesValues(new java.util.HashSet<ir.viratech.pond_ms.model.time_series.TimeSeriesDateValuePair>());
		return this.getTimeSeriesValues();
	}
	
	/**
	 * Adds a member to "timeSeriesValues".
	 * It creates the collection if it is null.
	 *
	 * @param timeSeriesDateValuePair the new member to be added
	 */
	public void addToTimeSeriesValues(ir.viratech.pond_ms.model.time_series.TimeSeriesDateValuePair timeSeriesDateValuePair) {
		this.getCreatedTimeSeriesValues().add(timeSeriesDateValuePair);
	}
	
	/**
	 * Adds a member to "timeSeriesValues".
	 * It creates the collection if it is null.
	 *
	 * @param timeSeriesDateValuePair the new member to be added
	 * @deprecated Use {@link #addToTimeSeriesValues(ir.viratech.pond_ms.model.time_series.TimeSeriesDateValuePair)} instead.
	 */
	@Deprecated
	public final void addTotimeSeriesValues(ir.viratech.pond_ms.model.time_series.TimeSeriesDateValuePair timeSeriesDateValuePair) {
		this.addToTimeSeriesValues(timeSeriesDateValuePair);
	}
	
	/**
	 * Removes a member from "timeSeriesValues".
	 * It does nothing if the collection is null.
	 *
	 * @param timeSeriesDateValuePair the member to be removed
	 */
	public void removeFromTimeSeriesValues(ir.viratech.pond_ms.model.time_series.TimeSeriesDateValuePair timeSeriesDateValuePair) {
		if (null != this.getTimeSeriesValues()) {
			this.getTimeSeriesValues().remove(timeSeriesDateValuePair);
		}
	}




	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (null == obj) return false;
		if (!(obj instanceof ir.viratech.pond_ms.model.time_series.LeafCategory)) return false;
		else {
			ir.viratech.pond_ms.model.time_series.LeafCategory leafCategory = (ir.viratech.pond_ms.model.time_series.LeafCategory) obj;
			if (null == this.getId() || null == leafCategory.getId()) return false;
			else return (this.getId().equals(leafCategory.getId()));
		}
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		if (Integer.MIN_VALUE == this.hashCode_) {
			if (null == this.getId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getId().hashCode();
				this.hashCode_ = hashStr.hashCode();
			}
		}
		return this.hashCode_;
	}


	



}