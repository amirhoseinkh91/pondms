package ir.viratech.pond_ms.model.gradient.base;




/**
 *  Base DAO class for entity "ir.viratech.pond_ms.model.gradient.Gradient". 
 *  It is an automatically generated file and should not be edited.
 */
public abstract class BaseGradientDAO extends ir.viratech.base.AbstractEntityDAO<ir.viratech.pond_ms.model.gradient.Gradient, java.lang.Long> {

	

	// query name references


	/**
	 * Gets the DAO instance from Spring.
	 *
	 * @return the instance of GradientMgr
	 */
	public static ir.viratech.pond_ms.model.gradient.dao.GradientDAO getInstance() {
		return ir.viratech.commons.spring.context.ApplicationContextProvider.getInitializedApplicationContext().getBean(ir.viratech.pond_ms.model.gradient.dao.GradientDAO.class);
	}

	/* (non-Javadoc)
	 * @see ir.viratech.commons.persistence.base.BaseAbstractEntityDAO#getReferenceClass()
	 */
	@Override
	public Class<ir.viratech.pond_ms.model.gradient.Gradient> getReferenceClass() {
		return ir.viratech.pond_ms.model.gradient.Gradient.class;
	}
	
	/* (non-Javadoc)
	 * @see ir.viratech.commons.persistence.base.BaseAbstractEntityDAO#getId(java.lang.Object)
	 */
	@Override
	public java.lang.Long getId(ir.viratech.pond_ms.model.gradient.Gradient gradient) {
		return gradient.getId();
	}
	




	/**
	 * Unique finder method for "extuid".
	 *
	 * @param extuid the value of extuid
	 * @return the unique matching object
	 */
	public ir.viratech.pond_ms.model.gradient.Gradient getByExtuid(java.lang.String extuid) {
		return this.getByUniqueProp(ir.viratech.pond_ms.model.gradient.Gradient.PROP_EXTUID, extuid);
	}




	@Override
	public void initialize(ir.viratech.pond_ms.model.gradient.Gradient gradient) {
		super.initialize(gradient);
		gradient.setExtuid(this.generateUid());
	}
	



}