package ir.viratech.pond_ms.model.user.logic;


import ir.viratech.commons.spring.tx.ReadTransactional;
import ir.viratech.pond_ms.model.user.Feature;
import ir.viratech.pond_ms.model.user.base.BaseFeatureMgr;

import java.util.List;

/**
 * Mgr class for entity "ir.viratech.pond_ms.model.user.Feature".
 */
public class FeatureMgr extends BaseFeatureMgr {

    @ReadTransactional
    public List<Feature> getPublicFeatures() {
        return this.getDAO().getPublicFeatures();
    }

    public List<Feature> getFalseExposables() {
        return this.getDAO().getFalseExposables();
    }

}