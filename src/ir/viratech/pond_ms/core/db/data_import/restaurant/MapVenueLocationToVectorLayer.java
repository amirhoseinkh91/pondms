package ir.viratech.pond_ms.core.db.data_import.restaurant;

import ir.viratech.pond_ms.core.db.data_import.exception.CityNotFoundException;
import ir.viratech.pond_ms.core.db.data_import.exception.RestaurantLayerNotFoundException;
import ir.viratech.pond_ms.core.db.data_import.restaurant.foursquare.FoursquareVenue;
import ir.viratech.pond_ms.model.layer.Layer;
import ir.viratech.pond_ms.model.layer.ParentLayer;
import ir.viratech.pond_ms.model.layer.VectorLayer;
import ir.viratech.pond_ms.model.layer.logic.ParentLayerMgr;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.IOException;

public class MapVenueLocationToVectorLayer {

    private FoursquareVenue venue;

    public MapVenueLocationToVectorLayer(FoursquareVenue venue) {
        this.venue = venue;
    }

    public VectorLayer getVectorLayer() throws CityNotFoundException, RestaurantLayerNotFoundException {
        VectorLayer vectorLayer = findVectorLayer();
        if (vectorLayer != null)
            return vectorLayer;
        else
            throw new CityNotFoundException("city is null");

    }

    private VectorLayer findVectorLayer() throws RestaurantLayerNotFoundException {
        try {
            String city = getCity();
            return getVectorLayer(city);
        } catch (NullPointerException e) {
            return null;
        } catch (IOException e) {
            return null;
        }
    }

    private VectorLayer getVectorLayer(String city) throws IOException, RestaurantLayerNotFoundException {
        String faCity = "شهر";
        String parentLayerName = faCity.trim().concat(" ").concat(city).trim();

        ParentLayer parentLayer = ParentLayerMgr.getInstance().getByName(parentLayerName);
        VectorLayer restaurantVectorLayer = null;
        for(Layer layer : parentLayer.getSubLayers()) {
            VectorLayer vectorLayer = (VectorLayer) layer;
            if (vectorLayer.getFormSchemaKey().equals("Restaurant"))
                restaurantVectorLayer = vectorLayer;
        }
        if (restaurantVectorLayer != null) {
            return restaurantVectorLayer;
        } else {
            throw new RestaurantLayerNotFoundException("layer restaurant not found for city: " + city);
        }
    }

    private String mapCityName(String city) throws IOException {
        String persianCityName = mapFinglishToPersian("shahr%20" + city).trim();
        StringBuilder builder = new StringBuilder("شهر");
        builder.append(" ");
        builder.append(persianCityName);
        return persianCityName;
    }

    @SuppressWarnings("All")
    private String mapFinglishToPersian(String string) throws IOException {
        String url = "http://www.behnevis.com/php/convert.php";
        Connection.Response res = Jsoup.connect(url).method(Connection.Method.POST)
                .header("Content-Type", "application/x-www-form-urlencoded").requestBody("farsi=" + string).execute();
        return res.body();
    }

    private String getCity() throws NullPointerException {
        if (venue.getLocation().getCity() == null)
            throw new NullPointerException("venue city is null");
        if (venue.getLocation().getCity().equals("لواسان"))
            return "شهر لواسانات";
        return venue.getLocation().getCity();
    }

}
