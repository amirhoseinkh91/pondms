package ir.viratech.pond_ms.model.review.dao;

import ir.viratech.commons.model.ListAndTotalCount;
import ir.viratech.commons.model.SimpleListAndTotalCount;
import ir.viratech.pond_ms.model.map_object.vector.GISVectorObject;
import ir.viratech.pond_ms.model.review.Review;
import ir.viratech.pond_ms.model.review.base.BaseReviewDAO;
import ir.viratech.pond_ms.model.user.User;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import java.util.Date;
import java.util.List;

/**
 * DAO class for entity "ir.viratech.pond_ms.model.review.Review".
 */
public class ReviewDAO extends BaseReviewDAO {

    @Override
    protected Order getDefaultOrder() {
        return Order.desc(Review.PROP_LAST_MODIFIED_DATE);
    }

    public List<Review> getConfirmedByUser(User user, int start, int len) {
        Criteria criteria = this.createCriteria()
                .add(Restrictions.eq(Review.PROP_DELETED, false))
                .add(Restrictions.eq(Review.PROP_USER, user))
                .add(Restrictions.eq(Review.PROP_CONFIRMED, 1))
                .addOrder(Order.desc(Review.PROP_CREATION_DATE))
                .setFirstResult(start)
                .setMaxResults(len);
        return criteria.list();
    }

    public List<Review> getConfirmedReviews(int start, int len) {
        Criteria criteria = this.createCriteria()
                .add(Restrictions.eq(Review.PROP_CONFIRMED, 1))
                .addOrder(Order.desc(Review.PROP_CREATION_DATE))
                .setFirstResult(start)
                .setMaxResults(len);
        return criteria.list();
    }

    public List<Review> getUnConfirmedReviews(int start, int len) {
        Criteria criteria = this.createCriteria()
                .add(Restrictions.eq(Review.PROP_CONFIRMED, -1))
                .addOrder(Order.desc(Review.PROP_CREATION_DATE))
                .setFirstResult(start)
                .setMaxResults(len);
        return criteria.list();
    }

    public List<Review> getNewReviews(int start, int len) {
        Criteria criteria = this.createCriteria()
                .add(Restrictions.eq(Review.PROP_CONFIRMED, 0))
                .addOrder(Order.desc(Review.PROP_CREATION_DATE))
                .setFirstResult(start)
                .setMaxResults(len);
        return criteria.list();
    }

    @SuppressWarnings("unchecked")
    public List<Review> getAllByUser(User user, int start, int len) {
        return this.createCriteria()
                .add(Restrictions.eq(Review.PROP_DELETED, false))
                .add(Restrictions.eq(Review.PROP_USER, user))
                .addOrder(Order.desc(Review.PROP_CREATION_DATE))
                .setFirstResult(start)
                .setMaxResults(len).list();
    }

    public List<Review> getConfirmedByGisVectorObject(GISVectorObject gisVectorObject, int start, int len) {
        Criteria criteria = this.createCriteria()
                .add(Restrictions.eq(Review.PROP_DELETED, false))
                .add(Restrictions.eq(Review.PROP_GIS_VECTOR_OBJECT, gisVectorObject))
                .add(Restrictions.eq(Review.PROP_CONFIRMED, 1))
                .addOrder(Order.desc(Review.PROP_CREATION_DATE))
                .setFirstResult(start)
                .setMaxResults(len);
        return criteria.list();
    }

    public long getCountConfirmedByGisVectorObject(GISVectorObject gisVectorObject) {
        Criteria criteria = this.createCriteria()
                .add(Restrictions.eq(Review.PROP_DELETED, false))
                .add(Restrictions.eq(Review.PROP_GIS_VECTOR_OBJECT, gisVectorObject))
                .add(Restrictions.eq(Review.PROP_CONFIRMED, 1));
        return getRowCount(criteria);
    }

    public long getCountConfirmedByUser(User user) {
        Criteria criteria = this.createCriteria()
                .add(Restrictions.eq(Review.PROP_DELETED, false))
                .add(Restrictions.eq(Review.PROP_USER, user))
                .add(Restrictions.eq(Review.PROP_CONFIRMED, 1));
        return getRowCount(criteria);
    }

    public float getAvgConfirmedByGisVectorObject(GISVectorObject gisVectorObject) {
        Criteria criteria = createCriteria()
                .add(Restrictions.eq(Review.PROP_DELETED, false))
                .add(Restrictions.eq(Review.PROP_GIS_VECTOR_OBJECT, gisVectorObject))
                .add(Restrictions.eq(Review.PROP_CONFIRMED, 1))
                .setProjection(Projections.avg(Review.PROP_RATE));
        List result = criteria.list();
        if (result.get(0) != null)
            return ((Double) result.get(0)).floatValue();
        return 0;
    }

    @Override
    public void update(Review obj) {
        obj.setLastModifiedDate(new Date());
        super.update(obj);
    }

    public Long countConfirmed(User user) {
        return (Long) this.createCriteria()
                .add(Restrictions.eq(Review.PROP_USER, user))
                .add(Restrictions.eq(Review.PROP_CONFIRMED, 1))
                .add(Restrictions.eq(Review.PROP_DELETED, false))
                .setProjection(Projections.rowCount())
                .uniqueResult();
    }

    public Long countFromDate(Date fromDate) {
        return (Long) this.createCriteria()
                .add(Restrictions.ge(Review.PROP_CREATION_DATE, fromDate))
                .setProjection(Projections.rowCount())
                .uniqueResult();
    }

    public ListAndTotalCount<Review> pageList_waitingForConfirmation(int start, int len) {

        SimpleListAndTotalCount<Review> listAndTotalCount = new SimpleListAndTotalCount<>();

        Criteria countCriteria = createCriteria();
        countCriteria.add(Restrictions.eq(Review.PROP_CONFIRMED, 0));
        countCriteria.add(Restrictions.eq(Review.PROP_DELETED, false));

        long rowCount = getRowCount(countCriteria);

        Criteria fetchResultCriteria = createCriteria();
        fetchResultCriteria.add(Restrictions.eq(Review.PROP_CONFIRMED, 0));
        fetchResultCriteria.add(Restrictions.eq(Review.PROP_DELETED, false));
        fetchResultCriteria.setFirstResult(start);
        fetchResultCriteria.setMaxResults(len);
        fetchResultCriteria.addOrder(Order.asc(Review.PROP_CREATION_DATE));
        List<Review> objects = getList(fetchResultCriteria);


        listAndTotalCount.setTotalCount(rowCount);
        listAndTotalCount.setItems(objects);
        return listAndTotalCount;
    }

}