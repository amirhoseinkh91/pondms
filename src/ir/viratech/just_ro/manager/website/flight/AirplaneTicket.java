package ir.viratech.just_ro.manager.website.flight;

import ir.viratech.just_ro.api.flight.dto.airplainTicekt.AirplainTicketFlightResponseDTO;
import ir.viratech.just_ro.api.flight.dto.airplainTicekt.AirplainTicketFlightInfoDTO;
import ir.viratech.just_ro.api.flight.dto.config.*;
import ir.viratech.just_ro.api.flight.dto.flight.FlightDTO;
import ir.viratech.just_ro.api.flight.dto.flight.FlightResponseDTO;
import ir.viratech.just_ro.api.flight.dto.search.FlightSearchQueryDTO;
import ir.viratech.just_ro.manager.website.flight.flight_utils.FlightClassUtil;
import ir.viratech.just_ro.manager.website.flight.flight_utils.FlightCompanyUtil;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import ir.viratech.just_ro.model.calendar.CalendarTool;
import ir.viratech.just_ro.model.flight.Flight;
import ir.viratech.just_ro.model.flight.exception.FlightClassMatchException;
import ir.viratech.just_ro.model.information.Information;

public class AirplaneTicket extends FlightsWebsites {

    private String link;
    private FlightResponseDTO flightResponseDTO;

    public AirplaneTicket(Information information) {
        super(information);
    }

    public AirplaneTicket() {
        this.flightResponseDTO = new FlightResponseDTO();
    }

    @Override
    public FlightWebsiteRequestDTO getFlightWebsiteRequestDTO() {
        ServerRequest serverRequest = new ServerRequest();
        makeServerRequest(serverRequest);
        FlightWebsiteRequestDTO flightWebsiteRequestDTO = new FlightWebsiteRequestDTO();
        flightWebsiteRequestDTO.setServerRequest(serverRequest);
        flightWebsiteRequestDTO.setBaseUrl("https://airplaneticket.ir/flights/getFlights2");
        flightWebsiteRequestDTO.setHttpMethod(FlightWebsiteRequestDTO.HttpMethod.POST);
        flightWebsiteRequestDTO.setRequestHeaders(getRequestHeaders());
        flightWebsiteRequestDTO.setRequestBody(true);
        flightWebsiteRequestDTO.setQueryTypeList(makeQueryType());
        flightWebsiteRequestDTO.setQueries(getQueries());
        return flightWebsiteRequestDTO;
    }

    private List<FlightWebsiteRequestDTO.QueryType> makeQueryType() {
        List<FlightWebsiteRequestDTO.QueryType> queryTypes = new ArrayList<>();
        queryTypes.add(FlightWebsiteRequestDTO.QueryType.FormParam);
        return queryTypes;
    }

    private void makeServerRequest(ServerRequest serverRequest) {

        serverRequest.setApi("/api/v1/flight/airplane_ticket");
        serverRequest.setMethod(String.valueOf(ServerRequest.Method.Post));
        Map<String, String> map = new HashedMap();
        map.put("Content-Type", "application/json");
        serverRequest.setRequestHeaders(map);
    }

    private QueryDTO getQueries() {
        QueryDTO queryDTO = new QueryDTO();
        queryDTO.setAdult(getAdults());
        queryDTO.setChildren(getChildren());
        queryDTO.setInfant(getInfant());
        queryDTO.setDateFormat("dd/mm/yyyy");
        queryDTO.setDateSplitter("/");
        queryDTO.setDepartureDate(getDepartureDate());
        queryDTO.setDstCity(getDstCity());
        queryDTO.setSrcCity(getSrcCity());
        queryDTO.setUsePersianDate(true);
        queryDTO.setUsePersianCityName(false);
        queryDTO.setUseEnglishCityName(false);
        queryDTO.setUseCityCode(true);
        return queryDTO;
    }

    private QueryMapDTO getInfant() {
        QueryMapDTO queryMapDTO = new QueryMapDTO();
        queryMapDTO.setDataType(QueryMapDTO.DataType.Integer);
        queryMapDTO.setKey("inf");
        return queryMapDTO;
    }

    private QueryMapDTO getChildren() {
        QueryMapDTO queryMapDTO = new QueryMapDTO();
        queryMapDTO.setDataType(QueryMapDTO.DataType.Integer);
        queryMapDTO.setKey("chd");
        return queryMapDTO;
    }

