package ir.viratech.pond_ms.api.map_object.vector.base;

import com.wordnik.swagger.annotations.Api;

import ir.viratech.pond_ms.model.map_object.vector.GISVectorObject;

/**
 *  Base class for "GISVectorObjectAnonymousResource".
 *  It is an automatically generated file and should not be edited.
 */
@Api(value = BaseGISVectorObjectAnonymousResource.RESOURCE_PATH_BASE, description = BaseGISVectorObjectAnonymousResource.RESOURCE_DESCRIPTION)
public abstract class BaseGISVectorObjectAnonymousResource extends ir.viratech.pond_ms.api.AbstractMgrBasedResource<GISVectorObject, ir.viratech.pond_ms.api.map_object.vector.dto.GISVectorObjectFullDTO> {
	
	/**
	 * The resource path base used in swagger.
	 */
	public static final String RESOURCE_PATH_BASE = "/gis-vector-object"+"/"+PATH_PART_ITEMS;
	
	/**
	 * The resource description used in swagger.
	 */
	public static final String RESOURCE_DESCRIPTION = "GISVectorObject Resource";
	
	/**
	 * The path which is handled by this resource/
	 */
	public static final String RESOURCE_PATH = "/gis-vector-object"+PATH_PARAM_PART__ITEMS;
	
	/**
	 * Provides the entity manager used by the resource.
	 * @return an instance of the required entity manager
	 */
	@Override
	protected ir.viratech.commons.model.BasicEntityMgr<GISVectorObject> getMgr() {
		return ir.viratech.pond_ms.model.map_object.vector.logic.GISVectorObjectMgr.getInstance();
	}

	/**
	 * Factory method for FullDTO.
	 * @return a FullDTO instance
	 */
	@Override
	protected ir.viratech.pond_ms.api.map_object.vector.dto.GISVectorObjectFullDTO createFullDTO() {
		return new ir.viratech.pond_ms.api.map_object.vector.dto.GISVectorObjectFullDTO();
	}

	/**
	 * Provides the class of FieldInfoContext used for search.
	 * @return the class of FieldInfoContext 
	 */
	@Override
	protected Class<ir.viratech.pond_ms.api.map_object.vector.dto.GISVectorObjectFullDTO.FieldInfoContext> getFullDtoFieldInfoContextClass() {
		return ir.viratech.pond_ms.api.map_object.vector.dto.GISVectorObjectFullDTO.FieldInfoContext.class;
	}

	/**
	 * Provides the bundle prefix used in i18n.
	 * @return the bundle prefix
	 */
	@Override
	protected String getBundlePrefix() {
		return "gisvectorobject.";
	}
	
	
	/**
	 * Default constructor.
	 * Also adds the extents.
	 */
	public BaseGISVectorObjectAnonymousResource() {
		super();
	}

}
