package ir.viratech.pond_ms.api.time_series;

import ir.viratech.pond_ms.api.time_series.base.BaseTimeSeriesGroupResource;
import ir.viratech.pond_ms.api.time_series.dto.TimeSeriesGroupFullDTO;
import ir.viratech.pond_ms.api.time_series.dto.TimeSeriesGroupLightDTO;

import javax.ws.rs.Path;

import org.springframework.stereotype.Component;

/**
 *  This is a REST Resource class for entity "TimeSeriesGroup".
 *
 */
@Component
@Path(BaseTimeSeriesGroupResource.RESOURCE_PATH)
public class TimeSeriesGroupResource extends BaseTimeSeriesGroupResource {
	public TimeSeriesGroupResource () {
		super();
 		this.addFieldInfoContext("brief", TimeSeriesGroupLightDTO.FieldInfoContext.class);
 		this.addFieldInfoContext("full", TimeSeriesGroupFullDTO.FieldInfoContext.class);
 	}

}
