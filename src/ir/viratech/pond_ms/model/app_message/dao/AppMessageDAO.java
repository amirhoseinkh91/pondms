package ir.viratech.pond_ms.model.app_message.dao;

import ir.viratech.pond_ms.model.app_message.AppMessage;
import ir.viratech.pond_ms.model.app_message.base.BaseAppMessageDAO;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.util.Date;
import java.util.List;

/**
 * DAO class for entity "ir.viratech.pond_ms.model.app_message.AppMessage".
 */
public class AppMessageDAO extends BaseAppMessageDAO {

    @Override
    protected Order getDefaultOrder() {
        return Order.desc(AppMessage.PROP_CREATION_DATE);
    }

    public List<AppMessage> getAll(boolean enabled, boolean accessToExpiredItems, int start, int len) {
        Date now = new Date();
        Criteria criteria = createCriteria()
                .add(Restrictions.eq(AppMessage.PROP_ENABLED, enabled))
                .setFirstResult(start)
                .setMaxResults(len);
        if (!accessToExpiredItems)
            criteria.add(Restrictions.gt(AppMessage.PROP_EXPIRATION_DATE , now));
        return criteria.list();
    }

    public long getCount(boolean enabled, boolean accessToExpiredItems) {
        Date now = new Date();
        Criteria criteria = createCriteria()
                .add(Restrictions.eq(AppMessage.PROP_ENABLED, enabled));
        if (!accessToExpiredItems)
            criteria.add(Restrictions.gt(AppMessage.PROP_EXPIRATION_DATE , now));
        return getRowCount(criteria);
    }
}