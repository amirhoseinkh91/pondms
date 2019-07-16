package ir.viratech.just_ro.manager.website.flight;

import java.util.HashMap;
import java.util.Map;

import ir.viratech.just_ro.api.flight.dto.config.FlightWebsiteRequestDTO;
import ir.viratech.just_ro.api.flight.dto.search.FlightSearchQueryDTO;
import ir.viratech.just_ro.manager.cityChecker.CityChecker;
import ir.viratech.just_ro.model.Website;
import ir.viratech.just_ro.model.flight.Flight;
import ir.viratech.just_ro.model.flight.exception.FlightCapacityMatchException;
import ir.viratech.just_ro.model.flight.exception.FlightClassMatchException;
import ir.viratech.just_ro.model.information.Information;

public abstract class FlightsWebsites extends Website {

	private static final Map<String, String> flightCityCodeMap;

	static {
		flightCityCodeMap = new HashMap<>();
		fillCityFlightCode();
	}

	public FlightsWebsites() {

	}

	public abstract FlightWebsiteRequestDTO getFlightWebsiteRequestDTO();

	public String getSourceCityCode(FlightSearchQueryDTO searchQueryDTO){
		return flightCityCodeMap.get(searchQueryDTO.getSource());
	}

	public String getDestCityCode(FlightSearchQueryDTO searchQueryDTO){
		return flightCityCodeMap.get(searchQueryDTO.getDestination());
	}

	public FlightsWebsites(Information information) {
		super(information);
		findSrcDstCodes();
	}

	private void findSrcDstCodes() {
		String srcCityName = information.getSrcPersianCityName();
		String dstCityName = information.getPersianCityName();
		this.srcCityCode = flightCityCodeMap.get(CityChecker.flights(srcCityName));
		this.destCityCode = flightCityCodeMap.get(CityChecker.flights(dstCityName));
	}

	protected String calculateFinalPrice(long lowestPrice) {
		long finalPrice = lowestPrice * information.getPassengers() / 10;
		return String.valueOf(finalPrice);

	}

	protected String convertCodeToPersianClass(String classCode) {
		final String[] buisnessClassCodes = { "C", "D", "J", "Z", "c", "d", "j", "z" };
		final String[] firstClassCodes = { "A", "F", "P", "R", "a", "f", "p", "r" };
		final String[] economyClassCodes = { "B", "E", "H", "K", "L", "M", "N", "Q", "S", "T", "V", "W", "X", "Y", "b",
				"e", "h", "k", "l", "m", "n", "q", "s", "t", "v", "w", "x", "y" };
		for (String code : buisnessClassCodes)
			if (classCode.contains(code))
				return Flight.BUISNESS_CLASS_FA;

		for (String code : economyClassCodes)
			if (classCode.contains(code))
				return Flight.ECONOMY_CLASS_FA;

		for (String code : firstClassCodes)
			if (classCode.contains(code))
				return Flight.FIRST_CLASS_FA;
		return Flight.UNKNOWN_CLASS_FA;
	}

	protected String findFlightClass(String flightClass) throws FlightClassMatchException {
		try {
			if (flightClass.contains("اکونومی")) {
				if (flightClassHandler(Flight.ECONOMY_CLASS_FA))
					return Flight.ECONOMY_CLASS_FA;
			} else if (flightClass.contains("بیزنس")) {
				if (flightClassHandler(Flight.BUISNESS_CLASS_FA))
					return Flight.BUISNESS_CLASS_FA;
			} else if (flightClass.contains("فرست")) {
				if (flightClassHandler(Flight.FIRST_CLASS_FA))
					return Flight.FIRST_CLASS_FA;
			} else if (flightClass.equals(Flight.UNKNOWN_CLASS_FA)) {
				return Flight.UNKNOWN_CLASS_FA;
			} else {
				throw new FlightClassMatchException();
			}
		} catch (Exception e) {
			return Flight.UNKNOWN_CLASS_FA;
		}
		throw new FlightClassMatchException();
	}
	
	protected void checkCapacity(int capacity) throws FlightCapacityMatchException {
		if (capacity < 1) //passangers
			throw new FlightCapacityMatchException();
	}
	
	protected boolean flightClassHandler(String flightClass) {
		if (flightClass.contains(information.getFlightClass()) || information.getFlightClass().equals(Flight.ALL_FLIGHT_CLASSES))
			return true;
		return false;
	}
	
