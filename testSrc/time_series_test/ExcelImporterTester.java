package time_series_test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import ir.viratech.commons.util.i18n.MessageTranslator;
import ir.viratech.pond_ms.core.i18n.MessageService;
import ir.viratech.pond_ms.core.spring.ApplicationContextUtil;
import ir.viratech.pond_ms.model.time_series.Category;
import ir.viratech.pond_ms.model.time_series.LeafCategory;
import ir.viratech.pond_ms.model.time_series.ParentCategory;
import ir.viratech.pond_ms.model.time_series.RootCategory;
import ir.viratech.pond_ms.model.time_series.TimeSeriesDateValuePair;
import ir.viratech.pond_ms.util.time_series.calender.CalendarType;
import ir.viratech.pond_ms.util.time_series.excel_importer.AbstractExcelImporter;
import ir.viratech.pond_ms.util.time_series.excel_importer.FirstTypeExcelImporter;
import ir.viratech.pond_ms.util.time_series.excel_importer.SecondTypeExcelImporter;

public class ExcelImporterTester {

	public static void main(String[] args) throws IOException
	{
		ApplicationContextUtil.initializeCliApplicationContext();
		
		String FILE_NAME = "testSrc/time_series_test/test.xlsx";

		testFirstType(FILE_NAME);
		
		System.out.println("---------------------------------");
		
		System.out.println("second type test:\n\n");
		FILE_NAME = "testSrc/time_series_test/test2.xlsx";
		testSecondType(FILE_NAME);
		
		System.out.println("\n\nfinished");
	}

	private static void testFirstType(String FILE_NAME) throws IOException {
		
		FileInputStream excelFile = new FileInputStream(new File(FILE_NAME));
        Workbook workbook = new XSSFWorkbook(excelFile);
		
		AbstractExcelImporter importer = 
				new FirstTypeExcelImporter(CalendarType.SHAMSI, workbook);
		
		RootCategory root = importer.importData();
		for(Category c : root.getSubCategories())
		{
			LeafCategory l = (LeafCategory)c;
			System.out.println(l.getName() + ":");
			for(TimeSeriesDateValuePair t : l.getTimeSeriesValues())
				System.out.println("\t" + t.getSubmissionTime() + "  " + t.getTimeSeriValue());
			System.out.println();
		}
	}

	private static void testSecondType(String FILE_NAME) throws IOException {
		
		FileInputStream excelFile = new FileInputStream(new File(FILE_NAME));
        Workbook workbook = new XSSFWorkbook(excelFile);
		
		AbstractExcelImporter importer = 
				new SecondTypeExcelImporter(CalendarType.SHAMSI, workbook);
		
		RootCategory root = importer.importData();
		for(Category c1 : root.getSubCategories())
		{
			ParentCategory p = (ParentCategory)c1;
			System.out.println(p.getName()+":");
			for(Category c2 : p.getSubCategories())
			{
				LeafCategory l = (LeafCategory)c2;
				System.out.println("\t" + l.getName() + ":");
				for(TimeSeriesDateValuePair t : l.getTimeSeriesValues())
					System.out.println("\t\t" + t.getSubmissionTime() + " " + t.getTimeSeriValue());
			}
		}
	}
}
