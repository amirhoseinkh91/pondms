package ir.viratech.pond_ms.model.time_series.base;

import java.io.Serializable;


/**
 *  Base class for entity "ir.viratech.pond_ms.model.time_series.ParentCategory".
 *  It is an automatically generated file and should not be edited.
 *
 * @hibernate.class
 *  table="pond_ms.PARENT_CATEGORY"
 */

public abstract class BaseParentCategory extends ir.viratech.pond_ms.model.time_series.Category  implements Serializable {
	private static final long serialVersionUID = 1L;


	/** The constant referring the name of class "ParentCategory". */
	public static final String REF = "ParentCategory";
	
	/** The constant referring the property "id". */
	public static final String PROP_ID = "id";
	
	/** The constant referring the property "subCategories". */
	public static final String PROP_SUB_CATEGORIES = "subCategories";
	
	
	/** The name of table for this class. */
	public static final String TABLE = "pond_ms.PARENT_CATEGORY";
	
	/** Name of column referring the property "id". */
	public static final String PROPCOLUMN_ID = "id";
	
	

	
	
	


	private int hashCode_ = Integer.MIN_VALUE;


	// collections
	private java.util.List<ir.viratech.pond_ms.model.time_series.Category> subCategories;






	/**
	 * Getter for "subCategories".
	 *
	 * @return the value of subCategories
	 */
	public java.util.List<ir.viratech.pond_ms.model.time_series.Category> getSubCategories() {
		return this.subCategories;
	}

	/**
	 * Setter for property "subCategories".
	 *
	 * @param subCategories the new value for subCategories
	 */
	public void setSubCategories(java.util.List<ir.viratech.pond_ms.model.time_series.Category> subCategories) {
		this.subCategories = subCategories;
	}
	/**
	 * Gets subCategories, and creates and sets a new instance if it is null.
	 *
	 * @return the value of property subCategories
	 */
	public java.util.List<ir.viratech.pond_ms.model.time_series.Category> getCreatedSubCategories() {
		if (null == getSubCategories()) this.setSubCategories(new java.util.ArrayList<ir.viratech.pond_ms.model.time_series.Category>());
		return this.getSubCategories();
	}
	
	/**
	 * Adds a member to "subCategories".
	 * It creates the collection if it is null.
	 *
	 * @param category the new member to be added
	 */
	public void addToSubCategories(ir.viratech.pond_ms.model.time_series.Category category) {
		this.getCreatedSubCategories().add(category);
	}
	
	/**
	 * Adds a member to "subCategories".
	 * It creates the collection if it is null.
	 *
	 * @param category the new member to be added
	 * @deprecated Use {@link #addToSubCategories(ir.viratech.pond_ms.model.time_series.Category)} instead.
	 */
	@Deprecated
	public final void addTosubCategories(ir.viratech.pond_ms.model.time_series.Category category) {
		this.addToSubCategories(category);
	}
	
	/**
	 * Removes a member from "subCategories".
	 * It does nothing if the collection is null.
	 *
	 * @param category the member to be removed
	 */
	public void removeFromSubCategories(ir.viratech.pond_ms.model.time_series.Category category) {
		if (null != this.getSubCategories()) {
			this.getSubCategories().remove(category);
		}
	}




	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (null == obj) return false;
		if (!(obj instanceof ir.viratech.pond_ms.model.time_series.ParentCategory)) return false;
		else {
			ir.viratech.pond_ms.model.time_series.ParentCategory parentCategory = (ir.viratech.pond_ms.model.time_series.ParentCategory) obj;
			if (null == this.getId() || null == parentCategory.getId()) return false;
			else return (this.getId().equals(parentCategory.getId()));
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