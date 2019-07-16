package ir.viratech.pond_ms.model.map_object.vector.base;


import ir.viratech.pond_ms.model.map_object.vector.PolygonObject;
import ir.viratech.pond_ms.model.map_object.vector.dao.PolygonObjectDAO;


/**
 *  Base Mgr class for entity "ir.viratech.pond_ms.model.map_object.vector.PolygonObject". 
 *  It is an automatically generated file and should not be edited.
 */
public abstract class BasePolygonObjectMgr extends ir.viratech.base.AbstractEntityMgr<PolygonObject, java.lang.Long> {


	private PolygonObjectDAO polygonObjectDAO = PolygonObjectDAO.getInstance();	

	@Override
	protected PolygonObjectDAO getDAO() {
		return this.polygonObjectDAO;
	}


	protected BasePolygonObjectMgr () {}
	



	/**
	 * Gets the Mgr instance from Spring.
	 *
	 * @return the instance of PolygonObjectDAO
	 */
	public static ir.viratech.pond_ms.model.map_object.vector.logic.PolygonObjectMgr getInstance() {
		return ir.viratech.commons.spring.context.ApplicationContextProvider.getInitializedApplicationContext().getBean(ir.viratech.pond_ms.model.map_object.vector.logic.PolygonObjectMgr.class);
	}






}