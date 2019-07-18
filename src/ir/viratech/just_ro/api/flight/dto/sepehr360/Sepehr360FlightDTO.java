package ir.viratech.just_ro.api.flight.dto.sepehr360;


import com.fasterxml.jackson.annotation.JsonProperty;
import ir.viratech.base.SuppressWarningsOption;

import java.util.List;

// TODO @Amir implement this class
@SuppressWarnings({SuppressWarningsOption.SPELL_CHECKING_INSPECTION,SuppressWarningsOption.UNUSED})
public class Sepehr360FlightDTO {

    @JsonProperty("FirstAdevrtisment")
    private String firstAdevrtisment;
    @JsonProperty("SecondAdevrtisment")
    private String secondAdevrtisment;
    @JsonProperty("LinkFirstAdevrtisment")
    private String linkFirstAdevrtisment;
    @JsonProperty("LinkSecondAdevrtisment")
    private String linkSecondAdevrtisment;
    @JsonProperty("IsAds")
    private Boolean ads;
    @JsonProperty("IsFirstBetweenResultAds")
    private Boolean firstBetweenResultAds;
    @JsonProperty("IsMobileBetweenResultAds")
    private Boolean mobileBetweenResultAds;
    @JsonProperty("AirLineId")
    private Integer airLineId;
    // TODO check
    @JsonProperty("ServerName")
    private Object serverName;
    //TODO
    @JsonProperty("FlightNumber")
    private String flightNumber;

    //TODO maybe an object
    @JsonProperty("ToolTip")
    private String toolTip;
    @JsonProperty("DepartureDateTime")
    private String departureDateTime;
    @JsonProperty("ArrivalDateTime")
    private String arrivalDateTime;
    @JsonProperty("SourceLocationCode")
    private String srcLocationCode;
    @JsonProperty("DestinationLocationCode")
    private String dstLocationCode;
    @JsonProperty("AirLineTitle")
    private String airLineTitle;
    @JsonProperty("AirLineTitleEn")
    private String airLineTitleEn;
    @JsonProperty("AirLineIataCode")
    private String airLineIataCode;
    @JsonProperty("AirPlane")
    private String airPlane;
    @JsonProperty("Destination")
    private String destination;
    @JsonProperty("Source")
    private String source;
    @JsonProperty("Description")
    private String description;
    @JsonProperty("AirLineImage")
    private String airLineImage;
    @JsonProperty("RPH")
    private String rph;
    @JsonProperty("DepartureTime")
    private String departureTime;
    @JsonProperty("ArrivalTime")
    private String arrivalTime;
    // todo what is this ? check
    @JsonProperty("MarketingCabinRph")
    private Object marketingCabinRph;
    @JsonProperty("Quantity")
    private List<Sepehr360FlightQuantityDTO> quantities;
    @JsonProperty("PriceList")
    private List<Sepehr360FlightPriceDTO> priceList;
    @JsonProperty("FilterdPriceList")
    private List<Sepehr360FlightPriceDTO> filterdPriceList;
    @JsonProperty("RankDatas")
    private List<Sepehr360FlightItemInfoRankDTO> rankDataList;
    @JsonProperty("RowNumber")
    private Integer rowNumber;
    @JsonProperty("RankCount")
    private Integer rankCount;
    @JsonProperty("FlightCount")
    private Integer flightCount;
    @JsonProperty("FlightPolicyWarningList")
    private List<Sepehr360FlightPolicyWarningDTO> flightPolicyWarningList;
    // todo
    @JsonProperty("BusinessFlightList")
    private Object businessFlightList;
    @JsonProperty("JalaliDepartureDate")
    private Sepehr360FlightJalaliDateDTO jalaliDepartureDate;
    @JsonProperty("GregorianDepartureDate")
    private Sepehr360FlightGregorianDateDTO gregorianDepartureDate;
    @JsonProperty("Price")
    private Double price;
    @JsonProperty("FormatedPrice")
    private String formatedPrice;
    @JsonProperty("FlightItems")
    private List<Sepehr360FlightItemDTO> flightItems;
    @JsonProperty("RoutID")
    private Integer routId;
    // todo
    @JsonProperty("BackFlight")
    private Object backFlight;
    @JsonProperty("DepartureAirportPersianName")
    private String departureAirportPersianName;
    @JsonProperty("DepartureAirportEnglishName")
    private String departureAirportEnglishName;
    @JsonProperty("ArrivalAirportPersianName")
    private String arrivalAirportPersianName;
    @JsonProperty("ArrivalAirportEnglishName")
    private String arrivalAirportEnglishName;
    @JsonProperty("StopCount")
    private Integer stopCount;
    // todo
    @JsonProperty("TimeStamp")
    private Object timeStamp;

