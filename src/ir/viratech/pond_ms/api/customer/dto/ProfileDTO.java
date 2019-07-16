package ir.viratech.pond_ms.api.customer.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import ir.viratech.commons.api.dto.LoaderDTO;
import ir.viratech.pond_ms.model.customer.Customer;
import ir.viratech.pond_ms.model.review.logic.ReviewMgr;

public class ProfileDTO implements LoaderDTO<Customer>{

	private String name;
	@JsonProperty
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	private String email;
	@JsonProperty
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	private String phoneNo;
	@JsonProperty
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	private String biography;
	@JsonProperty
	public String getBiography() {
		return biography;
	}
	public void setBiography(String biography) {
		this.biography = biography;
	}

	private Long reviewCount;
	@JsonProperty
	public Long getReviewCount() {
		return reviewCount;
	}
	public void setReviewCount(Long reviewCount) {
		this.reviewCount = reviewCount;
	}


	private String gender;
	@JsonProperty
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

	private String age;
	@JsonProperty
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}

	private String firebaseId;
	public String getFirebaseId() {
		return firebaseId;
	}

	public void setFirebaseId(String firebaseId) {
		this.firebaseId = firebaseId;
	}

	private String locality;
	@JsonProperty
	public String getLocality() {
		return locality;
	}
	public void setLocality(String locality) {
		this.locality = locality;
	}

	private String avatarHash;
	@JsonProperty
	public String getAvatarHash() {
		return avatarHash;
	}
	public void setAvatarHash(String avatarHash) {
		this.avatarHash = avatarHash;
	}

	@Override
	public void loadFrom(Customer customer) {
		this.name = customer.getName();
		this.email = customer.getEmail();
		this.phoneNo = customer.getPhoneNumber();
		this.biography = customer.getBiography();
		this.reviewCount = ReviewMgr.getInstance().countConfirmed(customer.getUser());
		this.age = customer.getAge();
		this.gender = customer.getGender();
		this.locality = customer.getLocality();
		this.avatarHash = customer.getUser().getAvatar();
		this.firebaseId = customer.getUser().getFirebaseId();
	}

}
