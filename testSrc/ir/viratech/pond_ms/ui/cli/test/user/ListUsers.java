package ir.viratech.pond_ms.ui.cli.test.user;

import java.util.List;

import ir.viratech.pond_ms.core.spring.ApplicationContextUtil;
import ir.viratech.pond_ms.model.user.User;
import ir.viratech.pond_ms.model.user.logic.UserMgr;

public class ListUsers {

	public static void main(String[] args) {
		ApplicationContextUtil.initializeCliApplicationContext();
		List<User> list = UserMgr.getInstance().list();
		System.out.println("total: "+list.size());
		for (User user : list) {
			System.out.println(user);
		}
	}

}
