package ir.viratech.mongo.model;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by amir on 9/11/17.
 */
public abstract class AbstractMongoEntity implements Serializable {

    public static final String PROP_UID = "uid";
    public static final String PROP_ID = "id";
    public static final String PROP_CREATION_DATE = "creationDate";
    public static final String PROP_CREATOR = "creator";
    public static final String PROP_TYPE = "__type";
    public static final String PROP_IS_ENABLED = "_isEnabled";
    public static final String PROP_IS_DELETED = "_isDeleted";
    public static final String UNKNOWN_FA = "نامشخص";

    public static final String METHOD_DELETED_SETTER_NAME = "setDeleted";
    public static final String METHOD_DELETED_GETTER_NAME = "isDeleted";

    public static final String METHOD_ENABLED_SETTER_NAME = "setEnabled";
    public static final String METHOD_ENABLED_GETTER_NAME = "isEnabled";

    @Id
    private ObjectId id;
    @Indexed
    private String uid;
    @Indexed
    private String creator;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date creationDate;

    private String __type;

    @Field("_isEnabled")
    private boolean isEnabled;

    @Field("_isDeleted")
    private boolean isDeleted;

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        if (creator != null)
            this.creator = creator;
        else
            this.creator = UNKNOWN_FA;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String get__type() {
        return __type;
    }

    @Required
    public void set__type(String __type) {
        this.__type = __type;
    }

    public abstract void init();
    protected abstract Class getRefClass();

    @Override
    public String toString() {
        return "AbstractMongoEntity{" +
                "id=" + id +
                ", uid='" + uid + '\'' +
                ", creator='" + creator + '\'' +
                ", creationDate=" + creationDate +
                ", __type='" + __type + '\'' +
                '}';
    }
}
