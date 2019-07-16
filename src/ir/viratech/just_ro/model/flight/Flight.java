package ir.viratech.just_ro.model.flight;

import java.util.List;

import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.Gson;

import ir.viratech.just_ro.model.lowestprice.LowestPrice;


public class Flight implements Comparable<Flight> {

    private String id;
    @JsonProperty
    private String flightCompany;
    @JsonProperty
    private String capacity;
    private String price;
    @JsonProperty
    private String flightNumber;
    @JsonProperty
    private String date;
    @JsonProperty
    private String time;
    @JsonProperty
    private String isCharter;
    @JsonProperty
    private String flightClass;
    @JsonProperty
    private List<LowestPrice> lowestPrices;
    @JsonProperty
    private int companyCode;

    public static final String BUISNESS_CLASS_FA = "بیزنس کلاس";
    public static final String ECONOMY_CLASS_FA = "اکونومی";
    public static final String FIRST_CLASS_FA = "فرست کلاس";
    public static final String ALL_FLIGHT_CLASSES = "همه";
    public static final String UNKNOWN_CLASS_FA = "نامشخص";
    public static final String UNKNOWN_CAPACIY_FA = "ظرفیت نامشخص";
    public static final String CHARTER_TRUE = "چارتر";
    public static final String CHARTER_FALSE = "سیستمی";

    public static final String ATA_AIRLINE = "هواپیمایی آتا";
    public static final String ATRAK_AIRLINE = "هواپیمایی اترک";
    public static final String HOMA_AIRLINE = "هواپیمایی هما";
    public static final String IRAN_ASEMAN_AIRLINE = "هواپیمایی ایران آسمان";
    public static final String IRAN_AIR_AIRLINE = "هواپیمایی ایران ایر";
    public static final String IRAN_AIR_TOUR_AIRLINE = "هواپیمایی ایران ایرتور";
    public static final String CASPIAN_AIRLINE = "هواپیمایی کاسپین";
    public static final String KISH_AIRLINE = "هواپیمایی کیش";
    public static final String MAHAN_AIRLINE = "هواپیمایی ماهان";
    public static final String MERAJ_AIRLINE = "هواپیمایی معراج";
    public static final String NAFT_AIRLINE = "هواپیمایی نفت";
    public static final String SAHAND_AIRLINE = "هواپیمایی سهند";
    public static final String GHESHM_AIRLINE = "هواپیمایی قشم";
    public static final String SAHA_AIRLINE = "هواپیمایی ساها";
    public static final String SEPEHRAN_AIRLINE = "هواپیمایی سپهران";
    public static final String TABAN_AIRLINE = "هواپیمایی تابان";
    public static final String TAFTAN_AIRLINE = "هواپیمایی تفتان";
    public static final String ZAGROS_AIRLINE = "هواپیمایی زاگرس";

    private String host;
    private String link;
    private String type;
    private transient String classSaloon;
    private transient String lowestPrice;
    private transient String name;

    public Flight() {

    }

    public Flight(String flightCompany, String capacity, String price, String flightNumber, String date, String host,
                  String link, String time, String airplane, String isCharter, String flightClass) {
        this.flightCompany = airlineChecker(flightCompany);
        this.capacity = capacity;
        this.price = price;
        this.flightNumber = flightNumber;
        this.date = date;
        this.host = host;
        this.link = link;
        this.time = time;
        this.type = airplane;
        this.isCharter = isCharter;
        this.flightClass = flightClass;
        this.name = flightCompany + " " + flightNumber;
        this.companyCode = getCompanyCode();
        setId();
    }

    public Flight(String flightCompany, String capacity, String price, String flightNumber, String date, String host,
                  String link, String time) {
        this.flightCompany = airlineChecker(flightCompany);
        this.capacity = capacity;
        this.price = price;
        this.flightNumber = flightNumber;
        this.date = date;
        this.host = host;
        this.link = link;
        this.time = time;
        setId();
        this.companyCode = getCompanyCode();
    }

