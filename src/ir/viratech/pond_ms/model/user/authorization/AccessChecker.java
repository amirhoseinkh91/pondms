package ir.viratech.pond_ms.model.user.authorization;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import ir.viratech.commons.api.ResponseException;
import ir.viratech.pond_ms.api.auth.MyUserDetailsService;
import ir.viratech.pond_ms.model.organization.Organization;
import ir.viratech.pond_ms.model.user.Feature;
import ir.viratech.pond_ms.model.user.User;
import ir.viratech.pond_ms.model.user.logic.UserMgr;

/**
 * The Class AccessChecker.
 */
public final class AccessChecker {

	private static Map<Long, Set<String>> userFeaturesMap = new HashMap<Long, Set<String>>();
	private static UserMgr userMgr = UserMgr.getInstance();


	private AccessChecker() {
		// private constructor added to hide implicit public one
	}

	/**
	 * Clean features of.
	 *
	 * @param user the user
	 */
	public static void cleanFeaturesOf(User user) {
		userFeaturesMap.remove(getId(user));
	}

	private static Long getId(User user) {
		return (user==null) ? null : user.getId();
	}

	private static void reloadFeaturesOf(User user) {
		user = userMgr.reget(user);
		Set<String> featureNames = new HashSet<String>();
		for (Feature feature : userMgr.getFeaturesOf(user)) {
			featureNames.add(feature.getName());
		}
		userFeaturesMap.put(getId(user), featureNames);
	}

	private static Set<String> getAvailableFeatureNames(User user) {
		Long id = getId(user);
		reloadFeaturesOf(user);//TODO @Kian: Use the observer pattern to clean the features.
		Set<String> set = userFeaturesMap.get(id);
		if (set == null) {
			reloadFeaturesOf(user);
			set = userFeaturesMap.get(id);
		}
		return set;
	}

	/**
	 * Checks for access to any.
	 *
	 * @param user the user
	 * @param featureNames the feature names
	 * @return true, if successful
	 */
	public static boolean hasAccessToAny(User user, String featureNames) {
		Set<String> availableFeatureNames = getAvailableFeatureNames(user);
		for (String t : featureNames.split(",", -1)) {
			String fName= t.trim();
			if (!fName.isEmpty() && availableFeatureNames.contains(fName)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Checks for access to any.
	 *
	 * @param featureNames the feature names
	 * @return true, if successful
	 */
	public static boolean hasAccessToAny(String featureNames) {
		return hasAccessToAny(MyUserDetailsService.getCurrentUser(), featureNames);
	}

	/**
	 * Invalidate.
	 */
	public static void invalidate(){
		userFeaturesMap.clear();
	}

	public static void checkAccess(String featureName) {
		if (!hasAccessToAny(featureName))
			throw ResponseException.createWithStatus_Forbidden("Forbidden access to feature '"+featureName+"'");
	}

	public static boolean hasAccessToOrganization(User user, Organization org){
		Organization user_org = user.getOrganization();
		if (user_org != null && user_org != org) {
			return false;
		}
		return true;
	}
}
