package ir.viratech.just_ro.api.flight.dto.mrbilit;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.viratech.base.SuppressWarningsOption;

import java.util.Map;

@SuppressWarnings({SuppressWarningsOption.UNUSED, SuppressWarningsOption.SPELL_CHECKING_INSPECTION})
public class MrBilitResponseFlightDTO {

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
    @JsonProperty("LastCheckRequestID")
    private String lastCheckRequestId;
    @JsonProperty("Status")
    private String status;
    @JsonProperty("Stops")
    private String stops;
    @JsonProperty("FullCharter")
    private Boolean fullCharter;
    @JsonProperty("Electronic")
    private Boolean electronic;
    @JsonProperty("Hidden")
    private Object hidden;
    @JsonProperty("ProviderID")
    private Object providerId;
    @JsonProperty("Test")
    private String test;
    @JsonProperty("MealType")
    private String mealType;
    @JsonProperty("IsGrouped")
    private Boolean grouped;
    @JsonProperty("UniqueIdentifier")
    private Object uniqueIdentifier;
    @JsonProperty("AirplaneCode")
    private String airplaneCode;
    @JsonProperty("CharterTime")
    private Boolean charterTime;
    @JsonProperty("Price")
    private Integer price;
    @JsonProperty("AddonPrice")
    private String addOnPrice;
    @JsonProperty("Details")
    private String details;
    @JsonProperty("LastUpdate")
    private String lastUpdate;
    @JsonProperty("ChildPrice")
    private Integer childPrice;
    @JsonProperty("InfantPrice")
    private Integer infantPrice;
    @JsonProperty("Class")
    private String classCode;
    @JsonProperty("TwoWay")
    private Boolean twoWay;
    @JsonProperty("Parameters")
    private String parameters;
    @JsonProperty("Capacity")
    private String capacity;
    @JsonProperty("Business")
    private Object business;
    @JsonProperty("CharterSource")
    private String charterSrc;
    //TODO check format
    @JsonProperty("Trusted")
    private Object trusted;
    @JsonProperty("Wheelchair")
    private Object wheelchair;
    @JsonProperty("Baggage")
    private String baggage;
    @JsonProperty("Commission")
    private Integer commision;
    @JsonProperty("Priority")
    private Double priority;
    @JsonProperty("Unselectable")
    private Boolean unselectable;
    @JsonProperty("NotEnoughCapacity")
    private Boolean notEnoughCapacity;
    @JsonProperty("PenaltyRate")
    private Object penaltyRate;
    @JsonProperty("AgencyID")
    private String agencyID;
    @JsonProperty("OnlineBooking")
    private Object onlineBooking;
    @JsonProperty("WebserviceUrl")
    private Object webServiceUrl;
    @JsonProperty("WebserviceParameters")
    private Object webServiceParameters;
    @JsonProperty("FlightID")
    private String flightId;
    @JsonProperty("Website")
    private String website;
    @JsonProperty("PriceDSC")
    private Integer priceDiscount;
    @JsonProperty("ChildPriceDSC")
    private Integer childPriceDiscount;
    @JsonProperty("InfantPriceDSC")
    private Integer infantPriceDiscount;
    @JsonProperty("DiscountPercent")
    private Integer discountPercent;
    @JsonProperty("Type")
    private Integer type;
    @JsonProperty("discountHash")
    private String discountHash;
    @JsonProperty("International")
    private Boolean international;
    @JsonProperty("DepartureTimeIsClose")
    private Boolean departureTimeIsClose;
    @JsonProperty("Departure")
    private String departTime;
    @JsonProperty("FareBasisName")
    private String fareBasisName;
    //TODO check format
    @JsonProperty("IsPlannedFlight")
    private Object isPlannedFlight;
    @JsonProperty("origHidden")
    private Integer origHidden;
    @JsonProperty("AgencyWebsite")
    private MrBilitAgencyWebsite agencyWebsite;
    @JsonProperty("CharterID")
    private String charterID;
    @JsonProperty("IsAllowedToBuy")
    private Boolean isAllowedToBuy;
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
    @JsonProperty("SpecialOffer")
    private Boolean specialOffer;
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

    public String getLastCheckRequestId() {
        return lastCheckRequestId;
    }

