package ir.viratech.just_ro.model.information;

import ir.viratech.just_ro.model.calendar.CalendarTool;

public class Information {

	private String englishCityName;
	private String persianCityName;
	private String checkinDate;
	private String checkOutDate;
	private int nights;
	private int adults;
	private int children;
	private String srcPersianCityName;
	private boolean isRoundTrip;
	private int newBorns;
	private int rooms;
	private String faHotelName;
	private String flightClass;
	private int passengers;

    public Information(String city, String name) {
    	this.persianCityName = city;
    	this.faHotelName = name;
    }

    public String getFlightClass() {
		return flightClass;
	}

	public void setFlightClass(String flightClass) {
		this.flightClass = flightClass;
	}

	public Information() {

	}

	public Information(String persianCityName, String checkinDate, int nights, int adults, int children, int rooms) {
		this.persianCityName = persianCityName;
		this.checkinDate = checkinDate;
		this.nights = nights;
		this.adults = adults;
		this.children = children;
		this.setRooms(rooms);
	}

	public Information(String persianCityName, String faHotelName, String checkInDate, String nights, String adults,
			String children, int rooms) {
		this.persianCityName = persianCityName;
		this.setFaHotelName(faHotelName);
		this.checkinDate = checkInDate;
		this.nights = Integer.parseInt(nights);
		this.adults = Integer.parseInt(adults);
		this.children = Integer.parseInt(children);
		this.rooms = rooms;

	}

	// ONE WAY FLIGHTS -- new
	public Information(String srcPersianCityName, String persianCityName, String checkinDate, 
			String flightClass, int passengers, boolean isRoundTrip) {
		this.persianCityName = persianCityName;
		this.setSrcPersianCityName(srcPersianCityName);
		this.checkinDate = checkinDate;
		this.setCheckOutDate(checkOutDate);
		this.flightClass = flightClass;
		this.isRoundTrip = isRoundTrip;
		this.passengers = passengers;
	}

	// ONE WAY FLIGHTS
	public Information(String srcPersianCityName, String persianCityName, String checkinDate, String checkOutDate,
			int adults, int children, int newBorn, boolean isRoundTrip) {
		this.persianCityName = persianCityName;
		this.srcPersianCityName = srcPersianCityName;
		this.checkinDate = checkinDate;
		this.setCheckOutDate(checkOutDate);
		this.adults = adults;
		this.children = children;
		this.newBorns = newBorn;
		this.isRoundTrip = isRoundTrip;
	}

	// TWO WAY FLIGHTS
	public Information(String srcPersianCityName, String persianCityName, String checkinDate, int adults, int children,
			int newBorn, boolean isRoundTrip) {
		this.persianCityName = persianCityName;
		this.srcPersianCityName = srcPersianCityName;
		this.checkinDate = checkinDate;
		this.adults = adults;
		this.children = children;
		this.newBorns = newBorn;
		this.isRoundTrip = isRoundTrip;
	}

	public String getChechoutDate() {
		CalendarTool calendarTool = new CalendarTool();
		calendarTool.setIranianDate(checkinDate);
		calendarTool.nextDay(nights);
		int day = calendarTool.getIranianDay();
		int month = calendarTool.getIranianMonth();
		String checkoutDate = calendarTool.getIranianYear() + "/";
		if (month < 10) {
			checkoutDate += "0" + month + "/";
		} else {
			checkoutDate += month + "/";
		}
		if (day < 10) {
			checkoutDate += "0" + day;
		} else {
			checkoutDate += day;
		}
		return checkoutDate;
	}

	public String getEnglishCityName() {
		return englishCityName;
	}

	public void setEnglishCityName(String englishCityName) {
		this.englishCityName = englishCityName;
	}

	public String getPersianCityName() {
		return persianCityName;
	}

	public void setPersianCityName(String persianCityName) {
		this.persianCityName = persianCityName;
	}

	public String getCheckinDate() {
		return checkinDate;
	}

	public void setCheckinDate(String checkinDate) {
		this.checkinDate = checkinDate;
	}

	public int getNights() {
		return nights;
	}

	public void setNights(int nights) {
		this.nights = nights;
	}

	public int getAdults() {
		return adults;
	}

	public void setAdults(int adults) {
		this.adults = adults;
	}

	public int getChildren() {
		return children;
	}

	public void setChildren(int children) {
		this.children = children;
	}

	public String getSrcPersianCityName() {
		return srcPersianCityName;
	}

	public void setSrcPersianCityName(String srcPersianCityName) {
		this.srcPersianCityName = srcPersianCityName;
	}

	public boolean getIsRoundTrip() {
		return isRoundTrip;
	}

	public void setIsRoundTrip(Boolean isRoundTrip) {
		this.isRoundTrip = isRoundTrip;
	}

	public int getNewBorns() {
		return newBorns;
	}

	public void setNewBorns(int newBorns) {
		this.newBorns = newBorns;
	}

	public String getCheckOutDate() {
		CalendarTool calendarTool = new CalendarTool();
		calendarTool.setIranianDate(checkinDate);
		calendarTool.nextDay(nights);
		int day = calendarTool.getIranianDay();
		int month = calendarTool.getIranianMonth();
		String checkoutDate = calendarTool.getIranianYear() + "/";
		if (month < 10) {
			checkoutDate += "0" + month + "/";
		} else {
			checkoutDate += month + "/";
		}
		if (day < 10) {
			checkoutDate += "0" + day;
		} else {
			checkoutDate += day;
		}
		return checkoutDate;
	}

	public void setCheckOutDate(String checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	public int getRooms() {
		return rooms;
	}

	public void setRooms(int rooms) {
		this.rooms = rooms;
	}

	public String getFaHotelName() {
		return faHotelName;
	}

	public void setFaHotelName(String faHotelName) {
		this.faHotelName = faHotelName;
	}

	public int getPassengers() {
		return passengers;
	}

	public void setPassengers(int passengers) {
		this.passengers = passengers;
	}

}
