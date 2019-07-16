package ir.viratech.pond_ms.model.time_series.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import ir.viratech.pond_ms.model.layer.Pond;
import ir.viratech.pond_ms.model.map_object.vector.GISVectorObject;
import ir.viratech.pond_ms.model.time_series.RootCategory;
import ir.viratech.pond_ms.model.time_series.TimeSeriesGroup;
import ir.viratech.pond_ms.model.time_series.base.BaseRootCategoryDAO;

/**
 * DAO class for entity "ir.viratech.pond_ms.model.time_series.RootCategory".
 */
public class RootCategoryDAO extends BaseRootCategoryDAO {

	@SuppressWarnings("unchecked")
	public RootCategory getByGroupUidAndPondUid(String groupUid,String pondUid)
	{
		Criteria criteria = createCriteria();
		criteria.createAlias(RootCategory.PROP_GROUP, "group");
		criteria.add(Restrictions.eq("group."+TimeSeriesGroup.PROP_EXTUID, groupUid));
		criteria.createAlias(RootCategory.PROP_POND, "pond");
		criteria.add(Restrictions.eq("pond."+Pond.PROP_EXTUID, pondUid));
		
		List<RootCategory> list = criteria.list();
		
		if(!list.isEmpty())
			return list.get(0);
		
		return null;
	}

	@SuppressWarnings("unchecked")
	public RootCategory getByGroupUidAndObjectUid(String groupUid, String objectUid) {
		Criteria criteria = createCriteria();
		criteria.createAlias(RootCategory.PROP_GROUP, "group");
		criteria.add(Restrictions.eq("group."+TimeSeriesGroup.PROP_EXTUID, groupUid));
		criteria.createAlias(RootCategory.PROP_G_I_S_VECTOR_OBJECT, "object");
		criteria.add(Restrictions.eq("object." + GISVectorObject.PROP_EXTUID, objectUid));

		List<RootCategory> list = criteria.list();
		
		if(!list.isEmpty())
			return list.get(0);
		
		return null;
	}

}