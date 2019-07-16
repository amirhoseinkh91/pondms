package ir.viratech.just_ro.api.flight.dto.alibaba;

import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings({"SpellCheckingInspection" , "unused"})
public class AlibabaFlightDTO {

    private String id;
    private String airline;
    private String aircraft;
    private String leaveDate;
    private String leaveDateFa;
    private String leaveTime;
    private String arrivalTime;
    private String from;
    private String to;
    private String fromShowName;
    private String toShowName;
    private String flightNumber;
    private String airlineEnglish;
    private String classType;
    private String classPrice;
    private String classCount;
    private String type;
    private String classDeatils;
    private String kind;
    private Integer price;
    private String dayOfWeek;
    private Integer count;
    private String ticketClass;
    private String priceChild;
    private String priceInfant;
    private String isAvailable;
    private Integer uniqueId;
    private String description;
    private Boolean hasConnection;
    private String urlLink;
    private Integer orderIndex;
    private AlibabaCRCNDTO crcn;
    private String p1;
    private String p2;
    private String p3;
    private String p4;
    private String p5;
    private String sellerId;
    private String sellerReference;
    private String systemKey;
    private String systemKeyName;
    private String specialServices;
    private String ticketOriginalPrice;
    private String ticketCharterPrice;
    private String ticketOverPrice;
    private Boolean charterOverPrice;

