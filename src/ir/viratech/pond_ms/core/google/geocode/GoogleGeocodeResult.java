package ir.viratech.pond_ms.core.google.geocode;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GoogleGeocodeResult {

    @SerializedName("formatted_address")
    private String formattedAddress;

    @SerializedName("place_id")
    private String placeId;

    @SerializedName("address_components")
    private List<AddressComponent> addressComponents;

    @SerializedName("types")
    private List<String> types;

    @SerializedName("geometry")
    private GoogleGeocodeGeometry geometry;

    public String getFormattedAddress() {
        return formattedAddress;
    }

    public void setFormattedAddress(String formattedAddress) {
        this.formattedAddress = formattedAddress;
    }

    public String getPlaceId() {
        return placeId;
    }

    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }

    public List<AddressComponent> getAddressComponents() {
        return addressComponents;
    }

    public void setAddressComponents(List<AddressComponent> addressComponents) {
        this.addressComponents = addressComponents;
    }

    public List<String> getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }

    public GoogleGeocodeGeometry getGeometry() {
        return geometry;
    }

    public void setGeometry(GoogleGeocodeGeometry geometry) {
        this.geometry = geometry;
    }
}
