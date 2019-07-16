package ir.viratech.pond_ms.model.layer.base;

import java.io.Serializable;


/**
 *  Base class for entity "ir.viratech.pond_ms.model.layer.Pond".
 *  It is an automatically generated file and should not be edited.
 *
 * @hibernate.class
 *  table="pond_ms.PONDS"
 */

public abstract class BasePond  implements Serializable {
	private static final long serialVersionUID = 1L;


	/** The constant referring the name of class "Pond". */
	public static final String REF = "Pond";
	
	/** The constant referring the property "id". */
	public static final String PROP_ID = "id";
	
	/** The constant referring the property "extuid". */
	public static final String PROP_EXTUID = "extuid";
	
	/** The constant referring the property "title". */
	public static final String PROP_TITLE = "title";
	
	/** The constant referring the property "generalFormUID_public". */
	public static final String PROP_GENERAL_FORM_U_I_D_PUBLIC = "generalFormUID_public";
	
	/** The constant referring the property "descriptiveFormUID_public". */
	public static final String PROP_DESCRIPTIVE_FORM_U_I_D_PUBLIC = "descriptiveFormUID_public";
	
	/** The constant referring the property "tabularFormUID_public". */
	public static final String PROP_TABULAR_FORM_U_I_D_PUBLIC = "tabularFormUID_public";
	
	/** The constant referring the property "libraryFormUID_public". */
	public static final String PROP_LIBRARY_FORM_U_I_D_PUBLIC = "libraryFormUID_public";
	
	/** The constant referring the property "galleryFormUID_public". */
	public static final String PROP_GALLERY_FORM_U_I_D_PUBLIC = "galleryFormUID_public";
	
	/** The constant referring the property "universalMapFormUID_public". */
	public static final String PROP_UNIVERSAL_MAP_FORM_U_I_D_PUBLIC = "universalMapFormUID_public";
	
	/** The constant referring the property "descriptiveFormUID_secret". */
	public static final String PROP_DESCRIPTIVE_FORM_U_I_D_SECRET = "descriptiveFormUID_secret";
	
	/** The constant referring the property "tabularFormUID_secret". */
	public static final String PROP_TABULAR_FORM_U_I_D_SECRET = "tabularFormUID_secret";
	
	/** The constant referring the property "libraryFormUID_secret". */
	public static final String PROP_LIBRARY_FORM_U_I_D_SECRET = "libraryFormUID_secret";
	
	/** The constant referring the property "galleryFormUID_secret". */
	public static final String PROP_GALLERY_FORM_U_I_D_SECRET = "galleryFormUID_secret";
	
	/** The constant referring the property "universalMapFormUID_secret". */
	public static final String PROP_UNIVERSAL_MAP_FORM_U_I_D_SECRET = "universalMapFormUID_secret";
	
	/** The constant referring the property "layer". */
	public static final String PROP_LAYER = "layer";
	
	/** The constant referring the property "timeSeriesRootCategories". */
	public static final String PROP_TIME_SERIES_ROOT_CATEGORIES = "timeSeriesRootCategories";
	
	
	/** The name of table for this class. */
	public static final String TABLE = "pond_ms.PONDS";
	
	/** Name of column referring the property "id". */
	public static final String PROPCOLUMN_ID = "id";
	
	/** Name of column referring the property "extuid". */
	public static final String PROPCOLUMN_EXTUID = "extuid";
	
	/** Name of column referring the property "title". */
	public static final String PROPCOLUMN_TITLE = "title";
	
	/** Name of column referring the property "generalFormUID_public". */
	public static final String PROPCOLUMN_GENERAL_FORM_U_I_D_PUBLIC = "generalFormUID_public";
	
	/** Name of column referring the property "descriptiveFormUID_public". */
	public static final String PROPCOLUMN_DESCRIPTIVE_FORM_U_I_D_PUBLIC = "descriptiveFormUID_public";
	
	/** Name of column referring the property "tabularFormUID_public". */
	public static final String PROPCOLUMN_TABULAR_FORM_U_I_D_PUBLIC = "tabularFormUID_public";
	
	/** Name of column referring the property "libraryFormUID_public". */
	public static final String PROPCOLUMN_LIBRARY_FORM_U_I_D_PUBLIC = "libraryFormUID_public";
	
