package ir.viratech.just_ro.manager.website.flight;

import java.io.IOException;
import java.net.SocketTimeoutException;

import ir.viratech.just_ro.api.flight.dto.config.FlightWebsiteRequestDTO;
import ir.viratech.just_ro.api.flight.dto.search.FlightSearchQueryDTO;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;

import ir.viratech.just_ro.model.information.Information;


public class Parvaziran extends FlightsWebsites{

	@Override
	public FlightWebsiteRequestDTO getFlightWebsiteRequestDTO() {
		return null;
	}


	public Parvaziran(Information information) {
		super(information);
	}
	
	@Override
	public void startScrape() throws SocketTimeoutException {
		super.startScrape();
		String url = "http://parvaziran.ir/api/flight/getalloneway/"
				+ "?flightType=charter&source=THR"
				+ "&destination=KIH&personCount=1&flightDate=1396/02/25";
		
		try {
			Response response = Jsoup.connect(url).userAgent(userAgent)
					.method(Method.GET).ignoreContentType(true).execute();
			response.charset("UTF-8");
			System.out.println(response.body());
			
			System.out.println( this.getClass().getSimpleName() + " has been scraped");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
