package ir.viratech.just_ro.api.flight.dto.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.viratech.base.SuppressWarningsOption;

import javax.ws.rs.DefaultValue;
import java.util.Map;

@SuppressWarnings(SuppressWarningsOption.UNUSED)
public class QueryDTO {

    @JsonProperty("SrcCity")
    private QueryMapDTO srcCity;
    @JsonProperty("DstCity")
    private QueryMapDTO dstCity;
    @JsonProperty("Adult")
    private QueryMapDTO adult;
    @JsonProperty("Children")
    private QueryMapDTO children;
    @JsonProperty("Infant")
    private QueryMapDTO infant;
    @JsonProperty("DepartureDate")
    private QueryMapDTO departureDate;
    @JsonProperty("UsePersianDate")
    @DefaultValue("true")
    private Boolean usePersianDate;
    @JsonProperty("DateSplitter")
    private String dateSplitter;
    @JsonProperty("DateFormat")
    private String dateFormat;
    @JsonProperty("UseCityCode")
    @DefaultValue("true")
    private boolean useCityCode;
    @JsonProperty("UsePersianCityName")
    @DefaultValue("false")
    private boolean usePersianCityName;
    @JsonProperty("UseEnglishCityName")
    @DefaultValue("false")
    private boolean useEnglishCityName;

    public Map<String, AlibabaAditionalInfoMapDTO> getAdditionalQueries() {
        return additionalQueries;
    }

    public void setAdditionalQueries(Map<String, AlibabaAditionalInfoMapDTO> additionalQueries) {
        this.additionalQueries = additionalQueries;
    }

    @JsonProperty("AdditioanlQueries")
    private Map<String , AlibabaAditionalInfoMapDTO> additionalQueries;

    public QueryMapDTO getSrcCity() {
        return srcCity;
    }

    public void setSrcCity(QueryMapDTO srcCity) {
        this.srcCity = srcCity;
    }

    public QueryMapDTO getDstCity() {
        return dstCity;
    }

    public void setDstCity(QueryMapDTO dstCity) {
        this.dstCity = dstCity;
    }

    public QueryMapDTO getAdult() {
        return adult;
    }

    public void setAdult(QueryMapDTO adult) {
        this.adult = adult;
    }

    public QueryMapDTO getChildren() {
        return children;
    }

    public void setChildren(QueryMapDTO children) {
        this.children = children;
    }

    public QueryMapDTO getInfant() {
        return infant;
    }

    public void setInfant(QueryMapDTO infant) {
        this.infant = infant;
    }

    public QueryMapDTO getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(QueryMapDTO departureDate) {
        this.departureDate = departureDate;
    }

    public Boolean getUsePersianDate() {
        return usePersianDate;
    }

    public void setUsePersianDate(Boolean usePersianDate) {
        this.usePersianDate = usePersianDate;
    }

    public String getDateSplitter() {
        return dateSplitter;
    }

    public void setDateSplitter(String dateSplitter) {
        this.dateSplitter = dateSplitter;
    }

    public String getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
    }

    public boolean isUseCityCode() {
        return useCityCode;
    }

    public void setUseCityCode(boolean useCityCode) {
        this.useCityCode = useCityCode;
    }

    public boolean isUsePersianCityName() {
        return usePersianCityName;
    }

    public void setUsePersianCityName(boolean usePersianCityName) {
        this.usePersianCityName = usePersianCityName;
    }

    public boolean isUseEnglishCityName() {
        return useEnglishCityName;
    }

    public void setUseEnglishCityName(boolean useEnglishCityName) {
        this.useEnglishCityName = useEnglishCityName;
    }
}
