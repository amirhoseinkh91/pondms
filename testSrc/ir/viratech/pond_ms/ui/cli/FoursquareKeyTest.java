package ir.viratech.pond_ms.ui.cli;

import ir.viratech.base.AbstractEntityDAO;
import ir.viratech.commons.utils.MyDateUtils;
import ir.viratech.pond_ms.core.spring.ApplicationContextUtil;
import ir.viratech.pond_ms.model.foursquare.FoursquareKey;
import ir.viratech.pond_ms.model.foursquare.exception.NoAvailableFoursquareKeyFoundException;
import ir.viratech.pond_ms.model.foursquare.logic.FoursquareKeyMgr;

public class FoursquareKeyTest {

    public static void main(String[] args) {
        ApplicationContextUtil.initializeCliApplicationContext();
        AbstractEntityDAO.touchSession();

        for (int i = 0; i < 11; i++) {
            System.out.println("=================================");
            System.out.println("counter : " + (i + 1));
            try {
                FoursquareKey availableKey = getAvailable();
                updateKey(availableKey);
            } catch (NoAvailableFoursquareKeyFoundException e) {
                e.printStackTrace();
            }
        }

        AbstractEntityDAO.closeCurrentThreadSessions();
    }

    private static void updateKey(FoursquareKey availableKey) {
        availableKey.setUsedCount(availableKey.getUsedCount() * 2);
        availableKey.setBusy(false);
        availableKey.setLastUsedDate(MyDateUtils.now());
        FoursquareKeyMgr.getInstance().update(availableKey);
    }

    private static FoursquareKey getAvailable() throws NoAvailableFoursquareKeyFoundException {
        FoursquareKey available = FoursquareKeyMgr.getInstance().getAvailable();
        System.out.println(available.getDisplayString());
        return available;
    }

}
