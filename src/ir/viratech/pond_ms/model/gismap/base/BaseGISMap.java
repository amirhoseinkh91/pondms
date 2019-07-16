package ir.viratech.pond_ms.model.gismap.base;

import java.io.Serializable;


/**
 *  Base class for entity "ir.viratech.pond_ms.model.gismap.GISMap".
 *  It is an automatically generated file and should not be edited.
 *
 * @hibernate.class
 *  table="pond_ms.GISMAPS"
 */

public abstract class BaseGISMap  implements Serializable {
	private static final long serialVersionUID = 1L;


	/** The constant referring the name of class "GISMap". */
	public static final String REF = "GISMap";
	
	/** The constant referring the property "id". */
	public static final String PROP_ID = "id";
	
	/** The constant referring the property "extuid". */
	public static final String PROP_EXTUID = "extuid";
	
	/** The constant referring the property "title". */
	public static final String PROP_TITLE = "title";
	
	/** The constant referring the property "latinTitle". */
	public static final String PROP_LATIN_TITLE = "latinTitle";
	
	/** The constant referring the property "description". */
	public static final String PROP_DESCRIPTION = "description";
	
	/** The constant referring the property "creationDate". */
	public static final String PROP_CREATION_DATE = "creationDate";
	
	/** The constant referring the property "boundingBox". */
	public static final String PROP_BOUNDING_BOX = "boundingBox";
	
	/** The constant referring the property "center". */
	public static final String PROP_CENTER = "center";
	
	/** The constant referring the property "minZoom". */
	public static final String PROP_MIN_ZOOM = "minZoom";
	
	/** The constant referring the property "maxZoom". */
	public static final String PROP_MAX_ZOOM = "maxZoom";
	
	/** The constant referring the property "defaultZoom". */
	public static final String PROP_DEFAULT_ZOOM = "defaultZoom";
	
	/** The constant referring the property "organization". */
	public static final String PROP_ORGANIZATION = "organization";
	
	/** The constant referring the property "layers". */
	public static final String PROP_LAYERS = "layers";
	
	
	/** The name of table for this class. */
	public static final String TABLE = "pond_ms.GISMAPS";
	
	/** Name of column referring the property "id". */
	public static final String PROPCOLUMN_ID = "id";
	
	/** Name of column referring the property "extuid". */
	public static final String PROPCOLUMN_EXTUID = "extuid";
	
	/** Name of column referring the property "title". */
	public static final String PROPCOLUMN_TITLE = "title";
	
	/** Name of column referring the property "latinTitle". */
	public static final String PROPCOLUMN_LATIN_TITLE = "latin_title";
	
	/** Name of column referring the property "description". */
	public static final String PROPCOLUMN_DESCRIPTION = "description";
	
	/** Name of column referring the property "creationDate". */
	public static final String PROPCOLUMN_CREATION_DATE = "creation_date";
	
	/** Name of column referring the property "boundingBox". */
	public static final String PROPCOLUMN_BOUNDING_BOX = "bounding_box";
	
	/** Name of column referring the property "center". */
	public static final String PROPCOLUMN_CENTER = "center";
	
	/** Name of column referring the property "minZoom". */
	public static final String PROPCOLUMN_MIN_ZOOM = "min_zoom";
	
	/** Name of column referring the property "maxZoom". */
	public static final String PROPCOLUMN_MAX_ZOOM = "max_zoom";
	
	/** Name of column referring the property "defaultZoom". */
	public static final String PROPCOLUMN_DEFAULT_ZOOM = "default_zoom";
	
	/** Name of column referring the property "organization". */
	public static final String PROPCOLUMN_ORGANIZATION = "organization_id";
	
	

	
	
	


	private int hashCode_ = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
	private java.lang.String extuid;
	private java.lang.String title;
	private java.lang.String latinTitle;
	private java.lang.String description;
	private java.util.Date creationDate;
	private com.vividsolutions.jts.geom.Polygon boundingBox;
	private com.vividsolutions.jts.geom.Point center;
	private int minZoom;
	private int maxZoom;
	private int defaultZoom;

	// many to one
	private ir.viratech.pond_ms.model.organization.Organization organization;

	// collections
	private java.util.List<ir.viratech.pond_ms.model.layer.Layer> layers;



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
	 * Getter for "latinTitle".
	 * column= latin_title
	 *
	 * @return the value of latinTitle
	 */
	public java.lang.String getLatinTitle() {
		return this.latinTitle;
	}

	/**
	 * Setter for property "latinTitle".
	 * column= latin_title
	 *
	 * @param latinTitle the new value for latinTitle
	 */
	public void setLatinTitle(java.lang.String latinTitle) {
		this.latinTitle = latinTitle;
	}



	/**
	 * Getter for "description".
	 * column= description
	 *
	 * @return the value of description
	 */
	public java.lang.String getDescription() {
		return this.description;
	}

