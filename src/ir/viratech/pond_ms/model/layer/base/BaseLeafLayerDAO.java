package ir.viratech.pond_ms.model.layer.base;




/**
 *  Base DAO class for entity "ir.viratech.pond_ms.model.layer.LeafLayer". 
 *  It is an automatically generated file and should not be edited.
 */
public abstract class BaseLeafLayerDAO extends ir.viratech.base.AbstractEntityDAO<ir.viratech.pond_ms.model.layer.LeafLayer, java.lang.Long> {

	

	// query name references


	/**
	 * Gets the DAO instance from Spring.
	 *
	 * @return the instance of LeafLayerMgr
	 */
	public static ir.viratech.pond_ms.model.layer.dao.LeafLayerDAO getInstance() {
		return ir.viratech.commons.spring.context.ApplicationContextProvider.getInitializedApplicationContext().getBean(ir.viratech.pond_ms.model.layer.dao.LeafLayerDAO.class);
	}

	/* (non-Javadoc)
	 * @see ir.viratech.commons.persistence.base.BaseAbstractEntityDAO#getReferenceClass()
	 */
	@Override
	public Class<ir.viratech.pond_ms.model.layer.LeafLayer> getReferenceClass() {
		return ir.viratech.pond_ms.model.layer.LeafLayer.class;
	}
	
	/* (non-Javadoc)
	 * @see ir.viratech.commons.persistence.base.BaseAbstractEntityDAO#getId(java.lang.Object)
	 */
	@Override
	public java.lang.Long getId(ir.viratech.pond_ms.model.layer.LeafLayer leafLayer) {
		return leafLayer.getId();
	}
	







	@Override
	public void initialize(ir.viratech.pond_ms.model.layer.LeafLayer leafLayer) {
		ir.viratech.pond_ms.model.layer.dao.LayerDAO.getInstance().initialize(leafLayer); 
	}
	



}