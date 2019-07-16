package ir.viratech.just_ro.api.flight.dto.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.viratech.base.SuppressWarningsOption;
import ir.viratech.just_ro.api.flight.dto.search.FlightSearchQueryDTO;
import ir.viratech.just_ro.manager.website.flight.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings({SuppressWarningsOption.SPELL_CHECKING_INSPECTION, SuppressWarningsOption.UNUSED})
public class FlightConfigDTO {

    @JsonProperty("AvailableWebsitesCount")
    private int websiteItemsCount;

    @JsonProperty("AvailableWebsites")
    private List<String> availableWebsites;

    @JsonProperty("Timeout")
    private int timeout = 120;

    @JsonProperty("WebsiteRequests")
    private Map<String, FlightWebsiteRequestDTO> websiteSamples;


    public FlightConfigDTO( ) {
        this.init();
    }

    private void init() {
        final FlightMgr mgr = new FlightMgr();
        this.availableWebsites = mgr.getAvailableWebsites();
        HashMap<String, FlightWebsiteRequestDTO> map = new HashMap<>();
        for (String websiteKey : availableWebsites) {
            if (websiteKey.equals("Alibaba"))
                map.put(websiteKey, new Alibaba().getFlightWebsiteRequestDTO());
            if (websiteKey.equals("Mrbilit"))
                map.put(websiteKey, new Mrbilit().getFlightWebsiteRequestDTO());
            if (websiteKey.equals("Ghasedak24"))
                map.put(websiteKey, new Ghasedak24().getFlightWebsiteRequestDTO());
            if (websiteKey.equals("Sepehr360"))
                map.put(websiteKey, new Sepehr360().getFlightWebsiteRequestDTO());
            if (websiteKey.equals("AirplaneTicket"))
                map.put(websiteKey, new AirplaneTicket().getFlightWebsiteRequestDTO());
        }

        this.websiteSamples = map;
        this.websiteItemsCount = this.availableWebsites.size();
    }

    public List<String> getAvailableWebsites() {
        return availableWebsites;
    }

    public void setAvailableWebsites(List<String> availableWebsites) {
        this.availableWebsites = availableWebsites;
    }

    public Map<String, FlightWebsiteRequestDTO> getWebsiteSamples() {
        return websiteSamples;
    }

    public void setWebsiteSamples(Map<String, FlightWebsiteRequestDTO> websiteSamples) {
        this.websiteSamples = websiteSamples;
    }

    public int getWebsiteItemsCount() {
        return websiteItemsCount;
    }

    public void setWebsiteItemsCount(int websiteItemsCount) {
        this.websiteItemsCount = websiteItemsCount;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }
}
