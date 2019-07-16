package ir.viratech.pond_ms.core.db.flyway.migrations;


import java.sql.Connection;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import ir.viratech.commons.persistence.sql.Quoter;
import ir.viratech.commons.persistence.sql.SqlUtil;
import ir.viratech.pond_ms.model.user.AuthUser;
import ir.viratech.pond_ms.model.user.User;

/**
 * Add default users to database.
 * It add one user which used by developers and should have all features.
 * Also it add another user which is admin and it will be given to the real admin.
 * This is a Migrate class and should be executed by flyway.
 */
public class V39__InitialUsers extends BaseJdbcMigration {

	/**
	 * add default users to database.
	 */
	@Override
	public void migrate(Connection conn) throws Exception {
		PasswordEncoder passwordEncoder =  new BCryptPasswordEncoder();

		// Create Auth-user for the two user.
		Quoter quoter = new Quoter(false, true, true, true, false, false);
		this.executeQuery(conn, SqlUtil.insertIntoTable(AuthUser.TABLE, AuthUser.PROPCOLUMN_ID, AuthUser.PROPCOLUMN_EXTUID, AuthUser.PROPCOLUMN_USERNAME,
								AuthUser.PROPCOLUMN_PASSWORD, AuthUser.PROPCOLUMN_ENABLED, AuthUser.PROPCOLUMN_LAST_CONSECUTIVE_LOGIN_FAILURES_COUNT)
				+ SqlUtil.values(
						quoter.tuple(1, this.generateUid(), "sysadmin",passwordEncoder.encode("sysadmin"), true, 0),
						quoter.tuple(2, this.generateUid(), "admin", passwordEncoder.encode("admin"), true, 0)
						)
			);

		//add users and associate them with created auth-users
		quoter = new Quoter(false, true, false, false, false,true,false,false,false,false,false,false,false,false);
		this.executeQuery(conn, SqlUtil.insertIntoTable(User.TABLE, User.PROPCOLUMN_ID, User.PROPCOLUMN_EXTUID, User.PROPCOLUMN_AUTH_USER, User.PROPCOLUMN_ENABLED, User.PROPCOLUMN_USER_DEFINED)
				+ SqlUtil.values(
						quoter.tuple(1, this.generateUid(), 1, true, false),
						quoter.tuple(2, this.generateUid(), 2, true, false)
					)
			);

		//Add default roles to created users
		this.executeQuery(conn, SqlUtil.insertIntoTable(User.PROPTABLE_ROLES, "userId", "roleId")
				+SqlUtil.values(
						createSqlPair(1, 2),
						createSqlPair(2, 3)
					)
			);
	}

}