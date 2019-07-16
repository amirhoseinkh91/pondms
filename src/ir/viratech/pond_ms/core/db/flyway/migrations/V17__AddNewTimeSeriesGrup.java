package ir.viratech.pond_ms.core.db.flyway.migrations;

import java.sql.Connection;
import java.sql.SQLException;

import ir.viratech.commons.persistence.sql.Quoter;
import ir.viratech.commons.persistence.sql.SqlUtil;
import ir.viratech.pond_ms.core.i18n.MessageService;
import ir.viratech.pond_ms.model.time_series.TimeSeriesGroup;
import ir.viratech.pond_ms.model.user.Feature;

public class V17__AddNewTimeSeriesGrup extends BaseJdbcMigration{

	@Override
	public void migrate(Connection conn) throws Exception {
		addTimeSeriesGroup(conn, new String[]{"synoptic", "niroo", "hydrometery", "water_level"});
	}

	protected long addTimeSeriesGroup(Connection conn, String[] timeSeriesGroupKeys) throws SQLException {
		long id = this.getMaxIdByTable(conn, Feature.TABLE)+1;
		String query = SqlUtil.insertIntoTable(TimeSeriesGroup.TABLE, TimeSeriesGroup.PROPCOLUMN_ID, TimeSeriesGroup.PROPCOLUMN_EXTUID, TimeSeriesGroup.PROPCOLUMN_NAME, TimeSeriesGroup.PROPCOLUMN_DESCRIPTION)
				+ SqlUtil.values(
						timeSeriesGroupsToTuples(id, timeSeriesGroupKeys)
				);
		this.executeQuery(conn, query);
		return id;
	}

	protected String[] timeSeriesGroupsToTuples(long id, String[] timeSeriesGroupKeys) {
		String[] result = new String[timeSeriesGroupKeys.length];
		Quoter quoter = new Quoter(false, true, true, true);

		int i = 0;
		for (String key : timeSeriesGroupKeys) {
			result[i] = quoter.tuple(id++, this.generateUid(), MessageService.getMessage("time_series.group." + key + ".name"), MessageService.getMessage("time_series.group." + key + ".description"));
			i++;
		}

		return result;
	}


}
