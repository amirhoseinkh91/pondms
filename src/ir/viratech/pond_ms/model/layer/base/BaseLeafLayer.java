package ir.viratech.pond_ms.model.layer.base;

import java.io.Serializable;


/**
 *  Base class for entity "ir.viratech.pond_ms.model.layer.LeafLayer".
 *  It is an automatically generated file and should not be edited.
 *
 * @hibernate.class
 *  table="pond_ms.LEAF_LAYERS"
 */

public abstract class BaseLeafLayer extends ir.viratech.pond_ms.model.layer.Layer  implements Serializable {
	private static final long serialVersionUID = 1L;


	/** The constant referring the name of class "LeafLayer". */
	public static final String REF = "LeafLayer";
	
	/** The constant referring the property "id". */
	public static final String PROP_ID = "id";
	
	/** The constant referring the property "dataFiles". */
	public static final String PROP_DATA_FILES = "dataFiles";
	
	
	/** The name of table for this class. */
	public static final String TABLE = "pond_ms.LEAF_LAYERS";
	
	/** Name of column referring the property "id". */
	public static final String PROPCOLUMN_ID = "id";
	
	

	
	
	


	private int hashCode_ = Integer.MIN_VALUE;


	// collections
	private java.util.List<ir.viratech.pond_ms.model.file.DataFile> dataFiles;






	/**
	 * Getter for "dataFiles".
	 *
	 * @return the value of dataFiles
	 */
	public java.util.List<ir.viratech.pond_ms.model.file.DataFile> getDataFiles() {
		return this.dataFiles;
	}

	/**
	 * Setter for property "dataFiles".
	 *
	 * @param dataFiles the new value for dataFiles
	 */
	public void setDataFiles(java.util.List<ir.viratech.pond_ms.model.file.DataFile> dataFiles) {
		this.dataFiles = dataFiles;
	}
	/**
	 * Gets dataFiles, and creates and sets a new instance if it is null.
	 *
	 * @return the value of property dataFiles
	 */
	public java.util.List<ir.viratech.pond_ms.model.file.DataFile> getCreatedDataFiles() {
		if (null == getDataFiles()) this.setDataFiles(new java.util.ArrayList<ir.viratech.pond_ms.model.file.DataFile>());
		return this.getDataFiles();
	}
	
	/**
	 * Adds a member to "dataFiles".
	 * It creates the collection if it is null.
	 *
	 * @param dataFile the new member to be added
	 */
	public void addToDataFiles(ir.viratech.pond_ms.model.file.DataFile dataFile) {
		this.getCreatedDataFiles().add(dataFile);
	}
	
	/**
	 * Adds a member to "dataFiles".
	 * It creates the collection if it is null.
	 *
	 * @param dataFile the new member to be added
	 * @deprecated Use {@link #addToDataFiles(ir.viratech.pond_ms.model.file.DataFile)} instead.
	 */
	@Deprecated
	public final void addTodataFiles(ir.viratech.pond_ms.model.file.DataFile dataFile) {
		this.addToDataFiles(dataFile);
	}
	
	/**
	 * Removes a member from "dataFiles".
	 * It does nothing if the collection is null.
	 *
	 * @param dataFile the member to be removed
	 */
	public void removeFromDataFiles(ir.viratech.pond_ms.model.file.DataFile dataFile) {
		if (null != this.getDataFiles()) {
			this.getDataFiles().remove(dataFile);
		}
	}




	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (null == obj) return false;
		if (!(obj instanceof ir.viratech.pond_ms.model.layer.LeafLayer)) return false;
		else {
			ir.viratech.pond_ms.model.layer.LeafLayer leafLayer = (ir.viratech.pond_ms.model.layer.LeafLayer) obj;
			if (null == this.getId() || null == leafLayer.getId()) return false;
			else return (this.getId().equals(leafLayer.getId()));
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