package ir.viratech.pond_ms.model.map_object.vector.base;

import java.io.Serializable;


/**
 *  Base class for entity "ir.viratech.pond_ms.model.map_object.vector.GISVectorObject".
 *  It is an automatically generated file and should not be edited.
 *
 * @hibernate.class
 *  table="pond_ms.GIS_VECTOR_OBJECTS"
 */

public abstract class BaseGISVectorObject  implements Serializable {
	private static final long serialVersionUID = 1L;


	/** The constant referring the name of class "GISVectorObject". */
	public static final String REF = "GISVectorObject";
	
	/** The constant referring the property "id". */
	public static final String PROP_ID = "id";
	
	/** The constant referring the property "extuid". */
	public static final String PROP_EXTUID = "extuid";
	
	/** The constant referring the property "name". */
	public static final String PROP_NAME = "name";
	
	/** The constant referring the property "creationDate". */
	public static final String PROP_CREATION_DATE = "creationDate";
	
	/** The constant referring the property "provider". */
	public static final String PROP_PROVIDER = "provider";
	
	/** The constant referring the property "formUID". */
	public static final String PROP_FORM_U_I_D = "formUID";
	
	/** The constant referring the property "reviewCount". */
	public static final String PROP_REVIEW_COUNT = "reviewCount";
	
	/** The constant referring the property "favoriteCount". */
	public static final String PROP_FAVORITE_COUNT = "favoriteCount";
	
	/** The constant referring the property "layer". */
	public static final String PROP_LAYER = "layer";
	
	/** The constant referring the property "reviews". */
	public static final String PROP_REVIEWS = "reviews";
	
	/** The constant referring the property "timeSeriesRootCategories". */
	public static final String PROP_TIME_SERIES_ROOT_CATEGORIES = "timeSeriesRootCategories";
	
	
	/** The name of table for this class. */
	public static final String TABLE = "pond_ms.GIS_VECTOR_OBJECTS";
	
	/** Name of column referring the property "id". */
	public static final String PROPCOLUMN_ID = "id";
	
	/** Name of column referring the property "extuid". */
	public static final String PROPCOLUMN_EXTUID = "extuid";
	
	/** Name of column referring the property "name". */
	public static final String PROPCOLUMN_NAME = "name";
	
	/** Name of column referring the property "creationDate". */
	public static final String PROPCOLUMN_CREATION_DATE = "creation_date";
	
	/** Name of column referring the property "provider". */
	public static final String PROPCOLUMN_PROVIDER = "provider";
	
	/** Name of column referring the property "formUID". */
	public static final String PROPCOLUMN_FORM_U_I_D = "formUID";
	
	/** Name of column referring the property "reviewCount". */
	public static final String PROPCOLUMN_REVIEW_COUNT = "reviewCount";
	
	/** Name of column referring the property "favoriteCount". */
	public static final String PROPCOLUMN_FAVORITE_COUNT = "favoriteCount";
	
	/** Name of column referring the property "layer". */
	public static final String PROPCOLUMN_LAYER = "layer_id";
	
	/** Name of table referring the property "timeSeriesRootCategories". */
	public static final String PROPTABLE_TIME_SERIES_ROOT_CATEGORIES = "pond_ms.ROOT_CATEGORY";
	
	

	
	
	


	private int hashCode_ = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
	private java.lang.String extuid;
	private java.lang.String name;
	private java.util.Date creationDate;
	private java.lang.String provider;
	private java.lang.String formUID;
	private java.lang.Integer reviewCount;
	private java.lang.Integer favoriteCount;

	// many to one
	private ir.viratech.pond_ms.model.layer.VectorLayer layer;

	// collections
	private java.util.Set<ir.viratech.pond_ms.model.review.Review> reviews;
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
	 * Getter for "creationDate".
	 * column= creation_date
	 *
	 * @return the value of creationDate
	 */
	public java.util.Date getCreationDate() {
		return this.creationDate;
	}

	/**
	 * Setter for property "creationDate".
	 * column= creation_date
	 *
	 * @param creationDate the new value for creationDate
	 */
	public void setCreationDate(java.util.Date creationDate) {
		this.creationDate = creationDate;
	}



	/**
	 * Getter for "provider".
	 * column= provider
	 *
	 * @return the value of provider
	 */
	public java.lang.String getProvider() {
		return this.provider;
	}

	/**
	 * Setter for property "provider".
	 * column= provider
	 *
	 * @param provider the new value for provider
	 */
	public void setProvider(java.lang.String provider) {
		this.provider = provider;
	}



	/**
	 * Getter for "formUID".
	 * column= formUID
	 *
	 * @return the value of formUID
	 */
	public java.lang.String getFormUID() {
		return this.formUID;
	}

