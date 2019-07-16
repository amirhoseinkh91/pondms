package ir.viratech.pond_ms.api.gradient;

import javax.ws.rs.Path;

import org.springframework.stereotype.Component;

import ir.viratech.pond_ms.api.gradient.base.BaseGradientResource;
import ir.viratech.pond_ms.api.gradient.dto.GradientFullDTO;
import ir.viratech.pond_ms.api.gradient.dto.GradientLightDTO;

/**
 *  This is a REST Resource class for entity "Gradient".
 *
 */
@Component
@Path(BaseGradientResource.RESOURCE_PATH)
public class GradientResource extends BaseGradientResource {

	/**
	 * Default constructor.
	 * Also adds the extents.
	 */
	public GradientResource() {
		super();
 		this.addFieldInfoContext("brief", GradientLightDTO.FieldInfoContext.class);
 		this.addFieldInfoContext("full", GradientFullDTO.FieldInfoContext.class);
	}


}
