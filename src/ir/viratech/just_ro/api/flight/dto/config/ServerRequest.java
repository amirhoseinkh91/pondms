package ir.viratech.just_ro.api.flight.dto.config;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by justro on 2/18/18.
 */
public class ServerRequest {

    @JsonProperty("Api")
    private String api;
    @JsonProperty("Method")
    private String method = String.valueOf(Method.Get);

    public Map<String, String> getRequestHeaders() {
        return requestHeaders;
    }

    public void setRequestHeaders(Map<String, String> requestHeaders) {
        this.requestHeaders = requestHeaders;
    }

    @JsonProperty("RequestHeaders")
    private Map<String , String> requestHeaders;

    public String getApi() {
        return api;
    }

    public void setApi(String api) {
        this.api = api;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }



    public enum Method{
        Get,Post
    }
}
