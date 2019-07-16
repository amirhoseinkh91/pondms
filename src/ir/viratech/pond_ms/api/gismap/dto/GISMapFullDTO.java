package ir.viratech.pond_ms.api.gismap.dto;

import java.util.Collection;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import ir.viratech.commons.api.ResponseException;
import ir.viratech.commons.api.dto.PlainCollectionDTO;
import ir.viratech.commons.api.dto.UI_MetadataDTO;
import ir.viratech.commons.api.dto.UI_MetadataDTO.MessageDTO.MessageType;
import ir.viratech.commons.api.entity_modifier.BadDtoEntityModificationException;
import ir.viratech.commons.api.search.EntityByDtoFinder;
import ir.viratech.commons.api.search.EntityByDtoFinder_ByUid;
import ir.viratech.commons.api.search.InvalidDtoException;
import ir.viratech.commons.util.i18n.MessageTranslator;
import ir.viratech.pond_ms.api.gismap.base.BaseGISMapFullDTO;
import ir.viratech.pond_ms.api.layer.dto.LayerLightDTO;
import ir.viratech.pond_ms.api.organization.dto.OrganizationFullDTO;
import ir.viratech.pond_ms.commons.geo.Point;
import ir.viratech.pond_ms.core.i18n.MessageService;
import ir.viratech.pond_ms.model.gismap.GISMap;
import ir.viratech.pond_ms.model.layer.Layer;
import ir.viratech.pond_ms.model.layer.logic.LayerMgr;
import ir.viratech.pond_ms.model.organization.Organization;
import ir.viratech.pond_ms.model.organization.logic.OrganizationMgr;


/**
 * A DTO for class GISMap.
 *
 */
public class GISMapFullDTO extends BaseGISMapFullDTO {

	/**
	 * FieldInfoContext for GISMapFullDTO
	 */
	public static class FieldInfoContext extends BaseGISMapFullDTO.BaseFieldInfoContext {

		@Override
		protected EntityByDtoFinder<Organization, OrganizationFullDTO> createEntityByDtoFinder_Organization() {
			return new EntityByDtoFinder_ByUid<Organization, OrganizationFullDTO>(OrganizationMgr.getInstance());
		}

	}


	@Override
	protected ir.viratech.pond_ms.commons.geo.Polygon load_BoundingBox(GISMap gISMap) {
		return new ir.viratech.pond_ms.commons.geo.Polygon(gISMap.getBoundingBox());
	}

	@Override
	protected void save_BoundingBox(GISMap gISMap, ir.viratech.pond_ms.commons.geo.Polygon boundingBox)
			throws ResponseException {
		MessageTranslator messageTranslator = MessageService.getMessageTranslator();
		if(boundingBox == null || gISMap == null){
			throw new ResponseException(Response.status(Status.NOT_ACCEPTABLE).entity(
					UI_MetadataDTO.createWith_i18n("INVALID_BOUNDINGBOX_DATA",
							MessageType.ERROR,messageTranslator)).build());
		}
		else{
			gISMap.setBoundingBox(boundingBox.getJtsGeometry());
		}

	}

	@Override
	protected int load_ChildCount(GISMap gISMap) {
		return gISMap.getLayers().size();
	}

	@Override
	protected Point load_Center(GISMap gISMap) {
		return new ir.viratech.pond_ms.commons.geo.Point(gISMap.getCenter());
	}

	@Override
	protected void save_Center(GISMap gISMap, Point center) throws BadDtoEntityModificationException {
		MessageTranslator messageTranslator = MessageService.getMessageTranslator();
		if(center == null || gISMap == null){
			throw new ResponseException(Response.status(Status.NOT_ACCEPTABLE).entity(
					UI_MetadataDTO.createWith_i18n("INVALID_CENTER_DATA",
							MessageType.ERROR,messageTranslator)).build());
		}
		else{
			gISMap.setCenter(center.getJtsGeometry());
		}

	}

	@Override
	protected PlainCollectionDTO<Layer, LayerLightDTO> load_SubLayers(GISMap gISMap) {
		return PlainCollectionDTO.createAndLoad(gISMap.getLayers(), LayerLightDTO.class);
	}

	@Override
	protected void save_SubLayers(GISMap gISMap, PlainCollectionDTO<Layer, LayerLightDTO> subLayers)
			throws BadDtoEntityModificationException {
		try {
			if (gISMap.getLayers() != null)
				gISMap.getLayers().clear();
			Collection<Layer> items = PlainCollectionDTO.getEntities(subLayers, LayerMgr.getInstance());
			gISMap.getCreatedLayers().addAll(items);
		} catch (InvalidDtoException e) {
			new BadDtoEntityModificationException();
		}

	}


}
