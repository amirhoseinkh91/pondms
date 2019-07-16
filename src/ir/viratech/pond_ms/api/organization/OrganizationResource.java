package ir.viratech.pond_ms.api.organization;

import java.util.List;

import javax.ws.rs.Path;

import org.springframework.stereotype.Component;

import ir.viratech.commons.model.EntityObjectNotFoundException;
import ir.viratech.commons.model.InvalidEntityModificationException;
import ir.viratech.pond_ms.api.organization.base.BaseOrganizationResource;
import ir.viratech.pond_ms.api.organization.dto.OrganizationFullDTO;
import ir.viratech.pond_ms.model.organization.Organization;
import ir.viratech.pond_ms.model.organization.logic.OrganizationMgr;

/**
 *  This is a REST Resource class for entity "Organization".
 *
 */
@Component
@Path(BaseOrganizationResource.RESOURCE_PATH)
public class OrganizationResource extends BaseOrganizationResource {

	public OrganizationResource() {
		super();
		this.addFieldInfoContext("full", OrganizationFullDTO.FieldInfoContext.class);
	}

	@Override
	public List<Organization> getRootChildren() {
		return OrganizationMgr.getInstance().getRootChildren();
	}

	@Override
	public void moveEntity(String childExtuid, String parentExtuid)
			throws InvalidEntityModificationException, EntityObjectNotFoundException {
		OrganizationMgr.getInstance().moveOrganization(childExtuid, parentExtuid);
	}


}