    public Flight(String flightCompany, String capacity, String price, String flightNumber, String flightClass,
                  String isCharter, String date, String lowestPrice, List<LowestPrice> lowestPrices, String host, String link,
                  String time) {
        this.flightCompany = airlineChecker(flightCompany);
        this.capacity = capacity;
        this.price = price;
        this.flightNumber = flightNumber;
        this.flightClass = flightClass;
        this.isCharter = isCharter;
        this.date = date;
        this.lowestPrice = lowestPrice;
        this.lowestPrices = lowestPrices;
        this.link = link;
        this.host = host;
        this.setTime(time);
        this.companyCode = getCompanyCode();
        setId();
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    @XmlTransient
    public String getClassSaloon() {
        return classSaloon;
    }

    public void setClassSaloon(String classSaloon) {
        this.classSaloon = classSaloon;
    }

    @XmlTransient
    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @XmlTransient
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @XmlTransient
    public String getHost() {
        return host;
    }

    public void setHost(String webUrl) {
        this.host = webUrl;
    }

    public List<LowestPrice> getLowestPrices() {
        return lowestPrices;
    }

    public void setLowestPrices(List<LowestPrice> lowestPrices) {
        this.lowestPrices = lowestPrices;
    }

    @XmlTransient
    public String getLowestPrice() {
        return lowestPrice;
    }

    public void setLowestPrice(String lowestPrice) {
        this.lowestPrice = lowestPrice;
    }

    @Override
    public int compareTo(Flight o) {
        int priceCompare = Integer.parseInt(o.lowestPrice);
        return Integer.parseInt(this.getLowestPrice()) - priceCompare;
    }

    @XmlTransient
    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @XmlTransient
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public String getId() {
        return id;
    }

    public void setId() {
        this.id = this.flightNumber + " " + this.time;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFlightCompany() {
        return flightCompany;
    }

    public void setFlightCompany(String flightCompany) {
        this.flightCompany = airlineChecker(flightCompany);
    }

    public String getFlightClass() {
        return flightClass;
    }

    public void setFlightClass(String flightClass) {
        this.flightClass = flightClass;
    }

    public String getIsCharter() {
        return isCharter;
    }

    public void setIsCharter(String isCharter) {
        this.isCharter = isCharter;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String toJson() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    public final int getCompanyCode() {

        if (this.flightCompany.equals(IRAN_AIR_AIRLINE))
            return 1;
        else if (this.flightCompany.equals(MAHAN_AIRLINE))
            return 2;
        else if (this.flightCompany.equals(KISH_AIRLINE))
            return 3;
        else if (this.flightCompany.equals(GHESHM_AIRLINE))
            return 4;
        else if (this.flightCompany.equals(IRAN_AIR_TOUR_AIRLINE))
            return 5;
        else if (this.flightCompany.equals(CASPIAN_AIRLINE))
            return 6;
        else if (this.flightCompany.equals(TABAN_AIRLINE))
            return 7;
        else if (this.flightCompany.equals(IRAN_ASEMAN_AIRLINE))
            return 8;
        else if (this.flightCompany.equals(ATA_AIRLINE))
            return 9;
        else if (this.flightCompany.equals(ZAGROS_AIRLINE))
            return 10;
        else if (this.flightCompany.equals(MERAJ_AIRLINE))
            return 11;
        else if (this.flightCompany.equals(SAHA_AIRLINE))
            return 12;
        else if (this.flightCompany.equals(ATRAK_AIRLINE))
            return 13;
        else if (this.flightCompany.equals(HOMA_AIRLINE))
            return 14;
        else if (this.flightCompany.equals(NAFT_AIRLINE))
            return 15;
        else if (this.flightCompany.equals(SAHAND_AIRLINE))
            return 16;
        else if (this.flightCompany.equals(SEPEHRAN_AIRLINE))
            return 17;
        else if (this.flightCompany.equals(TAFTAN_AIRLINE))
            return 18;
        else {
            return 0;
        }
    }

    public final String airlineChecker(String inputAirline) {
        if (inputAirline.contains("آتا"))
            return ATA_AIRLINE;
        if (inputAirline.contains("اترک") | inputAirline.contains("Ak"))
            return ATRAK_AIRLINE;
        if (inputAirline.contains("هما"))
            return HOMA_AIRLINE;
        if (inputAirline.contains("آسمان"))
            return IRAN_ASEMAN_AIRLINE;
        if (inputAirline.contains("ایران ایر") | inputAirline.contains("ایران‌ایر"))
            return IRAN_AIR_AIRLINE;
        if (inputAirline.contains("ایرتور") || inputAirline.contains("ایر تور") || inputAirline.contains("ایر‌تور"))
            return IRAN_AIR_TOUR_AIRLINE;
        if (inputAirline.contains("کاسپین"))
            return CASPIAN_AIRLINE;
        if (inputAirline.contains("کیش"))
            return KISH_AIRLINE;
        if (inputAirline.contains("ماهان") || inputAirline.contains("ماهان ایر")) {
            return MAHAN_AIRLINE;
        }
        if (inputAirline.contains("معراج"))
            return MERAJ_AIRLINE;
        if (inputAirline.contains("نفت"))
            return NAFT_AIRLINE;
        if (inputAirline.contains("سهند"))
            return SAHAND_AIRLINE;
        if (inputAirline.contains("قشم"))
            return GHESHM_AIRLINE;
        if (inputAirline.contains("ساها"))
            return SAHA_AIRLINE;
        if (inputAirline.contains("سپهران")) {
            return SEPEHRAN_AIRLINE;
        }
        if (inputAirline.contains("تابان"))
            return TABAN_AIRLINE;
        if (inputAirline.contains("تفتان"))
            return TAFTAN_AIRLINE;
        if (inputAirline.contains("زاگرس"))
            return ZAGROS_AIRLINE;
        return inputAirline;
    }

    @Override
    public String toString() {
        return id + " " + flightCompany + " " + capacity + " " + price + " " + flightNumber + " " + date + " " + link
                + " " + time;
    }

    public void setCompanyCode(int companyCode) {
        this.companyCode = companyCode;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((capacity == null) ? 0 : capacity.hashCode());
        result = prime * result + companyCode;
        result = prime * result + ((date == null) ? 0 : date.hashCode());
        result = prime * result + ((flightClass == null) ? 0 : flightClass.hashCode());
        result = prime * result + ((flightCompany == null) ? 0 : flightCompany.hashCode());
        result = prime * result + ((flightNumber == null) ? 0 : flightNumber.hashCode());
        result = prime * result + ((host == null) ? 0 : host.hashCode());
        result = prime * result + ((isCharter == null) ? 0 : isCharter.hashCode());
        result = prime * result + ((link == null) ? 0 : link.hashCode());
        result = prime * result + ((price == null) ? 0 : price.hashCode());
        result = prime * result + ((time == null) ? 0 : time.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Flight other = (Flight) obj;
        if (capacity == null) {
            if (other.capacity != null)
                return false;
        } else if (!capacity.equals(other.capacity))
            return false;
        if (companyCode != other.companyCode)
            return false;
        if (date == null) {
            if (other.date != null)
                return false;
        } else if (!date.equals(other.date))
            return false;
        if (flightClass == null) {
            if (other.flightClass != null)
                return false;
        } else if (!flightClass.equals(other.flightClass))
            return false;
        if (flightCompany == null) {
            if (other.flightCompany != null)
                return false;
        } else if (!flightCompany.equals(other.flightCompany))
            return false;
        if (flightNumber == null) {
            if (other.flightNumber != null)
                return false;
        } else if (!flightNumber.equals(other.flightNumber))
            return false;
        if (host == null) {
            if (other.host != null)
                return false;
        } else if (!host.equals(other.host))
            return false;
        if (isCharter == null) {
            if (other.isCharter != null)
                return false;
        } else if (!isCharter.equals(other.isCharter))
            return false;
        if (link == null) {
            if (other.link != null)
                return false;
        } else if (!link.equals(other.link))
            return false;
        if (price == null) {
            if (other.price != null)
                return false;
        } else if (!price.equals(other.price))
            return false;
        if (time == null) {
            if (other.time != null)
                return false;
        } else if (!time.equals(other.time))
            return false;
        return true;
    }


    public static Integer getFlightCompanyCode(String flightCompany) {
        if (flightCompany.equals(IRAN_AIR_AIRLINE))
            return 1;
        else if (flightCompany.equals(MAHAN_AIRLINE))
            return 2;
        else if (flightCompany.equals(KISH_AIRLINE))
            return 3;
        else if (flightCompany.equals(GHESHM_AIRLINE))
            return 4;
        else if (flightCompany.equals(IRAN_AIR_TOUR_AIRLINE))
            return 5;
        else if (flightCompany.equals(CASPIAN_AIRLINE))
            return 6;
        else if (flightCompany.equals(TABAN_AIRLINE))
            return 7;
        else if (flightCompany.equals(IRAN_ASEMAN_AIRLINE))
            return 8;
        else if (flightCompany.equals(ATA_AIRLINE))
            return 9;
        else if (flightCompany.equals(ZAGROS_AIRLINE))
            return 10;
        else if (flightCompany.equals(MERAJ_AIRLINE))
            return 11;
        else if (flightCompany.equals(SAHA_AIRLINE))
            return 12;
        else if (flightCompany.equals(ATRAK_AIRLINE))
            return 13;
        else if (flightCompany.equals(HOMA_AIRLINE))
            return 14;
        else if (flightCompany.equals(NAFT_AIRLINE))
            return 15;
        else if (flightCompany.equals(SAHAND_AIRLINE))
            return 16;
        else if (flightCompany.equals(SEPEHRAN_AIRLINE))
            return 17;
        else if (flightCompany.equals(TAFTAN_AIRLINE))
            return 18;
        else {
            return 0;
        }
    }
}
