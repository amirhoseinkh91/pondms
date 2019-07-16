package ir.viratech.pond_ms.model.user.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import ir.viratech.commons.model.search.InvalidSearchQueryException;
import ir.viratech.commons.model.search.criterion.SimpleCustomRestriction;
import ir.viratech.commons.persistence.hibernate.search.AliasSystem;
import ir.viratech.pond_ms.model.user.AuthUser;
import ir.viratech.pond_ms.model.user.Feature;
import ir.viratech.pond_ms.model.user.User;
import ir.viratech.pond_ms.model.user.base.BaseUserDAO;
import ir.viratech.pond_ms.model.user.role.Role;
import ir.viratech.pond_ms.model.user.role.dao.NullUserRoleDAO;

/**
 * DAO class for entity "ir.viratech.pond_ms.model.user.User".
 */
public class UserDAO extends BaseUserDAO {

	private static final String AUTH_USER_STRING = "user_authUser";

	private Criteria createCriteriaWtihAuthUserAlias() {
		return this.createCriteria()
				.createAlias(User.PROP_AUTH_USER , AUTH_USER_STRING);
	}

	/**
	 * Gets the by auth user extuid.
	 *
	 * @param authUserExtuid the auth user extuid
	 * @return the by auth user extuid
	 */
	public User getByAuthUserExtuid(String authUserExtuid) {
		return (User)
				this.createCriteriaWtihAuthUserAlias()
				.add(Restrictions.eq(AUTH_USER_STRING + "." + AuthUser.PROP_EXTUID, authUserExtuid))
				.uniqueResult();
	}

	/**
	 * Gets the by auth user username.
	 *
	 * @param authUserUsername the auth user username
	 * @return the by auth user username
	 */
	public User getByAuthUserUsername(String authUserUsername) {
		return (User)
				this.createCriteriaWtihAuthUserAlias()
				.add(Restrictions.eq(AUTH_USER_STRING + "." + AuthUser.PROP_USERNAME, authUserUsername))
				.uniqueResult();
	}

	@Override
	protected void applyCustomSearchCriterion(SimpleCustomRestriction restriction, List<Criterion> criteria, AliasSystem aliasSystem) throws InvalidSearchQueryException {
		if ("hasRole".equals(restriction.getFieldValue("type"))) {
			String roleName = restriction.getFieldValue("roleName");
			if (StringUtils.isEmpty(roleName))
				throw new InvalidSearchQueryException("roleName is not available.");
			String prop = aliasSystem.getElement(User.PROP_ROLES+"."+Role.PROP_NAME);
			criteria.add(Restrictions.eq(prop, roleName));
			return;
		}
		throw new InvalidSearchQueryException("Unknown SearchQuery custom restriction: "+restriction);
	}


	public Set<Feature> getFeaturesOf(final User user) {
		if (user == null) {
			return NullUserRoleDAO.getInstance().findOne().getAvailableFeatures();
		}
		// user != null
		if(user.isPasswordNotExpired()) {
			return user.getFeatures();
		} else {
			Set<Feature> features = new HashSet<Feature>();
			for (String featureName : User.EXPIRED_USER_FEATURES) {
				features.add(FeatureDAO.getInstance().getByName(featureName));
			}
			return features;
		}
	}

	public boolean hasFeature(User user, Feature feature) {
		//TODO: improve the performance
		return this.getFeaturesOf(user).contains(feature);
	}

	public boolean hasFeature(User user, String featureName) {
		//TODO: improve the performance
		return this.hasFeature(user, FeatureDAO.getInstance().getExistingByName(featureName));
	}



}