package ir.viratech.pond_ms.model.organization.logic;


import java.util.List;

import ir.viratech.commons.model.EntityObjectNotFoundException;
import ir.viratech.commons.model.InvalidEntityModificationException;
import ir.viratech.commons.spring.tx.ReadTransactional;
import ir.viratech.commons.spring.tx.WriteTransactional;
import ir.viratech.pond_ms.core.spring.ApplicationContextUtil;
import ir.viratech.pond_ms.model.organization.Organization;
import ir.viratech.pond_ms.model.organization.base.BaseOrganizationMgr;

/**
 * Mgr class for entity "ir.viratech.pond_ms.model.organization.Organization".
 */
public class OrganizationMgr extends BaseOrganizationMgr {


	public Organization getByCode(String code){
		return getDAO().getByCode(code);
	}

	@ReadTransactional
	public List<Organization> getRootChildren() {
		return getDAO().getRootChildren();
	}

	@WriteTransactional
	public void moveOrganization(String childExtuid, String parentExtuid) throws EntityObjectNotFoundException {
		Organization child = getDAO().getExistingByExtuid(childExtuid);
		Organization parent = getDAO().getExistingByExtuid(parentExtuid);

		//checking the parent not to be a descendant of the child.
		for (Organization temp = parent; temp != null; temp = temp.getParent())
			if (temp.equals(child))
				throw new InvalidEntityModificationException("the parent is a descendant of the child");

		parent.addToChildren_AndReverse(child);
	}


	@Override
	@ReadTransactional
	public Organization getByExtuid(String extuid) {
		if(extuid.equalsIgnoreCase("current"))
			return ApplicationContextUtil.getCurrentExecutionContext().getUser().getOrganization();
		return super.getByExtuid(extuid);
	}

}