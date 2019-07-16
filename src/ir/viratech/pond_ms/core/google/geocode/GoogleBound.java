package ir.viratech.pond_ms.core.google.geocode;

import com.google.gson.annotations.SerializedName;

public class GoogleBound {

    @SerializedName("northeast")
    private GoogleLatLng northEast;

    @SerializedName("southwest")
    private GoogleLatLng southWest;

    public GoogleLatLng getNorthEast() {
        return northEast;
    }

    public void setNorthEast(GoogleLatLng northEast) {
        this.northEast = northEast;
    }

    public GoogleLatLng getSouthWest() {
        return southWest;
    }

    public void setSouthWest(GoogleLatLng southWest) {
        this.southWest = southWest;
    }
}
