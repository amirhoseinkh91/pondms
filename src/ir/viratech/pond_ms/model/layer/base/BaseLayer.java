package ir.viratech.pond_ms.model.layer.base;

import java.io.Serializable;


/**
 *  Base class for entity "ir.viratech.pond_ms.model.layer.Layer".
 *  It is an automatically generated file and should not be edited.
 *
 * @hibernate.class
 *  table="pond_ms.LAYER"
 */

public abstract class BaseLayer  implements Serializable {
	private static final long serialVersionUID = 1L;


	/** The constant referring the name of class "Layer". */
	public static final String REF = "Layer";
	
	/** The constant referring the property "id". */
	public static final String PROP_ID = "id";
	
	/** The constant referring the property "extuid". */
	public static final String PROP_EXTUID = "extuid";
	
	/** The constant referring the property "name". */
	public static final String PROP_NAME = "name";
	
	/** The constant referring the property "description". */
	public static final String PROP_DESCRIPTION = "description";
	
	/** The constant referring the property "creationDate". */
	public static final String PROP_CREATION_DATE = "creationDate";
	
	/** The constant referring the property "pondRelated". */
	public static final String PROP_POND_RELATED = "pondRelated";
	
	/** The constant referring the property "indexInParent". */
	public static final String PROP_INDEX_IN_PARENT = "indexInParent";
	
	/** The constant referring the property "indexInGISMap". */
	public static final String PROP_INDEX_IN_G_I_S_MAP = "indexInGISMap";
	
	/** The constant referring the property "secret". */
	public static final String PROP_SECRET = "secret";
	
	/** The constant referring the property "map". */
	public static final String PROP_MAP = "map";
	
	/** The constant referring the property "parentLayer". */
	public static final String PROP_PARENT_LAYER = "parentLayer";
	
	/** The constant referring the property "parentMap". */
	public static final String PROP_PARENT_MAP = "parentMap";
	
	
	/** The name of table for this class. */
	public static final String TABLE = "pond_ms.LAYER";
	
	/** Name of column referring the property "id". */
	public static final String PROPCOLUMN_ID = "id";
	
	/** Name of column referring the property "extuid". */
	public static final String PROPCOLUMN_EXTUID = "extuid";
	
	/** Name of column referring the property "name". */
	public static final String PROPCOLUMN_NAME = "name";
	
	/** Name of column referring the property "description". */
	public static final String PROPCOLUMN_DESCRIPTION = "description";
	
	/** Name of column referring the property "creationDate". */
	public static final String PROPCOLUMN_CREATION_DATE = "creation_date";
	
	/** Name of column referring the property "pondRelated". */
	public static final String PROPCOLUMN_POND_RELATED = "pondRelated";
	
	/** Name of column referring the property "indexInParent". */
	public static final String PROPCOLUMN_INDEX_IN_PARENT = "index_in_parent";
	
	/** Name of column referring the property "indexInGISMap". */
	public static final String PROPCOLUMN_INDEX_IN_G_I_S_MAP = "index_in_gismap";
	
	/** Name of column referring the property "secret". */
	public static final String PROPCOLUMN_SECRET = "secret";
	
	/** Name of column referring the property "map". */
	public static final String PROPCOLUMN_MAP = "map_id";
	
	/** Name of column referring the property "parentLayer". */
	public static final String PROPCOLUMN_PARENT_LAYER = "parent_id";
	
	/** Name of column referring the property "parentMap". */
	public static final String PROPCOLUMN_PARENT_MAP = "parent_map_id";
	
	

	
	
	


	private int hashCode_ = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
	private java.lang.String extuid;
	private java.lang.String name;
	private java.lang.String description;
	private java.util.Date creationDate;
	private boolean pondRelated;
	private java.lang.Integer indexInParent;
	private java.lang.Integer indexInGISMap;
	private boolean secret;

	// many to one
	private ir.viratech.pond_ms.model.gismap.GISMap map;
	private ir.viratech.pond_ms.model.layer.ParentLayer parentLayer;
	private ir.viratech.pond_ms.model.gismap.GISMap parentMap;



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
	 * Getter for "pondRelated".
	 * column= pondRelated
	 *
	 * @return the value of pondRelated
	 */
	public boolean isPondRelated() {
		return this.pondRelated;
	}

	/**
	 * Setter for property "pondRelated".
	 * column= pondRelated
	 *
	 * @param pondRelated the new value for pondRelated
	 */
	public void setPondRelated(boolean pondRelated) {
		this.pondRelated = pondRelated;
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



	/**
	 * Getter for "indexInGISMap".
	 * column= index_in_gismap
	 *
	 * @return the value of indexInGISMap
	 */
	public java.lang.Integer getIndexInGISMap() {
		return this.indexInGISMap;
	}

	/**
	 * Setter for property "indexInGISMap".
	 * column= index_in_gismap
	 *
	 * @param indexInGISMap the new value for indexInGISMap
	 */
	public void setIndexInGISMap(java.lang.Integer indexInGISMap) {
		this.indexInGISMap = indexInGISMap;
	}



	/**
	 * Getter for "secret".
	 * column= secret
	 *
	 * @return the value of secret
	 */
	public boolean isSecret() {
		return this.secret;
	}

	/**
	 * Setter for property "secret".
	 * column= secret
	 *
	 * @param secret the new value for secret
	 */
	public void setSecret(boolean secret) {
		this.secret = secret;
	}



	/**
	 * Getter for "map".
	 * column= map_id
	 *
	 * @return the value of map
	 */
	public ir.viratech.pond_ms.model.gismap.GISMap getMap() {
		return this.map;
	}

	/**
	 * Setter for property "map".
	 * column= map_id
	 *
	 * @param map the new value for map
	 */
	public void setMap(ir.viratech.pond_ms.model.gismap.GISMap map) {
		this.map = map;
	}



	/**
	 * Getter for "parentLayer".
	 * column= parent_id
	 *
	 * @return the value of parentLayer
	 */
	public ir.viratech.pond_ms.model.layer.ParentLayer getParentLayer() {
		return this.parentLayer;
	}

	/**
	 * Setter for property "parentLayer".
	 * column= parent_id
	 *
	 * @param parentLayer the new value for parentLayer
	 */
	public void setParentLayer(ir.viratech.pond_ms.model.layer.ParentLayer parentLayer) {
		this.parentLayer = parentLayer;
	}



	/**
	 * Getter for "parentMap".
	 * column= parent_map_id
	 *
	 * @return the value of parentMap
	 */
	public ir.viratech.pond_ms.model.gismap.GISMap getParentMap() {
		return this.parentMap;
	}

	/**
	 * Setter for property "parentMap".
	 * column= parent_map_id
	 *
	 * @param parentMap the new value for parentMap
	 */
	public void setParentMap(ir.viratech.pond_ms.model.gismap.GISMap parentMap) {
		this.parentMap = parentMap;
	}




	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (null == obj) return false;
		if (!(obj instanceof ir.viratech.pond_ms.model.layer.Layer)) return false;
		else {
			ir.viratech.pond_ms.model.layer.Layer layer = (ir.viratech.pond_ms.model.layer.Layer) obj;
			boolean isEqual = true;
			if (null == this.getExtuid() || null == layer.getExtuid()) return false;
			else isEqual = isEqual && (this.getExtuid().equals(layer.getExtuid()));
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