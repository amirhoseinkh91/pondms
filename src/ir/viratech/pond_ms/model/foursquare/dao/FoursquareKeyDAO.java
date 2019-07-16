package ir.viratech.pond_ms.model.foursquare.dao;

import ir.viratech.commons.spring.tx.WriteTransactional;
import ir.viratech.commons.utils.MyDateUtils;
import ir.viratech.pond_ms.model.foursquare.FoursquareKey;
import ir.viratech.pond_ms.model.foursquare.base.BaseFoursquareKeyDAO;
import ir.viratech.pond_ms.model.foursquare.exception.NoAvailableFoursquareKeyFoundException;
import org.hibernate.Criteria;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * DAO class for entity "ir.viratech.pond_ms.model.foursquare.FoursquareKey".
 */
public class FoursquareKeyDAO extends BaseFoursquareKeyDAO {


    public FoursquareKey getAvailable() throws NoAvailableFoursquareKeyFoundException {
        Criteria criteria = this.createCriteria();
        Date yesterday = new Date(MyDateUtils.now().getTime() - TimeUnit.DAYS.toMillis(1));
        Criterion dateRestriction = Restrictions.lt(FoursquareKey.PROP_LAST_USED_DATE, yesterday);
        Criterion countRestriction = Restrictions.lt(FoursquareKey.PROP_USED_COUNT, 1000);
        Criterion notBusyRestriction = Restrictions.eq(FoursquareKey.PROP_BUSY, false);
        LogicalExpression dateOrCountRest = Restrictions.or(dateRestriction, countRestriction);
        criteria.add(Restrictions.and(dateOrCountRest, notBusyRestriction));

        @SuppressWarnings("unchecked")
        List<FoursquareKey> res = (List<FoursquareKey>) criteria.list();
        if (res != null && res.size() > 0) {
            FoursquareKey foursquareKey = res.get(0);
            return foursquareKey;
        }
        throw new NoAvailableFoursquareKeyFoundException("No available foursquare key found.");
    }
}