package ir.viratech.pond_ms.api.time_series.base;

import com.wordnik.swagger.annotations.Api;

import ir.viratech.pond_ms.model.time_series.TimeSeriesGroup;

/**
 *  Base class for "TimeSeriesGroupResource".
 *  It is an automatically generated file and should not be edited.
 */
@Api(value = BaseTimeSeriesGroupResource.RESOURCE_PATH_BASE, description = BaseTimeSeriesGroupResource.RESOURCE_DESCRIPTION)
public abstract class BaseTimeSeriesGroupResource extends ir.viratech.pond_ms.api.AbstractMgrBasedResource<TimeSeriesGroup, ir.viratech.pond_ms.api.time_series.dto.TimeSeriesGroupFullDTO> {
	
	/**
	 * The resource path base used in swagger.
	 */
	public static final String RESOURCE_PATH_BASE = "/time_series_group"+"/"+PATH_PART_ITEMS;
	
	/**
	 * The resource description used in swagger.
	 */
	public static final String RESOURCE_DESCRIPTION = "TimeSeriesGroup Resource";
	
	/**
	 * The path which is handled by this resource/
	 */
	public static final String RESOURCE_PATH = "/time_series_group"+PATH_PARAM_PART__ITEMS;
	
	/**
	 * Provides the entity manager used by the resource.
	 * @return an instance of the required entity manager
	 */
	@Override
	protected ir.viratech.commons.model.BasicEntityMgr<TimeSeriesGroup> getMgr() {
		return ir.viratech.pond_ms.model.time_series.logic.TimeSeriesGroupMgr.getInstance();
	}

	/**
	 * Factory method for FullDTO.
	 * @return a FullDTO instance
	 */
	@Override
	protected ir.viratech.pond_ms.api.time_series.dto.TimeSeriesGroupFullDTO createFullDTO() {
		return new ir.viratech.pond_ms.api.time_series.dto.TimeSeriesGroupFullDTO();
	}

	/**
	 * Provides the class of FieldInfoContext used for search.
	 * @return the class of FieldInfoContext 
	 */
	@Override
	protected Class<ir.viratech.pond_ms.api.time_series.dto.TimeSeriesGroupFullDTO.FieldInfoContext> getFullDtoFieldInfoContextClass() {
		return ir.viratech.pond_ms.api.time_series.dto.TimeSeriesGroupFullDTO.FieldInfoContext.class;
	}

	/**
	 * Provides the bundle prefix used in i18n.
	 * @return the bundle prefix
	 */
	@Override
	protected String getBundlePrefix() {
		return "time_series.group.";
	}
	
	/**
	 * Provides the feature entity name by which access checking is performed.
	 * @return the feature entity name
	 */
	@Override
	protected String getFeatureEntityName() {
		return "TIME_SERIES_GROUP";
	}
	
	
	/**
	 * Default constructor.
	 * Also adds the extents.
	 */
	public BaseTimeSeriesGroupResource() {
		super();
	}

}
