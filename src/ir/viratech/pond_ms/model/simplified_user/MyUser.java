package ir.viratech.pond_ms.model.simplified_user;

import ir.viratech.pond_ms.model.simplified_user.base.AbstractMyUser;
import ir.viratech.pond_ms.model.simplified_user.base.BaseMyUserDAO;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by amir on 9/17/17.
 */
@Document(collection = BaseMyUserDAO.MY_USER_COLLECTION)
public class MyUser extends AbstractMyUser {

    @Indexed
    private String userUid;
    @Indexed
    private String authUserUid;
    private String firstName;
    private String lastName;
    @Indexed
    private String username;
    private Long numberOfReviews;
    private String avatar;
    private String phoneNumber;

    public String getUserUid() {
        return userUid;
    }

    public void setUserUid(String userUid) {
        this.userUid = userUid;
    }

    public String getAuthUserUid() {
        return authUserUid;
    }

    public void setAuthUserUid(String authUserUid) {
        this.authUserUid = authUserUid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getNumberOfReviews() {
        return numberOfReviews;
    }

    public void setNumberOfReviews(Long numberOfReviews) {
        this.numberOfReviews = numberOfReviews;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MyUser)) return false;

        MyUser myUser = (MyUser) o;

        return userUid != null ? userUid.equals(myUser.userUid) : myUser.userUid == null;
    }

    @Override
    public int hashCode() {
        return userUid != null ? userUid.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "MyUser{" +
                "userUid='" + userUid + '\'' +
                ", authUserUid='" + authUserUid + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", numberOfReviews=" + numberOfReviews +
                ", avatar='" + avatar + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
