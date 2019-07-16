package ir.viratech.just_ro.manager.website.flight;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import ir.viratech.just_ro.api.flight.dto.config.ServerRequest;
import ir.viratech.just_ro.api.flight.dto.flight.FlightDTO;
import ir.viratech.just_ro.api.flight.dto.flight.FlightResponseDTO;
import ir.viratech.just_ro.api.flight.dto.config.FlightWebsiteRequestDTO;
import ir.viratech.just_ro.api.flight.dto.config.PathParamQueryDTO;
import ir.viratech.just_ro.api.flight.dto.search.FlightSearchQueryDTO;
import ir.viratech.just_ro.manager.website.flight.flight_utils.FlightClassUtil;
import ir.viratech.just_ro.manager.website.flight.flight_utils.FlightCompanyUtil;
import ir.viratech.just_ro.model.calendar.CalendarTool;
import org.apache.commons.collections.map.HashedMap;
import org.jsoup.Connection.Method;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import ir.viratech.just_ro.model.flight.Flight;
import ir.viratech.just_ro.model.flight.exception.FlightCapacityMatchException;
import ir.viratech.just_ro.model.flight.exception.FlightClassMatchException;
import ir.viratech.just_ro.model.information.Information;

public class Ghasedak24 extends FlightsWebsites {

    private Document document;
    String url;

    public Ghasedak24(Information information) {
        super(information);
    }

    public Ghasedak24() {

    }

    @Override
    public FlightWebsiteRequestDTO getFlightWebsiteRequestDTO() {
        ServerRequest serverRequest = new ServerRequest();
        makeServerRequest(serverRequest);
        FlightWebsiteRequestDTO flightWebsiteRequestDTO = new FlightWebsiteRequestDTO();
        flightWebsiteRequestDTO.setServerRequest(serverRequest);
        flightWebsiteRequestDTO.setBaseUrl("https://ghasedak24.com/search/flight");
        flightWebsiteRequestDTO.setHttpMethod(FlightWebsiteRequestDTO.HttpMethod.GET);
        flightWebsiteRequestDTO.setRequestBody(false);
        flightWebsiteRequestDTO.setPathParamQuery(getPathParamQueries());
        flightWebsiteRequestDTO.setQueryTypeList(makeQueryType());
        return flightWebsiteRequestDTO;
    }

    private List<FlightWebsiteRequestDTO.QueryType> makeQueryType() {
        List<FlightWebsiteRequestDTO.QueryType> queryTypes = new ArrayList<>();
        queryTypes.add(FlightWebsiteRequestDTO.QueryType.PathParam);
        return queryTypes;
    }


    private void makeServerRequest(ServerRequest serverRequest) {

        serverRequest.setApi("/api/v1/flight/ghasedak24");
        serverRequest.setMethod(String.valueOf(ServerRequest.Method.Post));
        Map<String, String> map = new HashedMap();
        map.put("Content-Type", "text/html");
        serverRequest.setRequestHeaders(map);
    }


    public List<PathParamQueryDTO> getPathParamQueries() {
        List<PathParamQueryDTO> pathParamQueryDTOS = new ArrayList<>();
        pathParamQueryDTOS.add(0, getSrcDst());
        pathParamQueryDTOS.add(1, getDepartureDate());
        pathParamQueryDTOS.add(2, getPassengers());
        return pathParamQueryDTOS;
    }

    public PathParamQueryDTO getPassengers() {
        List<String> keys = new ArrayList<>();
        keys.add("Adults");
        keys.add("Children");
        keys.add("Infant");
        PathParamQueryDTO pathParamQueryDTO = new PathParamQueryDTO();
        pathParamQueryDTO.setPlace(3);
        pathParamQueryDTO.setPatternSplitter("-");
        pathParamQueryDTO.setKeys(keys);
        pathParamQueryDTO.setPattern("Adults-Children-Infant");
        return pathParamQueryDTO;
    }

