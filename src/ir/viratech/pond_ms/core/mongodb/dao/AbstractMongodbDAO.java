package ir.viratech.pond_ms.core.mongodb.dao;

import java.util.List;
import java.util.Set;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

import com.mongodb.DBCollection;

import ir.viratech.commons.persistence.mongo.base.MongoDBManager;
import ir.viratech.pond_ms.core.spring.ApplicationContextUtil;
import ir.viratech.pond_ms.model.map_object.vector.dao.GISVectorObjectDAO;
import ir.viratech.pond_ms.model.user.role.UserRole;

/**
 * Created by amir on 9/10/17.
 */
public abstract class AbstractMongodbDAO<T> {

    protected boolean isNormUser;
    protected boolean isProUser;
    protected boolean isMobileAdmin;
    protected boolean isSysadmin;
    protected boolean isAgency;

    protected int start;
    protected int length;

    protected static final int MAX_LENGTH = 50;
    protected static final int MIN_LENGTH = 0;
    protected static final int MIN_START = 0;
    protected static final int ALL_DATA = -1;

    protected final void paginationConverter() {
        paginationConverter(null , null);
    }

    protected final void paginationConverter(Integer start, Integer len) {
        try {
            if (start < MIN_START)
                this.start = MIN_START;
            else
                this.start = start;
        } catch (Exception e) {
            this.start = MIN_START;
        }

        try {
            if (len <= MAX_LENGTH && len >= MIN_LENGTH)
                this.length = len;
            else
                this.length = MAX_LENGTH;
        } catch (Exception e) {
            this.length = MAX_LENGTH;
        }
    }

    public String generateUid() {
        return GISVectorObjectDAO.getInstance().generateUid();
    }

    protected MongoDBManager mongoDBManager;

    public AbstractMongodbDAO() {
        init();
    }

    public void init() {
        mongoDBManager = MongoDBManager.getInstance();
    }

    protected abstract void add(T t);

    protected abstract void update(T t);

    protected abstract void update(String uid , T t);

    protected abstract void remove(String uid);

    protected abstract void remove(T t);

    protected abstract T getByUid(String uid);

    protected abstract List<T> getAll();

    protected abstract List<T> getAll(Integer start, Integer len);

    public abstract String getCollectionName();

    protected DBCollection getCollection(String collectionName) {
        return mongoDBManager.getCollection(collectionName);
    }

    protected final MongoTemplate getMongoTemplate() {
        return new MongoTemplate(mongoDBManager.mongoClient, mongoDBManager.getDbName());
    }

    protected Query roleHandler() {
        try {
            Set<UserRole> roles = ApplicationContextUtil.getCurrentExecutionContext().getUser().getRoles();
            for (UserRole role: roles) {
                if (role.getName().equals(UserRole.NORM_USER_ROLE))
                    isNormUser = true;
                if (role.getName().equals(UserRole.PRO_USER_ROLE))
                    isProUser = true;
                if (role.getName().equals(UserRole.MOBILE_ADMIN_ROLE))
                    isMobileAdmin = true;
                if (role.getName().equals("sysadmin"))
                    isSysadmin = true;
                if (role.getName().equalsIgnoreCase(UserRole.AGENCY_ROLE))
                    isAgency = true;
            }

        } catch (NullPointerException e) {

        }
        return new Query();
    }

    protected Sort sort(Sort.Direction direction , String field) {
        return new Sort(new Sort.Order(direction, field));
    }

}
