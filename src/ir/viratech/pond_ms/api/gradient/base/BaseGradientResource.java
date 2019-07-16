package ir.viratech.pond_ms.api.gradient.base;

import com.wordnik.swagger.annotations.Api;

import ir.viratech.pond_ms.model.gradient.Gradient;

/**
 *  Base class for "GradientResource".
 *  It is an automatically generated file and should not be edited.
 */
@Api(value = BaseGradientResource.RESOURCE_PATH_BASE, description = BaseGradientResource.RESOURCE_DESCRIPTION)
public abstract class BaseGradientResource extends ir.viratech.pond_ms.api.AbstractMgrBasedResource<Gradient, ir.viratech.pond_ms.api.gradient.dto.GradientFullDTO> {
	
	/**
	 * The resource path base used in swagger.
	 */
	public static final String RESOURCE_PATH_BASE = "/gradient"+"/"+PATH_PART_ITEMS;
	
	/**
	 * The resource description used in swagger.
	 */
	public static final String RESOURCE_DESCRIPTION = "Gradient Resource";
	
	/**
	 * The path which is handled by this resource/
	 */
	public static final String RESOURCE_PATH = "/gradient"+PATH_PARAM_PART__ITEMS;
	
	/**
	 * Provides the entity manager used by the resource.
	 * @return an instance of the required entity manager
	 */
	@Override
	protected ir.viratech.commons.model.BasicEntityMgr<Gradient> getMgr() {
		return ir.viratech.pond_ms.model.gradient.logic.GradientMgr.getInstance();
	}

	/**
	 * Factory method for FullDTO.
	 * @return a FullDTO instance
	 */
	@Override
	protected ir.viratech.pond_ms.api.gradient.dto.GradientFullDTO createFullDTO() {
		return new ir.viratech.pond_ms.api.gradient.dto.GradientFullDTO();
	}

	/**
	 * Provides the class of FieldInfoContext used for search.
	 * @return the class of FieldInfoContext 
	 */
	@Override
	protected Class<ir.viratech.pond_ms.api.gradient.dto.GradientFullDTO.FieldInfoContext> getFullDtoFieldInfoContextClass() {
		return ir.viratech.pond_ms.api.gradient.dto.GradientFullDTO.FieldInfoContext.class;
	}

	/**
	 * Provides the bundle prefix used in i18n.
	 * @return the bundle prefix
	 */
	@Override
	protected String getBundlePrefix() {
		return "gradient.";
	}
	
	/**
	 * Provides the feature entity name by which access checking is performed.
	 * @return the feature entity name
	 */
	@Override
	protected String getFeatureEntityName() {
		return "GRADIENT";
	}
	
	
	/**
	 * Default constructor.
	 * Also adds the extents.
	 */
	public BaseGradientResource() {
		super();
	}

}
