package ir.viratech.pond_ms.api.layer.base;

import com.wordnik.swagger.annotations.Api;

import ir.viratech.pond_ms.model.layer.ParentLayer;

/**
 *  Base class for "ParentLayerResource".
 *  It is an automatically generated file and should not be edited.
 */
@Api(value = BaseParentLayerResource.RESOURCE_PATH_BASE, description = BaseParentLayerResource.RESOURCE_DESCRIPTION)
public abstract class BaseParentLayerResource extends ir.viratech.pond_ms.api.AbstractMgrBasedResource<ParentLayer, ir.viratech.pond_ms.api.layer.dto.ParentLayerFullDTO> {
	
	/**
	 * The resource path base used in swagger.
	 */
	public static final String RESOURCE_PATH_BASE = "/parentlayer"+"/"+PATH_PART_ITEMS;
	
	/**
	 * The resource description used in swagger.
	 */
	public static final String RESOURCE_DESCRIPTION = "ParentLayer Resource";
	
	/**
	 * The path which is handled by this resource/
	 */
	public static final String RESOURCE_PATH = "/parentlayer"+PATH_PARAM_PART__ITEMS;
	
	/**
	 * Provides the entity manager used by the resource.
	 * @return an instance of the required entity manager
	 */
	@Override
	protected ir.viratech.commons.model.BasicEntityMgr<ParentLayer> getMgr() {
		return ir.viratech.pond_ms.model.layer.logic.ParentLayerMgr.getInstance();
	}

	/**
	 * Factory method for FullDTO.
	 * @return a FullDTO instance
	 */
	@Override
	protected ir.viratech.pond_ms.api.layer.dto.ParentLayerFullDTO createFullDTO() {
		return new ir.viratech.pond_ms.api.layer.dto.ParentLayerFullDTO();
	}

	/**
	 * Provides the class of FieldInfoContext used for search.
	 * @return the class of FieldInfoContext 
	 */
	@Override
	protected Class<ir.viratech.pond_ms.api.layer.dto.ParentLayerFullDTO.FieldInfoContext> getFullDtoFieldInfoContextClass() {
		return ir.viratech.pond_ms.api.layer.dto.ParentLayerFullDTO.FieldInfoContext.class;
	}

	/**
	 * Provides the bundle prefix used in i18n.
	 * @return the bundle prefix
	 */
	@Override
	protected String getBundlePrefix() {
		return "parentlayer.";
	}
	
	/**
	 * Provides the feature entity name by which access checking is performed.
	 * @return the feature entity name
	 */
	@Override
	protected String getFeatureEntityName() {
		return "PARENT_LAYER";
	}
	
	
	/**
	 * Default constructor.
	 * Also adds the extents.
	 */
	public BaseParentLayerResource() {
		super();
	}

}
