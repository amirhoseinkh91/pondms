package ir.viratech.pond_ms.api.time_series;

import ir.viratech.pond_ms.api.time_series.base.BaseTimeSeriesDateValuePairResource;
import ir.viratech.pond_ms.api.time_series.dto.TimeSeriesDateValuePairFullDTO;
import ir.viratech.pond_ms.api.time_series.dto.TimeSeriesDateValuePairLightDTO;

import javax.ws.rs.Path;

import org.springframework.stereotype.Component;

/**
 *  This is a REST Resource class for entity "TimeSeriesDateValuePair".
 *
 */
@Component
@Path(BaseTimeSeriesDateValuePairResource.RESOURCE_PATH)
public class TimeSeriesDateValuePairResource extends BaseTimeSeriesDateValuePairResource {

	public TimeSeriesDateValuePairResource () {
		super();
 		this.addFieldInfoContext("brief", TimeSeriesDateValuePairLightDTO.FieldInfoContext.class);
 		this.addFieldInfoContext("full", TimeSeriesDateValuePairFullDTO.FieldInfoContext.class);
 	}

}
