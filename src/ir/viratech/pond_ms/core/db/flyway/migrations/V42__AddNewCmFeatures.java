package ir.viratech.pond_ms.core.db.flyway.migrations;

import java.sql.Connection;

import ir.viratech.commons.cm.core.feature.FeatureNames;
import ir.viratech.commons.persistence.sql.Quoter;
import ir.viratech.commons.persistence.sql.SqlUtil;
import ir.viratech.pond_ms.model.user.Feature;

public class V42__AddNewCmFeatures extends BaseJdbcMigration{

	@Override
	public void migrate(Connection conn) throws Exception {
		this.setId(this.getMaxIdByTable(conn, Feature.TABLE) + 1);
		Quoter quoter = new Quoter(false, true, true, true, false);
		String query = SqlUtil.insertIntoTable(Feature.TABLE, Feature.PROPCOLUMN_ID, Feature.PROPCOLUMN_EXTUID, Feature.PROPCOLUMN_NAME, Feature.PROPCOLUMN_DESCRIPTION, Feature.PROPCOLUMN_EXPOSABLE)
				+ SqlUtil.values(
						quoter.tuple(this.nextId(), this.generateUid(), FeatureNames.ENTITY_TYPE_ADD_FEATURE, FeatureNames.ENTITY_TYPE_ADD_FEATURE, true),
						quoter.tuple(this.nextId(), this.generateUid(), FeatureNames.ENTITY_TYPE_DELETE_FEATURE, FeatureNames.ENTITY_TYPE_DELETE_FEATURE, true),
						quoter.tuple(this.nextId(), this.generateUid(), FeatureNames.ENTITY_TYPE_READ_FEATURE, FeatureNames.ENTITY_TYPE_READ_FEATURE, true),
						quoter.tuple(this.nextId(), this.generateUid(), FeatureNames.ENTITY_TYPE_EDIT_FEATURE, FeatureNames.ENTITY_TYPE_EDIT_FEATURE, true),
						quoter.tuple(this.nextId(), this.generateUid(), FeatureNames.ENTITY_TYPE_COPY_FEATURE, FeatureNames.ENTITY_TYPE_COPY_FEATURE, true)

				);
		this.executeQuery(conn, query);
	}

}
