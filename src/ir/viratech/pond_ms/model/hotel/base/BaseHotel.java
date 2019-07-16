package ir.viratech.pond_ms.model.hotel.base;

import java.io.Serializable;


/**
 *  Base class for entity "ir.viratech.pond_ms.model.hotel.Hotel".
 *  It is an automatically generated file and should not be edited.
 *
 * @hibernate.class
 *  table="pond_ms.Hotels"
 */

public abstract class BaseHotel  implements Serializable {
	private static final long serialVersionUID = 1L;


	/** The constant referring the name of class "Hotel". */
	public static final String REF = "Hotel";
	
	/** The constant referring the property "id". */
	public static final String PROP_ID = "id";
	
	/** The constant referring the property "extuid". */
	public static final String PROP_EXTUID = "extuid";
	
	/** The constant referring the property "hotel_name". */
	public static final String PROP_HOTEL_NAME = "hotel_name";
	
	/** The constant referring the property "eghamat_name". */
	public static final String PROP_EGHAMAT_NAME = "eghamat_name";
	
	/** The constant referring the property "pintapin_name". */
	public static final String PROP_PINTAPIN_NAME = "pintapin_name";
	
	/** The constant referring the property "ariabooking_name". */
	public static final String PROP_ARIABOOKING_NAME = "ariabooking_name";
	
	/** The constant referring the property "hotelyar_name". */
	public static final String PROP_HOTELYAR_NAME = "hotelyar_name";
	
	/** The constant referring the property "hotelyar_code". */
	public static final String PROP_HOTELYAR_CODE = "hotelyar_code";
	
	/** The constant referring the property "iranhotelonline_name". */
	public static final String PROP_IRANHOTELONLINE_NAME = "iranhotelonline_name";
	
	/** The constant referring the property "iranhotelonline_code". */
	public static final String PROP_IRANHOTELONLINE_CODE = "iranhotelonline_code";
	
	
	/** The name of table for this class. */
	public static final String TABLE = "pond_ms.Hotels";
	
	/** Name of column referring the property "id". */
	public static final String PROPCOLUMN_ID = "id";
	
	/** Name of column referring the property "extuid". */
	public static final String PROPCOLUMN_EXTUID = "extuid";
	
	/** Name of column referring the property "hotel_name". */
	public static final String PROPCOLUMN_HOTEL_NAME = "hotel_name";
	
	/** Name of column referring the property "eghamat_name". */
	public static final String PROPCOLUMN_EGHAMAT_NAME = "eghamat_name";
	
	/** Name of column referring the property "pintapin_name". */
	public static final String PROPCOLUMN_PINTAPIN_NAME = "pintapin_name";
	
	/** Name of column referring the property "ariabooking_name". */
	public static final String PROPCOLUMN_ARIABOOKING_NAME = "ariabooking_name";
	
	/** Name of column referring the property "hotelyar_name". */
	public static final String PROPCOLUMN_HOTELYAR_NAME = "hotelyar_name";
	
	/** Name of column referring the property "hotelyar_code". */
	public static final String PROPCOLUMN_HOTELYAR_CODE = "hotelyar_code";
	
	/** Name of column referring the property "iranhotelonline_name". */
	public static final String PROPCOLUMN_IRANHOTELONLINE_NAME = "iranhotelonline_name";
	
	/** Name of column referring the property "iranhotelonline_code". */
	public static final String PROPCOLUMN_IRANHOTELONLINE_CODE = "iranhotelonline_code";
	
	

	
	
	


	private int hashCode_ = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
	private java.lang.String extuid;
	private java.lang.String hotel_name;
	private java.lang.String eghamat_name;
	private java.lang.String pintapin_name;
	private java.lang.String ariabooking_name;
	private java.lang.String hotelyar_name;
	private java.lang.String hotelyar_code;
	private java.lang.String iranhotelonline_name;
	private java.lang.String iranhotelonline_code;



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
	 * Getter for "hotel_name".
	 * column= hotel_name
	 *
	 * @return the value of hotel_name
	 */
	public java.lang.String getHotel_name() {
		return this.hotel_name;
	}

	/**
	 * Setter for property "hotel_name".
	 * column= hotel_name
	 *
	 * @param hotel_name the new value for hotel_name
	 */
	public void setHotel_name(java.lang.String hotel_name) {
		this.hotel_name = hotel_name;
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
	 * Getter for "pintapin_name".
	 * column= pintapin_name
	 *
	 * @return the value of pintapin_name
	 */
	public java.lang.String getPintapin_name() {
		return this.pintapin_name;
	}

	/**
	 * Setter for property "pintapin_name".
	 * column= pintapin_name
	 *
	 * @param pintapin_name the new value for pintapin_name
	 */
	public void setPintapin_name(java.lang.String pintapin_name) {
		this.pintapin_name = pintapin_name;
	}



	/**
	 * Getter for "ariabooking_name".
	 * column= ariabooking_name
	 *
	 * @return the value of ariabooking_name
	 */
	public java.lang.String getAriabooking_name() {
		return this.ariabooking_name;
	}

	/**
	 * Setter for property "ariabooking_name".
	 * column= ariabooking_name
	 *
	 * @param ariabooking_name the new value for ariabooking_name
	 */
	public void setAriabooking_name(java.lang.String ariabooking_name) {
		this.ariabooking_name = ariabooking_name;
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



	/**
	 * Getter for "iranhotelonline_name".
	 * column= iranhotelonline_name
	 *
	 * @return the value of iranhotelonline_name
	 */
	public java.lang.String getIranhotelonline_name() {
		return this.iranhotelonline_name;
	}

	/**
	 * Setter for property "iranhotelonline_name".
	 * column= iranhotelonline_name
	 *
	 * @param iranhotelonline_name the new value for iranhotelonline_name
	 */
	public void setIranhotelonline_name(java.lang.String iranhotelonline_name) {
		this.iranhotelonline_name = iranhotelonline_name;
	}



	/**
	 * Getter for "iranhotelonline_code".
	 * column= iranhotelonline_code
	 *
	 * @return the value of iranhotelonline_code
	 */
	public java.lang.String getIranhotelonline_code() {
		return this.iranhotelonline_code;
	}

	/**
	 * Setter for property "iranhotelonline_code".
	 * column= iranhotelonline_code
	 *
	 * @param iranhotelonline_code the new value for iranhotelonline_code
	 */
	public void setIranhotelonline_code(java.lang.String iranhotelonline_code) {
		this.iranhotelonline_code = iranhotelonline_code;
	}




	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (null == obj) return false;
		if (!(obj instanceof ir.viratech.pond_ms.model.hotel.Hotel)) return false;
		else {
			ir.viratech.pond_ms.model.hotel.Hotel hotel = (ir.viratech.pond_ms.model.hotel.Hotel) obj;
			boolean isEqual = true;
			if (null == this.getExtuid() || null == hotel.getExtuid()) return false;
			else isEqual = isEqual && (this.getExtuid().equals(hotel.getExtuid()));
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