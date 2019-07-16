package ir.viratech.pond_ms.core.db.flyway.migrations;

import ir.viratech.pond_ms.core.features.EntityFeatureNames;
import ir.viratech.pond_ms.model.user.Feature;

import java.sql.Connection;

public class V60__AddFeedBackFeature extends BaseJdbcMigration {
    @Override
    public void migrate(Connection connection) throws Exception {
        long id = this.getMaxIdByTable(connection, Feature.TABLE)+1;
        id = addEntityFeatures(connection, EntityFeatureNames.FEEDBACK, "feed_back_features", id, true);

        addFeaturesToRole(connection, Feature.EntityAccessKey.getAccessKeyForManagement(EntityFeatureNames.FEEDBACK), "admin");
        addFeaturesToRole(connection, Feature.EntityAccessKey.getAccessKeyForAdd(EntityFeatureNames.FEEDBACK), "admin");
        addFeaturesToRole(connection, Feature.EntityAccessKey.getAccessKeyForEdit(EntityFeatureNames.FEEDBACK), "admin");
        addFeaturesToRole(connection, Feature.EntityAccessKey.getAccessKeyForDelete(EntityFeatureNames.FEEDBACK), "admin");
        addFeaturesToRole(connection, Feature.EntityAccessKey.getAccessKeyForList(EntityFeatureNames.FEEDBACK), "admin");
        addFeaturesToRole(connection, Feature.EntityAccessKey.getAccessKeyForView(EntityFeatureNames.FEEDBACK), "admin");
    }
}
