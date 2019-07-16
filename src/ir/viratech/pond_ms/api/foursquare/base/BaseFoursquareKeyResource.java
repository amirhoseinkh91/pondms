package ir.viratech.pond_ms.api.foursquare.base;

import com.wordnik.swagger.annotations.Api;

import ir.viratech.pond_ms.model.foursquare.FoursquareKey;

/**
 *  Base class for "FoursquareKeyResource".
 *  It is an automatically generated file and should not be edited.
 */
@Api(value = BaseFoursquareKeyResource.RESOURCE_PATH_BASE, description = BaseFoursquareKeyResource.RESOURCE_DESCRIPTION)
public abstract class BaseFoursquareKeyResource extends ir.viratech.pond_ms.api.AbstractMgrBasedResource<FoursquareKey, ir.viratech.pond_ms.api.foursquare.dto.FoursquareKeyFullDTO> {
	
	/**
	 * The resource path base used in swagger.
	 */
	public static final String RESOURCE_PATH_BASE = "/foursquare-key"+"/"+PATH_PART_ITEMS;
	
	/**
	 * The resource description used in swagger.
	 */
	public static final String RESOURCE_DESCRIPTION = "FoursquareKey Resource";
	
	/**
	 * The path which is handled by this resource/
	 */
	public static final String RESOURCE_PATH = "/foursquare-key"+PATH_PARAM_PART__ITEMS;
	
	/**
	 * Provides the entity manager used by the resource.
	 * @return an instance of the required entity manager
	 */
	@Override
	protected ir.viratech.commons.model.BasicEntityMgr<FoursquareKey> getMgr() {
		return ir.viratech.pond_ms.model.foursquare.logic.FoursquareKeyMgr.getInstance();
	}

	/**
	 * Factory method for FullDTO.
	 * @return a FullDTO instance
	 */
	@Override
	protected ir.viratech.pond_ms.api.foursquare.dto.FoursquareKeyFullDTO createFullDTO() {
		return new ir.viratech.pond_ms.api.foursquare.dto.FoursquareKeyFullDTO();
	}

	/**
	 * Provides the class of FieldInfoContext used for search.
	 * @return the class of FieldInfoContext 
	 */
	@Override
	protected Class<ir.viratech.pond_ms.api.foursquare.dto.FoursquareKeyFullDTO.FieldInfoContext> getFullDtoFieldInfoContextClass() {
		return ir.viratech.pond_ms.api.foursquare.dto.FoursquareKeyFullDTO.FieldInfoContext.class;
	}

	/**
	 * Provides the bundle prefix used in i18n.
	 * @return the bundle prefix
	 */
	@Override
	protected String getBundlePrefix() {
		return "foursquare.key.";
	}
	
	/**
	 * Provides the feature entity name by which access checking is performed.
	 * @return the feature entity name
	 */
	@Override
	protected String getFeatureEntityName() {
		return "POINT_OBJECT";
	}
	
	
	/**
	 * Default constructor.
	 * Also adds the extents.
	 */
	public BaseFoursquareKeyResource() {
		super();
	}

}
