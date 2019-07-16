package ir.viratech.pond_ms.api.layer.base;

import com.wordnik.swagger.annotations.Api;

import ir.viratech.pond_ms.model.layer.Pond;

/**
 *  Base class for "PondResource".
 *  It is an automatically generated file and should not be edited.
 */
@Api(value = BasePondResource.RESOURCE_PATH_BASE, description = BasePondResource.RESOURCE_DESCRIPTION)
public abstract class BasePondResource extends ir.viratech.pond_ms.api.AbstractOrganizationBasedMgrBasedResource<Pond, ir.viratech.pond_ms.api.layer.dto.PondFullDTO> {
	
	/**
	 * The resource path base used in swagger.
	 */
	public static final String RESOURCE_PATH_BASE = "/org/{org_key}/pond"+"/"+PATH_PART_ITEMS;
	
	/**
	 * The resource description used in swagger.
	 */
	public static final String RESOURCE_DESCRIPTION = "Pond Resource";
	
	/**
	 * The path which is handled by this resource/
	 */
	public static final String RESOURCE_PATH = "/org/{org_key}/pond"+PATH_PARAM_PART__ITEMS;
	
	/**
	 * Provides the entity manager used by the resource.
	 * @return an instance of the required entity manager
	 */
	@Override
	protected ir.viratech.commons.model.BasicEntityMgr<Pond> getMgr() {
		return ir.viratech.pond_ms.model.layer.logic.PondMgr.getInstance();
	}

	/**
	 * Factory method for FullDTO.
	 * @return a FullDTO instance
	 */
	@Override
	protected ir.viratech.pond_ms.api.layer.dto.PondFullDTO createFullDTO() {
		return new ir.viratech.pond_ms.api.layer.dto.PondFullDTO();
	}

	/**
	 * Provides the class of FieldInfoContext used for search.
	 * @return the class of FieldInfoContext 
	 */
	@Override
	protected Class<ir.viratech.pond_ms.api.layer.dto.PondFullDTO.FieldInfoContext> getFullDtoFieldInfoContextClass() {
		return ir.viratech.pond_ms.api.layer.dto.PondFullDTO.FieldInfoContext.class;
	}

	/**
	 * Provides the bundle prefix used in i18n.
	 * @return the bundle prefix
	 */
	@Override
	protected String getBundlePrefix() {
		return "pond.";
	}
	
	/**
	 * Provides the feature entity name by which access checking is performed.
	 * @return the feature entity name
	 */
	@Override
	protected String getFeatureEntityName() {
		return "POND";
	}
	
	
	/**
	 * Default constructor.
	 * Also adds the extents.
	 */
	public BasePondResource() {
		super();
	}

}
