package ir.viratech.pond_ms.api.layer.handler;

import java.util.ArrayList;
import java.util.Collection;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import ir.viratech.commons.api.ResponseException;
import ir.viratech.commons.api.dto.PlainCollectionDTO;
import ir.viratech.commons.api.dto.UI_MetadataDTO;
import ir.viratech.commons.api.dto.UI_MetadataDTO.MessageDTO.MessageType;
import ir.viratech.pond_ms.api.BaseServiceHandler;
import ir.viratech.pond_ms.api.RequestHandlingException;
import ir.viratech.pond_ms.api.layer.dto.DataFileDTO;
import ir.viratech.pond_ms.model.file.DataFile;
import ir.viratech.pond_ms.model.layer.LeafLayer;

public class GetLayerDataFilesHandler extends BaseServiceHandler{

	private LeafLayer layer;
	
	public LeafLayer getLayer() {
		return layer;
	}
	
	public GetLayerDataFilesHandler(LeafLayer layer) {
		this.layer = layer;
	}
	
	
	@Override
	public Response handle() throws RequestHandlingException {
		if (this.layer == null)
			throw ResponseException.create(Response.status(Status.NOT_FOUND).entity(
					UI_MetadataDTO.createWith_i18n("layer.not_found", MessageType.ERROR, getMessageTranslator()))
					.build());
		Collection<DataFileDTO> dtos = new ArrayList<>();
		for (DataFile file: this.layer.getDataFiles()) {
			DataFileDTO dto = new DataFileDTO();
			dto.loadFrom(file);
			dtos.add(dto);
		}
		PlainCollectionDTO<DataFile, DataFileDTO> resultDTO = 
				new PlainCollectionDTO<>(dtos);
		return Response.ok().entity(resultDTO).build();
	}

}
