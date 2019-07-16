package ir.viratech.pond_ms.api.user.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ChangePasswordDTO {
	
	private String oldPassword;
	public String getOldPassword() {
		return oldPassword;
	}
	@JsonProperty
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}
	
	
	private String newPassword;
	public String getNewPassword() {
		return newPassword;
	}
	@JsonProperty
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
}
