package ir.viratech.pond_ms.api.report.dto;

import ir.viratech.pond_ms.api.report.base.BaseReportDTO;

/**
 * Created by amir on 9/10/17.
 */
public class ReportLightDTO extends BaseReportDTO {

    private String text;
    private int rate;
    private String objectUid;

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

    public String getObjectUid() {
        return objectUid;
    }

    public void setObjectUid(String objectUid) {
        this.objectUid = objectUid;
    }
}
