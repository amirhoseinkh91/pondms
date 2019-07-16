package ir.viratech.pond_ms.model.foursquare.logic;


import ir.viratech.commons.spring.tx.ReadTransactional;
import ir.viratech.commons.spring.tx.WriteTransactional;
import ir.viratech.commons.utils.MyDateUtils;
import ir.viratech.pond_ms.model.foursquare.FoursquareKey;
import ir.viratech.pond_ms.model.foursquare.base.BaseFoursquareKeyMgr;
import ir.viratech.pond_ms.model.foursquare.exception.NoAvailableFoursquareKeyFoundException;

import java.util.Date;

/**
 * Mgr class for entity "ir.viratech.pond_ms.model.foursquare.FoursquareKey".
 */
public class FoursquareKeyMgr extends BaseFoursquareKeyMgr {

    @ReadTransactional
    @WriteTransactional
    public FoursquareKey getAvailable() throws NoAvailableFoursquareKeyFoundException {
        FoursquareKey key = this.getDAO().getAvailable();
        key.setBusy(true);
        Date yesterday = MyDateUtils.yesterday();
        Date lastUsedDate = key.getLastUsedDate();
        int dayDifference = MyDateUtils.dayDifference(yesterday, lastUsedDate);
        if (dayDifference > 1)
            key.setUsedCount(0);
        this.update(key);
        return key;
    }
    
}