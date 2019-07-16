package ir.viratech.just_ro.api.flight.dto.mrbilit;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.viratech.base.SuppressWarningsOption;

import java.util.List;

@SuppressWarnings({SuppressWarningsOption.UNUSED, SuppressWarningsOption.SPELL_CHECKING_INSPECTION})
public class MrBilitResponseDTO {

    @JsonProperty("Meta")
    private MrBilitMetaDTO meta;

    @JsonProperty("FlightInfo")
    private List<MrBilitFlightInfo> flightInfos;

    public MrBilitMetaDTO getMeta() {
        return meta;
    }

    public void setMeta(MrBilitMetaDTO meta) {
        this.meta = meta;
    }

    public List<MrBilitFlightInfo> getFlightInfos() {
        return flightInfos;
    }

    public void setFlightInfos(List<MrBilitFlightInfo> flightInfos) {
        this.flightInfos = flightInfos;
    }
}
