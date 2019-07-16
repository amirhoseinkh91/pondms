package ir.viratech.just_ro.model;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Document.OutputSettings;

import ir.viratech.just_ro.manager.website.proxy.ProxyManager;
import ir.viratech.just_ro.model.flight.Flight;
import ir.viratech.just_ro.model.hotel.Hotel;
import ir.viratech.just_ro.model.information.Information;

public abstract class Website implements Runnable {

	protected Information information;
	//public final static String userAgent = "Mozilla/5.0 (compatible; Googlebot/2.1; +http://www.google.com/bot.html)";
	public final static String userAgent = "Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:54.0) Gecko/20100101 Firefox/54.0";
	private static List<Hotel> hotels;
	private List<Flight> flights;
	protected String srcCityCode;
	protected String destCityCode;
	protected OutputSettings settings;
	protected final int timeOut = 3000;
	protected Hotel hotel = new Hotel();

	// constructors
	public Website() {

	}

	public Hotel getHotel() {
		return hotel;
	}

	public Website(Information information) {
		this.information = information;
		hotels = Collections.synchronizedList(new ArrayList<>());
		flights = Collections.synchronizedList(new ArrayList<>());
	}

	@Override
	public void run() {
		try {
			// startScrape();
			myStartScrape();
		} catch (SocketTimeoutException e) {
			// TODO handle Exception
		}
	}

	// setter getter for List<Hotel>
	public static List<Hotel> getHoltes() {
		return hotels;
	}

	// setter getter for list flights
	public List<Flight> getFlights() {
		return flights;
	}

	// add Hotel to List<Hotel>
	protected void addHotel(Hotel hotel) {
		synchronized (hotels) {
			this.hotels.add(hotel);
		}
	}

	protected void addFlight(Flight flight) {
		synchronized (flights) {
			this.flights.add(flight);
		}
	}

	protected void startScrape() throws SocketTimeoutException {
		settings = new OutputSettings();
		settings.charset("UTF-8");
	}

	protected void myStartScrape() throws SocketTimeoutException {
		settings = new OutputSettings();
		settings.charset("UTF-8");
	}
	
	protected Proxy getProxy() throws InstantiationException, IllegalAccessException {
		return ProxyManager.newInstance().getRandomProxy();
	}

	protected Document getConnectedDocument(String url, Method method) {
		Document document = null;
		try {
			document = Jsoup.connect(url).method(method).userAgent(userAgent).execute().parse();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return document;
	}

	protected Document getConnectedDocument(String url, Method method, String requestBody) {
		Document document = null;
		try {
			document = (Document) Jsoup.connect(url).method(method).requestBody(requestBody).userAgent(userAgent)
					.execute();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return document;
	}

	protected Response getConnectedResponse(String url, Method method) {
		Response response = null;
		try {
			response = Jsoup.connect(url).method(method).userAgent(userAgent).execute();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return response;
	}

	protected Response getConnectedResponse(String url, Method method, String requestBody) {
		Response response = null;
		try {
			response = Jsoup.connect(url).method(method).userAgent(userAgent).requestBody(requestBody).execute();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return response;
	}
}