    private QueryMapDTO getAdults() {
        QueryMapDTO queryMapDTO = new QueryMapDTO();
        queryMapDTO.setDataType(QueryMapDTO.DataType.Integer);
        queryMapDTO.setKey("adl");
        return queryMapDTO;
    }

    private QueryMapDTO getDepartureDate() {
        QueryMapDTO queryMapDTO = new QueryMapDTO();
        queryMapDTO.setKey("depart");
        queryMapDTO.setDataType(QueryMapDTO.DataType.String);
        return queryMapDTO;
    }

    private QueryMapDTO getDstCity() {
        QueryMapDTO queryMapDTO = new QueryMapDTO();
        queryMapDTO.setKey("to");
        queryMapDTO.setDataType(QueryMapDTO.DataType.String);
        return queryMapDTO;
    }

    private QueryMapDTO getSrcCity() {
        QueryMapDTO queryMapDTO = new QueryMapDTO();
        queryMapDTO.setKey("from");
        queryMapDTO.setDataType(QueryMapDTO.DataType.String);
        return queryMapDTO;
    }

    private Map<String, String> getRequestHeaders() {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/x-www-form-urlencoded");
        return headers;
    }

    public void myStartScrape() {
        try {
            String Referer = makeReferer();
            String postMethodUrl = postMethodUrl();
            String request = myMakeRequestBody();
            Response response = Jsoup.connect(postMethodUrl).userAgent(userAgent).ignoreContentType(true)
                    .referrer(Referer).method(Method.POST).requestBody(request).execute();
            myFindDetails(response.body());
        } catch (IOException e) {
            return;
        } catch (JSONException e) {
            return;
        } catch (FlightClassMatchException e) {
            return;
        }
    }

    public FlightResponseDTO getFlightDTOList(AirplainTicketFlightResponseDTO responseDTO) {

        List<AirplainTicketFlightInfoDTO> flightInfoList = new ArrayList<>();

        for (AirplainTicketFlightInfoDTO flightInfoDTO : responseDTO.getResponseDTOList())
            flightInfoList.add(flightInfoDTO);

        return getAirplainTicketFlightDTOList(flightInfoList);
    }

    @SuppressWarnings("Duplicates")
    private FlightResponseDTO getAirplainTicketFlightDTOList(List<AirplainTicketFlightInfoDTO> infoDTOS) {

        FlightResponseDTO responseDTO = new FlightResponseDTO();
        List<FlightDTO> flightDTOList = new ArrayList<>();
        for (AirplainTicketFlightInfoDTO infoDTO : infoDTOS) {

            for (int i = 0; i < infoDTO.getFlightsSize(); i++) {
                FlightDTO flightDTO = new FlightDTO();
                flightDTO.setLink(this.link);
                flightDTO.setPrice(infoDTO.getTotalPrice());
                flightDTO.setFormattedPrice(NumberFormat.getNumberInstance().format(flightDTO.getPrice()));
                flightDTO.setCurrencyFa(FlightDTO.CURRENCY_TOMAN_FA);
                flightDTO.setCurrencyEn(FlightDTO.CURRENCY_TOMAN_EN);
                flightDTO.setFlightNumber(infoDTO.getFlightNumber(i));
                //TODO check with amir
                flightDTO.setFlightClass(FlightClassUtil.convertCodeToPersianClass(infoDTO.getClassCode(i)));
                //TODO check with amir
                flightDTO.setFilghtCompanyNameFa(FlightCompanyUtil.airplaneTicketFlightCompanyNameFa(infoDTO.getCarrier(i)));
                //TODO check with amir
                flightDTO.setFilghtCompanyNameEn(FlightCompanyUtil.airplaneTicketFlightCompanyNameEn(infoDTO.getAirlineEnglish(i)));
                flightDTO.setAirplane(infoDTO.getAirplane(i));
                flightDTO.setCharter(infoDTO.getCharterTime(i));
                String departTime = infoDTO.getDepartTime(i);
                String[] times = StringUtils.split(departTime, " ")[1].split(":");
                flightDTO.setDepartureTime(times[0]+":" + times[1]);
                flightDTO.setArrivalTime(infoDTO.getArrivalTime(i));
                flightDTO.setDepartureDateFa(getIranianDate(infoDTO.getDepartureDate(i).replaceAll("-", "/")));
                flightDTO.setDepartureDateEn(infoDTO.getDepartureDate(i).replaceAll("-", "/"));
                flightDTO.setArrivalDateFa(getIranianDate(infoDTO.getArriveDate(i).replaceAll("-", "/")));
                flightDTO.setArrivalDateEn(infoDTO.getArriveDate(i));
                Integer capacity = infoDTO.getCapacity(i);
                if (capacity == null || capacity == 0)
                    continue;
                flightDTO.setCapacity(capacity);
                flightDTOList.add(flightDTO);
            }
        }

        responseDTO.setFlightDTOS(flightDTOList);
        return responseDTO;
    }

