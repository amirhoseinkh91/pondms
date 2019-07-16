package ir.viratech.pond_ms.core.features;

import ir.viratech.pond_ms.core.spring.ApplicationContextUtil;
import ir.viratech.pond_ms.model.user.Feature;
import ir.viratech.pond_ms.model.user.logic.FeatureMgr;

import java.util.List;

public class FalseFeaturesToTrue {

    public static void main(String[] args) {
        ApplicationContextUtil.initializeCliApplicationContext();
        List<Feature> falseExposables = FeatureMgr.getInstance().getFalseExposables();
        int counter = 0;
        for (Feature feature : falseExposables) {
            feature.setExposable(true);
            FeatureMgr.getInstance().update(feature);
            counter++;
        }
        System.out.println(counter + "\t is updated");
    }

}
