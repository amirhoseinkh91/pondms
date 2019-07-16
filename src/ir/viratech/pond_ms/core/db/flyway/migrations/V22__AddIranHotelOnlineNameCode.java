package ir.viratech.pond_ms.core.db.flyway.migrations;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ir.viratech.commons.cm.core.db.flyway.migrations.BaseJdbcMigration;
import ir.viratech.pond_ms.core.spring.ApplicationContextUtil;
import ir.viratech.pond_ms.model.hotel.Hotel;

public class V22__AddIranHotelOnlineNameCode extends BaseJdbcMigration {

	private final static String filePath = "iranhotelOnline-hotels-File";
	private List<String> hotelNames = new ArrayList<>();
	private List<String> hotelCodes = new ArrayList<>();

	@Override
	public void migrate(Connection connection) throws Exception {
		readFromFile();

		for (int i = 0; i < hotelNames.size(); i++) {
			String queryString = "update " + "pond_ms.hotels set " + Hotel.PROPCOLUMN_IRANHOTELONLINE_NAME + " = " + "'"
					+ hotelNames.get(i) + "' , " + Hotel.PROP_IRANHOTELONLINE_CODE + " = " + "'" + hotelCodes.get(i)
					+ "'" + " where " + Hotel.PROPCOLUMN_HOTEL_NAME + " = " + "'" + hotelNames.get(i) + "';";
			executeQuery(connection, queryString);
		}

	}

	private void readFromFile() {
		try {
			File file = new File(ApplicationContextUtil.getProperty(filePath));

			Scanner scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				String hotelName = scanner.nextLine();
				String hotelCode = scanner.nextLine();

				hotelNames.add(hotelName);
				hotelCodes.add(hotelCode);
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
