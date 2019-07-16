package ir.viratech.just_ro.manager.website.flight;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import ir.viratech.commons.api.search.SearchQueryDTO;
import ir.viratech.just_ro.api.flight.dto.alibaba.AlibabaCRCNDTO;
import ir.viratech.just_ro.api.flight.dto.alibaba.AlibabaFlightDTO;
import ir.viratech.just_ro.api.flight.dto.alibaba.AlibabaResponseDTO;
import ir.viratech.just_ro.api.flight.dto.alibaba.AlibabaResponseIdDTO;
import ir.viratech.just_ro.api.flight.dto.config.*;
import ir.viratech.just_ro.api.flight.dto.flight.FlightDTO;
import ir.viratech.just_ro.api.flight.dto.flight.FlightResponseDTO;
import ir.viratech.just_ro.api.flight.dto.search.FlightSearchQueryDTO;
import ir.viratech.just_ro.api.search.Search;
import ir.viratech.just_ro.manager.website.flight.flight_utils.FlightClassUtil;
import ir.viratech.just_ro.manager.website.flight.flight_utils.FlightCompanyUtil;
import ir.viratech.just_ro.model.calendar.CalendarTool;
import ir.viratech.just_ro.model.flight.Flight;
import ir.viratech.just_ro.model.flight.exception.FlightCapacityMatchException;
import ir.viratech.just_ro.model.flight.exception.FlightClassMatchException;
import ir.viratech.just_ro.model.information.Information;
import org.apache.commons.collections.map.HashedMap;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.UnsupportedMimeTypeException;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Alibaba extends FlightsWebsites {


    private String searchUrl;

    public Alibaba() {

    }


    @Override
    public FlightWebsiteRequestDTO getFlightWebsiteRequestDTO() {

        ServerRequest serverRequest = new ServerRequest();
        makeServerRequest(serverRequest);
        FlightWebsiteRequestDTO flightWebsiteRequestDTO = new FlightWebsiteRequestDTO();
        flightWebsiteRequestDTO.setServerRequest(serverRequest);
        flightWebsiteRequestDTO.setBaseUrl("https://www.alibaba.ir/api/GetFlight");
        flightWebsiteRequestDTO.setHttpMethod(FlightWebsiteRequestDTO.HttpMethod.GET);
        flightWebsiteRequestDTO.setRequestHeaders(getRequestHeaders());
        flightWebsiteRequestDTO.setRequestBody(false);
        flightWebsiteRequestDTO.setQueryTypeList(makeQueryType());
        flightWebsiteRequestDTO.setQueries(getQueries());
        // flightWebsiteRequestDTO.setAdditionalInfo(createAdditional(flightWebsiteRequestDTO));
        return flightWebsiteRequestDTO;
    }

    private List<FlightWebsiteRequestDTO.QueryType> makeQueryType() {
        List<FlightWebsiteRequestDTO.QueryType> queryTypes = new ArrayList<>();
        queryTypes.add(FlightWebsiteRequestDTO.QueryType.QueryString);
        return queryTypes;
    }

    private void makeServerRequest(ServerRequest serverRequest) {

        serverRequest.setApi("/api/v1/flight/alibaba");
        serverRequest.setMethod(String.valueOf(ServerRequest.Method.Post));
        Map<String, String> map = new HashedMap();
        map.put("Content-Type", "application/json");
        serverRequest.setRequestHeaders(map);
    }

    public void makeUrl(FlightSearchQueryDTO searchQueryDTO) {

        FlightsWebsites websites = new Alibaba();
        String baseUrl = "https://www.alibaba.ir/flights/";
        String srcDestCity = websites.getSourceCityCode(searchQueryDTO) + "-" + websites.getDestCityCode(searchQueryDTO);

        String dateTemp = searchQueryDTO.getPersianDate();
        String date = dateTemp.replaceAll("-", "/");
        String passengersCount = searchQueryDTO.getAdults() + "-" + searchQueryDTO.getChildren() + "-" + searchQueryDTO.getInfants();
        searchUrl = baseUrl + srcDestCity + "/" + date + "/" + passengersCount;
    }

    private String makeSearchFlightURL(String srcCode, String destCode, String dateFrom) {
        //https://www.alibaba.ir/flights/THR-SYZ/1396-11-18/1-0-0
        String baseURL = "https://www.alibaba.ir/flights/";
        String from = "?ffrom=" + srcCode;
        String to = "&fto=" + destCode;
        String passengersCount = "&adult=" + information.getPassengers() + "&child=" + information.getChildren()
                + "&infant=" + information.getNewBorns();
        String searchFlightURL = baseURL + from + to + "&datefrom=" + dateFrom + passengersCount;
        return searchFlightURL;
    }

    public FlightResponseDTO getFlightDTOList(AlibabaResponseDTO alibabaResponseDTO) {

        FlightResponseDTO flightResponseDTO = new FlightResponseDTO();
        List<FlightDTO> flightDTOList = new ArrayList<>();
        for (AlibabaFlightDTO alibabaFlightDTO : alibabaResponseDTO.getAvailableFlights()) {

            FlightDTO flightDTO = new FlightDTO();
            flightDTO.setPrice(alibabaFlightDTO.getPrice());
            flightDTO.setLink(alibabaFlightDTO.getUrlLink());
            flightDTO.setFormattedPrice(NumberFormat.getNumberInstance().format(flightDTO.getPrice()));
            flightDTO.setFlightNumber(alibabaFlightDTO.getFlightNumber());
            //TODO check with amir
            flightDTO.setFlightClass(FlightClassUtil.alibabaFlightClass(alibabaFlightDTO.getKind()));
            //TODO check with amir
            flightDTO.setFilghtCompanyNameFa(FlightCompanyUtil.flightCompanyNameFa(alibabaFlightDTO.getAirline()));
            //TODO check with amir
            flightDTO.setFilghtCompanyNameEn(FlightCompanyUtil.aliMrFlightCompanyNameEn(alibabaFlightDTO.getAirlineEnglish()));
            flightDTO.setAirplane(alibabaFlightDTO.getAircraft());
            flightDTO.setCharter(alibabaFlightDTO.getCharterOverPrice());
            flightDTO.setDepartureTime(alibabaFlightDTO.getLeaveTime());
            flightDTO.setArrivalTime(alibabaFlightDTO.getArrivalTime());
            flightDTO.setDepartureDateFa(alibabaFlightDTO.getLeaveDateFa());
            flightDTO.setDepartureDateEn(alibabaFlightDTO.getLeaveDate());
            //TODO there is no arrive date
            flightDTO.setArrivalDateFa(null);
            //TODO there is no arrive date
            flightDTO.setArrivalDateEn(null);
            try {
                Integer capacity = findCapacity(alibabaFlightDTO.getClassDeatils());
                flightDTO.setCapacity(capacity);
            } catch (FlightCapacityMatchException e) {
                e.printStackTrace();
            }
            flightDTOList.add(flightDTO);
        }
        flightResponseDTO.setFlightDTOS(flightDTOList);
        flightResponseDTO.setItemsCount(flightDTOList.size());
        return flightResponseDTO;
    }

    private Integer findCapacity(String capacity) throws NumberFormatException, FlightCapacityMatchException {
        final String[] englishNums = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        final String[] persianNums = {"۰", "۱", "۲", "۳", "۴", "۵", "۶", "۷", "۸", "۹"};
        if (capacity.contains("فقط")) {
            capacity = capacity.replaceAll("فقط", "").replaceAll("نفر", "").trim();
            checkCapacity(Integer.parseInt(capacity));
            for (int i = 0; i < englishNums.length; i++)
                if (capacity.equals(englishNums[i]))
                    capacity = persianNums[i];
            return Integer.parseInt(capacity);
        } else if (capacity.contains("تکمیل") || capacity.contains("موجود")) {
            return null;
        }
        return Integer.parseInt(capacity);
    }


    private Map<String, AlibabaAditionalInfoMapDTO> createAdditional() {
        Map<String, AlibabaAditionalInfoMapDTO> map = new HashedMap();
        map.put("last", getLast());
        map.put("isReturn", getIsReturn());
        map.put("isNew", getIsNew());
        return map;
    }

    private AlibabaAditionalInfoMapDTO getIsNew() {

        AlibabaAditionalInfoMapDTO infoMapDTO = new AlibabaAditionalInfoMapDTO();
        infoMapDTO.setValue(true);
        infoMapDTO.setDataType(AlibabaAditionalInfoMapDTO.DataType.Boolean);
        return infoMapDTO;
    }

    private AlibabaAditionalInfoMapDTO getIsReturn() {

        AlibabaAditionalInfoMapDTO infoMapDTO = new AlibabaAditionalInfoMapDTO();
        infoMapDTO.setValue(false);
        infoMapDTO.setDataType(AlibabaAditionalInfoMapDTO.DataType.Boolean);
        return infoMapDTO;
    }

    private AlibabaAditionalInfoMapDTO getLast() {

        AlibabaAditionalInfoMapDTO infoMapDTO = new AlibabaAditionalInfoMapDTO();
        infoMapDTO.setValue(0);
        infoMapDTO.setDataType(AlibabaAditionalInfoMapDTO.DataType.Integer);
        return infoMapDTO;
    }


//    private AlibabaResponseIdDTO requestToGetAdditionalContent() {
//        //String url = alibabaRequestIdUrl();
//        System.out.println("alibaba url : " + url);
//        try {
//            UnsupportedMimeTypeException mimeType = new UnsupportedMimeTypeException("Hey this is Mime", "application/json", "http://dictionary.cambridge.org/dictionary/english/reality");
//            String mime = mimeType.getMimeType();
//            Response response = Jsoup.connect(url).userAgent(userAgent).header("Content-Type", mime).ignoreContentType(true).method(Method.GET).execute();
//            System.out.println("response : " + response.body());
//            AlibabaResponseIdDTO alibabaResponseIdDTO = new Gson().fromJson(response.body(), AlibabaResponseIdDTO.class);
//            System.out.println("alibaba response id : " + alibabaResponseIdDTO.getRequestID());
//            return alibabaResponseIdDTO;
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

//    private Map<String, Object> fillAditionalContent(FlightWebsiteRequestDTO flightWebsiteRequestDTO) {
//        AlibabaResponseIdDTO alibabaResponseIdDTO = new AlibabaResponseIdDTO();
//        System.out.println("fill aditional content" + alibabaResponseIdDTO.getRequestID());
//        Map<String, Object> map = new HashedMap();
//        alibabaResponseIdDTO.setRequestID(getAlibabaAdditionalId(alibabaResponseIdDTO));
//        alibabaResponseIdDTO.setInterval(getAlibabaInterval(alibabaResponseIdDTO));
//        alibabaResponseIdDTO.setCount(getAlibabaAdditionalCount(alibabaResponseIdDTO));
//        alibabaResponseIdDTO.setIsReturn(getAlibabaAdditionalIsReturn(alibabaResponseIdDTO));
//        alibabaResponseIdDTO.setIsNew(getAlibabaAdditionalIsNew(alibabaResponseIdDTO));
//        flightWebsiteRequestDTO.setBaseUrl("https://www.alibaba.ir/api/GetFlight");
//        map.put("RequestURL", flightWebsiteRequestDTO.getBaseUrl());
//        map.put("Id", alibabaResponseIdDTO.getRequestID());
//        map.put("Interval", alibabaResponseIdDTO.getInterval());
//        //  map.put("RequestUrl", getFlightstURL(alibabaResponseIdDTO));
//        map.put("last", alibabaResponseIdDTO.getLast());
//        map.put("SrcCity", getSrcCity());
//        map.put("DstCity", getDstCity());
//        map.put("DepartureDate", getDepartureDate());
//        map.put("count", alibabaResponseIdDTO.getCount());
//        map.put("isReturn", alibabaResponseIdDTO.getIsReturn());
//        map.put("isNew", alibabaResponseIdDTO.getIsNew());
//        return map;
//    }

    private AlibabaAditionalInfoMapDTO getAlibabaAdditionalIsNew(AlibabaResponseIdDTO alibabaResponseIdDTO) {

        AlibabaAditionalInfoMapDTO infoMapDTO = new AlibabaAditionalInfoMapDTO();
        infoMapDTO.setDataType(AlibabaAditionalInfoMapDTO.DataType.Boolean);
        infoMapDTO.setValue(true);
        return infoMapDTO;

    }

    private AlibabaAditionalInfoMapDTO getAlibabaAdditionalIsReturn(AlibabaResponseIdDTO alibabaResponseIdDTO) {

        AlibabaAditionalInfoMapDTO infoMapDTO = new AlibabaAditionalInfoMapDTO();
        infoMapDTO.setDataType(AlibabaAditionalInfoMapDTO.DataType.Boolean);
        infoMapDTO.setValue(alibabaResponseIdDTO.getIsReturn());
        return infoMapDTO;
    }

    private AlibabaAditionalInfoMapDTO getAlibabaAdditionalCount(AlibabaResponseIdDTO alibabaResponseIdDTO) {

        AlibabaAditionalInfoMapDTO infoMapDTO = new AlibabaAditionalInfoMapDTO();
        infoMapDTO.setDataType(AlibabaAditionalInfoMapDTO.DataType.Integer);
        infoMapDTO.setValue("adult + children + child");
        return infoMapDTO;
    }

//    private String getFlightstURL(AlibabaResponseIdDTO responseIdDTO) {
//        FlightsWebsites websites = new Alibaba();
//        String baseUrl = "https://www.alibaba.ir/api/GetFlight";
//        String from = websites.getSourceCityCode(searchQueryDTO);
//        String to = websites.getDestCityCode(searchQueryDTO);
//        String date = searchQueryDTO.getPersianDate();
//        return baseUrl + "?id=" + responseIdDTO.getRequestID() + "&last=0" + "&ffrom=" + from + "&fto=" + to +
//                "&datefrom=" + date + "&count=1" + "&interval=" +
//                responseIdDTO.getInterval() + "&isReturn=false&isNew=true";
//    }

    private AlibabaAditionalInfoMapDTO getAlibabaInterval(AlibabaResponseIdDTO alibabaResponseIdDTO) {

        AlibabaAditionalInfoMapDTO infoMapDTO = new AlibabaAditionalInfoMapDTO();
        infoMapDTO.setDataType(AlibabaAditionalInfoMapDTO.DataType.Integer);
        infoMapDTO.setValue(alibabaResponseIdDTO.getInterval());
        return infoMapDTO;
    }

    private AlibabaAditionalInfoMapDTO getAlibabaAdditionalId(AlibabaResponseIdDTO alibabaResponseIdDTO) {

        AlibabaAditionalInfoMapDTO infoMapDTO = new AlibabaAditionalInfoMapDTO();
        infoMapDTO.setDataType(AlibabaAditionalInfoMapDTO.DataType.Integer);
        infoMapDTO.setValue(alibabaResponseIdDTO.getRequestID());
        return infoMapDTO;
    }


    private QueryDTO getQueries() {
        QueryDTO queryDTO = new QueryDTO();
        queryDTO.setAdult(getAdult());
        queryDTO.setChildren(getChildren());
        queryDTO.setInfant(getInfant());
        queryDTO.setDateFormat("yyyy/mm/dd");
        queryDTO.setDateSplitter("/");
        queryDTO.setDepartureDate(getDepartureDate());
        queryDTO.setDstCity(getDstCity());
        queryDTO.setSrcCity(getSrcCity());
        queryDTO.setUsePersianDate(true);
        queryDTO.setUsePersianCityName(false);
        queryDTO.setUseEnglishCityName(false);
        queryDTO.setUseCityCode(true);
        queryDTO.setAdditionalQueries(createAdditional());
        return queryDTO;
    }

    private QueryMapDTO getDepartureDate() {
        QueryMapDTO queryMapDTO = new QueryMapDTO();
        queryMapDTO.setKey("datefrom");
        queryMapDTO.setDataType(QueryMapDTO.DataType.String);
        return queryMapDTO;
    }

    private QueryMapDTO getDstCity() {
        QueryMapDTO queryMapDTO = new QueryMapDTO();
        queryMapDTO.setKey("fto");
        queryMapDTO.setDataType(QueryMapDTO.DataType.String);
        return queryMapDTO;
    }

    private QueryMapDTO getSrcCity() {
        QueryMapDTO queryMapDTO = new QueryMapDTO();
        queryMapDTO.setKey("ffrom");
        queryMapDTO.setDataType(QueryMapDTO.DataType.String);
        return queryMapDTO;
    }

    private QueryMapDTO getInfant() {
        QueryMapDTO queryMapDTO = new QueryMapDTO();
        queryMapDTO.setKey("infant");
        queryMapDTO.setDataType(QueryMapDTO.DataType.Integer);
        return queryMapDTO;
    }

    private QueryMapDTO getAdult() {
        QueryMapDTO queryMapDTO = new QueryMapDTO();
        queryMapDTO.setKey("adult");
        queryMapDTO.setDataType(QueryMapDTO.DataType.Integer);
        return queryMapDTO;
    }

    private QueryMapDTO getChildren() {
        QueryMapDTO queryMapDTO = new QueryMapDTO();
        queryMapDTO.setKey("child");
        queryMapDTO.setDataType(QueryMapDTO.DataType.Integer);
        return queryMapDTO;
    }

    private Map<String, String> getRequestHeaders() {
        Map<String, String> headers = new HashMap<>();
        headers.put("Accept", "application/json, text/javascript, */*; q=0.01");
        headers.put("X-Requested-With", "XMLHttpRequest");
        return headers;
    }


    public Alibaba(Information information) {
        super(information);
    }

    @Override
    public void myStartScrape() throws SocketTimeoutException {
        super.startScrape();
        Response response = null;
        String referrer = makeReferrer();
        try {
            String searchFlightURL = makeSearchFlightURL(srcCityCode, destCityCode, information.getCheckinDate());

            int counter = 1;
            while (true) {
                try {
                    counter++;
                    response = Jsoup.connect(searchFlightURL).userAgent(userAgent)
                            .header("Host", "http://www.alibaba.ir")
                            .header("Accept", "application/json, text/javascript, */*; q=0.01")
                            .header("Accept-Encoding", "gzip, deflate, br").header("Accept-Language", "en-US,en;q=0.5")
                            .header("X-Requested-With", "XMLHttpRequest").header("Connection", "Keep-Alive")
                            .referrer(referrer).ignoreContentType(true).timeout(timeOut).method(Method.GET).execute();
                    break;
                } catch (SocketTimeoutException e) {
                    if (counter < 4) {
                        continue;
                    } else {
                        break;
                    }
                }
            }
            JSONParser parser = new JSONParser();
            JSONObject newJObject = null;
            String jsonText = response.body().toString();
            Object objectId = null;
            Object objectInterval = null;
            try {
                newJObject = (JSONObject) parser.parse(jsonText);
                objectInterval = newJObject.get("Interval");
                objectId = newJObject.get("RequestId");
            } catch (ParseException e) {
                e.printStackTrace();
            }
            Long id = (Long) objectId;
            Long interval = (Long) objectInterval;
            String getFlightURL = makeGetFlightURL(id, srcCityCode, destCityCode, false, information.getCheckinDate(),
                    interval);
            Document doc = Jsoup.connect(getFlightURL).userAgent(userAgent).ignoreContentType(true).get();
            findFlights(doc, referrer);

            // find datas for roundTrip
            if (information.getIsRoundTrip()) {
                searchFlightURL = makeSearchFlightURL(destCityCode, srcCityCode, information.getCheckOutDate());
                response = Jsoup.connect(searchFlightURL).userAgent(userAgent).header("Host", "http://www.alibaba.ir")
                        .header("Accept", "application/json, text/javascript, */*; q=0.01")
                        .header("Accept-Encoding", "gzip, deflate, br").header("Accept-Language", "en-US,en;q=0.5")
                        .header("X-Requested-With", "XMLHttpRequest").referrer(referrer)
                        .header("Connection", "Keep-Alive").timeout(timeOut).ignoreContentType(true).method(Method.GET)
                        .execute();

                newJObject = null;
                jsonText = response.body().toString();
                try {
                    newJObject = (JSONObject) parser.parse(jsonText);
                    objectInterval = newJObject.get("Interval");
                    objectId = newJObject.get("RequestId");
                } catch (ParseException e) {
                    return;
                }
                id = (Long) objectId;
                interval = (Long) objectInterval;

                getFlightURL = makeGetFlightURL(id, destCityCode, srcCityCode, true, information.getCheckOutDate(),
                        interval);
                doc = Jsoup.connect(getFlightURL).userAgent(userAgent).ignoreContentType(true).get();
                findFlights(doc, referrer);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

    }

    private void findFlights(Document doc, String link) {
        String price;
        String[] flightsStringParts = doc.select("body").text().split("AvailableFlights\":");
        String[] flightsJsonParts = flightsStringParts[1].split(",\"FaranegarAvailableCount\"");
        String flightsJson = flightsJsonParts[0];
        Gson gson = new Gson();
        JsonObject[] flightsArray = gson.fromJson(flightsJson, JsonObject[].class);
        for (JsonObject flightJson : flightsArray) {
            String flightCompany = flightJson.get("AirLine").toString().replaceAll("\"", "");
            String airplane = flightJson.get("Aircraft").toString().replaceAll("\"", "");
            String time = getFlightTime(flightJson);
            String date = dateChecker(flightJson.get("LeaveDateFa").toString().replaceAll("\"", ""));
            String flightNumber = getFlightNumber(flightJson);

            // find lowestPrice
            if (flightJson.get("price").toString().replaceAll("\"", "").equals("0")
                    || flightJson.get("price").toString().isEmpty()) {
                continue;
            } else
                price = calculateFinalPrice(Long.parseLong(flightJson.get("price").toString().replaceAll("\"", "")));
            String capacity = null;
            try {
                capacity = findCapacity(flightJson);
            } catch (FlightCapacityMatchException e) {
                continue;
            }
            String isCharter = flightJson.get("SystemKeyName").toString().replaceAll("\"", "");
            String flightClass = null;
            try {
                flightClass = findFlightClass(flightJson.get("kind").toString().replaceAll("\"", ""));
            } catch (FlightClassMatchException e) {
                continue;
            }

            Flight flight = new Flight(flightCompany, capacity, price, flightNumber, date, "alibaba", link, time,
                    airplane, isCharter, flightClass);

            if (information.getFlightClass().equals(Flight.ALL_FLIGHT_CLASSES)) {
                if (flight.getFlightClass().contains(Flight.UNKNOWN_CLASS_FA)
                        || flight.getFlightClass().contains(Flight.BUISNESS_CLASS_FA)
                        || flight.getFlightClass().contains(Flight.ECONOMY_CLASS_FA)
                        || flight.getFlightClass().contains(Flight.FIRST_CLASS_FA))
                    addFlight(flight);
            }
            if (flight.getFlightClass().equals(Flight.UNKNOWN_CLASS_FA))
                continue;
            else
                addFlight(flight);

        }
    }

    private String findCapacity(JsonObject flightJson) throws NumberFormatException, FlightCapacityMatchException {
        final String[] englishNums = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        final String[] persianNums = {"۰", "۱", "۲", "۳", "۴", "۵", "۶", "۷", "۸", "۹"};
        String capacity = flightJson.get("ClassDetails").toString().replaceAll("\"", "");
        if (capacity.contains("فقط")) {
            capacity = capacity.replaceAll("فقط", "").replaceAll("نفر", "").trim();
            checkCapacity(Integer.parseInt(capacity));
            for (int i = 0; i < englishNums.length; i++)
                if (capacity.equals(englishNums[i]))
                    capacity = persianNums[i];
            capacity = "ظرفیت" + " " + capacity + " " + "نفر";
            return capacity;
        } else if (capacity.contains("تکمیل")) {
            throw new FlightCapacityMatchException();
        }
        return capacity;
    }

    private String getFlightTime(JsonObject flightJson) {
        String flightTime = flightJson.get("LeaveTime").toString().replaceAll("\"", "");
        String part1 = flightTime.substring(0, 2);
        String part2 = flightTime.substring(2, 4);
        return part1 + ":" + part2;
    }

    private String getFlightNumber(JsonObject flightJson) {
        String[] enSmallChars = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q",
                "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        String[] enCapitalChars = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q",
                "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        String flightNiumber = flightJson.get("FlightNumber").toString().replaceAll("\"", "");
        for (String character : enCapitalChars)
            flightNiumber = flightNiumber.replaceAll(character, "");

        for (String character : enSmallChars)
            flightNiumber = flightNiumber.replaceAll(character, "");

        return flightNiumber;
    }

    private String makeGetFlightURL(Long id, String srcCode, String destCode, boolean isReturn, String dateFrom,
                                    Long interval) {
        String baseURL = "https://www.alibaba.ir/api/GetFlight";
        StringBuilder getFlightURL = new StringBuilder(baseURL);
        getFlightURL.append("?id=" + id);
        getFlightURL.append("&last=0");
        getFlightURL.append("&ffrom=" + srcCode);
        getFlightURL.append("&fto=" + destCode);
        getFlightURL.append("&datefrom=" + dateFrom);
        getFlightURL.append("&count=" + information.getPassengers());
        getFlightURL.append("&interval=" + interval);
        getFlightURL.append("&isReturn=" + isReturn);
        getFlightURL.append("&isNew=true");
        return getFlightURL.toString();
    }


    private String makeReferrer() {
        String baseUrl = "https://www.alibaba.ir/flights/";
        String checkInDate = information.getCheckinDate().replaceAll("/", "-");
        String passengersCount = information.getPassengers() + "-" + information.getChildren() + "-"
                + information.getNewBorns();
        String referrer = baseUrl + srcCityCode + "-" + destCityCode + "/" + checkInDate + "/";
        if (information.getIsRoundTrip()) {
            String checkOutDate = information.getCheckOutDate().replaceAll("/", "-");
            referrer += checkOutDate + "/";
        }
        referrer += passengersCount;
        return referrer;
    }


}
