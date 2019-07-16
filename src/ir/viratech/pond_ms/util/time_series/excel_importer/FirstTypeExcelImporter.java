package ir.viratech.pond_ms.util.time_series.excel_importer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import ir.viratech.pond_ms.model.time_series.LeafCategory;
import ir.viratech.pond_ms.model.time_series.RootCategory;
import ir.viratech.pond_ms.model.time_series.TimeSeriesDateValuePair;
import ir.viratech.pond_ms.model.time_series.base.BaseLeafCategoryMgr;
import ir.viratech.pond_ms.model.time_series.base.BaseRootCategoryMgr;
import ir.viratech.pond_ms.model.time_series.base.BaseTimeSeriesDateValuePairMgr;
import ir.viratech.pond_ms.util.time_series.calender.CalendarType;

public class FirstTypeExcelImporter extends AbstractExcelImporter {
	
	
	public FirstTypeExcelImporter(CalendarType calendarType, Workbook workbook) {
		super(calendarType, workbook);
	}
	
	public FirstTypeExcelImporter(CalendarType calendarType, Workbook workbook,Map<String,Integer> monthNumberMap) {
		super(calendarType, workbook,monthNumberMap);
	}

	@Override
	public RootCategory importData() {
    
		RootCategory result = BaseRootCategoryMgr.getInstance().createNew();
		for(int i=0;i<workbook.getNumberOfSheets();i++)
		{
			LeafCategory leaf = createLeafFromSheet(workbook.getSheetAt(i),workbook.getSheetName(i));
			result.addToSubCategories(leaf);
		}
		 
        return result;
	}	
	
	private LeafCategory createLeafFromSheet(Sheet sheet,String sheetName)
	{
		ArrayList<String> monthArray = getMonthArray(sheet.getRow(0).iterator());

		LeafCategory result = BaseLeafCategoryMgr.getInstance().createNew();
		result.setName(sheetName);
		result.setTimeSeriesValueType("double");
        Iterator<Row> rows = sheet.iterator();
        rows.next(); 							//the first row is month names
        while(rows.hasNext())
        {
        	Row currentRow = rows.next();
        	Iterator<Cell> cells = currentRow.cellIterator();
        	String year = String.valueOf((int)(cells.next().getNumericCellValue()));
        	while(cells.hasNext())
        	{
        		Cell cell = cells.next();
        		TimeSeriesDateValuePair value = BaseTimeSeriesDateValuePairMgr.getInstance().createNew();
        		value.setSubmissionTime(this.calendar.getDate(year, monthArray.get(cell.getColumnIndex())).getTime());
        		
        		if(Cell.CELL_TYPE_NUMERIC == cell.getCellType())
        			value.setTimeSeriValue(String.valueOf(cell.getNumericCellValue()));
        		result.addToTimeSeriesValues(value);
        	}
        }
        
		return result;
	}

	private ArrayList<String> getMonthArray(Iterator<Cell> mounths) {
		ArrayList<String> result = new ArrayList<>();
		while(mounths.hasNext())
			result.add(mounths.next().getStringCellValue());
		return result;
	}
}
