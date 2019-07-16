package ir.viratech.pond_ms.model.customer;

public class CurrentUserIsNotCustomerException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public CurrentUserIsNotCustomerException() {
		super();
	}

	public CurrentUserIsNotCustomerException(String message, Throwable cause) {
		super(message, cause);
	}

	public CurrentUserIsNotCustomerException(String message) {
		super(message);
	}
	
	

}
