package ir.viratech.pond_ms.core.db.flyway.migrations;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ir.viratech.commons.persistence.sql.Quoter;
import ir.viratech.commons.persistence.sql.SqlUtil;
import ir.viratech.pond_ms.core.spring.ApplicationContextUtil;
import ir.viratech.pond_ms.model.city.City;
import ir.viratech.pond_ms.model.hotel.Hotel;


public class V19__AddCitiesAndHotelsToDB extends BaseJdbcMigration {

	private List<Hotel> hotels = new ArrayList<>();
	private List<City> cities = new ArrayList<>();
	
	private final String eghamat24Cities_FilePath = "eghamat-cities-File";
	private final String eghamat24Hotels_FilePath = "eghamat-hotels-File";
	
	@Override
	public void migrate(Connection conn) throws Exception {
		
		readFromFile();
		
		for (int i = 0; i < hotels.size(); i++) {
			Quoter quoter = new Quoter(false, true, true, true);
			System.out.println(hotels.get(i).getEghamat_name() + " ==== " +  hotels.get(i).getHotel_name());
			this.executeQuery(conn, SqlUtil.insertIntoTable(Hotel.TABLE, Hotel.PROPCOLUMN_ID, Hotel.PROPCOLUMN_EXTUID,
					Hotel.PROPCOLUMN_HOTEL_NAME, Hotel.PROPCOLUMN_EGHAMAT_NAME)
					+ SqlUtil.values(
							quoter.tuple(i, this.generateUid(), hotels.get(i).getHotel_name(), hotels.get(i).getEghamat_name())));
		}

		for (int i = 0; i < cities.size(); i++) {
			Quoter quoter = new Quoter(false, true, true, true);
			System.out.println(cities.get(i).getEghamat_name() + " ==== " + cities.get(i).getCity_name());
			this.executeQuery(conn, SqlUtil.insertIntoTable(City.TABLE, City.PROPCOLUMN_ID, City.PROPCOLUMN_EXTUID,
					City.PROPCOLUMN_CITY_NAME, City.PROPCOLUMN_EGHAMAT_NAME)
					+ SqlUtil.values(
							quoter.tuple(i, this.generateUid(), cities.get(i).getCity_name(), cities.get(i).getEghamat_name())));
		}

	}

	private void readFromFile() {
		readCitiesFromFile();
		readHotelsFromFile();
	}

	private void readCitiesFromFile() {
		try {
			File file = new File(ApplicationContextUtil.getProperty(eghamat24Cities_FilePath));
			Scanner scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				String faName = scanner.nextLine();
				String enName = scanner.nextLine();
				City city = new City();
				city.setCity_name(faName);
				city.setEghamat_name(enName);
				cities.add(city);

			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private void readHotelsFromFile() {
		try {
			File file = new File(ApplicationContextUtil.getProperty(eghamat24Hotels_FilePath));
			Scanner scanner;

			scanner = new Scanner(file);

			while (scanner.hasNextLine()) {
				String faName = scanner.nextLine();
				String enName = scanner.nextLine();
				Hotel hotel = new Hotel();
				hotel.setHotel_name(faName);
				hotel.setEghamat_name(enName);
				hotels.add(hotel);
			}

			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

}
