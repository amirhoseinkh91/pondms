package ir.viratech.pond_ms.api.portal.handler;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import ir.viratech.commons.api.ResponseException;
import ir.viratech.commons.api.dto.UI_MetadataDTO;
import ir.viratech.commons.api.dto.UI_MetadataDTO.MessageDTO.MessageType;
import ir.viratech.pond_ms.api.BaseServiceHandler;
import ir.viratech.pond_ms.api.RequestHandlingException;
import ir.viratech.pond_ms.model.gismap.GISMap;
import ir.viratech.pond_ms.model.gismap.logic.GISMapMgr;
import ir.viratech.pond_ms.model.organization.Organization;
import ir.viratech.pond_ms.model.organization.logic.OrganizationMgr;
import ir.viratech.pond_ms.model.user.User;
import ir.viratech.pond_ms.model.user.logic.UserMgr;

public class DeletePortalHandler extends BaseServiceHandler{

	private String orgUid;

	//TODO only users and map deleted! other dependent entities must be deleted later

	public DeletePortalHandler(String orgUid) {
		this.orgUid = orgUid;
	}

	@Override
	public Response handle() throws RequestHandlingException {
		validateRequest();

		Organization organization = OrganizationMgr.getInstance().getByExtuid(orgUid);
		GISMap gisMap = GISMapMgr.getInstance().getByOrganization(organization);
		List<User> users = new ArrayList<User>(organization.getUsers());
		for(User user : users){
			UserMgr.getInstance().delete(user);
		}
		GISMapMgr.getInstance().delete(gisMap);
		OrganizationMgr.getInstance().delete(organization);
		return Response.ok().build();
	}

	private void validateRequest(){

		if(orgUid == null || orgUid.isEmpty())
			throw ResponseException.create(Response.status(Status.BAD_REQUEST).entity(
					UI_MetadataDTO.createWith_i18n("portal.organization.extuid.null", MessageType.ERROR, getMessageTranslator()))
					.build());

		if(OrganizationMgr.getInstance().getByExtuid(orgUid) == null)
			throw ResponseException.create(Response.status(Status.BAD_REQUEST).entity(
					UI_MetadataDTO.createWith_i18n("portal.organization.null", MessageType.ERROR, getMessageTranslator()))
					.build());
	}
}
