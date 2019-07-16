package ir.viratech.pond_ms.api.organization;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

import ir.viratech.commons.api.dto.PlainCollectionDTO;
import ir.viratech.commons.api.dto.SimpleUltraLightDTO;
import ir.viratech.commons.api.service.AbstractJsonService;
import ir.viratech.pond_ms.core.spring.ApplicationContextUtil;
import ir.viratech.pond_ms.model.organization.Organization;

@Path("/organization")
@Api(value = "/organization", description = "Organization services")
public class OrganizarionServices extends AbstractJsonService{

	@GET
	@Path("availables")
	@ApiOperation("Return available organizations")
	@ApiResponses({ @ApiResponse(code = 200, message = "OK, with some response content"),
			@ApiResponse(code = 204, message = "OK, with no response content"),
			@ApiResponse(code = 400, message = "Bad Request, for bad information sent to server"),
			@ApiResponse(code = 403, message = "Forbidden, for accessing something not allowed"),
			@ApiResponse(code = 404, message = "Not Found, for referring something which does not exist"),
			@ApiResponse(code = 500, message = "Internal server error") })
	public PlainCollectionDTO<Organization, SimpleUltraLightDTO<Organization>> getAvalableOrganizations() {
		List<Organization> list = ApplicationContextUtil.getCurrentExecutionContext().getUser().getAvailableOrganizations();
		return PlainCollectionDTO.createAndLoad(list, SimpleUltraLightDTO.<Organization>getGenericClass());
	}
}