    private String getIranianDate(String gerigorianDate) {
        String[] parts = gerigorianDate.split("/");
        int year = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int day = Integer.parseInt(parts[2]);
        CalendarTool calendarTool = new CalendarTool();
        calendarTool.setGregorianDate(year, month, day);
        return calendarTool.getIranianDate();

    }

    public void makeUrl(FlightSearchQueryDTO searchQueryDTO) {
        FlightsWebsites websites = new AirplaneTicket();
        String baseUrl = "https://airplaneticket.ir/flights/";
        String cityName = searchQueryDTO.getSource() + "-"
                + searchQueryDTO.getDestination() + "/";
        String dateTemp = searchQueryDTO.getPersianDate();
        String date = dateTemp.replaceAll("/", "-");
        this.link = baseUrl + cityName + date + "/";
    }

    private String getLowestPrice(List<Integer> prices) {
        Integer min = prices.get(0);
        for (int i = 0; i < prices.size(); i++) {
            if (prices.get(i) < min) {
                min = prices.get(i);
            }
        }
        return String.valueOf(min);
    }

    private String makeReferer() {
        String cities = srcCityCode + "-" + destCityCode;
        String date = information.getCheckinDate();
        String refer = "https://airplaneticket.ir/flights/" + cities + "/" + date;
        return refer;
    }

    private String reverseDate(String date) {
        String[] parts = date.split("/");
        String day = parts[0];
        String month = parts[1];
        String year = parts[2];
        return year + "-" + month + "-" + day;
    }

    private String myMakeRequestBody() {
        String date = reverseDate(information.getCheckinDate());
        return "from=" + "[" + "\"" + srcCityCode + "\"" + "]" + "&" + "to=" + "[" + "\"" + destCityCode + "\"" + "]"
                + "&" + "depart=" + "[" + "\"" + date + "\"" + "]" + "&" + "adl=" + information.getPassengers() + "&"
                + "chd=" + 0 + "&" + "inf=" + 0 + "&" + "page=1" + "&" + "filters={}";
    }

    private void myFindDetails(String response) throws JSONException, FlightClassMatchException {
        JSONObject jsonObjectData = new JSONObject(response);

        JSONArray jsonArray = jsonObjectData.getJSONArray("FlightInfo");

        for (int i = 0; i < jsonArray.length(); i++) {
            Flight flight = new Flight();
            long price = Long.parseLong(jsonArray.getJSONObject(i).getString("totalPrice"));
            if (price > 0)
                flight.setPrice(calculateFinalPrice(price));
            else
                continue;
            flight.setDate(information.getCheckinDate());
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            if (jsonObject.has("Flights")) {
                JSONArray flightsInfo = jsonObject.getJSONArray("Flights");
                JSONObject flightInfo = (JSONObject) flightsInfo.get(0);
                flight.setFlightCompany(flightInfo.getString("Airline"));
                flight.setFlightNumber(flightInfo.getString("FlightNumber"));
                flight.setTime(flightInfo.getString("Departure"));
                int capacity = Integer.parseInt(flightInfo.getString("Capacity"));
                if (capacity > 0)
                    flight.setCapacity(String.valueOf(capacity));
                else
                    continue;

                boolean isBuisness = false;
                flight.setFlightClass(Flight.ECONOMY_CLASS_FA);

                int flag = 2;

                try {
                    flag = (Integer) flightInfo.get("Business");
                    if (flag == 1)
                        isBuisness = true;
                    else
                        isBuisness = false;
                } catch (ClassCastException e) {
                    isBuisness = flightInfo.getBoolean("Business");
                }

                if (isBuisness) {
                    flight.setFlightClass(findFlightClass(Flight.BUISNESS_CLASS_FA));
                } else {
                    flight.setFlightClass(findFlightClass(Flight.ECONOMY_CLASS_FA));
                }
                if (flightInfo.getBoolean("CharterTime"))
                    flight.setIsCharter(Flight.CHARTER_FALSE);
                else
                    flight.setIsCharter(Flight.CHARTER_TRUE);
                flight.setHost("airplaneticket");
                flight.setCompanyCode(flight.getCompanyCode());
                flight.setLink(makeURL());
                flight.setId();

            }

            if (information.getFlightClass().equals(Flight.ALL_FLIGHT_CLASSES)) {
                if (flight.getFlightClass().contains(Flight.UNKNOWN_CLASS_FA)
                        || flight.getFlightClass().contains(Flight.BUISNESS_CLASS_FA)
                        || flight.getFlightClass().contains(Flight.ECONOMY_CLASS_FA)
                        || flight.getFlightClass().contains(Flight.FIRST_CLASS_FA))
                    addFlight(flight);
            }


            addFlight(flight);
        }

    }

