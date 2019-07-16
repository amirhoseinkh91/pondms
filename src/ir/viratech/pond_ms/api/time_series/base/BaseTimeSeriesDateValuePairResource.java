package ir.viratech.pond_ms.api.time_series.base;

import com.wordnik.swagger.annotations.Api;

import ir.viratech.pond_ms.model.time_series.TimeSeriesDateValuePair;

/**
 *  Base class for "TimeSeriesDateValuePairResource".
 *  It is an automatically generated file and should not be edited.
 */
@Api(value = BaseTimeSeriesDateValuePairResource.RESOURCE_PATH_BASE, description = BaseTimeSeriesDateValuePairResource.RESOURCE_DESCRIPTION)
public abstract class BaseTimeSeriesDateValuePairResource extends ir.viratech.pond_ms.api.AbstractMgrBasedResource<TimeSeriesDateValuePair, ir.viratech.pond_ms.api.time_series.dto.TimeSeriesDateValuePairFullDTO> {
	
	/**
	 * The resource path base used in swagger.
	 */
	public static final String RESOURCE_PATH_BASE = "/time_series_date_value_pair"+"/"+PATH_PART_ITEMS;
	
	/**
	 * The resource description used in swagger.
	 */
	public static final String RESOURCE_DESCRIPTION = "TimeSeriesDateValuePair Resource";
	
	/**
	 * The path which is handled by this resource/
	 */
	public static final String RESOURCE_PATH = "/time_series_date_value_pair"+PATH_PARAM_PART__ITEMS;
	
	/**
	 * Provides the entity manager used by the resource.
	 * @return an instance of the required entity manager
	 */
	@Override
	protected ir.viratech.commons.model.BasicEntityMgr<TimeSeriesDateValuePair> getMgr() {
		return ir.viratech.pond_ms.model.time_series.logic.TimeSeriesDateValuePairMgr.getInstance();
	}

	/**
	 * Factory method for FullDTO.
	 * @return a FullDTO instance
	 */
	@Override
	protected ir.viratech.pond_ms.api.time_series.dto.TimeSeriesDateValuePairFullDTO createFullDTO() {
		return new ir.viratech.pond_ms.api.time_series.dto.TimeSeriesDateValuePairFullDTO();
	}

	/**
	 * Provides the class of FieldInfoContext used for search.
	 * @return the class of FieldInfoContext 
	 */
	@Override
	protected Class<ir.viratech.pond_ms.api.time_series.dto.TimeSeriesDateValuePairFullDTO.FieldInfoContext> getFullDtoFieldInfoContextClass() {
		return ir.viratech.pond_ms.api.time_series.dto.TimeSeriesDateValuePairFullDTO.FieldInfoContext.class;
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
		return "TIME_SERIES_DATE_VALUE_PAIR";
	}
	
	
	/**
	 * Default constructor.
	 * Also adds the extents.
	 */
	public BaseTimeSeriesDateValuePairResource() {
		super();
	}

}
