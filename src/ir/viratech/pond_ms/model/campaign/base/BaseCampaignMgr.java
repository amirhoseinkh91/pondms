package ir.viratech.pond_ms.model.campaign.base;


import ir.viratech.pond_ms.model.campaign.Campaign;
import ir.viratech.pond_ms.model.campaign.dao.CampaignDAO;


/**
 *  Base Mgr class for entity "ir.viratech.pond_ms.model.campaign.Campaign". 
 *  It is an automatically generated file and should not be edited.
 */
public abstract class BaseCampaignMgr extends ir.viratech.base.AbstractEntityMgr<Campaign, java.lang.Long> {


	private CampaignDAO campaignDAO = CampaignDAO.getInstance();	

	@Override
	protected CampaignDAO getDAO() {
		return this.campaignDAO;
	}


	protected BaseCampaignMgr () {}
	



	/**
	 * Gets the Mgr instance from Spring.
	 *
	 * @return the instance of CampaignDAO
	 */
	public static ir.viratech.pond_ms.model.campaign.logic.CampaignMgr getInstance() {
		return ir.viratech.commons.spring.context.ApplicationContextProvider.getInitializedApplicationContext().getBean(ir.viratech.pond_ms.model.campaign.logic.CampaignMgr.class);
	}



	/**
	 * Unique finder method for "extuid".
	 *
	 * @param extuid the value of extuid
	 * @return the unique matching object
	 */
	@ir.viratech.commons.spring.tx.ReadTransactional
	public ir.viratech.pond_ms.model.campaign.Campaign getByExtuid(java.lang.String extuid) {
		return this.getDAO().getByExtuid(extuid);
	}

	/**
	 * Unique finder method for "useId".
	 *
	 * @param useId the value of useId
	 * @return the unique matching object
	 */
	@ir.viratech.commons.spring.tx.ReadTransactional
	public ir.viratech.pond_ms.model.campaign.Campaign getByUseId(java.lang.String useId) {
		return this.getDAO().getByUseId(useId);
	}




}