package ir.viratech.pond_ms.model.layer.base;

import java.io.Serializable;


/**
 *  Base class for entity "ir.viratech.pond_ms.model.layer.VectorLayer".
 *  It is an automatically generated file and should not be edited.
 *
 * @hibernate.class
 *  table="pond_ms.VECTOR_LAYER"
 */

public abstract class BaseVectorLayer extends ir.viratech.pond_ms.model.layer.LeafLayer  implements Serializable {
	private static final long serialVersionUID = 1L;


	/** The constant referring the name of class "VectorLayer". */
	public static final String REF = "VectorLayer";
	
	/** The constant referring the property "id". */
	public static final String PROP_ID = "id";
	
	/** The constant referring the property "formSchemaKey". */
	public static final String PROP_FORM_SCHEMA_KEY = "formSchemaKey";
	
	/** The constant referring the property "vectorObjectsType". */
	public static final String PROP_VECTOR_OBJECTS_TYPE = "vectorObjectsType";
	
	/** The constant referring the property "pointIcon". */
	public static final String PROP_POINT_ICON = "pointIcon";
	
	/** The constant referring the property "lineColor". */
	public static final String PROP_LINE_COLOR = "lineColor";
	
	/** The constant referring the property "lineWidth". */
	public static final String PROP_LINE_WIDTH = "lineWidth";
	
	/** The constant referring the property "polygonFill". */
	public static final String PROP_POLYGON_FILL = "polygonFill";
	
	/** The constant referring the property "labled". */
	public static final String PROP_LABLED = "labled";
	
	/** The constant referring the property "vectorObjects". */
	public static final String PROP_VECTOR_OBJECTS = "vectorObjects";
	
	
	/** The name of table for this class. */
	public static final String TABLE = "pond_ms.VECTOR_LAYER";
	
	/** Name of column referring the property "id". */
	public static final String PROPCOLUMN_ID = "id";
	
	/** Name of column referring the property "formSchemaKey". */
	public static final String PROPCOLUMN_FORM_SCHEMA_KEY = "formSchemaKey";
	
	/** Name of column referring the property "vectorObjectsType". */
	public static final String PROPCOLUMN_VECTOR_OBJECTS_TYPE = "vectorObjectsType";
	
	/** Name of column referring the property "pointIcon". */
	public static final String PROPCOLUMN_POINT_ICON = "pointIcon";
	
	/** Name of column referring the property "lineColor". */
	public static final String PROPCOLUMN_LINE_COLOR = "lineColor";
	
	/** Name of column referring the property "lineWidth". */
	public static final String PROPCOLUMN_LINE_WIDTH = "lineWidth";
	
	/** Name of column referring the property "polygonFill". */
	public static final String PROPCOLUMN_POLYGON_FILL = "polygonFill";
	
	/** Name of column referring the property "labled". */
	public static final String PROPCOLUMN_LABLED = "labled";
	
	/** Name of table referring the property "vectorObjects". */
	public static final String PROPTABLE_VECTOR_OBJECTS = "pond_ms.GIS_VECTOR_OBJECTS";
	
	

	
	
	


	private int hashCode_ = Integer.MIN_VALUE;


	// fields
	private java.lang.String formSchemaKey;
	private java.lang.String vectorObjectsType;
	private java.lang.String pointIcon;
	private java.lang.String lineColor;
	private java.lang.String lineWidth;
	private java.lang.String polygonFill;
	private boolean labled;

	// collections
	private java.util.Set<ir.viratech.pond_ms.model.map_object.vector.GISVectorObject> vectorObjects;






	/**
	 * Getter for "formSchemaKey".
	 * column= formSchemaKey
	 *
	 * @return the value of formSchemaKey
	 */
	public java.lang.String getFormSchemaKey() {
		return this.formSchemaKey;
	}

	/**
	 * Setter for property "formSchemaKey".
	 * column= formSchemaKey
	 *
	 * @param formSchemaKey the new value for formSchemaKey
	 */
	public void setFormSchemaKey(java.lang.String formSchemaKey) {
		this.formSchemaKey = formSchemaKey;
	}



	/**
	 * Getter for "vectorObjectsType".
	 * column= vectorObjectsType
	 *
	 * @return the value of vectorObjectsType
	 */
	public java.lang.String getVectorObjectsType() {
		return this.vectorObjectsType;
	}

	/**
	 * Setter for property "vectorObjectsType".
	 * column= vectorObjectsType
	 *
	 * @param vectorObjectsType the new value for vectorObjectsType
	 */
	public void setVectorObjectsType(java.lang.String vectorObjectsType) {
		this.vectorObjectsType = vectorObjectsType;
	}



	/**
	 * Getter for "pointIcon".
	 * column= pointIcon
	 *
	 * @return the value of pointIcon
	 */
	public java.lang.String getPointIcon() {
		return this.pointIcon;
	}

