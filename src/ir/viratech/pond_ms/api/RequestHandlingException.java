package ir.viratech.pond_ms.api;

public abstract class RequestHandlingException extends Exception{
	
	private static final long serialVersionUID = 1L;
	
	private String i18nMessageKey;
	
	public String getI18nMessageKey() {
		return i18nMessageKey;
	}

	public void setI18nMessageKey(String i18nMessageKey) {
		this.i18nMessageKey = i18nMessageKey;
	}

	public RequestHandlingException(String i18nMessageKey){
		setI18nMessageKey(i18nMessageKey);
	}
	
	public RequestHandlingException(String i18nMessageKey, String message){
		super(message);
		setI18nMessageKey(i18nMessageKey);
	}
}
