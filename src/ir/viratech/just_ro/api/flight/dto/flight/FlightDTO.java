package ir.viratech.just_ro.api.flight.dto.flight;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import ir.viratech.base.SuppressWarningsOption;
import ir.viratech.just_ro.manager.website.flight.flight_utils.FlightCompanyUtil;
import ir.viratech.just_ro.model.flight.Flight;

@SuppressWarnings({SuppressWarningsOption.SPELL_CHECKING_INSPECTION, SuppressWarningsOption.UNUSED})
public class FlightDTO {

    @JsonIgnore
    public static final String CURRENCY_TOMAN_FA = "تومان";
    @JsonIgnore
    public static final String CURRENCY_TOMAN_EN = "Toman";

    @JsonProperty("Url")
    private String link;
    @JsonProperty("Price")
    private Integer price;
    @JsonProperty("FormattedPrice")
    private String formattedPrice;
    @JsonProperty("CurrencyFa")
    private String currencyFa;
    @JsonProperty("CurrencyEn")
    private String currencyEn;
    @JsonProperty("FlightNumber")
    private String flightNumber;
    @JsonProperty("FlightClass")
    private String flightClass;
    @JsonProperty("FlightCompanyNameFa")
    private String filghtCompanyNameFa;
    @JsonProperty("FlightCompanyNameEn")
    private String filghtCompanyNameEn;
    @JsonProperty("FlightCompanyCode")
    private Integer flightCompanyCode;
    @JsonProperty("Airplane")
    private String airplane;
    @JsonProperty("IsCharter")
    private Boolean isCharter;
    @JsonProperty("DepartureTime")
    private String departureTime;
    @JsonProperty("ArrivalTime")
    private String arrivalTime;
    @JsonProperty("DepartureDateFa")
    private String departureDateFa;
    @JsonProperty("DepartureDateEn")
    private String departureDateEn;
    @JsonProperty("ArrivalDateFa")
    private String arrivalDateFa;
    @JsonProperty("ArrivalDateEn")
    private String arrivalDateEn;
    @JsonProperty("Capacity")
    private Integer capacity;

    public String getFlightClass() {
        return flightClass;
    }

    public void setFlightClass(String flightClass) {
        this.flightClass = flightClass;
    }

    public FlightDTO() {
    }

    public FlightDTO(String link, Integer price, String formattedPrice, String currencyFa, String currencyEn,
                     String flightNumber, String flightClass, String filghtCompanyNameFa, String filghtCompanyNameEn, String airplane, Boolean isCharter, String departureTime, String arrivalTime,
                     String departureDateFa, String departureDateEn, String arrivalDateFa, String arrivalDateEn, Integer capacity) {
        this.link = link;
        this.price = price;
        this.formattedPrice = formattedPrice;
        this.currencyFa = currencyFa;
        this.currencyEn = currencyEn;
        this.flightNumber = flightNumber;
        this.flightClass = flightClass;
        this.filghtCompanyNameFa = filghtCompanyNameFa;
        this.filghtCompanyNameEn = filghtCompanyNameEn;
        this.flightCompanyCode = flightCompanyCode;
        this.airplane = airplane;
        this.isCharter = isCharter;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        setDepartureDateFa(departureDateFa);
        setDepartureDateEn(departureDateEn);
        this.arrivalDateFa = arrivalDateFa;
        this.arrivalDateEn = arrivalDateEn;
        this.capacity = capacity;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        if (price != null)
            this.price = price / 10;
    }

    public String getFormattedPrice() {
        return formattedPrice;
    }

    public void setFormattedPrice(String formattedPrice) {
        this.formattedPrice = formattedPrice;
    }

    public String getCurrencyFa() {
        return currencyFa;
    }

    public void setCurrencyFa(String currencyFa) {
        this.currencyFa = currencyFa;
    }

    public String getCurrencyEn() {
        return currencyEn;
    }

    public void setCurrencyEn(String currencyEn) {
        this.currencyEn = currencyEn;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getFilghtCompanyNameFa() {
        return filghtCompanyNameFa;
    }

    public void setFilghtCompanyNameFa(String filghtCompanyNameFa) {
        if (filghtCompanyNameFa != null) {
            this.filghtCompanyNameFa = filghtCompanyNameFa;
            this.flightCompanyCode = FlightCompanyUtil.getFlightCompanyCode(filghtCompanyNameFa);
        }
    }

    public String getFilghtCompanyNameEn() {
        return filghtCompanyNameEn;
    }

    public void setFilghtCompanyNameEn(String filghtCompanyNameEn) {
        this.filghtCompanyNameEn = filghtCompanyNameEn;
    }

    public Integer getFlightCompanyCode() {
        return flightCompanyCode;
    }

    public void setFlightCompanyCode(Integer flightCompanyCode) {
        this.flightCompanyCode = flightCompanyCode;
    }

    public String getAirplane() {
        return airplane;
    }

    public void setAirplane(String airplane) {
        this.airplane = airplane;
    }

    public Boolean getCharter() {
        return isCharter;
    }

    public void setCharter(Boolean charter) {
        isCharter = charter;
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

    public String getDepartureDateFa() {
        return departureDateFa;
    }

    public void setDepartureDateFa(String departureDateFa) {
        if (departureDateFa != null)
            this.departureDateFa = departureDateFa.split(" ")[0];
    }

    public String getDepartureDateEn() {
        return departureDateEn;
    }

    public void setDepartureDateEn(String departureDateEn) {
        if (departureDateEn != null)
            this.departureDateEn = departureDateEn.split(" ")[0];
    }

    public String getArrivalDateFa() {
        return arrivalDateFa;
    }

    public void setArrivalDateFa(String arrivalDateFa) {
        this.arrivalDateFa = arrivalDateFa;
    }

    public String getArrivalDateEn() {
        return arrivalDateEn;
    }

    public void setArrivalDateEn(String arrivalDateEn) {
        this.arrivalDateEn = arrivalDateEn;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }
}
