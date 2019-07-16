package ir.viratech.pond_ms.ui.cli.test.user;

import ir.viratech.commons.paged_list.api.PagedList;
import ir.viratech.commons.paged_list.util.PagedListUtil;
import ir.viratech.pond_ms.core.spring.ApplicationContextUtil;
import ir.viratech.pond_ms.model.user.User;
import ir.viratech.pond_ms.model.user.base.BaseUserDAO;

/**
 * The Class TestUsersPagedList.
 */
public class TestUsersPagedList {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		ApplicationContextUtil.initializeCliApplicationContext();
		PagedList<User> pl = BaseUserDAO.getInstance().findAll_paged();
		System.out.println("size: "+ pl.getTotalSize());
		for (User user : PagedListUtil.getFullList(pl)) {
			System.out.println(user);
		}
	}
}
