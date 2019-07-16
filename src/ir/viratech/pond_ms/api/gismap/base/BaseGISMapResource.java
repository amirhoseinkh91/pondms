package ir.viratech.pond_ms.api.gismap.base;

import com.wordnik.swagger.annotations.Api;

import ir.viratech.pond_ms.model.gismap.GISMap;

/**
 *  Base class for "GISMapResource".
 *  It is an automatically generated file and should not be edited.
 */
@Api(value = BaseGISMapResource.RESOURCE_PATH_BASE, description = BaseGISMapResource.RESOURCE_DESCRIPTION)
public abstract class BaseGISMapResource extends ir.viratech.pond_ms.api.AbstractOrganizationBasedMgrBasedResource<GISMap, ir.viratech.pond_ms.api.gismap.dto.GISMapFullDTO> {
	
	/**
	 * The resource path base used in swagger.
	 */
	public static final String RESOURCE_PATH_BASE = "/org/{org_key}/gis-map"+"/"+PATH_PART_ITEMS;
	
	/**
	 * The resource description used in swagger.
	 */
	public static final String RESOURCE_DESCRIPTION = "GISMap Resource";
	
	/**
	 * The path which is handled by this resource/
	 */
	public static final String RESOURCE_PATH = "/org/{org_key}/gis-map"+PATH_PARAM_PART__ITEMS;
	
	/**
	 * Provides the entity manager used by the resource.
	 * @return an instance of the required entity manager
	 */
	@Override
	protected ir.viratech.commons.model.BasicEntityMgr<GISMap> getMgr() {
		return ir.viratech.pond_ms.model.gismap.logic.GISMapMgr.getInstance();
	}

	/**
	 * Factory method for FullDTO.
	 * @return a FullDTO instance
	 */
	@Override
	protected ir.viratech.pond_ms.api.gismap.dto.GISMapFullDTO createFullDTO() {
		return new ir.viratech.pond_ms.api.gismap.dto.GISMapFullDTO();
	}

	/**
	 * Provides the class of FieldInfoContext used for search.
	 * @return the class of FieldInfoContext 
	 */
	@Override
	protected Class<ir.viratech.pond_ms.api.gismap.dto.GISMapFullDTO.FieldInfoContext> getFullDtoFieldInfoContextClass() {
		return ir.viratech.pond_ms.api.gismap.dto.GISMapFullDTO.FieldInfoContext.class;
	}

	/**
	 * Provides the bundle prefix used in i18n.
	 * @return the bundle prefix
	 */
	@Override
	protected String getBundlePrefix() {
		return "gismap.";
	}
	
	/**
	 * Provides the feature entity name by which access checking is performed.
	 * @return the feature entity name
	 */
	@Override
	protected String getFeatureEntityName() {
		return "GIS_MAP";
	}
	
	
	/**
	 * Default constructor.
	 * Also adds the extents.
	 */
	public BaseGISMapResource() {
		super();
	}

}
