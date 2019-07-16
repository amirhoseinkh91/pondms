package ir.viratech.pond_ms.model.customer;

import ir.viratech.commons.model.UIDAndDisplayStringProvider;
import ir.viratech.pond_ms.model.customer.base.BaseCustomerFavoriteGISVectorObject;

/**
 * The entity class "CustomerFavoriteGISVectorObject".
 */

public class CustomerFavoriteGISVectorObject extends BaseCustomerFavoriteGISVectorObject implements UIDAndDisplayStringProvider, CustomerBasedProvider{
	private static final long serialVersionUID = 1L;

	@Override
	public String getDisplayString() {
		return getGisVectorObject().getName();
	}





}