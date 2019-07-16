package ir.viratech.pond_ms.model.gradient.base;




/**
 *  Base DAO class for entity "ir.viratech.pond_ms.model.gradient.GradientStop". 
 *  It is an automatically generated file and should not be edited.
 */
public abstract class BaseGradientStopDAO extends ir.viratech.base.AbstractEntityDAO<ir.viratech.pond_ms.model.gradient.GradientStop, java.lang.Long> {

	

	// query name references


	/**
	 * Gets the DAO instance from Spring.
	 *
	 * @return the instance of GradientStopMgr
	 */
	public static ir.viratech.pond_ms.model.gradient.dao.GradientStopDAO getInstance() {
		return ir.viratech.commons.spring.context.ApplicationContextProvider.getInitializedApplicationContext().getBean(ir.viratech.pond_ms.model.gradient.dao.GradientStopDAO.class);
	}

	/* (non-Javadoc)
	 * @see ir.viratech.commons.persistence.base.BaseAbstractEntityDAO#getReferenceClass()
	 */
	@Override
	public Class<ir.viratech.pond_ms.model.gradient.GradientStop> getReferenceClass() {
		return ir.viratech.pond_ms.model.gradient.GradientStop.class;
	}
	
	/* (non-Javadoc)
	 * @see ir.viratech.commons.persistence.base.BaseAbstractEntityDAO#getId(java.lang.Object)
	 */
	@Override
	public java.lang.Long getId(ir.viratech.pond_ms.model.gradient.GradientStop gradientStop) {
		return gradientStop.getId();
	}
	




	/**
	 * Unique finder method for "extuid".
	 *
	 * @param extuid the value of extuid
	 * @return the unique matching object
	 */
	public ir.viratech.pond_ms.model.gradient.GradientStop getByExtuid(java.lang.String extuid) {
		return this.getByUniqueProp(ir.viratech.pond_ms.model.gradient.GradientStop.PROP_EXTUID, extuid);
	}




	@Override
	public void initialize(ir.viratech.pond_ms.model.gradient.GradientStop gradientStop) {
		super.initialize(gradientStop);
		gradientStop.setExtuid(this.generateUid());
	}
	



}