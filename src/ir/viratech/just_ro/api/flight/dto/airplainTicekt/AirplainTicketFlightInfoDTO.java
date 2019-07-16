package ir.viratech.just_ro.api.flight.dto.airplainTicekt;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.xpath.operations.Bool;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings({"SpellCheckingInspection", "unused"})
public class AirplainTicketFlightInfoDTO implements Serializable {

    @JsonProperty("payable")
    private Integer payable;
    @JsonProperty("totalPrice")
    private Integer totalPrice;
    @JsonProperty("totalDSC")
    private Integer totalDSC;
    @JsonProperty("cancellationAlert")
    private Boolean cancellationAlert;
    @JsonProperty("score")
    private Integer score;
    @JsonProperty("Flights")
    private List<Map<String, Object>> ticketFlightDTOList;
    @JsonProperty("IsGrouped")
    private Boolean isGrouped;
    @JsonProperty("UniqueIdentifier")
    private String uniqueIdentifier;


    public int getFlightsSize() {
        if (ticketFlightDTOList != null)
            return ticketFlightDTOList.size();
        return 0;
    }

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

    public Integer getTotalDSC() {
        return totalDSC;
    }

    public void setTotalDSC(Integer totalDSC) {
        this.totalDSC = totalDSC;
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

    public List<Map<String, Object>> getTicketFlightDTOList() {
        return ticketFlightDTOList;
    }

    public void setTicketFlightDTOList(List<Map<String, Object>> ticketFlightDTOList) {
        this.ticketFlightDTOList = ticketFlightDTOList;
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
        return ticketFlightDTOList.get(index).get(key);
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
