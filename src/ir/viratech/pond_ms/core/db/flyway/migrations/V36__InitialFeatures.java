package ir.viratech.pond_ms.core.db.flyway.migrations;

import java.sql.Connection;

import ir.viratech.commons.persistence.sql.Quoter;
import ir.viratech.commons.persistence.sql.SqlUtil;
import ir.viratech.pond_ms.core.features.FeatureNames;
import ir.viratech.pond_ms.model.user.Feature;

/**
 * This class will add default features which are common across project to db.
 * This is a Migrate class and should be executed by flyway.
 */
public class V36__InitialFeatures extends BaseJdbcMigration {

	/**
	 * Add default features to database.
	 * These features are common in almost all projects.
	 */
	@Override
	public void migrate(Connection conn) throws Exception {
		this.setId(1);
		Quoter quoter = new Quoter(false, true, true, true, false);
		String query = SqlUtil.insertIntoTable(Feature.TABLE, Feature.PROPCOLUMN_ID, Feature.PROPCOLUMN_EXTUID, Feature.PROPCOLUMN_NAME, Feature.PROPCOLUMN_DESCRIPTION, Feature.PROPCOLUMN_EXPOSABLE)
				+ SqlUtil.values(
						quoter.tuple(this.nextId(), this.generateUid(), FeatureNames.ACCESS_API, FeatureNames.ACCESS_API, false),
						quoter.tuple(this.nextId(), this.generateUid(), FeatureNames.SEE_HOME, FeatureNames.SEE_HOME, true),
						quoter.tuple(this.nextId(), this.generateUid(), FeatureNames.API_CHANGE_PASSWORD, FeatureNames.API_CHANGE_PASSWORD, false),
						quoter.tuple(this.nextId(), this.generateUid(), FeatureNames.SEE_UNSPECIFIED, FeatureNames.SEE_UNSPECIFIED, false),
						quoter.tuple(this.nextId(), this.generateUid(), FeatureNames.API_UNSPECIFIED, FeatureNames.API_UNSPECIFIED, false),
						quoter.tuple(this.nextId(), this.generateUid(), FeatureNames.API_SYS_ADMIN, FeatureNames.API_SYS_ADMIN, false),
						quoter.tuple(this.nextId(), this.generateUid(), FeatureNames.GET_REPORT_LAYERS, FeatureNames.GET_REPORT_LAYERS, false),
						quoter.tuple(this.nextId(), this.generateUid(), FeatureNames.SEE_SECRET_LAYERS, FeatureNames.SEE_SECRET_LAYERS, false),
						quoter.tuple(this.nextId(), this.generateUid(), FeatureNames.EDIT_SECRET_LAYERS, FeatureNames.EDIT_SECRET_LAYERS, false),
						quoter.tuple(this.nextId(), this.generateUid(), FeatureNames.GET_REPORT_SECRET_LAYERS, FeatureNames.GET_REPORT_SECRET_LAYERS, false),
						quoter.tuple(this.nextId(), this.generateUid(), FeatureNames.GET_LAYER_FILES, FeatureNames.GET_LAYER_FILES, false),
						quoter.tuple(this.nextId(), this.generateUid(), FeatureNames.ADD_LAYER_FILES, FeatureNames.ADD_LAYER_FILES, false),
						quoter.tuple(this.nextId(), this.generateUid(), FeatureNames.DELETE_LAYER_FILES, FeatureNames.DELETE_LAYER_FILES, false),
						quoter.tuple(this.nextId(), this.generateUid(), FeatureNames.DOWNLOAD_LAYER_FILES, FeatureNames.DOWNLOAD_LAYER_FILES, false),
						quoter.tuple(this.nextId(), this.generateUid(), FeatureNames.SEE_PUBLIC_POND_FORMS, FeatureNames.SEE_PUBLIC_POND_FORMS, false),
						quoter.tuple(this.nextId(), this.generateUid(), FeatureNames.EDIT_PUBLIC_POND_FORMS, FeatureNames.EDIT_PUBLIC_POND_FORMS, false),
						quoter.tuple(this.nextId(), this.generateUid(), FeatureNames.DOWNLOAD_PUBLIC_POND_FORMS, FeatureNames.DOWNLOAD_PUBLIC_POND_FORMS, false),
						quoter.tuple(this.nextId(), this.generateUid(), FeatureNames.SEE_SECRET_POND_FORMS, FeatureNames.SEE_SECRET_POND_FORMS, false),
						quoter.tuple(this.nextId(), this.generateUid(), FeatureNames.EDIT_SECRET_POND_FORMS, FeatureNames.EDIT_SECRET_POND_FORMS, false),
						quoter.tuple(this.nextId(), this.generateUid(), FeatureNames.DOWNLOAD_SECRET_POND_FORMS, FeatureNames.DOWNLOAD_SECRET_POND_FORMS, false),
						quoter.tuple(this.nextId(), this.generateUid(), FeatureNames.MANAGEMENT_PORTAL, FeatureNames.MANAGEMENT_PORTAL, false),
						quoter.tuple(this.nextId(), this.generateUid(), FeatureNames.ADD_PORTAL, FeatureNames.ADD_PORTAL, false),
						quoter.tuple(this.nextId(), this.generateUid(), FeatureNames.EDIT_PORTAL, FeatureNames.EDIT_PORTAL, false),
						quoter.tuple(this.nextId(), this.generateUid(), FeatureNames.DELETE_PORTAL, FeatureNames.DELETE_PORTAL, false),
						quoter.tuple(this.nextId(), this.generateUid(), FeatureNames.LIST_PORTAL, FeatureNames.LIST_PORTAL, false),
						quoter.tuple(this.nextId(), this.generateUid(), FeatureNames.CLIENT_SEE_META_ORGANIZATION_MENU, FeatureNames.CLIENT_SEE_META_ORGANIZATION_MENU, false),

						//Cm features
						quoter.tuple(this.nextId(), this.generateUid(), FeatureNames.ACCESS_CM, FeatureNames.API_CHANGE_PASSWORD, false),

						//event log
						quoter.tuple(this.nextId(), this.generateUid(), FeatureNames.SEE_EVENT_LOGS, FeatureNames.SEE_EVENT_LOGS, true)
				);
		this.executeQuery(conn, query);

		//Cm HotelFeatures


	}



}