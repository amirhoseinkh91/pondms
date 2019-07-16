package ir.viratech.pond_ms.model.file.base;


import ir.viratech.pond_ms.model.file.DataFile;
import ir.viratech.pond_ms.model.file.dao.DataFileDAO;


/**
 *  Base Mgr class for entity "ir.viratech.pond_ms.model.file.DataFile". 
 *  It is an automatically generated file and should not be edited.
 */
public abstract class BaseDataFileMgr extends ir.viratech.base.AbstractEntityMgr<DataFile, java.lang.Long> {


	private DataFileDAO dataFileDAO = DataFileDAO.getInstance();	

	@Override
	protected DataFileDAO getDAO() {
		return this.dataFileDAO;
	}


	protected BaseDataFileMgr () {}
	



	/**
	 * Gets the Mgr instance from Spring.
	 *
	 * @return the instance of DataFileDAO
	 */
	public static ir.viratech.pond_ms.model.file.logic.DataFileMgr getInstance() {
		return ir.viratech.commons.spring.context.ApplicationContextProvider.getInitializedApplicationContext().getBean(ir.viratech.pond_ms.model.file.logic.DataFileMgr.class);
	}



	/**
	 * Unique finder method for "extuid".
	 *
	 * @param extuid the value of extuid
	 * @return the unique matching object
	 */
	@ir.viratech.commons.spring.tx.ReadTransactional
	public ir.viratech.pond_ms.model.file.DataFile getByExtuid(java.lang.String extuid) {
		return this.getDAO().getByExtuid(extuid);
	}

	/**
	 * Unique finder method for "abstractFile".
	 *
	 * @param abstractFile the value of abstractFile
	 * @return the unique matching object
	 */
	@ir.viratech.commons.spring.tx.ReadTransactional
	public ir.viratech.pond_ms.model.file.DataFile getByAbstractFile(ir.viratech.commons.file.model.AbstractFile abstractFile) {
		return this.getDAO().getByAbstractFile(abstractFile);
	}




}