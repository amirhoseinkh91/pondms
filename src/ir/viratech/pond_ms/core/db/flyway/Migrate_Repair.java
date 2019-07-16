package ir.viratech.pond_ms.core.db.flyway;

import javax.sql.DataSource;

import org.flywaydb.core.Flyway;

import ir.viratech.commons.persistence.flyway.FlywayAutomaticUpdateMigratorBean;
import ir.viratech.pond_ms.core.spring.ApplicationContextUtil;

public final class Migrate_Repair {

	public static void main(String[] args) {
		FlywayAutomaticUpdateMigratorBean.disableAutomaticMigration();
		ApplicationContextUtil.initializeCliApplicationContext();
		Flyway flyway = new Flyway();
		flyway = new Flyway();
		flyway.setDataSource(ApplicationContextUtil.getApplicationContext().getBean(DataSource.class));
		flyway.setLocations("ir/viratech/pond_ms/core/db/flyway/migrations");
		flyway.setSchemas("pond_ms", "org_chart");
		flyway.setTable("pond_ms_schema_version");
		flyway.repair();
	}
}
