package ir.viratech.pond_ms.model.user.exception;

/**
 * The Class UserNotFoundException.
 */
public class UserNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new user not found exception.
	 *
	 * @param msg the msg
	 */
	public UserNotFoundException(String msg) {
		super(msg);
	}

}
