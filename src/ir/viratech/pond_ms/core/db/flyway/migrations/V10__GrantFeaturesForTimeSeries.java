package ir.viratech.pond_ms.core.db.flyway.migrations;

import java.sql.Connection;

import ir.viratech.pond_ms.core.features.EntityFeatureNames;
import ir.viratech.pond_ms.model.user.Feature.EntityAccessKey;

public class V10__GrantFeaturesForTimeSeries extends BaseJdbcMigration {

	@Override
	public void migrate(Connection conn) throws Exception {
		addFeaturesToRole(conn, EntityAccessKey.getAccessKeyForManagement(EntityFeatureNames.CATEGORY), "sysadmin");
		addFeaturesToRole(conn, EntityAccessKey.getAccessKeyForAdd(EntityFeatureNames.CATEGORY), "sysadmin");
		addFeaturesToRole(conn, EntityAccessKey.getAccessKeyForEdit(EntityFeatureNames.CATEGORY), "sysadmin");
		addFeaturesToRole(conn, EntityAccessKey.getAccessKeyForDelete(EntityFeatureNames.CATEGORY), "sysadmin");
		addFeaturesToRole(conn, EntityAccessKey.getAccessKeyForList(EntityFeatureNames.CATEGORY), "sysadmin");
		addFeaturesToRole(conn, EntityAccessKey.getAccessKeyForView(EntityFeatureNames.CATEGORY), "sysadmin");


		addFeaturesToRole(conn, EntityAccessKey.getAccessKeyForManagement(EntityFeatureNames.PARENT_CATEGORY), "sysadmin");
		addFeaturesToRole(conn, EntityAccessKey.getAccessKeyForAdd(EntityFeatureNames.PARENT_CATEGORY), "sysadmin");
		addFeaturesToRole(conn, EntityAccessKey.getAccessKeyForEdit(EntityFeatureNames.PARENT_CATEGORY), "sysadmin");
		addFeaturesToRole(conn, EntityAccessKey.getAccessKeyForDelete(EntityFeatureNames.PARENT_CATEGORY), "sysadmin");
		addFeaturesToRole(conn, EntityAccessKey.getAccessKeyForList(EntityFeatureNames.PARENT_CATEGORY), "sysadmin");
		addFeaturesToRole(conn, EntityAccessKey.getAccessKeyForView(EntityFeatureNames.PARENT_CATEGORY), "sysadmin");

		addFeaturesToRole(conn, EntityAccessKey.getAccessKeyForManagement(EntityFeatureNames.LEAF_CATEGORY), "sysadmin");
		addFeaturesToRole(conn, EntityAccessKey.getAccessKeyForAdd(EntityFeatureNames.LEAF_CATEGORY), "sysadmin");
		addFeaturesToRole(conn, EntityAccessKey.getAccessKeyForEdit(EntityFeatureNames.LEAF_CATEGORY), "sysadmin");
		addFeaturesToRole(conn, EntityAccessKey.getAccessKeyForDelete(EntityFeatureNames.LEAF_CATEGORY), "sysadmin");
		addFeaturesToRole(conn, EntityAccessKey.getAccessKeyForList(EntityFeatureNames.LEAF_CATEGORY), "sysadmin");
		addFeaturesToRole(conn, EntityAccessKey.getAccessKeyForView(EntityFeatureNames.LEAF_CATEGORY), "sysadmin");

		addFeaturesToRole(conn, EntityAccessKey.getAccessKeyForManagement(EntityFeatureNames.ROOT_CATEGORY), "sysadmin");
		addFeaturesToRole(conn, EntityAccessKey.getAccessKeyForAdd(EntityFeatureNames.ROOT_CATEGORY), "sysadmin");
		addFeaturesToRole(conn, EntityAccessKey.getAccessKeyForEdit(EntityFeatureNames.ROOT_CATEGORY), "sysadmin");
		addFeaturesToRole(conn, EntityAccessKey.getAccessKeyForDelete(EntityFeatureNames.ROOT_CATEGORY), "sysadmin");
		addFeaturesToRole(conn, EntityAccessKey.getAccessKeyForList(EntityFeatureNames.ROOT_CATEGORY), "sysadmin");
		addFeaturesToRole(conn, EntityAccessKey.getAccessKeyForView(EntityFeatureNames.ROOT_CATEGORY), "sysadmin");



		addFeaturesToRole(conn, EntityAccessKey.getAccessKeyForManagement(EntityFeatureNames.TIME_SERIES_GROUP), "sysadmin");
		addFeaturesToRole(conn, EntityAccessKey.getAccessKeyForAdd(EntityFeatureNames.TIME_SERIES_GROUP), "sysadmin");
		addFeaturesToRole(conn, EntityAccessKey.getAccessKeyForEdit(EntityFeatureNames.TIME_SERIES_GROUP), "sysadmin");
		addFeaturesToRole(conn, EntityAccessKey.getAccessKeyForDelete(EntityFeatureNames.TIME_SERIES_GROUP), "sysadmin");
		addFeaturesToRole(conn, EntityAccessKey.getAccessKeyForList(EntityFeatureNames.TIME_SERIES_GROUP), "sysadmin");
		addFeaturesToRole(conn, EntityAccessKey.getAccessKeyForView(EntityFeatureNames.TIME_SERIES_GROUP), "sysadmin");

		addFeaturesToRole(conn, EntityAccessKey.getAccessKeyForManagement(EntityFeatureNames.TIME_SERIES_DATE_VALUE_PAIR), "sysadmin");
		addFeaturesToRole(conn, EntityAccessKey.getAccessKeyForAdd(EntityFeatureNames.TIME_SERIES_DATE_VALUE_PAIR), "sysadmin");
		addFeaturesToRole(conn, EntityAccessKey.getAccessKeyForEdit(EntityFeatureNames.TIME_SERIES_DATE_VALUE_PAIR), "sysadmin");
		addFeaturesToRole(conn, EntityAccessKey.getAccessKeyForDelete(EntityFeatureNames.TIME_SERIES_DATE_VALUE_PAIR), "sysadmin");
		addFeaturesToRole(conn, EntityAccessKey.getAccessKeyForList(EntityFeatureNames.TIME_SERIES_DATE_VALUE_PAIR), "sysadmin");
		addFeaturesToRole(conn, EntityAccessKey.getAccessKeyForView(EntityFeatureNames.TIME_SERIES_DATE_VALUE_PAIR), "sysadmin");

	}

}
