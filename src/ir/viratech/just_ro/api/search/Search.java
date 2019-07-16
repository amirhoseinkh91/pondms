package ir.viratech.just_ro.api.search;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONException;
import org.json.JSONObject;

import ir.viratech.just_ro.manager.merge.MergeFlights;
import ir.viratech.just_ro.manager.merge.MergeHotels;

import ir.viratech.just_ro.manager.website.flight.FlightsWebsites;
import ir.viratech.just_ro.manager.website.flight.Ghasedak24;
import ir.viratech.just_ro.manager.website.hotel.AriaBooking;
import ir.viratech.just_ro.manager.website.hotel.Eghamat24;
import ir.viratech.just_ro.manager.website.hotel.HotelsWebsites;
import ir.viratech.just_ro.manager.website.hotel.IranHotelOnline;
import ir.viratech.just_ro.manager.website.hotel.SnappTrip;
import ir.viratech.just_ro.model.Website;
import ir.viratech.just_ro.model.calendar.CalendarTool;
import ir.viratech.just_ro.model.errors.http.Error;
import ir.viratech.just_ro.model.flight.Flight;
import ir.viratech.just_ro.model.hotel.Hotel;
import ir.viratech.just_ro.model.information.Information;

@Path("/search")
public class Search {

	private Information information = new Information();

	private Set<Hotel> hotels;
	private Set<Flight> flights;

	private List<Hotel> lowestPriceHotels = null;

	private long startTime;
	private long endTime;

	private HotelsWebsites pintapin;
	private HotelsWebsites hotelyar;
	private HotelsWebsites ariaBooking;
	private HotelsWebsites eghamat;
	private HotelsWebsites iranHotelOnline;

	private FlightsWebsites alibaba;

	// new flight website
	private FlightsWebsites airlplainTicket;
	private FlightsWebsites ghasedak24;
	private FlightsWebsites mrbilit;

	private Thread pintapinThread;

	// new flight thread
	private Thread airplainTicketThread;

	private Thread hotelyarThread;
	private Thread ariabookingThread;
	private Thread alibabaThread;
	private Thread ghasedak24Thread;
	private Thread mrbilitThread;
	private Thread eghamatThread;
	private Thread iranHotelOnlineThread;

