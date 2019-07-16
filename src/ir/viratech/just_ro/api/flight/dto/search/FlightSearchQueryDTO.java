package ir.viratech.just_ro.api.flight.dto.search;

import ir.viratech.base.SuppressWarningsOption;
import ir.viratech.just_ro.model.calendar.CalendarTool;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.QueryParam;

@SuppressWarnings({SuppressWarningsOption.SPELL_CHECKING_INSPECTION, SuppressWarningsOption.UNUSED})
public class FlightSearchQueryDTO {

    @QueryParam("adults")
    @DefaultValue("1")
    private Integer adults;

    @QueryParam("children")
    @DefaultValue("0")
    private Integer children;

    @QueryParam("infants")
    @DefaultValue("0")
    private Integer infants;

    @QueryParam("src")
    @DefaultValue("THR")
    private String source;

    @QueryParam("dst")
    @DefaultValue("MHD")
    private String destination;

    @QueryParam("date-fa")
    private String persianDate;

    @QueryParam("date-en")
    private String englishDate;

    public Integer getAdults() {
        return adults;
    }

    public void setAdults(Integer adults) {
        this.adults = adults;
    }

    public Integer getChildren() {
        return children;
    }

    public void setChildren(Integer children) {
        this.children = children;
    }

    public Integer getInfants() {
        return infants;
    }

    public void setInfants(Integer infants) {
        this.infants = infants;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getPersianDate() {
        return persianDate;
    }

    public void setPersianDate(String persianDate) {
        if (persianDate != null)
            this.persianDate = persianDate;
        else
            this.persianDate = new CalendarTool().getIranianToday();
    }

    public String getEnglishDate() {
        return englishDate;
    }

    public void setEnglishDate(String englishDate) {
        if (englishDate != null)
            this.englishDate = englishDate;
        else
            this.englishDate = new CalendarTool().getGregorianDate();
    }
}
