package ir.viratech.pond_ms.model.map_object.vector.base;

import java.io.Serializable;


/**
 *  Base class for entity "ir.viratech.pond_ms.model.map_object.vector.PointObject".
 *  It is an automatically generated file and should not be edited.
 *
 * @hibernate.class
 *  table="pond_ms.POINT_OBJECTS"
 */

public abstract class BasePointObject extends ir.viratech.pond_ms.model.map_object.vector.GISVectorObject  implements Serializable {
	private static final long serialVersionUID = 1L;


	/** The constant referring the name of class "PointObject". */
	public static final String REF = "PointObject";
	
	/** The constant referring the property "id". */
	public static final String PROP_ID = "id";
	
	/** The constant referring the property "point". */
	public static final String PROP_POINT = "point";
	
	
	/** The name of table for this class. */
	public static final String TABLE = "pond_ms.POINT_OBJECTS";
	
	/** Name of column referring the property "id". */
	public static final String PROPCOLUMN_ID = "id";
	
	/** Name of column referring the property "point". */
	public static final String PROPCOLUMN_POINT = "point";
	
	

	
	
	


	private int hashCode_ = Integer.MIN_VALUE;


	// fields
	private com.vividsolutions.jts.geom.Point point;






	/**
	 * Getter for "point".
	 * column= point
	 *
	 * @return the value of point
	 */
	public com.vividsolutions.jts.geom.Point getPoint() {
		return this.point;
	}

	/**
	 * Setter for property "point".
	 * column= point
	 *
	 * @param point the new value for point
	 */
	public void setPoint(com.vividsolutions.jts.geom.Point point) {
		this.point = point;
	}




	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (null == obj) return false;
		if (!(obj instanceof ir.viratech.pond_ms.model.map_object.vector.PointObject)) return false;
		else {
			ir.viratech.pond_ms.model.map_object.vector.PointObject pointObject = (ir.viratech.pond_ms.model.map_object.vector.PointObject) obj;
			if (null == this.getId() || null == pointObject.getId()) return false;
			else return (this.getId().equals(pointObject.getId()));
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