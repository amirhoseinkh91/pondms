package ir.viratech.pond_ms.model.tour_relations.tour;

import java.util.*;

import ir.viratech.mongo.model.AbstractMongoEntity;
import ir.viratech.pond_ms.model.tour_relations.base.model.ExtendedPointObject;
import ir.viratech.pond_ms.model.tour_relations.tour.dao.TourDAO;
import ir.viratech.pond_ms.model.tour_relations.tour.exception.DayNotFoundException;
import ir.viratech.pond_ms.model.tour_relations.guide.Guide;
import ir.viratech.pond_ms.model.tour_relations.hotel.Hotel;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = TourDAO.TOUR_COLLECTION)
public class Tour extends AbstractMongoEntity {

    public static final String PROP_AGENCY_USERNAME = "agency_username";
    public static final String PROP_RATE = "Rate";
    public static final String PROP_INTRNSIC_VALUE = "IntrinsicValue";
    public static final String PROP_TOTAL_SCORE = "TotalScore";
    public static final String PROP_TEMPORAL_VALUE = "TemporalValue";

    public static final String PROP_MAIN_INFO_COMPONENT = "mainInformation";
    public static final String PROP_HOTELS_COMPONENT = "hotels";
    public static final String PROP_TOUR_GUIDE_COMPONENT = "tourGuide";
    public static final String PROP_AGENCY_COMPONENT = "agency";
    public static final String PROP_DAYS_COMPONENT = "days";

    public static final String MAIN_INFO_COMPONENT_FROM_URL = "main-info";
    public static final String HOTEL_COMPONENT_FROM_URL = "hotel";
    public static final String MEAL_COMPONENT_FROM_URL = "meal";
    public static final String RESISTENCE_COMPONENT_FROM_URL = "resistence";
    public static final String DEPART_COMPONENT_FROM_URL = "depart";
    public static final String ARRIVAL_COMPONENT_FROM_URL = "arrival";
    public static final String SIGHT_SEEING_COMPONENT_FROM_URL = "sights";
    public static final String TRANSFER_COMPONENT_FROM_URL = "transfer";
    public static final String TOUR_GUIDE_COMPONENT_FROM_URL = "tour-guide";
    public static final String PROP_TYPE_KEY = "__type";
    public static final String PROP_TYPE_VALUE = "Tour";

    @Override
    public void init() {
        set__type(PROP_TYPE_VALUE);
        days = new HashMap<>();
    }

    @Override
    protected Class getRefClass() {
        return Tour.class;
    }

    public String getType() {
        return getRefClass().getSimpleName();
    }

    private Map<String, List<ExtendedPointObject>> days;

    public Map<String, List<ExtendedPointObject>> getDays() {
        return days;
    }

    public void setDays(Map<String, List<ExtendedPointObject>> days) {
        this.days = days;
    }

    public void addDay(List<ExtendedPointObject> objects, Integer dayNumber) {
        try {
            if (getDays().containsKey("day" + dayNumber))
                removeDay(dayNumber);
            days.put("day" + dayNumber, objects);
        } catch (NullPointerException e) {
            days = new HashMap<>();
            days.put("day" + dayNumber, objects);
        }
    }

    public void addDay(List<ExtendedPointObject> objects) {
        try {
            addDay(objects, getLastDayNumber() + 1);
        } catch (NullPointerException e) {
            addDay(objects, 1);
        }
    }

    public Map<String, List<ExtendedPointObject>> removeDay(Integer dayNumber) {
        if (dayNumber != null)
            days.remove("day" + dayNumber);
        return days;
    }

    public List<ExtendedPointObject> getDay(Integer dayNumber) throws DayNotFoundException {
        if (dayNumber != null)
            if (days.containsKey("day" + dayNumber))
                return days.get("day" + dayNumber);
        throw new DayNotFoundException("day " + dayNumber + " does not extist.");
    }

