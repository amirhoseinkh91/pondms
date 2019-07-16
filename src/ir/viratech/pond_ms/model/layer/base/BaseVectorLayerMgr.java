package ir.viratech.pond_ms.model.layer.base;


import ir.viratech.pond_ms.model.layer.VectorLayer;
import ir.viratech.pond_ms.model.layer.dao.VectorLayerDAO;


/**
 *  Base Mgr class for entity "ir.viratech.pond_ms.model.layer.VectorLayer". 
 *  It is an automatically generated file and should not be edited.
 */
public abstract class BaseVectorLayerMgr extends ir.viratech.base.AbstractEntityMgr<VectorLayer, java.lang.Long> {


	private VectorLayerDAO vectorLayerDAO = VectorLayerDAO.getInstance();	

	@Override
	protected VectorLayerDAO getDAO() {
		return this.vectorLayerDAO;
	}


	protected BaseVectorLayerMgr () {}
	



	/**
	 * Gets the Mgr instance from Spring.
	 *
	 * @return the instance of VectorLayerDAO
	 */
	public static ir.viratech.pond_ms.model.layer.logic.VectorLayerMgr getInstance() {
		return ir.viratech.commons.spring.context.ApplicationContextProvider.getInitializedApplicationContext().getBean(ir.viratech.pond_ms.model.layer.logic.VectorLayerMgr.class);
	}






}