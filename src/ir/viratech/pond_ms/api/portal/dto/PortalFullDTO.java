package ir.viratech.pond_ms.api.portal.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import ir.viratech.pond_ms.api.gismap.dto.GISMapFullDTO;
import ir.viratech.pond_ms.api.organization.dto.OrganizationFullDTO;
import ir.viratech.pond_ms.model.gismap.GISMap;
import ir.viratech.pond_ms.model.gismap.logic.GISMapMgr;
import ir.viratech.pond_ms.model.organization.Organization;

public class PortalFullDTO {

	@JsonProperty("map")
	private GISMapFullDTO map;

	@JsonProperty("organization")
	private OrganizationFullDTO organization;

	public GISMapFullDTO getMap() {
		return map;
	}

	public void setMap(GISMapFullDTO map) {
		this.map = map;
	}

	public OrganizationFullDTO getOrganization() {
		return organization;
	}

	public void setOrganization(OrganizationFullDTO organization) {
		this.organization = organization;
	}

	public void loadFrom(Organization organization) {
		GISMap map = GISMapMgr.getInstance().getByOrganization(organization);

		OrganizationFullDTO organizationFullDTO = new OrganizationFullDTO();
		organizationFullDTO.loadFrom(organization);

		GISMapFullDTO gisMapFullDTO = new GISMapFullDTO();
		gisMapFullDTO.loadFrom(map);

		setMap(gisMapFullDTO);
		setOrganization(organizationFullDTO);
	}

}
