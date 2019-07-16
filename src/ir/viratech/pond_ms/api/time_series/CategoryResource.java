package ir.viratech.pond_ms.api.time_series;

import ir.viratech.pond_ms.api.time_series.base.BaseCategoryResource;
import ir.viratech.pond_ms.api.time_series.dto.CategoryFullDTO;
import ir.viratech.pond_ms.api.time_series.dto.CategoryLightDTO;

import javax.ws.rs.Path;

import org.springframework.stereotype.Component;

/**
 *  This is a REST Resource class for entity "Category".
 *
 */
@Component
@Path(BaseCategoryResource.RESOURCE_PATH)
public class CategoryResource extends BaseCategoryResource {


	public CategoryResource () {
		super();
 		this.addFieldInfoContext("brief", CategoryLightDTO.FieldInfoContext.class);
 		this.addFieldInfoContext("full", CategoryFullDTO.FieldInfoContext.class);
 	}
}
