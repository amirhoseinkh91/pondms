package ir.viratech.pond_ms.core.google.geocode;

import com.google.gson.annotations.SerializedName;

public class GoogleGeocodeGeometry {

    @SerializedName("bounds")
    private GoogleBound bounds;

    @SerializedName("location")
    private GoogleLatLng location;

    @SerializedName("location_type")
    private String locationType;

    @SerializedName("viewport")
    private GoogleBound vewPort;

    public GoogleBound getBounds() {
        return bounds;
    }

    public void setBounds(GoogleBound bounds) {
        this.bounds = bounds;
    }

    public GoogleLatLng getLocation() {
        return location;
    }

    public void setLocation(GoogleLatLng location) {
        this.location = location;
    }

    public String getLocationType() {
        return locationType;
    }

    public void setLocationType(String locationType) {
        this.locationType = locationType;
    }

    public GoogleBound getVewPort() {
        return vewPort;
    }

    public void setVewPort(GoogleBound vewPort) {
        this.vewPort = vewPort;
    }
}
