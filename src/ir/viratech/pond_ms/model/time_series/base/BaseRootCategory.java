package ir.viratech.pond_ms.model.time_series.base;

import java.io.Serializable;


/**
 *  Base class for entity "ir.viratech.pond_ms.model.time_series.RootCategory".
 *  It is an automatically generated file and should not be edited.
 *
 * @hibernate.class
 *  table="pond_ms.ROOT_CATEGORY"
 */

public abstract class BaseRootCategory extends ir.viratech.pond_ms.model.time_series.ParentCategory  implements Serializable {
	private static final long serialVersionUID = 1L;


	/** The constant referring the name of class "RootCategory". */
	public static final String REF = "RootCategory";
	
	/** The constant referring the property "id". */
	public static final String PROP_ID = "id";
	
	/** The constant referring the property "group". */
	public static final String PROP_GROUP = "group";
	
	/** The constant referring the property "pond". */
	public static final String PROP_POND = "pond";
	
	/** The constant referring the property "GISVectorObject". */
	public static final String PROP_G_I_S_VECTOR_OBJECT = "GISVectorObject";
	
	/** The constant referring the property "dataFile". */
	public static final String PROP_DATA_FILE = "dataFile";
	
	
	/** The name of table for this class. */
	public static final String TABLE = "pond_ms.ROOT_CATEGORY";
	
	/** Name of column referring the property "id". */
	public static final String PROPCOLUMN_ID = "id";
	
	/** Name of column referring the property "group". */
	public static final String PROPCOLUMN_GROUP = "group_id";
	
	/** Name of column referring the property "pond". */
	public static final String PROPCOLUMN_POND = "pond_id";
	
	/** Name of column referring the property "GISVectorObject". */
	public static final String PROPCOLUMN_G_I_S_VECTOR_OBJECT = "object_id";
	
	/** Name of column referring the property "dataFile". */
	public static final String PROPCOLUMN_DATA_FILE = "dataFile";
	
	

	
	
	


	private int hashCode_ = Integer.MIN_VALUE;


	// many to one
	private ir.viratech.pond_ms.model.time_series.TimeSeriesGroup group;
	private ir.viratech.pond_ms.model.layer.Pond pond;
	private ir.viratech.pond_ms.model.map_object.vector.GISVectorObject gISVectorObject;
	private ir.viratech.pond_ms.model.file.DataFile dataFile;






	/**
	 * Getter for "group".
	 * column= group_id
	 *
	 * @return the value of group
	 */
	public ir.viratech.pond_ms.model.time_series.TimeSeriesGroup getGroup() {
		return this.group;
	}

	/**
	 * Setter for property "group".
	 * column= group_id
	 *
	 * @param group the new value for group
	 */
	public void setGroup(ir.viratech.pond_ms.model.time_series.TimeSeriesGroup group) {
		this.group = group;
	}



	/**
	 * Getter for "pond".
	 * column= pond_id
	 *
	 * @return the value of pond
	 */
	public ir.viratech.pond_ms.model.layer.Pond getPond() {
		return this.pond;
	}

	/**
	 * Setter for property "pond".
	 * column= pond_id
	 *
	 * @param pond the new value for pond
	 */
	public void setPond(ir.viratech.pond_ms.model.layer.Pond pond) {
		this.pond = pond;
	}



	/**
	 * Getter for "gISVectorObject".
	 * column= object_id
	 *
	 * @return the value of gISVectorObject
	 */
	public ir.viratech.pond_ms.model.map_object.vector.GISVectorObject getGISVectorObject() {
		return this.gISVectorObject;
	}

	/**
	 * Setter for property "gISVectorObject".
	 * column= object_id
	 *
	 * @param gISVectorObject the new value for gISVectorObject
	 */
	public void setGISVectorObject(ir.viratech.pond_ms.model.map_object.vector.GISVectorObject gISVectorObject) {
		this.gISVectorObject = gISVectorObject;
	}



	/**
	 * Getter for "dataFile".
	 * column= dataFile
	 *
	 * @return the value of dataFile
	 */
	public ir.viratech.pond_ms.model.file.DataFile getDataFile() {
		return this.dataFile;
	}

	/**
	 * Setter for property "dataFile".
	 * column= dataFile
	 *
	 * @param dataFile the new value for dataFile
	 */
	public void setDataFile(ir.viratech.pond_ms.model.file.DataFile dataFile) {
		this.dataFile = dataFile;
	}




	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (null == obj) return false;
		if (!(obj instanceof ir.viratech.pond_ms.model.time_series.RootCategory)) return false;
		else {
			ir.viratech.pond_ms.model.time_series.RootCategory rootCategory = (ir.viratech.pond_ms.model.time_series.RootCategory) obj;
			if (null == this.getId() || null == rootCategory.getId()) return false;
			else return (this.getId().equals(rootCategory.getId()));
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