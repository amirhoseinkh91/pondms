package ir.viratech.pond_ms.api.portal.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import ir.viratech.pond_ms.model.organization.Organization;

public class PortalOverviewDTO {

	@JsonProperty("title")
	private String title;

	@JsonProperty("sub_domain")
	private String subDomin;

	@JsonProperty("uid")
	private String organizationUID;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubDomin() {
		return subDomin;
	}

	public void setSubDomin(String subDomin) {
		this.subDomin = subDomin;
	}

	public String getOrganizationUID() {
		return organizationUID;
	}

	public void setOrganizationUID(String organizationUID) {
		this.organizationUID = organizationUID;
	}

	public void load (Organization organization) {
		setSubDomin(organization.getCode());
		setTitle(organization.getName());
		setOrganizationUID(organization.getExtuid());
	}

}
