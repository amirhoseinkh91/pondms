package ir.viratech.pond_ms.ui.cli.test.user;

import ir.viratech.pond_ms.core.spring.ApplicationContextUtil;
import ir.viratech.pond_ms.model.user.User;
import ir.viratech.pond_ms.model.user.base.BaseUserMgr;
import ir.viratech.pond_ms.model.user.role.UserRole;
import ir.viratech.pond_ms.model.user.role.logic.RoleMgr;

public class AddUser {

	public static void main(String[] args) {
		ApplicationContextUtil.initializeCliApplicationContext();
		//UserRole role_admin = BaseUserRoleMgr.getInstance().getByName("admin");
		UserRole role_user = (UserRole) RoleMgr.getInstance().getByName("user");

		User user = BaseUserMgr.getInstance().createNew();
		user.setFirstName("ahmad3");
		user.setLastName("ahmadi3");
		user.setUsername("ahmadi3");
		user.setPassword("123");

		//user1.addToRoles(role_admin);
		user.addToRoles(role_user);

		System.out.println("Adding "+user);

		BaseUserMgr.getInstance().add(user);

		System.out.println("done.");
	}
}
