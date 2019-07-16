package ir.viratech.just_ro.manager.website.hotel;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import ir.viratech.just_ro.api.eghamat.EghamatResource;
import ir.viratech.just_ro.model.hotel.logic.HotelManager;
import ir.viratech.just_ro.model.website.dao.Eghamat24DAO;
import org.json.JSONObject;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import ir.viratech.just_ro.model.hotel.Hotel;
import ir.viratech.just_ro.model.hotel.Room;
import ir.viratech.just_ro.model.information.Information;
import ir.viratech.pond_ms.model.city.dao.CityDAO;
import ir.viratech.pond_ms.model.city.logic.CityMgr;
import ir.viratech.pond_ms.model.hotel.dao.HotelDAO;

public class Eghamat24 extends HotelsWebsites {

	public final static String eghamat24WebSiteKey = "eghamat24";
	private String hotelName;

	private HashMap<String, String> englishPersianCitiesMap = new HashMap<>();
	private List<Double> prices = new ArrayList<>();
	private Document document;
	private double minPrice;
	private String link;

	// default Constructor
	public Eghamat24() {

	}

	// starts scraping
	public void startScrape() throws SocketTimeoutException {
		super.startScrape();
		String url = makeURL();

		String queryString = "";
		Document document;
		try {
			document = Jsoup.connect(url).userAgent("Mozilla").get();
			findHotels(document);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void myStartScrape() {
		try {
			String url = myMakeURL();
			this.link = url;
			try {
				this.document = Jsoup.connect(url).proxy(getProxy()).userAgent(userAgent).get();
			} catch (Exception e) {
				this.document = Jsoup.connect(url).userAgent(userAgent).get();
			}
			myFindLowestPrice(document);
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
	}

	public void addScrapedHotelsFromAndroid(List<Hotel> hotels) {

	}

	public JsonNode getHotelsToScrapeForAndroid() {
        return  HotelDAO.getInstance().getHotelsToScrapeForAndroid(8);
    }

	private Eghamat24DAO getDAO() {
		return new Eghamat24DAO();
	}

	// constructor with fields of superclass
	public Eghamat24(Information information) {
		super(information);
	}

	public String myMakeURL() throws IndexOutOfBoundsException, ArrayIndexOutOfBoundsException{
		String enHotelName = HotelDAO.getInstance().getByName_eghamat24(information.getFaHotelName());
		String enCityName = CityDAO.getInstance().getByName_eghamat24(information.getPersianCityName());
		String url = "https://www.eghamat24.com/" + enCityName + "Hotels" + "/"
				+ enHotelName;
		return url;
	}

	public String getURL(String faCity , String hotelName) throws IndexOutOfBoundsException, ArrayIndexOutOfBoundsException{
		String enHotelName = HotelDAO.getInstance().getByName_eghamat24(hotelName);
		String enCityName = CityDAO.getInstance().getByName_eghamat24(faCity);
		String url = "https://www.eghamat24.com/" + enCityName + "Hotels" + "/"
				+ enHotelName;
		return url;
	}

	private void myFindLowestPrice(Document document) throws ArrayIndexOutOfBoundsException, IndexOutOfBoundsException{

		Element roomBox;

		String priceSelector = "body > main.main > div.page-wrapper > div#hotel_reservation > div.front_r > div.hotel_reservation_box.hotel_box_shadow > div.hotel_reservation_main.hotel_table_main > div.table.table_block.table_row_border > div.tbody";

		roomBox = document.select(priceSelector).get(0);
		try {
			myAddPrices(roomBox);
		} catch (ParseException e) {
			return;
		}
		myFindMinPrice();
		String name = information.getFaHotelName();
		hotel = new Hotel(name, "eghamat24", Double.parseDouble(myFindMinPrice()), this.link);
		addHotel(hotel);
	}

	private String getMyName(Element nameElement) {
		return nameElement.text().trim();
	}

	private String myFindMinPrice() throws ArrayIndexOutOfBoundsException, IndexOutOfBoundsException{
		this.minPrice = prices.get(0);
		for (double price : prices) {
			if (minPrice > price) {
				this.minPrice = price;
				return String.valueOf(calculateFinalPrice(minPrice));
			} else {
				continue;
			}
		}

		return String.valueOf(calculateFinalPrice(minPrice));
	}

	public JSONObject getByName(String name) {
		return new EghamatResource.EghamatDAO().getByName(name);
	}

	private void myAddPrices(Element roomBox) throws ParseException {
		for (int i = 0; i < roomBox.children().size(); i++) {
			try {
				Element roomInfo = roomBox.child(i);
				String price = getMyPrice(roomInfo);

				if(price.equals(Hotel.UNKNOWN_PRICE_FA))
					continue;

				String priceRemoveComma = price.replaceAll(",", "").replaceAll("-", "").trim();
				String priceRemoveToman = priceRemoveComma.replaceAll("تومان", "").trim();

				priceRemoveToman = priceRemoveToman.replaceAll("۰", "0");
				priceRemoveToman = priceRemoveToman.replaceAll("۱", "1");
				priceRemoveToman = priceRemoveToman.replaceAll("۲", "2");
				priceRemoveToman = priceRemoveToman.replaceAll("۳", "3");
				priceRemoveToman = priceRemoveToman.replaceAll("۴", "4");
				priceRemoveToman = priceRemoveToman.replaceAll("۵", "5");
				priceRemoveToman = priceRemoveToman.replaceAll("۶", "6");
				priceRemoveToman = priceRemoveToman.replaceAll("۷", "7");
				priceRemoveToman = priceRemoveToman.replaceAll("۸", "8");
				priceRemoveToman = priceRemoveToman.replaceAll("۹", "9");

				NumberFormat nf = NumberFormat.getInstance();
				double priceValue = nf.parse(priceRemoveToman).doubleValue();

				this.prices.add(priceValue);
			} catch (Exception e) {
				e.printStackTrace();
				continue;
			}

		}

	}

	private String getMyPrice(Element roomInfo) {
		if (roomInfo.select(
				"div.tr > section.td.td_five.table_grey.room_price > div.hotel_room_price > div.hotel_room_price_new.r_right > p")
				.size() > 0) {
			String price = roomInfo.select(
					"div.tr > section.td.td_five.table_grey.room_price > div.hotel_room_price > div.hotel_room_price_new.r_right > p")
					.text().trim();

			return price;
		} else {
			return Hotel.UNKNOWN_PRICE_FA;
		}
	}

	// makes url
	public String makeURL() {
		String checkinDate = getDateIn();
		String enName = HotelDAO.getInstance().getByName_eghamat24(information.getFaHotelName());
		return "https://www.eghamat24.com/search/" + information.getEnglishCityName() + "/" + enName + "Hotels" + "/"
				+ checkinDate + "/" + information.getNights();

	} // end of makeURL

	private String getDateIn() {
		String dateIn = information.getCheckinDate();
		dateIn = dateIn.substring(2);
		dateIn = dateIn.replaceAll("/", "-");
		return dateIn;
	}

	// finds hotels
	private void findHotels(Document document) {

		Element hotelBox;
		String hotelBoxCssSelector = "body > main > div.r_box.page_box.search_page > div > div "
				+ "> div.page_content_box > div.page_content_box_main";
		hotelBox = document.select(hotelBoxCssSelector).get(0);
		for (int i = 0; i < hotelBox.children().size(); i++) {

			try {

				// gets hotelNameInfo for every Hotel
				Element hotelNameInfo = getHotelNameInfo(hotelBox.child(i));
				// gets name for every hotel
				String name = getName(hotelNameInfo);
				// gets Link for every Hotel
				String link = getLink(hotelNameInfo);
				// gets address(location) for every Hotel
				String location = getLocation(hotelNameInfo);
				// gets rooms from a Hotel
				this.hotelName = name;
				List<Room> rooms = getHotelRooms(getRoomTags(hotelBox.child(i)));
				String id = information.getPersianCityName() + "-" + name;
				String lowestPrice = findLowestPrice(rooms);
				// int stars = findStars(hotelbox);
				Hotel hotel = new Hotel(id, name, "eghamat24", link, lowestPrice, 0);
				addHotel(hotel);

			} catch (NumberFormatException e) {
				continue;
			}

		}

	} // end of findHotels

	private String findLowestPrice(List<Room> rooms) {
		double[] prices = new double[rooms.size()];
		int counter = 0;
		for (Room room : rooms) {
			prices[counter] = Double.parseDouble(room.getPrice().replaceAll(",", ""));
			counter++;
		}
		double lowestPrice = prices[0];
		for (int i = 0; i < prices.length; i++) {
			if (prices[i] < lowestPrice) {
				lowestPrice = prices[i];
			}
		}
		return String.valueOf(lowestPrice);
	}

	// returns Element for link and name informations
	private Element getHotelNameInfo(Element hotelBoxChild) {
		return hotelBoxChild.child(0);
	}

	// returns name of a hotel
	private String getName(Element hotelNameInfo) {
		return hotelNameInfo.select("div.hotel_name_box > a").get(0).attr("title").trim();
	}

	// returns weblink of a hotel
	private String getLink(Element hotelNameInfo) {
		String link = hotelNameInfo.select("div.hotel_name_box > a").get(0).attr("href").trim();
		if (link.contains(" ")) {
			link = link.replace(" ", "%20");
		}
		return link;
	}

	// returns List of Rooms for a Hotel
	private List<Room> getHotelRooms(Elements hotelRoomsTags) throws NumberFormatException {
		List<Room> rooms = new ArrayList<>();
		int i = 000;
		for (Element roomTag : hotelRoomsTags) {
			int peopleNumber = getPeopleNumber(roomTag);
			String price = getPrice(roomTag);
			String type = getType(roomTag);
			boolean isAvilable = getIsAvilable(roomTag);
			boolean breakfast = getBreakfast(roomTag);
			boolean lunch = getLunchDinner(roomTag);
			boolean dinner = lunch;

			String id = information.getEnglishCityName() + "-" + hotelName + "-" + peopleNumber + i;
			i++;
			rooms.add(new Room(id, type, isAvilable, price, lunch, dinner, breakfast, peopleNumber, 0));
		}
		return rooms;
	}

	// returns true if the room from Hotel is avilablle
	private boolean getIsAvilable(Element roomTag) {
		String avilableText = roomTag.getElementsByTag("section").get(5).select("a > p").text();
		if (avilableText.contains("رزرو")) {
			return false;
		} else {
			return true;
		}
	}

	// returns capacity of a room from a Hotel
	private int getPeopleNumber(Element roomTag) {
		return roomTag.getElementsByTag("section").get(0).getElementsByTag("span").size();
	}

	// returns price of a room from Hotel
	private String getPrice(Element roomTag) throws NumberFormatException {
		String price = roomTag.getElementsByTag("section").get(4).select("div.hotel_room_price_new > p").text().trim();
		price = price.replaceAll("۰", "0");
		price = price.replaceAll("۱", "1");
		price = price.replaceAll("۲", "2");
		price = price.replaceAll("۳", "3");
		price = price.replaceAll("۴", "4");
		price = price.replaceAll("۵", "5");
		price = price.replaceAll("۶", "6");
		price = price.replaceAll("۷", "7");
		price = price.replaceAll("۸", "8");
		price = price.replaceAll("۹", "9");
		if (price.equals("") | price.equals(" ")) {
			throw new NumberFormatException("Not Found Price");
		} else {
			return price.replaceAll("تومان", "").trim();
		}
	}

	// returns boolean for breakfast of a room from Hotel
	private boolean getBreakfast(Element roomTag) {
		String hasBreakfast = roomTag.getElementsByTag("section").get(3).child(0).attr("class");
		if (hasBreakfast.equals("icon-correct.signal"))
			return true;
		else
			return false;
	}

	private boolean getLunchDinner(Element roomTag) {
		String hasLunchDinner = roomTag.getElementsByTag("section").get(3).child(1).attr("class");
		if (hasLunchDinner.equals("icon-close-2"))
			return false;
		else
			return true;
	}

	// returns type of room from Hotel
	private String getType(Element roomTag) {
		return roomTag.getElementsByTag("section").get(1).text().trim();
	}

	// returns address(location) of a hotel
	private String getLocation(Element hotelNameInfo) {
		return hotelNameInfo.select("div.hotel_other_info > p.hotel_address").get(0).text().trim();
	}

	// returns tags of rooms of a Hotel
	private Elements getRoomTags(Element hotelBoxChild) {
		return hotelBoxChild.select("div.hotel_box_reserve > div").get(0).child(0).child(1).select("div.tr");
	}

	private void fillEnglishPersianCitiesMap() throws IOException {
		englishPersianCitiesMap.put("خرم آباد", "Khorramabad");
		englishPersianCitiesMap.put("ساری", "Sari");
		englishPersianCitiesMap.put("قزوین", "Ghazvin");
		englishPersianCitiesMap.put("درود", "Dorud");
		englishPersianCitiesMap.put("خوی", "Khoy");
		englishPersianCitiesMap.put("خمین", "Khomeyn");
		englishPersianCitiesMap.put("عباس آباد", "Abbasabad");
		englishPersianCitiesMap.put("Amol", "آمل");
		englishPersianCitiesMap.put("قمصر", "Ghamsar");
		englishPersianCitiesMap.put("ماهان", "Mahan");
		englishPersianCitiesMap.put("تاکستان", "Takestan");
		englishPersianCitiesMap.put("بروجرد", "Borujerd");
		englishPersianCitiesMap.put("کرج", "Karaj");
		englishPersianCitiesMap.put("شاهرود", "Shahroud");
		englishPersianCitiesMap.put("اردبیل", "Ardabil");
		englishPersianCitiesMap.put("نور", "Nour");
		englishPersianCitiesMap.put("بانه", "Baneh");
		englishPersianCitiesMap.put("محمودآباد", "Mahmoudabad");
		englishPersianCitiesMap.put("شیروان", "Shirvan");
		englishPersianCitiesMap.put("کوهرنگ", "KoohranArakg");
		englishPersianCitiesMap.put("اراک", "Arak");
		englishPersianCitiesMap.put("اردکان", "Ardakan");
		englishPersianCitiesMap.put("شوشتر", "Shushtar");
		englishPersianCitiesMap.put("سرعین", "Sarein");
		englishPersianCitiesMap.put("لنگرود", "Langarud");
		englishPersianCitiesMap.put("آبادان", "Abadan");
		englishPersianCitiesMap.put("گنبدکاووس", "Gonbadkavus");
		englishPersianCitiesMap.put("رفسنجان", "Rafsanjan");
		englishPersianCitiesMap.put("کاشان", "Kashan");
		englishPersianCitiesMap.put("عسلویه", "Assaluyeh");
		englishPersianCitiesMap.put("قلعه گنج", "Ghalegang");
		englishPersianCitiesMap.put("بندر انزلی", "Bandaranzali");
		englishPersianCitiesMap.put("یاسوج", "Yasuj");
		englishPersianCitiesMap.put("چالوس", "Chalus");
		englishPersianCitiesMap.put("تنکابن", "Tonekabon");
		englishPersianCitiesMap.put("بابلسر", "Babolsar");
		englishPersianCitiesMap.put("فومن", "Fouman");
		englishPersianCitiesMap.put("ماکو", "Maku");
		englishPersianCitiesMap.put("تفت", "Taft");
		englishPersianCitiesMap.put("فیروزآباد", "Firouzabad");
		englishPersianCitiesMap.put("سیرجان", "Sirjan");
		englishPersianCitiesMap.put("فسا", "فسا");
		englishPersianCitiesMap.put("نکا", "Neka");
		englishPersianCitiesMap.put("مینودشت", "Minudasht");
		englishPersianCitiesMap.put("اسکو", "Oskou");
		englishPersianCitiesMap.put("خوانسار", "Khansar");
		englishPersianCitiesMap.put("اهواز", "Ahvaz");
		englishPersianCitiesMap.put("علی آبادکتول", "Aliabadekatol");
		englishPersianCitiesMap.put("رامسر", "Ramsar");
		englishPersianCitiesMap.put("مرودشت", "Marvdasht");
		englishPersianCitiesMap.put("نیشابور", "Nishapur");
		englishPersianCitiesMap.put("تبریز", "Tabriz");
		englishPersianCitiesMap.put("گرگان", "Gorgan");
		englishPersianCitiesMap.put("بناب", "Bonab");
		englishPersianCitiesMap.put("مهریز", "Mehriz");
		englishPersianCitiesMap.put("فردوس", "Ferdows");
		englishPersianCitiesMap.put("سراب", "Sarab");
		englishPersianCitiesMap.put("آمل", "Amol");
		englishPersianCitiesMap.put("نوشهر", "Noshahr");
		englishPersianCitiesMap.put("نائین", "Naeen");
		englishPersianCitiesMap.put("سمنان", "خلخال");
		englishPersianCitiesMap.put("Khansar", "Semnan");
		englishPersianCitiesMap.put("مریوان", "Marivan");
		englishPersianCitiesMap.put("شهرکرد", "Shahrekord");
		englishPersianCitiesMap.put("ماسوله", "Masuleh");
		englishPersianCitiesMap.put("سقز", "Saqqez");
		englishPersianCitiesMap.put("رودسر", "Rudsar");
		englishPersianCitiesMap.put("کیش", "Kish");
		englishPersianCitiesMap.put("چابهار", "Chabahar");
		englishPersianCitiesMap.put("قم", "Qhom");
		englishPersianCitiesMap.put("استهبان", "Estahban");
		englishPersianCitiesMap.put("الیگودرز", "Aligoodarz");
		englishPersianCitiesMap.put("میبد", "Meybod");
		englishPersianCitiesMap.put("یزد", "Yazd");
		englishPersianCitiesMap.put("لار", "Lar");
		englishPersianCitiesMap.put("محلات", "Mahalat");
		englishPersianCitiesMap.put("بیرجند", "Birgand");
		englishPersianCitiesMap.put("دماوند", "Damavand");
		englishPersianCitiesMap.put("مبارکه", "Mobarakeh");
		englishPersianCitiesMap.put("قائمشهر", "Qaemshahr");
		englishPersianCitiesMap.put("کردکوی", "Kordkuy");
		englishPersianCitiesMap.put("ارومیه", "Urmia");
		englishPersianCitiesMap.put("ایلام", "Ilam");
		englishPersianCitiesMap.put("خور و بیابانک", "Khurandbiabanak");
		englishPersianCitiesMap.put("بهشهر", "Behshahr");
		englishPersianCitiesMap.put("جلفا", "Julfa");
		englishPersianCitiesMap.put("مهاباد", "Mahabad");
		englishPersianCitiesMap.put("بجنورد", "Bojnurd");
		englishPersianCitiesMap.put("خلخال", "Khakhal");
		englishPersianCitiesMap.put("تالش", "Talesh");
		englishPersianCitiesMap.put("شیراز", "Shiraz");
		englishPersianCitiesMap.put("بوشهر", "Bushehr");
		englishPersianCitiesMap.put("اندیمشک", "Andimeshk");
		englishPersianCitiesMap.put("بندر عباس", "Bandareabbas");
		englishPersianCitiesMap.put("مراغه", "Maragheh");
		englishPersianCitiesMap.put("رشت", "Rasht");
		englishPersianCitiesMap.put("طبس", "Tabas");
		englishPersianCitiesMap.put("زنجان", "Zanjan");
		englishPersianCitiesMap.put("سبزوار", "Sabzevar");
		englishPersianCitiesMap.put("آباده", "Abadeh");
		englishPersianCitiesMap.put("داراب", "Darab");
		englishPersianCitiesMap.put("میناب", "Minab");
		englishPersianCitiesMap.put("ماسال", "Masal");
		englishPersianCitiesMap.put("گچساران ", "Gachsaran");
		englishPersianCitiesMap.put("کرمانشاه", "Kermanshah");
		englishPersianCitiesMap.put("بافق", "Bafgh");
		englishPersianCitiesMap.put("لاهیجان", "Lahijan");
		englishPersianCitiesMap.put("زاهدان", "Zahedan");
		englishPersianCitiesMap.put("ساوه", "Saveh");
		englishPersianCitiesMap.put("آستارا", "Astara");
		englishPersianCitiesMap.put("کلیبر", "Kalibar");
		englishPersianCitiesMap.put("دلیجان", "Delijan");
		englishPersianCitiesMap.put("تهران", "Tehran");
		englishPersianCitiesMap.put("دامغان", "Damghan");
		englishPersianCitiesMap.put("کرمان", "Kerman");
		englishPersianCitiesMap.put("رضوانشهر", "Rezvanshahr");
		englishPersianCitiesMap.put("سرخس", "Sarakhs");
		englishPersianCitiesMap.put("کلاردشت", "Kelardasht");
		englishPersianCitiesMap.put("آزادشهر", "Azadshahr");
		englishPersianCitiesMap.put("بم", "Bam");
		englishPersianCitiesMap.put("همدان", "Hamedan");
		englishPersianCitiesMap.put("ملایر", "Malayer");
		englishPersianCitiesMap.put("گلپایگان", "Golpaygan");
		englishPersianCitiesMap.put("سنندج", "Sanandaj");
		englishPersianCitiesMap.put("مشهد", "Mashhad");
		englishPersianCitiesMap.put("اصفهان", "Esfahan");

	}

	//*****************************************************************************************************************************************************
	//*****************************************************************************************************************************************************

	public void updateHotelPrice(String html, String uid) {

		this.document = Jsoup.parse(html);
		Element roomBox;
		String priceSelector = "body > main.main > div.page-wrapper > div#hotel_reservation > div.front_r > div.hotel_reservation_box.hotel_box_shadow > div.hotel_reservation_main.hotel_table_main > div.table.table_block.table_row_border > div.tbody";
		roomBox = document.select(priceSelector).get(0);
		try {
			myAddPrices(roomBox);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		HotelManager mgr = new HotelManager();
		mgr.updateDB(Double.parseDouble(findMinPrice()) , uid , eghamat24WebSiteKey);

	}

	private final String calculatePrice(double lowestPrice) {
		double finalPrice = lowestPrice * 1;//nights
		int ourRooms;
		if (1 % 2 ==0)//adults
			ourRooms = 1/2;//adults
		else
			ourRooms = (int) Math.floor(1 / 2) + 1;//aults
		if (ourRooms <= 1)//rooms
			finalPrice *= 1;//rooms
		else
			finalPrice *= ourRooms;

		return String.valueOf(finalPrice);
	}
	private String findMinPrice() throws ArrayIndexOutOfBoundsException, IndexOutOfBoundsException{
		this.minPrice = prices.get(0);
		for (double price : prices) {
			if (minPrice > price) {
				this.minPrice = price;
				return String.valueOf(calculatePrice(minPrice));
			} else {
				continue;
			}
		}

		return String.valueOf(calculatePrice(minPrice));
	}
}
