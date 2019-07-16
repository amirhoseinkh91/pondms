package ir.viratech.pond_ms.core.db.flyway.migrations;

import java.sql.Connection;

import ir.viratech.pond_ms.core.features.EntityFeatureNames;
import ir.viratech.pond_ms.model.user.Feature;
import ir.viratech.pond_ms.model.user.Feature.EntityAccessKey;

public class V14__GradientFeaturesAndGrants extends BaseJdbcMigration{

	@Override
	public void migrate(Connection conn) throws Exception {

		long id = this.getMaxIdByTable(conn, Feature.TABLE)+1;
		id = addEntityFeatures(conn, EntityFeatureNames.GRADIENT, "gradient", id, true);
		id = addEntityFeatures(conn, EntityFeatureNames.GRADIENT_STOPS, "gradient_stops", id, true);

		addFeaturesToRole(conn, EntityAccessKey.getAccessKeyForManagement(EntityFeatureNames.GRADIENT), "sysadmin");
		addFeaturesToRole(conn, EntityAccessKey.getAccessKeyForAdd(EntityFeatureNames.GRADIENT), "sysadmin");
		addFeaturesToRole(conn, EntityAccessKey.getAccessKeyForEdit(EntityFeatureNames.GRADIENT), "sysadmin");
		addFeaturesToRole(conn, EntityAccessKey.getAccessKeyForDelete(EntityFeatureNames.GRADIENT), "sysadmin");
		addFeaturesToRole(conn, EntityAccessKey.getAccessKeyForList(EntityFeatureNames.GRADIENT), "sysadmin");
		addFeaturesToRole(conn, EntityAccessKey.getAccessKeyForView(EntityFeatureNames.GRADIENT), "sysadmin");

		addFeaturesToRole(conn, EntityAccessKey.getAccessKeyForManagement(EntityFeatureNames.GRADIENT_STOPS), "sysadmin");
		addFeaturesToRole(conn, EntityAccessKey.getAccessKeyForAdd(EntityFeatureNames.GRADIENT_STOPS), "sysadmin");
		addFeaturesToRole(conn, EntityAccessKey.getAccessKeyForEdit(EntityFeatureNames.GRADIENT_STOPS), "sysadmin");
		addFeaturesToRole(conn, EntityAccessKey.getAccessKeyForDelete(EntityFeatureNames.GRADIENT_STOPS), "sysadmin");
		addFeaturesToRole(conn, EntityAccessKey.getAccessKeyForList(EntityFeatureNames.GRADIENT_STOPS), "sysadmin");
		addFeaturesToRole(conn, EntityAccessKey.getAccessKeyForView(EntityFeatureNames.GRADIENT_STOPS), "sysadmin");
	}

}
