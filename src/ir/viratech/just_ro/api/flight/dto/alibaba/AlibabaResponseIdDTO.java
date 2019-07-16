package ir.viratech.just_ro.api.flight.dto.alibaba;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.viratech.just_ro.api.flight.dto.config.AlibabaAditionalInfoMapDTO;
import org.apache.xpath.operations.Bool;

import javax.ws.rs.DefaultValue;

/**
 * Created by justro on 2/17/18.
 */
public class AlibabaResponseIdDTO {

    @JsonProperty("ErrorCode")
    private AlibabaAditionalInfoMapDTO errorCode;
    @JsonProperty("ErrorMessage")
    private AlibabaAditionalInfoMapDTO errorMessage;
    @JsonProperty("EstimatedDelay")
    private AlibabaAditionalInfoMapDTO estimatedDelay;
    @JsonProperty("Interval")
    private AlibabaAditionalInfoMapDTO interval;
    @JsonProperty("IsValid")
    private AlibabaAditionalInfoMapDTO isValid;
    @JsonProperty("RequestId")
    private AlibabaAditionalInfoMapDTO requestID;
    @JsonProperty("ReservationRequired")
    private AlibabaAditionalInfoMapDTO reservationRequired;
    @JsonProperty("last")
    private AlibabaAditionalInfoMapDTO last;
    @JsonProperty("count")
    private AlibabaAditionalInfoMapDTO count;
    @JsonProperty("isReturn")
    private AlibabaAditionalInfoMapDTO isReturn;

    public AlibabaAditionalInfoMapDTO getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(AlibabaAditionalInfoMapDTO errorCode) {
        this.errorCode = errorCode;
    }

    public AlibabaAditionalInfoMapDTO getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(AlibabaAditionalInfoMapDTO errorMessage) {
        this.errorMessage = errorMessage;
    }

    public AlibabaAditionalInfoMapDTO getEstimatedDelay() {
        return estimatedDelay;
    }

    public void setEstimatedDelay(AlibabaAditionalInfoMapDTO estimatedDelay) {
        this.estimatedDelay = estimatedDelay;
    }

    public AlibabaAditionalInfoMapDTO getInterval() {
        return interval;
    }

    public void setInterval(AlibabaAditionalInfoMapDTO interval) {
        this.interval = interval;
    }

    public AlibabaAditionalInfoMapDTO getIsValid() {
        return isValid;
    }

    public void setIsValid(AlibabaAditionalInfoMapDTO isValid) {
        this.isValid = isValid;
    }

    public AlibabaAditionalInfoMapDTO getRequestID() {
        return requestID;
    }

    public void setRequestID(AlibabaAditionalInfoMapDTO requestID) {
        this.requestID = requestID;
    }

    public AlibabaAditionalInfoMapDTO getReservationRequired() {
        return reservationRequired;
    }

    public void setReservationRequired(AlibabaAditionalInfoMapDTO reservationRequired) {
        this.reservationRequired = reservationRequired;
    }

    public AlibabaAditionalInfoMapDTO getLast() {
        return last;
    }

    public void setLast(AlibabaAditionalInfoMapDTO last) {
        this.last = last;
    }

    public AlibabaAditionalInfoMapDTO getCount() {
        return count;
    }

    public void setCount(AlibabaAditionalInfoMapDTO count) {
        this.count = count;
    }

    public AlibabaAditionalInfoMapDTO getIsReturn() {
        return isReturn;
    }

    public void setIsReturn(AlibabaAditionalInfoMapDTO isReturn) {
        this.isReturn = isReturn;
    }

    public AlibabaAditionalInfoMapDTO getIsNew() {
        return isNew;
    }

    public void setIsNew(AlibabaAditionalInfoMapDTO isNew) {
        this.isNew = isNew;
    }

    @JsonProperty("isNew")
    private AlibabaAditionalInfoMapDTO isNew;


}
