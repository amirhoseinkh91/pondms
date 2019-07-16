package ir.viratech.pond_ms.api.user.base;

import com.wordnik.swagger.annotations.Api;

import ir.viratech.pond_ms.model.user.role.UserRole;

/**
 *  Base class for "RoleResource".
 *  It is an automatically generated file and should not be edited.
 */
@Api(value = BaseRoleResource.RESOURCE_PATH_BASE, description = BaseRoleResource.RESOURCE_DESCRIPTION)
public abstract class BaseRoleResource extends ir.viratech.pond_ms.api.AbstractMgrBasedResource<UserRole, ir.viratech.pond_ms.api.user.dto.UserRoleFullDTO> {
	
	/**
	 * The resource path base used in swagger.
	 */
	public static final String RESOURCE_PATH_BASE = "/role"+"/"+PATH_PART_ITEMS;
	
	/**
	 * The resource description used in swagger.
	 */
	public static final String RESOURCE_DESCRIPTION = "UserRole Resource";
	
	/**
	 * The path which is handled by this resource/
	 */
	public static final String RESOURCE_PATH = "/role"+PATH_PARAM_PART__ITEMS;
	
	/**
	 * Provides the entity manager used by the resource.
	 * @return an instance of the required entity manager
	 */
	@Override
	protected ir.viratech.commons.model.BasicEntityMgr<UserRole> getMgr() {
		return ir.viratech.pond_ms.model.user.role.logic.UserRoleMgr.getInstance();
	}

	/**
	 * Factory method for FullDTO.
	 * @return a FullDTO instance
	 */
	@Override
	protected ir.viratech.pond_ms.api.user.dto.UserRoleFullDTO createFullDTO() {
		return new ir.viratech.pond_ms.api.user.dto.UserRoleFullDTO();
	}

	/**
	 * Provides the class of FieldInfoContext used for search.
	 * @return the class of FieldInfoContext 
	 */
	@Override
	protected Class<ir.viratech.pond_ms.api.user.dto.UserRoleFullDTO.FieldInfoContext> getFullDtoFieldInfoContextClass() {
		return ir.viratech.pond_ms.api.user.dto.UserRoleFullDTO.FieldInfoContext.class;
	}

	/**
	 * Provides the bundle prefix used in i18n.
	 * @return the bundle prefix
	 */
	@Override
	protected String getBundlePrefix() {
		return "role.";
	}
	
	/**
	 * Provides the feature entity name by which access checking is performed.
	 * @return the feature entity name
	 */
	@Override
	protected String getFeatureEntityName() {
		return "ROLE";
	}
	
	
	/**
	 * Default constructor.
	 * Also adds the extents.
	 */
	public BaseRoleResource() {
		super();
	}

}
