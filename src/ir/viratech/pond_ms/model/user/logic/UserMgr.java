package ir.viratech.pond_ms.model.user.logic;


import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.security.crypto.password.PasswordEncoder;

import ir.viratech.commons.model.EntityModificationException;
import ir.viratech.commons.model.EntityModifier;
import ir.viratech.commons.spring.tx.ReadTransactional;
import ir.viratech.commons.spring.tx.WriteTransactional;
import ir.viratech.commons.util.date.DateUtil;
import ir.viratech.pond_ms.core.spring.ApplicationContextUtil;
import ir.viratech.pond_ms.model.user.AuthUser;
import ir.viratech.pond_ms.model.user.Feature;
import ir.viratech.pond_ms.model.user.User;
import ir.viratech.pond_ms.model.user.base.BaseUserMgr;
import ir.viratech.pond_ms.model.user.dao.AuthUserDAO;
import ir.viratech.pond_ms.model.user.exception.UserNotFoundException;
import ir.viratech.pond_ms.model.user.role.UserRole;

/**
 * Mgr class for entity "ir.viratech.pond_ms.model.user.User".
 */
public class UserMgr extends BaseUserMgr {

	private static final transient Logger logger = Logger.getLogger(UserMgr.class);

	/**
	 * Gets the by username.
	 *
	 * @param username the username
	 * @return the by username
	 */
	@ReadTransactional
	public User getByUsername(String username) {
		return this.getDAO().getByAuthUserUsername(username);
	}

	/**
	 * Gets the detached user by username.
	 *
	 * @param username the username
	 * @return the detached user by username
	 * @throws UserNotFoundException the user not found exception
	 */
	@ReadTransactional
	public User getDetachedUserByUsername(String username) throws UserNotFoundException {
		User user = this.getDAO().getByAuthUserUsername(username);
		if (user == null) {
			throw new UserNotFoundException("No User found with username = " + username);
		}
		this.getDAO().evict(user);
		return user;
	}

	/**
	 * Gets the detached user by auth extuid.
	 *
	 * @param authExtuid the auth extuid
	 * @return the detached user by auth extuid
	 * @throws UserNotFoundException the user not found exception
	 */
	@ReadTransactional
	public User getDetachedUserByAuthExtuid(String authExtuid) throws UserNotFoundException {
		User user = this.getDAO().getByAuthUserExtuid(authExtuid);
		if (user == null) {
			throw new UserNotFoundException("No User found with authExtuid = " + authExtuid);
		}
		this.getDAO().evict(user);
		return user;
	}

	/**
	 * Gets user in detached mode.
	 *
	 * @param id the id
	 * @return the detached
	 */
	@ReadTransactional
	public User getDetached(long id) {
		User user = this.getDAO().get(id);
		this.getDAO().evict(user);
		return user;
	}

	/**
	 * Gets the features of a user.
	 *
	 * @param user the user
	 * @return the features
	 */
	@ReadTransactional
	public Set<Feature> getFeaturesOf(final User user) {
		return getDAO().getFeaturesOf(user);
	}

	/**
	 * Gets the attached.
	 *
	 * @param user the user
	 * @return the attached
	 */
	@ReadTransactional
	public User getAttached(User user) {
		return this.getDAO().getAttached(user);
	}

	/**
	 * Sets the role and reverse.
	 *
	 * @param user the user
	 * @param role the role
	 * @param active the active
	 */
	@WriteTransactional
	public void setRoleAndReverse(User user, UserRole role, boolean active) {
		if (active) {
			user.addToRoles_AndReverse(role);
		} else {
			user.removeFromRoles_AndReverse(role);
		}
		this.getDAO().saveOrUpdate(user);
	}

	/**
	 * Join user and role.
	 *
	 * @param user the user
	 * @param role the role
	 */
	public void joinUserAndRole(User user, UserRole role) {
		this.setRoleAndReverse(user, role, true);
	}

	/**
	 * Update password for user.
	 *
	 * @param user the user
	 * @param newPassword new Password for the user.
	 * @param serverPasswordEncoder
	 */
	@WriteTransactional
	public void updatePassword(User user, String newPassword, PasswordEncoder passwordEncoder){
		user.setPassword(passwordEncoder.encode(newPassword));
		long expirationPeriodInHours = ApplicationContextUtil.getPropertyAsLongExpression("password.expiration.period.hours");
		user.setPasswordExpirationDate(DateUtil.addHours(new Date(), expirationPeriodInHours));
		this.getDAO().update(user);
	}

	private static final boolean DEMO_DELETE = false;
	private static final long DEMO_MOD_ERROR = 0;

	@Override
	protected void checkAndDelete(User user) throws EntityModificationException {
		if (DEMO_DELETE) {
			if (user.getId()%2 == DEMO_MOD_ERROR) {
				throw new ir.viratech.commons.model.IllegalEntityModificationException("Example exception of forbidden");
			} else {
				logger.info("Assume "+user+" to be deleted.");
			}
		} else {
			this.getDAO().delete(user);
		}
	}

	@ReadTransactional
	public List<User> list(int startItemIndex, int pageSize) {
		return getDAO().findAll_paged().getItems(startItemIndex, pageSize);
	}

	@Override
	protected User createAndModify(EntityModifier<User> entityModifier) throws EntityModificationException {
		User user = this.createNew();
		AuthUser authUser = AuthUserDAO.getInstance().createNew();
		user.setAuthUser(authUser);
		entityModifier.modify(user);
		return user;
	}
}