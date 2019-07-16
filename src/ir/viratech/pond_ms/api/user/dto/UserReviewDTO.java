package ir.viratech.pond_ms.api.user.dto;
import com.fasterxml.jackson.annotation.JsonProperty;

import ir.viratech.commons.api.dto.LoaderDTO;
import ir.viratech.commons.api.dto.UidProviderDTO;
import ir.viratech.pond_ms.model.review.logic.ReviewMgr;
import ir.viratech.pond_ms.model.user.User;
public class UserReviewDTO implements LoaderDTO<User>, UidProviderDTO {
    private String uid;
    private String username;
    private String firstName;
    private String lastName;
    private String avatar;
    private long reviewsCount;
    @Override
    public void loadFrom(User user) {
        setUid(user.getExtuid());
        setAvatar(user.getAvatar());
        setFirstName(user.getFirstName());
        setLastName(user.getLastName());
        if(user.getCustomer()!= null)
        	setUsername(user.getCustomer().getName());
        else
        	setUsername(user.getUsername());
        long count = ReviewMgr.getInstance().getCountConfirmedByUser(user);
        setReviewsCount(count);
    }
    @JsonProperty
    public String getUid() {
        return uid;
    }
    public void setUid(String uid) {
        this.uid = uid;
    }
    @JsonProperty
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    @JsonProperty
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    @JsonProperty
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    @JsonProperty
    public String getAvatar() {
        return avatar;
    }
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
    @JsonProperty
    public long getReviewsCount() {
        return reviewsCount;
    }
    public void setReviewsCount(long reviewsCount) {
        this.reviewsCount = reviewsCount;
    }
}