    public void setLastCheckRequestId(String lastCheckRequestId) {
        this.lastCheckRequestId = lastCheckRequestId;
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

    public Object getHidden() {
        return hidden;
    }

    public void setHidden(Object hidden) {
        this.hidden = hidden;
    }

    public Object getProviderId() {
        return providerId;
    }

    public void setProviderId(Object providerId) {
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

    public Object getUniqueIdentifier() {
        return uniqueIdentifier;
    }

    public void setUniqueIdentifier(Object uniqueIdentifier) {
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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getAddOnPrice() {
        return addOnPrice;
    }

    public void setAddOnPrice(String addOnPrice) {
        this.addOnPrice = addOnPrice;
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

    public String getParameters() {
        return parameters;
    }

    public void setParameters(String parameters) {
        this.parameters = parameters;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public Object getBusiness() {
        return business;
    }

    public void setBusiness(Object business) {
        this.business = business;
    }

    public String getCharterSrc() {
        return charterSrc;
    }

    public void setCharterSrc(String charterSrc) {
        this.charterSrc = charterSrc;
    }

    public Object getTrusted() {
        return trusted;
    }

    public void setTrusted(Object trusted) {
        this.trusted = trusted;
    }

    public Object getWheelchair() {
        return wheelchair;
    }

    public void setWheelchair(Object wheelchair) {
        this.wheelchair = wheelchair;
    }

    public String getBaggage() {
        return baggage;
    }

    public void setBaggage(String baggage) {
        this.baggage = baggage;
    }

    public Integer getCommision() {
        return commision;
    }

    public void setCommision(Integer commision) {
        this.commision = commision;
    }

    public Double getPriority() {
        return priority;
    }

    public void setPriority(Double priority) {
        this.priority = priority;
    }

    public Boolean getUnselectable() {
        return unselectable;
    }

    public void setUnselectable(Boolean unselectable) {
        this.unselectable = unselectable;
    }

    public Boolean getNotEnoughCapacity() {
        return notEnoughCapacity;
    }

    public void setNotEnoughCapacity(Boolean notEnoughCapacity) {
        this.notEnoughCapacity = notEnoughCapacity;
    }

    public Object getPenaltyRate() {
        return penaltyRate;
    }

    public void setPenaltyRate(Object penaltyRate) {
        this.penaltyRate = penaltyRate;
    }

    public String getAgencyID() {
        return agencyID;
    }

    public void setAgencyID(String agencyID) {
        this.agencyID = agencyID;
    }

    public Object getOnlineBooking() {
        return onlineBooking;
    }

    public void setOnlineBooking(Object onlineBooking) {
        this.onlineBooking = onlineBooking;
    }

    public Object getWebServiceUrl() {
        return webServiceUrl;
    }

    public void setWebServiceUrl(Object webServiceUrl) {
        this.webServiceUrl = webServiceUrl;
    }

    public Object getWebServiceParameters() {
        return webServiceParameters;
    }

    public void setWebServiceParameters(Object webServiceParameters) {
        this.webServiceParameters = webServiceParameters;
    }

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getDiscountHash() {
        return discountHash;
    }

    public void setDiscountHash(String discountHash) {
        this.discountHash = discountHash;
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

    public Object getIsPlannedFlight() {
        return isPlannedFlight;
    }

    public void setIsPlannedFlight(Object isPlannedFlight) {
        this.isPlannedFlight = isPlannedFlight;
    }

    public Integer getOrigHidden() {
        return origHidden;
    }

    public void setOrigHidden(Integer origHidden) {
        this.origHidden = origHidden;
    }

    public MrBilitAgencyWebsite getAgencyWebsite() {
        return agencyWebsite;
    }

    public void setAgencyWebsite(MrBilitAgencyWebsite agencyWebsite) {
        this.agencyWebsite = agencyWebsite;
    }

    public String getCharterID() {
        return charterID;
    }

    public void setCharterID(String charterID) {
        this.charterID = charterID;
    }

    public Boolean getAllowedToBuy() {
        return isAllowedToBuy;
    }

    public void setAllowedToBuy(Boolean allowedToBuy) {
        isAllowedToBuy = allowedToBuy;
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

    public Boolean getSpecialOffer() {
        return specialOffer;
    }

    public void setSpecialOffer(Boolean specialOffer) {
        this.specialOffer = specialOffer;
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
}
