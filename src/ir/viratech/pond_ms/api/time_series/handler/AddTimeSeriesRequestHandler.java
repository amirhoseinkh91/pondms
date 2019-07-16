package ir.viratech.pond_ms.api.time_series.handler;

import java.io.IOException;
import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import ir.viratech.commons.file.model.AbstractFile;
import ir.viratech.commons.file.model.logic.AbstractFileMgr;
import ir.viratech.pond_ms.api.BaseServiceHandler;
import ir.viratech.pond_ms.api.RequestHandlingException;
import ir.viratech.pond_ms.api.time_series.dto.AddTimeSeriesRequestDTO;
import ir.viratech.pond_ms.model.file.DataFile;
import ir.viratech.pond_ms.model.file.logic.DataFileMgr;
import ir.viratech.pond_ms.model.layer.Pond;
import ir.viratech.pond_ms.model.layer.logic.PondMgr;
import ir.viratech.pond_ms.model.map_object.vector.GISVectorObject;
import ir.viratech.pond_ms.model.map_object.vector.logic.GISVectorObjectMgr;
import ir.viratech.pond_ms.model.time_series.RootCategory;
import ir.viratech.pond_ms.model.time_series.TimeSeriesGroup;
import ir.viratech.pond_ms.model.time_series.logic.TimeSeriesDateValuePairMgr;
import ir.viratech.pond_ms.model.time_series.logic.TimeSeriesGroupMgr;
import ir.viratech.pond_ms.util.time_series.calender.CalendarType;
import ir.viratech.pond_ms.util.time_series.excel_importer.AbstractExcelImporter;
import ir.viratech.pond_ms.util.time_series.excel_importer.FirstTypeExcelImporter;
import ir.viratech.pond_ms.util.time_series.excel_importer.SecondTypeExcelImporter;

public class AddTimeSeriesRequestHandler extends BaseServiceHandler{

	private AddTimeSeriesRequestDTO dto;
	
	
	public AddTimeSeriesRequestHandler(AddTimeSeriesRequestDTO dto) {
		this.dto = dto;
	}

	@Override
	public Response handle() throws RequestHandlingException {
		
		AbstractFile file = AbstractFileMgr.getInstance().getByHashCodeString(dto.getFileHash());
		RootCategory root = null;
		try {
			InputStream excelFile = file.getBinaryStream();
			Workbook workbook = new XSSFWorkbook(excelFile);
			AbstractExcelImporter importer = null;
			switch (dto.getFileFormat()) {
			case "first":
				importer = new FirstTypeExcelImporter(CalendarType.SHAMSI, workbook);
				break;
			case "second":
				importer = new FirstTypeExcelImporter(CalendarType.MILADI, workbook);
				break;
			case "third":
				importer = new SecondTypeExcelImporter(CalendarType.SHAMSI, workbook);
			default:
				break;
			}
			root = importer.importData();	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//TODO check organization access
		
		DataFile dataFile = DataFileMgr.getInstance().createNew();
		dataFile.setAbstractFile(file);
		dataFile.setDataCollectionDate(this.dto.getCollectionDate());
		dataFile.setDataReference(this.dto.getReference());
		root.setDataFile(dataFile);
		
		TimeSeriesGroup group = TimeSeriesGroupMgr.getInstance().getByExtuid(dto.getTimeSeriesGroupUid());
		
		root.setName(group.getName());
		root.setGroup(group);
		
		if(dto.getPondUid() != null)
		{
			Pond pond = PondMgr.getInstance().getByExtuid(dto.getPondUid());
			
			if(pond == null)
				return Response.status(Status.NO_CONTENT).build();
			
			root.setPond(pond);
			TimeSeriesDateValuePairMgr.getInstance().addTimeSeriesToPond(root);
		}
		else if(dto.getGISVectorObjectUid() != null)
		{
			GISVectorObject gisVectorObject = GISVectorObjectMgr.getInstance().getByExtuid(dto.getGISVectorObjectUid());
			
			if(gisVectorObject == null)
				return Response.status(Status.NO_CONTENT).build();
			
			root.setGISVectorObject(gisVectorObject);
			TimeSeriesDateValuePairMgr.getInstance().addTimeSeriesToGISVectorObject(root);
		}
		else
			return Response.status(Status.BAD_REQUEST).build();
		
		return Response.ok().build();
	}

}