	/** Name of column referring the property "galleryFormUID_public". */
	public static final String PROPCOLUMN_GALLERY_FORM_U_I_D_PUBLIC = "galleryFormUID_public";
	
	/** Name of column referring the property "universalMapFormUID_public". */
	public static final String PROPCOLUMN_UNIVERSAL_MAP_FORM_U_I_D_PUBLIC = "universalMapFormUID_public";
	
	/** Name of column referring the property "descriptiveFormUID_secret". */
	public static final String PROPCOLUMN_DESCRIPTIVE_FORM_U_I_D_SECRET = "descriptiveFormUID_secret";
	
	/** Name of column referring the property "tabularFormUID_secret". */
	public static final String PROPCOLUMN_TABULAR_FORM_U_I_D_SECRET = "tabularFormUID_secret";
	
	/** Name of column referring the property "libraryFormUID_secret". */
	public static final String PROPCOLUMN_LIBRARY_FORM_U_I_D_SECRET = "libraryFormUID_secret";
	
	/** Name of column referring the property "galleryFormUID_secret". */
	public static final String PROPCOLUMN_GALLERY_FORM_U_I_D_SECRET = "galleryFormUID_secret";
	
	/** Name of column referring the property "universalMapFormUID_secret". */
	public static final String PROPCOLUMN_UNIVERSAL_MAP_FORM_U_I_D_SECRET = "universalMapFormUID_secret";
	
	/** Name of column referring the property "layer". */
	public static final String PROPCOLUMN_LAYER = "layer";
	
	/** Name of table referring the property "timeSeriesRootCategories". */
	public static final String PROPTABLE_TIME_SERIES_ROOT_CATEGORIES = "pond_ms.ROOT_CATEGORY";
	
	

	
	
	


	private int hashCode_ = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
	private java.lang.String extuid;
	private java.lang.String title;
	private java.lang.String generalFormUID_public;
	private java.lang.String descriptiveFormUID_public;
	private java.lang.String tabularFormUID_public;
	private java.lang.String libraryFormUID_public;
	private java.lang.String galleryFormUID_public;
	private java.lang.String universalMapFormUID_public;
	private java.lang.String descriptiveFormUID_secret;
	private java.lang.String tabularFormUID_secret;
	private java.lang.String libraryFormUID_secret;
	private java.lang.String galleryFormUID_secret;
	private java.lang.String universalMapFormUID_secret;

	// many to one
	private ir.viratech.pond_ms.model.layer.ParentLayer layer;

	// collections
	private java.util.Set<ir.viratech.pond_ms.model.time_series.RootCategory> timeSeriesRootCategories;



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
	 * Getter for "generalFormUID_public".
	 * column= generalFormUID_public
	 *
	 * @return the value of generalFormUID_public
	 */
	public java.lang.String getGeneralFormUID_public() {
		return this.generalFormUID_public;
	}

	/**
	 * Setter for property "generalFormUID_public".
	 * column= generalFormUID_public
	 *
	 * @param generalFormUID_public the new value for generalFormUID_public
	 */
	public void setGeneralFormUID_public(java.lang.String generalFormUID_public) {
		this.generalFormUID_public = generalFormUID_public;
	}



	/**
	 * Getter for "descriptiveFormUID_public".
	 * column= descriptiveFormUID_public
	 *
	 * @return the value of descriptiveFormUID_public
	 */
	public java.lang.String getDescriptiveFormUID_public() {
		return this.descriptiveFormUID_public;
	}

	/**
	 * Setter for property "descriptiveFormUID_public".
	 * column= descriptiveFormUID_public
	 *
	 * @param descriptiveFormUID_public the new value for descriptiveFormUID_public
	 */
	public void setDescriptiveFormUID_public(java.lang.String descriptiveFormUID_public) {
		this.descriptiveFormUID_public = descriptiveFormUID_public;
	}



	/**
	 * Getter for "tabularFormUID_public".
	 * column= tabularFormUID_public
	 *
	 * @return the value of tabularFormUID_public
	 */
	public java.lang.String getTabularFormUID_public() {
		return this.tabularFormUID_public;
	}

	/**
	 * Setter for property "tabularFormUID_public".
	 * column= tabularFormUID_public
	 *
	 * @param tabularFormUID_public the new value for tabularFormUID_public
	 */
	public void setTabularFormUID_public(java.lang.String tabularFormUID_public) {
		this.tabularFormUID_public = tabularFormUID_public;
	}



