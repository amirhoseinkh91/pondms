package ir.viratech.just_ro.manager.website.flight;

import java.io.IOException;
import java.net.SocketTimeoutException;

import ir.viratech.just_ro.api.flight.dto.config.FlightWebsiteRequestDTO;
import ir.viratech.just_ro.api.flight.dto.search.FlightSearchQueryDTO;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import ir.viratech.just_ro.model.information.Information;


public class Tcharter extends FlightsWebsites {

	private Document document;
	
	public Tcharter() {

	}

	@Override
	public FlightWebsiteRequestDTO getFlightWebsiteRequestDTO() {
		return null;
	}



	public Tcharter(Information information) {
		super(information);
	}
	
	protected void startScrape () throws SocketTimeoutException {
		super.startScrape();
		try {
			document = Jsoup.connect(makeURL()).userAgent(userAgent).get();
			findFlights();
			
			System.out.println( this.getClass().getSimpleName() + " has been scraped");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void findFlights() {
		Element flightsBox = findFlightBox(document);
		
	}
	
	private Element findFlightBox(Document document) {
		return document.select("#dates").get(0);
	}
	
	private String makeURL() {
		String baseUrl = "https://tcharter.ir/tickets/dates/";
		if (information.getIsRoundTrip()) { // two-way ticket
//			String urlPart1 = baseUrl + srcCityCode + "-" + destCityCode + "-" + dateIn + getAdults() + "-" + getChildren() + "-" + getNewBorns() + 
			return null;
		} else { // one-way ticket			
			return baseUrl + srcCityCode + "-" + destCityCode;
		}
	}
	
}
