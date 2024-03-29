package ir.viratech.pond_ms.api.layer.base;

import com.wordnik.swagger.annotations.Api;

import ir.viratech.pond_ms.model.layer.Layer;

/**
 *  Base class for "LayerAnonymousResource".
 *  It is an automatically generated file and should not be edited.
 */
@Api(value = BaseLayerAnonymousResource.RESOURCE_PATH_BASE, description = BaseLayerAnonymousResource.RESOURCE_DESCRIPTION)
public abstract class BaseLayerAnonymousResource extends ir.viratech.pond_ms.api.AbstractMgrBasedResource<Layer, ir.viratech.pond_ms.api.layer.dto.LayerFullDTO> {
	
	/**
	 * The resource path base used in swagger.
	 */
	public static final String RESOURCE_PATH_BASE = "/layer"+"/"+PATH_PART_ITEMS;
	
	/**
	 * The resource description used in swagger.
	 */
	public static final String RESOURCE_DESCRIPTION = "Layer Resource";
	
	/**
	 * The path which is handled by this resource/
	 */
	public static final String RESOURCE_PATH = "/layer"+PATH_PARAM_PART__ITEMS;
	
	/**
	 * Provides the entity manager used by the resource.
	 * @return an instance of the required entity manager
	 */
	@Override
	protected ir.viratech.commons.model.BasicEntityMgr<Layer> getMgr() {
		return ir.viratech.pond_ms.model.layer.logic.LayerMgr.getInstance();
	}

	/**
	 * Factory method for FullDTO.
	 * @return a FullDTO instance
	 */
	@Override
	protected ir.viratech.pond_ms.api.layer.dto.LayerFullDTO createFullDTO() {
		return new ir.viratech.pond_ms.api.layer.dto.LayerFullDTO();
	}

	/**
	 * Provides the class of FieldInfoContext used for search.
	 * @return the class of FieldInfoContext 
	 */
	@Override
	protected Class<ir.viratech.pond_ms.api.layer.dto.LayerFullDTO.FieldInfoContext> getFullDtoFieldInfoContextClass() {
		return ir.viratech.pond_ms.api.layer.dto.LayerFullDTO.FieldInfoContext.class;
	}

	/**
	 * Provides the bundle prefix used in i18n.
	 * @return the bundle prefix
	 */
	@Override
	protected String getBundlePrefix() {
		return "layer.";
	}
	
	
	/**
	 * Default constructor.
	 * Also adds the extents.
	 */
	public BaseLayerAnonymousResource() {
		super();
	}

}
