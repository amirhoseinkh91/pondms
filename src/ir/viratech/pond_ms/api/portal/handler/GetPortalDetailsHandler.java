package ir.viratech.pond_ms.api.portal.handler;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import ir.viratech.commons.api.ResponseException;
import ir.viratech.commons.api.dto.UI_MetadataDTO;
import ir.viratech.commons.api.dto.UI_MetadataDTO.MessageDTO.MessageType;
import ir.viratech.pond_ms.api.BaseServiceHandler;
import ir.viratech.pond_ms.api.RequestHandlingException;
import ir.viratech.pond_ms.api.portal.dto.PortalFullDTO;
import ir.viratech.pond_ms.model.organization.Organization;
import ir.viratech.pond_ms.model.organization.logic.OrganizationMgr;

public class GetPortalDetailsHandler extends BaseServiceHandler {

	private String orgUid;

	public GetPortalDetailsHandler(String orgUid) {
		this.orgUid = orgUid;
	}

	@Override
	public Response handle() throws RequestHandlingException {
		if (orgUid == null)
			throw ResponseException.create(Response.status(Status.NOT_FOUND).entity(
					UI_MetadataDTO.createWith_i18n("organization.code.null", MessageType.ERROR, getMessageTranslator()))
					.build());
		PortalFullDTO dto = new PortalFullDTO();
		Organization org = OrganizationMgr.getInstance().getByExtuid(orgUid);
		if (org == null)
			throw ResponseException.create(Response.status(Status.NOT_FOUND).entity(
					UI_MetadataDTO.createWith_i18n("organization.code.not_found", MessageType.ERROR, getMessageTranslator()))
					.build());
		dto.loadFrom(org);
		return Response.ok().entity(dto).build();
	}

}
