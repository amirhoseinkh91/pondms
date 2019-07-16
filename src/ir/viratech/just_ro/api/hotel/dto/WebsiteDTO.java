package ir.viratech.just_ro.api.hotel.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

/**
 * Created by justro on 2/11/18.
 */
public class WebsiteDTO {

    @JsonProperty("Website")
    private String website;
    @JsonProperty("ServerAddress")
    private String serverAddress;
    @JsonProperty("URL")
    private String url;
    @JsonProperty("RequestHeaders")
    private Map<String, String> headers;

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getServerAddress() {
        return serverAddress;
    }

    public void setServerAddress(String serverAddress) {
        this.serverAddress = serverAddress;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }
}
