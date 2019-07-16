package ir.viratech.pond_ms.api.tour.mainInformation.base;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.viratech.pond_ms.api.tour.tour.base.BaseTourObjectDTO;

import java.io.Serializable;
import java.util.List;

public class BaseMainTourInformationDTO extends BaseTourObjectDTO implements Serializable{

    public static final String PROP_IS_IRANIAN = "isIranian";
    public static final String PROP_TYPE = "type";
    public static final String PROP_DATE = "date";
    public static final String PROP_PRICE = "price";
    public static final String PROP_IMAGES = "images";
    public static final String PROP_DISCOUNTED_PRICE = "discountedPrice";
    public static final String PROP_SERVICES = "services";
    public static final String PROP_SIGNUP_RULES = "signupRules";
    public static final String PROP_REQUIRED_TOOLS = "requiredTools";
    public static final String PROP_RECOMENDED_TOOLS = "recommendedTools";
    public static final String PROP_SRC_CITY = "srcCity";
    public static final String PROP_DST_COUNTRIES = "dstCountries";
    public static final String PROP_DST_CITIES = "dstCities";

    @JsonProperty
    private boolean isIranian;
    @JsonProperty
    private String name;
    @JsonProperty
    private String type;
    @JsonProperty
    private String duration;
    @JsonProperty
    private String date;
    @JsonProperty
    private Long price;
    @JsonProperty
    private Long discountedPrice;
    @JsonProperty
    private String services;
    @JsonProperty
    private String signupRules;
    @JsonProperty
    private String requiredTools;
    @JsonProperty
    private String recommendedTools;
    @JsonProperty
    private String description;
    @JsonProperty
    private List<String> images;
    @JsonProperty
    private String srcCity;
    @JsonProperty
    private List<String> dstCities;
    @JsonProperty
    private List<String> dstCountries;

    public boolean isIranian() {
        return isIranian;
    }

    public void setIranian(boolean iranian) {
        isIranian = iranian;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getDiscountedPrice() {
        return discountedPrice;
    }

    public void setDiscountedPrice(Long discountedPrice) {
        this.discountedPrice = discountedPrice;
    }

    public String getServices() {
        return services;
    }

    public void setServices(String services) {
        this.services = services;
    }

    public String getSignupRules() {
        return signupRules;
    }

    public void setSignupRules(String signupRules) {
        this.signupRules = signupRules;
    }

    public String getRequiredTools() {
        return requiredTools;
    }

    public void setRequiredTools(String requiredTools) {
        this.requiredTools = requiredTools;
    }

    public String getRecommendedTools() {
        return recommendedTools;
    }

    public void setRecommendedTools(String recommendedTools) {
        this.recommendedTools = recommendedTools;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public String getSrcCity() {
        return srcCity;
    }

    public void setSrcCity(String srcCity) {
        this.srcCity = srcCity;
    }

    public List<String> getDstCities() {
        return dstCities;
    }

    public void setDstCities(List<String> dstCities) {
        this.dstCities = dstCities;
    }

    public List<String> getDstCountries() {
        return dstCountries;
    }

    public void setDstCountries(List<String> dstCountries) {
        this.dstCountries = dstCountries;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BaseMainTourInformationDTO that = (BaseMainTourInformationDTO) o;

        if (isIranian != that.isIranian) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (duration != null ? !duration.equals(that.duration) : that.duration != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (discountedPrice != null ? !discountedPrice.equals(that.discountedPrice) : that.discountedPrice != null)
            return false;
        if (services != null ? !services.equals(that.services) : that.services != null) return false;
        if (signupRules != null ? !signupRules.equals(that.signupRules) : that.signupRules != null) return false;
        if (requiredTools != null ? !requiredTools.equals(that.requiredTools) : that.requiredTools != null)
            return false;
        if (recommendedTools != null ? !recommendedTools.equals(that.recommendedTools) : that.recommendedTools != null)
            return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (images != null ? !images.equals(that.images) : that.images != null) return false;
        if (srcCity != null ? !srcCity.equals(that.srcCity) : that.srcCity != null) return false;
        if (dstCities != null ? !dstCities.equals(that.dstCities) : that.dstCities != null) return false;
        return dstCountries != null ? dstCountries.equals(that.dstCountries) : that.dstCountries == null;
    }

    @Override
    public int hashCode() {
        int result = (isIranian ? 1 : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (duration != null ? duration.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (discountedPrice != null ? discountedPrice.hashCode() : 0);
        result = 31 * result + (services != null ? services.hashCode() : 0);
        result = 31 * result + (signupRules != null ? signupRules.hashCode() : 0);
        result = 31 * result + (requiredTools != null ? requiredTools.hashCode() : 0);
        result = 31 * result + (recommendedTools != null ? recommendedTools.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (images != null ? images.hashCode() : 0);
        result = 31 * result + (srcCity != null ? srcCity.hashCode() : 0);
        result = 31 * result + (dstCities != null ? dstCities.hashCode() : 0);
        result = 31 * result + (dstCountries != null ? dstCountries.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "BaseMainTourInformationDTO{" +
                "isIranian=" + isIranian +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", duration='" + duration + '\'' +
                ", date='" + date + '\'' +
                ", price=" + price +
                ", discountedPrice=" + discountedPrice +
                ", services='" + services + '\'' +
                ", signupRules='" + signupRules + '\'' +
                ", requiredTools='" + requiredTools + '\'' +
                ", recommendedTools='" + recommendedTools + '\'' +
                ", description='" + description + '\'' +
                ", images=" + images +
                ", srcCity='" + srcCity + '\'' +
                ", dstCities=" + dstCities +
                ", dstCountries=" + dstCountries +
                '}';
    }
}
