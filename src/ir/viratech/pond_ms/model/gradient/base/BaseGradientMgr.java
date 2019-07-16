package ir.viratech.pond_ms.model.gradient.base;


import ir.viratech.pond_ms.model.gradient.Gradient;
import ir.viratech.pond_ms.model.gradient.dao.GradientDAO;


/**
 *  Base Mgr class for entity "ir.viratech.pond_ms.model.gradient.Gradient". 
 *  It is an automatically generated file and should not be edited.
 */
public abstract class BaseGradientMgr extends ir.viratech.base.AbstractEntityMgr<Gradient, java.lang.Long> {


	private GradientDAO gradientDAO = GradientDAO.getInstance();	

	@Override
	protected GradientDAO getDAO() {
		return this.gradientDAO;
	}


	protected BaseGradientMgr () {}
	



	/**
	 * Gets the Mgr instance from Spring.
	 *
	 * @return the instance of GradientDAO
	 */
	public static ir.viratech.pond_ms.model.gradient.logic.GradientMgr getInstance() {
		return ir.viratech.commons.spring.context.ApplicationContextProvider.getInitializedApplicationContext().getBean(ir.viratech.pond_ms.model.gradient.logic.GradientMgr.class);
	}



	/**
	 * Unique finder method for "extuid".
	 *
	 * @param extuid the value of extuid
	 * @return the unique matching object
	 */
	@ir.viratech.commons.spring.tx.ReadTransactional
	public ir.viratech.pond_ms.model.gradient.Gradient getByExtuid(java.lang.String extuid) {
		return this.getDAO().getByExtuid(extuid);
	}




}