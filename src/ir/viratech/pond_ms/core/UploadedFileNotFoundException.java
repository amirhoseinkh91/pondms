package ir.viratech.pond_ms.core;

public class UploadedFileNotFoundException extends Exception{
	private static final long serialVersionUID = 1L;

	public UploadedFileNotFoundException(String hash) {
		super("No uploaded file was found with hash: " + hash);
	}

}
