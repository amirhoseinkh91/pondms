package ir.viratech.pond_ms.api.organization.dto;

import ir.viratech.commons.api.dto.SimpleUltraLightDTO;
import ir.viratech.commons.api.search.EntityByDtoFinder;
import ir.viratech.commons.api.search.EntityByDtoFinder_ByUid;
import ir.viratech.pond_ms.api.organization.base.BaseOrganizationFullDTO;
import ir.viratech.pond_ms.model.organization.Organization;
import ir.viratech.pond_ms.model.organization.logic.OrganizationMgr;


/**
 * A DTO for class Organization.
 *
 */
public class OrganizationFullDTO extends BaseOrganizationFullDTO {

	/**
	 * FieldInfoContext for OrganizationFullDTO
	 */
	public static class FieldInfoContext extends BaseOrganizationFullDTO.BaseFieldInfoContext {

		@Override
		protected EntityByDtoFinder<Organization, SimpleUltraLightDTO<Organization>> createEntityByDtoFinder_Parent() {
			return new EntityByDtoFinder_ByUid<Organization, SimpleUltraLightDTO<Organization>>(OrganizationMgr.getInstance()) ;
		}
	}

}
