package ir.viratech.pond_ms.ui.cli.example_data;

import java.util.Arrays;
import java.util.List;

import ir.viratech.commons.persistence.base.BaseAbstractEntityDAO;
import ir.viratech.pond_ms.core.features.EntityFeatureNames;
import ir.viratech.pond_ms.core.features.FeatureNames;
import ir.viratech.pond_ms.core.spring.ApplicationContextUtil;
import ir.viratech.pond_ms.model.organization.Organization;
import ir.viratech.pond_ms.model.organization.logic.OrganizationMgr;
import ir.viratech.pond_ms.model.user.Feature;
import ir.viratech.pond_ms.model.user.User;
import ir.viratech.pond_ms.model.user.base.BaseFeatureMgr;
import ir.viratech.pond_ms.model.user.base.BaseUserMgr;
import ir.viratech.pond_ms.model.user.logic.UserMgr;
import ir.viratech.pond_ms.model.user.role.UserRole;
import ir.viratech.pond_ms.model.user.role.base.BaseUserRoleMgr;

public class ExampleOrganizationUser {

	//TODO correct and optimize this example file

	protected void addData(Organization organization) {
		BaseAbstractEntityDAO.closeCurrentThreadSessions();
		BaseAbstractEntityDAO.touchSession();
		User user = UserMgr.getInstance().createNew();
		user.setFirstName("first");
		user.setLastName("testUser");
		user.setOrganization(organization);
		user.setEnabled(true);
		user.setPassword("123456789");
		user.setUserDefined(true);
		user.setUsername("firsttest");
		/*organization = OrganizationMgr.getInstance().reget(organization);
		Set<Position> positions  = organization.getPositions();
		if(positions.size() < 2){
			ExamplePositionAndPositionRole.main();
			positions = organization.getPositions();
		}
		Iterator<Position> it = positions.iterator();
	    Position position = it.next();
		user.addToPositions(position);*/
		UserRole userRole = BaseUserRoleMgr.getInstance().createNew();
		userRole.setName("firstTestUser");
		for (String fname : Arrays.asList(FeatureNames.SEE_HOME, FeatureNames.ACCESS_API, Feature.EntityAccessKey.getAccessKeyForView(EntityFeatureNames.USER))) {
			userRole.addToAvailableFeatures(BaseFeatureMgr.getInstance().getByName(fname));
		}
		BaseUserRoleMgr.getInstance().add(userRole);
		user.addToRoles(userRole);
		BaseUserMgr.getInstance().add(user);
		userRole.addToUsers(user);
		BaseUserRoleMgr.getInstance().update(userRole);
	}

	protected void addAnotherData(Organization organization) {
		BaseAbstractEntityDAO.closeCurrentThreadSessions();
		BaseAbstractEntityDAO.touchSession();
		User user = UserMgr.getInstance().createNew();
		user.setFirstName("second");
		user.setLastName("testUser");
		user.setOrganization(organization);
		user.setEnabled(true);
		user.setPassword("987654321");
		user.setUserDefined(true);
		user.setUsername("secondtest");
		/*organization = OrganizationMgr.getInstance().reget(organization);
		Set<Position> positions  = organization.getPositions();
		if(positions.size() < 2){
			ExamplePositionAndPositionRole.main();
			positions = organization.getPositions();
		}
		Iterator<Position> it = positions.iterator();
		Position position = it.next();
		user.addToPositions(position);*/
		UserRole userRole = BaseUserRoleMgr.getInstance().createNew();
		userRole.setName("secondTestUser");
		for (String fname : Arrays.asList(FeatureNames.SEE_HOME, FeatureNames.ACCESS_API, Feature.EntityAccessKey.getAccessKeyForView(EntityFeatureNames.USER))) {
			userRole.addToAvailableFeatures(BaseFeatureMgr.getInstance().getByName(fname));
		}
		BaseUserRoleMgr.getInstance().add(userRole);
		user.addToRoles(userRole);
		BaseUserMgr.getInstance().add(user);
		userRole.addToUsers(user);
		BaseUserRoleMgr.getInstance().update(userRole);
	}

	public static void main(String... args) {
		ApplicationContextUtil.initializeCliApplicationContext();
		List<Organization> organizations = OrganizationMgr.getInstance().list();
		if(organizations.size() < 2){
			ExampleOrganization.main(args);
			organizations = OrganizationMgr.getInstance().list();
		}
		new ExampleOrganizationUser().addData(organizations.get(0));
		new ExampleOrganizationUser().addAnotherData(organizations.get(1));
	}
}
