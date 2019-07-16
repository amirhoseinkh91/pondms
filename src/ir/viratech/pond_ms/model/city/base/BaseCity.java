package ir.viratech.pond_ms.model.city.base;

import java.io.Serializable;


/**
 *  Base class for entity "ir.viratech.pond_ms.model.city.City".
 *  It is an automatically generated file and should not be edited.
 *
 * @hibernate.class
 *  table="pond_ms.Cities"
 */

public abstract class BaseCity  implements Serializable {
	private static final long serialVersionUID = 1L;


	/** The constant referring the name of class "City". */
	public static final String REF = "City";
	
	/** The constant referring the property "id". */
	public static final String PROP_ID = "id";
	
	/** The constant referring the property "extuid". */
	public static final String PROP_EXTUID = "extuid";
	
	/** The constant referring the property "city_name". */
	public static final String PROP_CITY_NAME = "city_name";
	
	/** The constant referring the property "flight_code". */
	public static final String PROP_FLIGHT_CODE = "flight_code";
	
	/** The constant referring the property "eghamat_name". */
	public static final String PROP_EGHAMAT_NAME = "eghamat_name";
	
	/** The constant referring the property "hotelyar_name". */
	public static final String PROP_HOTELYAR_NAME = "hotelyar_name";
	
	/** The constant referring the property "hotelyar_code". */
	public static final String PROP_HOTELYAR_CODE = "hotelyar_code";
	
	
	/** The name of table for this class. */
	public static final String TABLE = "pond_ms.Cities";
	
	/** Name of column referring the property "id". */
	public static final String PROPCOLUMN_ID = "id";
	
	/** Name of column referring the property "extuid". */
	public static final String PROPCOLUMN_EXTUID = "extuid";
	
	/** Name of column referring the property "city_name". */
	public static final String PROPCOLUMN_CITY_NAME = "city_name";
	
	/** Name of column referring the property "flight_code". */
	public static final String PROPCOLUMN_FLIGHT_CODE = "flight_code";
	
	/** Name of column referring the property "eghamat_name". */
	public static final String PROPCOLUMN_EGHAMAT_NAME = "eghamat_name";
	
	/** Name of column referring the property "hotelyar_name". */
	public static final String PROPCOLUMN_HOTELYAR_NAME = "hotelyar_name";
	
	/** Name of column referring the property "hotelyar_code". */
	public static final String PROPCOLUMN_HOTELYAR_CODE = "hotelyar_code";
	
	

	
	
	


	private int hashCode_ = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
	private java.lang.String extuid;
	private java.lang.String city_name;
	private java.lang.String flight_code;
	private java.lang.String eghamat_name;
	private java.lang.String hotelyar_name;
	private java.lang.String hotelyar_code;



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
	 * Getter for "city_name".
	 * column= city_name
	 *
	 * @return the value of city_name
	 */
	public java.lang.String getCity_name() {
		return this.city_name;
	}

	/**
	 * Setter for property "city_name".
	 * column= city_name
	 *
	 * @param city_name the new value for city_name
	 */
	public void setCity_name(java.lang.String city_name) {
		this.city_name = city_name;
	}



	/**
	 * Getter for "flight_code".
	 * column= flight_code
	 *
	 * @return the value of flight_code
	 */
	public java.lang.String getFlight_code() {
		return this.flight_code;
	}

	/**
	 * Setter for property "flight_code".
	 * column= flight_code
	 *
	 * @param flight_code the new value for flight_code
	 */
	public void setFlight_code(java.lang.String flight_code) {
		this.flight_code = flight_code;
	}



	/**
	 * Getter for "eghamat_name".
	 * column= eghamat_name
	 *
	 * @return the value of eghamat_name
	 */
	public java.lang.String getEghamat_name() {
		return this.eghamat_name;
	}

	/**
	 * Setter for property "eghamat_name".
	 * column= eghamat_name
	 *
	 * @param eghamat_name the new value for eghamat_name
	 */
	public void setEghamat_name(java.lang.String eghamat_name) {
		this.eghamat_name = eghamat_name;
	}



	/**
	 * Getter for "hotelyar_name".
	 * column= hotelyar_name
	 *
	 * @return the value of hotelyar_name
	 */
	public java.lang.String getHotelyar_name() {
		return this.hotelyar_name;
	}

	/**
	 * Setter for property "hotelyar_name".
	 * column= hotelyar_name
	 *
	 * @param hotelyar_name the new value for hotelyar_name
	 */
	public void setHotelyar_name(java.lang.String hotelyar_name) {
		this.hotelyar_name = hotelyar_name;
	}



	/**
	 * Getter for "hotelyar_code".
	 * column= hotelyar_code
	 *
	 * @return the value of hotelyar_code
	 */
	public java.lang.String getHotelyar_code() {
		return this.hotelyar_code;
	}

	/**
	 * Setter for property "hotelyar_code".
	 * column= hotelyar_code
	 *
	 * @param hotelyar_code the new value for hotelyar_code
	 */
	public void setHotelyar_code(java.lang.String hotelyar_code) {
		this.hotelyar_code = hotelyar_code;
	}




	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (null == obj) return false;
		if (!(obj instanceof ir.viratech.pond_ms.model.city.City)) return false;
		else {
			ir.viratech.pond_ms.model.city.City city = (ir.viratech.pond_ms.model.city.City) obj;
			boolean isEqual = true;
			if (null == this.getExtuid() || null == city.getExtuid()) return false;
			else isEqual = isEqual && (this.getExtuid().equals(city.getExtuid()));
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