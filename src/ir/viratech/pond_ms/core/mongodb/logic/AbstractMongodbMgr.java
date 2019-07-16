package ir.viratech.pond_ms.core.mongodb.logic;

import ir.viratech.pond_ms.core.mongodb.dao.AbstractMongodbDAO;

import java.util.List;

/**
 * Created by amir on 9/10/17.
 */
public abstract class AbstractMongodbMgr<T> {

    public abstract T createNew();

    protected abstract AbstractMongodbDAO<T> getDAO();

    public abstract void save(T t);

    public abstract void update(T t);

    public abstract void update(T t, String uid);

    public abstract void remove(T t);

    public abstract void remove(String uid);

    public abstract T getByUid(String uid);

    public abstract List<T> list();

    public abstract List<T> list(Integer start, Integer len);

}
