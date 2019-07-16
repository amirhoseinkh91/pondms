package ir.viratech.just_ro.manager.website.flight;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.SocketTimeoutException;

import ir.viratech.just_ro.api.flight.dto.config.FlightWebsiteRequestDTO;
import ir.viratech.just_ro.api.flight.dto.search.FlightSearchQueryDTO;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import ir.viratech.just_ro.model.flight.Flight;
import ir.viratech.just_ro.model.information.Information;


public class IrTour extends FlightsWebsites {

	@Override
	public FlightWebsiteRequestDTO getFlightWebsiteRequestDTO() {
		return null;
	}



	public IrTour(Information information) {
		super(information);
	}

	public void startScrape() throws SocketTimeoutException {
		super.startScrape();
		String url = "http://irtour.ir/fa/Flight/SearchFlight";
		String url2 = "http://irtour.ir";
		String requestBody = makeRequestBody(url2);
		// String reqBody = "From=THR&To=KIH&StartDate=1396%2F02%2F25"
		// + "&EndDate=&passenger%5B0%5D.Key=adt&passenger%5B0%5D.Value=1"
		// + "&passenger%5B1%5D.Key=chd&passenger%5B1%5D.Value=0"
		// + "&passenger%5B2%5D.Key=inf&passenger%5B2%5D.Value=0"
		// + "&Fare=Business%2CEconomy";

		try {
			Response response = Jsoup.connect(url2).userAgent(userAgent).header("Host", "irtour.ir")
					.header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
					.header("Accept-Language", "en-US,en;q=0.5").header("Accept-Encoding", "gzip, deflate")
					.referrer("http://irtour.ir/").header("Connection", "keep-alive").followRedirects(true)
					.requestBody(requestBody).method(Method.POST).execute();

			Document document = response.parse();

			File file = new File("/home/amir/Desktop/testIRTOUR.html");
			FileWriter writer = new FileWriter(file);
			writer.append(document.outerHtml());
			writer.close();
			findFlights(document, url + "?" + requestBody);

			System.out.println(this.getClass().getSimpleName() + " has been scraped");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void findFlights(Document document, String url) {
		Element flightsBox = findFlightsBox(document);
		for (int i = 0; i < flightsBox.getElementsByAttributeValue("class", "flight-panel").size(); i++) {
			Element flightBox = flightsBox.getElementsByAttributeValue("class", "flight-panel").get(i);
			String flightNumber = findFlightNumber(flightBox);
			String[] flightCompanyParts = findCompany(flightBox).split("،");
			String flightCompany = flightCompanyParts[0].trim();
			String type = flightCompanyParts[1].trim();
			String time = findTime(flightBox);

			// find lowestPrice
			String price = findLowestPrice(flightBox);

			String capacity = findCapacity(flightBox);

			Flight flight = new Flight(flightCompany, capacity, price, flightNumber, information.getCheckinDate(),
					"IrTour", url, time);

			addFlight(flight);

		}
	}

	private String makeRequestBody(String url) {
		StringBuilder reqBody = new StringBuilder();
		reqBody.append("?From=" + this.srcCityCode);
		reqBody.append("&To=" + this.destCityCode);
		reqBody.append("&StartDate=" + information.getCheckinDate());// .replaceAll("/",
																		// "%2F"));
		reqBody.append("&EndDate=");
		if (information.getIsRoundTrip())
			reqBody.append(information.getCheckOutDate());// .replaceAll("/",
															// "%2F"));
		reqBody.append("&passenger[0].Key=adt&passenger[0].Value=" + information.getAdults());
		reqBody.append("&passenger[1].Key=chd&passenger[1].Value=" + information.getChildren());
		reqBody.append("&passenger[2].Key=inf&passenger[2].Value=" + information.getNewBorns());
		reqBody.append("&Fare=Business,Economy");

		return reqBody.toString();
	}

	private String findCapacity(Element flightBox) {
		String capacity = flightBox.select("div.fp-body > div.text-center > div.row").get(0).child(1).child(1).child(1)
				.child(1).text().trim();
		capacity = capacity.replace("صندلی موجود", "").trim();
		return capacity;
	}

	private String findLowestPrice(Element flightBox) {
		String price = flightBox.select("div.fp-body > div.text-center > div.row").get(0).child(1).child(1).child(1)
				.child(0).text().trim();
		price = price.replace("تومان", "");
		price = price.replaceAll(",", "").trim();

		long priceValue = Long.parseLong(price);
		return calculateFinalPrice(priceValue);
	}

	private String findTime(Element flightBox) {
		return flightBox.select("div.fp-body > div.text-center > div.row").get(0).child(0).child(0).child(0).child(0)
				.text().trim();
	}

	private String findCompany(Element flightBox) {
		return flightBox.select("div.fp-body > div.row > div.col-xs-9.col-sm-9.col-md-9.col-lg-9").get(0).child(0)
				.text();
	}

	private String findFlightNumber(Element flightBox) {
		String flightNumber = flightBox.select("div.fp-body > div.row > div.col-xs-9.col-sm-9.col-md-9.col-lg-9").get(0)
				.child(1).text();
		String[] flightNumParts = flightNumber.split(" ");
		flightNumber = flightNumParts[2];
		return flightNumber;
	}

	private Element findFlightsBox(Document document) {
		String cssSelector = "body > div#Airinegrid.container-fluid > div#pagebody.row > div.col-sm-10.col-md-10.col-lg-10 > div#grid"
				+ " > div#Departurelist > div#gridrslt > div.row";
		String cssSelector2 = "body";
		System.out.println("+=-+-+_=_=_=-+_+-+-+-+-+-=_=-+_+-+_");
		System.out.println(document.outerHtml());
		System.out.println("+=-+-+_=_=_=-+_+-+-+-+-+-=_=-+_+-+_");
		return document.select(cssSelector).get(0);
	}
}
