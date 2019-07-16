package ir.viratech.pond_ms.model.layer.base;


import ir.viratech.pond_ms.model.layer.Pond;
import ir.viratech.pond_ms.model.layer.dao.PondDAO;


/**
 *  Base Mgr class for entity "ir.viratech.pond_ms.model.layer.Pond". 
 *  It is an automatically generated file and should not be edited.
 */
public abstract class BasePondMgr extends ir.viratech.base.AbstractEntityMgr<Pond, java.lang.Long> {


	private PondDAO pondDAO = PondDAO.getInstance();	

	@Override
	protected PondDAO getDAO() {
		return this.pondDAO;
	}


	protected BasePondMgr () {}
	



	/**
	 * Gets the Mgr instance from Spring.
	 *
	 * @return the instance of PondDAO
	 */
	public static ir.viratech.pond_ms.model.layer.logic.PondMgr getInstance() {
		return ir.viratech.commons.spring.context.ApplicationContextProvider.getInitializedApplicationContext().getBean(ir.viratech.pond_ms.model.layer.logic.PondMgr.class);
	}



	/**
	 * Unique finder method for "extuid".
	 *
	 * @param extuid the value of extuid
	 * @return the unique matching object
	 */
	@ir.viratech.commons.spring.tx.ReadTransactional
	public ir.viratech.pond_ms.model.layer.Pond getByExtuid(java.lang.String extuid) {
		return this.getDAO().getByExtuid(extuid);
	}

	/**
	 * Unique finder method for "layer".
	 *
	 * @param layer the value of layer
	 * @return the unique matching object
	 */
	@ir.viratech.commons.spring.tx.ReadTransactional
	public ir.viratech.pond_ms.model.layer.Pond getByLayer(ir.viratech.pond_ms.model.layer.ParentLayer layer) {
		return this.getDAO().getByLayer(layer);
	}




}