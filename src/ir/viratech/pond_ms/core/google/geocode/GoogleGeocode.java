package ir.viratech.pond_ms.core.google.geocode;

import ir.viratech.base.SuppressWarningsOption;
import ir.viratech.pond_ms.core.behnevis.BehnevisPinglishToEnglishConverter;
import ir.viratech.pond_ms.core.google.exception.CityNotFoundException;
import ir.viratech.pond_ms.core.google.exception.GeocodeBadRequestException;
import ir.viratech.pond_ms.core.google.exception.GeocodeException;
import ir.viratech.pond_ms.core.google.exception.StateNotFoundException;
import ir.viratech.pond_ms.core.mapper.Mapper;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SuppressWarnings({SuppressWarningsOption.UNUSED, SuppressWarningsOption.ALL})
public class GoogleGeocode {

    private final String BASE_GOOGLE_GEOCODE_API = "https://maps.googleapis.com/maps/api/geocode";

    @SuppressWarnings({SuppressWarningsOption.UNUSED, SuppressWarningsOption.SPELL_CHECKING_INSPECTION})
    public enum QueryString {
        address, latlng, bounds, components, place_id, language, region
    }

    public enum ResponseType {
        json, xml
    }

    public enum Language {
        fa, en
    }

    public enum Region {
        IR, US
    }

    private String apiKey;
    private ResponseType responseType = ResponseType.json;
    private Map<QueryString, String> queryStrings;


    public GoogleGeocode(Map<QueryString, String> queryStrings) {
        this.queryStrings = queryStrings;
    }

    public GoogleGeocode(Map<QueryString, String> queryStrings, String apiKey) {
        this.apiKey = apiKey;
        this.queryStrings = queryStrings;
    }

    public GoogleGeocode(Map<QueryString, String> queryStrings, ResponseType responseType) {
        this.queryStrings = queryStrings;
        this.responseType = responseType;
    }

    public GoogleGeocode(Map<QueryString, String> queryStrings, ResponseType responseType, String apiKey) {
        this.apiKey = apiKey;
        this.queryStrings = queryStrings;
        this.responseType = responseType;
    }

    public GoogleGeocodeResponse execute() throws IOException, GeocodeException, GeocodeBadRequestException {
        String url = generateUrl();
        Connection.Method method = Connection.Method.GET;
        String jsonString = connect(url, method).body();
        GoogleGeocodeResponse response = (GoogleGeocodeResponse) Mapper.map(jsonString, GoogleGeocodeResponse.class);
        if (response.getStatusMessage().equals(GoogleGeocodeResponse.StatusMessage.REQUEST_DENIED))
            throw new GeocodeException(response.getErrorMessage());
        if (response.getStatusMessage().equals(GoogleGeocodeResponse.StatusMessage.INVALID_REQUEST))
            throw new GeocodeBadRequestException(response.getErrorMessage());
        return response;
    }

    private Connection.Response connect(String url, Connection.Method method) throws IOException {
        return Jsoup.connect(url).method(method).ignoreContentType(true).execute();
    }

    private String generateUrl() {
        StringBuilder builder = new StringBuilder(BASE_GOOGLE_GEOCODE_API);
        builder.append("/" + this.responseType + "?");
        if (apiKey != null)
            builder.append("key=" + apiKey);
        if (queryStrings != null)
            for (QueryString key : queryStrings.keySet())
                builder.append("&" + key + "=" + queryStrings.get(key));
        return builder.toString();
    }

    public String getState() throws IOException , StateNotFoundException {
        final String stateKey = "administrative_area_level_1";
        GoogleGeocodeResponse response = null;
        try {
            response = this.execute();
        } catch (GeocodeException e) {
            e.printStackTrace();
        } catch (GeocodeBadRequestException e) {
            e.printStackTrace();
        }
        List<AddressComponent> addressComponentList = new ArrayList<>();
        for (GoogleGeocodeResult result : response.getResults())
            addressComponentList.addAll(result.getAddressComponents());
        for (AddressComponent addressComponent : addressComponentList) {
            for (String type : addressComponent.getTypes() ) {
                if (type.equalsIgnoreCase(stateKey))
                    return addressComponent.getLongName();
            }
        }
        throw new StateNotFoundException();
    }

    public String getCity() throws IOException, CityNotFoundException {
        final String cityKey = "administrative_area_level_2";
        final String alternateCityKey = "locality";
        GoogleGeocodeResponse response = null;
        try {
            response = this.execute();
        } catch (GeocodeException e) {
            e.printStackTrace();
        } catch (GeocodeBadRequestException e) {
            e.printStackTrace();
        }
        List<AddressComponent> addressComponentList = new ArrayList<>();
        for (GoogleGeocodeResult result : response.getResults())
            addressComponentList.addAll(result.getAddressComponents());

        for (int i = 0; i < addressComponentList.size(); i++) {
            if (addressComponentList.get(i).getTypes().contains(cityKey)){
                return addressComponentList.get(i).getLongName();
            }
        }

        for (int i = 0; i < addressComponentList.size(); i++) {
            if (addressComponentList.get(i).getTypes().contains(alternateCityKey)){
                return addressComponentList.get(i).getLongName();
            }
        }

        throw new CityNotFoundException();
    }

    private String mapString(String string) {
        return new BehnevisPinglishToEnglishConverter().map(string);
    }

}
