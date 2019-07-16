package ir.viratech.just_ro.api.flight.dto.config;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by justro on 2/17/18.
 */
public class AlibabaAditionalInfoMapDTO {

    @JsonProperty("Value")
    private Object value;
    @JsonProperty("DataType")
    private DataType dataType;

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public DataType getDataType() {
        return dataType;
    }

    public void setDataType(DataType dataType) {
        this.dataType = dataType;
    }



    public enum DataType {
        Integer, String, Double, Boolean, Char, Float
    }
}
