package ir.viratech.pond_ms.model.gradient.base;

import java.io.Serializable;


/**
 *  Base class for entity "ir.viratech.pond_ms.model.gradient.Gradient".
 *  It is an automatically generated file and should not be edited.
 *
 * @hibernate.class
 *  table="pond_ms.GRADIENTS"
 */

public abstract class BaseGradient  implements Serializable {
	private static final long serialVersionUID = 1L;


	/** The constant referring the name of class "Gradient". */
	public static final String REF = "Gradient";
	
	/** The constant referring the property "id". */
	public static final String PROP_ID = "id";
	
	/** The constant referring the property "extuid". */
	public static final String PROP_EXTUID = "extuid";
	
	/** The constant referring the property "title". */
	public static final String PROP_TITLE = "title";
	
	/** The constant referring the property "stops". */
	public static final String PROP_STOPS = "stops";
	
	
	/** The name of table for this class. */
	public static final String TABLE = "pond_ms.GRADIENTS";
	
	/** Name of column referring the property "id". */
	public static final String PROPCOLUMN_ID = "id";
	
	/** Name of column referring the property "extuid". */
	public static final String PROPCOLUMN_EXTUID = "extuid";
	
	/** Name of column referring the property "title". */
	public static final String PROPCOLUMN_TITLE = "title";
	
	

	
	
	


	private int hashCode_ = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
	private java.lang.String extuid;
	private java.lang.String title;

	// collections
	private java.util.Map stops;



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
	 * Getter for "stops".
	 *
	 * @return the value of stops
	 */
	public java.util.Map getStops() {
		return this.stops;
	}

	/**
	 * Setter for property "stops".
	 *
	 * @param stops the new value for stops
	 */
	public void setStops(java.util.Map stops) {
		this.stops = stops;
	}




	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (null == obj) return false;
		if (!(obj instanceof ir.viratech.pond_ms.model.gradient.Gradient)) return false;
		else {
			ir.viratech.pond_ms.model.gradient.Gradient gradient = (ir.viratech.pond_ms.model.gradient.Gradient) obj;
			boolean isEqual = true;
			if (null == this.getExtuid() || null == gradient.getExtuid()) return false;
			else isEqual = isEqual && (this.getExtuid().equals(gradient.getExtuid()));
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