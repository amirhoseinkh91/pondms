package ir.viratech.just_ro.manager.merge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import ir.viratech.just_ro.model.flight.Flight;
import ir.viratech.just_ro.model.lowestprice.LowestPrice;

public class MergeFlights {

	private Set<Flight> flights = new HashSet<>();
	private Set<Flight> mergedFlights = new HashSet<>();
	LowestPrice lowestPrice;

	public MergeFlights(Set<Flight> flights) {
		this.flights = flights;
	}

	public void startMerge() {
		mergePrices();
	}

	private void mergePrices() {
		Set<String> flightsID = new HashSet<>();
		for (Flight flight : flights) {
			flightsID.add(flight.getId());
			
		}

		for (String flightId : flightsID) {
			// before
			// Flight mergedFlight = new Flight();
			/*
			 * TODO make an array of flights named tempFlightsList! in this list
			 * , equal flights should be added from different websites! then,
			 * Flight with lowest Price from this list should be added to
			 * mergedFlights after below for loop!
			 */
			// now
			List<Flight> tempFlightList = new ArrayList<>();

			// before
			/*
			 * List<LowestPrice> lowestPrices = new ArrayList<>(); String
			 * flightCompany; String flightNumber; String flightClass; String
			 * isCharter; String date; String capacity; String time; String
			 * price;
			 */
			for (Flight flight : flights) {


				if (isEqual(flight, flightId)) {
					/*
					 * TODO here , flight object must be added to tempFlightList
					 * then inside for loop is done! after for loop, a method is
					 * required to find and return Flight with lowestPrice in
					 * tempFlightList..!
					 */
					// now
					tempFlightList.add(flight);


					// before
					/*
					 * flightNumber = flight.getFlightNumber(); flightCompany =
					 * flight.getFlightCompany(); flightClass =
					 * flight.getFlightClass(); isCharter =
					 * flight.getIsCharter(); date = flight.getDate(); capacity
					 * = flight.getCapacity(); time = flight.getTime();
					 * 
					 * mergedFlight.setFlightCompany(flightCompany);
					 * mergedFlight.setFlightNumber(flightNumber);
					 * mergedFlight.setFlightClass(flightClass);
					 * mergedFlight.setDate(date);
					 * mergedFlight.setCapacity(capacity);
					 * mergedFlight.setIsCharter(isCharter);
					 * mergedFlight.setDate(date); mergedFlight.setTime(time);
					 * mergedFlight.setCompanyCode(flight.getCompanyCode(
					 * mergedFlight.airlineChecker(flightCompany))); price =
					 * flight.getPrice(); if (price.equals(0)) continue; String
					 * link = flight.getLink(); String host = flight.getHost();
					 * lowestPrices.add(new LowestPrice(price, host, link));
					 */
				}
				// before
				// mergedFlight.setLowestPrices(lowestPrices);
			}

			/*
			 * here is metod to find Flight with lowest price and returns it,
			 * then that flight will add to mergedFlightsList. then its done!...
			 * YAY...
			 */
			// now
			mergedFlights.add(getFLightWithLowestprice(tempFlightList));
		}

			// before
			// mergedFlights.add(mergedFlight);
		}
	

	private final Flight getFLightWithLowestprice(List<Flight> tempFlightList) {
		// key is index from for! value is price of the flight with related
		// index
		Map<Integer, Double> pricesMap = new HashMap<Integer, Double>();
		for (int i = 0; i < tempFlightList.size(); i++)
			pricesMap.put(i, Double.parseDouble(tempFlightList.get(i).getPrice()));
		Flight f = tempFlightList.get(getIndexOfLowestPriceFlight(pricesMap));
		// now that we have flight with lowest price, add other sites data to
		// this flight!!!
		List<LowestPrice> lowestPrices = new ArrayList<>();
		lowestPrices.add(new LowestPrice(f.getPrice(), f.getHost(), f.getLink()));

		f.setLowestPrices(lowestPrices);
		return f;
	}

	private int getIndexOfLowestPriceFlight(Map<Integer, Double> pricesMap) {
		double max_price = 9000000000.0;
		int minPriceIndex = 0;
		for (Integer index : pricesMap.keySet()) {
			Double price = pricesMap.get(index);
			if (price <= max_price && price > 0) {
				max_price = price;
				minPriceIndex = index;
			}
		}
		return minPriceIndex;
	}

	private boolean isEqual(Flight flight, String flightId) {
		String[] parts = flightId.split(" ");
		String flightNumberFromId = parts[0];
		String flightTimeFromId = parts[1];

		boolean isSameFlightNumber = isSameFlightNumber(flight, flightNumberFromId);
		boolean isSameTime = flight.getTime().equals(flightTimeFromId);
		if (isSameTime && isSameFlightNumber)
			return true;
		return false;
	}

	private boolean isSameFlightNumber(Flight flight, String flightNumberFromId) {
		if (flightNumberFromId.endsWith(flight.getFlightNumber())
				|| flight.getFlightNumber().endsWith(flightNumberFromId)
				|| flight.getFlightNumber().equals(flightNumberFromId))
			return true;
		return false;
	}

	public Set<Flight> getMergedFlights() {
		return mergedFlights;
	}
}
