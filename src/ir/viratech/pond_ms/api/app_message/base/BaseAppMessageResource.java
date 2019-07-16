package ir.viratech.pond_ms.api.app_message.base;

import com.wordnik.swagger.annotations.Api;

import ir.viratech.pond_ms.model.app_message.AppMessage;

/**
 *  Base class for "AppMessageResource".
 *  It is an automatically generated file and should not be edited.
 */
@Api(value = BaseAppMessageResource.RESOURCE_PATH_BASE, description = BaseAppMessageResource.RESOURCE_DESCRIPTION)
public abstract class BaseAppMessageResource extends ir.viratech.pond_ms.api.AbstractMgrBasedResource<AppMessage, ir.viratech.pond_ms.api.app_message.dto.AppMessageFullDTO> {
	
	/**
	 * The resource path base used in swagger.
	 */
	public static final String RESOURCE_PATH_BASE = "/app-message"+"/"+PATH_PART_ITEMS;
	
	/**
	 * The resource description used in swagger.
	 */
	public static final String RESOURCE_DESCRIPTION = "AppMessage Resource";
	
	/**
	 * The path which is handled by this resource/
	 */
	public static final String RESOURCE_PATH = "/app-message"+PATH_PARAM_PART__ITEMS;
	
	/**
	 * Provides the entity manager used by the resource.
	 * @return an instance of the required entity manager
	 */
	@Override
	protected ir.viratech.commons.model.BasicEntityMgr<AppMessage> getMgr() {
		return ir.viratech.pond_ms.model.app_message.logic.AppMessageMgr.getInstance();
	}

	/**
	 * Factory method for FullDTO.
	 * @return a FullDTO instance
	 */
	@Override
	protected ir.viratech.pond_ms.api.app_message.dto.AppMessageFullDTO createFullDTO() {
		return new ir.viratech.pond_ms.api.app_message.dto.AppMessageFullDTO();
	}

	/**
	 * Provides the class of FieldInfoContext used for search.
	 * @return the class of FieldInfoContext 
	 */
	@Override
	protected Class<ir.viratech.pond_ms.api.app_message.dto.AppMessageFullDTO.FieldInfoContext> getFullDtoFieldInfoContextClass() {
		return ir.viratech.pond_ms.api.app_message.dto.AppMessageFullDTO.FieldInfoContext.class;
	}

	/**
	 * Provides the bundle prefix used in i18n.
	 * @return the bundle prefix
	 */
	@Override
	protected String getBundlePrefix() {
		return "message.app.";
	}
	
	/**
	 * Provides the feature entity name by which access checking is performed.
	 * @return the feature entity name
	 */
	@Override
	protected String getFeatureEntityName() {
		return "APP_MESSAGE";
	}
	
	
	/**
	 * Default constructor.
	 * Also adds the extents.
	 */
	public BaseAppMessageResource() {
		super();
	}

}
