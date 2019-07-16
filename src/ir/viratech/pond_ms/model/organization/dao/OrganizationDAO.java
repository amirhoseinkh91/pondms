package ir.viratech.pond_ms.model.organization.dao;

import java.util.List;

import org.hibernate.criterion.Restrictions;

import ir.viratech.pond_ms.model.organization.Organization;
import ir.viratech.pond_ms.model.organization.base.BaseOrganizationDAO;

/**
 * DAO class for entity "ir.viratech.pond_ms.model.organization.Organization".
 */
public class OrganizationDAO extends BaseOrganizationDAO {



	public Organization getByCode(String code) {
		return (Organization) createCriteria().add(Restrictions.eq(Organization.PROP_CODE, code)).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<Organization> getRootChildren() {
		return createCriteria()
				.add(Restrictions.isNull("parent"))
				.list();
	}


}