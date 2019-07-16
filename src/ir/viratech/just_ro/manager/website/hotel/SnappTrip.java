package ir.viratech.just_ro.manager.website.hotel;

import java.io.File;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;

import ir.viratech.just_ro.model.hotel.logic.HotelManager;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

import ir.viratech.just_ro.manager.cityChecker.CityChecker;
import ir.viratech.just_ro.model.calendar.CalendarTool;
import ir.viratech.just_ro.model.hotel.Hotel;
import ir.viratech.just_ro.model.hotel.Room;
import ir.viratech.just_ro.model.information.Information;
import ir.viratech.pond_ms.model.hotel.dao.HotelDAO;

public class SnappTrip extends HotelsWebsites {

    public final static String snapptripWebsiteKey = "snapptrip";
    WebDriver driver;

    private Document document;
    private String hotelName;
    private String link;

    private Document doc;
    // private String hotelName;
    List<Double> prices = new ArrayList<>();
    double minPrice = 0;
    Object objectCity = null;
    Object objectUrl = null;

    // constructors
    public SnappTrip() {

    }

    public SnappTrip(Information information) {
        super(information);
        fillHotelsCityNames();
    }

    protected void startScrape() throws SocketTimeoutException {
        super.startScrape();

        int connectionCounter = 0;
        while (true) {
            connectionCounter++;
            try {
                String url = makeURL();
                try {
                    document = Jsoup.connect(url).proxy(getProxy()).userAgent(userAgent).followRedirects(true)
                            .timeout(timeOut).get();
                } catch (Exception e) {
                    document = Jsoup.connect(url).userAgent(userAgent).followRedirects(true).timeout(timeOut).get();
                }
                int pageNumber = findPageNumber(document);
                findHotels();
                for (int i = 2; i <= pageNumber; i++) {
                    document = Jsoup.connect(url + "&page=" + i).timeout(timeOut).userAgent(userAgent).get();
                    findHotels();
                }

                break;
            } catch (IOException e) {
                if (connectionCounter < 4)
                    continue;
                else
                    break;
            }
        }

    }

