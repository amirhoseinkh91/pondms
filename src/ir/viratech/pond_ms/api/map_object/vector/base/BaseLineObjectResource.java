package ir.viratech.pond_ms.api.map_object.vector.base;

import com.wordnik.swagger.annotations.Api;

import ir.viratech.pond_ms.model.map_object.vector.LineObject;

/**
 *  Base class for "LineObjectResource".
 *  It is an automatically generated file and should not be edited.
 */
@Api(value = BaseLineObjectResource.RESOURCE_PATH_BASE, description = BaseLineObjectResource.RESOURCE_DESCRIPTION)
public abstract class BaseLineObjectResource extends ir.viratech.pond_ms.api.AbstractMgrBasedResource<LineObject, ir.viratech.pond_ms.api.map_object.vector.dto.LineObjectFullDTO> {
	
	/**
	 * The resource path base used in swagger.
	 */
	public static final String RESOURCE_PATH_BASE = "/line-object"+"/"+PATH_PART_ITEMS;
	
	/**
	 * The resource description used in swagger.
	 */
	public static final String RESOURCE_DESCRIPTION = "LineObject Resource";
	
	/**
	 * The path which is handled by this resource/
	 */
	public static final String RESOURCE_PATH = "/line-object"+PATH_PARAM_PART__ITEMS;
	
	/**
	 * Provides the entity manager used by the resource.
	 * @return an instance of the required entity manager
	 */
	@Override
	protected ir.viratech.commons.model.BasicEntityMgr<LineObject> getMgr() {
		return ir.viratech.pond_ms.model.map_object.vector.logic.LineObjectMgr.getInstance();
	}

	/**
	 * Factory method for FullDTO.
	 * @return a FullDTO instance
	 */
	@Override
	protected ir.viratech.pond_ms.api.map_object.vector.dto.LineObjectFullDTO createFullDTO() {
		return new ir.viratech.pond_ms.api.map_object.vector.dto.LineObjectFullDTO();
	}

	/**
	 * Provides the class of FieldInfoContext used for search.
	 * @return the class of FieldInfoContext 
	 */
	@Override
	protected Class<ir.viratech.pond_ms.api.map_object.vector.dto.LineObjectFullDTO.FieldInfoContext> getFullDtoFieldInfoContextClass() {
		return ir.viratech.pond_ms.api.map_object.vector.dto.LineObjectFullDTO.FieldInfoContext.class;
	}

	/**
	 * Provides the bundle prefix used in i18n.
	 * @return the bundle prefix
	 */
	@Override
	protected String getBundlePrefix() {
		return "lineobject.";
	}
	
	/**
	 * Provides the feature entity name by which access checking is performed.
	 * @return the feature entity name
	 */
	@Override
	protected String getFeatureEntityName() {
		return "LINE_OBJECT";
	}
	
	
	/**
	 * Default constructor.
	 * Also adds the extents.
	 */
	public BaseLineObjectResource() {
		super();
	}

}
