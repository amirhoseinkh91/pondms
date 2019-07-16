package ir.viratech.pond_ms.model.simplified_user.base;

import ir.viratech.commons.spring.context.ApplicationContextProvider;
import ir.viratech.pond_ms.core.mongodb.logic.AbstractMongodbMgr;
import ir.viratech.pond_ms.model.simplified_user.MyUser;
import ir.viratech.pond_ms.model.simplified_user.dao.MyUserDAO;
import ir.viratech.pond_ms.model.simplified_user.logic.MyUserMgr;

import java.util.List;

/**
 * Created by amir on 9/17/17.
 */
public class BaseMyUserMgr extends AbstractMongodbMgr<MyUser> {

    public static MyUserMgr getInstance() {
        return (MyUserMgr) ApplicationContextProvider.getInitializedApplicationContext().getBean(MyUserMgr.class);
    }

    @Override
    public MyUser createNew() {
        return (MyUser) ApplicationContextProvider.getInitializedApplicationContext().getBean(MyUser.class);
    }

    @Override
    protected MyUserDAO getDAO() {
        return new MyUserDAO();
    }

    @Override
    public void save(MyUser myUser) {
        this.getDAO().add(myUser);
    }

    @Override
    public void update(MyUser myUser) {
        this.getDAO().update(myUser);
    }

    @Override
    public void update(MyUser myUser, String uid) {
        this.getDAO().update(uid, myUser);
    }

    @Override
    public void remove(MyUser myUser) {
        this.getDAO().remove(myUser);
    }

    @Override
    public void remove(String uid) {
        this.getDAO().remove(uid);
    }

    @Override
    public MyUser getByUid(String uid) {
        return this.getDAO().getByUid(uid);
    }

    @Override
    public List<MyUser> list() {
        return this.getDAO().getAll();
    }

    @Override
    public List<MyUser> list(Integer start, Integer len) {
        return this.getDAO().getAll(start, len);
    }

    public void addOrUpdate (MyUser myUser) {
        try {
            MyUser myUser1 = this.getDAO().getByUid(myUser.getUid());
            if (myUser1 != null)
                this.update(myUser);
            else
                this.save(myUser);
        } catch (NullPointerException e) {
            this.save(myUser);
        }
    }
}
