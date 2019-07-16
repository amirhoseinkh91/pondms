package ir.viratech.pond_ms.model.main_city_config;

import java.util.List;

@SuppressWarnings("unused")
public class ConfigFilter {

    public ConfigFilter(){}

    //see more
    public ConfigFilter(String queryName, String cityName, ConfigPoint point, List<Integer> prices, List<Integer> rates, List<String> tags,List<String> features) {
        this.queryName = queryName;
        this.cityName = cityName;
        this.point = point;
        this.prices = prices;
        this.rates = rates;
        this.tags = tags;
        this.features=features;

    }

    //main page
    public ConfigFilter(String cityName, ConfigPoint point, List<Integer> prices, List<Integer> rates, List<String> tags,List<String> features) {
        this.cityName = cityName;
        this.point = point;
        this.prices = prices;
        this.rates = rates;
        this.tags = tags;
        this.features=features;
    }

    //collection main page
    public ConfigFilter(String layer, String cityName, List<Integer> prices, List<Integer> rates, List<String> tags,List<String> features) {
        this.layer = layer;
        this.cityName = cityName;
        this.prices = prices;
        this.rates = rates;
        this.tags = tags;
        this.features=features;
    }

    private String layer;
    private String queryName;
    private String cityName;
    private ConfigPoint point;
    private String cityUid;
    private List<Integer> prices;
    private List<Integer> rates;
    private List<String> tags;
    private List<String> features;


    public String getCityUid() {
        return cityUid;
    }

    public void setCityUid(String cityUid) {
        this.cityUid = cityUid;
    }

    public String getLayer() {
        return layer;
    }

    public void setLayer(String layer) {
        this.layer = layer;
    }

    public String getQueryName() {
        return queryName;
    }

    public void setQueryName(String queryName) {
        this.queryName = queryName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public ConfigPoint getPoint() {
        return point;
    }

    public void setPoint(ConfigPoint point) {
        this.point = point;
    }

    public List<Integer> getPrices() {
        return prices;
    }

    public void setPrices(List<Integer> prices) {
        this.prices = prices;
    }

    public List<Integer> getRates() {
        return rates;
    }

    public void setRates(List<Integer> rates) {
        this.rates = rates;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public List<String> getFeatures() {
        return features;
    }

    public void setFeatures(List<String> features) {
        this.features = features;
    }
}