	/**
	 * Getter for "libraryFormUID_public".
	 * column= libraryFormUID_public
	 *
	 * @return the value of libraryFormUID_public
	 */
	public java.lang.String getLibraryFormUID_public() {
		return this.libraryFormUID_public;
	}

	/**
	 * Setter for property "libraryFormUID_public".
	 * column= libraryFormUID_public
	 *
	 * @param libraryFormUID_public the new value for libraryFormUID_public
	 */
	public void setLibraryFormUID_public(java.lang.String libraryFormUID_public) {
		this.libraryFormUID_public = libraryFormUID_public;
	}



	/**
	 * Getter for "galleryFormUID_public".
	 * column= galleryFormUID_public
	 *
	 * @return the value of galleryFormUID_public
	 */
	public java.lang.String getGalleryFormUID_public() {
		return this.galleryFormUID_public;
	}

	/**
	 * Setter for property "galleryFormUID_public".
	 * column= galleryFormUID_public
	 *
	 * @param galleryFormUID_public the new value for galleryFormUID_public
	 */
	public void setGalleryFormUID_public(java.lang.String galleryFormUID_public) {
		this.galleryFormUID_public = galleryFormUID_public;
	}



	/**
	 * Getter for "universalMapFormUID_public".
	 * column= universalMapFormUID_public
	 *
	 * @return the value of universalMapFormUID_public
	 */
	public java.lang.String getUniversalMapFormUID_public() {
		return this.universalMapFormUID_public;
	}

	/**
	 * Setter for property "universalMapFormUID_public".
	 * column= universalMapFormUID_public
	 *
	 * @param universalMapFormUID_public the new value for universalMapFormUID_public
	 */
	public void setUniversalMapFormUID_public(java.lang.String universalMapFormUID_public) {
		this.universalMapFormUID_public = universalMapFormUID_public;
	}



	/**
	 * Getter for "descriptiveFormUID_secret".
	 * column= descriptiveFormUID_secret
	 *
	 * @return the value of descriptiveFormUID_secret
	 */
	public java.lang.String getDescriptiveFormUID_secret() {
		return this.descriptiveFormUID_secret;
	}

	/**
	 * Setter for property "descriptiveFormUID_secret".
	 * column= descriptiveFormUID_secret
	 *
	 * @param descriptiveFormUID_secret the new value for descriptiveFormUID_secret
	 */
	public void setDescriptiveFormUID_secret(java.lang.String descriptiveFormUID_secret) {
		this.descriptiveFormUID_secret = descriptiveFormUID_secret;
	}



	/**
	 * Getter for "tabularFormUID_secret".
	 * column= tabularFormUID_secret
	 *
	 * @return the value of tabularFormUID_secret
	 */
	public java.lang.String getTabularFormUID_secret() {
		return this.tabularFormUID_secret;
	}

	/**
	 * Setter for property "tabularFormUID_secret".
	 * column= tabularFormUID_secret
	 *
	 * @param tabularFormUID_secret the new value for tabularFormUID_secret
	 */
	public void setTabularFormUID_secret(java.lang.String tabularFormUID_secret) {
		this.tabularFormUID_secret = tabularFormUID_secret;
	}



	/**
	 * Getter for "libraryFormUID_secret".
	 * column= libraryFormUID_secret
	 *
	 * @return the value of libraryFormUID_secret
	 */
	public java.lang.String getLibraryFormUID_secret() {
		return this.libraryFormUID_secret;
	}

	/**
	 * Setter for property "libraryFormUID_secret".
	 * column= libraryFormUID_secret
	 *
	 * @param libraryFormUID_secret the new value for libraryFormUID_secret
	 */
	public void setLibraryFormUID_secret(java.lang.String libraryFormUID_secret) {
		this.libraryFormUID_secret = libraryFormUID_secret;
	}



	/**
	 * Getter for "galleryFormUID_secret".
	 * column= galleryFormUID_secret
	 *
	 * @return the value of galleryFormUID_secret
	 */
	public java.lang.String getGalleryFormUID_secret() {
		return this.galleryFormUID_secret;
	}

	/**
	 * Setter for property "galleryFormUID_secret".
	 * column= galleryFormUID_secret
	 *
	 * @param galleryFormUID_secret the new value for galleryFormUID_secret
	 */
	public void setGalleryFormUID_secret(java.lang.String galleryFormUID_secret) {
		this.galleryFormUID_secret = galleryFormUID_secret;
	}



