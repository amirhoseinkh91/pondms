package ir.viratech.pond_ms.api.customer.base;

import com.wordnik.swagger.annotations.Api;

import ir.viratech.pond_ms.model.customer.CustomerViewedGISVectorObject;

/**
 *  Base class for "CustomerViewedGISVectorObjectResource".
 *  It is an automatically generated file and should not be edited.
 */
@Api(value = BaseCustomerViewedGISVectorObjectResource.RESOURCE_PATH_BASE, description = BaseCustomerViewedGISVectorObjectResource.RESOURCE_DESCRIPTION)
public abstract class BaseCustomerViewedGISVectorObjectResource extends ir.viratech.pond_ms.api.customer.AbstractCustomerBasedMgrBasedResource<CustomerViewedGISVectorObject,ir.viratech.pond_ms.api.customer.dto.CustomerViewedGISVectorObjectFullDTO> {
	
	/**
	 * The resource path base used in swagger.
	 */
	public static final String RESOURCE_PATH_BASE = "/cu/v1/viewedgisvectorobject"+"/"+PATH_PART_ITEMS;
	
	/**
	 * The resource description used in swagger.
	 */
	public static final String RESOURCE_DESCRIPTION = "CustomerViewedGISVectorObject Resource";
	
	/**
	 * The path which is handled by this resource/
	 */
	public static final String RESOURCE_PATH = "/cu/v1/viewedgisvectorobject"+PATH_PARAM_PART__ITEMS;
	
	/**
	 * Provides the entity manager used by the resource.
	 * @return an instance of the required entity manager
	 */
	@Override
	protected ir.viratech.commons.model.BasicEntityMgr<CustomerViewedGISVectorObject> getMgr() {
		return ir.viratech.pond_ms.model.customer.logic.CustomerViewedGISVectorObjectMgr.getInstance();
	}

	/**
	 * Factory method for FullDTO.
	 * @return a FullDTO instance
	 */
	@Override
	protected ir.viratech.pond_ms.api.customer.dto.CustomerViewedGISVectorObjectFullDTO createFullDTO() {
		return new ir.viratech.pond_ms.api.customer.dto.CustomerViewedGISVectorObjectFullDTO();
	}

	/**
	 * Provides the class of FieldInfoContext used for search.
	 * @return the class of FieldInfoContext 
	 */
	@Override
	protected Class<ir.viratech.pond_ms.api.customer.dto.CustomerViewedGISVectorObjectFullDTO.FieldInfoContext> getFullDtoFieldInfoContextClass() {
		return ir.viratech.pond_ms.api.customer.dto.CustomerViewedGISVectorObjectFullDTO.FieldInfoContext.class;
	}

	/**
	 * Provides the bundle prefix used in i18n.
	 * @return the bundle prefix
	 */
	@Override
	protected String getBundlePrefix() {
		return "customerViewedGisVectorObject.";
	}
	
	
	/**
	 * Default constructor.
	 * Also adds the extents.
	 */
	public BaseCustomerViewedGISVectorObjectResource() {
		super();
	}

}
