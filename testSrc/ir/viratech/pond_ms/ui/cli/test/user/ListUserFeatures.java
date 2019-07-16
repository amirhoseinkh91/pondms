package ir.viratech.pond_ms.ui.cli.test.user;

import java.util.Set;

import ir.viratech.base.AbstractEntityDAO;
import ir.viratech.pond_ms.core.spring.ApplicationContextUtil;
import ir.viratech.pond_ms.model.user.Feature;
import ir.viratech.pond_ms.model.user.User;
import ir.viratech.pond_ms.model.user.logic.UserMgr;

/**
 * The Class ListUserFeatures.
 */
public class ListUserFeatures {


	protected static <T> void printSet(Set<T> set, String title) {
		System.out.println(title);
		for (T t : set) {
			System.out.println("\t"+t);
		}
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		ApplicationContextUtil.initializeCliApplicationContext();
		AbstractEntityDAO.touchSession();
		String username = "admin";
		User user = UserMgr.getInstance().getByUsername(username);
		if (user == null) {
			System.out.println("No user found with username '"+username+"'");
			return;
		}
		System.out.println("Found user: "+ user);
		printSet(user.getRoles(), "roles");
		Set<Feature> userFeatures = user.getFeatures();
		Set<Feature> logicalFeatures = UserMgr.getInstance().getFeaturesOf(user);
		if (userFeatures.equals(logicalFeatures)) {
			printSet(userFeatures, "User HotelFeatures = Logical HotelFeatures:");
		} else {
			printSet(userFeatures, "User HotelFeatures:");
			printSet(logicalFeatures, "Logical HotelFeatures:");
		}
	}
}
