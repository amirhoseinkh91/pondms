package ir.viratech.pond_ms.model.map_object.vector.base;




/**
 *  Base DAO class for entity "ir.viratech.pond_ms.model.map_object.vector.PolygonObject". 
 *  It is an automatically generated file and should not be edited.
 */
public abstract class BasePolygonObjectDAO extends ir.viratech.base.AbstractEntityDAO<ir.viratech.pond_ms.model.map_object.vector.PolygonObject, java.lang.Long> {

	

	// query name references


	/**
	 * Gets the DAO instance from Spring.
	 *
	 * @return the instance of PolygonObjectMgr
	 */
	public static ir.viratech.pond_ms.model.map_object.vector.dao.PolygonObjectDAO getInstance() {
		return ir.viratech.commons.spring.context.ApplicationContextProvider.getInitializedApplicationContext().getBean(ir.viratech.pond_ms.model.map_object.vector.dao.PolygonObjectDAO.class);
	}

	/* (non-Javadoc)
	 * @see ir.viratech.commons.persistence.base.BaseAbstractEntityDAO#getReferenceClass()
	 */
	@Override
	public Class<ir.viratech.pond_ms.model.map_object.vector.PolygonObject> getReferenceClass() {
		return ir.viratech.pond_ms.model.map_object.vector.PolygonObject.class;
	}
	
	/* (non-Javadoc)
	 * @see ir.viratech.commons.persistence.base.BaseAbstractEntityDAO#getId(java.lang.Object)
	 */
	@Override
	public java.lang.Long getId(ir.viratech.pond_ms.model.map_object.vector.PolygonObject polygonObject) {
		return polygonObject.getId();
	}
	







	@Override
	public void initialize(ir.viratech.pond_ms.model.map_object.vector.PolygonObject polygonObject) {
		ir.viratech.pond_ms.model.map_object.vector.dao.GISVectorObjectDAO.getInstance().initialize(polygonObject); 
	}
	



}