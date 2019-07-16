package ir.viratech.pond_ms.model.layer.base;


import ir.viratech.pond_ms.model.layer.RasterLayer;
import ir.viratech.pond_ms.model.layer.dao.RasterLayerDAO;


/**
 *  Base Mgr class for entity "ir.viratech.pond_ms.model.layer.RasterLayer". 
 *  It is an automatically generated file and should not be edited.
 */
public abstract class BaseRasterLayerMgr extends ir.viratech.base.AbstractEntityMgr<RasterLayer, java.lang.Long> {


	private RasterLayerDAO rasterLayerDAO = RasterLayerDAO.getInstance();	

	@Override
	protected RasterLayerDAO getDAO() {
		return this.rasterLayerDAO;
	}


	protected BaseRasterLayerMgr () {}
	



	/**
	 * Gets the Mgr instance from Spring.
	 *
	 * @return the instance of RasterLayerDAO
	 */
	public static ir.viratech.pond_ms.model.layer.logic.RasterLayerMgr getInstance() {
		return ir.viratech.commons.spring.context.ApplicationContextProvider.getInitializedApplicationContext().getBean(ir.viratech.pond_ms.model.layer.logic.RasterLayerMgr.class);
	}



	/**
	 * Unique finder method for "rasterFile".
	 *
	 * @param rasterFile the value of rasterFile
	 * @return the unique matching object
	 */
	@ir.viratech.commons.spring.tx.ReadTransactional
	public ir.viratech.pond_ms.model.layer.RasterLayer getByRasterFile(ir.viratech.commons.file.model.AbstractFile rasterFile) {
		return this.getDAO().getByRasterFile(rasterFile);
	}




}