package ir.viratech.pond_ms.model.layer.dao;

import ir.viratech.pond_ms.core.i18n.MessageService;
import ir.viratech.pond_ms.model.layer.Layer;
import ir.viratech.pond_ms.model.layer.ParentLayer;
import ir.viratech.pond_ms.model.layer.base.BaseParentLayerDAO;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * DAO class for entity "ir.viratech.pond_ms.model.layer.ParentLayer".
 */
public class ParentLayerDAO extends BaseParentLayerDAO {

    @Override
    public ParentLayer createNew() {
        ParentLayer pl = super.createNew();
        pl.setCreationDate(new Date());
        pl.setExtuid(this.generateUid());
        pl.setSubLayers(new ArrayList<Layer>());
        return pl;
    }

    public ParentLayer getByName(String parentLayerName) {
        Criteria criteria = this.createCriteria();
        criteria.add(Restrictions.ilike(ParentLayer.PROP_NAME, parentLayerName));
        ParentLayer parentLayer = null;
        try {
            parentLayer = (ParentLayer) criteria.uniqueResult();
            return parentLayer;
        } catch (org.hibernate.NonUniqueResultException e) {
            System.out.println("-==-=-==--====-=-==-=-==-=-=-=-=-=-==-=-=-=---===--");
            System.out.println(parentLayer.getName() + " name : " + parentLayer.getParentLayer().getName());
            System.out.println("-==-=-==--====-=-==-=-==-=-=-=-=-=-==-=-=-=---===--");
            e.printStackTrace();
            throw new org.hibernate.NonUniqueResultException(2);
        }

    }

    public ParentLayer getByCityName(String cityName) {
        Criteria criteria = createCriteria();
        criteria.add(Restrictions.eq(Layer.PROP_NAME, cityName));
        return (ParentLayer) criteria.uniqueResult();
    }

    public ParentLayer getByCityNameLike(String cityName) {
        Criteria criteria = createCriteria();
        criteria.add(Restrictions.ilike(Layer.PROP_NAME, cityName, MatchMode.ANYWHERE));
        return ((ParentLayer) criteria.uniqueResult());
    }


    public List<ParentLayer> getByProvince() {
        Criteria criteria = createCriteria();
        criteria.add(Restrictions.ilike(Layer.PROP_NAME, MessageService.getMessage("province"), MatchMode.START));
        return criteria.list();
    }

    public List<ParentLayer> getByProvinceName(String provinceName) {
        Criteria criteria = createCriteria();
        criteria.add(Restrictions.and(Restrictions.ilike(Layer.PROP_NAME, MessageService.getMessage("province"), MatchMode.START), Restrictions.ilike(Layer.PROP_NAME, provinceName, MatchMode.ANYWHERE)));
        return criteria.list();
    }

}