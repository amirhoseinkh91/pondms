package ir.viratech.pond_ms.api.organization.base;

import com.wordnik.swagger.annotations.Api;

import ir.viratech.pond_ms.model.organization.Organization;

/**
 *  Base class for "OrganizationResource".
 *  It is an automatically generated file and should not be edited.
 */
@Api(value = BaseOrganizationResource.RESOURCE_PATH_BASE, description = BaseOrganizationResource.RESOURCE_DESCRIPTION)
public abstract class BaseOrganizationResource extends ir.viratech.pond_ms.api.AbstractMgrBasedTreeResource<Organization, ir.viratech.pond_ms.api.organization.dto.OrganizationFullDTO> {
	
	/**
	 * The resource path base used in swagger.
	 */
	public static final String RESOURCE_PATH_BASE = "/organization"+"/"+PATH_PART_ITEMS;
	
	/**
	 * The resource description used in swagger.
	 */
	public static final String RESOURCE_DESCRIPTION = "Organization Resource";
	
	/**
	 * The path which is handled by this resource/
	 */
	public static final String RESOURCE_PATH = "/organization"+PATH_PARAM_PART__ITEMS;
	
	/**
	 * Provides the entity manager used by the resource.
	 * @return an instance of the required entity manager
	 */
	@Override
	protected ir.viratech.commons.model.BasicEntityMgr<Organization> getMgr() {
		return ir.viratech.pond_ms.model.organization.logic.OrganizationMgr.getInstance();
	}

	/**
	 * Factory method for FullDTO.
	 * @return a FullDTO instance
	 */
	@Override
	protected ir.viratech.pond_ms.api.organization.dto.OrganizationFullDTO createFullDTO() {
		return new ir.viratech.pond_ms.api.organization.dto.OrganizationFullDTO();
	}

	/**
	 * Provides the class of FieldInfoContext used for search.
	 * @return the class of FieldInfoContext 
	 */
	@Override
	protected Class<ir.viratech.pond_ms.api.organization.dto.OrganizationFullDTO.FieldInfoContext> getFullDtoFieldInfoContextClass() {
		return ir.viratech.pond_ms.api.organization.dto.OrganizationFullDTO.FieldInfoContext.class;
	}

	/**
	 * Provides the bundle prefix used in i18n.
	 * @return the bundle prefix
	 */
	@Override
	protected String getBundlePrefix() {
		return "organization.";
	}
	
	/**
	 * Provides the feature entity name by which access checking is performed.
	 * @return the feature entity name
	 */
	@Override
	protected String getFeatureEntityName() {
		return "ORGANIZATION";
	}
	
	
	/**
	 * Default constructor.
	 * Also adds the extents.
	 */
	public BaseOrganizationResource() {
		super();
	}

}
