package ir.viratech.pond_ms.core.db.flyway.migrations;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import ir.viratech.pond_ms.core.spring.ApplicationContextUtil;
import ir.viratech.pond_ms.model.hotel.Hotel;

public class V25__PinTaPinAddHotelNames extends BaseJdbcMigration {

	List<String> hotelPinTaPinNames = new ArrayList<>();
	List<String> hotelNames = new ArrayList<>();
	private final static String pinTaPin_filePath = "pintapin-hotels-file";

	@Override
	public void migrate(Connection conn) throws Exception {
		readFromFile();
		for (int i = 0; i < hotelNames.size(); i++) {
			String queryString = "update " + "pond_ms.hotels set " + Hotel.PROPCOLUMN_PINTAPIN_NAME + " = " + "'"
					+ hotelPinTaPinNames.get(i) + "'" + " where " + Hotel.PROPCOLUMN_HOTEL_NAME + " = " + "'"
					+ hotelPinTaPinNames.get(i) + "';";
			executeQuery(conn, queryString);

		}
	}

	private void readFromFile() {
		try {
			File file = new File(ApplicationContextUtil.getProperty(pinTaPin_filePath));
			Scanner scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				String hotelName = null;
				try {
					hotelName = scanner.nextLine();
				} catch (NoSuchElementException e){
					hotelName = null;
				}
				String pinTaPinNames = null;
				try {
					pinTaPinNames = scanner.nextLine();
				} catch (NoSuchElementException e){
					pinTaPinNames = null;
				}
				System.out.println(hotelName + "\t" + pinTaPinNames);
				hotelNames.add(hotelName);
				hotelPinTaPinNames.add(pinTaPinNames);
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
