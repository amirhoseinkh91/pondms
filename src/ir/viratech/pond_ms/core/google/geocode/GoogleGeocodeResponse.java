package ir.viratech.pond_ms.core.google.geocode;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GoogleGeocodeResponse {

    @SerializedName("error_message")
    private String errorMessage;

    @SerializedName("status")
    private String statusMessage;

    @SerializedName("results")
    private List<GoogleGeocodeResult> results;

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public List<GoogleGeocodeResult> getResults() {
        return results;
    }

    public void setResults(List<GoogleGeocodeResult> results) {
        this.results = results;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public enum StatusMessage {
        INVALID_REQUEST, OK , REQUEST_DENIED
    }
}
