package ir.viratech.pond_ms.model.map_object.vector.dao;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import ir.viratech.commons.model.SimpleListAndTotalCount;
import ir.viratech.commons.model.order.OrderDirection;
import ir.viratech.commons.model.order.SimpleOrderEntry;
import ir.viratech.commons.model.search.InvalidSearchQueryException;
import ir.viratech.commons.model.search.SearchQuery;
import ir.viratech.commons.paged_list.api.PagedList;
import ir.viratech.commons.persistence.hibernate.search.AliasSystem;
import ir.viratech.commons.persistence.mongo.base.MongoDBManager;
import ir.viratech.pond_ms.core.features.FeatureNames;
import ir.viratech.pond_ms.core.spring.ApplicationContextUtil;
import ir.viratech.pond_ms.model.layer.Layer;
import ir.viratech.pond_ms.model.layer.VectorLayer;
import ir.viratech.pond_ms.model.map_object.vector.GISVectorObject;
import ir.viratech.pond_ms.model.map_object.vector.base.BaseGISVectorObjectDAO;
import ir.viratech.pond_ms.model.user.authorization.AccessChecker;
import org.apache.commons.collections.CollectionUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import java.io.IOException;

/**
 * DAO class for entity "ir.viratech.pond_ms.model.map_object.vector.GISVectorObject".
 */
public class GISVectorObjectDAO extends BaseGISVectorObjectDAO {

    @Override
    public Criteria createCriteria() {
        Criteria criteria = super.createCriteria();
        AliasSystem aliasSystem = new AliasSystem(criteria);
        if (!AccessChecker.hasAccessToAny(ApplicationContextUtil.getCurrentExecutionContext().getUser(), FeatureNames.SEE_SECRET_LAYERS)) {
            criteria.add(Restrictions.eq(aliasSystem.getElement(GISVectorObject.PROP_LAYER + "." + Layer.PROP_SECRET), false));
        }
        return criteria;
    }

    public SimpleListAndTotalCount<GISVectorObject> getLayerObjects(long start, int len, VectorLayer vectorLayer) {
        Criteria criteria = this.createCriteria();
        criteria.add(Restrictions.eq(GISVectorObject.PROP_LAYER, vectorLayer));
        long count = (long) criteria.setProjection(Projections.rowCount()).uniqueResult();
        Criteria criteria1 = this.createCriteria();
        criteria1.add(Restrictions.eq(GISVectorObject.PROP_LAYER, vectorLayer));
        SimpleListAndTotalCount<GISVectorObject> result = new SimpleListAndTotalCount<>();
        result.setTotalCount(count);
        criteria1.setFirstResult((int) start);
        criteria1.setMaxResults(len);
        result.setItems(getList(criteria1));

        return result;
    }

    @Override
    public PagedList<GISVectorObject> search(SearchQuery searchQuery) throws InvalidSearchQueryException {
        if (CollectionUtils.isEmpty(searchQuery.getOrderEntries())) {
            Order defaultOrder = getDefaultOrder();
            searchQuery.addToOrderEntries(new SimpleOrderEntry(defaultOrder.getPropertyName(), defaultOrder.isAscending() ? OrderDirection.ASCENDING : OrderDirection.DESCENDING));
        }
        return super.search(searchQuery);
    }

    @Override
    protected Order getDefaultOrder() {
        return Order.asc(GISVectorObject.PROP_NAME);
    }

    public JsonNode getByFormField(String collection, String key, String value) throws JsonProcessingException, IOException {
        MongoDBManager manager = MongoDBManager.getInstance();
        String query = null;

        return manager.executeQuery(query);
    }
}