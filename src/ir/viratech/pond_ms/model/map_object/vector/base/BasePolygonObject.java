package ir.viratech.pond_ms.model.map_object.vector.base;

import java.io.Serializable;


/**
 *  Base class for entity "ir.viratech.pond_ms.model.map_object.vector.PolygonObject".
 *  It is an automatically generated file and should not be edited.
 *
 * @hibernate.class
 *  table="pond_ms.POLYGON_OBJECTS"
 */

public abstract class BasePolygonObject extends ir.viratech.pond_ms.model.map_object.vector.GISVectorObject  implements Serializable {
	private static final long serialVersionUID = 1L;


	/** The constant referring the name of class "PolygonObject". */
	public static final String REF = "PolygonObject";
	
	/** The constant referring the property "id". */
	public static final String PROP_ID = "id";
	
	/** The constant referring the property "polygon". */
	public static final String PROP_POLYGON = "polygon";
	
	
	/** The name of table for this class. */
	public static final String TABLE = "pond_ms.POLYGON_OBJECTS";
	
	/** Name of column referring the property "id". */
	public static final String PROPCOLUMN_ID = "id";
	
	/** Name of column referring the property "polygon". */
	public static final String PROPCOLUMN_POLYGON = "polygon";
	
	

	
	
	


	private int hashCode_ = Integer.MIN_VALUE;


	// fields
	private com.vividsolutions.jts.geom.Polygon polygon;






	/**
	 * Getter for "polygon".
	 * column= polygon
	 *
	 * @return the value of polygon
	 */
	public com.vividsolutions.jts.geom.Polygon getPolygon() {
		return this.polygon;
	}

	/**
	 * Setter for property "polygon".
	 * column= polygon
	 *
	 * @param polygon the new value for polygon
	 */
	public void setPolygon(com.vividsolutions.jts.geom.Polygon polygon) {
		this.polygon = polygon;
	}




	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (null == obj) return false;
		if (!(obj instanceof ir.viratech.pond_ms.model.map_object.vector.PolygonObject)) return false;
		else {
			ir.viratech.pond_ms.model.map_object.vector.PolygonObject polygonObject = (ir.viratech.pond_ms.model.map_object.vector.PolygonObject) obj;
			if (null == this.getId() || null == polygonObject.getId()) return false;
			else return (this.getId().equals(polygonObject.getId()));
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