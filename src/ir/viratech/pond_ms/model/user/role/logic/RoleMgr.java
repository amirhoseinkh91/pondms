package ir.viratech.pond_ms.model.user.role.logic;


import ir.viratech.commons.spring.tx.WriteTransactional;
import ir.viratech.pond_ms.model.user.Feature;
import ir.viratech.pond_ms.model.user.role.UserRole;
import ir.viratech.pond_ms.model.user.role.base.BaseRoleMgr;

/**
 * Mgr class for entity "ir.viratech.pond_ms.model.user.role.Role".
 */
public class RoleMgr extends BaseRoleMgr {

	/**
	 * Join role and feature.
	 *
	 * @param role the role
	 * @param feature the feature
	 */
	@WriteTransactional
	public void joinRoleAndFeature(UserRole role, Feature feature) {
		role.addToAvailableFeatures_AndReverse(feature);
	}



}