	protected String dateChecker(String date) {
		StringBuilder builder = new StringBuilder();
		String[] parts = date.split("/");
		int day = Integer.parseInt(parts[2]);
		int month = Integer.parseInt(parts[1]);
		builder.append(parts[0] + "/");
		if (month < 10)
			builder.append("0" + month + "/");
		else
			builder.append(month + "/");
		
		if (day < 10)
			builder.append("0" + day);
		else
			builder.append(day);
		return builder.toString();
	}
	
	protected String changePersianToEnglishNum(String engNum) {
		final String[] englishNums = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };
		final String[] persianNums = { "۰", "۱", "۲", "۳", "۴", "۵", "۶", "۷", "۸", "۹" };
		for (int i = 0; i < persianNums.length; i++) {
			if (engNum.equals(persianNums[i]))
				engNum = engNum.replaceAll(persianNums[i], englishNums[i]);
		}
		return engNum;
	}
	
	private static final void fillCityFlightCode() {
		flightCityCodeMap.put("کلاله", "KLM");
		flightCityCodeMap.put("گچساران", "GCH");
		flightCityCodeMap.put("آبادان", "ABD");
		flightCityCodeMap.put("لارستان", "LRR");
		flightCityCodeMap.put("یزد", "AZD");
		flightCityCodeMap.put("بابلسر", "BBL");
		flightCityCodeMap.put("اهواز", "AWZ");
		flightCityCodeMap.put("تبریز", "TBZ");
		flightCityCodeMap.put("سیرجان", "SYJ");
		flightCityCodeMap.put("جم", "TEW");
		flightCityCodeMap.put("طبس", "TCX");
		flightCityCodeMap.put("اصفهان", "IFN");
		flightCityCodeMap.put("بم", "BXR");
		flightCityCodeMap.put("سنندج", "SDG");
		flightCityCodeMap.put("کرمان", "KER");
		flightCityCodeMap.put("ابوموسی", "AEU");
		flightCityCodeMap.put("بجنورد", "BJB");
		flightCityCodeMap.put("نوشهر", "NSH");
		flightCityCodeMap.put("لاوان", "LVP");
		flightCityCodeMap.put("بیرجند", "XBJ");
		flightCityCodeMap.put("ماهشهر", "MRX");
		flightCityCodeMap.put("رامسر", "RZR");
		flightCityCodeMap.put("اراک", "AJK");
		flightCityCodeMap.put("دزفول", "DEF");
		flightCityCodeMap.put("همدان", "HDM");
		flightCityCodeMap.put("یاسوج", "YES");
		flightCityCodeMap.put("خوى", "KHY");
		flightCityCodeMap.put("تهران", "THR");
		flightCityCodeMap.put("اردبیل", "ADU");
		flightCityCodeMap.put("عسلویه", "PGU");
		flightCityCodeMap.put("بندرعباس", "BND");
		flightCityCodeMap.put("خرم آباد", "KHD");
		flightCityCodeMap.put("کرمانشاه", "KSH");
		flightCityCodeMap.put("کیش", "KIH");
		flightCityCodeMap.put("قشم", "GSM");
		flightCityCodeMap.put("لامرد", "LFM");
		flightCityCodeMap.put("شاهرود", "RUD");
		flightCityCodeMap.put("سبزوار", "AFZ");
		flightCityCodeMap.put("گرگان", "GBT");
		flightCityCodeMap.put("ایرانشهر", "IHR");
		flightCityCodeMap.put("شیراز", "SYZ");
		flightCityCodeMap.put("پارس آباد", "PFQ");
		flightCityCodeMap.put("بندر لنگه", "BDH");
		flightCityCodeMap.put("سارى", "SRY");
		flightCityCodeMap.put("مشهد", "MHD");
		flightCityCodeMap.put("شهرکرد", "CQD");
		flightCityCodeMap.put("زنجان", "JWN");
		flightCityCodeMap.put("جهرم", "JAR");
		flightCityCodeMap.put("مراغه", "ACP");
		flightCityCodeMap.put("رفسنجان", "RJN");
		flightCityCodeMap.put("بوشهر", "BUZ");
		flightCityCodeMap.put("ارومیه", "OMH");
		flightCityCodeMap.put("جیرفت", "JYR");
		flightCityCodeMap.put("زاهدان", "ZAH");
		flightCityCodeMap.put("زابل", "ACZ");
		flightCityCodeMap.put("ایلام", "IIL");
		flightCityCodeMap.put("چابهار", "ZBR");
		flightCityCodeMap.put("رشت", "RAS");
	}
}
