package ir.viratech.pond_ms.model.user.role.dao;

import org.hibernate.criterion.Order;

import ir.viratech.pond_ms.model.user.role.NullUserRole;
import ir.viratech.pond_ms.model.user.role.base.BaseNullUserRoleDAO;

/**
 * DAO class for entity "ir.viratech.pond_ms.model.user.role.NullUserRole".
 */
public class NullUserRoleDAO extends BaseNullUserRoleDAO {



	@Override
	public void initialize(NullUserRole nullUserRole) {
		super.initialize(nullUserRole);
		nullUserRole.setUserDefined(false);
	}

	/**
	 * Find one.
	 * @return the null user role
	 */
	public NullUserRole findOne() {
		return (NullUserRole) this.createCriteria().addOrder(Order.asc(NullUserRole.PROP_ID)).setMaxResults(1).uniqueResult();
	}



}