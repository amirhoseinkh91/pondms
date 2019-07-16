package ir.viratech.pond_ms.model.app_message.logic;


import ir.viratech.commons.spring.tx.ReadTransactional;
import ir.viratech.pond_ms.model.app_message.AppMessage;
import ir.viratech.pond_ms.model.app_message.base.BaseAppMessageMgr;

import java.util.List;

/**
 * Mgr class for entity "ir.viratech.pond_ms.model.app_message.AppMessage".
 */
public class AppMessageMgr extends BaseAppMessageMgr {


    @ReadTransactional
    public List<AppMessage> getActivatedAndUnexpired(int start, int len) {
        return getDAO().getAll(true, false, start , len);
    }

    public long getActivatedAndUnexpiredCount() {
        return getDAO().getCount(true, false);
    }
}