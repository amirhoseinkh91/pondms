package ir.viratech.pond_ms.model.layer.dao;

import java.util.Date;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import ir.viratech.pond_ms.core.features.FeatureNames;
import ir.viratech.pond_ms.core.spring.ApplicationContextUtil;
import ir.viratech.pond_ms.model.layer.RasterLayer;
import ir.viratech.pond_ms.model.layer.base.BaseRasterLayerDAO;
import ir.viratech.pond_ms.model.user.authorization.AccessChecker;

/**
 * DAO class for entity "ir.viratech.pond_ms.model.layer.RasterLayer".
 */
public class RasterLayerDAO extends BaseRasterLayerDAO {

	@Override
	public RasterLayer createNew() {
		RasterLayer rl = super.createNew();
		rl.setCreationDate(new Date());
		rl.setExtuid(this.generateUid());
		return rl;
	}

	@Override
	public Criteria createCriteria() {
		Criteria criteria = super.createCriteria();
		if(!AccessChecker.hasAccessToAny(ApplicationContextUtil.getCurrentExecutionContext().getUser(), FeatureNames.SEE_SECRET_LAYERS)){
			criteria.add(Restrictions.eq(RasterLayer.PROP_SECRET, false));
		}
		return criteria;
	}


}