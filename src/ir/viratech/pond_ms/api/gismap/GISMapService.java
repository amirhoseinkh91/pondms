package ir.viratech.pond_ms.api.gismap;

import java.net.URI;
import java.net.URISyntaxException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.wordnik.swagger.annotations.ApiOperation;

import ir.viratech.commons.api.service.AbstractJsonService;
import ir.viratech.pond_ms.core.spring.ApplicationContextUtil;
import ir.viratech.pond_ms.model.user.User;

@Path("gis-map")
public class GISMapService extends AbstractJsonService {
	@Context
	UriInfo uriInfo;

	@GET
	@Path("/availables")
	@ApiOperation(value = "get available maps for user")
	public Response getInfo(@QueryParam("extent") String extent) throws URISyntaxException {
		URI baseUri = uriInfo.getBaseUri();
		User currentUser = ApplicationContextUtil.getCurrentExecutionContext().getUser();
		//TODO read URI documentation and use query parameter in better way
		if (currentUser == null || currentUser.getOrganization() == null) {
			return Response.temporaryRedirect(new URI(baseUri + GISMapAnonymousResource.RESOURCE_PATH_BASE + "?extent=" + extent)).build();
		} else {
			return Response.temporaryRedirect(new URI(baseUri + "org/" + currentUser.getOrganization().getExtuid() + GISMapAnonymousResource.RESOURCE_PATH_BASE + "?extent=" + extent)).build();
		}
	}
}
