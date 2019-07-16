package ir.viratech.pond_ms.api.report.base;

import ir.viratech.pond_ms.api.report.dto.ReportFullDTO;
import ir.viratech.pond_ms.model.report.Report;
import ir.viratech.pond_ms.model.report.logic.ReportMgr;

/**
 * Created by amir on 9/10/17.
 */
public class BaseReportDTO {

    public static Report parse(ReportFullDTO reportFullDTO) {
        Report report = ReportMgr.getInstance().createNew();
        report.setText(reportFullDTO.getText());
        report.setObjectUid(reportFullDTO.getObjectUid());
        report.setRate(reportFullDTO.getRate());
        return report;
    }

}
