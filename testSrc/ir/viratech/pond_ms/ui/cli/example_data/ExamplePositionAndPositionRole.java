package ir.viratech.pond_ms.ui.cli.example_data;

public class ExamplePositionAndPositionRole {

	//We remove position, So this test not needed any more

	/*protected void addData(Organization organization) {
		BaseAbstractEntityDAO.closeCurrentThreadSessions();
		BaseAbstractEntityDAO.touchSession();
		User user = UserMgr.getInstance().getByUsername("admin");
		Set<Feature> features = new HashSet<>(FeatureMgr.getInstance().list());

		Position position = PositionMgr.getInstance().createNew();
		position.setOrganization(organization);
		position.setName("modir_amel_organ 1");
		position.setCurrentUser(user);
		position.setSystemDefined(false);
		PositionRole positionRole = PositionRoleMgr.getInstance().createNew();
		positionRole.addToPositions(position);
		positionRole.setName("modir_amel_1");
		positionRole.setUserDefined(true);
		positionRole.setAvailableFeatures(features);
		BasePositionMgr.getInstance().add(position);
		BasePositionRoleMgr.getInstance().add(positionRole);
		position.addToRoles(positionRole);
		BasePositionMgr.getInstance().update(position);

		Position position2 = PositionMgr.getInstance().createNew();
		position2.setOrganization(organization);
		position2.setName("nayeb_reis_organ_1");
		position2.setCurrentUser(user);
		position2.setSystemDefined(false);
		PositionRole positionRole2 = PositionRoleMgr.getInstance().createNew();
		positionRole2.addToPositions(position2);
		positionRole2.setName("nayeb_reis_1");
		positionRole2.setUserDefined(true);
		positionRole2.setAvailableFeatures(features);
		BasePositionMgr.getInstance().add(position2);
		BasePositionRoleMgr.getInstance().add(positionRole2);
		position2.addToRoles(positionRole2);
		BasePositionMgr.getInstance().update(position2);
	}

	protected void addAnotherData(Organization organization) {
		BaseAbstractEntityDAO.closeCurrentThreadSessions();
		BaseAbstractEntityDAO.touchSession();
		User user = UserMgr.getInstance().getByUsername("admin");
		Set<Feature> features = new HashSet<>(FeatureMgr.getInstance().list());

		Position position = PositionMgr.getInstance().createNew();
		position.setOrganization(organization);
		position.setName("modir_amel_organ_2");
		position.setCurrentUser(user);
		position.setSystemDefined(false);
		PositionRole positionRole = PositionRoleMgr.getInstance().createNew();
		positionRole.addToPositions(position);
		positionRole.setName("modir_amel_2");
		positionRole.setUserDefined(true);
		positionRole.setAvailableFeatures(features);
		BasePositionMgr.getInstance().add(position);
		BasePositionRoleMgr.getInstance().add(positionRole);
		position.addToRoles(positionRole);
		BasePositionMgr.getInstance().update(position);

		Position position2 = PositionMgr.getInstance().createNew();
		position2.setOrganization(organization);
		position2.setName("nayeb_reis_organ_2");
		position2.setCurrentUser(user);
		position2.setSystemDefined(false);
		PositionRole positionRole2 = PositionRoleMgr.getInstance().createNew();
		positionRole2.addToPositions(position2);
		positionRole2.setName("nayeb_reis_2");
		positionRole2.setUserDefined(true);
		positionRole2.setAvailableFeatures(features);
		BasePositionMgr.getInstance().add(position2);
		BasePositionRoleMgr.getInstance().add(positionRole2);
		position2.addToRoles(positionRole2);
		BasePositionMgr.getInstance().update(position2);
	}

	public static void main(String... args) {
		ApplicationContextUtil.initializeCliApplicationContext();
		List<Organization> organizations = OrganizationMgr.getInstance().list();
		if(organizations.size() < 2){
			ExampleOrganization.main(args);
			organizations = OrganizationMgr.getInstance().list();
		}
		new ExamplePositionAndPositionRole().addData(organizations.get(0));
		new ExamplePositionAndPositionRole().addAnotherData(organizations.get(1));
	}*/
}
