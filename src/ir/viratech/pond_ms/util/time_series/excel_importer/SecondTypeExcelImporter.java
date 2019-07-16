package ir.viratech.pond_ms.util.time_series.excel_importer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import ir.viratech.pond_ms.model.time_series.LeafCategory;
import ir.viratech.pond_ms.model.time_series.ParentCategory;
import ir.viratech.pond_ms.model.time_series.RootCategory;
import ir.viratech.pond_ms.model.time_series.TimeSeriesDateValuePair;
import ir.viratech.pond_ms.model.time_series.base.BaseLeafCategoryMgr;
import ir.viratech.pond_ms.model.time_series.base.BaseParentCategoryMgr;
import ir.viratech.pond_ms.model.time_series.base.BaseRootCategoryMgr;
import ir.viratech.pond_ms.model.time_series.base.BaseTimeSeriesDateValuePairMgr;
import ir.viratech.pond_ms.util.time_series.calender.CalendarType;

public class SecondTypeExcelImporter extends AbstractExcelImporter{

	public SecondTypeExcelImporter(CalendarType calendarType, Workbook workbook) {
		super(calendarType, workbook);
	}
	
	public SecondTypeExcelImporter(CalendarType calendarType, Workbook workbook,Map<String,Integer> monthNumberMap) {
		super(calendarType, workbook,monthNumberMap);
	}

	@Override
	public RootCategory importData() {
		
		RootCategory result = BaseRootCategoryMgr.getInstance().createNew();
		for(int i=0;i<workbook.getNumberOfSheets();i++)
		{
			ParentCategory parent = createParentFromSheet(workbook.getSheetAt(i),workbook.getSheetName(i));
			result.addToSubCategories(parent);
		}
		 
        return result;
	}

	private ParentCategory createParentFromSheet(Sheet sheet, String sheetName) {
	
		ParentCategory result = BaseParentCategoryMgr.getInstance().createNew();
		
		List<LeafCategory> cityArray = getCityArray(sheet.getRow(0).iterator(),result);

		result.setName(sheetName);
		
        Iterator<Row> rows = sheet.iterator();
        rows.next(); 							//the first row is city names
        while(rows.hasNext())
        {
        	Row currentRow = rows.next();
        	Iterator<Cell> cells = currentRow.cellIterator();
        	String year = String.valueOf((int)(cells.next().getNumericCellValue()));
        	while(cells.hasNext())
        	{
        		Cell cell = cells.next();
        		TimeSeriesDateValuePair value = BaseTimeSeriesDateValuePairMgr.getInstance().createNew();
        		value.setSubmissionTime(this.calendar.getDate(year).getTime());
        		if(Cell.CELL_TYPE_NUMERIC == cell.getCellType())
        			value.setTimeSeriValue(String.valueOf(cell.getNumericCellValue()));
        		cityArray.get(cell.getColumnIndex()-1).addToTimeSeriesValues(value);	
        	}
        }
        
        for(LeafCategory l : cityArray)
        	result.addToSubCategories(l);
        
		return result;
	}

	private List<LeafCategory> getCityArray(Iterator<Cell> cities,ParentCategory parent) {		
		List<LeafCategory> result = new ArrayList<>();
		cities.next();
		while(cities.hasNext())
		{
			LeafCategory temp = BaseLeafCategoryMgr.getInstance().createNew();
			temp.setName(cities.next().getStringCellValue());
			temp.setTimeSeriesValueType("integer");
			result.add(temp);
		}
		return result;
	}

}