	@POST
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	@Path("/hotels/features")
	public Response getHotelFeatures(String input) {
		startTime = System.currentTimeMillis();
		JSONObject jsonObject = null;
		String link = null;
		String host = null;
		try {
			jsonObject = new JSONObject(input);
			link = jsonObject.getString("link");
			host = jsonObject.getString("host");
		} catch (JSONException e1) {
			e1.printStackTrace();
		}
		try {
			HotelsWebsites hotelsWebsites = new HotelsWebsites();
			List<String> features = hotelsWebsites.getHotelFeaturesScrapper(link, host);
			endTime = System.currentTimeMillis();
			System.out.println("find hotel features time: " + (endTime - startTime) / 1000);
			return Response.status(Error.OK_CODE).entity(features).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Error.No_Content_From_Server_CODE).entity(Error.No_Content_From_Server_FA).build();
		}

	}

	@GET
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	@Path("/hotels/searchNames")
	public Response searchHotelsNames(@QueryParam("city") String cityName, @QueryParam("hotel") String hotelName,
			@QueryParam("check_in") String checkInDate, @QueryParam("nights") String nights,
			@QueryParam("adults") String adults, @QueryParam("children") String children,
			@QueryParam("rooms") String rooms) {
		this.information = new Information(cityName, hotelName, checkInDate, nights, adults, children,
				Integer.parseInt(rooms));
		searchHotelsByName();
		return Response.status(200).entity(this.lowestPriceHotels).build();
	}

	/*
	 * for cache model !!!
	 */

	public List<Hotel> searchHotelsNames(String cityName, String hotelName, String checkInDate) {

		this.information = new Information(cityName, hotelName, checkInDate, "1", "1", "0", Integer.parseInt("1"));
		return searchHotelsByName();
	}


	@GET
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	@Path("/hotels/items")
	public Response getHotels(@QueryParam("city") String persianCityName, @QueryParam("check_in") String checkinDate,
			@QueryParam("nights") String nights, @QueryParam("adults") String adults,
			@QueryParam("children") String children, @QueryParam("rooms") String rooms) {

		hotels = new HashSet<>();

		String faCityName = persianCityName.replaceAll("-", " ");

		boolean isDataValid = checkDataValidation(faCityName, checkinDate, nights, adults, children, rooms);
		if (isDataValid) {
			startTime = System.currentTimeMillis();
			information = new Information(faCityName, checkinDate, Integer.parseInt(nights), Integer.parseInt(adults),
					Integer.parseInt(children), Integer.parseInt(rooms));
			searchHotels();
			if (this.hotels.size() == 0) {
				return Response.status(Error.No_Content_From_Server_CODE)
						.entity(new Error(Error.No_Content_From_Server_CODE, Error.No_Content_From_Server_FA)).build();
			} else {
				endTime = System.currentTimeMillis();
				return Response.status(200).entity(this.hotels).build();
			}
		} else {
			return Response.status(Error.Bad_Request_CODE)
					.entity(new Error(Error.Bad_Request_CODE, Error.Bad_Request_FA)).build();
		}
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	@Path("/flights/items")
	public Response getFlights(@QueryParam("src") String srcPersianCityName,
			@QueryParam("dst") String dstPersianCityName, @QueryParam("date") String checkinDate,
			@QueryParam("passengers") String passengers, @QueryParam("class") String flightClass) {

		flights = new HashSet<>();

		String srcfaCityName = srcPersianCityName.replaceAll("-", " ");
		String dstfaCityName = dstPersianCityName.replaceAll("-", " ");

		if (srcfaCityName.equals("") | srcfaCityName.equals(" ") | srcfaCityName == null | dstfaCityName.equals("")
				| dstfaCityName.equals(" ") | dstfaCityName == null) {
			return Response.status(Error.Bad_Request_CODE)
					.entity(new Error(Error.Bad_Request_CODE, "نام شهر ها را با دقت وارد نمایید")).build();
		}

		boolean isvalid = checkFlightDataValidation(srcfaCityName, dstfaCityName, checkAlibabaDayMonth(checkinDate),
				passengers);

		if (isvalid) {
			information = new Information(srcfaCityName, dstfaCityName, checkAlibabaDayMonth(checkinDate), flightClass,
					Integer.parseInt(passengers), false);
			searchFlights();
			if (flights.size() == 0) {
				return Response.status(Error.No_Content_From_Server_CODE).build();
			} else {
				return Response.status(Error.OK_CODE).entity(this.flights).build();
			}
		}

		return Response.status(Error.OK_CODE).entity(new Error(Error.Bad_Request_CODE, Error.Bad_Request_FA)).build();
	}

	private String checkAlibabaDayMonth(String checkinDate) {
		String[] parts = checkinDate.split("/");
		String month = parts[1];
		String day = parts[2];
		int dayValue = Integer.parseInt(day);

		if (1 <= dayValue && dayValue <= 9) {
			day = "0" + dayValue;
		}
		int monthValue = Integer.parseInt(month);
		if (1 <= monthValue && monthValue <= 9) {
			month = "0" + monthValue;
		}

		return parts[0] + "/" + month + "/" + day;
	}

	private boolean checkDataValidation(String persianCityName, String checkinDate, String nights, String adults,
			String children, String rooms) {
		final String[] enNumsArray = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "0" };
		final String[] faNumsArray = { "۱", "۲", "۳", "۴", "۵", "۶", "۷", "۸", "۹", "۰" };
		try {

			Integer.parseInt(rooms);

			for (String enNumber : enNumsArray)
				if (persianCityName.contains(enNumber))
					return false;
			for (String faNumber : faNumsArray)
				if (persianCityName.contains(faNumber))
					return false;
			if (Integer.parseInt(adults) <= 0 | Integer.parseInt(adults) > 9)
				return false;
			if (Integer.parseInt(children) < 0 | Integer.parseInt(children) > 9
					| Integer.parseInt(children) > Integer.parseInt(adults) + 5)
				return false;
			if (Integer.parseInt(nights) <= 0 | Integer.parseInt(nights) > 9)
				return false;
			if (checkinDateValidation(checkinDate) != 0)
				return false;
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	private boolean checkFlightDataValidation(String srcPersianCityName, String dstPersianCityName, String checkinDate,
			String passengers) {
		final String[] enNumsArray = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "0" };
		final String[] faNumsArray = { "۱", "۲", "۳", "۴", "۵", "۶", "۷", "۸", "۹", "۰" };
		try {
			for (String enNumber : enNumsArray) {
				if (srcPersianCityName.contains(enNumber)) {
					return false;
				}
			}
			for (String faNumber : faNumsArray) {
				if (srcPersianCityName.contains(faNumber)) {
					return false;
				}
			}

			if (Integer.parseInt(passengers) <= 0 | Integer.parseInt(passengers) > 9)
				return false;

			if (information.getIsRoundTrip()) {
				if (checkoutDateValidation(checkinDate) != 0)
					return false;
			}

			return true;
		} catch (Exception e) {
			return false;
		}
	}

	private int checkinDateValidation(String checkinDate) {
		try {
			LocalDate localDate = LocalDate.now();
			String[] dateParts = DateTimeFormatter.ofPattern("yyy/MM/dd").format(localDate).split("/");
			CalendarTool calendarTool = new CalendarTool(Integer.parseInt(dateParts[0]), Integer.parseInt(dateParts[1]),
					Integer.parseInt(dateParts[2]));
			int thisYear = calendarTool.getIranianYear();
			int thisMonth = calendarTool.getIranianMonth();
			int thisday = calendarTool.getIranianDay();

			if (!checkinDate.contains("/"))
				return 1;
			int counter = 0;
			for (int i = 0; i < checkinDate.length(); i++) {
				if (checkinDate.charAt(i) == '/')
					counter++;
			}
			if (counter != 2)
				return 1;
			String[] parts = checkinDate.split("/");
			if (Integer.parseInt(parts[0]) < thisYear)
				return 1;
			if (Integer.parseInt(parts[1]) < thisMonth | Integer.parseInt(parts[1]) > 13)
				return 1;
			if (Integer.parseInt(parts[1]) == thisMonth)
				if (Integer.parseInt(parts[2]) < thisday)
					return 1;
			if (Integer.parseInt(parts[2]) > 31)
				return 1;
			return 0;
		} catch (Exception e) {
			return 1;
		}

	}

	private int checkoutDateValidation(String checkoutDate) {
		try {
			LocalDate localDate = LocalDate.now();
			String[] dateParts = DateTimeFormatter.ofPattern("yyy/MM/dd").format(localDate).split("/");
			CalendarTool calendarTool = new CalendarTool(Integer.parseInt(dateParts[0]), Integer.parseInt(dateParts[1]),
					Integer.parseInt(dateParts[2]));
			int thisYear = calendarTool.getIranianYear();
			int thisMonth = calendarTool.getIranianMonth();
			int thisday = calendarTool.getIranianDay();

			if (!checkoutDate.contains("/"))
				return 1;
			int counter = 0;
			for (int i = 0; i < checkoutDate.length(); i++) {
				if (checkoutDate.charAt(i) == '/')
					counter++;
			}
			if (counter != 2)
				return 1;
			String[] parts = checkoutDate.split("/");
			if (Integer.parseInt(parts[0]) < thisYear)
				return 1;
			if (Integer.parseInt(parts[1]) < thisMonth | Integer.parseInt(parts[1]) > 13)
				return 1;
			if (Integer.parseInt(parts[1]) == thisMonth)
				if (Integer.parseInt(parts[2]) < thisday)
					return 1;
			if (Integer.parseInt(parts[2]) > 31)
				return 1;
			return 0;
		} catch (Exception e) {
			return 1;
		}

	}

	public List<Hotel> searchHotelsByName() {
		try {
			pintapin = new SnappTrip(information);
			pintapinThread = new Thread(pintapin);
			pintapinThread.start();

			// hotelyar = new HotelYar(information);
			// hotelyarThread = new Thread(hotelyar);
			// hotelyarThread.start();

			eghamat = new Eghamat24(information);
			eghamatThread = new Thread(eghamat);
			eghamatThread.start();

			ariaBooking = new AriaBooking(information);
			ariabookingThread = new Thread(ariaBooking);
			ariabookingThread.start();
			//
			// // hotelyar = new HotelYar(information);
			// // hotelyarThread = new Thread(hotelyar);
			// // hotelyarThread.start();
			//
			iranHotelOnline = new IranHotelOnline(information);
			iranHotelOnlineThread = new Thread(iranHotelOnline);
			iranHotelOnlineThread.start();

			pintapinThread.join();
			eghamatThread.join();
			ariabookingThread.join();
			// hotelyarThread.join();
			iranHotelOnlineThread.join();

			lowestPriceHotels = Website.getHoltes();
			return Website.getHoltes();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	public void searchHotels() {
		List<Hotel> pintapinHotels = new ArrayList<>();
		List<Hotel> hotelyarHotels = new ArrayList<>();
		List<Hotel> ariabookingHotels = new ArrayList<>();
		List<Hotel> iranHotelOnlineHotels = new ArrayList<>();
		List<Hotel> eghamatHotels = new ArrayList<>();
		try {

			pintapin = new SnappTrip(information);
			pintapinThread = new Thread(pintapin);
			pintapinThread.start();

			// hotelyar = new HotelYar(information);
			// hotelyarThread = new Thread(hotelyar);
			// hotelyarThread.start();
			//
			eghamat = new Eghamat24(information);
			eghamatThread = new Thread(eghamat);
			eghamatThread.start();

			ariaBooking = new AriaBooking(information);
			ariabookingThread = new Thread(ariaBooking);
			ariabookingThread.start();

			iranHotelOnline = new IranHotelOnline(information);
			iranHotelOnlineThread = new Thread(iranHotelOnline);
			iranHotelOnlineThread.start();

			ariabookingThread.join();
			pintapinThread.join();
			// hotelyarThread.join();
			eghamatThread.join();
			iranHotelOnlineThread.join();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		pintapinHotels = pintapin.getHoltes();
		ariabookingHotels = ariaBooking.getHoltes();
		hotelyarHotels = hotelyar.getHoltes();
		iranHotelOnlineHotels = iranHotelOnline.getHoltes();
		eghamatHotels = eghamat.getHoltes();

		gatherAllHotelResultsToOneSet(pintapinHotels, hotelyarHotels, ariabookingHotels, iranHotelOnlineHotels,
				eghamatHotels);
		mergeHotelResults();
	}

	public void searchFlights() {

		List<Flight> ghasedak24Flights = new ArrayList<>();
//		List<Flight> alibabaFlights = new ArrayList<>();
//		List<Flight> mrbilitFlights = new ArrayList<>();
	//	List<Flight> airplainTicketFlights = new ArrayList<>();

		try {
//			alibaba = new Alibaba(information);
//			alibabaThread = new Thread(alibaba);
//			alibabaThread.start();

//			airlplainTicket = new AirplaneTicket(information);
//			airplainTicketThread = new Thread(airlplainTicket);
//			airplainTicketThread.start();

			ghasedak24 = new Ghasedak24(information);
			ghasedak24Thread = new Thread(ghasedak24);
			ghasedak24Thread.start();

//			mrbilit = new Mrbilit(information);
//			mrbilitThread = new Thread(mrbilit);
//			mrbilitThread.start();

//			airplainTicketThread.join();
//			mrbilitThread.join();
			ghasedak24Thread.join();
//			alibabaThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		ghasedak24Flights = ghasedak24.getFlights();
//		alibabaFlights = alibaba.getFlights();
//		mrbilitFlights = mrbilit.getFlights();
//		airplainTicketFlights = airlplainTicket.getFlights();

		gatherAllFlightResultsToOneSet(/*airplainTicketFlights, mrbilitFlights/*, alibabaFlights,*/ ghasedak24Flights);
		mergeFlightResults();
	}

	@SafeVarargs
	@SuppressWarnings("unchecked")
	private final void gatherAllHotelResultsToOneSet(List<Hotel>... hotels) {
		for (List<Hotel> list : hotels)
			if (list != null)
				this.hotels.addAll(list);
	}

	@SafeVarargs
	@SuppressWarnings("unchecked")
	private final void gatherAllFlightResultsToOneSet(List<Flight>... flights) {
		for (List<Flight> list : flights) {
			if (list != null)
				this.flights.addAll(list);
		}
	}

	private void mergeHotelResults() {
		MergeHotels mergeHotels = new MergeHotels(hotels);
		mergeHotels.startMerge();
		this.hotels.clear();
		this.hotels = mergeHotels.getMergedHotels();
	}

	private void mergeFlightResults() {
		MergeFlights mergeFlights = new MergeFlights(flights);
		mergeFlights.startMerge();
		this.flights.clear();
		this.flights = mergeFlights.getMergedFlights();
	}


}
