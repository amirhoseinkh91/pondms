package ir.viratech.just_ro.api.flight.dto.mrbilit;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.viratech.base.SuppressWarningsOption;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings({SuppressWarningsOption.UNUSED, SuppressWarningsOption.SPELL_CHECKING_INSPECTION})
public class MrBilitFlightInfo {

    @JsonProperty("payable")
    private Integer payable;
    @JsonProperty("totalPrice")
    private Integer totalPrice;
    @JsonProperty("totalDSC")
    private Integer totalDescount;
    @JsonProperty("cancellationAlert")
    private Boolean cancellationAlert;
    @JsonProperty("score")
    private Integer score;
    @JsonProperty("Flights")
    private List<Map<String, Object>> flights;
    @JsonProperty("IsGrouped")
    private Boolean isGrouped;
    @JsonProperty("UniqueIdentifier")
    private String uniqueIdentifier;

    public Integer getPayable() {
        return payable;
    }

    public void setPayable(Integer payable) {
        this.payable = payable;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getTotalDescount() {
        return totalDescount;
    }

    public void setTotalDescount(Integer totalDescount) {
        this.totalDescount = totalDescount;
    }

    public Boolean getCancellationAlert() {
        return cancellationAlert;
    }

    public void setCancellationAlert(Boolean cancellationAlert) {
        this.cancellationAlert = cancellationAlert;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public List<Map<String, Object>> getFlights() {
        return flights;
    }

    public void setFlights(List<Map<String, Object>> flights) {
        this.flights = flights;
    }

    public Boolean getGrouped() {
        return isGrouped;
    }

    public void setGrouped(Boolean grouped) {
        isGrouped = grouped;
    }

    public String getUniqueIdentifier() {
        return uniqueIdentifier;
    }

    public void setUniqueIdentifier(String uniqueIdentifier) {
        this.uniqueIdentifier = uniqueIdentifier;
    }

    public int getFlightsSize() {
        if (flights != null)
            return flights.size();
        return 0;
    }

    public String getFlightNumber(int flightListIndex) {
        return (String) getFromTicketFlightDTOList(flightListIndex, "FlightNumber");
    }

    public String getClassCode(int i) {
        return (String) getFromTicketFlightDTOList(i, "Class");
    }

    public String getCarrier(int i) {
        return (String) getFromTicketFlightDTOList(i, "Carrier");
    }

    private Object getFromTicketFlightDTOList(int index, String key) {
        return flights.get(index).get(key);
    }

    public String getAirlineEnglish(int i) {
        return (String) getFromTicketFlightDTOList(i, "EnAirline");
    }

    public String getAirplane(int i) {
        return (String) getFromTicketFlightDTOList(i, "Airplane");
    }

    public Boolean getCharterTime(int i) {
        return (Boolean) getFromTicketFlightDTOList(i, "CharterTime");
    }

    public String getDepartTime(int i) {
        return (String) getFromTicketFlightDTOList(i, "DepartureTime");
    }

    public String getArrivalTime(int i) {
        return (String) getFromTicketFlightDTOList(i, "ArrivalTime");
    }

    public String getDepartureDate(int i) {
        return (String) getFromTicketFlightDTOList(i, "DepartDate");
    }

    public String getArriveDate(int i) {
        return (String) getFromTicketFlightDTOList(i, "ArriveDate");
    }

    @SuppressWarnings("Duplicates")
    public Integer getCapacity(int i) throws NullPointerException {
        Object capacity = getFromTicketFlightDTOList(i, "Capacity");
        if (capacity == null) {
            String classCode = getClassCode(i);
            Object classes = getFromTicketFlightDTOList(i, "Classes");
            @SuppressWarnings("unchecked")
            ArrayList<LinkedHashMap<String, Object>> newClassesMap = (ArrayList<LinkedHashMap<String, Object>>) classes;
            for (LinkedHashMap<String, Object> cl : newClassesMap) {
                String tempClassCode = (String) cl.get("Class");
                if (tempClassCode.equalsIgnoreCase(classCode)) {
                    if (cl.get("Capacity") != null) {
                        capacity = cl.get("Capacity");
                    }
                }
            }
        }
        if (capacity instanceof String)
            return Integer.valueOf((String) capacity);
        else if (capacity instanceof Integer)
            return (Integer) capacity;
        return null;
    }

}
