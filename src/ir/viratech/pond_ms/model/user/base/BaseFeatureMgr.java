package ir.viratech.pond_ms.model.user.base;


import ir.viratech.pond_ms.model.user.Feature;
import ir.viratech.pond_ms.model.user.dao.FeatureDAO;


/**
 *  Base Mgr class for entity "ir.viratech.pond_ms.model.user.Feature". 
 *  It is an automatically generated file and should not be edited.
 */
public abstract class BaseFeatureMgr extends ir.viratech.base.AbstractEntityMgr<Feature, java.lang.Long> {


	private FeatureDAO featureDAO = FeatureDAO.getInstance();	

	@Override
	protected FeatureDAO getDAO() {
		return this.featureDAO;
	}


	protected BaseFeatureMgr () {}
	



	/**
	 * Gets the Mgr instance from Spring.
	 *
	 * @return the instance of FeatureDAO
	 */
	public static ir.viratech.pond_ms.model.user.logic.FeatureMgr getInstance() {
		return ir.viratech.commons.spring.context.ApplicationContextProvider.getInitializedApplicationContext().getBean(ir.viratech.pond_ms.model.user.logic.FeatureMgr.class);
	}



	/**
	 * Unique finder method for "extuid".
	 *
	 * @param extuid the value of extuid
	 * @return the unique matching object
	 */
	@ir.viratech.commons.spring.tx.ReadTransactional
	public ir.viratech.pond_ms.model.user.Feature getByExtuid(java.lang.String extuid) {
		return this.getDAO().getByExtuid(extuid);
	}

	/**
	 * Unique finder method for "name".
	 *
	 * @param name the value of name
	 * @return the unique matching object
	 */
	@ir.viratech.commons.spring.tx.ReadTransactional
	public ir.viratech.pond_ms.model.user.Feature getByName(java.lang.String name) {
		return this.getDAO().getByName(name);
	}




}