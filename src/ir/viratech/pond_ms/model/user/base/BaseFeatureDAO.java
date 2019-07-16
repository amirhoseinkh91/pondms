package ir.viratech.pond_ms.model.user.base;




/**
 *  Base DAO class for entity "ir.viratech.pond_ms.model.user.Feature". 
 *  It is an automatically generated file and should not be edited.
 */
public abstract class BaseFeatureDAO extends ir.viratech.base.AbstractEntityDAO<ir.viratech.pond_ms.model.user.Feature, java.lang.Long> {

	

	// query name references


	/**
	 * Gets the DAO instance from Spring.
	 *
	 * @return the instance of FeatureMgr
	 */
	public static ir.viratech.pond_ms.model.user.dao.FeatureDAO getInstance() {
		return ir.viratech.commons.spring.context.ApplicationContextProvider.getInitializedApplicationContext().getBean(ir.viratech.pond_ms.model.user.dao.FeatureDAO.class);
	}

	/* (non-Javadoc)
	 * @see ir.viratech.commons.persistence.base.BaseAbstractEntityDAO#getReferenceClass()
	 */
	@Override
	public Class<ir.viratech.pond_ms.model.user.Feature> getReferenceClass() {
		return ir.viratech.pond_ms.model.user.Feature.class;
	}
	
	/* (non-Javadoc)
	 * @see ir.viratech.commons.persistence.base.BaseAbstractEntityDAO#getId(java.lang.Object)
	 */
	@Override
	public java.lang.Long getId(ir.viratech.pond_ms.model.user.Feature feature) {
		return feature.getId();
	}
	




	/**
	 * Unique finder method for "extuid".
	 *
	 * @param extuid the value of extuid
	 * @return the unique matching object
	 */
	public ir.viratech.pond_ms.model.user.Feature getByExtuid(java.lang.String extuid) {
		return this.getByUniqueProp(ir.viratech.pond_ms.model.user.Feature.PROP_EXTUID, extuid);
	}

	/**
	 * Unique finder method for "name".
	 *
	 * @param name the value of name
	 * @return the unique matching object
	 */
	public ir.viratech.pond_ms.model.user.Feature getByName(java.lang.String name) {
		return this.getByUniqueProp(ir.viratech.pond_ms.model.user.Feature.PROP_NAME, name);
	}




	@Override
	public void initialize(ir.viratech.pond_ms.model.user.Feature feature) {
		super.initialize(feature);
		feature.setExtuid(this.generateUid());
		feature.setExposable(false);
	}
	



}