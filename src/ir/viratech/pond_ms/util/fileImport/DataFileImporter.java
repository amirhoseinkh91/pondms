package ir.viratech.pond_ms.util.fileImport;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FilenameUtils;

import ir.viratech.commons.cm.core.validation.ValidationException;
import ir.viratech.commons.cm.model.entity_type.EntityTypeNotFoundException;
import ir.viratech.pond_ms.model.file.DataFile;
import ir.viratech.pond_ms.model.layer.LeafLayer;
import ir.viratech.pond_ms.util.config.ConfigUtils;
import ir.viratech.pond_ms.util.fileImport.exception.DataFileValidationException;
import ir.viratech.pond_ms.util.fileImport.exception.DataImportException;
import ir.viratech.pond_ms.util.fileImport.exception.FeatureTypeIncompatibleException;
import ir.viratech.pond_ms.util.fileImport.zipUtil.ZipFileUtil;

public abstract class DataFileImporter {

	private LeafLayer layer;
	private String unzippedPath;
	private String fileName;
	private DataFile dataFile;

	public DataFileImporter(DataFile dataFile) {
		this.dataFile = dataFile;
	}
	
	public LeafLayer getLayer() {
		return layer;
	}

	public void setLayer(LeafLayer layer) {
		this.layer = layer;
	}

	public String getUnzippedPath() {
		return unzippedPath;
	}

	public void setUnzippedPath(String unzippedPath) {
		this.unzippedPath = unzippedPath;
	}

	public String getFileName() {
		return fileName;
	}
	
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public DataFile getDataFile() {
		return dataFile;
	}
	
	public void setDataFile(DataFile dataFile) {
		this.dataFile = dataFile;
	}
	
	protected void validate() throws DataFileValidationException, IOException, FeatureTypeIncompatibleException {
		if (getDataFile() == null)
			throw new DataFileValidationException("File is null!");
		try {
			setUnzippedPath(new ZipFileUtil().unzip(getDataFile().getAbstractFile()));
		} catch (IOException e) {
			throw new DataFileValidationException("IO error!");
		}
		checkExtensions(getUnzippedPath());
	}
	
	public void checkExtensions(String path) throws DataFileValidationException {
		File directory = new File(path);
		String fileName = null;
		for (File f : directory.listFiles())
			if (FilenameUtils.getExtension(f.getName()).equals(getMainDataFileExtension())) {
				if (fileName != null)
					throw new DataFileValidationException("More than one tif file exists");
				fileName = FilenameUtils.getBaseName(f.getName());
			}
		setFileName(fileName);
		for (String ext : ConfigUtils.getValidDataFileExtensions().get(getLayer().getType())) {
			String expectedFileName = fileName + "." + ext;
			if (!(new File(directory, expectedFileName).exists()))
				throw new DataFileValidationException("File " + expectedFileName + "not found!");
		}
	}
	
	protected abstract void cleanData();

	protected abstract void importData() throws DataImportException, NullPointerException, IOException, EntityTypeNotFoundException, ValidationException;
	
	protected abstract String getMainDataFileExtension();

	
	public void resetAndImport() throws DataFileValidationException, DataImportException, IOException, FeatureTypeIncompatibleException, NullPointerException, EntityTypeNotFoundException, ValidationException {
		validate();
		cleanData();
		importData();
	}

}
