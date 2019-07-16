package ir.viratech.pond_ms.model.layer.base;


import ir.viratech.pond_ms.model.layer.Layer;
import ir.viratech.pond_ms.model.layer.dao.LayerDAO;


/**
 *  Base Mgr class for entity "ir.viratech.pond_ms.model.layer.Layer". 
 *  It is an automatically generated file and should not be edited.
 */
public abstract class BaseLayerMgr extends ir.viratech.base.AbstractEntityMgr<Layer, java.lang.Long> {


	private LayerDAO layerDAO = LayerDAO.getInstance();	

	@Override
	protected LayerDAO getDAO() {
		return this.layerDAO;
	}


	protected BaseLayerMgr () {}
	



	/**
	 * Gets the Mgr instance from Spring.
	 *
	 * @return the instance of LayerDAO
	 */
	public static ir.viratech.pond_ms.model.layer.logic.LayerMgr getInstance() {
		return ir.viratech.commons.spring.context.ApplicationContextProvider.getInitializedApplicationContext().getBean(ir.viratech.pond_ms.model.layer.logic.LayerMgr.class);
	}



	/**
	 * Unique finder method for "extuid".
	 *
	 * @param extuid the value of extuid
	 * @return the unique matching object
	 */
	@ir.viratech.commons.spring.tx.ReadTransactional
	public ir.viratech.pond_ms.model.layer.Layer getByExtuid(java.lang.String extuid) {
		return this.getDAO().getByExtuid(extuid);
	}




}