package ir.viratech.pond_ms.util.time_series.excel_importer;
import java.util.Map;

import org.apache.poi.ss.usermodel.Workbook;


import ir.viratech.pond_ms.model.time_series.RootCategory;
import ir.viratech.pond_ms.util.time_series.calender.CalendarType;
import ir.viratech.pond_ms.util.time_series.calender.JalaliCalendar;

public abstract class AbstractExcelImporter {

	protected CalendarType calendarType;
	protected Workbook workbook;
	protected Map<String,Integer> monthNumberMap;
	protected JalaliCalendar calendar;
	public abstract RootCategory importData();
	public AbstractExcelImporter(CalendarType calendarType,Workbook workbook)
	{
		this.workbook = workbook;
		this.calendarType = calendarType;
		this.calendar = new JalaliCalendar(calendarType);
	}
	public AbstractExcelImporter(CalendarType calendarType,Workbook workbook,Map<String,Integer> monthNumberMap)
	{
		this.workbook = workbook;
		this.calendarType = calendarType;
		this.monthNumberMap = monthNumberMap;
		this.calendar = new JalaliCalendar(calendarType);
	}
	
}
