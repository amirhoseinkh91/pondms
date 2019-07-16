package ir.viratech.pond_ms.model.layer.base;

import java.io.Serializable;


/**
 *  Base class for entity "ir.viratech.pond_ms.model.layer.RasterLayer".
 *  It is an automatically generated file and should not be edited.
 *
 * @hibernate.class
 *  table="pond_ms.RASTER_LAYERS"
 */

public abstract class BaseRasterLayer extends ir.viratech.pond_ms.model.layer.LeafLayer  implements Serializable {
	private static final long serialVersionUID = 1L;


	/** The constant referring the name of class "RasterLayer". */
	public static final String REF = "RasterLayer";
	
	/** The constant referring the property "id". */
	public static final String PROP_ID = "id";
	
	/** The constant referring the property "gradient". */
	public static final String PROP_GRADIENT = "gradient";
	
	/** The constant referring the property "rasterFile". */
	public static final String PROP_RASTER_FILE = "rasterFile";
	
	
	/** The name of table for this class. */
	public static final String TABLE = "pond_ms.RASTER_LAYERS";
	
	/** Name of column referring the property "id". */
	public static final String PROPCOLUMN_ID = "id";
	
	/** Name of column referring the property "gradient". */
	public static final String PROPCOLUMN_GRADIENT = "gradient";
	
	/** Name of column referring the property "rasterFile". */
	public static final String PROPCOLUMN_RASTER_FILE = "rasterFile";
	
	

	
	
	


	private int hashCode_ = Integer.MIN_VALUE;


	// many to one
	private ir.viratech.pond_ms.model.gradient.Gradient gradient;
	private ir.viratech.commons.file.model.AbstractFile rasterFile;






	/**
	 * Getter for "gradient".
	 * column= gradient
	 *
	 * @return the value of gradient
	 */
	public ir.viratech.pond_ms.model.gradient.Gradient getGradient() {
		return this.gradient;
	}

	/**
	 * Setter for property "gradient".
	 * column= gradient
	 *
	 * @param gradient the new value for gradient
	 */
	public void setGradient(ir.viratech.pond_ms.model.gradient.Gradient gradient) {
		this.gradient = gradient;
	}



	/**
	 * Getter for "rasterFile".
	 * column= rasterFile
	 *
	 * @return the value of rasterFile
	 */
	public ir.viratech.commons.file.model.AbstractFile getRasterFile() {
		return this.rasterFile;
	}

	/**
	 * Setter for property "rasterFile".
	 * column= rasterFile
	 *
	 * @param rasterFile the new value for rasterFile
	 */
	public void setRasterFile(ir.viratech.commons.file.model.AbstractFile rasterFile) {
		this.rasterFile = rasterFile;
	}




	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (null == obj) return false;
		if (!(obj instanceof ir.viratech.pond_ms.model.layer.RasterLayer)) return false;
		else {
			ir.viratech.pond_ms.model.layer.RasterLayer rasterLayer = (ir.viratech.pond_ms.model.layer.RasterLayer) obj;
			if (null == this.getId() || null == rasterLayer.getId()) return false;
			else return (this.getId().equals(rasterLayer.getId()));
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