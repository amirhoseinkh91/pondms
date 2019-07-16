package ir.viratech.pond_ms.api.menu.base;

import com.wordnik.swagger.annotations.Api;

import ir.viratech.pond_ms.model.config.ConfigEntry;

/**
 *  Base class for "ConfigEntryResource".
 *  It is an automatically generated file and should not be edited.
 */
@Api(value = BaseConfigEntryResource.RESOURCE_PATH_BASE, description = BaseConfigEntryResource.RESOURCE_DESCRIPTION)
public abstract class BaseConfigEntryResource extends ir.viratech.pond_ms.api.AbstractMgrBasedResource<ConfigEntry, ir.viratech.pond_ms.api.menu.dto.ConfigEntryFullDTO> {
	
	/**
	 * The resource path base used in swagger.
	 */
	public static final String RESOURCE_PATH_BASE = "/config_entry"+"/"+PATH_PART_ITEMS;
	
	/**
	 * The resource description used in swagger.
	 */
	public static final String RESOURCE_DESCRIPTION = "ConfigEntry Resource";
	
	/**
	 * The path which is handled by this resource/
	 */
	public static final String RESOURCE_PATH = "/config_entry"+PATH_PARAM_PART__ITEMS;
	
	/**
	 * Provides the entity manager used by the resource.
	 * @return an instance of the required entity manager
	 */
	@Override
	protected ir.viratech.commons.model.BasicEntityMgr<ConfigEntry> getMgr() {
		return ir.viratech.pond_ms.model.config.logic.ConfigEntryMgr.getInstance();
	}

	/**
	 * Factory method for FullDTO.
	 * @return a FullDTO instance
	 */
	@Override
	protected ir.viratech.pond_ms.api.menu.dto.ConfigEntryFullDTO createFullDTO() {
		return new ir.viratech.pond_ms.api.menu.dto.ConfigEntryFullDTO();
	}

	/**
	 * Provides the class of FieldInfoContext used for search.
	 * @return the class of FieldInfoContext 
	 */
	@Override
	protected Class<ir.viratech.pond_ms.api.menu.dto.ConfigEntryFullDTO.FieldInfoContext> getFullDtoFieldInfoContextClass() {
		return ir.viratech.pond_ms.api.menu.dto.ConfigEntryFullDTO.FieldInfoContext.class;
	}

	/**
	 * Provides the bundle prefix used in i18n.
	 * @return the bundle prefix
	 */
	@Override
	protected String getBundlePrefix() {
		return "configEntry.";
	}
	
	/**
	 * Provides the feature entity name by which access checking is performed.
	 * @return the feature entity name
	 */
	@Override
	protected String getFeatureEntityName() {
		return "CONFIG_ENTRY";
	}
	
	
	/**
	 * Default constructor.
	 * Also adds the extents.
	 */
	public BaseConfigEntryResource() {
		super();
	}

}
