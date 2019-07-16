package ir.viratech.just_ro.manager.website.hotel;

import ir.viratech.just_ro.manager.cityChecker.CityChecker;
import ir.viratech.just_ro.model.calendar.CalendarTool;
import ir.viratech.just_ro.model.hotel.Hotel;
import ir.viratech.just_ro.model.hotel.logic.HotelManager;
import ir.viratech.just_ro.model.information.Information;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.text.ParseException;

public class AriaBooking extends HotelsWebsites {

    public static final String ariabookingwebSiteKey = "ariabooking";
    private Document document;
    private double minPrice;
    private String link;

    public AriaBooking() {

    }

    public AriaBooking(Information information) {
        super(information);
    }

    public void startScrape() throws SocketTimeoutException {
        super.startScrape();
        int connectionCounter = 0;
        while (true) {
            connectionCounter++;
            try {
                String url = makeURL();
                try {
                    document = Jsoup.connect(url + "&page=1").proxy(getProxy()).referrer("http://ariabooking.ir/")
                            .userAgent(userAgent).followRedirects(true).timeout(timeOut).get();
                } catch (Exception e) {
                    document = Jsoup.connect(url + "&page=1").referrer("http://ariabooking.ir/").userAgent(userAgent)
                            .followRedirects(true).timeout(timeOut).get();
                }

                int pageNumber = numberOfPages();
                findHotels();
                for (int i = 2; i <= pageNumber; i++) {
                    try {
                        document = Jsoup.connect(url + "&page=" + i).proxy(getProxy()).header("Host", "ariabooking.ir")
                                .header("Accept-Language", "en-US,en;q=0.5").referrer("http://ariabooking.ir/")
                                .userAgent(userAgent).followRedirects(true).timeout(timeOut).get();
                    } catch (Exception e) {
                        document = Jsoup.connect(url + "&page=" + i).header("Host", "ariabooking.ir")
                                .referrer("http://ariabooking.ir/").userAgent(userAgent).followRedirects(true)
                                .timeout(timeOut).get();
                    }

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
        try {
            Document doc;
            String url = myMakeURL();
            this.link = url;
            try {
                doc = Jsoup.connect(url).proxy(getProxy()).userAgent(userAgent).header("Host", "ariabooking.ir")
                        .referrer("http://ariabooking.ir/").userAgent(userAgent)
                        .followRedirects(true).timeout(timeOut).get();
            } catch (Exception e) {
                doc = Jsoup.connect(url).userAgent(userAgent).header("Host", "ariabooking.ir")
                        .referrer("http://ariabooking.ir/").userAgent(userAgent)
                        .followRedirects(true).timeout(timeOut).get();
            }


            myFindLowestPrice(doc);
        } catch (IOException e) {
            return;
        } catch (ParseException e) {
            return;
        } catch (NullPointerException e) {
            return;
        } catch (ArrayIndexOutOfBoundsException e) {
            return;
        } catch (IndexOutOfBoundsException e) {
            return;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void myFindLowestPrice(Document doc)
            throws ParseException, NullPointerException, ArrayIndexOutOfBoundsException, IndexOutOfBoundsException {
        Element generalInfo = doc
                .select("body > div#main.container > div.row > div.col-md-8.col-sm-12.col-xs-12 > div.hotel_info.row > div.hotel_main_info.col-md-9.col-xs-12.col-sm-9")
                .get(0);
        String price = myGetPrice(generalInfo);
        String name = myGetName(generalInfo);

        minPrice = Double.parseDouble(calculateFinalPrice(Double.parseDouble(price.trim())));
        if (minPrice == 0)
            return;
        hotel = new Hotel(name, "ariaBooking", minPrice / 10, this.link);
        addHotel(hotel);
    }

    private String myGetName(Element generalInfo) {
        return generalInfo.select("div.hotel_title.col-md-5.col-xs-12.col-xs-12.col-sm-5 > a").text().trim();
    }

    private String myGetPrice(Element generalInfo) {

        String price = "";
        if (generalInfo.select("div.hotel_price.col-md-4.col-xs-12.col-sm-4 > span.farsi > b > del").size() > 0) {
            generalInfo.select("div.hotel_main_info > div.hotel_price > span.farsi > b > del").get(0).remove();
            price = generalInfo.select("div.hotel_main_info > div.hotel_price > span.farsi > b").get(0).text().trim();
            String priceRemoveComma = price.replaceAll(",", "").trim();
            String priceRemoveSpace = priceRemoveComma.substring(2, priceRemoveComma.length());

            return priceRemoveSpace;
        }

        price = generalInfo.select("div.hotel_price.col-md-4.col-xs-12.col-sm-4 > span.farsi > b ").get(0).text()
                .trim();
        String priceRemoveComma = price.replaceAll(",", "").trim();
        return priceRemoveComma;
    }

    private String myMakeURL() {

        String url = "http://ariabooking.ir/hotel_search.php?keywords=";
        String dateIn = information.getCheckinDate().replaceAll("/", "-");
        String dateOut = information.getCheckOutDate().replaceAll("/", "-");
        url = url + information.getFaHotelName().replaceAll(" ", "+") + "+" + "&check_in2=" + dateIn
                + "&num_night_index=" + information.getNights() + "&check_out1=" + dateOut
                + "&btn_search_hotel_index=جستجو";

        return url;
    }

    public String getURL(String faHotelName, String checkIn, String checkOut, int night) {

        String url = "http://ariabooking.ir/hotel_search.php?keywords=";
        String dateIn = checkIn.replaceAll("/", "-");
        String dateOut = checkOut.replaceAll("/", "-");
        url = url + faHotelName.replaceAll(" ", "+") + "&check_in2=" + dateIn
                + "&num_night_index=" + night + "&check_out1=" + dateOut
                + "&btn_search_hotel_index=جستجو";

        return url;
    }

    private void findHotels() throws IOException {
        Elements hotelsBoxes = document.select("div.hotel_info.row");
        for (Element hotelBox : hotelsBoxes) {
            try {
                String name = findName(hotelBox);
                String lowestPrice = findLowestPrice(hotelBox);
                String link = findLink(hotelBox);
                String id = information.getPersianCityName() + "-" + name;
                int stars = findStars(hotelBox);
                Hotel hotel = new Hotel(id, name, "ariabooking", link, lowestPrice, stars);
                addHotel(hotel);
            } catch (Exception e) {
                continue;
            }
        }
    }

    private int findStars(Element hotelBox) {
        String starSrc = hotelBox.child(1).child(0).select("img").get(0).attr("src");
        int stars = Integer.parseInt(starSrc.substring(starSrc.length() - 5, starSrc.length() - 4));
        return stars;
    }

    private String findLink(Element hotelBox) {
        CalendarTool calendar = new CalendarTool();
        calendar.setIranianDate(information.getCheckinDate());
        String[] linkParts = hotelBox.select("div.hotel_main_info > div.hotel_title > a").get(0).attr("href").trim()
                .split("check_in1=");
        String linkPart1 = linkParts[0];
        String linkPart2 = "check_in1=" + calendar.getIranianDay() + " " + calendar.getIranianYear() + " "
                + calendar.getIranianMonthStr();
        String linkPart3 = "&check_in2=" + information.getCheckinDate().replaceAll("/", "-") + "&number_night="
                + information.getNights();

        calendar.nextDay(information.getNights());
        String linkPart4 = "&check_out1=" + information.getCheckOutDate().replaceAll("/", "-");
        String linkPart5 = "&check_out2=" + calendar.getIranianDay() + " " + calendar.getIranianYear() + " "
                + calendar.getIranianMonthStr();
        String link = linkPart1 + linkPart2 + linkPart3 + linkPart4 + linkPart5;
        return link;
    }

    private String findLowestPrice(Element hotelBox) {
        String priceCssSelector = "div.hotel_main_info > div.hotel_price > span.farsi > b";
        Element temp = hotelBox.select(priceCssSelector).get(0);
        if (temp.children().size() > 0)
            hotelBox.select("div.hotel_main_info > div.hotel_price > span.farsi > b > del").get(0).remove();
        int price;
        String priceString = hotelBox.select(priceCssSelector).get(0).text().replaceAll(",", "");
        price = Integer.parseInt(priceString) / 10;

        return String.valueOf(calculateFinalPrice(price));
    }

    private String findName(Element hotelBox) throws IOException {
        String name = hotelBox.select("div.hotel_main_info > div.hotel_title > a").get(0).text().trim();
        String[] nameParts = name.split(" ");
        if (isSameCity(name)) {
            return name;
        } else {
            throw new IOException(
                    nameParts[nameParts.length - 1] + " does not equals " + information.getPersianCityName());
        }
    }

    private boolean isSameCity(String hotelResponseName) {
        boolean isEqual = false;
        String responseCityName = "";
        String cityName = CityChecker.ariaBooking(information.getPersianCityName());
        String[] partsResponse = hotelResponseName.split(" ");

        for (int i = CityChecker.partsCounter(cityName, " "); i > 0; i--) {
            responseCityName = responseCityName.concat(partsResponse[partsResponse.length - i] + " ");
        }
        responseCityName = responseCityName.trim();

        if (responseCityName.equals(cityName)) {
            isEqual = true;
        }
        return isEqual;
    }

    private int numberOfPages() {
        int counter = 0;
        for (int i = 0; i < document.select("#pageingHolder").get(0).getElementsByTag("a").size(); i++) {
            if (!document.select("#pageingHolder").get(0).child(i).text().equals("")) {
                counter++;
            }
        }
        return counter;
    }

    private String makeURL() {
        String url = "http://ariabooking.ir/hotel_search.php?keywords=";
        String dateIn = information.getCheckinDate().replaceAll("/", "-");
        String city = CityChecker.ariaBooking(information.getPersianCityName());
        url = url + city + "&check_in2=" + dateIn + "&num_night_index=" + information.getNights();
        return url;
    }

    //************************************************************************************************************************************************
    //************************************************************************************************************************************************
    //************************************************************************************************************************************************

    public void updateHotelPrice(String html, String uid) {

        this.document = Jsoup.parse(html);
        Element generalInfo;
        Element hotelTitle;
        String newLink;
        try {

            hotelTitle = document.select(".hotel_title").first();

            generalInfo = document
                    .select("body > div#main.container > div.row > div.col-md-8.col-sm-12.col-xs-12 > div.hotel_info.row > div.hotel_main_info.col-md-9.col-xs-12.col-sm-9")
                    .get(0);
        } catch (IndexOutOfBoundsException e) {
            return;
        }
        String price = myGetPrice(generalInfo);
        minPrice = Double.parseDouble(calculatePrice(Double.parseDouble(price.trim())));
        if (minPrice == 0)
            return;
        HotelManager mgr = new HotelManager();
        mgr.updateDB(minPrice / 10, uid, ariabookingwebSiteKey);
    }

    private String calculatePrice(double lowestPrice) {
        double finalPrice = lowestPrice * 1;//getnights
        int ourRooms;
        if (1 % 2 == 0)//adults
            ourRooms = information.getAdults() / 2;//adults
        else
            ourRooms = (int) Math.floor(1 / 2) + 1; //adults
        if (ourRooms <= 1)//rooms
            finalPrice *= 1;//rooms
        else
            finalPrice *= ourRooms;

        return String.valueOf(finalPrice);
    }

}
