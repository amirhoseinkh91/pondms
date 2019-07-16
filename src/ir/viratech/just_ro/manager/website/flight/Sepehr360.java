package ir.viratech.just_ro.manager.website.flight;

import ir.viratech.base.SuppressWarningsOption;
import ir.viratech.just_ro.api.flight.dto.config.ServerRequest;
import ir.viratech.just_ro.api.flight.dto.flight.FlightDTO;
import ir.viratech.just_ro.api.flight.dto.flight.FlightResponseDTO;
import ir.viratech.just_ro.api.flight.dto.config.FlightWebsiteRequestDTO;
import ir.viratech.just_ro.api.flight.dto.config.QueryDTO;
import ir.viratech.just_ro.api.flight.dto.config.QueryMapDTO;
import ir.viratech.just_ro.api.flight.dto.search.FlightSearchQueryDTO;
import ir.viratech.just_ro.api.flight.dto.sepehr360.*;
import ir.viratech.just_ro.manager.website.flight.flight_utils.FlightCompanyUtil;
import ir.viratech.just_ro.model.flight.Flight;
import org.apache.commons.collections.map.HashedMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by justro on 2/6/18.
 */

@SuppressWarnings({SuppressWarningsOption.UNUSED, SuppressWarningsOption.SPELL_CHECKING_INSPECTION})
public class Sepehr360 extends FlightsWebsites {
    private String link;

    @Override
    public FlightWebsiteRequestDTO getFlightWebsiteRequestDTO() {
        ServerRequest serverRequest = new ServerRequest();
        makeServerRequest(serverRequest);
        FlightWebsiteRequestDTO flightWebsiteRequestDTO = new FlightWebsiteRequestDTO();
        flightWebsiteRequestDTO.setServerRequest(serverRequest);
        flightWebsiteRequestDTO.setBaseUrl("https://sepehr360.com/fa/Api/FlightApi/FlightSearchGrouped");
        flightWebsiteRequestDTO.setHttpMethod(FlightWebsiteRequestDTO.HttpMethod.POST);
        flightWebsiteRequestDTO.setRequestHeaders(getRequestHeaders());
        flightWebsiteRequestDTO.setRequestBody(true);
        flightWebsiteRequestDTO.setQueryTypeList(makeQueryType());
        flightWebsiteRequestDTO.setQueries(getQueries());
        return flightWebsiteRequestDTO;
    }

    private List<FlightWebsiteRequestDTO.QueryType> makeQueryType(){
        List<FlightWebsiteRequestDTO.QueryType> queryTypes = new ArrayList<>();
        queryTypes.add(FlightWebsiteRequestDTO.QueryType.Json);
        return queryTypes;
    }

    private void makeServerRequest(ServerRequest serverRequest) {

        serverRequest.setApi("/api/v1/flight/sepehr360");
        serverRequest.setMethod(String.valueOf(ServerRequest.Method.Post));
        Map<String , String> map = new HashedMap();
        map.put("Content-Type" , "application/json");
        serverRequest.setRequestHeaders(map);
    }

    private QueryDTO getQueries() {
        QueryDTO queryDTO = new QueryDTO();
        queryDTO.setDateFormat("yyyy/mm/dd");
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
        queryMapDTO.setKey("StartDate");
        queryMapDTO.setDataType(QueryMapDTO.DataType.String);
        return queryMapDTO;
    }

    private QueryMapDTO getDstCity() {
        QueryMapDTO queryMapDTO = new QueryMapDTO();
        queryMapDTO.setKey("To");
        queryMapDTO.setDataType(QueryMapDTO.DataType.String);
        return queryMapDTO;
    }

    private QueryMapDTO getSrcCity() {
        QueryMapDTO queryMapDTO = new QueryMapDTO();
        queryMapDTO.setKey("From");
        queryMapDTO.setDataType(QueryMapDTO.DataType.String);
        return queryMapDTO;
    }

    private Map<String, String> getRequestHeaders() {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        return headers;
    }

    public FlightResponseDTO getFlightDTOList(Sepehr360ResponseDTO sepehrResponseDTO) {
        FlightResponseDTO responseDTO = new FlightResponseDTO();
        List<FlightDTO> flightDTOS = new ArrayList<>();
        for (Sepehr360FlightDTO sepehrFlightDTO : sepehrResponseDTO.getFlights()) {
            if (!sepehrFlightDTO.getAds()) {
                flightDTOS.addAll(fillEachSepehrFlightDtoObj(sepehrFlightDTO));
            }
        }
        responseDTO.setFlightDTOS(flightDTOS);
        responseDTO.setItemsCount(flightDTOS.size());
        return responseDTO;
    }

