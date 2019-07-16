package ir.viratech.pond_ms.core.db.flyway.migrations;

import java.sql.Connection;

import ir.viratech.pond_ms.core.features.EntityFeatureNames;
import ir.viratech.pond_ms.model.user.Feature;

public class V9__EntityFeaturesForTimeSeries extends BaseJdbcMigration {

	@Override
	public void migrate(Connection conn) throws Exception {
		long id = this.getMaxIdByTable(conn, Feature.TABLE)+1;
		id = addEntityFeatures(conn, EntityFeatureNames.CATEGORY, "category", id, true);
		id = addEntityFeatures(conn, EntityFeatureNames.PARENT_CATEGORY, "parent_category", id, true);
		id = addEntityFeatures(conn, EntityFeatureNames.LEAF_CATEGORY, "leaf_category", id, true);
		id = addEntityFeatures(conn, EntityFeatureNames.ROOT_CATEGORY, "root_category", id, true);
		id = addEntityFeatures(conn, EntityFeatureNames.TIME_SERIES_GROUP, "time_series_group", id, true);
		id = addEntityFeatures(conn, EntityFeatureNames.TIME_SERIES_DATE_VALUE_PAIR, "time_series_date_value_pair", id, true);

	}
}
