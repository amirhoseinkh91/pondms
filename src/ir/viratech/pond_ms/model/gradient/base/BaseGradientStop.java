package ir.viratech.pond_ms.model.gradient.base;

import java.io.Serializable;


/**
 *  Base class for entity "ir.viratech.pond_ms.model.gradient.GradientStop".
 *  It is an automatically generated file and should not be edited.
 *
 * @hibernate.class
 *  table="pond_ms.GRADIENT_STOPS"
 */

public abstract class BaseGradientStop  implements Serializable {
	private static final long serialVersionUID = 1L;


	/** The constant referring the name of class "GradientStop". */
	public static final String REF = "GradientStop";
	
	/** The constant referring the property "id". */
	public static final String PROP_ID = "id";
	
	/** The constant referring the property "extuid". */
	public static final String PROP_EXTUID = "extuid";
	
	/** The constant referring the property "red". */
	public static final String PROP_RED = "red";
	
	/** The constant referring the property "green". */
	public static final String PROP_GREEN = "green";
	
	/** The constant referring the property "blue". */
	public static final String PROP_BLUE = "blue";
	
	
	/** The name of table for this class. */
	public static final String TABLE = "pond_ms.GRADIENT_STOPS";
	
	/** Name of column referring the property "id". */
	public static final String PROPCOLUMN_ID = "id";
	
	/** Name of column referring the property "extuid". */
	public static final String PROPCOLUMN_EXTUID = "extuid";
	
	/** Name of column referring the property "red". */
	public static final String PROPCOLUMN_RED = "red";
	
	/** Name of column referring the property "green". */
	public static final String PROPCOLUMN_GREEN = "green";
	
	/** Name of column referring the property "blue". */
	public static final String PROPCOLUMN_BLUE = "blue";
	
	

	
	
	


	private int hashCode_ = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
	private java.lang.String extuid;
	private double red;
	private double green;
	private double blue;



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
	 * Getter for "red".
	 * column= red
	 *
	 * @return the value of red
	 */
	public double getRed() {
		return this.red;
	}

	/**
	 * Setter for property "red".
	 * column= red
	 *
	 * @param red the new value for red
	 */
	public void setRed(double red) {
		this.red = red;
	}



	/**
	 * Getter for "green".
	 * column= green
	 *
	 * @return the value of green
	 */
	public double getGreen() {
		return this.green;
	}

	/**
	 * Setter for property "green".
	 * column= green
	 *
	 * @param green the new value for green
	 */
	public void setGreen(double green) {
		this.green = green;
	}



	/**
	 * Getter for "blue".
	 * column= blue
	 *
	 * @return the value of blue
	 */
	public double getBlue() {
		return this.blue;
	}

	/**
	 * Setter for property "blue".
	 * column= blue
	 *
	 * @param blue the new value for blue
	 */
	public void setBlue(double blue) {
		this.blue = blue;
	}




	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (null == obj) return false;
		if (!(obj instanceof ir.viratech.pond_ms.model.gradient.GradientStop)) return false;
		else {
			ir.viratech.pond_ms.model.gradient.GradientStop gradientStop = (ir.viratech.pond_ms.model.gradient.GradientStop) obj;
			boolean isEqual = true;
			if (null == this.getExtuid() || null == gradientStop.getExtuid()) return false;
			else isEqual = isEqual && (this.getExtuid().equals(gradientStop.getExtuid()));
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