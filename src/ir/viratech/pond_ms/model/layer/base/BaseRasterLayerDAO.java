package ir.viratech.pond_ms.model.layer.base;




/**
 *  Base DAO class for entity "ir.viratech.pond_ms.model.layer.RasterLayer". 
 *  It is an automatically generated file and should not be edited.
 */
public abstract class BaseRasterLayerDAO extends ir.viratech.base.AbstractEntityDAO<ir.viratech.pond_ms.model.layer.RasterLayer, java.lang.Long> {

	

	// query name references


	/**
	 * Gets the DAO instance from Spring.
	 *
	 * @return the instance of RasterLayerMgr
	 */
	public static ir.viratech.pond_ms.model.layer.dao.RasterLayerDAO getInstance() {
		return ir.viratech.commons.spring.context.ApplicationContextProvider.getInitializedApplicationContext().getBean(ir.viratech.pond_ms.model.layer.dao.RasterLayerDAO.class);
	}

	/* (non-Javadoc)
	 * @see ir.viratech.commons.persistence.base.BaseAbstractEntityDAO#getReferenceClass()
	 */
	@Override
	public Class<ir.viratech.pond_ms.model.layer.RasterLayer> getReferenceClass() {
		return ir.viratech.pond_ms.model.layer.RasterLayer.class;
	}
	
	/* (non-Javadoc)
	 * @see ir.viratech.commons.persistence.base.BaseAbstractEntityDAO#getId(java.lang.Object)
	 */
	@Override
	public java.lang.Long getId(ir.viratech.pond_ms.model.layer.RasterLayer rasterLayer) {
		return rasterLayer.getId();
	}
	




	/**
	 * Unique finder method for "rasterFile".
	 *
	 * @param rasterFile the value of rasterFile
	 * @return the unique matching object
	 */
	public ir.viratech.pond_ms.model.layer.RasterLayer getByRasterFile(ir.viratech.commons.file.model.AbstractFile rasterFile) {
		return this.getByUniqueProp(ir.viratech.pond_ms.model.layer.RasterLayer.PROP_RASTER_FILE, rasterFile);
	}




	@Override
	public void initialize(ir.viratech.pond_ms.model.layer.RasterLayer rasterLayer) {
		ir.viratech.pond_ms.model.layer.dao.LeafLayerDAO.getInstance().initialize(rasterLayer); 
	}
	



}