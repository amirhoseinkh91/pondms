package ir.viratech.pond_ms.core.db.flyway;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import ir.viratech.commons.cm.core.db.flyway.CmFlywayMigrator;
import ir.viratech.commons.persistence.flyway.FlywayAutomaticUpdateMigratorBean;
import ir.viratech.commons.persistence.flyway.FlywayMigrator;

public class CDMFlywayAutomaticUpdateMigratorBean {

	private static final Logger logger = Logger.getLogger(FlywayAutomaticUpdateMigratorBean.class);
	
	public static final String FLYWAY_AUTOMATIC_UPDATE = "flyway.automatic_update";


	@Value("${"+FLYWAY_AUTOMATIC_UPDATE+":true}")
	private boolean enabled;

	@Autowired
	private FlywayMigrator migrator;
	
	@Autowired
	private CmFlywayMigrator cmFlywayMigrator;

	@PostConstruct
	void run() {
		if (this.enabled){
			logger.info("updating...");
			cmFlywayMigrator.doRepair();
			cmFlywayMigrator.doMigrate();
			this.migrator.doMigrate();
			logger.info("updated.");
		} else {
			logger.info("update is not enabled.");
		}
	}

	/**
	 * Disables the automatic migration
	 *
	 * @return the ready for reset
	 */
	public static void disableAutomaticMigration() {
		System.setProperty(FLYWAY_AUTOMATIC_UPDATE, "false");
	}
	
}
