package ir.viratech.pond_ms.model.map_object.vector.base;




/**
 *  Base DAO class for entity "ir.viratech.pond_ms.model.map_object.vector.LineObject". 
 *  It is an automatically generated file and should not be edited.
 */
public abstract class BaseLineObjectDAO extends ir.viratech.base.AbstractEntityDAO<ir.viratech.pond_ms.model.map_object.vector.LineObject, java.lang.Long> {

	

	// query name references


	/**
	 * Gets the DAO instance from Spring.
	 *
	 * @return the instance of LineObjectMgr
	 */
	public static ir.viratech.pond_ms.model.map_object.vector.dao.LineObjectDAO getInstance() {
		return ir.viratech.commons.spring.context.ApplicationContextProvider.getInitializedApplicationContext().getBean(ir.viratech.pond_ms.model.map_object.vector.dao.LineObjectDAO.class);
	}

	/* (non-Javadoc)
	 * @see ir.viratech.commons.persistence.base.BaseAbstractEntityDAO#getReferenceClass()
	 */
	@Override
	public Class<ir.viratech.pond_ms.model.map_object.vector.LineObject> getReferenceClass() {
		return ir.viratech.pond_ms.model.map_object.vector.LineObject.class;
	}
	
	/* (non-Javadoc)
	 * @see ir.viratech.commons.persistence.base.BaseAbstractEntityDAO#getId(java.lang.Object)
	 */
	@Override
	public java.lang.Long getId(ir.viratech.pond_ms.model.map_object.vector.LineObject lineObject) {
		return lineObject.getId();
	}
	







	@Override
	public void initialize(ir.viratech.pond_ms.model.map_object.vector.LineObject lineObject) {
		ir.viratech.pond_ms.model.map_object.vector.dao.GISVectorObjectDAO.getInstance().initialize(lineObject); 
	}
	



}