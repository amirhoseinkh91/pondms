package ir.viratech.just_ro.manager.website.flight;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import ir.viratech.just_ro.api.flight.dto.config.ServerRequest;
import ir.viratech.just_ro.api.flight.dto.flight.FlightDTO;
import ir.viratech.just_ro.api.flight.dto.flight.FlightResponseDTO;
import ir.viratech.just_ro.api.flight.dto.mrbilit.MrBilitFlightInfo;
import ir.viratech.just_ro.api.flight.dto.mrbilit.MrBilitResponseDTO;
import ir.viratech.just_ro.api.flight.dto.config.FlightWebsiteRequestDTO;
import ir.viratech.just_ro.api.flight.dto.config.QueryDTO;
import ir.viratech.just_ro.api.flight.dto.config.QueryMapDTO;
import ir.viratech.just_ro.api.flight.dto.search.FlightSearchQueryDTO;
import ir.viratech.just_ro.manager.website.flight.flight_utils.FlightClassUtil;
import ir.viratech.just_ro.manager.website.flight.flight_utils.FlightCompanyUtil;
import ir.viratech.just_ro.model.calendar.CalendarTool;
import ir.viratech.just_ro.model.flight.Flight;
import ir.viratech.just_ro.model.flight.exception.FlightCapacityMatchException;
import ir.viratech.just_ro.model.flight.exception.FlightClassMatchException;
import ir.viratech.just_ro.model.flight.exception.ZeroCapacityException;
import ir.viratech.just_ro.model.information.Information;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.text.NumberFormat;
import java.util.*;

public class Mrbilit extends FlightsWebsites {


    private final String host = "MrBilit";
    private String link;

    public Mrbilit() {

    }

    public Mrbilit(Information information) {
        super(information);
    }


    public void makeUrl(FlightSearchQueryDTO searchQueryDTO) {
        FlightsWebsites websites = new Mrbilit();
        String baseUrl = "https://mrbilit.com/flights";
        String cityName = searchQueryDTO.getSource()+ "-" + searchQueryDTO.getDestination();
        String date = searchQueryDTO.getPersianDate().replaceAll("/", "-");
        link = baseUrl + "/" + cityName + "/" + date;
    }

    public FlightResponseDTO getFlightDTOList(MrBilitResponseDTO mrBilitResponseDTO) {
        List<MrBilitFlightInfo> flightInfoList = new ArrayList<>();
        for (MrBilitFlightInfo mrBilitFlightInfo : mrBilitResponseDTO.getFlightInfos())
            flightInfoList.add(mrBilitFlightInfo);
        return getMrBilitFlightDTOList(flightInfoList);
    }

    @SuppressWarnings("Duplicates")
    private FlightResponseDTO getMrBilitFlightDTOList(List<MrBilitFlightInfo> flightInfoList) {

        FlightResponseDTO responseDTO = new FlightResponseDTO();
        List<FlightDTO> flightDTOList = new ArrayList<>();

        for (MrBilitFlightInfo mrBilitFlightInfo : flightInfoList) {
            for (int i = 0; i < mrBilitFlightInfo.getFlightsSize(); i++) {
                FlightDTO flightDTO = new FlightDTO();
                flightDTO.setLink(this.link);
                flightDTO.setPrice(mrBilitFlightInfo.getPayable());
                flightDTO.setFormattedPrice(NumberFormat.getNumberInstance().format(flightDTO.getPrice()));
                flightDTO.setCurrencyFa(FlightDTO.CURRENCY_TOMAN_FA);
                flightDTO.setCurrencyEn(FlightDTO.CURRENCY_TOMAN_EN);
                flightDTO.setFlightNumber(mrBilitFlightInfo.getFlightNumber(i));
                //TODO check with amir
                flightDTO.setFlightClass(FlightClassUtil.convertCodeToPersianClass(mrBilitFlightInfo.getClassCode(i)));
                //TODO check with amir
                flightDTO.setFilghtCompanyNameFa(FlightCompanyUtil.airplaneTicketFlightCompanyNameFa(mrBilitFlightInfo.getCarrier(i)));
                //TODO check with amir
                flightDTO.setFilghtCompanyNameEn(FlightCompanyUtil.airplaneTicketFlightCompanyNameEn(mrBilitFlightInfo.getAirlineEnglish(i)));
                flightDTO.setAirplane(mrBilitFlightInfo.getAirplane(i));
                flightDTO.setCharter(mrBilitFlightInfo.getCharterTime(i));
                String departTime = mrBilitFlightInfo.getDepartTime(i);
                String[] times = StringUtils.split(departTime, " ")[1].split(":");
                flightDTO.setDepartureTime(times[0]+":" + times[1]);
                flightDTO.setArrivalTime(mrBilitFlightInfo.getArrivalTime(i));
                flightDTO.setDepartureDateFa(getIranianDate(mrBilitFlightInfo.getDepartureDate(i).replaceAll("-", "/")));
                flightDTO.setDepartureDateEn(mrBilitFlightInfo.getDepartureDate(i).replaceAll("-", "/"));
                flightDTO.setArrivalDateFa(getIranianDate(mrBilitFlightInfo.getArriveDate(i).replaceAll("-", "/")));
                flightDTO.setArrivalDateEn(mrBilitFlightInfo.getArriveDate(i));
                flightDTO.setCapacity(mrBilitFlightInfo.getCapacity(i));
                flightDTOList.add(flightDTO);
            }
        }

        responseDTO.setFlightDTOS(flightDTOList);
        return responseDTO;
    }

