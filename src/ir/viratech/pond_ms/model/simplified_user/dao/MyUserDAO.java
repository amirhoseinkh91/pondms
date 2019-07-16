package ir.viratech.pond_ms.model.simplified_user.dao;

import ir.viratech.pond_ms.model.simplified_user.MyUser;
import ir.viratech.pond_ms.model.simplified_user.base.BaseMyUserDAO;

/**
 * Created by amir on 9/17/17.
 */
public class MyUserDAO extends BaseMyUserDAO {

    public Long incrementNumberOfReviews(String userUid) {
        MyUser user = super.getByUid(userUid);
        user.setNumberOfReviews(new Long(user.getNumberOfReviews() + 1));
        super.update(user);
        return user.getNumberOfReviews();
    }

    public Long decrementNumberOfReviews(String userUid) {
        MyUser user = super.getByUid(userUid);
        user.setNumberOfReviews(new Long(user.getNumberOfReviews() - 1));
        super.update(user);
        return user.getNumberOfReviews();
    }

}
