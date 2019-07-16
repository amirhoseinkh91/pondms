package ir.viratech.pond_ms.model.layer.base;


import ir.viratech.pond_ms.model.layer.ParentLayer;
import ir.viratech.pond_ms.model.layer.dao.ParentLayerDAO;


/**
 *  Base Mgr class for entity "ir.viratech.pond_ms.model.layer.ParentLayer". 
 *  It is an automatically generated file and should not be edited.
 */
public abstract class BaseParentLayerMgr extends ir.viratech.base.AbstractEntityMgr<ParentLayer, java.lang.Long> {


	private ParentLayerDAO parentLayerDAO = ParentLayerDAO.getInstance();	

	@Override
	protected ParentLayerDAO getDAO() {
		return this.parentLayerDAO;
	}


	protected BaseParentLayerMgr () {}
	



	/**
	 * Gets the Mgr instance from Spring.
	 *
	 * @return the instance of ParentLayerDAO
	 */
	public static ir.viratech.pond_ms.model.layer.logic.ParentLayerMgr getInstance() {
		return ir.viratech.commons.spring.context.ApplicationContextProvider.getInitializedApplicationContext().getBean(ir.viratech.pond_ms.model.layer.logic.ParentLayerMgr.class);
	}






}