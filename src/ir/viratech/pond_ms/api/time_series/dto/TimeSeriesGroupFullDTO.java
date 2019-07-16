package ir.viratech.pond_ms.api.time_series.dto;

import ir.viratech.commons.util.i18n.MessageTranslator;
import ir.viratech.pond_ms.api.time_series.base.BaseTimeSeriesGroupFullDTO;
import ir.viratech.pond_ms.core.i18n.MessageService;
import ir.viratech.pond_ms.model.time_series.TimeSeriesGroup;


/**
 * A DTO for class TimeSeriesGroup.
 *
 */
public class TimeSeriesGroupFullDTO extends BaseTimeSeriesGroupFullDTO {
	
	/**
	 * FieldInfoContext for TimeSeriesGroupFullDTO
	 */
	public static class FieldInfoContext extends BaseTimeSeriesGroupFullDTO.BaseFieldInfoContext {
		
	}

	@Override
	protected String load_Name(TimeSeriesGroup timeSeriesGroup) {
		MessageTranslator translator = MessageService.getMessageTranslator();
		
		return translator.getMessage("time_series.group." + timeSeriesGroup.getName(), timeSeriesGroup.getName());
	}
	
}
