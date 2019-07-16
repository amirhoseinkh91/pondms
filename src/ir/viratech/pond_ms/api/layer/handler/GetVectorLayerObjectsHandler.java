package ir.viratech.pond_ms.api.layer.handler;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import ir.viratech.commons.api.ResponseException;
import ir.viratech.commons.api.dto.PlainCollectionDTO;
import ir.viratech.commons.api.dto.UI_MetadataDTO;
import ir.viratech.commons.api.dto.UI_MetadataDTO.MessageDTO.MessageType;
import ir.viratech.commons.model.SimpleListAndTotalCount;
import ir.viratech.pond_ms.api.BaseServiceHandler;
import ir.viratech.pond_ms.api.RequestHandlingException;
import ir.viratech.pond_ms.api.layer.dto.VectorLayerObjectsTabularDTO;
import ir.viratech.pond_ms.api.map_object.vector.dto.GISVectorObjectMapDTO;
import ir.viratech.pond_ms.model.layer.VectorLayer;
import ir.viratech.pond_ms.model.layer.logic.VectorLayerMgr;
import ir.viratech.pond_ms.model.map_object.vector.GISVectorObject;
import ir.viratech.pond_ms.model.map_object.vector.logic.GISVectorObjectMgr;

public class GetVectorLayerObjectsHandler extends BaseServiceHandler{
	
	private String layerUid;
	private VectorLayer vectorLayer;
	private long start;
	private int len;
	
	public GetVectorLayerObjectsHandler(String Uid, long start, int len) {
		this.layerUid = Uid;
		this.start = start;
		this.len = len;
	}
	
		
	@Override
	public Response handle() throws RequestHandlingException {
		validateRequestAndFindLayer();
		List<GISVectorObjectMapDTO> gisVectorObjectMapDTOs = new ArrayList<GISVectorObjectMapDTO>();
		SimpleListAndTotalCount<GISVectorObject> result = GISVectorObjectMgr.getInstance().getLayerObjects(start,len,vectorLayer);
		gisVectorObjectMapDTOs = (List<GISVectorObjectMapDTO>) PlainCollectionDTO.createAndLoad(result.getItems(), GISVectorObjectMapDTO.class).getItems();
		VectorLayerObjectsTabularDTO tabularDTO = new VectorLayerObjectsTabularDTO();
		tabularDTO.setTotalCount(result.getTotalCount());
		tabularDTO.setList(gisVectorObjectMapDTOs);

		return Response.ok().entity(tabularDTO).build();
	}
	
	private void validateRequestAndFindLayer(){
		if(layerUid == null){
			throw ResponseException.create(Response.status(Status.BAD_REQUEST).entity(
					UI_MetadataDTO.createWith_i18n("vectorlayer.uid.null", MessageType.ERROR, getMessageTranslator()))
					.build());
		}
		this.vectorLayer = VectorLayerMgr.getInstance().getByExtuid(layerUid);
		if(vectorLayer == null){
			throw ResponseException.create(Response.status(Status.BAD_REQUEST).entity(
					UI_MetadataDTO.createWith_i18n("vectorlayer.not_found", MessageType.ERROR, getMessageTranslator()))
					.build());
		}
	}

}