    public void myStartScrape() {
        String url;

        try {

            url = myMakeUrl();

            // this.link = url;

            // doc = Jsoup.connect(url).userAgent(userAgent).header("Host",
            // "http://www.pintapin.com")
            // .header("Accept", "application/json, text/javascript, */*;
            // q=0.01")
            // .header("Accept-Encoding", "gzip, deflate,
            // br").header("Accept-Language", "en-US,en;q=0.5")
            // .header("X-Requested-With",
            // "XMLHttpRequest").header("Connection",
            // "Keep-Alive").referrer(refrrer)
            // .method(Method.GET).get();
//			System.setProperty("webdriver.gecko.driver", "/home/eric/geckodriver");
//			DesiredCapabilities desiredCapabilities = DesiredCapabilities.phantomjs();
//			desiredCapabilities.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
//					"/home/eric/phantomjs");
            //driver = new PhantomJSDriver(desiredCapabilities);
            driver = new HtmlUnitDriver();
            driver.get(url);


            myFindRoomWithLowestPrice(driver);
            getHotel().setLowestPriceValue(minPrice);
            driver.close();
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private Boolean checkFaUrl(String objectFaUrl) {
        String hotelName = information.getFaHotelName();
        String[] parts = hotelName.split(" ");

        String part0 = parts[0];

        String part1 = parts[1];

        String fa_url = part0 + "-" + part1;

        if (objectFaUrl.equals(fa_url)) {
            return true;
        } else
            return false;
    }

    private Boolean checkCityFaUrl(String objectCityUrl) {
        String hotelName = information.getFaHotelName();
        String[] parts = hotelName.split(" ");

        String part2 = parts[2];

        String city_fa_url = part2;

        if (objectCityUrl.equals(city_fa_url)) {
            return true;
        } else
            return false;
    }

    private String makeSearchUrl(Object objectUrl, Object objectCity) throws ParseException {

        String url = "https://www.pintapin.com/" + "رزرو-هتل" + "/" + objectCity + "/" + objectUrl + "?adults="
                + information.getAdults() + "&children_count=" + information.getChildren() + "&date_from="
                + getDateFrom() + "&date_to=" + getDateTo();
        this.link = url;
        return url;
    }

    private void myFindRoomWithLowestPrice(WebDriver driver) {

        System.out.println("pintapin\t" + information.getFaHotelName());
        Hotel hotel = null;
        // Elements roomBox;
        WebElement roomBox;
        // Element nameElement;
        // String roomBoxCssSelector = "body > div > main.content >
        // div.shuffle-animation > div.thebg.hotel-v2-detail-page >
        // div.container > div.row > div.col-md-7.col-xs-12 > div.row >
        // div.col-md-12 > div#hotel-rooms-container > div#hotel-change-date >
        // div#hotel-rooms-list-section";
        // String roomBoxCssSelector = "#hotel-rooms-list-section";

        roomBox = driver.findElement(By.cssSelector("#hotel-rooms-list-section"));
        myAddPrices(roomBox);
        myFindLowestPrice();
        // String nameCssSelector = "body > div > main#content >
        // div.shuffle-animation > div.thebg.hotel-v2-detail-page >
        // div.container > div.row > div.col-md-7.col-xs-12 > div#hotel-details
        // > div.hotel-header > div.title-container > div.row >
        // div.col-md-12.col-xs-12 > h1.title > a";
        // nameElement = doc.select(nameCssSelector).get(0);

        String name = information.getFaHotelName();
        hotel = new Hotel(name, "pintapin", Double.parseDouble(myFindLowestPrice()), this.link);
        addHotel(hotel);
    }

    private void test(WebDriver driver) {
        String priceSelector = "body > div > main.content > div.shuffle-animation > div.thebg.hotel-v2-detail-page > div.container > div.row > div.col-md-7.col-xs-12 > div.row > div.col-md-12 > div#hotel-rooms-container > div#hotel-change-date > div#hotel-rooms-list-section";
        Document document = Jsoup.parse(driver.getPageSource());
        System.out.println(document.select(priceSelector).
                get(0).
                child(1)
                .child(0)
                .child(2)
                .child(2)
                .child(1).
                        child(1).
                        child(0)
                .text());
    }

    private String myGetName(Element nameElement) {
        return nameElement.text().trim();
    }

    private String myFindLowestPrice() {
        this.minPrice = prices.get(0);
        for (int i = 0; i < prices.size(); i++) {
            if (this.minPrice > prices.get(i)) {
                this.minPrice = prices.get(i);
                System.out.println(this.minPrice);
                return String.valueOf(calculateFinalPrice(this.minPrice / information.getNights()));

            } else {
                continue;
            }
        }
        return String.valueOf(calculateFinalPrice(minPrice));
    }

    private void myAddPrices(WebElement roomBox) {

        List<WebElement> prices = driver.findElements(By.cssSelector(
                "div:nth-child(3) > div:nth-child(3) > div:nth-child(2) > div:nth-child(2) > span:nth-child(2)"));
        for (int i = 0; i < prices.size(); i++) {
            String price = prices.get(i).getText();
            double priceValue = Double.parseDouble(price.replace(",", "").trim());
            this.prices.add(priceValue);
        }
    }

    private String myGetPrice(Element roomInfo) {
        String price = roomInfo
                .select("div > div.item > div.detail > div.total-price > div.total. > div.low-price > span.span-prices")
                .text().trim();
        return price;
    }

    private String myMakeUrl() throws ParseException, NullPointerException {
        String hotelName = HotelDAO.getInstance().getByName_pintapin("هتل تارا مهاباد");
        for (int i = 0; i < hotelsCityNames.size(); i++) {

            if (hotelName.contains(hotelsCityNames.get(i))) {
                String name = hotelName.replace(hotelsCityNames.get(i), "");
                String nameHotel = name.trim().replace(" ", "-");
                String url = "https://www.pintapin.com/" + "رزرو-هتل" + "/" + hotelsCityNames.get(i) + "/" + nameHotel
                        + "?adults=" + information.getAdults() + "&date_from=" + getDateFrom() + "&date_to="
                        + getDateTo();
                System.out.println("pintapin url  :     " + url);
                return url;
            } else
                continue;
        }
        throw new NullPointerException();
    }

    // finds Hotel
    private void findHotels() throws HttpStatusException {
        Elements hotels = document.select(".hotels-data").get(0).getElementsByTag("li");
        for (Element hotelElem : hotels) {
            Element hotelElement = hotelElem.child(0);
            String name = findName(hotelElement);
            String lowestPrice = findLowestPrice(hotelElement);
            this.hotelName = name;
            String link = "";
            try {
                link = findLink(hotelElement);
            } catch (ParseException e) {
                continue;
            }
            String id = information.getPersianCityName() + "-" + name;
            int stars = findStars(hotelElement);
            Hotel hotel = new Hotel(id, name, "pintapin", link, lowestPrice, stars);
            addHotel(hotel);
        }
    }

    private int findStars(Element hotelElement) {
        int stars = hotelElement.child(1).child(0).child(1).children().size();
        return stars;
    }

    private String findLowestPrice(Element hotelElement) {
        String priceCssSelector = "div.hotel-details > div.price-part > div.price > div.new-price > span";
        long price = Integer.parseInt(hotelElement.select(priceCssSelector).text().replaceAll(",", "").trim());
        price = price / information.getNights();
        return String.valueOf(calculateFinalPrice(price));
    }

    // finds List<Room> of a Hotel
    private List<Room> findRooms(String link) throws IOException, HttpStatusException {
        Document doc = null;
        doc = Jsoup.connect(link).userAgent("Mozilla").followRedirects(true).get();
        List<Room> rooms = new ArrayList<>();
        int roomsSize;
        try {
            roomsSize = findNumberOfRooms(doc);
        } catch (NullPointerException e) {
            roomsSize = 0;
        }
        Element hotelRooms = doc.getElementById("hotel-rooms-list-section");
        for (int i = 0; i < roomsSize; i++) {
            Element hotelRoom = hotelRooms.child(i).child(0);
            String price = findRoomPrice(hotelRoom);
            boolean breakfast = hasBreakfast(hotelRoom);
            boolean lunch = false;
            boolean dinner = false;
            int peopleNumber = findPeopleNumber(hotelRoom);
            int extraPeople = 0;
            String type = findRoomType(hotelRoom);
            boolean isAvailable = true;
            String id = hotelNameRoom(doc) + "-" + type + "-" + peopleNumber;
            Room room = new Room(id, type, isAvailable, price, lunch, dinner, breakfast, peopleNumber, extraPeople);

            rooms.add(room);
        }

        return rooms;
    }

    // findsHotelName from RoomPage
    private String hotelNameRoom(Document doc) {
        return doc.select("h1.title > a:nth-child(1)").text().trim();
    }

    // finds type of a Room from a Hotel
    private String findRoomType(Element hotelRoom) {
        return hotelRoom.select("div.name > h4").text().trim();
    }

    // finds number of people in Room
    private int findPeopleNumber(Element hotelRoom) {
        return Integer.parseInt(hotelRoom.select("div.name > div.space").get(0).child(1).text().trim());
    }

    // has return boolean for breakfast
    private boolean hasBreakfast(Element hotelroom) {
        String hasBreakfastString = hotelroom.select("div.detail > div.include > div > span.breakfast").text().trim();

        if (hasBreakfastString.contains("صبحانه")) {
            return true;
        } else {
            return false;
        }

    }

    // finds room's price
    private String findRoomPrice(Element hotelRoom) {
        return hotelRoom.select("div.detail > div.total-price > div.total > div.low-price > span.span-prices")
                .attr("content").trim();
    }

    // finds number of rooms
    private int findNumberOfRooms(Document doc) throws NullPointerException {
        return doc.getElementById("hotel-rooms-list-section").children().size();
    }

    // finds link of a Hotel
    private String findLink(Element hotelElement) throws ParseException {
        String dateFrom = getDateFrom();
        String dateTo = getDateTo();
        String reserveFa = "رزرو";
        String hotelFa = "هتل";
        String baseUrl = "https://www.pintapin.com/" + reserveFa + "-" + hotelFa + "/"
                + information.getPersianCityName() + "/" + getHotelNameForRoomLink();
        String link = baseUrl + "?adults=" + information.getAdults() + "&date_from=" + dateFrom + "&date_to=" + dateTo
                + "&children_count=" + information.getChildren();
        return link;
    }

    //
    private String getHotelNameForRoomLink() {
        String removable = "-" + information.getPersianCityName();
        return hotelName.replaceAll(" ", "-").replace(removable, "");
    }

    // finds name of a Hotel
    private String findName(Element hotelElement) {
        return hotelElement.select("div.detail > h3").text().replaceAll("‌", " ").trim();
    }

    // finds Address of a Hotel
    private String findAddress(Element hotelElement) {
        return hotelElement.child(1).select("div.detail > address.address").text().trim();
    }

    // finds page numbers in firstPage
    private int findPageNumber(Document document) {
        int hotelNumbers = Integer.parseInt(document.select(".hotels-total > span:nth-child(1)").text());
        int pages = (int) Math.floor((hotelNumbers / 12) + 1);
        return pages;
    }

    // makes url based on user informations
    private String makeURL() {
        try {
            String dateFrom = getDateFrom();
            String dateTo = getDateTo();
            String reserveFa = "رزرو";
            String hotelFa = "هتل";
            String city = CityChecker.pintapin(information.getPersianCityName());
            String baseUrl = "https://www.pintapin.com/" + reserveFa + "-" + hotelFa + "/" + city;
            String url = baseUrl + "?adults=" + information.getAdults() + "&date_from=" + dateFrom + "&date_to="
                    + dateTo + "&children_count=" + information.getChildren();
            return url;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    // calculates dateFrom
    private String getDateFrom() throws ParseException {

        CalendarTool calendar = new CalendarTool();
        calendar.setIranianDate(information.getCheckinDate());
        String dateIn = calendar.getPinTaPinGregorianDate();
        return dateIn.replaceAll("/", "-");
    }

    // calculates dateTo :
    private String getDateTo() throws ParseException {
        CalendarTool calendar = new CalendarTool();
        calendar.setIranianDate(information.getCheckinDate());
        calendar.nextDay(information.getNights());
        return calendar.getPinTaPinGregorianDate().replaceAll("/", "-");
    }

    //********************************	*+***********************************************************
    //***********************************************************************************************
    //********************************   ************************************************************

    public void updateHotelPrice(String uid , File file) {

        driver = new HtmlUnitDriver();
        driver.get("/opt/PondMS/hotelsTmp.txt");
        driver.getPageSource();
        HotelManager mgr = new HotelManager();
        mgr.updateDB(findPrices(driver), uid, snapptripWebsiteKey);
        file.delete();
    }

    private Double findPrices(WebDriver driver) {

        WebElement roomBox = driver.findElement(By.cssSelector(priceSelector()));
        return priceList(roomBox);

    }

    private Double priceList(WebElement roomBox) {
        List<WebElement> priceList = driver.findElements(By.cssSelector(
                "#room_14 > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > span:nth-child(1)"));
        for (WebElement webElement : priceList) {
            Double price = getPrice(webElement);
            if (price == 0.0)
                continue;
            this.prices.add(price);
        }
        System.out.println("prices: " + prices.toString());
        return findMinPrice(prices);
    }

    private Double findMinPrice(List<Double> prices) {
        double price = prices.get(0);
        System.out.println("first price : " + price);
        for (Double priceValue : prices) {
            if (price > priceValue) {
                price = priceValue;
                System.out.println("price in for loop : " + price);
                return calculatePrice(price);
            } else {
                continue;
            }
        }
        System.out.println("calculated price : " + calculatePrice(price));
        return calculatePrice(price);
    }

    private Double calculatePrice(double price) {

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

        return finalPrice;
    }


    private Double getPrice(WebElement element) {
        Double priceValue = null;
        String priceString = "#room_14 > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > span:nth-child(1)";
        String price = element.findElement(By.cssSelector(priceString)).getText();
        if (price == null) {
            priceValue = 0.0;
            return priceValue;
        }
        priceValue = Double.parseDouble(price);
        return priceValue;
    }

    private String priceSelector() {
        return "#hotel-rooms-list-section";
    }

    public String getURL(String hotelName, String city, int adults, String checkInDate, String checkOutDate) {

        String baseUrl = "https://www.snapptrip.com/";
        String hotelTmp = hotelName.replaceAll(" ", "-");
        String checkIn = checkInDate.replaceAll("/", "-");
        String checkOut = checkOutDate.replaceAll("/", "-");
        return baseUrl + hotelTmp + "/" + city + "/" + "?-رزرو-هتل" + "adults=" + adults + "&date_from=" + checkIn + checkOut + "&date_to=" + checkOut;
    }
}
