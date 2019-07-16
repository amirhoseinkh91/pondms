package ir.viratech.pond_ms.model.google_key.dao;

import ir.viratech.pond_ms.model.google_key.GoogleApiKey;
import ir.viratech.pond_ms.model.google_key.base.BaseGoogleApiKeyDAO;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import java.util.Calendar;
import java.util.Date;

/**
 * DAO class for entity "ir.viratech.pond_ms.model.google_key.GoogleApiKey".
 */
public class GoogleApiKeyDAO extends BaseGoogleApiKeyDAO {


    public GoogleApiKey getAvailable() {
        Criteria criteria = this.createCriteria();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1);
        Criterion counterCriterion = Restrictions.le(GoogleApiKey.PROP_USED_COUNTER , 2400 );
        Criterion dateCriterion = Restrictions.le(GoogleApiKey.PROP_LAST_USED_DATE, calendar.getTime());
        criteria.add(Restrictions.or(counterCriterion, dateCriterion));
        criteria.add(Restrictions.eq(GoogleApiKey.PROP_BUSY, false));
        GoogleApiKey googleApiKey = (GoogleApiKey) criteria.list().get(0);

        googleApiKey.setBusy(true);

        Calendar googleApiKeyCal = Calendar.getInstance();
        if (googleApiKey.getLastUsedDate() != null)
            googleApiKeyCal.setTime(googleApiKey.getLastUsedDate());
        else
            googleApiKeyCal.setTime(new Date());
        Calendar nowTempCal = Calendar.getInstance();
        nowTempCal.setTime(new Date());

        if ((nowTempCal.get(Calendar.DAY_OF_MONTH) - googleApiKeyCal.get(Calendar.DAY_OF_MONTH)) > 1)
            googleApiKey.setUsedCounter(0);

        this.update(googleApiKey);
        return googleApiKey;
    }
}