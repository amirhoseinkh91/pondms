package ir.viratech.just_ro.api.flight.dto.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.viratech.base.SuppressWarningsOption;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SuppressWarnings(SuppressWarningsOption.UNUSED)
public class FlightWebsiteRequestDTO {


    //    @JsonProperty("AdditionalInfo")
//    private Map<String, Object> additionalInfo;
    @JsonProperty("HttpMethod")
    private String httpMethod = String.valueOf(HttpMethod.GET);
    @JsonProperty("BaseURL")
    private String baseUrl;
    @JsonProperty("QueryType")
    private List<QueryType> queryTypeList;
    @JsonProperty("PathParam")
    private List<PathParamQueryDTO> pathParamQuery;
    @JsonProperty("RequestBody")
    private boolean requestBody;
    @JsonProperty("RequestHeaders")
    private Map<String, String> requestHeaders;
    @JsonProperty("Queries")
    private QueryDTO queries;

    public ServerRequest getServerRequest() {
        return serverRequest;
    }

    public void setServerRequest(ServerRequest serverRequest) {
        this.serverRequest = serverRequest;
    }

    @JsonProperty("ServerRequest")
    private ServerRequest serverRequest;

    public enum HttpMethod {
        GET, POST, PUT, DELETE, OPTION
    }


    public enum QueryType {
        QueryString, PathParam, FormParam, Json
    }

    public String getHttpMethod() {
        return httpMethod;
    }

    public void setHttpMethod(FlightWebsiteRequestDTO.HttpMethod httpMethod) {
        this.httpMethod = String.valueOf(httpMethod);
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public List<QueryType> getQueryTypeList() {
        return queryTypeList;
    }

    public void setQueryTypeList(List<QueryType> queryTypeList) {
        this.queryTypeList = queryTypeList;
    }

    public List<PathParamQueryDTO> getPathParamQuery() {
        return pathParamQuery;
    }

    public void setPathParamQuery(List<PathParamQueryDTO> pathParamQuery) {
        this.pathParamQuery = pathParamQuery;
    }

    public boolean isRequestBody() {
        return requestBody;
    }

    public void setRequestBody(boolean requestBody) {
        this.requestBody = requestBody;
    }

    public Map<String, String> getRequestHeaders() {
        return requestHeaders;
    }

    public void setRequestHeaders(Map<String, String> requestHeaders) {
        this.requestHeaders = requestHeaders;
    }

    public QueryDTO getQueries() {
        return queries;
    }

    public void setQueries(QueryDTO queries) {
        this.queries = queries;
    }

//    public void setAdditionalInfo(Map<String, Object> additionalInfo) {
//        this.additionalInfo = additionalInfo;
//    }
//
//    public Map<String, Object> getAdditionalInfo() {
//        return additionalInfo;
//    }
}
