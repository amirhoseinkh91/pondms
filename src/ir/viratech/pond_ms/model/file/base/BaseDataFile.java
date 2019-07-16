package ir.viratech.pond_ms.model.file.base;

import java.io.Serializable;


/**
 *  Base class for entity "ir.viratech.pond_ms.model.file.DataFile".
 *  It is an automatically generated file and should not be edited.
 *
 * @hibernate.class
 *  table="pond_ms.DATA_FILES"
 */

public abstract class BaseDataFile  implements Serializable {
	private static final long serialVersionUID = 1L;


	/** The constant referring the name of class "DataFile". */
	public static final String REF = "DataFile";
	
	/** The constant referring the property "id". */
	public static final String PROP_ID = "id";
	
	/** The constant referring the property "extuid". */
	public static final String PROP_EXTUID = "extuid";
	
	/** The constant referring the property "dataReference". */
	public static final String PROP_DATA_REFERENCE = "dataReference";
	
	/** The constant referring the property "dataCollectionDate". */
	public static final String PROP_DATA_COLLECTION_DATE = "dataCollectionDate";
	
	/** The constant referring the property "abstractFile". */
	public static final String PROP_ABSTRACT_FILE = "abstractFile";
	
	
	/** The name of table for this class. */
	public static final String TABLE = "pond_ms.DATA_FILES";
	
	/** Name of column referring the property "id". */
	public static final String PROPCOLUMN_ID = "id";
	
	/** Name of column referring the property "extuid". */
	public static final String PROPCOLUMN_EXTUID = "extuid";
	
	/** Name of column referring the property "dataReference". */
	public static final String PROPCOLUMN_DATA_REFERENCE = "dataReference";
	
	/** Name of column referring the property "dataCollectionDate". */
	public static final String PROPCOLUMN_DATA_COLLECTION_DATE = "data_collection_date";
	
	/** Name of column referring the property "abstractFile". */
	public static final String PROPCOLUMN_ABSTRACT_FILE = "abstract_file";
	
	

	
	
	


	private int hashCode_ = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
	private java.lang.String extuid;
	private java.lang.String dataReference;
	private java.util.Date dataCollectionDate;

	// many to one
	private ir.viratech.commons.file.model.AbstractFile abstractFile;



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
	 * Getter for "dataReference".
	 * column= dataReference
	 *
	 * @return the value of dataReference
	 */
	public java.lang.String getDataReference() {
		return this.dataReference;
	}

	/**
	 * Setter for property "dataReference".
	 * column= dataReference
	 *
	 * @param dataReference the new value for dataReference
	 */
	public void setDataReference(java.lang.String dataReference) {
		this.dataReference = dataReference;
	}



	/**
	 * Getter for "dataCollectionDate".
	 * column= data_collection_date
	 *
	 * @return the value of dataCollectionDate
	 */
	public java.util.Date getDataCollectionDate() {
		return this.dataCollectionDate;
	}

	/**
	 * Setter for property "dataCollectionDate".
	 * column= data_collection_date
	 *
	 * @param dataCollectionDate the new value for dataCollectionDate
	 */
	public void setDataCollectionDate(java.util.Date dataCollectionDate) {
		this.dataCollectionDate = dataCollectionDate;
	}



	/**
	 * Getter for "abstractFile".
	 * column= abstract_file
	 *
	 * @return the value of abstractFile
	 */
	public ir.viratech.commons.file.model.AbstractFile getAbstractFile() {
		return this.abstractFile;
	}

	/**
	 * Setter for property "abstractFile".
	 * column= abstract_file
	 *
	 * @param abstractFile the new value for abstractFile
	 */
	public void setAbstractFile(ir.viratech.commons.file.model.AbstractFile abstractFile) {
		this.abstractFile = abstractFile;
	}




	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (null == obj) return false;
		if (!(obj instanceof ir.viratech.pond_ms.model.file.DataFile)) return false;
		else {
			ir.viratech.pond_ms.model.file.DataFile dataFile = (ir.viratech.pond_ms.model.file.DataFile) obj;
			boolean isEqual = true;
			if (null == this.getExtuid() || null == dataFile.getExtuid()) return false;
			else isEqual = isEqual && (this.getExtuid().equals(dataFile.getExtuid()));
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