package ir.viratech.pond_ms.api.customer.base;

import com.wordnik.swagger.annotations.Api;

import ir.viratech.pond_ms.model.customer.CustomerFavoriteGISVectorObject;

/**
 *  Base class for "CustomerFavoriteGISVectorObjectResource".
 *  It is an automatically generated file and should not be edited.
 */
@Api(value = BaseCustomerFavoriteGISVectorObjectResource.RESOURCE_PATH_BASE, description = BaseCustomerFavoriteGISVectorObjectResource.RESOURCE_DESCRIPTION)
public abstract class BaseCustomerFavoriteGISVectorObjectResource extends ir.viratech.pond_ms.api.customer.AbstractCustomerBasedMgrBasedResource<CustomerFavoriteGISVectorObject,ir.viratech.pond_ms.api.customer.dto.CustomerFavoriteGISVectorObjectFullDTO> {
	
	/**
	 * The resource path base used in swagger.
	 */
	public static final String RESOURCE_PATH_BASE = "/cu/v1/favoritegisvectorobject"+"/"+PATH_PART_ITEMS;
	
	/**
	 * The resource description used in swagger.
	 */
	public static final String RESOURCE_DESCRIPTION = "CustomerFavoriteGISVectorObject Resource";
	
	/**
	 * The path which is handled by this resource/
	 */
	public static final String RESOURCE_PATH = "/cu/v1/favoritegisvectorobject"+PATH_PARAM_PART__ITEMS;
	
	/**
	 * Provides the entity manager used by the resource.
	 * @return an instance of the required entity manager
	 */
	@Override
	protected ir.viratech.commons.model.BasicEntityMgr<CustomerFavoriteGISVectorObject> getMgr() {
		return ir.viratech.pond_ms.model.customer.logic.CustomerFavoriteGISVectorObjectMgr.getInstance();
	}

	/**
	 * Factory method for FullDTO.
	 * @return a FullDTO instance
	 */
	@Override
	protected ir.viratech.pond_ms.api.customer.dto.CustomerFavoriteGISVectorObjectFullDTO createFullDTO() {
		return new ir.viratech.pond_ms.api.customer.dto.CustomerFavoriteGISVectorObjectFullDTO();
	}

	/**
	 * Provides the class of FieldInfoContext used for search.
	 * @return the class of FieldInfoContext 
	 */
	@Override
	protected Class<ir.viratech.pond_ms.api.customer.dto.CustomerFavoriteGISVectorObjectFullDTO.FieldInfoContext> getFullDtoFieldInfoContextClass() {
		return ir.viratech.pond_ms.api.customer.dto.CustomerFavoriteGISVectorObjectFullDTO.FieldInfoContext.class;
	}

	/**
	 * Provides the bundle prefix used in i18n.
	 * @return the bundle prefix
	 */
	@Override
	protected String getBundlePrefix() {
		return "customerFavoriteGisVectorObject.";
	}
	
	
	/**
	 * Default constructor.
	 * Also adds the extents.
	 */
	public BaseCustomerFavoriteGISVectorObjectResource() {
		super();
	}

}
