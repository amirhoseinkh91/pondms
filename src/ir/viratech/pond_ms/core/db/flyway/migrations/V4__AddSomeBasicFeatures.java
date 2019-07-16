package ir.viratech.pond_ms.core.db.flyway.migrations;

import java.sql.Connection;

import ir.viratech.pond_ms.core.features.FeatureNames;
import ir.viratech.pond_ms.core.i18n.MessageService;

public class V4__AddSomeBasicFeatures extends BaseJdbcMigration {

	@Override
	public void migrate(Connection conn) throws Exception {		
		
		addFeaturesToRole(conn, FeatureNames.SEE_UNSPECIFIED, "sysadmin");
		addFeaturesToRole(conn, FeatureNames.SEE_HOME, "sysadmin");
		addFeaturesToRole(conn, FeatureNames.ACCESS_API, "sysadmin");
		addFeaturesToRole(conn, FeatureNames.API_UNSPECIFIED, "sysadmin");
		addFeaturesToRole(conn, FeatureNames.API_SYS_ADMIN, "sysadmin");
		addFeaturesToRole(conn, FeatureNames.API_CHANGE_PASSWORD, "sysadmin");

		addFeaturesToRole(conn, FeatureNames.SEE_UNSPECIFIED, "admin");
		addFeaturesToRole(conn, FeatureNames.SEE_HOME, "admin");
		addFeaturesToRole(conn, FeatureNames.ACCESS_API, "admin");
		addFeaturesToRole(conn, FeatureNames.API_UNSPECIFIED, "admin");
		addFeaturesToRole(conn, FeatureNames.API_SYS_ADMIN, "admin");
		addFeaturesToRole(conn, FeatureNames.API_CHANGE_PASSWORD, "admin");
		
		addFeatureIfNotExists(conn, FeatureNames.MANAGEMENT_PORTAL, MessageService.getMessage("access.management.portal"), true);
		addFeaturesToRole(conn, FeatureNames.MANAGEMENT_PORTAL, "sysadmin");
		addFeatureIfNotExists(conn, FeatureNames.ADD_PORTAL, MessageService.getMessage("access.add.portal"), true);
		addFeaturesToRole(conn, FeatureNames.ADD_PORTAL, "sysadmin");
		addFeatureIfNotExists(conn, FeatureNames.EDIT_PORTAL, MessageService.getMessage("access.edit.portal"), true);
		addFeaturesToRole(conn, FeatureNames.EDIT_PORTAL, "sysadmin");
		addFeatureIfNotExists(conn, FeatureNames.DELETE_PORTAL, MessageService.getMessage("access.delete.portal"), true);
		addFeaturesToRole(conn, FeatureNames.DELETE_PORTAL, "sysadmin");
		addFeatureIfNotExists(conn, FeatureNames.VIEW_PORTAL, MessageService.getMessage("access.view.portal"), true);
		addFeaturesToRole(conn, FeatureNames.VIEW_PORTAL, "sysadmin");
		addFeatureIfNotExists(conn, FeatureNames.LIST_PORTAL, MessageService.getMessage("access.list.portal"), true);
		addFeaturesToRole(conn, FeatureNames.LIST_PORTAL, "sysadmin");
		
		
		addFeatureIfNotExists(conn, FeatureNames.CLIENT_SEE_META_ORGANIZATION_MENU, MessageService.getMessage("access.see.meta.organization.menu"), true);
		addFeaturesToRole(conn, FeatureNames.CLIENT_SEE_META_ORGANIZATION_MENU, "sysadmin");
		addFeatureIfNotExists(conn, FeatureNames.ACCESS_CM, MessageService.getMessage("access.cm"), true);
		addFeaturesToRole(conn, FeatureNames.ACCESS_CM, "sysadmin");
		
		addFeatureIfNotExists(conn, FeatureNames.GET_REPORT_LAYERS, MessageService.getMessage("access.get.report.layers"), true);
		addFeaturesToRole(conn, FeatureNames.GET_REPORT_LAYERS, "sysadmin");
		addFeatureIfNotExists(conn, FeatureNames.SEE_SECRET_LAYERS, MessageService.getMessage("access.see.secret.layers"), true);
		addFeaturesToRole(conn, FeatureNames.SEE_SECRET_LAYERS, "sysadmin");
		addFeatureIfNotExists(conn, FeatureNames.EDIT_SECRET_LAYERS, MessageService.getMessage("access.edit.secret.layers"), true);
		addFeaturesToRole(conn, FeatureNames.EDIT_SECRET_LAYERS, "sysadmin");
		addFeatureIfNotExists(conn, FeatureNames.GET_REPORT_SECRET_LAYERS, MessageService.getMessage("access.get.report.secret.layers"), true);
		addFeaturesToRole(conn, FeatureNames.GET_REPORT_SECRET_LAYERS, "sysadmin");
		
		addFeatureIfNotExists(conn, FeatureNames.GET_LAYER_FILES, MessageService.getMessage("access.get.layer.files"), true);
		addFeaturesToRole(conn, FeatureNames.GET_LAYER_FILES, "sysadmin");
		addFeatureIfNotExists(conn, FeatureNames.ADD_LAYER_FILES, MessageService.getMessage("access.add.layer.files"), true);
		addFeaturesToRole(conn, FeatureNames.ADD_LAYER_FILES, "sysadmin");
		addFeatureIfNotExists(conn, FeatureNames.DELETE_LAYER_FILES, MessageService.getMessage("access.delete.layer.files"), true);
		addFeaturesToRole(conn, FeatureNames.DELETE_LAYER_FILES, "sysadmin");
		addFeatureIfNotExists(conn, FeatureNames.DOWNLOAD_LAYER_FILES, MessageService.getMessage("access.download.layer.files"), true);
		addFeaturesToRole(conn, FeatureNames.DOWNLOAD_LAYER_FILES, "sysadmin");

		
		addFeatureIfNotExists(conn, FeatureNames.SEE_PUBLIC_POND_FORMS, MessageService.getMessage("access.see.pond.public.forms"), true);
		addFeaturesToRole(conn, FeatureNames.SEE_PUBLIC_POND_FORMS, "sysadmin");
		addFeatureIfNotExists(conn, FeatureNames.EDIT_PUBLIC_POND_FORMS, MessageService.getMessage("access.edit.pond.public.forms"), true);
		addFeaturesToRole(conn, FeatureNames.EDIT_PUBLIC_POND_FORMS, "sysadmin");
		addFeatureIfNotExists(conn, FeatureNames.DOWNLOAD_PUBLIC_POND_FORMS, MessageService.getMessage("access.download.pond.public.forms"), true);
		addFeaturesToRole(conn, FeatureNames.DOWNLOAD_PUBLIC_POND_FORMS, "sysadmin");

		addFeatureIfNotExists(conn, FeatureNames.SEE_SECRET_POND_FORMS, MessageService.getMessage("access.see.pond.secret.forms"), true);
		addFeaturesToRole(conn, FeatureNames.SEE_SECRET_POND_FORMS, "sysadmin");
		addFeatureIfNotExists(conn, FeatureNames.EDIT_SECRET_POND_FORMS, MessageService.getMessage("access.edit.pond.secret.forms"), true);
		addFeaturesToRole(conn, FeatureNames.EDIT_SECRET_POND_FORMS, "sysadmin");
		addFeatureIfNotExists(conn, FeatureNames.DOWNLOAD_SECRET_POND_FORMS, MessageService.getMessage("access.download.pond.secret.forms"), true);
		addFeaturesToRole(conn, FeatureNames.DOWNLOAD_SECRET_POND_FORMS, "sysadmin");
		
				
		//and so on...
		//description for management entity should be in format like "accessing management of ..."
		//description for other client features should be in format like access to client for ..."
		//description for service feature should be in format like access to API for ..."
	}

}
