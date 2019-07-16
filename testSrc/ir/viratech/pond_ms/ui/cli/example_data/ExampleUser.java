package ir.viratech.pond_ms.ui.cli.example_data;

import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;

import ir.viratech.pond_ms.model.user.User;
import ir.viratech.pond_ms.model.user.logic.UserMgr;
import ir.viratech.pond_ms.model.user.role.UserRole;
import ir.viratech.pond_ms.model.user.role.base.BaseUserRoleMgr;
import ir.viratech.pond_ms.model.user.role.logic.RoleMgr;

/**
 * The Class ExampleUser.
 */
public class ExampleUser extends BaseExampleFile{

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String... args) {
		new ExampleUser().execute();
	}

	@Override
	protected String getPropertyFileName() {
		return "exampleUser.properties";
	}

	@Override
	protected void addData() {

		UserRole role_admin = (UserRole) RoleMgr.getInstance().getByName("admin");
		UserRole role_user = (UserRole) RoleMgr.getInstance().getByName("user");

		User user1 = UserMgr.getInstance().createNew();
		user1.setFirstName("ahmad");
		user1.setLastName("ahmadi");
		user1.setUsername("ahmadi");
		user1.setPassword("123");
		user1.setPasswordExpirationDate(DateUtils.addDays(new Date(), 365));
		user1.addToRoles(role_admin);
		user1.addToRoles(role_user);
		UserMgr.getInstance().add(user1);

		User user2 = UserMgr.getInstance().createNew();
		user2.setFirstName(this.getProperty("firstName",1));
		user2.setLastName(this.getProperty("lastName",1));
		user2.setUsername("ahmadi2");
		user2.setPassword("123");
		user2.setPasswordExpirationDate(DateUtils.addDays(new Date(), 290));
		user2.addToRoles(role_user);
		UserMgr.getInstance().add(user2);

	}
}