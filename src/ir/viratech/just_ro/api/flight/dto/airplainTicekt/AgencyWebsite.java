package ir.viratech.just_ro.api.flight.dto.airplainTicekt;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.xpath.operations.Bool;

/**
 * Created by justro on 2/5/18.
 */

@SuppressWarnings({"SpellCheckingInspection"})
public class AgencyWebsite {

    @JsonProperty("ID")
    private String id;
    @JsonProperty("AgencyID")
    private String agencyId;
    @JsonProperty("Url")
    private String url;
    @JsonProperty("Alias")
    private String alias;
    @JsonProperty("BlackListed")
    private Boolean blackListed;
    @JsonProperty("getFromCharterSource")
    private String getFromCharterSource;
    @JsonProperty("OnlineBooking")
    private Boolean onlineBooking;
    //TODO check format of web service
    @JsonProperty("WebserviceUrl")
    private Object webServiceUrl;
    //TODO check format
    @JsonProperty("WebserviceParameters")
    private Object webServiceParameters;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(String agencyId) {
        this.agencyId = agencyId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public Boolean getBlackListed() {
        return blackListed;
    }

    public void setBlackListed(Boolean blackListed) {
        this.blackListed = blackListed;
    }

    public String getGetFromCharterSource() {
        return getFromCharterSource;
    }

    public void setGetFromCharterSource(String getFromCharterSource) {
        this.getFromCharterSource = getFromCharterSource;
    }

    public Boolean getOnlineBooking() {
        return onlineBooking;
    }

    public void setOnlineBooking(Boolean onlineBooking) {
        this.onlineBooking = onlineBooking;
    }

    public Object getWebServiceUrl() {
        return webServiceUrl;
    }

    public void setWebServiceUrl(Object webServiceUrl) {
        this.webServiceUrl = webServiceUrl;
    }

    public Object getWebServiceParameters() {
        return webServiceParameters;
    }

    public void setWebServiceParameters(Object webServiceParameters) {
        this.webServiceParameters = webServiceParameters;
    }


}
