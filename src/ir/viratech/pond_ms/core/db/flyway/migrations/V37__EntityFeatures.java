package ir.viratech.pond_ms.core.db.flyway.migrations;



import java.sql.Connection;

import ir.viratech.pond_ms.core.features.EntityFeatureNames;
import ir.viratech.pond_ms.model.user.Feature;

/**
 * This class adds features related to user management to db.
 * This is a Migrate class and should be executed by flyway.
 */
public class V37__EntityFeatures extends BaseJdbcMigration {

	/**
	 * Adds features for CRUD of User to db.
	 * This method finds maximum id in FEATURES table to avoid duplicated ids.
	 */
	@Override
	public void migrate(Connection conn) throws Exception {
		long id = this.getMaxIdByTable(conn, Feature.TABLE)+1;
		id = addEntityFeatures(conn, EntityFeatureNames.USER, "feature_user.description", id,true);
		id = addEntityFeatures(conn, EntityFeatureNames.ROLE, "feature_role.description", id,true);
		id = addEntityFeatures(conn, EntityFeatureNames.GIS_MAP, "gis_map", id, true);
		id = addEntityFeatures(conn, EntityFeatureNames.LAYER, "layer", id, true);
		id = addEntityFeatures(conn, EntityFeatureNames.LEAF_LAYER, "leaf_layer", id, true);
		id = addEntityFeatures(conn, EntityFeatureNames.PARENT_LAYER, "parent_layer", id, true);
		id = addEntityFeatures(conn, EntityFeatureNames.VECTOR_LAYER, "vector_layer", id, true);
		id = addEntityFeatures(conn, EntityFeatureNames.RASTER_LAYER, "raster_layer", id, true);
		id = addEntityFeatures(conn, EntityFeatureNames.GIS_VECTOR_OBJECT, "gis_vector_object", id, true);
		id = addEntityFeatures(conn, EntityFeatureNames.POINT_OBJECT, "point_object", id, true);
		id = addEntityFeatures(conn, EntityFeatureNames.LINE_OBJECT, "line_object", id, true);
		id = addEntityFeatures(conn, EntityFeatureNames.POLYGON_OBJECT, "polygon_object", id, true);
		id = addEntityFeatures(conn, EntityFeatureNames.POND, "pond", id, true);
		id = addEntityFeatures(conn, EntityFeatureNames.CATEGORY, "category", id, true);
		id = addEntityFeatures(conn, EntityFeatureNames.LEAF_CATEGORY, "leaf_category", id, true);
		id = addEntityFeatures(conn, EntityFeatureNames.PARENT_CATEGORY, "parent_category", id, true);
		id = addEntityFeatures(conn, EntityFeatureNames.ROOT_CATEGORY, "root_category", id, true);
		id = addEntityFeatures(conn, EntityFeatureNames.TIME_SERIES_DATE_VALUE_PAIR, "time_series_date_value_pair", id, true);
		id = addEntityFeatures(conn, EntityFeatureNames.TIME_SERIES_GROUP, "time_series_Group", id, true);
		id = addEntityFeatures(conn, EntityFeatureNames.GRADIENT, "gradient", id, true);
		id = addEntityFeatures(conn, EntityFeatureNames.GRADIENT_STOPS, "gradient_stops", id, true);
		id = addEntityFeatures(conn, EntityFeatureNames.REVIEW, "review", id, true);
		id = addEntityFeatures(conn, EntityFeatureNames.APP_MESSAGE, "app_message", id, true);
		id = addEntityFeatures(conn, EntityFeatureNames.TOUR, "tour", id, true);
	}

}