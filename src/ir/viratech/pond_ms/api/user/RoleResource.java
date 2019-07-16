package ir.viratech.pond_ms.api.user;

import javax.ws.rs.Path;

import org.springframework.stereotype.Component;

import ir.viratech.pond_ms.api.user.base.BaseRoleResource;
import ir.viratech.pond_ms.api.user.dto.UserRoleFullDTO;
import ir.viratech.pond_ms.api.user.dto.UserRoleLightDTO;

/**
 *  This is a REST Resource class for entity "UserRole".
 *
 */
@Component
@Path(BaseRoleResource.RESOURCE_PATH)
public class RoleResource extends BaseRoleResource {
	/**
	 * Instantiates a new user role resource.
	 * Also add brief and full FieldInfoContexts.
	 */
	public RoleResource() {
		super();
		this.addFieldInfoContext("brief", UserRoleLightDTO.FieldInfoContext.class);
		this.addFieldInfoContext("full", UserRoleFullDTO.FieldInfoContext.class);
	}


}