    public String getFirstAdevrtisment() {
        return firstAdevrtisment;
    }

    public void setFirstAdevrtisment(String firstAdevrtisment) {
        this.firstAdevrtisment = firstAdevrtisment;
    }

    public String getSecondAdevrtisment() {
        return secondAdevrtisment;
    }

    public void setSecondAdevrtisment(String secondAdevrtisment) {
        this.secondAdevrtisment = secondAdevrtisment;
    }

    public String getLinkFirstAdevrtisment() {
        return linkFirstAdevrtisment;
    }

    public void setLinkFirstAdevrtisment(String linkFirstAdevrtisment) {
        this.linkFirstAdevrtisment = linkFirstAdevrtisment;
    }

    public String getLinkSecondAdevrtisment() {
        return linkSecondAdevrtisment;
    }

    public void setLinkSecondAdevrtisment(String linkSecondAdevrtisment) {
        this.linkSecondAdevrtisment = linkSecondAdevrtisment;
    }

    public Boolean getAds() {
        return ads;
    }

    public void setAds(Boolean ads) {
        this.ads = ads;
    }

    public Boolean getFirstBetweenResultAds() {
        return firstBetweenResultAds;
    }

    public void setFirstBetweenResultAds(Boolean firstBetweenResultAds) {
        this.firstBetweenResultAds = firstBetweenResultAds;
    }

    public Boolean getMobileBetweenResultAds() {
        return mobileBetweenResultAds;
    }

    public void setMobileBetweenResultAds(Boolean mobileBetweenResultAds) {
        this.mobileBetweenResultAds = mobileBetweenResultAds;
    }

    public Integer getAirLineId() {
        return airLineId;
    }

    public void setAirLineId(Integer airLineId) {
        this.airLineId = airLineId;
    }

    public Object getServerName() {
        return serverName;
    }

    public void setServerName(Object serverName) {
        this.serverName = serverName;
    }

    public Object getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getToolTip() {
        return toolTip;
    }

    public void setToolTip(String toolTip) {
        this.toolTip = toolTip;
    }

    public String getDepartureDateTime() {
        return departureDateTime;
    }

    public void setDepartureDateTime(String departureDateTime) {
        this.departureDateTime = departureDateTime;
    }

    public String getArrivalDateTime() {
        return arrivalDateTime;
    }

    public void setArrivalDateTime(String arrivalDateTime) {
        this.arrivalDateTime = arrivalDateTime;
    }

    public String getSrcLocationCode() {
        return srcLocationCode;
    }

    public void setSrcLocationCode(String srcLocationCode) {
        this.srcLocationCode = srcLocationCode;
    }

    public String getDstLocationCode() {
        return dstLocationCode;
    }

    public void setDstLocationCode(String dstLocationCode) {
        this.dstLocationCode = dstLocationCode;
    }

    public String getAirLineTitle() {
        return airLineTitle;
    }

    public void setAirLineTitle(String airLineTitle) {
        this.airLineTitle = airLineTitle;
    }

    public String getAirLineTitleEn() {
        return airLineTitleEn;
    }

    public void setAirLineTitleEn(String airLineTitleEn) {
        this.airLineTitleEn = airLineTitleEn;
    }

    public String getAirLineIataCode() {
        return airLineIataCode;
    }

    public void setAirLineIataCode(String airLineIataCode) {
        this.airLineIataCode = airLineIataCode;
    }

    public String getAirPlane() {
        return airPlane;
    }

