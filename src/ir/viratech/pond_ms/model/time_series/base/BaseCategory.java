package ir.viratech.pond_ms.model.time_series.base;

import java.io.Serializable;


/**
 *  Base class for entity "ir.viratech.pond_ms.model.time_series.Category".
 *  It is an automatically generated file and should not be edited.
 *
 * @hibernate.class
 *  table="pond_ms.CATEGORY"
 */

public abstract class BaseCategory  implements Serializable {
	private static final long serialVersionUID = 1L;


	/** The constant referring the name of class "Category". */
	public static final String REF = "Category";
	
	/** The constant referring the property "id". */
	public static final String PROP_ID = "id";
	
	/** The constant referring the property "extuid". */
	public static final String PROP_EXTUID = "extuid";
	
	/** The constant referring the property "name". */
	public static final String PROP_NAME = "name";
	
	/** The constant referring the property "indexInParent". */
	public static final String PROP_INDEX_IN_PARENT = "indexInParent";
	
	
	/** The name of table for this class. */
	public static final String TABLE = "pond_ms.CATEGORY";
	
	/** Name of column referring the property "id". */
	public static final String PROPCOLUMN_ID = "id";
	
	/** Name of column referring the property "extuid". */
	public static final String PROPCOLUMN_EXTUID = "extuid";
	
	/** Name of column referring the property "name". */
	public static final String PROPCOLUMN_NAME = "name";
	
	/** Name of column referring the property "indexInParent". */
	public static final String PROPCOLUMN_INDEX_IN_PARENT = "index_in_parent";
	
	

	
	
	


	private int hashCode_ = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
	private java.lang.String extuid;
	private java.lang.String name;
	private java.lang.Integer indexInParent;



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
	 * Getter for "indexInParent".
	 * column= index_in_parent
	 *
	 * @return the value of indexInParent
	 */
	public java.lang.Integer getIndexInParent() {
		return this.indexInParent;
	}

	/**
	 * Setter for property "indexInParent".
	 * column= index_in_parent
	 *
	 * @param indexInParent the new value for indexInParent
	 */
	public void setIndexInParent(java.lang.Integer indexInParent) {
		this.indexInParent = indexInParent;
	}




	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (null == obj) return false;
		if (!(obj instanceof ir.viratech.pond_ms.model.time_series.Category)) return false;
		else {
			ir.viratech.pond_ms.model.time_series.Category category = (ir.viratech.pond_ms.model.time_series.Category) obj;
			boolean isEqual = true;
			if (null == this.getExtuid() || null == category.getExtuid()) return false;
			else isEqual = isEqual && (this.getExtuid().equals(category.getExtuid()));
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