package ir.viratech.pond_ms.model.map_object.vector.base;


import ir.viratech.pond_ms.model.map_object.vector.GISVectorObject;
import ir.viratech.pond_ms.model.map_object.vector.dao.GISVectorObjectDAO;


/**
 *  Base Mgr class for entity "ir.viratech.pond_ms.model.map_object.vector.GISVectorObject". 
 *  It is an automatically generated file and should not be edited.
 */
public abstract class BaseGISVectorObjectMgr extends ir.viratech.base.AbstractEntityMgr<GISVectorObject, java.lang.Long> {


	private GISVectorObjectDAO gISVectorObjectDAO = GISVectorObjectDAO.getInstance();	

	@Override
	protected GISVectorObjectDAO getDAO() {
		return this.gISVectorObjectDAO;
	}


	protected BaseGISVectorObjectMgr () {}
	



	/**
	 * Gets the Mgr instance from Spring.
	 *
	 * @return the instance of GISVectorObjectDAO
	 */
	public static ir.viratech.pond_ms.model.map_object.vector.logic.GISVectorObjectMgr getInstance() {
		return ir.viratech.commons.spring.context.ApplicationContextProvider.getInitializedApplicationContext().getBean(ir.viratech.pond_ms.model.map_object.vector.logic.GISVectorObjectMgr.class);
	}



	/**
	 * Unique finder method for "extuid".
	 *
	 * @param extuid the value of extuid
	 * @return the unique matching object
	 */
	@ir.viratech.commons.spring.tx.ReadTransactional
	public ir.viratech.pond_ms.model.map_object.vector.GISVectorObject getByExtuid(java.lang.String extuid) {
		return this.getDAO().getByExtuid(extuid);
	}




}