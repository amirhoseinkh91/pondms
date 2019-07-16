package ir.viratech.pond_ms.model.simplified_user.base;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import ir.viratech.pond_ms.core.mongodb.dao.AbstractMongodbDAO;
import ir.viratech.pond_ms.core.spring.ApplicationContextUtil;
import ir.viratech.pond_ms.model.simplified_user.MyUser;
import ir.viratech.pond_ms.model.user.User;

/**
 * Created by amir on 9/17/17.
 */
public class BaseMyUserDAO extends AbstractMongodbDAO<MyUser> {

    public static final String MY_USER_COLLECTION = "myUser_col";

    @Override
    protected void add(MyUser myUser) {
        User user = ApplicationContextUtil.getCurrentExecutionContext().getUser();
        myUser.setId(new ObjectId());
        myUser.setAuthUserUid(user.getAuthUser().getExtuid());
        myUser.setUserUid(user.getExtuid());
        myUser.setUid(super.generateUid());
        myUser.setNumberOfReviews(new Long(0));
        myUser.setAvatar(user.getAvatar());
        myUser.setFirstName(user.getFirstName());
        myUser.setLastName(user.getLastName());
        myUser.setUsername(user.getUsername());
        myUser.setPhoneNumber(user.getAuthUser().getPhoneNumber());
        getMongoTemplate().insert(myUser);
    }

    @Override
    protected void update(MyUser myUser) {
        this.update(myUser.getUid() , myUser);
    }

    @Override
    protected void update(String uid, MyUser myUser) {
        MyUser oldMyUser = this.getByUid(uid);
        oldMyUser = myUser;
        getMongoTemplate().save(oldMyUser);
    }

    @Override
    protected void remove(String uid) {
        getMongoTemplate().remove(new Query(Criteria.where(MyUser.PROP_UID).is(uid)), MyUser.class);
    }

    @Override
    protected void remove(MyUser myUser) {
        this.remove(myUser.getUid());
    }

    @Override
    protected MyUser getByUid(String uid) {
        return getMongoTemplate().findOne(new Query(Criteria.where(MyUser.PROP_UID).is(uid)) , MyUser.class);
    }

    @Override
    protected List<MyUser> getAll() {
        return getMongoTemplate().findAll(MyUser.class);
    }

    @Override
    protected List<MyUser> getAll(Integer start, Integer len) {
        super.paginationConverter(start, len);
        return getMongoTemplate().find(new Query().skip(super.start).limit(super.length) , MyUser.class);
    }

    @Override
    public String getCollectionName() {
        return MY_USER_COLLECTION;
    }

    @Override
    protected Query roleHandler() {
        return null;
    }
}
