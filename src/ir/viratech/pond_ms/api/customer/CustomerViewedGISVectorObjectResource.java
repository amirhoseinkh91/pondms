package ir.viratech.pond_ms.api.customer;

import ir.viratech.commons.api.ResponseException;
import ir.viratech.pond_ms.api.customer.base.BaseCustomerViewedGISVectorObjectResource;
import ir.viratech.pond_ms.api.customer.dto.CustomerViewedGISVectorObjectFullDTO;

import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.stereotype.Component;

/**
 *  This is a REST Resource class for entity "CustomerViewedGISVectorObject".
 *
 */
@Component
@Path(BaseCustomerViewedGISVectorObjectResource.RESOURCE_PATH)
public class CustomerViewedGISVectorObjectResource extends BaseCustomerViewedGISVectorObjectResource {

	public CustomerViewedGISVectorObjectResource() {
			super();
			this.addFieldInfoContext("full", CustomerViewedGISVectorObjectFullDTO.FieldInfoContext.class);
	}

	@Override
	public Object add(CustomerViewedGISVectorObjectFullDTO customerViewedGISVectorObjectFullDTO) {
		throw new ResponseException(Response.status(Status.METHOD_NOT_ALLOWED).build());
	}
}
