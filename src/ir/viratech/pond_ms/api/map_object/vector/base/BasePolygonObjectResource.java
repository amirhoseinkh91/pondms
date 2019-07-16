package ir.viratech.pond_ms.api.map_object.vector.base;

import com.wordnik.swagger.annotations.Api;

import ir.viratech.pond_ms.model.map_object.vector.PolygonObject;

/**
 *  Base class for "PolygonObjectResource".
 *  It is an automatically generated file and should not be edited.
 */
@Api(value = BasePolygonObjectResource.RESOURCE_PATH_BASE, description = BasePolygonObjectResource.RESOURCE_DESCRIPTION)
public abstract class BasePolygonObjectResource extends ir.viratech.pond_ms.api.AbstractMgrBasedResource<PolygonObject, ir.viratech.pond_ms.api.map_object.vector.dto.PolygonObjectFullDTO> {
	
	/**
	 * The resource path base used in swagger.
	 */
	public static final String RESOURCE_PATH_BASE = "/polygon-object"+"/"+PATH_PART_ITEMS;
	
	/**
	 * The resource description used in swagger.
	 */
	public static final String RESOURCE_DESCRIPTION = "PolygonObject Resource";
	
	/**
	 * The path which is handled by this resource/
	 */
	public static final String RESOURCE_PATH = "/polygon-object"+PATH_PARAM_PART__ITEMS;
	
	/**
	 * Provides the entity manager used by the resource.
	 * @return an instance of the required entity manager
	 */
	@Override
	protected ir.viratech.commons.model.BasicEntityMgr<PolygonObject> getMgr() {
		return ir.viratech.pond_ms.model.map_object.vector.logic.PolygonObjectMgr.getInstance();
	}

	/**
	 * Factory method for FullDTO.
	 * @return a FullDTO instance
	 */
	@Override
	protected ir.viratech.pond_ms.api.map_object.vector.dto.PolygonObjectFullDTO createFullDTO() {
		return new ir.viratech.pond_ms.api.map_object.vector.dto.PolygonObjectFullDTO();
	}

	/**
	 * Provides the class of FieldInfoContext used for search.
	 * @return the class of FieldInfoContext 
	 */
	@Override
	protected Class<ir.viratech.pond_ms.api.map_object.vector.dto.PolygonObjectFullDTO.FieldInfoContext> getFullDtoFieldInfoContextClass() {
		return ir.viratech.pond_ms.api.map_object.vector.dto.PolygonObjectFullDTO.FieldInfoContext.class;
	}

	/**
	 * Provides the bundle prefix used in i18n.
	 * @return the bundle prefix
	 */
	@Override
	protected String getBundlePrefix() {
		return "polygonobject.";
	}
	
	/**
	 * Provides the feature entity name by which access checking is performed.
	 * @return the feature entity name
	 */
	@Override
	protected String getFeatureEntityName() {
		return "POLYGON_OBJECT";
	}
	
	
	/**
	 * Default constructor.
	 * Also adds the extents.
	 */
	public BasePolygonObjectResource() {
		super();
	}

}
