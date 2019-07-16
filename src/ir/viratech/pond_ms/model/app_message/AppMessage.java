package ir.viratech.pond_ms.model.app_message;

import ir.viratech.commons.model.UIDAndDisplayStringProvider;
import ir.viratech.commons.utils.DatePrettyPrintConverter;
import ir.viratech.pond_ms.model.app_message.base.BaseAppMessage;
import ir.viratech.pond_ms.model.app_message.dao.AppMessageUrlDAO;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * The entity class "AppMessage".
 */

public class AppMessage extends BaseAppMessage implements UIDAndDisplayStringProvider {
    private static final long serialVersionUID = 1L;


    public String getCreationDateString() {
        Date creationDate = getCreationDate();
        return DatePrettyPrintConverter.convertToPrerttyString(creationDate);
    }

    @Override
    public String getDisplayString() {
        return getTitle();
    }


    public void addToUrls(String url) {
        AppMessageUrl appMessageUrl = AppMessageUrlDAO.getInstance().createNew();
        appMessageUrl.setUrl(url);
        this.addToUrls(appMessageUrl);
    }
}