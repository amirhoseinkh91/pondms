package ir.viratech.pond_ms.model.map_object.vector.base;


import ir.viratech.pond_ms.model.map_object.vector.LineObject;
import ir.viratech.pond_ms.model.map_object.vector.dao.LineObjectDAO;


/**
 *  Base Mgr class for entity "ir.viratech.pond_ms.model.map_object.vector.LineObject". 
 *  It is an automatically generated file and should not be edited.
 */
public abstract class BaseLineObjectMgr extends ir.viratech.base.AbstractEntityMgr<LineObject, java.lang.Long> {


	private LineObjectDAO lineObjectDAO = LineObjectDAO.getInstance();	

	@Override
	protected LineObjectDAO getDAO() {
		return this.lineObjectDAO;
	}


	protected BaseLineObjectMgr () {}
	



	/**
	 * Gets the Mgr instance from Spring.
	 *
	 * @return the instance of LineObjectDAO
	 */
	public static ir.viratech.pond_ms.model.map_object.vector.logic.LineObjectMgr getInstance() {
		return ir.viratech.commons.spring.context.ApplicationContextProvider.getInitializedApplicationContext().getBean(ir.viratech.pond_ms.model.map_object.vector.logic.LineObjectMgr.class);
	}






}