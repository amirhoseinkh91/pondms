package ir.viratech.pond_ms.api.map_object.vector;

import javax.ws.rs.Path;

import org.springframework.stereotype.Component;

import ir.viratech.commons.api.ResponseException;
import ir.viratech.pond_ms.api.map_object.vector.base.BaseGISVectorObjectAnonymousResource;
import ir.viratech.pond_ms.api.map_object.vector.dto.GISVectorObjectFullDTO;
import ir.viratech.pond_ms.api.map_object.vector.dto.GISVectorObjectLightDTO;
import ir.viratech.pond_ms.core.spring.ApplicationContextUtil;
import ir.viratech.pond_ms.model.customer.CurrentUserIsNotCustomerException;
import ir.viratech.pond_ms.model.customer.Customer;
import ir.viratech.pond_ms.model.customer.logic.CustomerViewedGISVectorObjectMgr;
import ir.viratech.pond_ms.model.map_object.vector.GISVectorObject;

/**
 *  This is a REST Resource class for entity "GISVectorObject".
 *
 */
@Component
@Path(BaseGISVectorObjectAnonymousResource.RESOURCE_PATH)
public class GISVectorObjectAnonymousResource extends BaseGISVectorObjectAnonymousResource {

	public GISVectorObjectAnonymousResource() {
		this.addFieldInfoContext("brief", GISVectorObjectLightDTO.FieldInfoContext.class);
		this.addFieldInfoContext("full", GISVectorObjectFullDTO.FieldInfoContext.class);
	}

	@Override
	public Object add(GISVectorObjectFullDTO fullDto) {
		throw ResponseException.createWithStatus_Forbidden("can not add vector object out of organization");
	}

	@Override
	public Object edit(String uid, GISVectorObjectFullDTO fullDto) {
		throw ResponseException.createWithStatus_Forbidden("can not edit vector object out of organization");
	}

	@Override
	public Object delete(String uid) {
		throw ResponseException.createWithStatus_Forbidden("can not delete vector object out of organization");
	}

	@Override
	protected GISVectorObject getByUid(String uid) {
		GISVectorObject gisVectorObject = super.getByUid(uid);
		Customer customer;
		try {
			customer = ApplicationContextUtil.getCurrentExecutionContext().getCustomer();
			CustomerViewedGISVectorObjectMgr.getInstance().add(customer, gisVectorObject);
		} catch (CurrentUserIsNotCustomerException e) {
			//User is not customer, no problem, ignoring
		}
		return gisVectorObject;
	}

}
