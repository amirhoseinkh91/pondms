package ir.viratech.pond_ms.api.portal.handler;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import ir.viratech.commons.api.ResponseException;
import ir.viratech.commons.api.dto.UI_MetadataDTO;
import ir.viratech.commons.api.dto.UI_MetadataDTO.MessageDTO.MessageType;
import ir.viratech.pond_ms.api.BaseServiceHandler;
import ir.viratech.pond_ms.api.RequestHandlingException;
import ir.viratech.pond_ms.api.gismap.dto.GISMapFullDTO;
import ir.viratech.pond_ms.api.organization.dto.OrganizationFullDTO;
import ir.viratech.pond_ms.api.portal.dto.PortalFullDTO;
import ir.viratech.pond_ms.model.gismap.GISMap;
import ir.viratech.pond_ms.model.gismap.base.BaseGISMapMgr;
import ir.viratech.pond_ms.model.gismap.logic.GISMapMgr;
import ir.viratech.pond_ms.model.organization.Organization;
import ir.viratech.pond_ms.model.organization.base.BaseOrganizationMgr;
import ir.viratech.pond_ms.model.organization.logic.OrganizationMgr;

public class EditPortalHandler extends BaseServiceHandler{

	private PortalFullDTO dto;
	private String orgUid;

	public EditPortalHandler(PortalFullDTO dto, String orgUid) {
		this.dto = dto;
		this.orgUid = orgUid;
	}

	@Override
	public Response handle() throws RequestHandlingException {
		validateRequest();

		Organization organization = OrganizationMgr.getInstance().getByExtuid(orgUid);
		dto.getOrganization().saveTo(organization);
		BaseOrganizationMgr.getInstance().update(organization);


		GISMap gisMap = GISMapMgr.getInstance().getByExtuid(dto.getMap().getUid());
		dto.getMap().saveTo(gisMap);
		BaseGISMapMgr.getInstance().update(gisMap);

		return Response.ok().entity(dto).build();
	}

	private void validateRequest(){

		GISMapFullDTO mapFullDTO = dto.getMap();
		OrganizationFullDTO organizationFullDTO = dto.getOrganization();

		if(orgUid == null || orgUid.isEmpty())
			throw ResponseException.create(Response.status(Status.BAD_REQUEST).entity(
					UI_MetadataDTO.createWith_i18n("portal.organization.extuid.null", MessageType.ERROR, getMessageTranslator()))
					.build());

		if(OrganizationMgr.getInstance().getByExtuid(orgUid) == null)
			throw ResponseException.create(Response.status(Status.BAD_REQUEST).entity(
					UI_MetadataDTO.createWith_i18n("portal.organization.null", MessageType.ERROR, getMessageTranslator()))
					.build());

		if(organizationFullDTO == null)
			throw ResponseException.create(Response.status(Status.BAD_REQUEST).entity(
					UI_MetadataDTO.createWith_i18n("portal.organization.null", MessageType.ERROR, getMessageTranslator()))
					.build());

		if (mapFullDTO == null)
			throw ResponseException.create(Response.status(Status.BAD_REQUEST).entity(
					UI_MetadataDTO.createWith_i18n("portal.map.null", MessageType.ERROR, getMessageTranslator()))
					.build());

		if (mapFullDTO.getUid() == null || mapFullDTO.getUid().isEmpty())
			throw ResponseException.create(Response.status(Status.BAD_REQUEST).entity(
					UI_MetadataDTO.createWith_i18n("portal.map.extuid.null", MessageType.ERROR, getMessageTranslator()))
					.build());

		if(GISMapMgr.getInstance().getByExtuid(mapFullDTO.getUid()) == null){
			throw ResponseException.create(Response.status(Status.BAD_REQUEST).entity(
					UI_MetadataDTO.createWith_i18n("portal.map.null", MessageType.ERROR, getMessageTranslator()))
					.build());
		}

		if (mapFullDTO.getMinZoom() < GISMap.MIN_ZOOM_AVAILABLE
				|| mapFullDTO.getMaxZoom() > GISMap.MAX_ZOOM_AVAILABLE
				|| mapFullDTO.getMinZoom() > mapFullDTO.getMaxZoom()
				|| mapFullDTO.getDefaultZoom() < mapFullDTO.getMinZoom()
				|| mapFullDTO.getDefaultZoom() > mapFullDTO.getMaxZoom())
			throw ResponseException.create(Response.status(Status.BAD_REQUEST).entity(
					UI_MetadataDTO.createWith_i18n("map.zoom.range", MessageType.ERROR, getMessageTranslator()))
					.build());

		if(mapFullDTO.getBoundingBox() == null){
			throw ResponseException.create(Response.status(Status.BAD_REQUEST).entity(
					UI_MetadataDTO.createWith_i18n("map.boundinBox.empty", MessageType.ERROR, getMessageTranslator()))
					.build());
		}

		if(mapFullDTO.getTitle() == null || mapFullDTO.getTitle().isEmpty()){
			throw ResponseException.create(Response.status(Status.BAD_REQUEST).entity(
					UI_MetadataDTO.createWith_i18n("map.title.empty", MessageType.ERROR, getMessageTranslator()))
					.build());
		}

		if(dto.getMap().getCenter() == null){
			throw ResponseException.create(Response.status(Status.BAD_REQUEST).entity(
					UI_MetadataDTO.createWith_i18n("map.center.empty", MessageType.ERROR, getMessageTranslator()))
					.build());
		}

		if(!dto.getMap().getCenter().getJtsGeometry().within(dto.getMap().getBoundingBox().getJtsGeometry())){
			throw ResponseException.create(Response.status(Status.BAD_REQUEST).entity(
					UI_MetadataDTO.createWith_i18n("map.center.out.of.range", MessageType.ERROR, getMessageTranslator()))
					.build());
		}

		if(organizationFullDTO.getName() == null || organizationFullDTO.getName().isEmpty()){
			throw ResponseException.create(Response.status(Status.BAD_REQUEST).entity(
					UI_MetadataDTO.createWith_i18n("organization.name.empty", MessageType.ERROR, getMessageTranslator()))
					.build());
		}

	}

}
