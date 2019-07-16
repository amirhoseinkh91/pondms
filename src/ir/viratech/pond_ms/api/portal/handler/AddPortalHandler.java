package ir.viratech.pond_ms.api.portal.handler;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import ir.viratech.commons.api.ResponseException;
import ir.viratech.commons.api.dto.UI_MetadataDTO;
import ir.viratech.commons.api.dto.UI_MetadataDTO.MessageDTO.MessageType;
import ir.viratech.pond_ms.api.BaseServiceHandler;
import ir.viratech.pond_ms.api.RequestHandlingException;
import ir.viratech.pond_ms.api.portal.dto.PortalFullDTO;
import ir.viratech.pond_ms.model.gismap.GISMap;
import ir.viratech.pond_ms.model.gismap.dao.GISMapDAO;
import ir.viratech.pond_ms.model.gismap.logic.GISMapMgr;
import ir.viratech.pond_ms.model.organization.Organization;
import ir.viratech.pond_ms.model.organization.dao.OrganizationDAO;
import ir.viratech.pond_ms.model.organization.logic.OrganizationMgr;

public class AddPortalHandler extends BaseServiceHandler {

	private PortalFullDTO dto;

	public AddPortalHandler(PortalFullDTO dto) {
		this.dto = dto;
	}

	@Override
	//TODO should be Writetransactional
	public Response handle() throws RequestHandlingException {
		validateRequest();

		Organization org = OrganizationDAO.getInstance().createNew();
		dto.getOrganization().saveTo(org);
		OrganizationMgr.getInstance().add(org);

		GISMap map = GISMapDAO.getInstance().createNew();
		dto.getMap().saveTo(map);
		map.setOrganization(org);
		GISMapMgr.getInstance().add(map);


		dto.getMap().loadFrom(map);
		dto.getOrganization().loadFrom(org);

		return Response.ok().entity(dto).build();
	}

	private void validateRequest () {
		if (dto.getMap() == null)
			throw ResponseException.create(Response.status(Status.BAD_REQUEST).entity(
					UI_MetadataDTO.createWith_i18n("portal.map.null", MessageType.ERROR, getMessageTranslator()))
					.build());
		if (dto.getOrganization() == null)
			throw ResponseException.create(Response.status(Status.BAD_REQUEST).entity(
					UI_MetadataDTO.createWith_i18n("portal.organization.null", MessageType.ERROR, getMessageTranslator()))
					.build());

		if (dto.getMap().getMinZoom() < GISMap.MIN_ZOOM_AVAILABLE
				|| dto.getMap().getMaxZoom() > GISMap.MAX_ZOOM_AVAILABLE
				|| dto.getMap().getMinZoom() > dto.getMap().getMaxZoom()
				|| dto.getMap().getDefaultZoom() < dto.getMap().getMinZoom()
				|| dto.getMap().getDefaultZoom() > dto.getMap().getMaxZoom())
			throw ResponseException.create(Response.status(Status.BAD_REQUEST).entity(
					UI_MetadataDTO.createWith_i18n("map.zoom.range", MessageType.ERROR, getMessageTranslator()))
					.build());

		if(dto.getMap().getBoundingBox() == null){
			throw ResponseException.create(Response.status(Status.BAD_REQUEST).entity(
					UI_MetadataDTO.createWith_i18n("map.boundinBox.empty", MessageType.ERROR, getMessageTranslator()))
					.build());
		}

		if(dto.getMap().getTitle() == null || dto.getMap().getTitle().isEmpty()){
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


		if(dto.getOrganization().getName() == null || dto.getOrganization().getName().isEmpty()){
					throw ResponseException.create(Response.status(Status.BAD_REQUEST).entity(
							UI_MetadataDTO.createWith_i18n("organization.name.empty", MessageType.ERROR, getMessageTranslator()))
							.build());
		}

		if (OrganizationMgr.getInstance().getByCode(dto.getOrganization().getCode()) != null)
			throw ResponseException.create(Response.status(Status.BAD_REQUEST).entity(
					UI_MetadataDTO.createWith_i18n("organization.code.duplicate", MessageType.ERROR, getMessageTranslator()))
					.build());

	}

}
