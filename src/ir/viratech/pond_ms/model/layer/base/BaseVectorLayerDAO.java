package ir.viratech.pond_ms.model.layer.base;




/**
 *  Base DAO class for entity "ir.viratech.pond_ms.model.layer.VectorLayer". 
 *  It is an automatically generated file and should not be edited.
 */
public abstract class BaseVectorLayerDAO extends ir.viratech.base.AbstractEntityDAO<ir.viratech.pond_ms.model.layer.VectorLayer, java.lang.Long> {

	

	// query name references


	/**
	 * Gets the DAO instance from Spring.
	 *
	 * @return the instance of VectorLayerMgr
	 */
	public static ir.viratech.pond_ms.model.layer.dao.VectorLayerDAO getInstance() {
		return ir.viratech.commons.spring.context.ApplicationContextProvider.getInitializedApplicationContext().getBean(ir.viratech.pond_ms.model.layer.dao.VectorLayerDAO.class);
	}

	/* (non-Javadoc)
	 * @see ir.viratech.commons.persistence.base.BaseAbstractEntityDAO#getReferenceClass()
	 */
	@Override
	public Class<ir.viratech.pond_ms.model.layer.VectorLayer> getReferenceClass() {
		return ir.viratech.pond_ms.model.layer.VectorLayer.class;
	}
	
	/* (non-Javadoc)
	 * @see ir.viratech.commons.persistence.base.BaseAbstractEntityDAO#getId(java.lang.Object)
	 */
	@Override
	public java.lang.Long getId(ir.viratech.pond_ms.model.layer.VectorLayer vectorLayer) {
		return vectorLayer.getId();
	}
	







	@Override
	public void initialize(ir.viratech.pond_ms.model.layer.VectorLayer vectorLayer) {
		ir.viratech.pond_ms.model.layer.dao.LeafLayerDAO.getInstance().initialize(vectorLayer); 
	}
	



}