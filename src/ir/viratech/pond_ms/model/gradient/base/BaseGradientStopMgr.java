package ir.viratech.pond_ms.model.gradient.base;


import ir.viratech.pond_ms.model.gradient.GradientStop;
import ir.viratech.pond_ms.model.gradient.dao.GradientStopDAO;


/**
 *  Base Mgr class for entity "ir.viratech.pond_ms.model.gradient.GradientStop". 
 *  It is an automatically generated file and should not be edited.
 */
public abstract class BaseGradientStopMgr extends ir.viratech.base.AbstractEntityMgr<GradientStop, java.lang.Long> {


	private GradientStopDAO gradientStopDAO = GradientStopDAO.getInstance();	

	@Override
	protected GradientStopDAO getDAO() {
		return this.gradientStopDAO;
	}


	protected BaseGradientStopMgr () {}
	



	/**
	 * Gets the Mgr instance from Spring.
	 *
	 * @return the instance of GradientStopDAO
	 */
	public static ir.viratech.pond_ms.model.gradient.logic.GradientStopMgr getInstance() {
		return ir.viratech.commons.spring.context.ApplicationContextProvider.getInitializedApplicationContext().getBean(ir.viratech.pond_ms.model.gradient.logic.GradientStopMgr.class);
	}



	/**
	 * Unique finder method for "extuid".
	 *
	 * @param extuid the value of extuid
	 * @return the unique matching object
	 */
	@ir.viratech.commons.spring.tx.ReadTransactional
	public ir.viratech.pond_ms.model.gradient.GradientStop getByExtuid(java.lang.String extuid) {
		return this.getDAO().getByExtuid(extuid);
	}




}