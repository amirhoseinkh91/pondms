package ir.viratech.just_ro.api.flight.dto.sepehr360;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.viratech.base.SuppressWarningsOption;

@SuppressWarnings({SuppressWarningsOption.UNUSED , SuppressWarningsOption.SPELL_CHECKING_INSPECTION})
public class Sepehr360FlightItemInfoRankDTO {

    @JsonProperty("Title")
    private String title;

    @JsonProperty("IsExist")
    private Boolean exists;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getExists() {
        return exists;
    }

    public void setExists(Boolean exists) {
        this.exists = exists;
    }

}