    public PathParamQueryDTO getDepartureDate() {
        List<String> keys = new ArrayList<>();
        keys.add("DepartureDate");
        PathParamQueryDTO pathParamQueryDTO = new PathParamQueryDTO();
        pathParamQueryDTO.setPlace(2);
        pathParamQueryDTO.setPattern("DepartureDate");
        pathParamQueryDTO.setPatternSplitter(null);
        pathParamQueryDTO.setKeys(keys);
        pathParamQueryDTO.setDateFormat("yyyy-mm-dd");
        pathParamQueryDTO.setDateFormatSplitter("-");
        pathParamQueryDTO.setUseEnglishDate(false);
        pathParamQueryDTO.setUsePersianDate(true);
        return pathParamQueryDTO;
    }

    public PathParamQueryDTO getSrcDst() {
        List<String> keys = new ArrayList<>();
        keys.add("SrcCity");
        keys.add("DstCity");
        PathParamQueryDTO pathParamQueryDTO = new PathParamQueryDTO();
        pathParamQueryDTO.setPlace(1);
        pathParamQueryDTO.setPattern("from-to");
        pathParamQueryDTO.setPatternSplitter("-");
        pathParamQueryDTO.setKeys(keys);
        pathParamQueryDTO.setCityCode(true);
        pathParamQueryDTO.setPersianCityName(false);
        pathParamQueryDTO.setEnglishCityName(false);
        return pathParamQueryDTO;
    }

    public void makeUrl(FlightSearchQueryDTO searchQueryDTO) {
        FlightsWebsites websites = new Ghasedak24();
        String baseUrl = "https://ghasedak24.com/search/flight/";
        String srcDstCity = searchQueryDTO.getSource() + "-" + searchQueryDTO.getDestination();
        String dateTmp = searchQueryDTO.getPersianDate();
        String date = dateTmp.replaceAll("/", "-");
        String passangers = searchQueryDTO.getAdults() + "-" + searchQueryDTO.getChildren() + "-" + searchQueryDTO.getInfants();
        this.url = baseUrl + srcDstCity + "/" + date + "/" + passangers;
    }

    public FlightResponseDTO getFlightDTOList(String html) {
        this.document = Jsoup.parse(html);
        return getDTOFlights(document);
    }

    private FlightResponseDTO getDTOFlights(Document doc) {

        return findFlightsDTO(doc);
    }

