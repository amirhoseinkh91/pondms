package ir.viratech.pond_ms.model.map_object.vector.base;




/**
 *  Base DAO class for entity "ir.viratech.pond_ms.model.map_object.vector.PointObject". 
 *  It is an automatically generated file and should not be edited.
 */
public abstract class BasePointObjectDAO extends ir.viratech.base.AbstractEntityDAO<ir.viratech.pond_ms.model.map_object.vector.PointObject, java.lang.Long> {

	

	// query name references


	/**
	 * Gets the DAO instance from Spring.
	 *
	 * @return the instance of PointObjectMgr
	 */
	public static ir.viratech.pond_ms.model.map_object.vector.dao.PointObjectDAO getInstance() {
		return ir.viratech.commons.spring.context.ApplicationContextProvider.getInitializedApplicationContext().getBean(ir.viratech.pond_ms.model.map_object.vector.dao.PointObjectDAO.class);
	}

	/* (non-Javadoc)
	 * @see ir.viratech.commons.persistence.base.BaseAbstractEntityDAO#getReferenceClass()
	 */
	@Override
	public Class<ir.viratech.pond_ms.model.map_object.vector.PointObject> getReferenceClass() {
		return ir.viratech.pond_ms.model.map_object.vector.PointObject.class;
	}
	
	/* (non-Javadoc)
	 * @see ir.viratech.commons.persistence.base.BaseAbstractEntityDAO#getId(java.lang.Object)
	 */
	@Override
	public java.lang.Long getId(ir.viratech.pond_ms.model.map_object.vector.PointObject pointObject) {
		return pointObject.getId();
	}
	







	@Override
	public void initialize(ir.viratech.pond_ms.model.map_object.vector.PointObject pointObject) {
		ir.viratech.pond_ms.model.map_object.vector.dao.GISVectorObjectDAO.getInstance().initialize(pointObject); 
	}
	



}