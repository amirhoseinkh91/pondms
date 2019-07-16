package ir.viratech.pond_ms.model.layer.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import ir.viratech.pond_ms.core.features.FeatureNames;
import ir.viratech.pond_ms.core.spring.ApplicationContextUtil;
import ir.viratech.pond_ms.model.layer.VectorLayer;
import ir.viratech.pond_ms.model.layer.base.BaseVectorLayerDAO;
import ir.viratech.pond_ms.model.user.authorization.AccessChecker;

/**
 * DAO class for entity "ir.viratech.pond_ms.model.layer.VectorLayer".
 */
public class VectorLayerDAO extends BaseVectorLayerDAO {

	@Override
	public Criteria createCriteria() {
		Criteria criteria = super.createCriteria();
		if(!AccessChecker.hasAccessToAny(ApplicationContextUtil.getCurrentExecutionContext().getUser(), FeatureNames.SEE_SECRET_LAYERS)){
			criteria.add(Restrictions.eq(VectorLayer.PROP_SECRET, false));
		}
		return criteria;
	}
}