    private FlightResponseDTO findFlightsDTO(Document doc) {

        List<FlightDTO> flightDTOS = new ArrayList<>();
        Element flightBox;
        String flightBoxAddress = "body > div.result-wrap > div.container > div.row > div.col-md-12 > div.panel.panel-default > div#search-results > div.list-group-item > div.row > div.col-md-9.col-sm-9.col-xs-12 > div#search-results";
        FlightResponseDTO responseDTO = new FlightResponseDTO();
        flightBox = doc.select(flightBoxAddress).get(0);
        for (int i = 0; i < flightBox.children().size(); i++) {
            try {
                flightDTOS.add(flightDetailsFlightDTO(flightBox.child(i)));
            } catch (NumberFormatException e) {
                e.printStackTrace();
            } catch (FlightClassMatchException e) {
                e.printStackTrace();
            } catch (FlightCapacityMatchException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        responseDTO.setFlightDTOS(flightDTOS);
        return responseDTO;
    }

    private FlightDTO flightDetailsFlightDTO(Element element) throws NumberFormatException, FlightClassMatchException, FlightCapacityMatchException, Exception {

        String flightCompany;
        String capacity, price, flightNumber, flightClass, isCharter, date, time;
        flightCompany = element
                .select("div > div.panel-body > div.row > div.col-md-2.col-sm-2.col-xs-6 > p.text-center").text()
                .trim();
        date = element.select("div > div.panel-body > div.row > div.col-md-2.col-sm-2.col-xs-4 > p").text().trim();
        capacity = element.select("div > div.panel-body > div.row > div.col-md-2.col-sm-2.col-xs-3 > p.text-center")
                .text().trim();
        String strCap = capacity.replaceAll("ظرفیت", "");
        strCap = strCap.substring(1, 2);
        // checkCapacity(Integer.parseInt(changePersianToEnglishNum(strCap)));

        // finds lowestPrice
        if (calculateGhasedakPrice(element).equals(null)) {
            throw new NumberFormatException();
        } else
            price = calculateGhasedakPrice(element);
        String formattedPrice = calculateGhasedakFormattedPrice(element);

        String[] parts = flightCompany.split(" ");
        if (flightCompany.contains("ایر")) {
            String part0 = parts[0];
            String part1 = parts[1];
            String part2 = parts[2];
            String part3 = parts[3];
            flightCompany = part0 + " " + part1;
            flightNumber = part2;
            isCharter = part3;

        } else {
            String part0 = parts[0];
            String part1 = parts[1];
            String part2 = parts[2];
            flightCompany = part0;
            flightNumber = part1;
            isCharter = part2;
        }

        Boolean charter;
        if (isCharter.equals("چاتر"))
            charter = true;
        else
            charter = false;
        String[] parts1 = date.split(" ");
        String part0 = parts1[0];
        String part1 = parts1[1];
        String part2 = parts1[2];
        date = dateChecker(part0);
        time = part1;

        flightClass = findFlightClass(part2);


        FlightDTO flightDTO = new FlightDTO(url,
                Integer.valueOf(price),
                formattedPrice,
                FlightDTO.CURRENCY_TOMAN_FA,
                FlightDTO.CURRENCY_TOMAN_EN,
                flightNumber,
                FlightClassUtil.ghasedak24FlightClass(flightClass),
                FlightCompanyUtil.flightCompanyNameFa(flightCompany),
                null,
                null,
                charter,
                time,
                null,
                date,
                null,
                null,
                null,
                Integer.parseInt(changePersianToEnglishNum(strCap)));
        flightDTO.setCurrencyFa(FlightDTO.CURRENCY_TOMAN_FA);
        flightDTO.setCurrencyEn(FlightDTO.CURRENCY_TOMAN_EN);
        return flightDTO;

    }

    @Override
    public void myStartScrape() throws SocketTimeoutException {
        super.myStartScrape();
        url = makeURL();
        try {
            this.document = Jsoup.connect(url).header("host", "ghasedak24.com").userAgent(userAgent)
                    .header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
                    .header("Accept-Language", "en-US,en;q=0.5").header("Accept-Encoding", "gzip,deflate,br")
                    .referrer("https://ghasedak24.com/").header("Upgrade-Insecure-Requests", "1")
                    .header("Connection", "keep-alive").timeout(timeOut).followRedirects(true).method(Method.GET).get();

            findFlights(document);

        } catch (SocketTimeoutException e) {
            // TODO: handle exception
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void findFlights(Document doc) {

        System.out.println(" document     " + doc.body());
        Element flightBox;
        String flightBoxAddress = "body > div.result-wrap > div.container > div.row > div.col-md-12 > div.panel.panel-default > div#search-results > div.list-group-item > div.row > div.col-md-9.col-sm-9.col-xs-12 > div#search-results";
        flightBox = doc.select(flightBoxAddress).get(0);
        for (int i = 0; i < flightBox.children().size(); i++) {
            try {
                flightDetails(flightBox.child(i));
            } catch (NumberFormatException e) {
                continue;
            } catch (FlightClassMatchException e) {
                continue;
            } catch (FlightCapacityMatchException e) {
                continue;
            } catch (Exception e) {
                continue;
            }
        }
    }

    private String calculateGhasedakPrice(Element element) throws NumberFormatException {

        // string to make code clean with css address of price in the site
        String priceDiv = "div > div.panel-body > div.row > div.col-md-2.col-sm-2.col-xs-4 > p.text-center > span.price";
        if (element.select(priceDiv).size() > 0) {
            String price = element.select(
                    "div > div.panel-body > div.row > div.col-md-2.col-sm-2.col-xs-4 > p.text-center > span.price")
                    .text().trim();

            long priceValue = Long.parseLong(price.replaceAll(",", ""));
            return String.valueOf(priceValue);
        } else
            throw new NumberFormatException();
    }

    private String calculateGhasedakFormattedPrice(Element element) throws NumberFormatException {

        String priceDiv = "div > div.panel-body > div.row > div.col-md-2.col-sm-2.col-xs-4 > p.text-center > span.price";
        if (element.select(priceDiv).size() > 0) {
            String price = element.select(
                    "div > div.panel-body > div.row > div.col-md-2.col-sm-2.col-xs-4 > p.text-center > span.price")
                    .text().trim();
            return price;
        } else
            throw new NumberFormatException();
    }

    private void flightDetails(Element element)
            throws NumberFormatException, FlightClassMatchException, FlightCapacityMatchException, Exception {
        String flightCompany, capacity, price, flightNumber, flightClass, isCharter, date, time;
        flightCompany = element
                .select("div > div.panel-body > div.row > div.col-md-2.col-sm-2.col-xs-6 > p.text-center").text()
                .trim();
        date = element.select("div > div.panel-body > div.row > div.col-md-2.col-sm-2.col-xs-4 > p").text().trim();
        capacity = element.select("div > div.panel-body > div.row > div.col-md-2.col-sm-2.col-xs-3 > p.text-center")
                .text().trim();
        String strCap = capacity.replaceAll("ظرفیت", "");
        strCap = strCap.substring(1, 2);
        checkCapacity(Integer.parseInt(changePersianToEnglishNum(strCap)));
        // finds lowestPrice
        if (calculateGhasedakPrice(element).equals(null)) {
            throw new NumberFormatException();
        } else
            price = calculateGhasedakPrice(element);

        String link = makeURL();
        String host = "ghasedak24";
        String[] parts = flightCompany.split(" ");
        if (flightCompany.contains("ایر")) {
            String part0 = parts[0];
            String part1 = parts[1];
            String part2 = parts[2];
            String part3 = parts[3];
            flightCompany = part0 + " " + part1;
            flightNumber = part2;
            isCharter = part3;

        } else {
            String part0 = parts[0];
            String part1 = parts[1];
            String part2 = parts[2];
            flightCompany = part0;
            flightNumber = part1;
            isCharter = part2;
        }

        String[] parts1 = date.split(" ");
        String part0 = parts1[0];
        String part1 = parts1[1];
        String part2 = parts1[2];
        date = dateChecker(part0);
        time = part1;
        flightClass = findFlightClass(part2);
        Flight flight = new Flight();
        flight.setFlightCompany(flightCompany);
        flight.setCompanyCode(flight.getCompanyCode());
        flight.setFlightNumber(flightNumber);
        flight.setIsCharter(isCharter);
        flight.setDate(date);
        flight.setTime(time);
        flight.setCapacity(capacity);
        flight.setFlightClass(flightClass);
        flight.setPrice(price.replaceAll(",", "") + "0");
        flight.setLink(link);
        flight.setHost(host);
        flight.setId();

        if (information.getFlightClass().equals(Flight.ALL_FLIGHT_CLASSES)) {
            if (flight.getFlightClass().contains(Flight.UNKNOWN_CLASS_FA)
                    || flight.getFlightClass().contains(Flight.BUISNESS_CLASS_FA)
                    || flight.getFlightClass().contains(Flight.ECONOMY_CLASS_FA)
                    || flight.getFlightClass().contains(Flight.FIRST_CLASS_FA))
                addFlight(flight);
        }
        if (flight.getFlightClass().equals(Flight.UNKNOWN_CLASS_FA))
            return;
        else
            addFlight(flight);

    }

    private String makeURL() {

        if (!information.getIsRoundTrip()) {
            String baseUrl = "https://ghasedak24.com/search/flight/";
            String dateIn = information.getCheckinDate().replaceAll("/", "-");
            String urlPart = baseUrl + srcCityCode + "-" + destCityCode + "/" + dateIn + "/"
                    + information.getPassengers() + "-" + information.getChildren() + "-" + information.getNewBorns();
            return urlPart;
        } else {

            String baseUrl = "https://ghasedak24.com/search/flight/";
            String dateIn = information.getCheckinDate().replaceAll("/", "-");
            String dateOut = information.getCheckOutDate().replaceAll("/", "-");
            String urlPart = baseUrl + srcCityCode + "-" + destCityCode + "/" + dateIn + "/" + dateOut + "/"
                    + information.getPassengers() + "-" + information.getChildren() + "-" + information.getNewBorns();
            return urlPart;
        }
    }

}
