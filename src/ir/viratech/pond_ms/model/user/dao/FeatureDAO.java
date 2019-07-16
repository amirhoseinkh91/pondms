package ir.viratech.pond_ms.model.user.dao;

import java.util.List;

import ir.viratech.pond_ms.model.user.Feature;
import ir.viratech.pond_ms.model.user.base.BaseFeatureDAO;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 * DAO class for entity "ir.viratech.pond_ms.model.user.Feature".
 */
public class FeatureDAO extends BaseFeatureDAO {

    @SuppressWarnings("unchecked")
    public List<Feature> getPublicFeatures() {
        return this.findFiltered(Feature.PROP_EXPOSABLE, true).list();
    }

    public Feature getExistingByName(String name) {
        Feature feature = this.getByName(name);
        if (feature == null)
            throw new IllegalArgumentException("No feature found with name '" + name + "'");
        return feature;
    }

    public List<Feature> getFalseExposables() {
        Criteria criteria = this.createCriteria();
        criteria.add(Restrictions.eq(Feature.PROP_EXPOSABLE, false));
        return criteria.list();
    }


}