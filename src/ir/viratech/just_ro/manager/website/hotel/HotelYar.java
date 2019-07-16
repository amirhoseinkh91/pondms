package ir.viratech.just_ro.manager.website.hotel;

import ir.viratech.just_ro.manager.cityChecker.CityChecker;
import ir.viratech.just_ro.model.hotel.Hotel;
import ir.viratech.just_ro.model.hotel.Room;
import ir.viratech.just_ro.model.information.Information;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HotelYar extends HotelsWebsites {
	private static Map<String, String> idCityMap;
	Document document;
	private String hotelName;
	private List<Double> priceList = new ArrayList<>();
	private double minPrice;
	private String hotelCode;
	WebDriver driver;
	List<Double> prices = new ArrayList<>();
	// TODO hotelyar search url http://hotelyar.com/index.php?query=هتل داریوش..

	static {
		idCityMap = new HashMap<>();
		fillIdCityMap();
	}

	// constructors
	public HotelYar() {

	}

	// constructor with fields
	public HotelYar(Information information) {
		super(information);
		getCityCode();
	}

	protected void myStartScrape() throws SocketTimeoutException {
		
		try {
			super.startScrape();
	
		String url = "http://hotelyar.com/hotel/1350/هتل-داریوش..-کیش";
		System.setProperty("webdriver.gecko.driver", "/home/eric/geckodriver");
		DesiredCapabilities desiredCapabilities = DesiredCapabilities.firefox();
		driver = new FirefoxDriver();
		driver.get(url);
		myFindRoomWithLowestPrice(driver);
//		try {
//			String searchUrl = myMakeUrl();
//
//			Response response = null;
//			response = Jsoup.connect(searchUrl).userAgent(userAgent).method(Method.GET).ignoreHttpErrors(true)
//					.followRedirects(false).execute();
//			System.out.println(response.hasHeader("location"));
//			String body = response.body().toString();
//			JSONArray jsonArray = new JSONArray(body);
//
//			for (int i = 0; i < jsonArray.length(); i++) {
//				JSONObject jsonObject = (JSONObject) jsonArray.get(i);
//				if (jsonObject.has("k") && jsonObject.has("n") && jsonObject.has("p")) {
//					String hotelWord = jsonObject.getString("k");
//					String hotelName = jsonObject.getString("n");
//					String hotelCity = jsonObject.getString("p");
//
//					String url = makeSearchUrl(hotelWord, hotelName, hotelCity);
//					System.out.println(url);
//					String request = myMakeRequestBody(hotelWord, hotelName, hotelCity);
//					System.out.println(request);
//					document = Jsoup.connect(url).header("Host", "hotelyar.com").userAgent(userAgent)
//							.method(Method.POST).header("Upgrade-Insecure-Requests", "1").referrer("http://hotelyar.com/")
//							.header("Accept-Language", "en-US,en;q=0.5").header("Content-Type", "application/x-www-form-urlencoded").requestBody(request).post();
//					System.out.println(document.outerHtml());
//					myFindPrice();
//				}
//			}
//
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (JSONException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		} catch (SocketTimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	private void myFindRoomWithLowestPrice(WebDriver driver)
	{
		Hotel hotel = null;
		WebElement roomBox;
		roomBox = driver.findElement(By.cssSelector(".hotel-table > tbody:nth-child(2)"));
		myAddPrices(roomBox);
	}
	
	private void myAddPrices(WebElement roomBox) {

		List<WebElement> prices = driver.findElements(By.cssSelector(
				".hotel-table > tbody:nth-child(2) > tr:nth-child(1) > td:nth-child(8) > span:nth-child(1) > br:nth-child(2)"));
		for (int i = 0; i < prices.size(); i++) {
			String price = prices.get(i).getText();
			double priceValue = Double.parseDouble(price.replace(",", "").trim());
			this.prices.add(priceValue);
			System.out.println(price + "     hotelYar");
		}
	}


	private String myMakeRequestBody(String hotelWord, String hotelName, String hotelCity) {
		String request = "city=&hotelCode=" + this.hotelCode + "&typeCode="  + hotelWord + "+" + hotelName + "+"
				+ hotelCity + "&fromDate=" + information.getCheckinDate() + "&toDate=" + information.getChechoutDate()
				+ "&withDetail=1";
		return request;
	}

	private void myFindPrice() {
		String priceSelector = "body > div.wrapper > di.container > div.container.searchpage-result > div.row > div.col-md-12 > ul.searchpage-list.single > li > article.hotel-list.single > div.hotel-list_stats > form#frmReserve > table.hotel-table > tbody";
		Element priceElement = this.document.select(priceSelector).get(0);

		for (int i = 0; i < priceElement.children().size(); i++) {
			String price = getPriceHotelYar(priceElement.child(i));
			double priceValue = Double.parseDouble(price);
			priceList.add(priceValue);
		}

		this.minPrice = Double.parseDouble(myFindMinPrice());
	}

	private String myFindMinPrice() {
		this.minPrice = priceList.get(0);
		for (int i = 0; i < priceList.size(); i++) {
			if (this.minPrice > priceList.get(i)) {
				this.minPrice = priceList.get(i);
				return String.valueOf(calculateFinalPrice(this.minPrice / information.getNights()));
			} else
				continue;
		}
		return null;
	}

	private String getPriceHotelYar(Element element) {
		return element.select("tr > td.hidden-xs.hidden-sm > span > br").text().trim();
	}

	private String makeSearchUrl(String hotelWord, String hotelName, String hotelCity) {
		// name of the hotel we should make for the url of the hotel
		String urlName = hotelCity + "-" + hotelName + "-" + hotelWord;
		// code of the hotel we get it from database
//		this.hotelCode = HotelDAO.getInstance().getByName_hotelYarCode(information.getFaHotelName());
//		String completeUrl = "http://hotelyar.com/hotel/" + hotelCode + "/" + urlName;
//		return completeUrl;
		return null;
	}

	private String myMakeUrl() {
//		String hotelName = HotelDAO.getInstance().getByName_hotelYarName(information.getFaHotelName());
//		System.out.println(hotelName + "dao name of hotel************");
//		String[] parts = hotelName.split(" ");
//		String part0 = parts[0];
//		String part1 = parts[1] + "..";
//		String part2 = parts[2];
//		String name = "http://hotelyar.com/index.php?query=" + part0 + " " + part1 + " " + part2;
//		System.out.println(name);
//		return name;
		return null;
	}

	public void startScrape() throws SocketTimeoutException {
		super.startScrape();
		int connectionCounter = 0;
		while (true) {
			connectionCounter++;
			try {

				String body = makeReqBody();
				String url = makeURL();
				System.out.println("hotelyar url : " + url);

				document = Jsoup.connect(url).header("Host", "hotelyar.com").userAgent(userAgent)
						.header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
						.header("Accept-Language", "en-US,en;q=0.5").header("Accept-Encoding", "gzip, deflate")
						.referrer("http://hotelyar.com").header("Content-Type", "application/x-www-form-urlencoded")
						.header("Connection", "keep-alive").header("Upgrade-Insecure_request", "1")
						.followRedirects(true).method(Method.POST).requestBody(body).timeout(timeOut).post();

				Response response = null;
				String responseBody = "";
				int counter = 0;
				while (true) {
					counter += 5;
					body = makeReqBody(counter);
					response = Jsoup.connect("http://hotelyar.com/cleanSearchContinue.php")
							.header("Host", "hotelyar.com").userAgent(userAgent).header("Accept", "*/*")
							.header("Accept-Language", "en-US,en;q=0.5").header("Accept-Encoding", "gzip, deflate")
							.header("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8")
							.header("X-Requested-With", "XMLHttpRequest").header("Content-Length", "150")
							.timeout(timeOut).referrer(url).header("Connection", "keep-alive").requestBody(body)
							.method(Method.POST).execute();
					if ((!response.body().contains("<div")) | response.body() == null)
						break;
					response.charset("UTF-8");
					responseBody = responseBody + "\n\n" + response.body();

				}
				document.select("#divContainer").get(0).append(responseBody);

				findHotels(document);

				System.out.println(this.getClass().getSimpleName() + " has been scraped");
				break;
			} catch (IOException e) {
				if (connectionCounter < 4)
					continue;
				else
					break;
			}
		}
	}

	private String makeReqBody(int i) {
		String reqBody = "difference=" + information.getNights() + "&fromDate=" + information.getCheckinDate()
				+ "&city=" + getCityCode().replaceAll("-", "") + "&orderBy=0&offset=" + i;
		return reqBody;
	}

	private String makeReqBody() {
		String reqBody;
		String[] dateParts = information.getCheckinDate().split("/");
		reqBody = "city=" + getCityCode().replaceAll("-", "") + "&slcHotel=0&fromDate=" + dateParts[0] + "/"
				+ dateParts[1] + "/" + dateParts[2] + "&difference=" + information.getNights() + "&group=1&";
		return reqBody;
	}

	private String getCityCode() throws NullPointerException {
		String cityName = information.getPersianCityName();
		return idCityMap.get(cityName);
	}

	// returns url of hotelyar.com
	public String makeURL() {
		String city = CityChecker.hotelyar(information.getPersianCityName());
		return "http://hotelyar.com/city/" + getCityCode().replaceAll("-", "") + "/هتلهای-" + city;
	}

	// finds hotels from hotelyar.com
	private void findHotels(Document document) {
		String hotelsBoxesCssSelector = "body > div.col-sm-offset-0.col-xs-12.col-sm-12.col-md-12 >"
				+ "div.content.container > table > tbody > tr > td div.panel.panel-default";

		Elements hotelsBoxes = document.select(hotelsBoxesCssSelector);
		for (Element hotelBox : hotelsBoxes) {

			Hotel hotel = null;
			try {
				// gets hotelNameInfo for every Hotel
				Element hotelNameInfo = getHotelNameInfo(hotelBox);
				// gets name for every hotel
				String name = getName(hotelNameInfo);
				// gets Link for every Hotel
				String link = getLink(hotelNameInfo);
				// gets address(location) for every Hotel
				String location = ""; // getLocation(hotelNameInfo);
				// gets rooms from a Hotel
				this.hotelName = name;
				List<Room> rooms = getHotelRooms(getRoomTags(hotelBox));
				String lowestPrice = findLowestPrice(rooms);
				String id = information.getPersianCityName() + "-" + name;
				int stars = findStars(hotelBox);
				hotel = new Hotel(id, name, "hotelyar", link, lowestPrice, stars);
				addHotel(hotel);
			} catch (Exception e) {
				// e.printStackTrace();
				continue;
			}

		}
	}

	private int findStars(Element hotelBox) {
		String starStr = hotelBox.child(0).child(0).child(1).child(0).child(0).attr("class");
		int stars = Integer.parseInt(starStr.substring(starStr.length() - 1));
		return stars;
	}

	private String findLowestPrice(List<Room> rooms) throws ArrayIndexOutOfBoundsException {
		int[] prices = new int[rooms.size()];
		int priceArrayCounter = 0;
		for (Room room : rooms) {
			if (room.getPrice().equals(" تومان ")) {
				continue;
			}
			try {
				prices[priceArrayCounter] = Integer.parseInt(
						room.getPrice().replaceAll(",", "").replaceAll(" تومان ", "").replaceAll(" ", "").trim());
				priceArrayCounter++;
			} catch (Exception e) {
				continue;
			}
		}
		long lowestPrice;
		try {
			lowestPrice = prices[0];
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new ArrayIndexOutOfBoundsException();
		}
		for (int i = 0; i < prices.length; i++) {
			if (prices[i] < lowestPrice) {
				lowestPrice = prices[i];
			}
		}
		lowestPrice = lowestPrice / information.getNights();
		return String.valueOf(calculateFinalPrice(lowestPrice));
	}

	// returns List<Room> from Hotel
	private List<Room> getHotelRooms(Elements hotelRoomsTags) {
		List<Room> rooms = new ArrayList<>();
		for (Element roomTag : hotelRoomsTags) {
			// String type = getType(roomTag);
			int peopleNumber;
			int extraPeople;
			boolean breakfast;
			boolean lunch;
			boolean dinner;
			String price;
			boolean isAvilable = true;
			try {
				peopleNumber = getPeopleNumber(roomTag);
				extraPeople = getExtraPeople(roomTag);
				breakfast = getBreakfast(roomTag);
				lunch = false;
				dinner = false;
				price = getPrice(roomTag);
			} catch (ArrayIndexOutOfBoundsException e) {
				continue;
			} catch (IndexOutOfBoundsException e) {
				continue;
			}

			String id = information.getEnglishCityName() + "-" + hotelName + "-" + peopleNumber;
			rooms.add(new Room(id, "", isAvilable, price, lunch, dinner , breakfast, peopleNumber, extraPeople));
		}
		return rooms;
	}

	// returns price(string) of room from Hotel
	private String getPrice(Element roomTag) {
		int size = roomTag.getElementsByTag("td").size();
		Element lastTag = roomTag.select("td:nth-child(" + size + ")").get(0);

		String price;
		if (lastTag.children().size() > 0) {
			price = lastTag.child(0).attr("price").trim();
			price = price.substring(0, price.length() - 1);
		} else {
			throw new ArrayIndexOutOfBoundsException();
		}
		return price + " تومان ";
	}

	// returns true if room has breakfast for free
	private boolean getBreakfast(Element roomTag) {
		String hasBreakfast = roomTag.select(":nth-child(1) > td:nth-child(5) > small").attr("alt").trim();
		if (!hasBreakfast.equals("صبحانه ندارد")) {
			return true;
		} else {
			return false;
		}
	}

	// returns extraPeopleNumber (int) for a room from Hotel
	private int getExtraPeople(Element roomTag) {
		String extPeopleStr = roomTag.select("td:nth-child(4)").get(0).text().trim();
		if (extPeopleStr.equals("-")) {
			return 0;
		} else {
			return new Integer(extPeopleStr).intValue();
		}
	}

	// returns peopleNumber (int) for a room from Hotel
	private int getPeopleNumber(Element roomTag) {
		return new Integer(roomTag.select("td:nth-child(3)").get(0).text().trim());
	}

	// returns Type of a Room from Hotel
	private String getType(Element roomTag) {
		return roomTag.select("td.text-right > b").get(0).text().trim();
	}

	// returns Tags for rooms of a Hotel
	private Elements getRoomTags(Element hotelBox) {
		return hotelBox.select("form > table > tbody > tr");
	}

	// returns Element containig hotel name information
	private Element getHotelNameInfo(Element hotelBox) {
		String hotelNameInfoSelector = "div > div.col-xs-12.col-sm-12.col-md-8 > h3 > a";
		return hotelBox.select(hotelNameInfoSelector).get(0);
	}

	private String getName(Element hotelNameInfo) {
		return hotelNameInfo.text().trim();
	}

	private String getLink(Element hotelNameInfo) {
		String link = hotelNameInfo.attr("href").trim();
		if (link.contains(" ")) {
			link = link.replace(" ", "%20");
		}
		return link;
	}

	private final static void fillIdCityMap() {
		idCityMap.put("مهاباد", "-143");
		idCityMap.put("رودسر", "-111");
		idCityMap.put("چمخاله", "-198");
		idCityMap.put("گچساران", "-164");
		idCityMap.put("محمود آباد", "-134");
		idCityMap.put("اردکان", "-162");
		idCityMap.put("قزوین", "-127");
		idCityMap.put("بروجرد", "-88");
		idCityMap.put("شیروان", "-177");
		idCityMap.put("علی آباد کتول", "-104");
		idCityMap.put("خلخال", "-52");
		idCityMap.put("یزد", "-29");
		idCityMap.put("نائین", "-103");
		idCityMap.put("بابلسر", "-117");
		idCityMap.put("تبریز", "-10");
		idCityMap.put("سیرجان", "-186");
		idCityMap.put("بم", "-132");
		idCityMap.put("سنندج", "-65");
		idCityMap.put("داران", "-79");
		idCityMap.put("بسطام", "-152");
		idCityMap.put("پاوه", "-129");
		idCityMap.put("بجنورد", "-87");
		idCityMap.put("خوی", "-74");
		idCityMap.put("نیاسر", "-189");
		idCityMap.put("اراک", "-1");
		idCityMap.put("ماکو", "-75");
		idCityMap.put("آزادشهر", "-174");
		idCityMap.put("بندرانزلی", "-106");
		idCityMap.put("خوانسار", "-93");
		idCityMap.put("دزفول", "-193");
		idCityMap.put("لار", "-85");
		idCityMap.put("یاسوج", "-99");
		idCityMap.put("شوشتر", "-105");
		idCityMap.put("عباس آباد", "-133");
		idCityMap.put("عسلویه", "-136");
		idCityMap.put("گلپایگان", "-77");
		idCityMap.put("خرم آباد", "-100");
		idCityMap.put("قم", "-55");
		idCityMap.put("کیش", "-23");
		idCityMap.put("قشم", "-32");
		idCityMap.put("فسا", "-83");
		idCityMap.put("اسکو", "-183");
		idCityMap.put("شاهرود", "-90");
		idCityMap.put("سبزوار", "-178");
		idCityMap.put("ماسوله", "-95");
		idCityMap.put("گرگان", "-62");
		idCityMap.put("سراب", "-156");
		idCityMap.put("شیراز", "-20");
		idCityMap.put("دیزین", "-131");
		idCityMap.put("سمنان", "-70");
		idCityMap.put("مازندران", "-21");
		idCityMap.put("طالقان", "-165");
		idCityMap.put("مشهد", "-27");
		idCityMap.put("زنجان", "-45");
		idCityMap.put("رفسنجان", "-185");
		idCityMap.put("کاشان", "-18");
		idCityMap.put("بوشهر", "-80");
		idCityMap.put("ارومیه", "-3");
		idCityMap.put("زاهدان", "-72");
		idCityMap.put("جلفا", "-73");
		idCityMap.put("گیلان", "-22");
		idCityMap.put("ایلام", "-97");
		idCityMap.put("نکا", "-142");
		idCityMap.put("چابهار", "-34");
		idCityMap.put("رشت", "-112");
		idCityMap.put("مشگین شهر", "-149");
		idCityMap.put("کردستان", "-57");
		idCityMap.put("بافق", "-200");
		idCityMap.put("فریدونکنار", "-203");
		idCityMap.put("تالش", "-141");
		idCityMap.put("دهلران", "-155");
		idCityMap.put("سپیدان", "-206");
		idCityMap.put("آبادان", "-94");
		idCityMap.put("سرعین", "-35");
		idCityMap.put("ماسال", "-202");
		idCityMap.put("دلیجان", "-204");
		idCityMap.put("اهواز", "-31");
		idCityMap.put("کلاچای", "-109");
		idCityMap.put("کردکوی", "-61");
		idCityMap.put("اصفهان", "-4");
		idCityMap.put("بناب", "-148");
		idCityMap.put("کرج", "-171");
		idCityMap.put("میبد", "-197");
		idCityMap.put("کرمان", "-30");
		idCityMap.put("تفت", "-126");
		idCityMap.put("نوشهر", "-119");
		idCityMap.put("شمشک", "-64");
		idCityMap.put("ابیانه", "-139");
		idCityMap.put("بیرجند", "-69");
		idCityMap.put("رامسر", "-115");
		idCityMap.put("ماهشهر", "-86");
		idCityMap.put("نور", "-120");
		idCityMap.put("همدان", "-28");
		idCityMap.put("ساوه", "-102");
		idCityMap.put("اردبیل", "-36");
		idCityMap.put("تهران", "-11");
		idCityMap.put("آستارا", "-108");
		idCityMap.put("بندرعباس", "-9");
		idCityMap.put("بابل", "-180");
		idCityMap.put("دامغان", "-89");
		idCityMap.put("کرمانشاه", "-58");
		idCityMap.put("مریوان", "-130");
		idCityMap.put("بهشهر", "-122");
		idCityMap.put("چابکسر", "-110");
		idCityMap.put("تنکابن", "-121");
		idCityMap.put("محلات", "-33");
		idCityMap.put("مینودشت", "-137");
		idCityMap.put("بانه", "-138");
		idCityMap.put("خوروبیابانک", "-92");
		idCityMap.put("ساری", "-118");
		idCityMap.put("شهرکرد", "-39");
		idCityMap.put("جهرم", "-212");
		idCityMap.put("مراغه", "-63");
		idCityMap.put("میاندوآب", "-145");
		idCityMap.put("میگون", "-68");
		idCityMap.put("لنگرود", "-113");
		idCityMap.put("نیشابور", "-188");
		idCityMap.put("لاهیجان", "-107");
		idCityMap.put("فیروزآباد", "-84");
		idCityMap.put("خمین", "-96");
		idCityMap.put("فومن", "-191");
		idCityMap.put("کلاردشت", "-54");
		idCityMap.put("ماهان", "-187");
		idCityMap.put("داراب", "-82");
		idCityMap.put("قلعه گنج", "-211");
		idCityMap.put("چالوس", "-114");
		idCityMap.put("آمل", "-123");
	}
}
