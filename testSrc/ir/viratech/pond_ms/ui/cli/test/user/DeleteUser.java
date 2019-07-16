package ir.viratech.pond_ms.ui.cli.test.user;

import ir.viratech.commons.model.EntityModificationException;
import ir.viratech.commons.model.EntityObjectNotFoundException;
import ir.viratech.pond_ms.core.spring.ApplicationContextUtil;
import ir.viratech.pond_ms.model.user.logic.UserMgr;

public class DeleteUser {

	public static void main(String[] args) throws EntityObjectNotFoundException, EntityModificationException {
		ApplicationContextUtil.initializeCliApplicationContext();
		String userExtuid = "0ab46a89-816e-4723-b890-0c795780be28";
		UserMgr.getInstance().deleteByExtuid(userExtuid);
		System.out.println("done.");
	}
}
