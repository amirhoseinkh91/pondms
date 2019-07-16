package ir.viratech.pond_ms.api.user.base;

import com.wordnik.swagger.annotations.Api;

import ir.viratech.pond_ms.model.user.User;

/**
 *  Base class for "UserResource".
 *  It is an automatically generated file and should not be edited.
 */
@Api(value = BaseUserResource.RESOURCE_PATH_BASE, description = BaseUserResource.RESOURCE_DESCRIPTION)
public abstract class BaseUserResource extends ir.viratech.pond_ms.api.AbstractMgrBasedResource<User, ir.viratech.pond_ms.api.user.dto.UserFullDTO> {
	
	/**
	 * The resource path base used in swagger.
	 */
	public static final String RESOURCE_PATH_BASE = "/user"+"/"+PATH_PART_ITEMS;
	
	/**
	 * The resource description used in swagger.
	 */
	public static final String RESOURCE_DESCRIPTION = "User Resource";
	
	/**
	 * The path which is handled by this resource/
	 */
	public static final String RESOURCE_PATH = "/user"+PATH_PARAM_PART__ITEMS;
	
	/**
	 * Provides the entity manager used by the resource.
	 * @return an instance of the required entity manager
	 */
	@Override
	protected ir.viratech.commons.model.BasicEntityMgr<User> getMgr() {
		return ir.viratech.pond_ms.model.user.logic.UserMgr.getInstance();
	}

	/**
	 * Factory method for FullDTO.
	 * @return a FullDTO instance
	 */
	@Override
	protected ir.viratech.pond_ms.api.user.dto.UserFullDTO createFullDTO() {
		return new ir.viratech.pond_ms.api.user.dto.UserFullDTO();
	}

	/**
	 * Provides the class of FieldInfoContext used for search.
	 * @return the class of FieldInfoContext 
	 */
	@Override
	protected Class<ir.viratech.pond_ms.api.user.dto.UserFullDTO.FieldInfoContext> getFullDtoFieldInfoContextClass() {
		return ir.viratech.pond_ms.api.user.dto.UserFullDTO.FieldInfoContext.class;
	}

	/**
	 * Provides the bundle prefix used in i18n.
	 * @return the bundle prefix
	 */
	@Override
	protected String getBundlePrefix() {
		return "user.";
	}
	
	/**
	 * Provides the feature entity name by which access checking is performed.
	 * @return the feature entity name
	 */
	@Override
	protected String getFeatureEntityName() {
		return "USER";
	}
	
	
	/**
	 * Default constructor.
	 * Also adds the extents.
	 */
	public BaseUserResource() {
		super();
	}

}
