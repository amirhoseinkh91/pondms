package ir.viratech.pond_ms.api.customer.dto;

import ir.viratech.commons.api.search.EntityByDtoFinder;
import ir.viratech.commons.api.search.EntityByDtoFinder_ByUid;
import ir.viratech.pond_ms.api.customer.base.BaseCustomerFavoriteGISVectorObjectFullDTO;
import ir.viratech.pond_ms.api.map_object.vector.dto.GISVectorObjectMapDTO;
import ir.viratech.pond_ms.model.map_object.vector.GISVectorObject;
import ir.viratech.pond_ms.model.map_object.vector.logic.GISVectorObjectMgr;


/**
 * A DTO for class Customer.
 *
 */
public class CustomerFavoriteGISVectorObjectFullDTO extends BaseCustomerFavoriteGISVectorObjectFullDTO {

	/**
	 * FieldInfoContext for CustomerFavoriteGISVectorObjectFullDTO
	 */
	public static class FieldInfoContext extends BaseCustomerFavoriteGISVectorObjectFullDTO.BaseFieldInfoContext {

		@Override
		protected EntityByDtoFinder<GISVectorObject, GISVectorObjectMapDTO> createEntityByDtoFinder_GisVectorObject() {
			return new EntityByDtoFinder_ByUid<GISVectorObject, GISVectorObjectMapDTO>(GISVectorObjectMgr.getInstance());
		}

	}

}