	/**
	 * Getter for "universalMapFormUID_secret".
	 * column= universalMapFormUID_secret
	 *
	 * @return the value of universalMapFormUID_secret
	 */
	public java.lang.String getUniversalMapFormUID_secret() {
		return this.universalMapFormUID_secret;
	}

	/**
	 * Setter for property "universalMapFormUID_secret".
	 * column= universalMapFormUID_secret
	 *
	 * @param universalMapFormUID_secret the new value for universalMapFormUID_secret
	 */
	public void setUniversalMapFormUID_secret(java.lang.String universalMapFormUID_secret) {
		this.universalMapFormUID_secret = universalMapFormUID_secret;
	}



	/**
	 * Getter for "layer".
	 * column= layer
	 *
	 * @return the value of layer
	 */
	public ir.viratech.pond_ms.model.layer.ParentLayer getLayer() {
		return this.layer;
	}

	/**
	 * Setter for property "layer".
	 * column= layer
	 *
	 * @param layer the new value for layer
	 */
	public void setLayer(ir.viratech.pond_ms.model.layer.ParentLayer layer) {
		this.layer = layer;
	}



	/**
	 * Getter for "timeSeriesRootCategories".
	 *
	 * @return the value of timeSeriesRootCategories
	 */
	public java.util.Set<ir.viratech.pond_ms.model.time_series.RootCategory> getTimeSeriesRootCategories() {
		return this.timeSeriesRootCategories;
	}

	/**
	 * Setter for property "timeSeriesRootCategories".
	 *
	 * @param timeSeriesRootCategories the new value for timeSeriesRootCategories
	 */
	public void setTimeSeriesRootCategories(java.util.Set<ir.viratech.pond_ms.model.time_series.RootCategory> timeSeriesRootCategories) {
		this.timeSeriesRootCategories = timeSeriesRootCategories;
	}
	/**
	 * Gets timeSeriesRootCategories, and creates and sets a new instance if it is null.
	 *
	 * @return the value of property timeSeriesRootCategories
	 */
	public java.util.Set<ir.viratech.pond_ms.model.time_series.RootCategory> getCreatedTimeSeriesRootCategories() {
		if (null == getTimeSeriesRootCategories()) this.setTimeSeriesRootCategories(new java.util.HashSet<ir.viratech.pond_ms.model.time_series.RootCategory>());
		return this.getTimeSeriesRootCategories();
	}
	
	/**
	 * Adds a member to "timeSeriesRootCategories".
	 * It creates the collection if it is null.
	 *
	 * @param rootCategory the new member to be added
	 */
	public void addToTimeSeriesRootCategories(ir.viratech.pond_ms.model.time_series.RootCategory rootCategory) {
		this.getCreatedTimeSeriesRootCategories().add(rootCategory);
	}
	
	/**
	 * Adds a member to "timeSeriesRootCategories".
	 * It creates the collection if it is null.
	 *
	 * @param rootCategory the new member to be added
	 * @deprecated Use {@link #addToTimeSeriesRootCategories(ir.viratech.pond_ms.model.time_series.RootCategory)} instead.
	 */
	@Deprecated
	public final void addTotimeSeriesRootCategories(ir.viratech.pond_ms.model.time_series.RootCategory rootCategory) {
		this.addToTimeSeriesRootCategories(rootCategory);
	}
	
	/**
	 * Removes a member from "timeSeriesRootCategories".
	 * It does nothing if the collection is null.
	 *
	 * @param rootCategory the member to be removed
	 */
	public void removeFromTimeSeriesRootCategories(ir.viratech.pond_ms.model.time_series.RootCategory rootCategory) {
		if (null != this.getTimeSeriesRootCategories()) {
			this.getTimeSeriesRootCategories().remove(rootCategory);
		}
	}




	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (null == obj) return false;
		if (!(obj instanceof ir.viratech.pond_ms.model.layer.Pond)) return false;
		else {
			ir.viratech.pond_ms.model.layer.Pond pond = (ir.viratech.pond_ms.model.layer.Pond) obj;
			boolean isEqual = true;
			if (null == this.getExtuid() || null == pond.getExtuid()) return false;
			else isEqual = isEqual && (this.getExtuid().equals(pond.getExtuid()));
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