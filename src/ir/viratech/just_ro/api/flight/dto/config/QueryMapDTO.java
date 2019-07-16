package ir.viratech.just_ro.api.flight.dto.config;

import com.fasterxml.jackson.annotation.JsonProperty;

public class QueryMapDTO {

    @JsonProperty("Key")
    private String key;

    @JsonProperty("DataType")
    private DataType dataType;

    public enum DataType{
        Integer, String, Double, Boolean, Char, Float
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public QueryMapDTO.DataType getDataType() {
        return dataType;
    }

    public void setDataType(QueryMapDTO.DataType dataType) {
        this.dataType = dataType;
    }
}
