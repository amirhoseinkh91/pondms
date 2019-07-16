package ir.viratech.pond_ms.api.file.dto;

import ir.viratech.pond_ms.api.file.base.BaseDataFileFullDTO;
import ir.viratech.pond_ms.model.file.DataFile;


/**
 * A DTO for class DataFile.
 *
 */
public class DataFileFullDTO extends BaseDataFileFullDTO {
	
	/**
	 * FieldInfoContext for DataFileFullDTO
	 */
	public static class FieldInfoContext extends BaseDataFileFullDTO.BaseFieldInfoContext {
		
	}

	@Override
	protected String load_Name(DataFile dataFile) {
		return dataFile.getAbstractFile().getName();
	}

	@Override
	protected String load_Hash(DataFile dataFile) {
		return dataFile.getAbstractFile().getHashCodeString();
	}

}
