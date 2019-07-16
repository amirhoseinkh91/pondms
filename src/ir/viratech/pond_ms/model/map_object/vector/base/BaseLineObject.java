package ir.viratech.pond_ms.model.map_object.vector.base;

import java.io.Serializable;


/**
 *  Base class for entity "ir.viratech.pond_ms.model.map_object.vector.LineObject".
 *  It is an automatically generated file and should not be edited.
 *
 * @hibernate.class
 *  table="pond_ms.LINE_OBJECTS"
 */

public abstract class BaseLineObject extends ir.viratech.pond_ms.model.map_object.vector.GISVectorObject  implements Serializable {
	private static final long serialVersionUID = 1L;


	/** The constant referring the name of class "LineObject". */
	public static final String REF = "LineObject";
	
	/** The constant referring the property "id". */
	public static final String PROP_ID = "id";
	
	/** The constant referring the property "line". */
	public static final String PROP_LINE = "line";
	
	
	/** The name of table for this class. */
	public static final String TABLE = "pond_ms.LINE_OBJECTS";
	
	/** Name of column referring the property "id". */
	public static final String PROPCOLUMN_ID = "id";
	
	/** Name of column referring the property "line". */
	public static final String PROPCOLUMN_LINE = "line";
	
	

	
	
	


	private int hashCode_ = Integer.MIN_VALUE;


	// fields
	private com.vividsolutions.jts.geom.LineString line;






	/**
	 * Getter for "line".
	 * column= line
	 *
	 * @return the value of line
	 */
	public com.vividsolutions.jts.geom.LineString getLine() {
		return this.line;
	}

	/**
	 * Setter for property "line".
	 * column= line
	 *
	 * @param line the new value for line
	 */
	public void setLine(com.vividsolutions.jts.geom.LineString line) {
		this.line = line;
	}




	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (null == obj) return false;
		if (!(obj instanceof ir.viratech.pond_ms.model.map_object.vector.LineObject)) return false;
		else {
			ir.viratech.pond_ms.model.map_object.vector.LineObject lineObject = (ir.viratech.pond_ms.model.map_object.vector.LineObject) obj;
			if (null == this.getId() || null == lineObject.getId()) return false;
			else return (this.getId().equals(lineObject.getId()));
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