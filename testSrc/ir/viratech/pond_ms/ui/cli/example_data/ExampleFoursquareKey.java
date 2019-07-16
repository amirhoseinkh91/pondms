package ir.viratech.pond_ms.ui.cli.example_data;

import ir.viratech.pond_ms.core.spring.ApplicationContextUtil;
import ir.viratech.pond_ms.model.foursquare.FoursquareKey;
import ir.viratech.pond_ms.model.foursquare.logic.FoursquareKeyMgr;

import java.util.ArrayList;
import java.util.List;

public class ExampleFoursquareKey {

    public static void main(String... args) {

        ApplicationContextUtil.initializeCliApplicationContext();
        List<FoursquareKey> keys = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            FoursquareKey foursquareKey = FoursquareKeyMgr.getInstance().createNew();
            foursquareKey.setClientId("clientId " + i);
            foursquareKey.setClientSecret("clientSecret" + i);
            foursquareKey.setMaxUsage(1000);
            foursquareKey.setUsedCount((int) Math.pow(i,4));
            keys.add(foursquareKey);
        }
        FoursquareKeyMgr.getInstance().add(keys);
    }
}
