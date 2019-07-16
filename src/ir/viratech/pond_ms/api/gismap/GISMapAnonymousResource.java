package ir.viratech.pond_ms.api.gismap;

import javax.ws.rs.Path;

import org.springframework.stereotype.Component;

import ir.viratech.commons.api.ResponseException;
import ir.viratech.pond_ms.api.gismap.base.BaseGISMapAnonymousResource;
import ir.viratech.pond_ms.api.gismap.dto.GISMapFullDTO;
import ir.viratech.pond_ms.api.gismap.dto.GISMapLightDTO;

/**
 * This is a REST Resource class for entity "GISMap".
 *
 */
@Component
@Path(BaseGISMapAnonymousResource.RESOURCE_PATH)
public class GISMapAnonymousResource extends BaseGISMapAnonymousResource {
	
	public GISMapAnonymousResource() {
		super();
 		this.addFieldInfoContext("brief", GISMapLightDTO.FieldInfoContext.class);
 		this.addFieldInfoContext("full", GISMapFullDTO.FieldInfoContext.class);
	}

	@Override
	public Object add(GISMapFullDTO fullDto) {
		throw ResponseException.createWithStatus_Forbidden("can not add gismap out of organization");
	}
	
	@Override
	public Object edit(String uid, GISMapFullDTO fullDto) {
		throw ResponseException.createWithStatus_Forbidden("can not edit gismap out of organization");
	}
	
	@Override
	public Object delete(String uid) {
		throw ResponseException.createWithStatus_Forbidden("can not delete gismap out of organization");
	}
}
