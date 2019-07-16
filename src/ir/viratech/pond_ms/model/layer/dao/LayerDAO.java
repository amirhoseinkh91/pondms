package ir.viratech.pond_ms.model.layer.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import ir.viratech.pond_ms.core.features.FeatureNames;
import ir.viratech.pond_ms.core.spring.ApplicationContextUtil;
import ir.viratech.pond_ms.model.layer.Layer;
import ir.viratech.pond_ms.model.layer.base.BaseLayerDAO;
import ir.viratech.pond_ms.model.user.authorization.AccessChecker;

/**
 * DAO class for entity "ir.viratech.pond_ms.model.layer.Layer".
 */
public class LayerDAO extends BaseLayerDAO {

    @Override
    public Criteria createCriteria() {
        Criteria criteria = super.createCriteria();
        if (!AccessChecker.hasAccessToAny(ApplicationContextUtil.getCurrentExecutionContext().getUser(), FeatureNames.SEE_SECRET_LAYERS)) {
            criteria.add(Restrictions.eq(Layer.PROP_SECRET, false));
        }
        return criteria;
    }





}