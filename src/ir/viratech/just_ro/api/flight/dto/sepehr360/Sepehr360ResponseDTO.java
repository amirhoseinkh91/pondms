package ir.viratech.just_ro.api.flight.dto.sepehr360;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.viratech.base.SuppressWarningsOption;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({SuppressWarningsOption.SPELL_CHECKING_INSPECTION, SuppressWarningsOption.UNUSED})
public class Sepehr360ResponseDTO {

    @JsonProperty("RecordCount")
    private Integer recordCount;

    @JsonProperty("TwoWayMinPrice")
    private String twoWayMinPrice;

    // TODO what is this
    @JsonProperty("SiteErrorList")
    private List<Object> siteErrorList;

    @JsonProperty("FromCity")
    private String srcCity;

    @JsonProperty("ToCity")
    private String dstCity;

    @JsonProperty("TourMinPrice")
    private String tourMinPrice;

    @JsonProperty("HasError")
    private Boolean hasError;

    @JsonProperty("IsLogin")
    private Boolean isLogin;

    @JsonProperty("IntervalDay")
    private Integer intervalDay;

    @JsonProperty("JalaliDepartureDate")
    private String jalaliDepartureDate;

    @JsonProperty("JalaliDepartureDateFormatted")
    private String jalaliDepartureDateFormatted;

    @JsonProperty("GregorianDepartureDate")
    private String gregorianDepartureDate;

    @JsonProperty("IsDepartureDateToday")
    private Boolean isDepartureDateToday;

    @JsonProperty("HasAnyFlight")
    private Boolean hasAnyFlight;

    // TODO what is this
    @JsonProperty("EarliestAndCheapestFlightsInTwoWeeksLater")
    private Object earliestAndCheapestFlightsInTwoWeeksLater;

    @JsonProperty("AirLineLowestPriceList")
    private List<Sepehr360AirLineLowestPriceDTO> airLineLowestPriceList;

    @JsonProperty("MinPriceByDayList")
    private List<Sepehr360MinPriceByDayDTO> minPriceByDayList;

    @JsonProperty("MinPriceByFareClassList")
    private List<Sepehr360MinPriceByFareClassDTO> minPriceByFareClassList;

    @JsonProperty("MinPriceTitle")
    private Sepehr360MinPriceTitleDTO minPriceTitle;

    @JsonProperty("FlightList")
    private List<Sepehr360FlightDTO> flights;

    public Integer getRecordCount() {
        return recordCount;
    }

    public void setRecordCount(Integer recordCount) {
        this.recordCount = recordCount;
    }

    public String getTwoWayMinPrice() {
        return twoWayMinPrice;
    }

    public void setTwoWayMinPrice(String twoWayMinPrice) {
        this.twoWayMinPrice = twoWayMinPrice;
    }

    public List<Object> getSiteErrorList() {
        return siteErrorList;
    }

    public void setSiteErrorList(List<Object> siteErrorList) {
        this.siteErrorList = siteErrorList;
    }

    public String getSrcCity() {
        return srcCity;
    }

    public void setSrcCity(String srcCity) {
        this.srcCity = srcCity;
    }

    public String getDstCity() {
        return dstCity;
    }

    public void setDstCity(String dstCity) {
        this.dstCity = dstCity;
    }

    public String getTourMinPrice() {
        return tourMinPrice;
    }

    public void setTourMinPrice(String tourMinPrice) {
        this.tourMinPrice = tourMinPrice;
    }

    public Boolean getHasError() {
        return hasError;
    }

    public void setHasError(Boolean hasError) {
        this.hasError = hasError;
    }

    public Boolean getLogin() {
        return isLogin;
    }

    public void setLogin(Boolean login) {
        isLogin = login;
    }

    public Integer getIntervalDay() {
        return intervalDay;
    }

    public void setIntervalDay(Integer intervalDay) {
        this.intervalDay = intervalDay;
    }

    public String getJalaliDepartureDate() {
        return jalaliDepartureDate;
    }

    public void setJalaliDepartureDate(String jalaliDepartureDate) {
        this.jalaliDepartureDate = jalaliDepartureDate;
    }

    public String getJalaliDepartureDateFormatted() {
        return jalaliDepartureDateFormatted;
    }

    public void setJalaliDepartureDateFormatted(String jalaliDepartureDateFormatted) {
        this.jalaliDepartureDateFormatted = jalaliDepartureDateFormatted;
    }

    public String getGregorianDepartureDate() {
        return gregorianDepartureDate;
    }

    public void setGregorianDepartureDate(String gregorianDepartureDate) {
        this.gregorianDepartureDate = gregorianDepartureDate;
    }

    public Boolean getDepartureDateToday() {
        return isDepartureDateToday;
    }

    public void setDepartureDateToday(Boolean departureDateToday) {
        isDepartureDateToday = departureDateToday;
    }

    public Boolean getHasAnyFlight() {
        return hasAnyFlight;
    }

    public void setHasAnyFlight(Boolean hasAnyFlight) {
        this.hasAnyFlight = hasAnyFlight;
    }

    public Object getEarliestAndCheapestFlightsInTwoWeeksLater() {
        return earliestAndCheapestFlightsInTwoWeeksLater;
    }

    public void setEarliestAndCheapestFlightsInTwoWeeksLater(Object earliestAndCheapestFlightsInTwoWeeksLater) {
        this.earliestAndCheapestFlightsInTwoWeeksLater = earliestAndCheapestFlightsInTwoWeeksLater;
    }

    public List<Sepehr360AirLineLowestPriceDTO> getAirLineLowestPriceList() {
        return airLineLowestPriceList;
    }

    public void setAirLineLowestPriceList(List<Sepehr360AirLineLowestPriceDTO> airLineLowestPriceList) {
        this.airLineLowestPriceList = airLineLowestPriceList;
    }

    public List<Sepehr360MinPriceByDayDTO> getMinPriceByDayList() {
        return minPriceByDayList;
    }

    public void setMinPriceByDayList(List<Sepehr360MinPriceByDayDTO> minPriceByDayList) {
        this.minPriceByDayList = minPriceByDayList;
    }

    public List<Sepehr360MinPriceByFareClassDTO> getMinPriceByFareClassList() {
        return minPriceByFareClassList;
    }

    public void setMinPriceByFareClassList(List<Sepehr360MinPriceByFareClassDTO> minPriceByFareClassList) {
        this.minPriceByFareClassList = minPriceByFareClassList;
    }

    public Sepehr360MinPriceTitleDTO getMinPriceTitle() {
        return minPriceTitle;
    }

    public void setMinPriceTitle(Sepehr360MinPriceTitleDTO minPriceTitle) {
        this.minPriceTitle = minPriceTitle;
    }

    public List<Sepehr360FlightDTO> getFlights() {
        if (flights != null)
            return flights;
        return new ArrayList<>();
    }

    public void setFlights(List<Sepehr360FlightDTO> flights) {
        this.flights = flights;
    }
}
