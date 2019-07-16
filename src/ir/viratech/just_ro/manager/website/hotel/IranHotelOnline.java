package ir.viratech.just_ro.manager.website.hotel;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import ir.viratech.just_ro.model.hotel.logic.HotelManager;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import ir.viratech.just_ro.model.hotel.Hotel;
import ir.viratech.just_ro.model.information.Information;
import ir.viratech.pond_ms.model.hotel.dao.HotelDAO;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class IranHotelOnline extends HotelsWebsites {
	WebDriver driver;
	public final static String iranHotelOnlineWebsiteKey = "iranhotelonline";
	Document doc;
	List<Double> prices = new ArrayList<>();
	double minPrice;

	public IranHotelOnline(Information information) {
		super(information);
	}
	public IranHotelOnline(){

	}

//	public void myStartScrape() {
//		try {
//			String url = myMakeUrl();
//			try {
//				doc = Jsoup.connect(url).proxy(getProxy()).userAgent(userAgent).method(Method.GET)
//						.referrer("https://www.iranhotelonline.com/")
//						.followRedirects(true).method(Method.GET).get();
//			} catch (Exception e) {
//				doc = Jsoup.connect(url).userAgent(userAgent).method(Method.GET)
//						.referrer("https://www.iranhotelonline.com/")
//						.followRedirects(true).method(Method.GET).get();
//			}
//			myFindPrice(doc, url);
//		} catch (Exception e) {
//			e.printStackTrace();
//			return;
//		}
//	}

//	private void myFindPrice(WebDriver driver, String link) {
//		String priceSelector = "body > div > div.search_item_bg > div.search_item > div.search_rooms > table > tbody";
//		Element priceElement = doc.select(priceSelector).get(0);
//		for (int i = 0; i < priceElement.children().size(); i++) {
//			if (i == 0)
//				continue;
//			String price = myGetPrice(priceElement.child(i));
//			if(price.equals("Full"))
//				continue;
//			else
//				this.prices.add(Double.parseDouble(price));
//		}
//		String minPrice = myFindLowestPrice();
//		System.out.println(minPrice);
//		String hotelName = HotelDAO.getInstance().getByName_iranhotelonline(information.getFaHotelName());
//		Hotel hotel = new Hotel(hotelName, "iranhotelonline", Double.parseDouble(minPrice) / 10, link);
//		System.out.println("done!");
//		addHotel(hotel);
//	}

	private String myFindLowestPrice() {
		double minPrice = this.prices.get(0);
		for (int i = 0; i < prices.size(); i++) {
			if (this.minPrice > prices.get(i)) {
				this.minPrice = prices.get(i);
				return String.valueOf(calculatePrice(this.minPrice));

			} else {
				continue;
			}
		}
		return String.valueOf(calculateFinalPrice(minPrice));
	}

	private String calculatePrice(double price) {

			double finalPrice = price * 1;//nights
			int ourRooms;
			if (1 % 2 == 0)//adults
				ourRooms = 1 / 2;//adults
			else
				ourRooms = (int) Math.floor(1 / 2) + 1;//adults
			if (ourRooms <= 1)//rooms
				finalPrice *= 1;//rooms
			else
				finalPrice *= ourRooms;

			return String.valueOf(finalPrice);
		}


	private String myGetPrice(WebElement webElement) {
		String price = null;
		String priceValue = null;
		String priceSelector = "body > div.container.inner-container > div.filter-page-body.clearfix > div.left-panel.col-sm-9.clearfix > div > div#div_result.box-view-hotel.clearfix > div.item-hotel.clearfix > div > div.room-table.clearfix > table.tb-room.hidden-xs > tbody > tr.tr-room > td.hidden-xs.text-center";
		String indeedPrice = "body > div.container.inner-container > div.filter-page-body.clearfix > div.left-panel.col-sm-9.clearfix > div > div#div_result.box-view-hotel.clearfix > div.item-hotel.clearfix > div > div.room-table.clearfix > table.tb-room.hidden-xs > tbody > tr.tr-room > td.hidden-xs.text-center > span.new-price";
		String oldPrice = "body > div.container.inner-container > div.filter-page-body.clearfix > div.left-panel.col-sm-9.clearfix > div > div#div_result.box-view-hotel.clearfix > div.item-hotel.clearfix > div > div.room-table.clearfix > table.tb-room.hidden-xs > tbody > tr.tr-room > td.hidden-xs.text-center > span.old-price";
		// doubt over childs in this method
		if (webElement.findElement(By.cssSelector(priceSelector)).getSize().equals(1)) {
			price = webElement.findElement(By.cssSelector(oldPrice)).getText();
			System.out.println("mygetprice if : " + price);
			priceValue = price.replace(",", "");
			return priceValue;
		} else {
			price = webElement.findElement(By.cssSelector(indeedPrice)).getText();
			System.out.println(webElement.findElement(By.cssSelector(indeedPrice)).getText());
			System.out.println("mygetprice else : " + price);
			priceValue = price.replace(",", "");
			return priceValue;
		}
	}

	private String myMakeUrl() throws IndexOutOfBoundsException, ArrayIndexOutOfBoundsException {
		String hotelCode = HotelDAO.getInstance().getCode_iranhotelonline(information.getFaHotelName());
		String url = "https://www.iranhotelonline.com/persian/search/?date=" + information.getCheckinDate() + "&span="
				+ information.getNights() + "&refer=home&hid=" + hotelCode;
		return url;
	}



	@Override
	public void startScrape() throws SocketTimeoutException {
		super.startScrape();
		try {

			Response response = Jsoup.connect("https://www.iranhotelonline.com/Persian/Cities/")
					.header("Host", "www.iranhotelonline.com").userAgent(userAgent)
					.header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
					.header("Accept-Language", "en-US,en;q=0.5").header("Accept-Encoding", "gzip, deflate, br")
					.referrer("https://www.iranhotelonline.com/").header("Connection", "keep-alive")
					.header("Upgrade-Insecure-Requests", "1").method(Method.GET).execute();

			System.out.println(this.getClass().getSimpleName() + " has been scraped");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	//**********************************************************************************************************************************
	//**********************************************************************************************************************************
	//**********************************************************************************************************************************
	public void updateHotelPrice(String uid , File file) {
		driver = new HtmlUnitDriver();
		try {
			driver.get("file://" + Files.readAllLines(file.toPath(), Charset.forName("utf-8")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		driver.getPageSource();
		System.out.println(driver.getPageSource());
		findPrice(driver);
		HotelManager mgr = new HotelManager();
		mgr.updateDB(findPrice(driver),uid , iranHotelOnlineWebsiteKey);
		file.delete();
	}
	public String getURL(String hotelName , String checkInDate , int night) throws IndexOutOfBoundsException, ArrayIndexOutOfBoundsException {
		String hotelCode = HotelDAO.getInstance().getCode_iranhotelonline(hotelName);
		String url = "https://www.iranhotelonline.com/persian/search/?date=" + checkInDate + "&span="
				+ night + "&refer=home&hid=" + hotelCode;
		return url;
	}

	private double findPrice(WebDriver driver){
		String priceSelector = ".tb-room > tbody:nth-child(2)";
		List<WebElement> priceList = driver.findElements(By.cssSelector(priceSelector));
		for (WebElement webElement : priceList) {
//			if (i == 0)
//				continue;
			String price = myGetPrice(webElement);
			System.out.println("find price : " + price);
			if(price.equals("Full"))
				continue;
			else
				this.prices.add(Double.parseDouble(price));
		}
		String minPrice = myFindLowestPrice();
		return Double.parseDouble(minPrice);
	}

}
