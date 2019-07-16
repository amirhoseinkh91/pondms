package ir.viratech.pond_ms.model.layer.base;




/**
 *  Base DAO class for entity "ir.viratech.pond_ms.model.layer.Layer". 
 *  It is an automatically generated file and should not be edited.
 */
public abstract class BaseLayerDAO extends ir.viratech.base.AbstractEntityDAO<ir.viratech.pond_ms.model.layer.Layer, java.lang.Long> {

	

	// query name references


	/**
	 * Gets the DAO instance from Spring.
	 *
	 * @return the instance of LayerMgr
	 */
	public static ir.viratech.pond_ms.model.layer.dao.LayerDAO getInstance() {
		return ir.viratech.commons.spring.context.ApplicationContextProvider.getInitializedApplicationContext().getBean(ir.viratech.pond_ms.model.layer.dao.LayerDAO.class);
	}

	/* (non-Javadoc)
	 * @see ir.viratech.commons.persistence.base.BaseAbstractEntityDAO#getReferenceClass()
	 */
	@Override
	public Class<ir.viratech.pond_ms.model.layer.Layer> getReferenceClass() {
		return ir.viratech.pond_ms.model.layer.Layer.class;
	}
	
	/* (non-Javadoc)
	 * @see ir.viratech.commons.persistence.base.BaseAbstractEntityDAO#getId(java.lang.Object)
	 */
	@Override
	public java.lang.Long getId(ir.viratech.pond_ms.model.layer.Layer layer) {
		return layer.getId();
	}
	




	/**
	 * Unique finder method for "extuid".
	 *
	 * @param extuid the value of extuid
	 * @return the unique matching object
	 */
	public ir.viratech.pond_ms.model.layer.Layer getByExtuid(java.lang.String extuid) {
		return this.getByUniqueProp(ir.viratech.pond_ms.model.layer.Layer.PROP_EXTUID, extuid);
	}




	@Override
	public void initialize(ir.viratech.pond_ms.model.layer.Layer layer) {
		super.initialize(layer);
		layer.setExtuid(this.generateUid());
		layer.setCreationDate(new java.util.Date());
	}
	



}