package ir.viratech.pond_ms.ui.cli.test.user;

import ir.viratech.commons.model.EntityModificationException;
import ir.viratech.commons.model.EntityModifier;
import ir.viratech.commons.model.EntityObjectNotFoundException;
import ir.viratech.pond_ms.core.spring.ApplicationContextUtil;
import ir.viratech.pond_ms.model.user.User;
import ir.viratech.pond_ms.model.user.logic.UserMgr;

public class SetUserPassword {

	public static void main(String[] args) throws EntityObjectNotFoundException, EntityModificationException {
		ApplicationContextUtil.initializeCliApplicationContext();
		String userExtuid = "0ab46a89-816e-4723-b890-0c795780be28";
		final String newPassword = "123";

		UserMgr.getInstance().update(userExtuid, new EntityModifier<User>() {
			@Override
			public void modify(User user) throws EntityModificationException {
				user.setPassword(newPassword);
			}
		});

		System.out.println("done.");
	}
}
