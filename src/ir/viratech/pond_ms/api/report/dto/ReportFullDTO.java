package ir.viratech.pond_ms.api.report.dto;

import ir.viratech.pond_ms.api.report.base.BaseReportDTO;

import java.util.Date;

/**
 * Created by amir on 9/10/17.
 */
public class ReportFullDTO extends BaseReportDTO {

    private String text;
    private int rate;
    private int counter;
    private String uid;
    private String objectUid;
    private String creator;
    private Date creationDate;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getObjectUid() {
        return objectUid;
    }

    public void setObjectUid(String objectUid) {
        this.objectUid = objectUid;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}
