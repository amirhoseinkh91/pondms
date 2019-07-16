package ir.viratech.just_ro.manager.website.flight;

import java.io.IOException;
import java.net.SocketTimeoutException;

import ir.viratech.just_ro.api.flight.dto.config.FlightWebsiteRequestDTO;
import ir.viratech.just_ro.api.flight.dto.search.FlightSearchQueryDTO;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import ir.viratech.just_ro.model.information.Information;


public class Samtik extends FlightsWebsites {

	private Document document;

	public Samtik() {

	}

	@Override
	public FlightWebsiteRequestDTO getFlightWebsiteRequestDTO() {
		return null;
	}


	public Samtik(Information information) {
		super(information);
	}

	public void startScrape() throws SocketTimeoutException {
		super.startScrape();
		String url = makeURL();
		try {
			this.document = Jsoup.connect(url).get();
			findFlights();
			
			System.out.println( this.getClass().getSimpleName() + " has been scraped");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void findFlights() {
		Elements flighsBoxes = document.select("div.list-tickets > div.tab-content > div > div.row > div.col-xs-12 > article");

		for (Element flightBox : flighsBoxes) {
			String flightTitle = flightBox.select("div:nth-child(1) > h3:nth-child(2)").text().trim();
			String flightNumber = flightBox.select("div:nth-child(1) > small:nth-child(3)").text().trim();

			System.out.println(flightTitle + ": " + flightNumber);
		}

	}

	private String makeURL() {
		String baseUrl = "https://www.samtik.com/flight/";
		String planeFa = "هواپیما";
		String ticketFa = "بلیط";
		String toFa = "به";
		String dateIn = information.getCheckinDate().replaceAll("/", "");

		if (information.getIsRoundTrip()) { // two-way ticket
			// String urlPart1 = baseUrl + srcCityCode + "-" + destCityCode +
			// "-" + dateIn + getAdults() + "-" + getChildren() + "-" +
			// getNewBorns() +
			return null;
		} else { // one-way ticket
			String urlPart1 = baseUrl + srcCityCode + "-" + destCityCode + "-" + dateIn + "-" + information.getAdults() + "-" + information.getChildren() + "-"
					+ information.getNewBorns() + "/";
			String urlPart2 = ticketFa + "-" + planeFa + "-" + information.getSrcPersianCityName() + "-" + toFa + "-" + information.getPersianCityName();
			return urlPart1 + urlPart2;
		}
	}
}
