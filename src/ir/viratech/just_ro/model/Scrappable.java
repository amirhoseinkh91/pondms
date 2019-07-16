package ir.viratech.just_ro.model;

import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.nodes.Document;

import ir.viratech.just_ro.model.flight.Flight;
import ir.viratech.just_ro.model.hotel.Hotel;

public interface Scrappable {
	Document getConnectedDocument(String url, Method method);
	Document getConnectedDocument(String url, Method method, String requestBody);
	Response getConnectedResponse(String url, Method method);
	Response getConnectedResponse(String url, Method method, String requestBody);
	void addFlight(Flight flight);
	void addHotel(Hotel hotel);
	void startScrape();
}