	/**
	 * Setter for property "formUID".
	 * column= formUID
	 *
	 * @param formUID the new value for formUID
	 */
	public void setFormUID(java.lang.String formUID) {
		this.formUID = formUID;
	}



	/**
	 * Getter for "reviewCount".
	 * column= reviewCount
	 *
	 * @return the value of reviewCount
	 */
	public java.lang.Integer getReviewCount() {
		return this.reviewCount;
	}

	/**
	 * Setter for property "reviewCount".
	 * column= reviewCount
	 *
	 * @param reviewCount the new value for reviewCount
	 */
	public void setReviewCount(java.lang.Integer reviewCount) {
		this.reviewCount = reviewCount;
	}



	/**
	 * Getter for "favoriteCount".
	 * column= favoriteCount
	 *
	 * @return the value of favoriteCount
	 */
	public java.lang.Integer getFavoriteCount() {
		return this.favoriteCount;
	}

	/**
	 * Setter for property "favoriteCount".
	 * column= favoriteCount
	 *
	 * @param favoriteCount the new value for favoriteCount
	 */
	public void setFavoriteCount(java.lang.Integer favoriteCount) {
		this.favoriteCount = favoriteCount;
	}



	/**
	 * Getter for "layer".
	 * column= layer_id
	 *
	 * @return the value of layer
	 */
	public ir.viratech.pond_ms.model.layer.VectorLayer getLayer() {
		return this.layer;
	}

	/**
	 * Setter for property "layer".
	 * column= layer_id
	 *
	 * @param layer the new value for layer
	 */
	public void setLayer(ir.viratech.pond_ms.model.layer.VectorLayer layer) {
		this.layer = layer;
	}



	/**
	 * Getter for "reviews".
	 *
	 * @return the value of reviews
	 */
	public java.util.Set<ir.viratech.pond_ms.model.review.Review> getReviews() {
		return this.reviews;
	}

	/**
	 * Setter for property "reviews".
	 *
	 * @param reviews the new value for reviews
	 */
	public void setReviews(java.util.Set<ir.viratech.pond_ms.model.review.Review> reviews) {
		this.reviews = reviews;
	}
	/**
	 * Gets reviews, and creates and sets a new instance if it is null.
	 *
	 * @return the value of property reviews
	 */
	public java.util.Set<ir.viratech.pond_ms.model.review.Review> getCreatedReviews() {
		if (null == getReviews()) this.setReviews(new java.util.HashSet<ir.viratech.pond_ms.model.review.Review>());
		return this.getReviews();
	}
	
	/**
	 * Adds a member to "reviews".
	 * It creates the collection if it is null.
	 *
	 * @param review the new member to be added
	 */
	public void addToReviews(ir.viratech.pond_ms.model.review.Review review) {
		this.getCreatedReviews().add(review);
	}
	
	/**
	 * Adds a member to "reviews".
	 * It creates the collection if it is null.
	 *
	 * @param review the new member to be added
	 * @deprecated Use {@link #addToReviews(ir.viratech.pond_ms.model.review.Review)} instead.
	 */
	@Deprecated
	public final void addToreviews(ir.viratech.pond_ms.model.review.Review review) {
		this.addToReviews(review);
	}
	
	/**
	 * Removes a member from "reviews".
	 * It does nothing if the collection is null.
	 *
	 * @param review the member to be removed
	 */
	public void removeFromReviews(ir.viratech.pond_ms.model.review.Review review) {
		if (null != this.getReviews()) {
			this.getReviews().remove(review);
		}
	}
	
	/**
	 * Adds a member to "reviews" and synchronizes the reverse association.
	 *
	 * @param review the new member to be added
	 */
	public void addToReviews_AndReverse(ir.viratech.pond_ms.model.review.Review review) {
		this.addToReviews(review);
		review.setGisVectorObject((ir.viratech.pond_ms.model.map_object.vector.GISVectorObject)this);
	}
	
	/**
	 * Removes a member from "reviews" and synchronizes the reverse association.
	 *
	 * @param review the member to be removed
	 */
	public void removeFromReviews_AndReverse(ir.viratech.pond_ms.model.review.Review review) {
		this.removeFromReviews(review);
		review.setGisVectorObject(null);
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
		if (!(obj instanceof ir.viratech.pond_ms.model.map_object.vector.GISVectorObject)) return false;
		else {
			ir.viratech.pond_ms.model.map_object.vector.GISVectorObject gISVectorObject = (ir.viratech.pond_ms.model.map_object.vector.GISVectorObject) obj;
			boolean isEqual = true;
			if (null == this.getExtuid() || null == gISVectorObject.getExtuid()) return false;
			else isEqual = isEqual && (this.getExtuid().equals(gISVectorObject.getExtuid()));
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