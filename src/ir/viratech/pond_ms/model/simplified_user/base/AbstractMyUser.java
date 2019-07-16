package ir.viratech.pond_ms.model.simplified_user.base;

import ir.viratech.mongo.model.AbstractMongoEntity;
import ir.viratech.pond_ms.model.simplified_user.MyUser;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by amir on 9/17/17.
 */
public abstract class AbstractMyUser extends AbstractMongoEntity implements Serializable {

    public static final String PROP_USER_UID = "userUid";
    public static final String PROP_AUTHUSER_UID = "authUserUid";
    public static final String PROP_FIRST_NAME = "firstName";
    public static final String PROP_LAST_NAME = "lastName";
    public static final String PROP_USERNAME = "username";
    public static final String PROP_NUMBER_OF_REVIEWS = "numberOfReviews";
    public static final String PROP_AVATAR = "avatar";
    public static final String PROP_PHONE_NUMBER = "phoneNumber";

    @Override
    public void init() {
        this.setCreationDate(new Date());
    }

    @Override
    protected Class getRefClass() {
        return MyUser.class;
    }

}
