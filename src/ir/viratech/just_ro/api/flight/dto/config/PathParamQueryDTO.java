package ir.viratech.just_ro.api.flight.dto.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.viratech.base.SuppressWarningsOption;
import ir.viratech.pond_ms.api.map_object.vector.base.BasePointObjectLightDTO;
import org.apache.xpath.operations.Bool;

import javax.ws.rs.DefaultValue;
import java.util.List;

@SuppressWarnings(SuppressWarningsOption.UNUSED)
public class PathParamQueryDTO {

    @JsonProperty("Place")
    private int place;
    @JsonProperty("Pattern")
    private String pattern;
    @JsonProperty("PatternSplitter")
    @DefaultValue("null")
    private String patternSplitter;
    @JsonProperty("Keys")
    private List<String> keys;
    @JsonProperty("DefaultValue")
    @DefaultValue("null")
    private String defaultValue;
    @JsonProperty("UseDefaultValue")
    @DefaultValue("false")
    private boolean useDefaultValue;
    @JsonProperty("DateFormat")
    @DefaultValue("null")
    private String dateFormat;
    @JsonProperty("DateSplitter")
    @DefaultValue("null")
    private String dateFormatSplitter;
    @JsonProperty("UsePersianCityName")
    private Boolean persianCityName;
    @JsonProperty("UseEnglishCityName")
    private Boolean englishCityName;
    @JsonProperty("UseCityCode")
    private Boolean cityCode;
    @JsonProperty("UsePersianDate")
    private Boolean usePersianDate;
    @JsonProperty("UseEnglishDate")
    private Boolean useEnglishDate;

    public Boolean getUsePersianDate() {
        return usePersianDate;
    }

    public void setUsePersianDate(Boolean usePersianDate) {
        this.usePersianDate = usePersianDate;
    }

    public Boolean getUseEnglishDate() {
        return useEnglishDate;
    }

    public void setUseEnglishDate(Boolean useEnglishDate) {
        this.useEnglishDate = useEnglishDate;
    }

    public Boolean getPersianCityName() {
        return persianCityName;
    }

    public void setPersianCityName(Boolean persianCityName) {
        this.persianCityName = persianCityName;
    }

    public Boolean getEnglishCityName() {
        return englishCityName;
    }

    public void setEnglishCityName(Boolean englishCityName) {
        this.englishCityName = englishCityName;
    }

    public Boolean getCityCode() {
        return cityCode;
    }

    public void setCityCode(Boolean cityCode) {
        this.cityCode = cityCode;
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public String getPatternSplitter() {
        return patternSplitter;
    }

    public void setPatternSplitter(String patternSplitter) {
        this.patternSplitter = patternSplitter;
    }

    public List<String> getKeys() {
        return keys;
    }

    public void setKeys(List<String> keys) {
        this.keys = keys;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public boolean isUseDefaultValue() {
        return useDefaultValue;
    }

    public void setUseDefaultValue(boolean useDefaultValue) {
        this.useDefaultValue = useDefaultValue;
    }

    public void setDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
    }

    public String getDateFormat() {
        return dateFormat;
    }

    public void setDateFormatSplitter(String dateFormatSplitter) {
        this.dateFormatSplitter = dateFormatSplitter;
    }

    public String getDateFormatSplitter() {
        return dateFormatSplitter;
    }
}
