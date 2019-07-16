package ir.viratech.pond_ms.api.user;

import ir.viratech.pond_ms.api.user.base.BaseUserResource;
import ir.viratech.pond_ms.api.user.dto.UserFullDTO;

import javax.ws.rs.Path;

import org.springframework.stereotype.Component;

/**
 *  This is a REST Resource class for entity "User".
 *
 */
@Component
@Path(BaseUserResource.RESOURCE_PATH)
public class UserResource extends BaseUserResource {

	public UserResource() {
		this.addFieldInfoContext("full", UserFullDTO.FieldInfoContext.class);
	}
}
