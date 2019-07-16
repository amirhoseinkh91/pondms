package ir.viratech.pond_ms.api.time_series.base;

import com.wordnik.swagger.annotations.Api;

import ir.viratech.pond_ms.model.time_series.Category;

/**
 *  Base class for "CategoryResource".
 *  It is an automatically generated file and should not be edited.
 */
@Api(value = BaseCategoryResource.RESOURCE_PATH_BASE, description = BaseCategoryResource.RESOURCE_DESCRIPTION)
public abstract class BaseCategoryResource extends ir.viratech.pond_ms.api.AbstractMgrBasedResource<Category, ir.viratech.pond_ms.api.time_series.dto.CategoryFullDTO> {
	
	/**
	 * The resource path base used in swagger.
	 */
	public static final String RESOURCE_PATH_BASE = "/category"+"/"+PATH_PART_ITEMS;
	
	/**
	 * The resource description used in swagger.
	 */
	public static final String RESOURCE_DESCRIPTION = "Category Resource";
	
	/**
	 * The path which is handled by this resource/
	 */
	public static final String RESOURCE_PATH = "/category"+PATH_PARAM_PART__ITEMS;
	
	/**
	 * Provides the entity manager used by the resource.
	 * @return an instance of the required entity manager
	 */
	@Override
	protected ir.viratech.commons.model.BasicEntityMgr<Category> getMgr() {
		return ir.viratech.pond_ms.model.time_series.logic.CategoryMgr.getInstance();
	}

	/**
	 * Factory method for FullDTO.
	 * @return a FullDTO instance
	 */
	@Override
	protected ir.viratech.pond_ms.api.time_series.dto.CategoryFullDTO createFullDTO() {
		return new ir.viratech.pond_ms.api.time_series.dto.CategoryFullDTO();
	}

	/**
	 * Provides the class of FieldInfoContext used for search.
	 * @return the class of FieldInfoContext 
	 */
	@Override
	protected Class<ir.viratech.pond_ms.api.time_series.dto.CategoryFullDTO.FieldInfoContext> getFullDtoFieldInfoContextClass() {
		return ir.viratech.pond_ms.api.time_series.dto.CategoryFullDTO.FieldInfoContext.class;
	}

	/**
	 * Provides the bundle prefix used in i18n.
	 * @return the bundle prefix
	 */
	@Override
	protected String getBundlePrefix() {
		return "time_series.";
	}
	
	/**
	 * Provides the feature entity name by which access checking is performed.
	 * @return the feature entity name
	 */
	@Override
	protected String getFeatureEntityName() {
		return "CATEGORY";
	}
	
	
	/**
	 * Default constructor.
	 * Also adds the extents.
	 */
	public BaseCategoryResource() {
		super();
	}

}
