package ir.viratech.pond_ms.api.portal;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.wordnik.swagger.annotations.Api;

import ir.viratech.commons.api.service.AbstractJsonService;
import ir.viratech.pond_ms.api.RequestHandlingException;
import ir.viratech.pond_ms.api.portal.dto.PortalFullDTO;
import ir.viratech.pond_ms.api.portal.handler.AddPortalHandler;
import ir.viratech.pond_ms.api.portal.handler.DeletePortalHandler;
import ir.viratech.pond_ms.api.portal.handler.EditPortalHandler;
import ir.viratech.pond_ms.api.portal.handler.GetPortalDetailsHandler;
import ir.viratech.pond_ms.api.portal.handler.ListAllPortalsHandler;
import ir.viratech.pond_ms.core.features.FeatureNames;
import ir.viratech.pond_ms.model.user.authorization.AccessChecker;

@Api(value = "/portal", description = "Operations about portals")
@Path("/portal/items")
public class PortalService extends AbstractJsonService {

	/**
	 * @author Mohammad Javad Rafiei
	 * @param requestDto
	 *            contains map and organization
	 * @throws RequestHandlingException
	 *
	 */
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createNewPortal(PortalFullDTO requestDto) throws RequestHandlingException {
		if (!AccessChecker.hasAccessToAny(FeatureNames.ADD_PORTAL))
			return Response.status(Status.FORBIDDEN).build();
		return new AddPortalHandler(requestDto).handle();

	}

	/**
	 * @author Mohammad Javad Rafiei
	 * @throws RequestHandlingException
	 *
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listAllPortals(@QueryParam("start") Long start, @QueryParam("len") Integer len)
			throws RequestHandlingException {
		if (!AccessChecker.hasAccessToAny(FeatureNames.LIST_PORTAL))
			return Response.status(Status.FORBIDDEN).build();
		return new ListAllPortalsHandler(start, len).handle();
	}

	/**
	 * @author Mohammad Javad Rafiei
	 * @throws RequestHandlingException
	 *
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{org_uid}")
	public Response getPortalDetails(@PathParam("org_uid") String orgUid) throws RequestHandlingException {
		if (!AccessChecker.hasAccessToAny(FeatureNames.VIEW_PORTAL))
			return Response.status(Status.FORBIDDEN).build();
		return new GetPortalDetailsHandler(orgUid).handle();
	}

	/**
	 * @author Mohammad Sadegh Dabestani
	 * @throws RequestHandlingException
	 *
	 */
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{org_uid}")
	public Response editPortal(@PathParam("org_uid") String orgUid, PortalFullDTO requestDto)
			throws RequestHandlingException {
		if (!AccessChecker.hasAccessToAny(FeatureNames.EDIT_PORTAL))
			return Response.status(Status.FORBIDDEN).build();
		return new EditPortalHandler(requestDto, orgUid).handle();
	}

	/**
	 * @author Mohammad Sadegh Dabestani
	 * @throws RequestHandlingException
	 *
	 */
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{org_uid}")
	public Response deletePortal(@PathParam("org_uid") String orgUid) throws RequestHandlingException {
		if (!AccessChecker.hasAccessToAny(FeatureNames.DELETE_PORTAL))
			return Response.status(Status.FORBIDDEN).build();
		return new DeletePortalHandler(orgUid).handle();
	}
}
