package ir.viratech.pond_ms.model.customer.base;

import java.io.Serializable;


/**
 *  Base class for entity "ir.viratech.pond_ms.model.customer.CustomerViewedGISVectorObject".
 *  It is an automatically generated file and should not be edited.
 *
 * @hibernate.class
 *  table="pond_ms.CUSTOMER_VIEWED_GIS_VECTOR_OBJECTS"
 */

public abstract class BaseCustomerViewedGISVectorObject  implements Serializable {
	private static final long serialVersionUID = 1L;


	/** The constant referring the name of class "CustomerViewedGISVectorObject". */
	public static final String REF = "CustomerViewedGISVectorObject";
	
	/** The constant referring the property "id". */
	public static final String PROP_ID = "id";
	
	/** The constant referring the property "extuid". */
	public static final String PROP_EXTUID = "extuid";
	
	/** The constant referring the property "viewDate". */
	public static final String PROP_VIEW_DATE = "viewDate";
	
	/** The constant referring the property "customer". */
	public static final String PROP_CUSTOMER = "customer";
	
	/** The constant referring the property "gisVectorObject". */
	public static final String PROP_GIS_VECTOR_OBJECT = "gisVectorObject";
	
	
	/** The name of table for this class. */
	public static final String TABLE = "pond_ms.CUSTOMER_VIEWED_GIS_VECTOR_OBJECTS";
	
	/** Name of column referring the property "id". */
	public static final String PROPCOLUMN_ID = "id";
	
	/** Name of column referring the property "extuid". */
	public static final String PROPCOLUMN_EXTUID = "extuid";
	
	/** Name of column referring the property "viewDate". */
	public static final String PROPCOLUMN_VIEW_DATE = "viewDate";
	
	/** Name of column referring the property "customer". */
	public static final String PROPCOLUMN_CUSTOMER = "customerId";
	
	/** Name of column referring the property "gisVectorObject". */
	public static final String PROPCOLUMN_GIS_VECTOR_OBJECT = "gisVectorObjectId";
	
	

	
	
	


	private int hashCode_ = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
	private java.lang.String extuid;
	private java.util.Date viewDate;

	// many to one
	private ir.viratech.pond_ms.model.customer.Customer customer;
	private ir.viratech.pond_ms.model.map_object.vector.GISVectorObject gisVectorObject;



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
	 * Getter for "viewDate".
	 * column= viewDate
	 *
	 * @return the value of viewDate
	 */
	public java.util.Date getViewDate() {
		return this.viewDate;
	}

	/**
	 * Setter for property "viewDate".
	 * column= viewDate
	 *
	 * @param viewDate the new value for viewDate
	 */
	public void setViewDate(java.util.Date viewDate) {
		this.viewDate = viewDate;
	}



	/**
	 * Getter for "customer".
	 * column= customerId
	 *
	 * @return the value of customer
	 */
	public ir.viratech.pond_ms.model.customer.Customer getCustomer() {
		return this.customer;
	}

	/**
	 * Setter for property "customer".
	 * column= customerId
	 *
	 * @param customer the new value for customer
	 */
	public void setCustomer(ir.viratech.pond_ms.model.customer.Customer customer) {
		this.customer = customer;
	}



	/**
	 * Getter for "gisVectorObject".
	 * column= gisVectorObjectId
	 *
	 * @return the value of gisVectorObject
	 */
	public ir.viratech.pond_ms.model.map_object.vector.GISVectorObject getGisVectorObject() {
		return this.gisVectorObject;
	}

	/**
	 * Setter for property "gisVectorObject".
	 * column= gisVectorObjectId
	 *
	 * @param gisVectorObject the new value for gisVectorObject
	 */
	public void setGisVectorObject(ir.viratech.pond_ms.model.map_object.vector.GISVectorObject gisVectorObject) {
		this.gisVectorObject = gisVectorObject;
	}




	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (null == obj) return false;
		if (!(obj instanceof ir.viratech.pond_ms.model.customer.CustomerViewedGISVectorObject)) return false;
		else {
			ir.viratech.pond_ms.model.customer.CustomerViewedGISVectorObject customerViewedGISVectorObject = (ir.viratech.pond_ms.model.customer.CustomerViewedGISVectorObject) obj;
			boolean isEqual = true;
			if (null == this.getExtuid() || null == customerViewedGISVectorObject.getExtuid()) return false;
			else isEqual = isEqual && (this.getExtuid().equals(customerViewedGISVectorObject.getExtuid()));
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