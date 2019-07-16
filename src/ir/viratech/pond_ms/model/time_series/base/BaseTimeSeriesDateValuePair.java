package ir.viratech.pond_ms.model.time_series.base;

import java.io.Serializable;


/**
 *  Base class for entity "ir.viratech.pond_ms.model.time_series.TimeSeriesDateValuePair".
 *  It is an automatically generated file and should not be edited.
 *
 * @hibernate.class
 *  table="pond_ms.TIME_SERIES_DATE_VALUE_PAIR"
 */

public abstract class BaseTimeSeriesDateValuePair  implements Serializable {
	private static final long serialVersionUID = 1L;


	/** The constant referring the name of class "TimeSeriesDateValuePair". */
	public static final String REF = "TimeSeriesDateValuePair";
	
	/** The constant referring the property "id". */
	public static final String PROP_ID = "id";
	
	/** The constant referring the property "extuid". */
	public static final String PROP_EXTUID = "extuid";
	
	/** The constant referring the property "submissionTime". */
	public static final String PROP_SUBMISSION_TIME = "submissionTime";
	
	/** The constant referring the property "timeSeriValue". */
	public static final String PROP_TIME_SERI_VALUE = "timeSeriValue";
	
	
	/** The name of table for this class. */
	public static final String TABLE = "pond_ms.TIME_SERIES_DATE_VALUE_PAIR";
	
	/** Name of column referring the property "id". */
	public static final String PROPCOLUMN_ID = "id";
	
	/** Name of column referring the property "extuid". */
	public static final String PROPCOLUMN_EXTUID = "extuid";
	
	/** Name of column referring the property "submissionTime". */
	public static final String PROPCOLUMN_SUBMISSION_TIME = "submissionTime";
	
	/** Name of column referring the property "timeSeriValue". */
	public static final String PROPCOLUMN_TIME_SERI_VALUE = "timeSeriValue";
	
	

	
	
	


	private int hashCode_ = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
	private java.lang.String extuid;
	private long submissionTime;
	private java.lang.String timeSeriValue;



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
	 * Getter for "submissionTime".
	 * column= submissionTime
	 *
	 * @return the value of submissionTime
	 */
	public long getSubmissionTime() {
		return this.submissionTime;
	}

	/**
	 * Setter for property "submissionTime".
	 * column= submissionTime
	 *
	 * @param submissionTime the new value for submissionTime
	 */
	public void setSubmissionTime(long submissionTime) {
		this.submissionTime = submissionTime;
	}



	/**
	 * Getter for "timeSeriValue".
	 * column= timeSeriValue
	 *
	 * @return the value of timeSeriValue
	 */
	public java.lang.String getTimeSeriValue() {
		return this.timeSeriValue;
	}

	/**
	 * Setter for property "timeSeriValue".
	 * column= timeSeriValue
	 *
	 * @param timeSeriValue the new value for timeSeriValue
	 */
	public void setTimeSeriValue(java.lang.String timeSeriValue) {
		this.timeSeriValue = timeSeriValue;
	}




	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (null == obj) return false;
		if (!(obj instanceof ir.viratech.pond_ms.model.time_series.TimeSeriesDateValuePair)) return false;
		else {
			ir.viratech.pond_ms.model.time_series.TimeSeriesDateValuePair timeSeriesDateValuePair = (ir.viratech.pond_ms.model.time_series.TimeSeriesDateValuePair) obj;
			boolean isEqual = true;
			if (null == this.getExtuid() || null == timeSeriesDateValuePair.getExtuid()) return false;
			else isEqual = isEqual && (this.getExtuid().equals(timeSeriesDateValuePair.getExtuid()));
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