package ir.viratech.pond_ms.model.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.security.crypto.password.PasswordEncoder;

import ir.viratech.commons.model.UIDAndDisplayStringProvider;
import ir.viratech.commons.util.relation_map.RelationMap;
import ir.viratech.commons.util.synchronized_lazy.AbstractNotNullSynchronizedLazy;
import ir.viratech.commons.util.synchronized_lazy.SynchronizedLazy;
import ir.viratech.pond_ms.core.features.FeatureNames;
import ir.viratech.pond_ms.model.organization.Organization;
import ir.viratech.pond_ms.model.organization.logic.OrganizationMgr;
import ir.viratech.pond_ms.model.user.base.BaseUser;
import ir.viratech.pond_ms.model.user.role.UserRole;
import ir.viratech.pond_ms.model.user.role.dao.UserRoleDAO;

/**
 * The entity class "User".
 */

public class User extends BaseUser implements UIDAndDisplayStringProvider {
	private static final long serialVersionUID = 1L;

	public static final String[] EXPIRED_USER_FEATURES = new String[] {FeatureNames.API_CHANGE_PASSWORD, FeatureNames.SEE_HOME, FeatureNames.ACCESS_API};

	/**
	 * Gets the last name.
	 *
	 * @return the last name
	 */
	public String getLastName() {
		if(getAuthUser() != null)
			return this.getAuthUser().getLastName();
		else
			return null;
	}

	/**
	 * Sets the last name.
	 *
	 * @param lastName the new last name
	 */
	public void setLastName(String lastName) {
		if(getAuthUser() == null)
			throw new IllegalStateException("AuthUser is null");
		this.getAuthUser().setLastName(lastName);
	}

	/**
	 * Gets the first name.
	 *
	 * @return the first name
	 */
	public String getFirstName() {
		if(getAuthUser() != null)
			return this.getAuthUser().getFirstName();
		else
			return null;
	}

	/**
	 * Sets the first name.
	 *
	 * @param firstName the new first name
	 */
	public void setFirstName(String firstName) {
		if(getAuthUser() == null)
			throw new IllegalStateException("AuthUser is null");
		this.getAuthUser().setFirstName(firstName);
	}

	public String getUsername() {
		AuthUser authUser = this.getAuthUser();
		return authUser == null ? null : authUser.getUsername();
	}
	public void setUsername(String username) {
		AuthUser authUser = this.getAuthUser();
		if (authUser == null)
			throw new IllegalStateException("AuthUser is null");
		authUser.setUsername(username);
	}
	public String getPassword() {
		AuthUser authUser = this.getAuthUser();
		return authUser == null ? null : authUser.getPassword();
	}
	public void setPassword(String password) {
		AuthUser authUser = this.getAuthUser();
		if (authUser == null)
			throw new IllegalStateException("AuthUser is null");
		authUser.setPassword(password);
	}
	public Date getPasswordExpirationDate() {
		AuthUser authUser = this.getAuthUser();
		return authUser == null ? null : authUser.getPasswordExpirationDate();
	}
	public void setPasswordExpirationDate(Date passwordExpirationDate) {
		AuthUser authUser = this.getAuthUser();
		if (authUser == null)
			throw new IllegalStateException("AuthUser is null");
		authUser.setPasswordExpirationDate(passwordExpirationDate);
	}
	/**
	 * Gets the features.
	 *
	 * @return the features
	 */
	public Set<Feature> getFeatures() {
		Set<Feature> features = new HashSet<Feature>();
		Set<UserRole> roles = this.getRoles();
		if (roles != null) {
			for (UserRole role : roles) {
				Set<Feature> availableFeatures = role.getAvailableFeatures();
				if (availableFeatures != null) {
					features.addAll(availableFeatures);
				}
			}
		}
		return features;
	}

	/**
	 * Gets the exposable features.
	 *
	 * @return the exposable features
	 */
	public Set<Feature> getExposableFeatures() {
		Set<Feature> features = new HashSet<Feature>();
		for (Feature feature : this.getFeatures()) {
			if (feature.isExposable()) {
				features.add(feature);
			}
		}
		return features;
	}

	private final transient SynchronizedLazy<RelationMap<UserRole>> syn_rolesRelationMap = new AbstractNotNullSynchronizedLazy<RelationMap<UserRole>>() {
		@Override
		public RelationMap<UserRole> create() {
			return new RelationMap<>(UserRoleDAO.getInstance().findAll(), User.this.getCreatedRoles());
		}
	};

	/**
	 * Gets the roles relation map.
	 *
	 * @return the roles relation map
	 */
	public RelationMap<UserRole> getRolesRelationMap() {
		return this.syn_rolesRelationMap.get();
	}

	public boolean isPasswordNotExpired() {
		Date passwordExpirationDate = this.getPasswordExpirationDate();
		return (passwordExpirationDate == null) ? true : passwordExpirationDate.after(new Date());
	}

	public boolean isPasswordExpired() {
		return !this.isPasswordNotExpired();
	}



	protected String toStringData() {
		return super.toStringData()
			+ ", " +
			"extuid: " + this.getExtuid()
			+ ", " +
			"username: " + this.getUsername();
	}

	/* (non-Javadoc)
	 * @see ir.viratech.commons.model.DisplayStringProvider#getDisplayString()
	 */
	@Override
	public String getDisplayString() {
		return this.getFirstName() + " " + this.getLastName() + " (" + this.getUsername() + ")";
	}

	public String getFullName() {
		return getFirstName() + " " + getLastName();
	}

	public List<Organization> getAvailableOrganizations() {
		if(getOrganization() != null) {
			List<Organization> list = new ArrayList<>();
			list.add(getOrganization());
			return list;
		} else {
			return OrganizationMgr.getInstance().list();
		}
	}

	public void setAndEncodePassword(String password, PasswordEncoder passwordEncoder) {
        this.setPassword(passwordEncoder.encode(password));
	}


}