	/**
	 * Setter for property "description".
	 * column= description
	 *
	 * @param description the new value for description
	 */
	public void setDescription(java.lang.String description) {
		this.description = description;
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
	 * Getter for "boundingBox".
	 * column= bounding_box
	 *
	 * @return the value of boundingBox
	 */
	public com.vividsolutions.jts.geom.Polygon getBoundingBox() {
		return this.boundingBox;
	}

	/**
	 * Setter for property "boundingBox".
	 * column= bounding_box
	 *
	 * @param boundingBox the new value for boundingBox
	 */
	public void setBoundingBox(com.vividsolutions.jts.geom.Polygon boundingBox) {
		this.boundingBox = boundingBox;
	}



	/**
	 * Getter for "center".
	 * column= center
	 *
	 * @return the value of center
	 */
	public com.vividsolutions.jts.geom.Point getCenter() {
		return this.center;
	}

	/**
	 * Setter for property "center".
	 * column= center
	 *
	 * @param center the new value for center
	 */
	public void setCenter(com.vividsolutions.jts.geom.Point center) {
		this.center = center;
	}



	/**
	 * Getter for "minZoom".
	 * column= min_zoom
	 *
	 * @return the value of minZoom
	 */
	public int getMinZoom() {
		return this.minZoom;
	}

	/**
	 * Setter for property "minZoom".
	 * column= min_zoom
	 *
	 * @param minZoom the new value for minZoom
	 */
	public void setMinZoom(int minZoom) {
		this.minZoom = minZoom;
	}



	/**
	 * Getter for "maxZoom".
	 * column= max_zoom
	 *
	 * @return the value of maxZoom
	 */
	public int getMaxZoom() {
		return this.maxZoom;
	}

	/**
	 * Setter for property "maxZoom".
	 * column= max_zoom
	 *
	 * @param maxZoom the new value for maxZoom
	 */
	public void setMaxZoom(int maxZoom) {
		this.maxZoom = maxZoom;
	}



	/**
	 * Getter for "defaultZoom".
	 * column= default_zoom
	 *
	 * @return the value of defaultZoom
	 */
	public int getDefaultZoom() {
		return this.defaultZoom;
	}

	/**
	 * Setter for property "defaultZoom".
	 * column= default_zoom
	 *
	 * @param defaultZoom the new value for defaultZoom
	 */
	public void setDefaultZoom(int defaultZoom) {
		this.defaultZoom = defaultZoom;
	}



	/**
	 * Getter for "organization".
	 * column= organization_id
	 *
	 * @return the value of organization
	 */
	public ir.viratech.pond_ms.model.organization.Organization getOrganization() {
		return this.organization;
	}

	/**
	 * Setter for property "organization".
	 * column= organization_id
	 *
	 * @param organization the new value for organization
	 */
	public void setOrganization(ir.viratech.pond_ms.model.organization.Organization organization) {
		this.organization = organization;
	}



	/**
	 * Getter for "layers".
	 *
	 * @return the value of layers
	 */
	public java.util.List<ir.viratech.pond_ms.model.layer.Layer> getLayers() {
		return this.layers;
	}

	/**
	 * Setter for property "layers".
	 *
	 * @param layers the new value for layers
	 */
	public void setLayers(java.util.List<ir.viratech.pond_ms.model.layer.Layer> layers) {
		this.layers = layers;
	}
	/**
	 * Gets layers, and creates and sets a new instance if it is null.
	 *
	 * @return the value of property layers
	 */
	public java.util.List<ir.viratech.pond_ms.model.layer.Layer> getCreatedLayers() {
		if (null == getLayers()) this.setLayers(new java.util.ArrayList<ir.viratech.pond_ms.model.layer.Layer>());
		return this.getLayers();
	}
	
	/**
	 * Adds a member to "layers".
	 * It creates the collection if it is null.
	 *
	 * @param layer the new member to be added
	 */
	public void addToLayers(ir.viratech.pond_ms.model.layer.Layer layer) {
		this.getCreatedLayers().add(layer);
	}
	
	/**
	 * Adds a member to "layers".
	 * It creates the collection if it is null.
	 *
	 * @param layer the new member to be added
	 * @deprecated Use {@link #addToLayers(ir.viratech.pond_ms.model.layer.Layer)} instead.
	 */
	@Deprecated
	public final void addTolayers(ir.viratech.pond_ms.model.layer.Layer layer) {
		this.addToLayers(layer);
	}
	
	/**
	 * Removes a member from "layers".
	 * It does nothing if the collection is null.
	 *
	 * @param layer the member to be removed
	 */
	public void removeFromLayers(ir.viratech.pond_ms.model.layer.Layer layer) {
		if (null != this.getLayers()) {
			this.getLayers().remove(layer);
		}
	}




	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (null == obj) return false;
		if (!(obj instanceof ir.viratech.pond_ms.model.gismap.GISMap)) return false;
		else {
			ir.viratech.pond_ms.model.gismap.GISMap gISMap = (ir.viratech.pond_ms.model.gismap.GISMap) obj;
			boolean isEqual = true;
			if (null == this.getExtuid() || null == gISMap.getExtuid()) return false;
			else isEqual = isEqual && (this.getExtuid().equals(gISMap.getExtuid()));
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