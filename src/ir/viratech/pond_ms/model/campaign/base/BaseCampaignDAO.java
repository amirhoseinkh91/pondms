package ir.viratech.pond_ms.model.campaign.base;




/**
 *  Base DAO class for entity "ir.viratech.pond_ms.model.campaign.Campaign". 
 *  It is an automatically generated file and should not be edited.
 */
public abstract class BaseCampaignDAO extends ir.viratech.base.AbstractEntityDAO<ir.viratech.pond_ms.model.campaign.Campaign, java.lang.Long> {

	

	// query name references


	/**
	 * Gets the DAO instance from Spring.
	 *
	 * @return the instance of CampaignMgr
	 */
	public static ir.viratech.pond_ms.model.campaign.dao.CampaignDAO getInstance() {
		return ir.viratech.commons.spring.context.ApplicationContextProvider.getInitializedApplicationContext().getBean(ir.viratech.pond_ms.model.campaign.dao.CampaignDAO.class);
	}

	/* (non-Javadoc)
	 * @see ir.viratech.commons.persistence.base.BaseAbstractEntityDAO#getReferenceClass()
	 */
	@Override
	public Class<ir.viratech.pond_ms.model.campaign.Campaign> getReferenceClass() {
		return ir.viratech.pond_ms.model.campaign.Campaign.class;
	}
	
	/* (non-Javadoc)
	 * @see ir.viratech.commons.persistence.base.BaseAbstractEntityDAO#getId(java.lang.Object)
	 */
	@Override
	public java.lang.Long getId(ir.viratech.pond_ms.model.campaign.Campaign campaign) {
		return campaign.getId();
	}
	




	/**
	 * Unique finder method for "extuid".
	 *
	 * @param extuid the value of extuid
	 * @return the unique matching object
	 */
	public ir.viratech.pond_ms.model.campaign.Campaign getByExtuid(java.lang.String extuid) {
		return this.getByUniqueProp(ir.viratech.pond_ms.model.campaign.Campaign.PROP_EXTUID, extuid);
	}

	/**
	 * Unique finder method for "useId".
	 *
	 * @param useId the value of useId
	 * @return the unique matching object
	 */
	public ir.viratech.pond_ms.model.campaign.Campaign getByUseId(java.lang.String useId) {
		return this.getByUniqueProp(ir.viratech.pond_ms.model.campaign.Campaign.PROP_USE_ID, useId);
	}




	@Override
	public void initialize(ir.viratech.pond_ms.model.campaign.Campaign campaign) {
		super.initialize(campaign);
		campaign.setExtuid(this.generateUid());
		campaign.setDay01(false);
		campaign.setDay02(false);
		campaign.setDay03(false);
		campaign.setDay04(false);
		campaign.setDay05(false);
		campaign.setDay06(false);
		campaign.setDay07(false);
		campaign.setDay08(false);
		campaign.setDay09(false);
		campaign.setDay10(false);
		campaign.setDay11(false);
		campaign.setDay12(false);
		campaign.setDay13(false);
		campaign.setDay14(false);
		campaign.setDay15(false);
		campaign.setDay16(false);
		campaign.setDay17(false);
		campaign.setDay18(false);
	}
	



}