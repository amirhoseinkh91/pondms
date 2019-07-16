package ir.viratech.pond_ms.api.test;

import ir.viratech.pond_ms.core.spring.ApplicationContextUtil;
import ir.viratech.pond_ms.model.user.logic.UserMgr;

public class PagedListTest {
	public static void main(String[] args) {
		ApplicationContextUtil.initializeCliApplicationContext();
		System.out.println(UserMgr.getInstance().list(0 , 1));
	}
}
