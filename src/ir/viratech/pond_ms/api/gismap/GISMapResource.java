package ir.viratech.pond_ms.api.gismap;

import javax.ws.rs.Path;

import org.springframework.stereotype.Component;

import ir.viratech.pond_ms.api.gismap.base.BaseGISMapResource;
import ir.viratech.pond_ms.api.gismap.dto.GISMapFullDTO;
import ir.viratech.pond_ms.api.gismap.dto.GISMapLightDTO;

/**
 *  This is a REST Resource class for entity "GISMap".
 *
 */
@Component
@Path(BaseGISMapResource.RESOURCE_PATH)
public class GISMapResource extends BaseGISMapResource {

	/**
	 * Default constructor.
	 * Also adds the extents.
	 */
	public GISMapResource() {
		super();
 		this.addFieldInfoContext("brief", GISMapLightDTO.FieldInfoContext.class);
 		this.addFieldInfoContext("full", GISMapFullDTO.FieldInfoContext.class);
	}

}
