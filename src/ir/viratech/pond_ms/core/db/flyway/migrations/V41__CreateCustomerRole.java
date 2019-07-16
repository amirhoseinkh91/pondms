package ir.viratech.pond_ms.core.db.flyway.migrations;

import java.sql.Connection;

import ir.viratech.pond_ms.core.features.FeatureNames;
import ir.viratech.pond_ms.model.user.role.Role;

public class V41__CreateCustomerRole extends BaseJdbcMigration{

    public static final String CUSTOMER_ROLE_NAME = "customer";
    public static final String AGENT_ROLE_NAME = "agent";

    @Override
	public void migrate(Connection conn) throws Exception {
        long roleMaxId = this.getMaxIdByTable(conn, Role.TABLE);

        this.addRole(conn, roleMaxId + 1 , CUSTOMER_ROLE_NAME, "UserRole", "All customer should have this role");
        this.addFeaturesToRole(conn, FeatureNames.ACCESS_API, CUSTOMER_ROLE_NAME);
        this.addFeaturesToRole(conn, FeatureNames.SEE_HOME, CUSTOMER_ROLE_NAME);

	}

}
