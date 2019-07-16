package ir.viratech.pond_ms.model.time_series;

import ir.viratech.commons.model.UIDAndDisplayStringProvider;
import ir.viratech.pond_ms.model.time_series.base.BaseTimeSeriesGroup;

/**
 * The entity class "TimeSeriesGroup".
 */

public class TimeSeriesGroup extends BaseTimeSeriesGroup implements UIDAndDisplayStringProvider{
	private static final long serialVersionUID = 1L;

	@Override
	public String getDisplayString() {
		
		return this.getName();
	}

	
	


}