    private String postMethodUrl() {
        return "https://airplaneticket.ir/flights/getFlights";
    }

    @Override
    public void startScrape() throws SocketTimeoutException {
        super.startScrape();
        Response response;
        String requsetBody = makeRequestBody();
        String url = makeURL();
        try {
            response = Jsoup.connect("https://airplaneticket.ir/flights/getFlights").userAgent(userAgent)
                    .header("Host", "airplaneticket.ir")
                    .header("Accept", "application/json, text/javascript, */*; q=0.01").referrer(url)
                    .header("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8").requestBody(requsetBody)
                    .ignoreContentType(true).method(Method.POST).postDataCharset("UTF-8").execute();
            Document document = response.parse();
            findFlights(document, url);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void findFlights(Document document, String link) {
        Gson gson = new Gson();
        JsonObject jsonObject = new JsonObject();
        JsonElement jsonElement = jsonObject.get("FlightInfo");
        JsonObject[] flightsArray = gson.fromJson(jsonElement, JsonObject[].class);

        for (JsonObject flightJson : flightsArray) {
            String flightNumber = flightJson.get("FlightNumber").toString().replaceAll("\"", "");
            String airplane = flightJson.get("Airplane").toString().replaceAll("\"", "");
            String flightCompany = flightJson.get("Airline").toString().replaceAll("\"", "");
            String time = flightJson.get("Departure").toString().replaceAll("\"", "");

            String date = flightJson.get("LeaveDateFa").toString().replaceAll("\"", "");
            String price = calculateFinalPrice(Long.parseLong(flightJson.get("price").toString().replaceAll("\"", "")));
            String capacity = flightJson.get("ClassDetails").toString().replaceAll("\"", "");
            String isCharter = flightJson.get("SystemKeyName").toString().replaceAll("\"", "");
            String flightClass = flightJson.get("kind").toString().replaceAll("\"", "");
            Flight flight = new Flight(flightCompany, capacity, price, flightNumber, date, "airplainticket", link, time,
                    airplane, isCharter, flightClass);
            addFlight(flight);
        }
    }

    private String makeURL() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("https://airplaneticket.ir/flights/");
        stringBuilder.append(srcCityCode + "-" + destCityCode + "/");
        stringBuilder.append(information.getCheckinDate().replaceAll("/", "-"));
        if (information.getIsRoundTrip())
            stringBuilder.append("/" + information.getCheckOutDate().replaceAll("/", "-"));
        return stringBuilder.toString();
    }

    private String makeRequestBody() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("from=[\"" + srcCityCode + "\"]");
        stringBuilder.append("&to=[\"" + destCityCode + "\"]");
        CalendarTool calendarTool = new CalendarTool();
        calendarTool.setIranianDate(information.getCheckinDate());
        int month = calendarTool.getIranianMonth();
        int day = calendarTool.getIranianDay();
        int year = calendarTool.getIranianYear();
        String date = "";

        if (day < 10)
            date += "0" + day + "/";
        else
            date += day + "/";

        if (month < 10)
            date += "0" + month + "/";
        else
            date += month + "/";

        date += year;
        stringBuilder.append("&depart=[\"" + date + "\"]");
        stringBuilder.append("&adl=" + information.getAdults());
        stringBuilder.append("&chd=" + information.getChildren());
        stringBuilder.append("&inf=" + information.getNewBorns());
        stringBuilder.append("&page=" + 1);
        stringBuilder.append("&filters={}");

        return stringBuilder.toString();
    }

}