    public Map<String, List<ExtendedPointObject>> removeExtraDays(Integer maximumDayNumber) {
        // TODO remove extra days here
        return null;
    }

    public int getLastDayNumber() throws NullPointerException {
        if (days != null) {
            int dayNumber = 0;
            for (String key : days.keySet())
                dayNumber = Integer.parseInt(key.substring(3));
            return dayNumber;
        } else {
            throw new NullPointerException("no days found");
        }
    }

/*		add to any index for days list

	private void addToIndex(int dayNumber, DayTourObject dayTourObject){
		if(dayNumber -1 >= 0 && dayNumber <= days.size()){
			days.add(dayNumber -1, dayTourObject);
			return;
		}
		int insertNulls = (dayNumber - 1) - days.size();
		for(int i = 0; i < insertNulls; i++)
			days.add(null);
		days.add(dayTourObject);
	}*/

    private Guide tourGuide;

    public Guide getTourGuide() {
        return tourGuide;
    }

    public void setTourGuide(Guide tourGuide) {
        this.tourGuide = tourGuide;
    }

    private List<Hotel> hotels;

    public List<Hotel> getHotels() {
        return hotels;
    }

    public void setHotels(List<Hotel> hotels) {
        this.hotels = hotels;
    }

    private MainTourInformation mainInformation;

    /**
     * @return the mainInformation
     */
    public MainTourInformation getMainInformation() {
        return mainInformation;
    }

    /**
     * @param mainInformation the mainInformation to set
     */
    public void setMainInformation(MainTourInformation mainInformation) {
        this.mainInformation = mainInformation;
    }

    private String agencyUid;

    public String getAgencyUid() {
        return agencyUid;
    }

    public void setAgencyUid(String agencyUid) {
        this.agencyUid = agencyUid;
    }

    // TODO replave agency_username with agencyUid
    public String agency_username;

    /**
     * @return the agency_username
     */
    public String getAgency_username() {
        return agency_username;
    }

    /**
     * @param agency_username the agency_username to set
     */
    public void setAgency_username(String agency_username) {
        this.agency_username = agency_username;
    }

    private int rate;

    /**
     * @return the rate
     */
    public int getRate() {
        return rate;
    }

    /**
     * @param rate the rate to set
     */
    public void setRate(int rate) {
        this.rate = rate;
    }

    private int intrinsicValue;

    /**
     * @return the intrinsicValue
     */
    public int getIntrinsicValue() {
        return intrinsicValue;
    }

    /**
     * @param intrinsicValue the intrinsicValue to set
     */
    public void setIntrinsicValue(int intrinsicValue) {
        this.intrinsicValue = intrinsicValue;
    }

    private int temporalValue;

    /**
     * @return the temporalValue
     */
    public int getTemporalValue() {
        return temporalValue;
    }

    /**
     * @param temporalValue the temporalValue to set
     */
    public void setTemporalValue(int temporalValue) {
        this.temporalValue = temporalValue;
    }


    /*
     * enabling tour by admin
     */

    private int totalScore = calculateTotalScore();

    /**
     * @return the totalScore
     */
    public int getTotalScore() {
        return totalScore;
    }

    /**
     * @param totalScore the totalScore to set
     */
    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    protected int calculateTotalScore() {
        return getIntrinsicValue() + getTemporalValue() + getRate();
    }

    @Override
    public String toString() {
        return "Tour{" +
                "days=" + days +
                ", tourGuide=" + tourGuide +
                ", hotels=" + hotels +
                ", mainInformation=" + mainInformation +
                ", agency_username='" + agency_username + '\'' +
                ", rate=" + rate +
                ", totalScore=" + totalScore +
                ", intrinsicValue=" + intrinsicValue +
                ", temporalValue=" + temporalValue +
                ", _isDeleted=" + isDeleted()+
                ", isEnabled=" + isEnabled()+
                '}';
    }
}