    @SuppressWarnings("Duplicates")
    private String getIranianDate(String gerigorianDate) {
        String[] parts = gerigorianDate.split("/");
        int year = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int day = Integer.parseInt(parts[2]);
        CalendarTool calendarTool = new CalendarTool();
        calendarTool.setGregorianDate(year, month, day);
        return calendarTool.getIranianDate();

    }

    public FlightWebsiteRequestDTO getFlightWebsiteRequestDTO() {
        ServerRequest serverRequest = new ServerRequest();
        makeServerRequest(serverRequest);
        FlightWebsiteRequestDTO flightWebsiteRequestDTO = new FlightWebsiteRequestDTO();
        flightWebsiteRequestDTO.setServerRequest(serverRequest);
        flightWebsiteRequestDTO.setBaseUrl("https://mrbilit.com/flights/getFlights2");
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
        serverRequest.setApi("/api/v1/flight/mrbilit");
        serverRequest.setMethod(String.valueOf(ServerRequest.Method.Post));
        @SuppressWarnings("unchecked")
        Map<String, String> map = new HashedMap();
        map.put("Content-Type", "application/json");
        serverRequest.setRequestHeaders(map);
    }


    private QueryDTO getQueries() {
        QueryDTO queryDTO = new QueryDTO();
        queryDTO.setAdult(getAdult());
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

    private QueryMapDTO getInfant() {
        QueryMapDTO queryMapDTO = new QueryMapDTO();
        queryMapDTO.setKey("inf");
        queryMapDTO.setDataType(QueryMapDTO.DataType.Integer);
        return queryMapDTO;
    }

    private QueryMapDTO getAdult() {
        QueryMapDTO queryMapDTO = new QueryMapDTO();
        queryMapDTO.setKey("adl");
        queryMapDTO.setDataType(QueryMapDTO.DataType.Integer);
        return queryMapDTO;
    }

    private QueryMapDTO getChildren() {
        QueryMapDTO queryMapDTO = new QueryMapDTO();
        queryMapDTO.setKey("chd");
        queryMapDTO.setDataType(QueryMapDTO.DataType.Integer);
        return queryMapDTO;
    }

    private Map<String, String> getRequestHeaders() {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/x-www-form-urlencoded");
        return headers;
    }

    @Override
    protected void myStartScrape() throws SocketTimeoutException {
        super.myStartScrape();
        Response response = null;
        String baseURL = "https://mrbilit.com/flights/getFlights";
        String referrer = makeReferrer();
        this.link = referrer;
        String reqBody = makeRequestBody();
        try {
            response = Jsoup.connect(baseURL).userAgent(userAgent).referrer(referrer)
                    .header("Accept", "text/html").requestBody(reqBody).method(Method.POST)
                    .ignoreContentType(true).execute();
            response.charset("UTF-8");
            findFlights(response.body());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (FlightClassMatchException e) {
            return;
        }
    }

    @SuppressWarnings({"TryWithIdenticalCatches", "UnnecessaryContinue"})
    private void findFlights(String response) throws FlightClassMatchException {
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(response, JsonObject.class);
        JsonArray jsonArray = (JsonArray) jsonObject.get("FlightInfo");
        for (int i = 0; i < jsonArray.size(); i++) {
            JsonObject jsonFlight = (JsonObject) jsonArray.get(i);
            try {
                findDetails(jsonFlight);
            } catch (ZeroCapacityException e) {
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

    private void findDetails(JsonObject jsonFlight)
            throws ZeroCapacityException, FlightClassMatchException, FlightCapacityMatchException {
        JsonObject json = (JsonObject) jsonFlight.get("Flights").getAsJsonArray().get(0);

        String price = calculateFinalPrice(Long.parseLong(jsonFlight.get("payable").toString()));
        if (price.equals("0") || price == null)
            throw new NullPointerException();

        String flightCompany = getFlightCompany(json);
        if (flightCompany.equals("") | flightCompany.equals(" "))
            throw new NullPointerException();
        String airplane = getFlightAirPlane(json);
        if (airplane.equals("") | airplane.equals(" "))
            throw new NullPointerException();
        String flightNumber = getFlightNumber(json);
        if (flightNumber.equals("") | flightNumber.equals(" "))
            throw new NullPointerException();
        String time = getFlightTime(json);
        String date = dateChecker(getFlightDate(json));

        String capacity = getFlightCapacity(json);

        String flightClass = getFlightClass(json);
        String isCharter = getFlightIsCharter(json);
        Flight flight = new Flight(flightCompany, capacity, price, flightNumber, date, host, link, time, airplane,
                isCharter, flightClass);

        if (information.getFlightClass().equals(Flight.ALL_FLIGHT_CLASSES)) {
            if (flight.getFlightClass().contains(Flight.UNKNOWN_CLASS_FA)
                    || flight.getFlightClass().contains(Flight.BUISNESS_CLASS_FA)
                    || flight.getFlightClass().contains(Flight.ECONOMY_CLASS_FA)
                    || flight.getFlightClass().contains(Flight.FIRST_CLASS_FA)) {
                addFlight(flight);
            }
        }
        if (!flight.getFlightClass().equals(Flight.UNKNOWN_CLASS_FA)) {
            addFlight(flight);
        }
    }

    private String getFlightIsCharter(JsonObject json) {
        String isCharter;
        if (json.get("FullCharter").getAsBoolean()) {
            isCharter = "چارتر";
        } else {
            isCharter = "سیستمی";
        }
        return isCharter;
    }

    private String getFlightClass(JsonObject json) throws FlightClassMatchException {
        String classCode = json.get("Class").toString().replaceAll("\"", "");
        String flightClass = findFlightClass(convertCodeToPersianClass(classCode));
        return flightClass;
    }

    private String getFlightCapacity(JsonObject json) throws ZeroCapacityException, FlightCapacityMatchException {
        final String[] englishNums = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        final String[] persianNums = {"۰", "۱", "۲", "۳", "۴", "۵", "۶", "۷", "۸", "۹"};
        String capacityStr = "";
        try {
            capacityStr = json.get("Capacity").toString().replaceAll("\"", "");
            checkCapacity(Integer.parseInt(capacityStr));
            for (int i = 0; i < englishNums.length; i++) {
                if (capacityStr.equals("0")) {
                    throw new ZeroCapacityException();
                }
                if (capacityStr.equals(englishNums[i])) {
                    capacityStr = persianNums[i];
                }
            }
            capacityStr = "ظرفیت" + " " + capacityStr + " " + "نفر";
            return capacityStr;
        } catch (FlightCapacityMatchException e) {
            throw new FlightCapacityMatchException();
        } catch (Exception e) {
            return Flight.UNKNOWN_CAPACIY_FA;
        }

    }

    private String getFlightDate(JsonObject json) {
        String[] parts = json.get("DepartureTime").toString().replaceAll("\"", "").split(" ");
        CalendarTool calendarTool = new CalendarTool();
        String[] dateParts = parts[0].replaceAll("\"", "").split("-");
        int day = Integer.parseInt(dateParts[2]);
        int month = Integer.parseInt(dateParts[1]);
        int year = Integer.parseInt(dateParts[0]);
        calendarTool.setGregorianDate(year, month, day);
        return calendarTool.getIranianDate();
    }

    private String getFlightTime(JsonObject json) {
        String[] parts = json.get("DepartureTime").toString().replaceAll("\"", "").split(" ");
        return parts[1].replaceAll("\"", "").substring(0, parts[1].length() - 3);
    }

    private String getFlightNumber(JsonObject json) {
        return json.get("FlightNumber").toString().replaceAll("\"", "");
    }

    private String getFlightAirPlane(JsonObject json) {
        return json.get("Airplane").toString().replaceAll("\"", "");
    }

    private String getFlightCompany(JsonObject json) {
        return json.get("Airline").toString().replaceAll("\"", "");
    }

    private String makeReferrer() {
        StringBuilder builder = new StringBuilder();
        builder.append("https://mrbilit.com/flights/");
        builder.append(srcCityCode);
        builder.append("-");
        builder.append(destCityCode);
        builder.append("/");
        builder.append(information.getCheckinDate().replaceAll("/", "-"));
        return builder.toString();
    }

    private String makeRequestBody() {
        CalendarTool calendar = new CalendarTool();
        calendar.setIranianDate(information.getCheckinDate());
        String day = getDay(calendar);
        String month = getMonth(calendar);
        String year = getYear(calendar);

        StringBuilder builder = new StringBuilder();
        builder.append("from=[\"");
        builder.append(srcCityCode);
        builder.append("\"]&to=[\"");
        builder.append(destCityCode);
        builder.append("\"]&depart=[\"");
        builder.append(day + "/" + month + "/" + year + "\"]");
        builder.append("&adl=" + information.getPassengers());
        builder.append("&chd=" + information.getChildren());
        builder.append("&inf=" + information.getNewBorns());
        return builder.toString();
    }

    private String getDay(CalendarTool calendar) {
        if (calendar.getIranianDay() < 10)
            return "0" + calendar.getIranianDay();
        else
            return String.valueOf(calendar.getIranianDay());
    }

    private String getMonth(CalendarTool calendar) {
        if (calendar.getIranianMonth() < 10)
            return "0" + calendar.getIranianMonth();
        else
            return String.valueOf(calendar.getIranianMonth());
    }

    private String getYear(CalendarTool calendar) {
        return String.valueOf(calendar.getIranianYear());
    }

}
