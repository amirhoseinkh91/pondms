package ir.viratech.pond_ms.core.db.flyway.migrations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import ir.viratech.commons.persistence.sql.Quoter;
import ir.viratech.commons.persistence.sql.SqlUtil;
import ir.viratech.pond_ms.model.user.role.Role;

public class V45__CreateMobileAdminRole extends BaseJdbcMigration{

	@Override
	public void migrate(Connection conn) throws Exception {
		changeSysadminPassword(conn);
		deleteSysadminRoleFromSysadminUser(conn);
		long roleId = addMobileAdminRole(conn);
		addRequiredFeaturesToMobileAdmin(conn, roleId);
		assignMobileAdminRoleToSysadmin(conn, roleId);
	}

	private void deleteSysadminRoleFromSysadminUser(Connection conn) {
		String query = "delete from pond_ms.user_roles where userid=1 and roleid=2";
		this.executeQuery(conn, query);
	}

	protected void addRequiredFeaturesToMobileAdmin(Connection conn, long roleId) {
		Quoter quoter = new Quoter(false, false);
		String query = SqlUtil.insertIntoTable("pond_ms.role_features", "featureid" , "roleid")
				+ SqlUtil.values(
						quoter.tuple(1, roleId),
						quoter.tuple(2, roleId),
						quoter.tuple(7, roleId),
						quoter.tuple(8, roleId),
						quoter.tuple(10, roleId),
						quoter.tuple(11, roleId),
						quoter.tuple(14, roleId),
						quoter.tuple(15, roleId),
						quoter.tuple(17, roleId),
						quoter.tuple(18, roleId),
						quoter.tuple(20, roleId),
						quoter.tuple(25, roleId),
						quoter.tuple(26, roleId),
						quoter.tuple(27, roleId),
						quoter.tuple(43, roleId),
						quoter.tuple(46, roleId),
						quoter.tuple(49, roleId),
						quoter.tuple(52, roleId),
						quoter.tuple(55, roleId),
						quoter.tuple(58, roleId),
						quoter.tuple(61, roleId),
						quoter.tuple(64, roleId),
						quoter.tuple(67, roleId),
						quoter.tuple(70, roleId),
						quoter.tuple(73, roleId),
						quoter.tuple(76, roleId),
						quoter.tuple(79, roleId),
						quoter.tuple(82, roleId),
						quoter.tuple(85, roleId),
						quoter.tuple(88, roleId),
						quoter.tuple(91, roleId),
						quoter.tuple(94, roleId),
						quoter.tuple(97, roleId),
						quoter.tuple(100, roleId),
						quoter.tuple(103, roleId),
						quoter.tuple(106, roleId),
						quoter.tuple(109, roleId),
						quoter.tuple(112, roleId),
						quoter.tuple(115, roleId),
						quoter.tuple(118, roleId),
						quoter.tuple(121, roleId),
						quoter.tuple(124, roleId),
						quoter.tuple(127, roleId),
						quoter.tuple(130, roleId),
						quoter.tuple(133, roleId),
						quoter.tuple(136, roleId),
						quoter.tuple(139, roleId),
						quoter.tuple(142, roleId),
						quoter.tuple(145, roleId),
						quoter.tuple(148, roleId),
						quoter.tuple(151, roleId),
						quoter.tuple(154, roleId),
						quoter.tuple(157, roleId),
						quoter.tuple(160, roleId),
						quoter.tuple(163, roleId),
						quoter.tuple(166, roleId),
						quoter.tuple(169, roleId),
						quoter.tuple(172, roleId),
						quoter.tuple(175, roleId)


					);
		this.executeQuery(conn, query);
	}

	protected void assignMobileAdminRoleToSysadmin(Connection conn, long roleId) {
		Quoter quoter = new Quoter(false, false);
		String query = SqlUtil.insertIntoTable("pond_ms.user_roles" , "roleid", "userid")
				+ SqlUtil.values(
						quoter.tuple(roleId, 1)
					);
		this.executeQuery(conn, query);
	}

	protected long addMobileAdminRole(Connection conn) throws SQLException {
		Quoter quoter = new Quoter(false, true, false, true, true, true);
		long roleId = this.getMaxIdByTable(conn, Role.TABLE) + 1;
		String query = SqlUtil.insertIntoTable(Role.TABLE, Role.PROPCOLUMN_ID, "type_", Role.PROPCOLUMN_USER_DEFINED, Role.PROPCOLUMN_EXTUID, Role.PROPCOLUMN_NAME, Role.PROPCOLUMN_DESCRIPTION)
			+ SqlUtil.values(
					quoter.tuple(roleId, "UserRole", false, this.generateUid(), "mobile_admin", "Customers role")
				);
		this.executeQuery(conn, query);
		return roleId;
	}

	protected void changeSysadminPassword(Connection conn) throws SQLException {
		PasswordEncoder passwordEncoder =  new BCryptPasswordEncoder();
		String query = "update pond_ms.auth_users set password=? where username='sysadmin'";
		PreparedStatement prepareStatement = conn.prepareStatement(query);
		prepareStatement.setString(1, passwordEncoder.encode("hg20_ w- 78621 d @RT2r p$ #$# $ !DFEF S4nd jdsd"));
		prepareStatement.execute();
	}



}
