package ir.viratech.pond_ms.model.layer.base;




/**
 *  Base DAO class for entity "ir.viratech.pond_ms.model.layer.ParentLayer". 
 *  It is an automatically generated file and should not be edited.
 */
public abstract class BaseParentLayerDAO extends ir.viratech.base.AbstractEntityDAO<ir.viratech.pond_ms.model.layer.ParentLayer, java.lang.Long> {

	

	// query name references


	/**
	 * Gets the DAO instance from Spring.
	 *
	 * @return the instance of ParentLayerMgr
	 */
	public static ir.viratech.pond_ms.model.layer.dao.ParentLayerDAO getInstance() {
		return ir.viratech.commons.spring.context.ApplicationContextProvider.getInitializedApplicationContext().getBean(ir.viratech.pond_ms.model.layer.dao.ParentLayerDAO.class);
	}

	/* (non-Javadoc)
	 * @see ir.viratech.commons.persistence.base.BaseAbstractEntityDAO#getReferenceClass()
	 */
	@Override
	public Class<ir.viratech.pond_ms.model.layer.ParentLayer> getReferenceClass() {
		return ir.viratech.pond_ms.model.layer.ParentLayer.class;
	}
	
	/* (non-Javadoc)
	 * @see ir.viratech.commons.persistence.base.BaseAbstractEntityDAO#getId(java.lang.Object)
	 */
	@Override
	public java.lang.Long getId(ir.viratech.pond_ms.model.layer.ParentLayer parentLayer) {
		return parentLayer.getId();
	}
	







	@Override
	public void initialize(ir.viratech.pond_ms.model.layer.ParentLayer parentLayer) {
		ir.viratech.pond_ms.model.layer.dao.LayerDAO.getInstance().initialize(parentLayer); 
	}
	



}