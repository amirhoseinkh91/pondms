package ir.viratech.pond_ms.model.layer.base;

import java.io.Serializable;


/**
 *  Base class for entity "ir.viratech.pond_ms.model.layer.ParentLayer".
 *  It is an automatically generated file and should not be edited.
 *
 * @hibernate.class
 *  table="pond_ms.PARENT_LAYER"
 */

public abstract class BaseParentLayer extends ir.viratech.pond_ms.model.layer.Layer  implements Serializable {
	private static final long serialVersionUID = 1L;


	/** The constant referring the name of class "ParentLayer". */
	public static final String REF = "ParentLayer";
	
	/** The constant referring the property "id". */
	public static final String PROP_ID = "id";
	
	/** The constant referring the property "subLayers". */
	public static final String PROP_SUB_LAYERS = "subLayers";
	
	
	/** The name of table for this class. */
	public static final String TABLE = "pond_ms.PARENT_LAYER";
	
	/** Name of column referring the property "id". */
	public static final String PROPCOLUMN_ID = "id";
	
	

	
	
	


	private int hashCode_ = Integer.MIN_VALUE;


	// collections
	private java.util.List<ir.viratech.pond_ms.model.layer.Layer> subLayers;






	/**
	 * Getter for "subLayers".
	 *
	 * @return the value of subLayers
	 */
	public java.util.List<ir.viratech.pond_ms.model.layer.Layer> getSubLayers() {
		return this.subLayers;
	}

	/**
	 * Setter for property "subLayers".
	 *
	 * @param subLayers the new value for subLayers
	 */
	public void setSubLayers(java.util.List<ir.viratech.pond_ms.model.layer.Layer> subLayers) {
		this.subLayers = subLayers;
	}
	/**
	 * Gets subLayers, and creates and sets a new instance if it is null.
	 *
	 * @return the value of property subLayers
	 */
	public java.util.List<ir.viratech.pond_ms.model.layer.Layer> getCreatedSubLayers() {
		if (null == getSubLayers()) this.setSubLayers(new java.util.ArrayList<ir.viratech.pond_ms.model.layer.Layer>());
		return this.getSubLayers();
	}
	
	/**
	 * Adds a member to "subLayers".
	 * It creates the collection if it is null.
	 *
	 * @param layer the new member to be added
	 */
	public void addToSubLayers(ir.viratech.pond_ms.model.layer.Layer layer) {
		this.getCreatedSubLayers().add(layer);
	}
	
	/**
	 * Adds a member to "subLayers".
	 * It creates the collection if it is null.
	 *
	 * @param layer the new member to be added
	 * @deprecated Use {@link #addToSubLayers(ir.viratech.pond_ms.model.layer.Layer)} instead.
	 */
	@Deprecated
	public final void addTosubLayers(ir.viratech.pond_ms.model.layer.Layer layer) {
		this.addToSubLayers(layer);
	}
	
	/**
	 * Removes a member from "subLayers".
	 * It does nothing if the collection is null.
	 *
	 * @param layer the member to be removed
	 */
	public void removeFromSubLayers(ir.viratech.pond_ms.model.layer.Layer layer) {
		if (null != this.getSubLayers()) {
			this.getSubLayers().remove(layer);
		}
	}
	
	/**
	 * Adds a member to "subLayers" and synchronizes the reverse association.
	 *
	 * @param layer the new member to be added
	 */
	public void addToSubLayers_AndReverse(ir.viratech.pond_ms.model.layer.Layer layer) {
		this.addToSubLayers(layer);
		layer.setParentLayer((ir.viratech.pond_ms.model.layer.ParentLayer)this);
	}
	
	/**
	 * Removes a member from "subLayers" and synchronizes the reverse association.
	 *
	 * @param layer the member to be removed
	 */
	public void removeFromSubLayers_AndReverse(ir.viratech.pond_ms.model.layer.Layer layer) {
		this.removeFromSubLayers(layer);
		layer.setParentLayer(null);
	}




	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (null == obj) return false;
		if (!(obj instanceof ir.viratech.pond_ms.model.layer.ParentLayer)) return false;
		else {
			ir.viratech.pond_ms.model.layer.ParentLayer parentLayer = (ir.viratech.pond_ms.model.layer.ParentLayer) obj;
			if (null == this.getId() || null == parentLayer.getId()) return false;
			else return (this.getId().equals(parentLayer.getId()));
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