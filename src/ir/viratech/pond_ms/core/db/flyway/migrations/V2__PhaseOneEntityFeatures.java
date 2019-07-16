package ir.viratech.pond_ms.core.db.flyway.migrations;

import java.sql.Connection;

import ir.viratech.pond_ms.core.features.EntityFeatureNames;
import ir.viratech.pond_ms.model.user.Feature;

public class V2__PhaseOneEntityFeatures extends BaseJdbcMigration{

	@Override
	public void migrate(Connection conn) throws Exception {
		long id = this.getMaxIdByTable(conn, Feature.TABLE)+1;
		id = addEntityFeatures(conn, EntityFeatureNames.GIS_MAP, "gis_map", id, true);
		id = addEntityFeatures(conn, EntityFeatureNames.LAYER, "layer", id, true);
		id = addEntityFeatures(conn, EntityFeatureNames.PARENT_LAYER, "parent_layer", id, false);
		id = addEntityFeatures(conn, EntityFeatureNames.LEAF_LAYER, "leaf_layer", id, false);
		id = addEntityFeatures(conn, EntityFeatureNames.VECTOR_LAYER, "vector_layer", id, false);
		id = addEntityFeatures(conn, EntityFeatureNames.RASTER_LAYER, "raster_layer", id, false);
		id = addEntityFeatures(conn, EntityFeatureNames.GIS_VECTOR_OBJECT, "gis_vector_object", id, true);
		id = addEntityFeatures(conn, EntityFeatureNames.POINT_OBJECT, "point_object", id, false);
		id = addEntityFeatures(conn, EntityFeatureNames.LINE_OBJECT, "line_object", id, false);
		id = addEntityFeatures(conn, EntityFeatureNames.POLYGON_OBJECT, "polygon_object", id, false);
		id = addEntityFeatures(conn, EntityFeatureNames.POND, "pond", id, true);


	}

}
