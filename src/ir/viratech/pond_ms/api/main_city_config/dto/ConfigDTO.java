package ir.viratech.pond_ms.api.main_city_config.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.viratech.pond_ms.api.main_city_config.MakePointParam;

import java.util.List;
import java.util.Map;

public class ConfigDTO {
    @JsonProperty("name")
    private String name;
    @JsonProperty("visitPage")
    private int visitPage;
    @JsonProperty("type")
    private String type;
    @JsonProperty("sortBy")
    private Map<String, String> sortBy;
    @JsonProperty("filter")
    private Filter filter;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVisitPage() {
        return visitPage;
    }

    public void setVisitPage(int visitPage) {
        this.visitPage = visitPage;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public Map<String, String> getSortBy() {
        return sortBy;
    }

    public void setSortBy(Map<String, String> sortBy) {
        this.sortBy = sortBy;
    }

    public Filter getFilter() {
        return filter;
    }

    public void setFilter(Filter filter) {
        this.filter = filter;
    }

    public static class Filter {
        @JsonProperty("queryName")
        private String queryName;
        @JsonProperty("cityName")
        private String cityName;
        @JsonProperty("cityUid")
        private String cityUid;
        @JsonProperty("point")
        private MakePointParam point;
        @JsonProperty("tags")
        private List<String> tags;
        @JsonProperty("features")
        private List<String> features;
        @JsonProperty("rates")
        private List<Integer> rates;
        @JsonProperty("prices")
        private List<Integer> prices;
        @JsonProperty("new-tags")
        private List<String> newTags;


        public List<String> getNewTags() {
            return newTags;
        }

        public void setNewTags(List<String> newTags) {
            this.newTags = newTags;
        }

        public String getCityUid() {
            return cityUid;
        }

        public void setCityUid(String cityUid) {
            this.cityUid = cityUid;
        }

        public String getQueryName() {
            return queryName;
        }

        public void setQueryName(String queryName) {
            this.queryName = queryName;
        }

        public List<Integer> getRates() {
            return rates;
        }

        public void setRates(List<Integer> rates) {
            this.rates = rates;
        }

        public List<Integer> getPrices() {
            return prices;
        }

        public void setPrices(List<Integer> prices) {
            this.prices = prices;
        }

        public String getCityName() {
            return cityName;
        }

        public void setCityName(String cityName) {
            this.cityName = cityName;
        }

        public MakePointParam getPoint() {
            return point;
        }

        public void setPoint(MakePointParam point) {
            this.point = point;
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


}



