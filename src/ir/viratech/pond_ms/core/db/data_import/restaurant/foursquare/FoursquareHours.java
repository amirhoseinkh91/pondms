package ir.viratech.pond_ms.core.db.data_import.restaurant.foursquare;

public class FoursquareHours {

    private String status;
    private Boolean isOpen;
    private Boolean isLocalHoliday;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getOpen() {
        return isOpen;
    }

    public void setOpen(Boolean open) {
        isOpen = open;
    }

    public Boolean getLocalHoliday() {
        return isLocalHoliday;
    }

    public void setLocalHoliday(Boolean localHoliday) {
        isLocalHoliday = localHoliday;
    }

}
