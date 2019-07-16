package ir.viratech.pond_ms.api.layer;

import javax.ws.rs.Path;

import org.springframework.stereotype.Component;

import ir.viratech.pond_ms.api.layer.base.BasePondResource;
import ir.viratech.pond_ms.api.layer.dto.PondFullDTO;
import ir.viratech.pond_ms.api.layer.dto.PondLightDTO;
import ir.viratech.pond_ms.model.gismap.GISMap;
import ir.viratech.pond_ms.model.layer.Layer;
import ir.viratech.pond_ms.model.layer.Pond;

/**
 *  This is a REST Resource class for entity "Pond".
 *
 */
@Component
@Path(BasePondResource.RESOURCE_PATH)
public class PondResource extends BasePondResource {

	/**
	 * Default constructor.
	 * Also adds the extents.
	 */
	public PondResource() {
		super();
 		this.addFieldInfoContext("brief", PondLightDTO.FieldInfoContext.class);
 		this.addFieldInfoContext("full", PondFullDTO.FieldInfoContext.class);
	}
	
	@Override
	public String getPropertyKey() {
		return Pond.PROP_LAYER + "." + Layer.PROP_MAP + "." + GISMap.PROP_ORGANIZATION;
	}

}
