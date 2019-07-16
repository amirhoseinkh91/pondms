package ir.viratech.pond_ms.ui.cli.test.user;

import ir.viratech.pond_ms.core.spring.ApplicationContextUtil;
import ir.viratech.pond_ms.model.user.User;
import ir.viratech.pond_ms.model.user.base.BaseUserMgr;
import ir.viratech.pond_ms.model.user.exception.UserNotFoundException;

/**
 * The Class GetUserByAuthExtuidTest.
 */
public class GetUserByAuthExtuidTest {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws UserNotFoundException the user not found exception
	 */
	public static void main(String[] args) throws UserNotFoundException {
		ApplicationContextUtil.initializeCliApplicationContext();
		User user = BaseUserMgr.getInstance().getDetachedUserByAuthExtuid("authUser_extuid");
		System.out.println(user);
	}
}
