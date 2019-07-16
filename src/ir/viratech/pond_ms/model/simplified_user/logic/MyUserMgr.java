package ir.viratech.pond_ms.model.simplified_user.logic;

import ir.viratech.pond_ms.model.simplified_user.MyUser;
import ir.viratech.pond_ms.model.simplified_user.base.BaseMyUserMgr;

/**
 * Created by amir on 9/17/17.
 */
public class MyUserMgr extends BaseMyUserMgr {

    public Long incrementNumberOfReviews(String myUserUid) {
        return this.getDAO().incrementNumberOfReviews(myUserUid);
    }

    public Long decrementNumberOfReviews(String myUserUid){
        return this.getDAO().decrementNumberOfReviews(myUserUid);
    }

}
