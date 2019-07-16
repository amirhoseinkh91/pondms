package ir.viratech.pond_ms.model.map_object.vector.base;




/**
 *  Base DAO class for entity "ir.viratech.pond_ms.model.map_object.vector.GISVectorObject". 
 *  It is an automatically generated file and should not be edited.
 */
public abstract class BaseGISVectorObjectDAO extends ir.viratech.base.AbstractEntityDAO<ir.viratech.pond_ms.model.map_object.vector.GISVectorObject, java.lang.Long> {

	

	// query name references


	/**
	 * Gets the DAO instance from Spring.
	 *
	 * @return the instance of GISVectorObjectMgr
	 */
	public static ir.viratech.pond_ms.model.map_object.vector.dao.GISVectorObjectDAO getInstance() {
		return ir.viratech.commons.spring.context.ApplicationContextProvider.getInitializedApplicationContext().getBean(ir.viratech.pond_ms.model.map_object.vector.dao.GISVectorObjectDAO.class);
	}

	/* (non-Javadoc)
	 * @see ir.viratech.commons.persistence.base.BaseAbstractEntityDAO#getReferenceClass()
	 */
	@Override
	public Class<ir.viratech.pond_ms.model.map_object.vector.GISVectorObject> getReferenceClass() {
		return ir.viratech.pond_ms.model.map_object.vector.GISVectorObject.class;
	}
	
	/* (non-Javadoc)
	 * @see ir.viratech.commons.persistence.base.BaseAbstractEntityDAO#getId(java.lang.Object)
	 */
	@Override
	public java.lang.Long getId(ir.viratech.pond_ms.model.map_object.vector.GISVectorObject gISVectorObject) {
		return gISVectorObject.getId();
	}
	




	/**
	 * Unique finder method for "extuid".
	 *
	 * @param extuid the value of extuid
	 * @return the unique matching object
	 */
	public ir.viratech.pond_ms.model.map_object.vector.GISVectorObject getByExtuid(java.lang.String extuid) {
		return this.getByUniqueProp(ir.viratech.pond_ms.model.map_object.vector.GISVectorObject.PROP_EXTUID, extuid);
	}




	@Override
	public void initialize(ir.viratech.pond_ms.model.map_object.vector.GISVectorObject gISVectorObject) {
		super.initialize(gISVectorObject);
		gISVectorObject.setExtuid(this.generateUid());
		gISVectorObject.setCreationDate(new java.util.Date());
	}
	



}