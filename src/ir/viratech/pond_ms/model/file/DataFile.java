package ir.viratech.pond_ms.model.file;

import ir.viratech.commons.model.UIDAndDisplayStringProvider;
import ir.viratech.pond_ms.model.file.base.BaseDataFile;

/**
 * The entity class "DataFile".
 */

public class DataFile extends BaseDataFile implements UIDAndDisplayStringProvider {
	private static final long serialVersionUID = 1L;

	@Override
	public String getDisplayString() {
		return this.getAbstractFile().getName();
	}

	
	


}