    public void setAirPlane(String airPlane) {
        this.airPlane = airPlane;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAirLineImage() {
        return airLineImage;
    }

    public void setAirLineImage(String airLineImage) {
        this.airLineImage = airLineImage;
    }

    public String getRph() {
        return rph;
    }

    public void setRph(String rph) {
        this.rph = rph;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Object getMarketingCabinRph() {
        return marketingCabinRph;
    }

    public void setMarketingCabinRph(Object marketingCabinRph) {
        this.marketingCabinRph = marketingCabinRph;
    }

    public List<Sepehr360FlightQuantityDTO> getQuantities() {
        return quantities;
    }

    public void setQuantities(List<Sepehr360FlightQuantityDTO> quantities) {
        this.quantities = quantities;
    }

    public List<Sepehr360FlightPriceDTO> getPriceList() {
        return priceList;
    }

    public void setPriceList(List<Sepehr360FlightPriceDTO> priceList) {
        this.priceList = priceList;
    }

    public List<Sepehr360FlightPriceDTO> getFilterdPriceList() {
        return filterdPriceList;
    }

    public void setFilterdPriceList(List<Sepehr360FlightPriceDTO> filterdPriceList) {
        this.filterdPriceList = filterdPriceList;
    }

    public List<Sepehr360FlightItemInfoRankDTO> getRankDataList() {
        return rankDataList;
    }

    public void setRankDataList(List<Sepehr360FlightItemInfoRankDTO> rankDataList) {
        this.rankDataList = rankDataList;
    }

    public Integer getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(Integer rowNumber) {
        this.rowNumber = rowNumber;
    }

    public Integer getRankCount() {
        return rankCount;
    }

    public void setRankCount(Integer rankCount) {
        this.rankCount = rankCount;
    }

    public Integer getFlightCount() {
        return flightCount;
    }

    public void setFlightCount(Integer flightCount) {
        this.flightCount = flightCount;
    }

    public List<Sepehr360FlightPolicyWarningDTO> getFlightPolicyWarningList() {
        return flightPolicyWarningList;
    }

    public void setFlightPolicyWarningList(List<Sepehr360FlightPolicyWarningDTO> flightPolicyWarningList) {
        this.flightPolicyWarningList = flightPolicyWarningList;
    }

    public Object getBusinessFlightList() {
        return businessFlightList;
    }

    public void setBusinessFlightList(Object businessFlightList) {
        this.businessFlightList = businessFlightList;
    }

    public Sepehr360FlightJalaliDateDTO getJalaliDepartureDate() {
        return jalaliDepartureDate;
    }

    public void setJalaliDepartureDate(Sepehr360FlightJalaliDateDTO jalaliDepartureDate) {
        this.jalaliDepartureDate = jalaliDepartureDate;
    }

    public Sepehr360FlightGregorianDateDTO getGregorianDepartureDate() {
        return gregorianDepartureDate;
    }

    public void setGregorianDepartureDate(Sepehr360FlightGregorianDateDTO gregorianDepartureDate) {
        this.gregorianDepartureDate = gregorianDepartureDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getFormatedPrice() {
        return formatedPrice;
    }

    public void setFormatedPrice(String formatedPrice) {
        this.formatedPrice = formatedPrice;
    }

    public List<Sepehr360FlightItemDTO> getFlightItems() {
        return flightItems;
    }

    public void setFlightItems(List<Sepehr360FlightItemDTO> flightItems) {
        this.flightItems = flightItems;
    }

    public Integer getRoutId() {
        return routId;
    }

    public void setRoutId(Integer routId) {
        this.routId = routId;
    }

    public Object getBackFlight() {
        return backFlight;
    }

    public void setBackFlight(Object backFlight) {
        this.backFlight = backFlight;
    }

    public String getDepartureAirportPersianName() {
        return departureAirportPersianName;
    }

    public void setDepartureAirportPersianName(String departureAirportPersianName) {
        this.departureAirportPersianName = departureAirportPersianName;
    }

    public String getDepartureAirportEnglishName() {
        return departureAirportEnglishName;
    }

    public void setDepartureAirportEnglishName(String departureAirportEnglishName) {
        this.departureAirportEnglishName = departureAirportEnglishName;
    }

    public String getArrivalAirportPersianName() {
        return arrivalAirportPersianName;
    }

    public void setArrivalAirportPersianName(String arrivalAirportPersianName) {
        this.arrivalAirportPersianName = arrivalAirportPersianName;
    }

    public String getArrivalAirportEnglishName() {
        return arrivalAirportEnglishName;
    }

    public void setArrivalAirportEnglishName(String arrivalAirportEnglishName) {
        this.arrivalAirportEnglishName = arrivalAirportEnglishName;
    }

    public Integer getStopCount() {
        return stopCount;
    }

    public void setStopCount(Integer stopCount) {
        this.stopCount = stopCount;
    }

    public Object getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Object timeStamp) {
        this.timeStamp = timeStamp;
    }
}
