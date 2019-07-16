package ir.viratech.pond_ms.core.db.flyway.migrations;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ir.viratech.pond_ms.core.spring.ApplicationContextUtil;
import ir.viratech.pond_ms.model.hotel.Hotel;

public class V20__AddHotelYarNameCode extends BaseJdbcMigration {

	List<String> hotelNames = new ArrayList<>();
	List<String> hotelCodes = new ArrayList<>();

	private final static String hotelYar_filePath = "hotelyar-hotels-File";

	@Override
	public void migrate(Connection conn) throws Exception {
		// TODO Auto-generated method stub

		readFromFile();

		for (int i = 0; i < hotelNames.size(); i++) {
			String queryString = "update " + "pond_ms.hotels set " + Hotel.PROPCOLUMN_HOTELYAR_NAME + " = " + "'"
					+ hotelNames.get(i) + "' , " + Hotel.PROP_HOTELYAR_CODE + " = " + "'" + hotelCodes.get(i) + "'"
					+ " where " + Hotel.PROPCOLUMN_HOTEL_NAME + " = " + "'" + hotelNames.get(i) + "';";
			executeQuery(conn, queryString);

		}

	}

	private void readFromFile() {
		try {
			File file = new File(ApplicationContextUtil.getProperty(hotelYar_filePath));
			Scanner scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				String hotelName = scanner.nextLine();
				String hotelCode = scanner.nextLine();
				hotelNames.add(hotelName);
				hotelCodes.add(hotelCode);
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
