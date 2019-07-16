package ir.viratech.pond_ms.api.layer;

import javax.ws.rs.Path;

import ir.viratech.commons.api.service.search.SearchParameters;
import org.springframework.stereotype.Component;

import ir.viratech.commons.api.ResponseException;
import ir.viratech.pond_ms.api.layer.base.BaseLayerAnonymousResource;
import ir.viratech.pond_ms.api.layer.dto.LayerFullDTO;
import ir.viratech.pond_ms.api.layer.dto.LayerLightDTO;

/**
 *  This is a REST Resource class for entity "Layer".
 *
 */
@Component
@Path(BaseLayerAnonymousResource.RESOURCE_PATH)
public class LayerAnonymousResource extends BaseLayerAnonymousResource {
	
	public LayerAnonymousResource() {
		super();
 		this.addFieldInfoContext("brief", LayerLightDTO.FieldInfoContext.class);
 		this.addFieldInfoContext("full", LayerFullDTO.FieldInfoContext.class);
	}

	@Override
	public Object add(LayerFullDTO fullDto) {
		throw ResponseException.createWithStatus_Forbidden("can not add layer out of organization");
	}
	
	@Override
	public Object edit(String uid, LayerFullDTO fullDto) {
		throw ResponseException.createWithStatus_Forbidden("can not edit layer out of organization");		
	}
	
	@Override
	public Object delete(String uid) {
		throw ResponseException.createWithStatus_Forbidden("can not delete layer out of organization");		
	}

}
