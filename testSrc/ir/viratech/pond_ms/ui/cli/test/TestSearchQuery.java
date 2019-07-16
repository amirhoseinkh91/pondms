package ir.viratech.pond_ms.ui.cli.test;

import ir.viratech.commons.model.search.InvalidSearchQueryException;
import ir.viratech.commons.model.search.SearchQuery;
import ir.viratech.commons.model.search.criterion.RestrictionOperator;
import ir.viratech.commons.model.search.criterion.SingleFieldValueRestriction;
import ir.viratech.commons.paged_list.api.PagedList;
import ir.viratech.commons.paged_list.util.PagedListIterator;
import ir.viratech.pond_ms.core.spring.ApplicationContextUtil;
import ir.viratech.pond_ms.model.user.User;
import ir.viratech.pond_ms.model.user.logic.UserMgr;

/**
 * The Class TestSearchQuery.
 */
public class TestSearchQuery {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws InvalidSearchQueryException if searchQuery is not valid
	 */
	public static void main(String[] args) throws InvalidSearchQueryException {
		ApplicationContextUtil.initializeCliApplicationContext();
		SearchQuery searchQuery = new SearchQuery();
		searchQuery.addToCriteria(new SingleFieldValueRestriction<String>(RestrictionOperator.EQ, "authUser.username", "ahmadi"));
		PagedList<User> pl = UserMgr.getInstance().search(searchQuery);
		System.out.println("results:");
		for (User user : PagedListIterator.createIterable(pl)) {
			System.out.println(user);
		}
	}
}