    private List<FlightDTO> fillEachSepehrFlightDtoObj(Sepehr360FlightDTO sepehrFlightDTO) {
        List<FlightDTO> flightDTOList = new ArrayList<>();
        for (Sepehr360FlightItemDTO flightItem : sepehrFlightDTO.getFlightItems()) {
            if (flightItem.getFlightItemType().equals("SINGLE_SUPPLIER_FLIGHT")) {
                Sepehr360FlightItemInfoDTO flightInfo = flightItem.getFlightInfo();
                if (!flightInfo.getAds()) {
                    FlightDTO flightDTO = getFlightDTO(flightInfo);
                    if (!(flightDTO.getCapacity() == null || flightDTO.getCapacity() == 0)) {
                        flightDTOList.add(flightDTO);
                    }
                }
            } else if (flightItem.getFlightItemType().equals("MULTIPLE_SUPPLIER_FLIGHT")) {
                List<Sepehr360FlightItemInfoDTO> flightItemInfoList = flightItem.getFlightItemInfoList();
                for (Sepehr360FlightItemInfoDTO flightInfo : flightItemInfoList) {
                    if (!flightInfo.getAds()) {
                        FlightDTO flightDTO = getFlightDTO(flightInfo);
                        if (!(flightDTO.getCapacity() == null || flightDTO.getCapacity() == 0)) {
                            flightDTOList.add(flightDTO);
                        }
                    }
                }
            }
        }
        return flightDTOList;

    }

    private FlightDTO getFlightDTO(Sepehr360FlightItemInfoDTO flightInfo) {

        FlightDTO flightDTO = new FlightDTO();
        flightDTO.setLink("https://www.sepehr360.com/fa" + flightInfo.getAgencyAddress());
        flightDTO.setPrice((flightInfo.getPrice()) * 10);
        flightDTO.setFormattedPrice(flightInfo.getFormatedPrice());
        flightDTO.setCurrencyFa(FlightDTO.CURRENCY_TOMAN_FA);
        flightDTO.setCurrencyEn(FlightDTO.CURRENCY_TOMAN_EN);
        flightDTO.setFlightNumber(flightInfo.getFlightNumber());
        //TODO yet didnt find anyThing
        flightDTO.setFlightClass(findFlightClass(flightInfo));
        //TODO check with amir
        flightDTO.setFilghtCompanyNameEn(FlightCompanyUtil.sepehr360EnglishName(flightInfo.getAirLineTitleEn()));
        flightDTO.setFilghtCompanyNameFa(FlightCompanyUtil.flightCompanyNameFa(flightInfo.getAirLineTitle()));
        flightDTO.setAirplane(flightInfo.getAirPlane());
        flightDTO.setCharter(false);
        flightDTO.setDepartureTime(flightInfo.getDepartureTime());
        flightDTO.setArrivalTime(flightInfo.getArrivalTime());
        flightDTO.setDepartureDateFa(flightInfo.getJalaliDepartureDate().getShortDateString().replaceAll("-", "/"));
        flightDTO.setDepartureDateEn(flightInfo.getGregorianDepartureDate().getDate());
        flightDTO.setArrivalDateFa(null);
        flightDTO.setArrivalDateEn(flightInfo.getArrivalDateTime().split("T")[0]);
        Integer capacity = flightInfo.getQuantities().get(0).getQuantity();
        flightDTO.setCapacity(capacity);
        return flightDTO;
    }

    private String getFlightCompanyName(int code) {

        switch (code) {
            case 8:
                return Flight.IRAN_AIR_TOUR_AIRLINE;
            case 21:
                return Flight.TABAN_AIRLINE;
            case 44:
                return Flight.GHESHM_AIRLINE;
            case 73:
                return Flight.ZAGROS_AIRLINE;
            case 27:
                return Flight.CASPIAN_AIRLINE;
            case 69:
                return Flight.KISH_AIRLINE;
            case 14:
                return Flight.IRAN_ASEMAN_AIRLINE;
            case 26:
                return Flight.SAHA_AIRLINE;
            case 22:
                return Flight.ATA_AIRLINE;
            default:
                System.out.println(code);
                return "نامشخص";
        }

    }

    private String findFlightClass(Sepehr360FlightItemInfoDTO flightInfo) {
        String classType = flightInfo.getPriceList().get(0).getFlightByFareClass().getFareClassTitle();
        if (classType.equals("Economy"))
            return Flight.ECONOMY_CLASS_FA;
        if(classType.equals("Business"))
            return Flight.BUISNESS_CLASS_FA;
        return Flight.UNKNOWN_CLASS_FA;
    }


}