	/**
	 * Setter for property "pointIcon".
	 * column= pointIcon
	 *
	 * @param pointIcon the new value for pointIcon
	 */
	public void setPointIcon(java.lang.String pointIcon) {
		this.pointIcon = pointIcon;
	}



	/**
	 * Getter for "lineColor".
	 * column= lineColor
	 *
	 * @return the value of lineColor
	 */
	public java.lang.String getLineColor() {
		return this.lineColor;
	}

	/**
	 * Setter for property "lineColor".
	 * column= lineColor
	 *
	 * @param lineColor the new value for lineColor
	 */
	public void setLineColor(java.lang.String lineColor) {
		this.lineColor = lineColor;
	}



	/**
	 * Getter for "lineWidth".
	 * column= lineWidth
	 *
	 * @return the value of lineWidth
	 */
	public java.lang.String getLineWidth() {
		return this.lineWidth;
	}

	/**
	 * Setter for property "lineWidth".
	 * column= lineWidth
	 *
	 * @param lineWidth the new value for lineWidth
	 */
	public void setLineWidth(java.lang.String lineWidth) {
		this.lineWidth = lineWidth;
	}



	/**
	 * Getter for "polygonFill".
	 * column= polygonFill
	 *
	 * @return the value of polygonFill
	 */
	public java.lang.String getPolygonFill() {
		return this.polygonFill;
	}

	/**
	 * Setter for property "polygonFill".
	 * column= polygonFill
	 *
	 * @param polygonFill the new value for polygonFill
	 */
	public void setPolygonFill(java.lang.String polygonFill) {
		this.polygonFill = polygonFill;
	}



	/**
	 * Getter for "labled".
	 * column= labled
	 *
	 * @return the value of labled
	 */
	public boolean isLabled() {
		return this.labled;
	}

	/**
	 * Setter for property "labled".
	 * column= labled
	 *
	 * @param labled the new value for labled
	 */
	public void setLabled(boolean labled) {
		this.labled = labled;
	}



	/**
	 * Getter for "vectorObjects".
	 *
	 * @return the value of vectorObjects
	 */
	public java.util.Set<ir.viratech.pond_ms.model.map_object.vector.GISVectorObject> getVectorObjects() {
		return this.vectorObjects;
	}

	/**
	 * Setter for property "vectorObjects".
	 *
	 * @param vectorObjects the new value for vectorObjects
	 */
	public void setVectorObjects(java.util.Set<ir.viratech.pond_ms.model.map_object.vector.GISVectorObject> vectorObjects) {
		this.vectorObjects = vectorObjects;
	}
	/**
	 * Gets vectorObjects, and creates and sets a new instance if it is null.
	 *
	 * @return the value of property vectorObjects
	 */
	public java.util.Set<ir.viratech.pond_ms.model.map_object.vector.GISVectorObject> getCreatedVectorObjects() {
		if (null == getVectorObjects()) this.setVectorObjects(new java.util.HashSet<ir.viratech.pond_ms.model.map_object.vector.GISVectorObject>());
		return this.getVectorObjects();
	}
	
	/**
	 * Adds a member to "vectorObjects".
	 * It creates the collection if it is null.
	 *
	 * @param gISVectorObject the new member to be added
	 */
	public void addToVectorObjects(ir.viratech.pond_ms.model.map_object.vector.GISVectorObject gISVectorObject) {
		this.getCreatedVectorObjects().add(gISVectorObject);
	}
	
	/**
	 * Adds a member to "vectorObjects".
	 * It creates the collection if it is null.
	 *
	 * @param gISVectorObject the new member to be added
	 * @deprecated Use {@link #addToVectorObjects(ir.viratech.pond_ms.model.map_object.vector.GISVectorObject)} instead.
	 */
	@Deprecated
	public final void addTovectorObjects(ir.viratech.pond_ms.model.map_object.vector.GISVectorObject gISVectorObject) {
		this.addToVectorObjects(gISVectorObject);
	}
	
	/**
	 * Removes a member from "vectorObjects".
	 * It does nothing if the collection is null.
	 *
	 * @param gISVectorObject the member to be removed
	 */
	public void removeFromVectorObjects(ir.viratech.pond_ms.model.map_object.vector.GISVectorObject gISVectorObject) {
		if (null != this.getVectorObjects()) {
			this.getVectorObjects().remove(gISVectorObject);
		}
	}




	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (null == obj) return false;
		if (!(obj instanceof ir.viratech.pond_ms.model.layer.VectorLayer)) return false;
		else {
			ir.viratech.pond_ms.model.layer.VectorLayer vectorLayer = (ir.viratech.pond_ms.model.layer.VectorLayer) obj;
			if (null == this.getId() || null == vectorLayer.getId()) return false;
			else return (this.getId().equals(vectorLayer.getId()));
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