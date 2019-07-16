package ir.viratech.just_ro.api.flight.dto.airplainTicekt;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings({"SpellCheckingInspection", "unused"})
public class AirplainTicketFlightDTO implements Serializable{

    @JsonProperty("PriceDSC")
    private Integer priceDiscount;
    @JsonProperty("ChildPriceDSC")
    private Integer childPriceDiscount;
    @JsonProperty("InfantPriceDSC")
    private Integer infantPriceDiscount;
    @JsonProperty("DiscountPercent")
    private Integer discountPercent;
    @JsonProperty("ID")
    private String id;
    @JsonProperty("FlightNumber")
    private String flightNumber;
    @JsonProperty("From")
    private String from;
    @JsonProperty("To")
    private String to;
    @JsonProperty("Airplane")
    private String airplane;
    @JsonProperty("Airline")
    private String airline;
    @JsonProperty("DepartureTime")
    private String departureTime;
    @JsonProperty("ArrivalTime")
    private String arrivalTime;
    @JsonProperty("Status")
    private String status;
    @JsonProperty("Stops")
    private String stops;
    @JsonProperty("FullCharter")
    private Boolean fullCharter;
    @JsonProperty("Electronic")
    private Boolean electronic;
    @JsonProperty("Hidden")
    private String hidden;
    @JsonProperty("ProviderID")
    private String providerId;
    @JsonProperty("Test")
    private String test;
    @JsonProperty("MealType")
    private String mealType;
    @JsonProperty("IsGrouped")
    private Boolean grouped;
    @JsonProperty("UniqueIdentifier")
    private String uniqueIdentifier;
    @JsonProperty("AirplaneCode")
    private String airplaneCode;
    @JsonProperty("CharterTime")
    private Boolean charterTime;
    @JsonProperty("FlightID")
    private String flightId;
    @JsonProperty("Details")
    private String details;
    @JsonProperty("LastUpdate")
    private String lastUpdate;
    //TODO check format
    @JsonProperty("Trusted")
    private Object trusted;
    @JsonProperty("Class")
    private String classCode;
    @JsonProperty("TwoWay")
    private Boolean twoWay;
    @JsonProperty("ChildPrice")
    private Integer childPrice;
    @JsonProperty("InfantPrice")
    private Integer infantPrice;
    @JsonProperty("Departure")
    private String departTime;
    @JsonProperty("FareBasisName")
    private String fareBasisName;
    @JsonProperty("IsPlannedFlight")
    private Boolean isPlannedFlight;
    @JsonProperty("origHidden")
    private Integer origHidden;
    @JsonProperty("CharterID")
    private String charterID;
    @JsonProperty("SpecialOffer")
    private Boolean specialOffer;
    // todo test this for Double or Object
    @JsonProperty("Priority")
    private Object priority;
    @JsonProperty("OnlineBooking")
    private Boolean onlineBooking;
    @JsonProperty("WebserviceUrl")
    private String webServiceUrl;
    @JsonProperty("WebserviceParameters")
    private String webServiceParameters;
    @JsonProperty("Classes")
    private List<AirplaneTicketFlightClassesDTO> classes;
    @JsonProperty("International")
    private Boolean international;
    @JsonProperty("DepartureTimeIsClose")
    private Boolean departureTimeIsClose;
    @JsonProperty("DepartureFormatted")
    private String departureTimeFormatted;
    @JsonProperty("DepartDate")
    private String departureDate;
    @JsonProperty("DepartShortDateStr")
    private String departureShortDateStr;
    @JsonProperty("FullDateStr")
    private String departureFullDateStr;
    @JsonProperty("ArriveDate")
    private String arriveDate;
    @JsonProperty("ArriveShortDateStr")
    private String arriveShortDateStr;
    @JsonProperty("DateStr")
    private String dateStr;
    @JsonProperty("TimeStr")
    private String timeStr;
    @JsonProperty("AirlineIATACode")
    private String airlineIATACode;
    @JsonProperty("Duration")
    private Integer duration;
    @JsonProperty("Inappropriate")
    private Boolean inappropriate;
    @JsonProperty("CO2")
    private Integer cO2;
    @JsonProperty("Arrival")
    private String arriveTime;
    @JsonProperty("ArrivalFormatted")
    private String arrivalTimeFormatted;
    @JsonProperty("Business")
    private Boolean business;
    @JsonProperty("FromTerminal")
    private Integer srcTerminal;
    @JsonProperty("ToTerminal")
    private Integer dstTerminal;
    @JsonProperty("FromAirport")
    private String srcAirport;
    @JsonProperty("FromCountry")
    private String srcCountry;
    @JsonProperty("FromIATACode")
    private String srcIATACode;
    @JsonProperty("ToIATACode")
    private String dstIATACode;
    @JsonProperty("PerFrom")
    private String srcPerisan;
    @JsonProperty("EnFrom")
    private String srcEnglish;
    @JsonProperty("ToAirport")
    private String dstAirport;
    @JsonProperty("ToCountry")
    private String dstCountry;
    @JsonProperty("PerTo")
    private String dstPersian;
    @JsonProperty("EnTo")
    private String dstEnglish;
    @JsonProperty("Img")
    private String img;
    @JsonProperty("EnAirline")
    private String airlineEnglish;
    @JsonProperty("Carrier")
    private String carrier;
    @JsonProperty("AirplaneIATACode")
    private String airplaneIATACode;
    @JsonProperty("Vehicle")
    private String vehicle;
    @JsonProperty("Capacity")
    private Integer capacity;
    @JsonProperty("LastCheckRequestID")
    private String lastCheckRequestID;

