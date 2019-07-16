package ir.viratech.pond_ms.model.layer.base;


import ir.viratech.pond_ms.model.layer.LeafLayer;
import ir.viratech.pond_ms.model.layer.dao.LeafLayerDAO;


/**
 *  Base Mgr class for entity "ir.viratech.pond_ms.model.layer.LeafLayer". 
 *  It is an automatically generated file and should not be edited.
 */
public abstract class BaseLeafLayerMgr extends ir.viratech.base.AbstractEntityMgr<LeafLayer, java.lang.Long> {


	private LeafLayerDAO leafLayerDAO = LeafLayerDAO.getInstance();	

	@Override
	protected LeafLayerDAO getDAO() {
		return this.leafLayerDAO;
	}


	protected BaseLeafLayerMgr () {}
	



	/**
	 * Gets the Mgr instance from Spring.
	 *
	 * @return the instance of LeafLayerDAO
	 */
	public static ir.viratech.pond_ms.model.layer.logic.LeafLayerMgr getInstance() {
		return ir.viratech.commons.spring.context.ApplicationContextProvider.getInitializedApplicationContext().getBean(ir.viratech.pond_ms.model.layer.logic.LeafLayerMgr.class);
	}






}