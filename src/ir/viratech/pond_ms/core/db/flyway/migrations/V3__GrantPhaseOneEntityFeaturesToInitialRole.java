package ir.viratech.pond_ms.core.db.flyway.migrations;

import java.sql.Connection;

import ir.viratech.pond_ms.core.features.EntityFeatureNames;
import ir.viratech.pond_ms.model.user.Feature.EntityAccessKey;

public class V3__GrantPhaseOneEntityFeaturesToInitialRole extends BaseJdbcMigration {

	@Override
	public void migrate(Connection conn) throws Exception {


		addFeaturesToRole(conn, EntityAccessKey.getAccessKeyForManagement(EntityFeatureNames.GIS_MAP), "sysadmin");
		addFeaturesToRole(conn, EntityAccessKey.getAccessKeyForAdd(EntityFeatureNames.GIS_MAP), "sysadmin");
		addFeaturesToRole(conn, EntityAccessKey.getAccessKeyForEdit(EntityFeatureNames.GIS_MAP), "sysadmin");
		addFeaturesToRole(conn, EntityAccessKey.getAccessKeyForDelete(EntityFeatureNames.GIS_MAP), "sysadmin");
		addFeaturesToRole(conn, EntityAccessKey.getAccessKeyForList(EntityFeatureNames.GIS_MAP), "sysadmin");
		addFeaturesToRole(conn, EntityAccessKey.getAccessKeyForView(EntityFeatureNames.GIS_MAP), "sysadmin");

		addFeaturesToRole(conn, EntityAccessKey.getAccessKeyForManagement(EntityFeatureNames.LAYER), "sysadmin");
		addFeaturesToRole(conn, EntityAccessKey.getAccessKeyForAdd(EntityFeatureNames.LAYER), "sysadmin");
		addFeaturesToRole(conn, EntityAccessKey.getAccessKeyForEdit(EntityFeatureNames.LAYER), "sysadmin");
		addFeaturesToRole(conn, EntityAccessKey.getAccessKeyForDelete(EntityFeatureNames.LAYER), "sysadmin");
		addFeaturesToRole(conn, EntityAccessKey.getAccessKeyForList(EntityFeatureNames.LAYER), "sysadmin");
		addFeaturesToRole(conn, EntityAccessKey.getAccessKeyForView(EntityFeatureNames.LAYER), "sysadmin");

		addFeaturesToRole(conn, EntityAccessKey.getAccessKeyForManagement(EntityFeatureNames.PARENT_LAYER), "sysadmin");
		addFeaturesToRole(conn, EntityAccessKey.getAccessKeyForAdd(EntityFeatureNames.PARENT_LAYER), "sysadmin");
		addFeaturesToRole(conn, EntityAccessKey.getAccessKeyForEdit(EntityFeatureNames.PARENT_LAYER), "sysadmin");
		addFeaturesToRole(conn, EntityAccessKey.getAccessKeyForDelete(EntityFeatureNames.PARENT_LAYER), "sysadmin");
		addFeaturesToRole(conn, EntityAccessKey.getAccessKeyForList(EntityFeatureNames.PARENT_LAYER), "sysadmin");
		addFeaturesToRole(conn, EntityAccessKey.getAccessKeyForView(EntityFeatureNames.PARENT_LAYER), "sysadmin");


		addFeaturesToRole(conn, EntityAccessKey.getAccessKeyForManagement(EntityFeatureNames.LEAF_LAYER), "sysadmin");
		addFeaturesToRole(conn, EntityAccessKey.getAccessKeyForAdd(EntityFeatureNames.LEAF_LAYER), "sysadmin");
		addFeaturesToRole(conn, EntityAccessKey.getAccessKeyForEdit(EntityFeatureNames.LEAF_LAYER), "sysadmin");
		addFeaturesToRole(conn, EntityAccessKey.getAccessKeyForDelete(EntityFeatureNames.LEAF_LAYER), "sysadmin");
		addFeaturesToRole(conn, EntityAccessKey.getAccessKeyForList(EntityFeatureNames.LEAF_LAYER), "sysadmin");
		addFeaturesToRole(conn, EntityAccessKey.getAccessKeyForView(EntityFeatureNames.LEAF_LAYER), "sysadmin");

		addFeaturesToRole(conn, EntityAccessKey.getAccessKeyForManagement(EntityFeatureNames.VECTOR_LAYER), "sysadmin");
		addFeaturesToRole(conn, EntityAccessKey.getAccessKeyForAdd(EntityFeatureNames.VECTOR_LAYER), "sysadmin");
		addFeaturesToRole(conn, EntityAccessKey.getAccessKeyForEdit(EntityFeatureNames.VECTOR_LAYER), "sysadmin");
		addFeaturesToRole(conn, EntityAccessKey.getAccessKeyForDelete(EntityFeatureNames.VECTOR_LAYER), "sysadmin");
		addFeaturesToRole(conn, EntityAccessKey.getAccessKeyForList(EntityFeatureNames.VECTOR_LAYER), "sysadmin");
		addFeaturesToRole(conn, EntityAccessKey.getAccessKeyForView(EntityFeatureNames.VECTOR_LAYER), "sysadmin");

		addFeaturesToRole(conn, EntityAccessKey.getAccessKeyForManagement(EntityFeatureNames.RASTER_LAYER), "sysadmin");
		addFeaturesToRole(conn, EntityAccessKey.getAccessKeyForAdd(EntityFeatureNames.RASTER_LAYER), "sysadmin");
		addFeaturesToRole(conn, EntityAccessKey.getAccessKeyForEdit(EntityFeatureNames.RASTER_LAYER), "sysadmin");
		addFeaturesToRole(conn, EntityAccessKey.getAccessKeyForDelete(EntityFeatureNames.RASTER_LAYER), "sysadmin");
		addFeaturesToRole(conn, EntityAccessKey.getAccessKeyForList(EntityFeatureNames.RASTER_LAYER), "sysadmin");
		addFeaturesToRole(conn, EntityAccessKey.getAccessKeyForView(EntityFeatureNames.RASTER_LAYER), "sysadmin");

		addFeaturesToRole(conn, EntityAccessKey.getAccessKeyForManagement(EntityFeatureNames.GIS_VECTOR_OBJECT), "sysadmin");
		addFeaturesToRole(conn, EntityAccessKey.getAccessKeyForAdd(EntityFeatureNames.GIS_VECTOR_OBJECT), "sysadmin");
		addFeaturesToRole(conn, EntityAccessKey.getAccessKeyForEdit(EntityFeatureNames.GIS_VECTOR_OBJECT), "sysadmin");
		addFeaturesToRole(conn, EntityAccessKey.getAccessKeyForDelete(EntityFeatureNames.GIS_VECTOR_OBJECT), "sysadmin");
		addFeaturesToRole(conn, EntityAccessKey.getAccessKeyForList(EntityFeatureNames.GIS_VECTOR_OBJECT), "sysadmin");
		addFeaturesToRole(conn, EntityAccessKey.getAccessKeyForView(EntityFeatureNames.GIS_VECTOR_OBJECT), "sysadmin");

		addFeaturesToRole(conn, EntityAccessKey.getAccessKeyForManagement(EntityFeatureNames.POINT_OBJECT), "sysadmin");
		addFeaturesToRole(conn, EntityAccessKey.getAccessKeyForAdd(EntityFeatureNames.POINT_OBJECT), "sysadmin");
		addFeaturesToRole(conn, EntityAccessKey.getAccessKeyForEdit(EntityFeatureNames.POINT_OBJECT), "sysadmin");
		addFeaturesToRole(conn, EntityAccessKey.getAccessKeyForDelete(EntityFeatureNames.POINT_OBJECT), "sysadmin");
		addFeaturesToRole(conn, EntityAccessKey.getAccessKeyForList(EntityFeatureNames.POINT_OBJECT), "sysadmin");
		addFeaturesToRole(conn, EntityAccessKey.getAccessKeyForView(EntityFeatureNames.POINT_OBJECT), "sysadmin");

		addFeaturesToRole(conn, EntityAccessKey.getAccessKeyForManagement(EntityFeatureNames.LINE_OBJECT), "sysadmin");
		addFeaturesToRole(conn, EntityAccessKey.getAccessKeyForAdd(EntityFeatureNames.LINE_OBJECT), "sysadmin");
		addFeaturesToRole(conn, EntityAccessKey.getAccessKeyForEdit(EntityFeatureNames.LINE_OBJECT), "sysadmin");
		addFeaturesToRole(conn, EntityAccessKey.getAccessKeyForDelete(EntityFeatureNames.LINE_OBJECT), "sysadmin");
		addFeaturesToRole(conn, EntityAccessKey.getAccessKeyForList(EntityFeatureNames.LINE_OBJECT), "sysadmin");
		addFeaturesToRole(conn, EntityAccessKey.getAccessKeyForView(EntityFeatureNames.LINE_OBJECT), "sysadmin");

		addFeaturesToRole(conn, EntityAccessKey.getAccessKeyForManagement(EntityFeatureNames.POLYGON_OBJECT), "sysadmin");
		addFeaturesToRole(conn, EntityAccessKey.getAccessKeyForAdd(EntityFeatureNames.POLYGON_OBJECT), "sysadmin");
		addFeaturesToRole(conn, EntityAccessKey.getAccessKeyForEdit(EntityFeatureNames.POLYGON_OBJECT), "sysadmin");
		addFeaturesToRole(conn, EntityAccessKey.getAccessKeyForDelete(EntityFeatureNames.POLYGON_OBJECT), "sysadmin");
		addFeaturesToRole(conn, EntityAccessKey.getAccessKeyForList(EntityFeatureNames.POLYGON_OBJECT), "sysadmin");
		addFeaturesToRole(conn, EntityAccessKey.getAccessKeyForView(EntityFeatureNames.POLYGON_OBJECT), "sysadmin");

		addFeaturesToRole(conn, EntityAccessKey.getAccessKeyForManagement(EntityFeatureNames.POND), "sysadmin");
		addFeaturesToRole(conn, EntityAccessKey.getAccessKeyForAdd(EntityFeatureNames.POND), "sysadmin");
		addFeaturesToRole(conn, EntityAccessKey.getAccessKeyForEdit(EntityFeatureNames.POND), "sysadmin");
		addFeaturesToRole(conn, EntityAccessKey.getAccessKeyForDelete(EntityFeatureNames.POND), "sysadmin");
		addFeaturesToRole(conn, EntityAccessKey.getAccessKeyForList(EntityFeatureNames.POND), "sysadmin");
		addFeaturesToRole(conn, EntityAccessKey.getAccessKeyForView(EntityFeatureNames.POND), "sysadmin");

	}

}
