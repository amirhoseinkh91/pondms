package ir.viratech.pond_ms.core.db.flyway.migrations;


import java.sql.Connection;
import java.util.Arrays;

import ir.viratech.commons.persistence.sql.Quoter;
import ir.viratech.commons.persistence.sql.SqlUtil;
import ir.viratech.pond_ms.model.user.Feature;
import ir.viratech.pond_ms.model.user.role.Role;

/**
 * Add initial roles to database.
 * It adds some default roles which won't be shown to user and the admin role.
 * This is a Migrate class and should be executed by flyway.
 */
public class V38__InitialRoles extends BaseJdbcMigration {

	/**
	 * Add default roles to db.
	 * It add two roles which are system-defined and one which is admin and is user-defined.
	 * User-defined roles can be edited by user.
	 */
	@Override
	public void migrate(Connection conn) throws Exception {
		Quoter quoter = new Quoter(false, true, false, true, true, true);
		String query = SqlUtil.insertIntoTable(Role.TABLE, Role.PROPCOLUMN_ID, "type_", Role.PROPCOLUMN_USER_DEFINED, Role.PROPCOLUMN_EXTUID, Role.PROPCOLUMN_NAME, Role.PROPCOLUMN_DESCRIPTION)
			+ SqlUtil.values(
					quoter.tuple(1, "NullUserRole", false, this.generateUid(), "anonymous", "role of those who have not logged in"),
					quoter.tuple(2, "UserRole", false, this.generateUid(), "sysadmin", "the super-power system administrator"),
					quoter.tuple(3, "UserRole", true, this.generateUid(), "admin", "the conventional administrator")
				);
		this.executeQuery(conn, query);

		this.executeQuery(conn, SqlUtil.insertIntoTable(Role.PROPTABLE_AVAILABLE_FEATURES, "roleId", "featureId") +
				" select 2 as roleId, f.id as featureId " +
				" from "+Feature.TABLE+" as f where f.id not in (select rf.featureId from "+Role.PROPTABLE_AVAILABLE_FEATURES+" as rf where rf.roleId=2) ");

		this.executeQuery(conn, SqlUtil.insertIntoTable(Role.PROPTABLE_AVAILABLE_FEATURES, "roleId", "featureId")
				+ " values " + createSqlPairs(3, Arrays.asList(1, 2, 3, 6)));
		this.executeQuery(conn, SqlUtil.insertIntoTable(Role.PROPTABLE_AVAILABLE_FEATURES, "roleId", "featureId") +
				" select 3 as roleId, f.id as featureId " +
				" from "+Feature.TABLE+" as f where f.id not in (select rf.featureId from "+Role.PROPTABLE_AVAILABLE_FEATURES+" as rf where rf.roleId=3) and f.id>6");
	}

}