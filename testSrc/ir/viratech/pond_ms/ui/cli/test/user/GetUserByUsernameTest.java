package ir.viratech.pond_ms.ui.cli.test.user;

import ir.viratech.pond_ms.core.spring.ApplicationContextUtil;
import ir.viratech.pond_ms.model.user.User;
import ir.viratech.pond_ms.model.user.exception.UserNotFoundException;
import ir.viratech.pond_ms.model.user.logic.UserMgr;

/**
 * The Class GetUserByUsernameTest.
 */
public class GetUserByUsernameTest {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws UserNotFoundException the user not found exception
	 */
	public static void main(String[] args) throws UserNotFoundException {
		ApplicationContextUtil.initializeCliApplicationContext();
		User user = UserMgr.getInstance().getDetachedUserByUsername("ahmadi");
		System.out.println(user);
	}
}
