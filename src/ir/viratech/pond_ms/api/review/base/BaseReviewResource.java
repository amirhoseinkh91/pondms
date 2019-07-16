package ir.viratech.pond_ms.api.review.base;

import com.wordnik.swagger.annotations.Api;

import ir.viratech.pond_ms.model.review.Review;

/**
 *  Base class for "ReviewResource".
 *  It is an automatically generated file and should not be edited.
 */
@Api(value = BaseReviewResource.RESOURCE_PATH_BASE, description = BaseReviewResource.RESOURCE_DESCRIPTION)
public abstract class BaseReviewResource extends ir.viratech.pond_ms.api.AbstractMgrBasedResource<Review, ir.viratech.pond_ms.api.review.dto.ReviewFullDTO> {
	
	/**
	 * The resource path base used in swagger.
	 */
	public static final String RESOURCE_PATH_BASE = "/review"+"/"+PATH_PART_ITEMS;
	
	/**
	 * The resource description used in swagger.
	 */
	public static final String RESOURCE_DESCRIPTION = "Review Resource";
	
	/**
	 * The path which is handled by this resource/
	 */
	public static final String RESOURCE_PATH = "/review"+PATH_PARAM_PART__ITEMS;
	
	/**
	 * Provides the entity manager used by the resource.
	 * @return an instance of the required entity manager
	 */
	@Override
	protected ir.viratech.commons.model.BasicEntityMgr<Review> getMgr() {
		return ir.viratech.pond_ms.model.review.logic.ReviewMgr.getInstance();
	}

	/**
	 * Factory method for FullDTO.
	 * @return a FullDTO instance
	 */
	@Override
	protected ir.viratech.pond_ms.api.review.dto.ReviewFullDTO createFullDTO() {
		return new ir.viratech.pond_ms.api.review.dto.ReviewFullDTO();
	}

	/**
	 * Provides the class of FieldInfoContext used for search.
	 * @return the class of FieldInfoContext 
	 */
	@Override
	protected Class<ir.viratech.pond_ms.api.review.dto.ReviewFullDTO.FieldInfoContext> getFullDtoFieldInfoContextClass() {
		return ir.viratech.pond_ms.api.review.dto.ReviewFullDTO.FieldInfoContext.class;
	}

	/**
	 * Provides the bundle prefix used in i18n.
	 * @return the bundle prefix
	 */
	@Override
	protected String getBundlePrefix() {
		return "review.";
	}
	
	/**
	 * Provides the feature entity name by which access checking is performed.
	 * @return the feature entity name
	 */
	@Override
	protected String getFeatureEntityName() {
		return "REVIEW";
	}
	
	
	/**
	 * Default constructor.
	 * Also adds the extents.
	 */
	public BaseReviewResource() {
		super();
	}

}
