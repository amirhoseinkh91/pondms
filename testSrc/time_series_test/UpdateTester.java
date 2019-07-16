package time_series_test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import ir.viratech.pond_ms.core.spring.ApplicationContextUtil;
import ir.viratech.pond_ms.model.layer.base.BasePondMgr;
import ir.viratech.pond_ms.model.time_series.RootCategory;
import ir.viratech.pond_ms.model.time_series.TimeSeriesGroup;
import ir.viratech.pond_ms.model.time_series.logic.TimeSeriesGroupMgr;
import ir.viratech.pond_ms.util.time_series.calender.CalendarType;
import ir.viratech.pond_ms.util.time_series.excel_importer.AbstractExcelImporter;
import ir.viratech.pond_ms.util.time_series.excel_importer.FirstTypeExcelImporter;
import ir.viratech.pond_ms.util.time_series.excel_importer.SecondTypeExcelImporter;

public class UpdateTester {

	public static void main(String[] args) throws IOException
	{
		ApplicationContextUtil.initializeCliApplicationContext();
		
		FileInputStream excelFile = new FileInputStream(new File("testSrc/time_series_test/test2.xlsx"));
	    Workbook workbook = new XSSFWorkbook(excelFile);
		
		AbstractExcelImporter importer = 
				new SecondTypeExcelImporter(CalendarType.SHAMSI, workbook);
		
		RootCategory newCategory = importer.importData();
		TimeSeriesGroupMgr mgr = TimeSeriesGroupMgr.getInstance();
		TimeSeriesGroup group = mgr.createNew();
		group.setName("test update pond");
		mgr.add(group);
		newCategory.setGroup(mgr.reget(group));
		newCategory.setName("test pond");
		
		String uid = BasePondMgr.getInstance().get(new Long("1")).getExtuid();
		PondUpdater.update(uid, newCategory);
		
		FileInputStream excelFile2 = new FileInputStream(new File("testSrc/time_series_test/test.xlsx"));
	    Workbook workbook2 = new XSSFWorkbook(excelFile2);
		
		AbstractExcelImporter importer2 = 
				new FirstTypeExcelImporter(CalendarType.SHAMSI, workbook2);
		
		RootCategory newCategory2 = importer2.importData();
		TimeSeriesGroupMgr mgr2 = TimeSeriesGroupMgr.getInstance();
		TimeSeriesGroup group2 = mgr2.createNew();
		group2.setName("test update pond2");
		mgr2.add(group2);
		newCategory2.setGroup(mgr2.reget(group2));
		newCategory2.setName("test pond2");
		
		PondUpdater.update(uid, newCategory2);
	}
}
