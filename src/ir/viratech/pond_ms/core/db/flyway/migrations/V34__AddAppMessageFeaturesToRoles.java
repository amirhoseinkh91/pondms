package ir.viratech.pond_ms.core.db.flyway.migrations;

import java.sql.Connection;
import java.util.List;

import ir.viratech.base.SuppressWarningsOption;
import ir.viratech.pond_ms.core.features.EntityFeatureNames;
import ir.viratech.pond_ms.model.user.Feature;

@SuppressWarnings(SuppressWarningsOption.ALL)
public class V34__AddAppMessageFeaturesToRoles extends BaseJdbcMigration {

    @Override
    public void migrate(Connection conn) throws Exception {

        long id = getMaxIdByTable(conn, Feature.TABLE) + 1;
        addEntityFeatures(conn, EntityFeatureNames.APP_MESSAGE, "access app_message objects",id , true);

        List<String> allAccessKeyFeatures = Feature.EntityAccessKey.getAllAccessKeys(EntityFeatureNames.APP_MESSAGE);
        for (String accessKeyFeature :allAccessKeyFeatures) {
            addFeaturesToRole(conn, accessKeyFeature , "sysadmin");
            addFeaturesToRole(conn, accessKeyFeature, "admin");
            addFeaturesToRole(conn, accessKeyFeature, "MOBILE_ADMIN");
            addFeaturesToRole(conn, accessKeyFeature, "NORM_USER_ROLE");
            addFeaturesToRole(conn, accessKeyFeature, "PRO_USER_ROLE");
            addFeaturesToRole(conn, accessKeyFeature, "AGENCY_ROLE");
        }


    }
}
