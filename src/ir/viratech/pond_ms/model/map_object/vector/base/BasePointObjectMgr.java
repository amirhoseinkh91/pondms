package ir.viratech.pond_ms.model.map_object.vector.base;


import ir.viratech.pond_ms.model.map_object.vector.PointObject;
import ir.viratech.pond_ms.model.map_object.vector.dao.PointObjectDAO;


/**
 *  Base Mgr class for entity "ir.viratech.pond_ms.model.map_object.vector.PointObject". 
 *  It is an automatically generated file and should not be edited.
 */
public abstract class BasePointObjectMgr extends ir.viratech.base.AbstractEntityMgr<PointObject, java.lang.Long> {


	private PointObjectDAO pointObjectDAO = PointObjectDAO.getInstance();	

	@Override
	protected PointObjectDAO getDAO() {
		return this.pointObjectDAO;
	}


	protected BasePointObjectMgr () {}
	



	/**
	 * Gets the Mgr instance from Spring.
	 *
	 * @return the instance of PointObjectDAO
	 */
	public static ir.viratech.pond_ms.model.map_object.vector.logic.PointObjectMgr getInstance() {
		return ir.viratech.commons.spring.context.ApplicationContextProvider.getInitializedApplicationContext().getBean(ir.viratech.pond_ms.model.map_object.vector.logic.PointObjectMgr.class);
	}






}