    public String getLastCheckRequestID() {
        return lastCheckRequestID;
    }

    public void setLastCheckRequestID(String lastCheckRequestID) {
        this.lastCheckRequestID = lastCheckRequestID;
    }

    public Integer getPriceDiscount() {
        return priceDiscount;
    }

    public void setPriceDiscount(Integer priceDiscount) {
        this.priceDiscount = priceDiscount;
    }

    public Integer getChildPriceDiscount() {
        return childPriceDiscount;
    }

    public void setChildPriceDiscount(Integer childPriceDiscount) {
        this.childPriceDiscount = childPriceDiscount;
    }

    public Integer getInfantPriceDiscount() {
        return infantPriceDiscount;
    }

    public void setInfantPriceDiscount(Integer infantPriceDiscount) {
        this.infantPriceDiscount = infantPriceDiscount;
    }

    public Integer getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(Integer discountPercent) {
        this.discountPercent = discountPercent;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getAirplane() {
        return airplane;
    }

    public void setAirplane(String airplane) {
        this.airplane = airplane;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStops() {
        return stops;
    }

    public void setStops(String stops) {
        this.stops = stops;
    }

    public Boolean getFullCharter() {
        return fullCharter;
    }

    public void setFullCharter(Boolean fullCharter) {
        this.fullCharter = fullCharter;
    }

    public Boolean getElectronic() {
        return electronic;
    }

    public void setElectronic(Boolean electronic) {
        this.electronic = electronic;
    }

    public String getHidden() {
        return hidden;
    }

    public void setHidden(String hidden) {
        this.hidden = hidden;
    }

    public String getProviderId() {
        return providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public String getMealType() {
        return mealType;
    }

    public void setMealType(String mealType) {
        this.mealType = mealType;
    }

    public Boolean getGrouped() {
        return grouped;
    }

    public void setGrouped(Boolean grouped) {
        this.grouped = grouped;
    }

    public String getUniqueIdentifier() {
        return uniqueIdentifier;
    }

    public void setUniqueIdentifier(String uniqueIdentifier) {
        this.uniqueIdentifier = uniqueIdentifier;
    }

    public String getAirplaneCode() {
        return airplaneCode;
    }

    public void setAirplaneCode(String airplaneCode) {
        this.airplaneCode = airplaneCode;
    }

    public Boolean getCharterTime() {
        return charterTime;
    }

    public void setCharterTime(Boolean charterTime) {
        this.charterTime = charterTime;
    }

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Object getTrusted() {
        return trusted;
    }

    public void setTrusted(Object trusted) {
        this.trusted = trusted;
    }

    public String getClassCode() {
        return classCode;
    }

    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }

    public Boolean getTwoWay() {
        return twoWay;
    }

    public void setTwoWay(Boolean twoWay) {
        this.twoWay = twoWay;
    }

    public Integer getChildPrice() {
        return childPrice;
    }

    public void setChildPrice(Integer childPrice) {
        this.childPrice = childPrice;
    }

    public Integer getInfantPrice() {
        return infantPrice;
    }

    public void setInfantPrice(Integer infantPrice) {
        this.infantPrice = infantPrice;
    }

    public String getDepartTime() {
        return departTime;
    }

    public void setDepartTime(String departTime) {
        this.departTime = departTime;
    }

    public String getFareBasisName() {
        return fareBasisName;
    }

    public void setFareBasisName(String fareBasisName) {
        this.fareBasisName = fareBasisName;
    }

    public Boolean getPlannedFlight() {
        return isPlannedFlight;
    }

    public void setPlannedFlight(Boolean plannedFlight) {
        isPlannedFlight = plannedFlight;
    }

    public Integer getOrigHidden() {
        return origHidden;
    }

    public void setOrigHidden(Integer origHidden) {
        this.origHidden = origHidden;
    }

    public String getCharterID() {
        return charterID;
    }

    public void setCharterID(String charterID) {
        this.charterID = charterID;
    }

    public Boolean getSpecialOffer() {
        return specialOffer;
    }

    public void setSpecialOffer(Boolean specialOffer) {
        this.specialOffer = specialOffer;
    }

    public Object getPriority() {
        return priority;
    }

    public void setPriority(Object priority) {
        this.priority = priority;
    }

    public Boolean getOnlineBooking() {
        return onlineBooking;
    }

    public void setOnlineBooking(Boolean onlineBooking) {
        this.onlineBooking = onlineBooking;
    }

    public String getWebServiceUrl() {
        return webServiceUrl;
    }

    public void setWebServiceUrl(String webServiceUrl) {
        this.webServiceUrl = webServiceUrl;
    }

    public String getWebServiceParameters() {
        return webServiceParameters;
    }

    public void setWebServiceParameters(String webServiceParameters) {
        this.webServiceParameters = webServiceParameters;
    }

    public List<AirplaneTicketFlightClassesDTO> getClasses() {
        return classes;
    }

    public void setClasses(List<AirplaneTicketFlightClassesDTO> classes) {
        this.classes = classes;
    }

    public Boolean getInternational() {
        return international;
    }

    public void setInternational(Boolean international) {
        this.international = international;
    }

    public Boolean getDepartureTimeIsClose() {
        return departureTimeIsClose;
    }

    public void setDepartureTimeIsClose(Boolean departureTimeIsClose) {
        this.departureTimeIsClose = departureTimeIsClose;
    }

    public String getDepartureTimeFormatted() {
        return departureTimeFormatted;
    }

    public void setDepartureTimeFormatted(String departureTimeFormatted) {
        this.departureTimeFormatted = departureTimeFormatted;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getDepartureShortDateStr() {
        return departureShortDateStr;
    }

    public void setDepartureShortDateStr(String departureShortDateStr) {
        this.departureShortDateStr = departureShortDateStr;
    }

    public String getDepartureFullDateStr() {
        return departureFullDateStr;
    }

    public void setDepartureFullDateStr(String departureFullDateStr) {
        this.departureFullDateStr = departureFullDateStr;
    }

    public String getArriveDate() {
        return arriveDate;
    }

    public void setArriveDate(String arriveDate) {
        this.arriveDate = arriveDate;
    }

    public String getArriveShortDateStr() {
        return arriveShortDateStr;
    }

    public void setArriveShortDateStr(String arriveShortDateStr) {
        this.arriveShortDateStr = arriveShortDateStr;
    }

    public String getDateStr() {
        return dateStr;
    }

    public void setDateStr(String dateStr) {
        this.dateStr = dateStr;
    }

    public String getTimeStr() {
        return timeStr;
    }

    public void setTimeStr(String timeStr) {
        this.timeStr = timeStr;
    }

    public String getAirlineIATACode() {
        return airlineIATACode;
    }

    public void setAirlineIATACode(String airlineIATACode) {
        this.airlineIATACode = airlineIATACode;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Boolean getInappropriate() {
        return inappropriate;
    }

    public void setInappropriate(Boolean inappropriate) {
        this.inappropriate = inappropriate;
    }

    public Integer getcO2() {
        return cO2;
    }

    public void setcO2(Integer cO2) {
        this.cO2 = cO2;
    }

    public String getArriveTime() {
        return arriveTime;
    }

    public void setArriveTime(String arriveTime) {
        this.arriveTime = arriveTime;
    }

    public String getArrivalTimeFormatted() {
        return arrivalTimeFormatted;
    }

    public void setArrivalTimeFormatted(String arrivalTimeFormatted) {
        this.arrivalTimeFormatted = arrivalTimeFormatted;
    }

    public Boolean getBusiness() {
        return business;
    }

    public void setBusiness(Boolean business) {
        this.business = business;
    }

    public Integer getSrcTerminal() {
        return srcTerminal;
    }

    public void setSrcTerminal(Integer srcTerminal) {
        this.srcTerminal = srcTerminal;
    }

    public Integer getDstTerminal() {
        return dstTerminal;
    }

    public void setDstTerminal(Integer dstTerminal) {
        this.dstTerminal = dstTerminal;
    }

    public String getSrcAirport() {
        return srcAirport;
    }

    public void setSrcAirport(String srcAirport) {
        this.srcAirport = srcAirport;
    }

    public String getSrcCountry() {
        return srcCountry;
    }

    public void setSrcCountry(String srcCountry) {
        this.srcCountry = srcCountry;
    }

    public String getSrcIATACode() {
        return srcIATACode;
    }

    public void setSrcIATACode(String srcIATACode) {
        this.srcIATACode = srcIATACode;
    }

    public String getDstIATACode() {
        return dstIATACode;
    }

    public void setDstIATACode(String dstIATACode) {
        this.dstIATACode = dstIATACode;
    }

    public String getSrcPerisan() {
        return srcPerisan;
    }

    public void setSrcPerisan(String srcPerisan) {
        this.srcPerisan = srcPerisan;
    }

    public String getSrcEnglish() {
        return srcEnglish;
    }

    public void setSrcEnglish(String srcEnglish) {
        this.srcEnglish = srcEnglish;
    }

    public String getDstAirport() {
        return dstAirport;
    }

    public void setDstAirport(String dstAirport) {
        this.dstAirport = dstAirport;
    }

    public String getDstCountry() {
        return dstCountry;
    }

    public void setDstCountry(String dstCountry) {
        this.dstCountry = dstCountry;
    }

    public String getDstPersian() {
        return dstPersian;
    }

    public void setDstPersian(String dstPersian) {
        this.dstPersian = dstPersian;
    }

    public String getDstEnglish() {
        return dstEnglish;
    }

    public void setDstEnglish(String dstEnglish) {
        this.dstEnglish = dstEnglish;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getAirlineEnglish() {
        return airlineEnglish;
    }

    public void setAirlineEnglish(String airlineEnglish) {
        this.airlineEnglish = airlineEnglish;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public String getAirplaneIATACode() {
        return airplaneIATACode;
    }

    public void setAirplaneIATACode(String airplaneIATACode) {
        this.airplaneIATACode = airplaneIATACode;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }
}