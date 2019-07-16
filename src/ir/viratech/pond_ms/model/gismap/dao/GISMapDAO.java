package ir.viratech.pond_ms.model.gismap.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import ir.viratech.pond_ms.model.gismap.GISMap;
import ir.viratech.pond_ms.model.gismap.base.BaseGISMapDAO;
import ir.viratech.pond_ms.model.organization.Organization;

/**
 * DAO class for entity "ir.viratech.pond_ms.model.gismap.GISMap".
 */
public class GISMapDAO extends BaseGISMapDAO {

	public GISMap getByOrganizationUID (String orgUID) {
		Criteria criteria = createCriteria();
		criteria.add(Restrictions.eq(GISMap.PROP_ORGANIZATION + "." + Organization.PROP_EXTUID, orgUID));
		return (GISMap) criteria.uniqueResult();
	}

}