    @JsonProperty("Id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("AirLine")
    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    @JsonProperty("Aircraft")
    public String getAircraft() {
        return aircraft;
    }

    public void setAircraft(String aircraft) {
        this.aircraft = aircraft;
    }

    @JsonProperty("LeaveDate")
    public String getLeaveDate() {
        return leaveDate;
    }

    public void setLeaveDate(String leaveDate) {
        this.leaveDate = leaveDate;
    }

    @JsonProperty("LeaveDateFa")
    public String getLeaveDateFa() {
        return leaveDateFa;
    }

    public void setLeaveDateFa(String leaveDateFa) {
        this.leaveDateFa = leaveDateFa;
    }

    @JsonProperty("LeaveTime")
    public String getLeaveTime() {
        return leaveTime;
    }

    public void setLeaveTime(String leaveTime) {
        this.leaveTime = leaveTime;
    }

    @JsonProperty("ArrivalTime")
    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    @JsonProperty("From")
    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    @JsonProperty("To")
    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    @JsonProperty("FromShowName")
    public String getFromShowName() {
        return fromShowName;
    }

    public void setFromShowName(String fromShowName) {
        this.fromShowName = fromShowName;
    }

    @JsonProperty("ToShowName")
    public String getToShowName() {
        return toShowName;
    }

    public void setToShowName(String toShowName) {
        this.toShowName = toShowName;
    }

    @JsonProperty("FlightNumber")
    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    @JsonProperty("AirLineEnglish")
    public String getAirlineEnglish() {
        return airlineEnglish;
    }

    public void setAirlineEnglish(String airlineEnglish) {
        this.airlineEnglish = airlineEnglish;
    }

    @JsonProperty("ClassType")
    public String getClassType() {
        return classType;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }

    @JsonProperty("ClassPrice")
    public String getClassPrice() {
        return classPrice;
    }

    public void setClassPrice(String classPrice) {
        this.classPrice = classPrice;
    }

    @JsonProperty("ClassCount")
    public String getClassCount() {
        return classCount;
    }

    public void setClassCount(String classCount) {
        this.classCount = classCount;
    }

    @JsonProperty("Type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("ClassDetails")
    public String getClassDeatils() {
        return classDeatils;
    }

    public void setClassDeatils(String classDeatils) {
        this.classDeatils = classDeatils;
    }

    @JsonProperty("kind")
    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    @JsonProperty("price")
    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @JsonProperty("DayOfWeek")
    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    @JsonProperty("count")
    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @JsonProperty("ticketClass")
    public String getTicketClass() {
        return ticketClass;
    }

    public void setTicketClass(String ticketClass) {
        this.ticketClass = ticketClass;
    }

    @JsonProperty("PriceChild")
    public String getPriceChild() {
        return priceChild;
    }

    public void setPriceChild(String priceChild) {
        this.priceChild = priceChild;
    }

    @JsonProperty("PriceInfant")
    public String getPriceInfant() {
        return priceInfant;
    }

    public void setPriceInfant(String priceInfant) {
        this.priceInfant = priceInfant;
    }

    @JsonProperty("isAvailable")
    public String getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(String isAvailable) {
        this.isAvailable = isAvailable;
    }

    @JsonProperty("uniqId")
    public Integer getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(Integer uniqueId) {
        this.uniqueId = uniqueId;
    }

    @JsonProperty("Description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("HasConnection")
    public Boolean getHasConnection() {
        return hasConnection;
    }

    public void setHasConnection(Boolean hasConnection) {
        this.hasConnection = hasConnection;
    }

    @JsonProperty("UrlLink")
    public String getUrlLink() {
        return urlLink;
    }

    public void setUrlLink(String urlLink) {
        this.urlLink = urlLink;
    }

    @JsonProperty("Order_Index")
    public Integer getOrderIndex() {
        return orderIndex;
    }

    public void setOrderIndex(Integer orderIndex) {
        this.orderIndex = orderIndex;
    }

    @JsonProperty("CRCN")
    public AlibabaCRCNDTO getCrcn() {
        return crcn;
    }

    public void setCrcn(AlibabaCRCNDTO crcn) {
        this.crcn = crcn;
    }

    @JsonProperty("P1")
    public String getP1() {
        return p1;
    }

    public void setP1(String p1) {
        this.p1 = p1;
    }

    @JsonProperty("P2")
    public String getP2() {
        return p2;
    }

    public void setP2(String p2) {
        this.p2 = p2;
    }

    @JsonProperty("P3")
    public String getP3() {
        return p3;
    }

    public void setP3(String p3) {
        this.p3 = p3;
    }

    @JsonProperty("P4")
    public String getP4() {
        return p4;
    }

    public void setP4(String p4) {
        this.p4 = p4;
    }

    @JsonProperty("P5")
    public String getP5() {
        return p5;
    }

    public void setP5(String p5) {
        this.p5 = p5;
    }

    @JsonProperty("SellerId")
    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    @JsonProperty("SellerReference")
    public String getSellerReference() {
        return sellerReference;
    }

    public void setSellerReference(String sellerReference) {
        this.sellerReference = sellerReference;
    }

    @JsonProperty("SystemKey")
    public String getSystemKey() {
        return systemKey;
    }

    public void setSystemKey(String systemKey) {
        this.systemKey = systemKey;
    }

    @JsonProperty("SystemKeyName")
    public String getSystemKeyName() {
        return systemKeyName;
    }

    public void setSystemKeyName(String systemKeyName) {
        this.systemKeyName = systemKeyName;
    }

    @JsonProperty("SpecialServices")
    public String getSpecialServices() {
        return specialServices;
    }

    public void setSpecialServices(String specialServices) {
        this.specialServices = specialServices;
    }

    @JsonProperty("TicketOrginalPrice")
    public String getTicketOriginalPrice() {
        return ticketOriginalPrice;
    }

    public void setTicketOriginalPrice(String ticketOriginalPrice) {
        this.ticketOriginalPrice = ticketOriginalPrice;
    }

    @JsonProperty("TicketCharterPrice")
    public String getTicketCharterPrice() {
        return ticketCharterPrice;
    }

    public void setTicketCharterPrice(String ticketCharterPrice) {
        this.ticketCharterPrice = ticketCharterPrice;
    }

    @JsonProperty("TicketOverPrice")
    public String getTicketOverPrice() {
        return ticketOverPrice;
    }

    public void setTicketOverPrice(String ticketOverPrice) {
        this.ticketOverPrice = ticketOverPrice;
    }

    @JsonProperty("CharterOverPrice")
    public Boolean getCharterOverPrice() {
        return charterOverPrice;
    }

    public void setCharterOverPrice(Boolean charterOverPrice) {
        this.charterOverPrice = charterOverPrice;
    }
}
