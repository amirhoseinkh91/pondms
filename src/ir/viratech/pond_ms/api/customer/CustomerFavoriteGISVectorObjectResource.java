package ir.viratech.pond_ms.api.customer;

import ir.viratech.pond_ms.api.customer.base.BaseCustomerFavoriteGISVectorObjectResource;
import ir.viratech.pond_ms.api.customer.dto.CustomerFavoriteGISVectorObjectFullDTO;

import javax.ws.rs.Path;

import org.springframework.stereotype.Component;

/**
 *  This is a REST Resource class for entity "CustomerFavoriteGISVectorObject".
 *
 */
@Component
@Path(BaseCustomerFavoriteGISVectorObjectResource.RESOURCE_PATH)
public class CustomerFavoriteGISVectorObjectResource extends BaseCustomerFavoriteGISVectorObjectResource {

	public CustomerFavoriteGISVectorObjectResource() {
		super();
		this.addFieldInfoContext("full", CustomerFavoriteGISVectorObjectFullDTO.FieldInfoContext.class);
	}

}
