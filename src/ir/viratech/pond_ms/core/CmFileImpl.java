package ir.viratech.pond_ms.core;

import java.io.IOException;
import java.io.InputStream;
import ir.viratech.commons.cm.core.CmFileInterface;
import ir.viratech.commons.file.model.AbstractFile;

public class CmFileImpl implements CmFileInterface{
	
	
	public CmFileImpl() {
	}
	
	private AbstractFile file;
	public AbstractFile getFile() {
		return file;
	}

	public CmFileImpl(AbstractFile file) {
		this.file = file;
	}
	
	@Override
	public void setName(String arg0) {
		this.getFile().setName(arg0);
	}
	
	@Override
	public String getName() {
		return getFile().getName();
	}
	
	@Override
	public void setContentType(String arg0) {
		this.getFile().setContentType(arg0);
	}
	
	public String getContentType() {
		return getFile().getContentType();
	}
	
	@Override
	public String getDownloadLink() {
		return getFile().getFileUrl_DownloadMode();
	}
	@Override
	public byte[] getContent() {
		return this.getFile().getContent();
	}
	
	@Override
	public void setContent(byte[] arg0) {
		this.getFile().setContent(arg0);	
	}

	@Override
	public void setHashCodeString(String arg0) {
		this.getFile().setHashCodeString(arg0);		
	}
	
	@Override
	public String getHashCodeString() {
		return this.getFile().getHashCodeString();
	}
	
	@Override
	public InputStream getBinaryStream() throws IOException {
		 return this.getFile().getBinaryStream();
	}
	
	@Override
	public long getSize() {
		return this.getFile().getSize();
	}

}