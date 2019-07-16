package ir.viratech.pond_ms.ui.cli.example_data;

import ir.viratech.commons.persistence.base.BaseAbstractEntityDAO;
import ir.viratech.pond_ms.core.spring.ApplicationContextUtil;
import ir.viratech.pond_ms.model.organization.Organization;
import ir.viratech.pond_ms.model.organization.base.BaseOrganizationMgr;
import ir.viratech.pond_ms.model.user.User;
import ir.viratech.pond_ms.model.user.logic.UserMgr;

public class ExampleOrganization {



	protected void addData() {
		BaseAbstractEntityDAO.closeCurrentThreadSessions();
		BaseAbstractEntityDAO.touchSession();
		User user = UserMgr.getInstance().getByUsername("admin");
		Organization organization = BaseOrganizationMgr.getInstance().createNew();
		organization.addToUsers(user);
		organization.setName("first_organization");
		organization.setCode("123456789");
		BaseOrganizationMgr.getInstance().add(organization);
	}

	protected void addAnotherData() {
		BaseAbstractEntityDAO.closeCurrentThreadSessions();
		BaseAbstractEntityDAO.touchSession();
		User user = UserMgr.getInstance().getByUsername("admin");
		Organization organization = BaseOrganizationMgr.getInstance().createNew();
		organization.addToUsers(user);
		organization.setName("second_organization");
		organization.setCode("987654321");
		BaseOrganizationMgr.getInstance().add(organization);
	}

	public static void main(String... args) {
		ApplicationContextUtil.initializeCliApplicationContext();
		new ExampleOrganization().addData();
		new ExampleOrganization().addAnotherData();
	}
}
