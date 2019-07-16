package ir.viratech.pond_ms.core.db.flyway;

import ir.viratech.commons.persistence.flyway.FlywayAutomaticUpdateMigratorBean;
import ir.viratech.commons.persistence.flyway.FlywayMigrator;
import ir.viratech.pond_ms.core.spring.ApplicationContextUtil;

/**
 * The Class Migrate_Update.
 */
public final class Migrate_Update {
	
	private Migrate_Update() {
		// private constructor added to hide implicit public one
	}

	/**
	 * Runs the flyway migrations.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		FlywayAutomaticUpdateMigratorBean.disableAutomaticMigration();
		ApplicationContextUtil.getApplicationContext().getBean(FlywayMigrator.class).doMigrate();
	}
}
