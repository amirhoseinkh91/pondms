package ir.viratech.pond_ms.core.db.flyway;

import ir.viratech.commons.cm.core.db.flyway.CmFlywayMigrator;
import ir.viratech.commons.persistence.flyway.FlywayAutomaticUpdateMigratorBean;
import ir.viratech.commons.persistence.flyway.FlywayMigrator;
import ir.viratech.pond_ms.core.spring.ApplicationContextUtil;

/**
 * The Class Migrate_ResetAndInit.
 */
public final class Migrate_ResetAndInit {

	private Migrate_ResetAndInit() {
		// private constructor added to hide implicit public one
	}

	/**
	 * Clears the database and reruns flyway migrations.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		// this line resets DB and removes DB
		// resetAndInitDb();

		System.out.println("Huh.. Huh.. Huh.. You can not resetAndInitDB...");
		System.out.println("BYE BYE......");

		System.exit(0);
	}

	public static void resetAndInitDb(){
		FlywayAutomaticUpdateMigratorBean.disableAutomaticMigration();
		ApplicationContextUtil.initializeCliApplicationContext();

		ApplicationContextUtil.getApplicationContext().getBean(CmFlywayMigrator.class).doCleanAndMigrate();
		ApplicationContextUtil.getApplicationContext().getBean(FlywayMigrator.class).doResetAndMigrate();
	}
}