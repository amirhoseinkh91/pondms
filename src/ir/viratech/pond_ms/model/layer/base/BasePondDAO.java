package ir.viratech.pond_ms.model.layer.base;




/**
 *  Base DAO class for entity "ir.viratech.pond_ms.model.layer.Pond". 
 *  It is an automatically generated file and should not be edited.
 */
public abstract class BasePondDAO extends ir.viratech.base.AbstractEntityDAO<ir.viratech.pond_ms.model.layer.Pond, java.lang.Long> {

	

	// query name references


	/**
	 * Gets the DAO instance from Spring.
	 *
	 * @return the instance of PondMgr
	 */
	public static ir.viratech.pond_ms.model.layer.dao.PondDAO getInstance() {
		return ir.viratech.commons.spring.context.ApplicationContextProvider.getInitializedApplicationContext().getBean(ir.viratech.pond_ms.model.layer.dao.PondDAO.class);
	}

	/* (non-Javadoc)
	 * @see ir.viratech.commons.persistence.base.BaseAbstractEntityDAO#getReferenceClass()
	 */
	@Override
	public Class<ir.viratech.pond_ms.model.layer.Pond> getReferenceClass() {
		return ir.viratech.pond_ms.model.layer.Pond.class;
	}
	
	/* (non-Javadoc)
	 * @see ir.viratech.commons.persistence.base.BaseAbstractEntityDAO#getId(java.lang.Object)
	 */
	@Override
	public java.lang.Long getId(ir.viratech.pond_ms.model.layer.Pond pond) {
		return pond.getId();
	}
	




	/**
	 * Unique finder method for "extuid".
	 *
	 * @param extuid the value of extuid
	 * @return the unique matching object
	 */
	public ir.viratech.pond_ms.model.layer.Pond getByExtuid(java.lang.String extuid) {
		return this.getByUniqueProp(ir.viratech.pond_ms.model.layer.Pond.PROP_EXTUID, extuid);
	}

	/**
	 * Unique finder method for "layer".
	 *
	 * @param layer the value of layer
	 * @return the unique matching object
	 */
	public ir.viratech.pond_ms.model.layer.Pond getByLayer(ir.viratech.pond_ms.model.layer.ParentLayer layer) {
		return this.getByUniqueProp(ir.viratech.pond_ms.model.layer.Pond.PROP_LAYER, layer);
	}




	@Override
	public void initialize(ir.viratech.pond_ms.model.layer.Pond pond) {
		super.initialize(pond);
		pond.setExtuid(this.generateUid());
	}
	



}