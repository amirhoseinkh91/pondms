package ir.viratech.pond_ms.api.feed_back.base;

import com.wordnik.swagger.annotations.Api;

import ir.viratech.pond_ms.model.feed_back.FeedBack;

/**
 *  Base class for "FeedBackResource".
 *  It is an automatically generated file and should not be edited.
 */
@Api(value = BaseFeedBackResource.RESOURCE_PATH_BASE, description = BaseFeedBackResource.RESOURCE_DESCRIPTION)
public abstract class BaseFeedBackResource extends ir.viratech.pond_ms.api.AbstractMgrBasedResource<FeedBack, ir.viratech.pond_ms.api.feed_back.dto.FeedBackFullDTO> {
	
	/**
	 * The resource path base used in swagger.
	 */
	public static final String RESOURCE_PATH_BASE = "/feed-back"+"/"+PATH_PART_ITEMS;
	
	/**
	 * The resource description used in swagger.
	 */
	public static final String RESOURCE_DESCRIPTION = "FeedBack Resource";
	
	/**
	 * The path which is handled by this resource/
	 */
	public static final String RESOURCE_PATH = "/feed-back"+PATH_PARAM_PART__ITEMS;
	
	/**
	 * Provides the entity manager used by the resource.
	 * @return an instance of the required entity manager
	 */
	@Override
	protected ir.viratech.commons.model.BasicEntityMgr<FeedBack> getMgr() {
		return ir.viratech.pond_ms.model.feed_back.logic.FeedBackMgr.getInstance();
	}

	/**
	 * Factory method for FullDTO.
	 * @return a FullDTO instance
	 */
	@Override
	protected ir.viratech.pond_ms.api.feed_back.dto.FeedBackFullDTO createFullDTO() {
		return new ir.viratech.pond_ms.api.feed_back.dto.FeedBackFullDTO();
	}

	/**
	 * Provides the class of FieldInfoContext used for search.
	 * @return the class of FieldInfoContext 
	 */
	@Override
	protected Class<ir.viratech.pond_ms.api.feed_back.dto.FeedBackFullDTO.FieldInfoContext> getFullDtoFieldInfoContextClass() {
		return ir.viratech.pond_ms.api.feed_back.dto.FeedBackFullDTO.FieldInfoContext.class;
	}

	/**
	 * Provides the bundle prefix used in i18n.
	 * @return the bundle prefix
	 */
	@Override
	protected String getBundlePrefix() {
		return "feed-back.";
	}
	
	/**
	 * Provides the feature entity name by which access checking is performed.
	 * @return the feature entity name
	 */
	@Override
	protected String getFeatureEntityName() {
		return "FEEDBACK";
	}
	
	
	/**
	 * Default constructor.
	 * Also adds the extents.
	 */
	public BaseFeedBackResource() {
		super();
	}

}
