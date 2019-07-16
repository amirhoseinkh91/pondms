package ir.viratech.pond_ms.api.layer.base;

import com.wordnik.swagger.annotations.Api;

import ir.viratech.pond_ms.model.layer.LeafLayer;

/**
 *  Base class for "LeafLayerResource".
 *  It is an automatically generated file and should not be edited.
 */
@Api(value = BaseLeafLayerResource.RESOURCE_PATH_BASE, description = BaseLeafLayerResource.RESOURCE_DESCRIPTION)
public abstract class BaseLeafLayerResource extends ir.viratech.pond_ms.api.AbstractMgrBasedResource<LeafLayer, ir.viratech.pond_ms.api.layer.dto.LeafLayerFullDTO> {
	
	/**
	 * The resource path base used in swagger.
	 */
	public static final String RESOURCE_PATH_BASE = "/leaflayer"+"/"+PATH_PART_ITEMS;
	
	/**
	 * The resource description used in swagger.
	 */
	public static final String RESOURCE_DESCRIPTION = "LeafLayer Resource";
	
	/**
	 * The path which is handled by this resource/
	 */
	public static final String RESOURCE_PATH = "/leaflayer"+PATH_PARAM_PART__ITEMS;
	
	/**
	 * Provides the entity manager used by the resource.
	 * @return an instance of the required entity manager
	 */
	@Override
	protected ir.viratech.commons.model.BasicEntityMgr<LeafLayer> getMgr() {
		return ir.viratech.pond_ms.model.layer.logic.LeafLayerMgr.getInstance();
	}

	/**
	 * Factory method for FullDTO.
	 * @return a FullDTO instance
	 */
	@Override
	protected ir.viratech.pond_ms.api.layer.dto.LeafLayerFullDTO createFullDTO() {
		return new ir.viratech.pond_ms.api.layer.dto.LeafLayerFullDTO();
	}

	/**
	 * Provides the class of FieldInfoContext used for search.
	 * @return the class of FieldInfoContext 
	 */
	@Override
	protected Class<ir.viratech.pond_ms.api.layer.dto.LeafLayerFullDTO.FieldInfoContext> getFullDtoFieldInfoContextClass() {
		return ir.viratech.pond_ms.api.layer.dto.LeafLayerFullDTO.FieldInfoContext.class;
	}

	/**
	 * Provides the bundle prefix used in i18n.
	 * @return the bundle prefix
	 */
	@Override
	protected String getBundlePrefix() {
		return "leaflayer.";
	}
	
	/**
	 * Provides the feature entity name by which access checking is performed.
	 * @return the feature entity name
	 */
	@Override
	protected String getFeatureEntityName() {
		return "LEAF_LAYER";
	}
	
	
	/**
	 * Default constructor.
	 * Also adds the extents.
	 */
	public BaseLeafLayerResource() {
		super();
	}

}
