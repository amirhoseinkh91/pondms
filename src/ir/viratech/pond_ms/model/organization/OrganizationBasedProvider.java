package ir.viratech.pond_ms.model.organization;

import ir.viratech.commons.model.UIDAndDisplayStringProvider;

public interface OrganizationBasedProvider extends UIDAndDisplayStringProvider {
	public Organization getOrganization();
	public void setOrganization(Organization organization);

}