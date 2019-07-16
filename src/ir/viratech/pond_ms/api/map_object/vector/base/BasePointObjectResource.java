package ir.viratech.pond_ms.api.map_object.vector.base;

import com.wordnik.swagger.annotations.Api;

import ir.viratech.pond_ms.model.map_object.vector.PointObject;

/**
 *  Base class for "PointObjectResource".
 *  It is an automatically generated file and should not be edited.
 */
@Api(value = BasePointObjectResource.RESOURCE_PATH_BASE, description = BasePointObjectResource.RESOURCE_DESCRIPTION)
public abstract class BasePointObjectResource extends ir.viratech.pond_ms.api.AbstractMgrBasedResource<PointObject, ir.viratech.pond_ms.api.map_object.vector.dto.PointObjectFullDTO> {
	
	/**
	 * The resource path base used in swagger.
	 */
	public static final String RESOURCE_PATH_BASE = "/point-object"+"/"+PATH_PART_ITEMS;
	
	/**
	 * The resource description used in swagger.
	 */
	public static final String RESOURCE_DESCRIPTION = "PointObject Resource";
	
	/**
	 * The path which is handled by this resource/
	 */
	public static final String RESOURCE_PATH = "/point-object"+PATH_PARAM_PART__ITEMS;
	
	/**
	 * Provides the entity manager used by the resource.
	 * @return an instance of the required entity manager
	 */
	@Override
	protected ir.viratech.commons.model.BasicEntityMgr<PointObject> getMgr() {
		return ir.viratech.pond_ms.model.map_object.vector.logic.PointObjectMgr.getInstance();
	}

	/**
	 * Factory method for FullDTO.
	 * @return a FullDTO instance
	 */
	@Override
	protected ir.viratech.pond_ms.api.map_object.vector.dto.PointObjectFullDTO createFullDTO() {
		return new ir.viratech.pond_ms.api.map_object.vector.dto.PointObjectFullDTO();
	}

	/**
	 * Provides the class of FieldInfoContext used for search.
	 * @return the class of FieldInfoContext 
	 */
	@Override
	protected Class<ir.viratech.pond_ms.api.map_object.vector.dto.PointObjectFullDTO.FieldInfoContext> getFullDtoFieldInfoContextClass() {
		return ir.viratech.pond_ms.api.map_object.vector.dto.PointObjectFullDTO.FieldInfoContext.class;
	}

	/**
	 * Provides the bundle prefix used in i18n.
	 * @return the bundle prefix
	 */
	@Override
	protected String getBundlePrefix() {
		return "pointobject.";
	}
	
	/**
	 * Provides the feature entity name by which access checking is performed.
	 * @return the feature entity name
	 */
	@Override
	protected String getFeatureEntityName() {
		return "POINT_OBJECT";
	}
	
	
	/**
	 * Default constructor.
	 * Also adds the extents.
	 */
	public BasePointObjectResource() {
		super();
	}

}
