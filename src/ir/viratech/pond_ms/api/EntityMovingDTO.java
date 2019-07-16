package ir.viratech.pond_ms.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EntityMovingDTO {
	
	private String childUid;
	public String getChildUid() {
		return childUid;
	}
	@JsonProperty
	public void setChildUid(String childUid) {
		this.childUid = childUid;
	}
	
	private String parentUid;
	public String getParentUid() {
		return parentUid;
	}
	@JsonProperty
	public void setParentUid(String parentUid) {
		this.parentUid = parentUid;
	}
}
