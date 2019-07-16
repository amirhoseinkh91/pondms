package ir.viratech.pond_ms.api.customer.base;

import static ir.viratech.commons.api.field_info.FieldInfoContextProvider.getFieldInfoContextInstance;
import ir.viratech.pond_ms.api.customer.dto.CustomerFavoriteGISVectorObjectFullDTO;
import ir.viratech.pond_ms.model.customer.CustomerFavoriteGISVectorObject;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * A base DTO for class "CustomerFavoriteGISVectorObject".
 * Do not edit this file.
 * It is an automatically generated class.
 *
 */
public abstract class BaseCustomerFavoriteGISVectorObjectFullDTO extends ir.viratech.commons.api.dto.AbstractFullDTO<CustomerFavoriteGISVectorObject> {
	
	
	/**
	 * 
	 * Base FieldInfoContext for "CustomerFavoriteGISVectorObjectFullDTO".
	 *
	 */
	public static abstract class BaseFieldInfoContext extends ir.viratech.commons.api.search.field.AbstractFieldInfoContext<CustomerFavoriteGISVectorObjectFullDTO> {
		
		
		// =========== BEGIN createFieldInfo methods ===========
		
		
		/**
		 * creates a PrimitiveFieldInfo for primitive property "uid".
		 * @param externalName the external name of the property in the DTO class
		 * @param internalName the internal name of the property in the entity class
		 * @param internalSearchExpression the internal search expression by which the property could be really searched
		 * @param typeKey a key showing the type of the property (used in client side) 
		 * @param bundleKey Used for i18n translation of the property
		 * @param searchable true if the property could be accessed in client search queries
		 * @param sortable true if the property could be used for sorting in client search queries
		 * @return the FieldInfo created for the property
		 */
		protected ir.viratech.commons.api.search.field.PrimitiveFieldInfo<?> createFieldInfo_Uid(
				String externalName, String internalName, String internalSearchExpression, String typeKey, String bundleKey, boolean searchable, Boolean sortable) {
			return new ir.viratech.commons.api.search.field.types.FieldInfo_String(externalName, internalName, internalSearchExpression, typeKey, bundleKey, searchable, sortable);
		}
		
		
		/**
		 * Creates an EntityByDtoFinder for the DTO property "gisVectorObject".
		 * The created object finds entities of type "ir.viratech.pond_ms.model.map_object.vector.GISVectorObject" 
		 * by DTO's of type "ir.viratech.pond_ms.api.map_object.vector.dto.GISVectorObjectMapDTO".
		 * @return the created EntityByDtoFinder
		 */
		protected abstract ir.viratech.commons.api.search.EntityByDtoFinder<ir.viratech.pond_ms.model.map_object.vector.GISVectorObject, ir.viratech.pond_ms.api.map_object.vector.dto.GISVectorObjectMapDTO> createEntityByDtoFinder_GisVectorObject();
		
		private ir.viratech.commons.api.search.EntityByDtoFinder<ir.viratech.pond_ms.model.map_object.vector.GISVectorObject, ir.viratech.pond_ms.api.map_object.vector.dto.GISVectorObjectMapDTO> entityByDtoFinder_GisVectorObject;
		
		/**
		 * Getter for the previously created EntityByDtoFinder for property "gisVectorObject".
		 * @return the previously created EntityByDtoFinder object 
		 */
		public final ir.viratech.commons.api.search.EntityByDtoFinder<ir.viratech.pond_ms.model.map_object.vector.GISVectorObject, ir.viratech.pond_ms.api.map_object.vector.dto.GISVectorObjectMapDTO> getEntityByDtoFinder_GisVectorObject() {
			return this.entityByDtoFinder_GisVectorObject;
		}
		
		/**
		 * Finds entities of type "ir.viratech.pond_ms.model.map_object.vector.GISVectorObject" 
		 * by DTO's of type "ir.viratech.pond_ms.api.map_object.vector.dto.GISVectorObjectMapDTO".
		 * It is targeted for the DTO property: gisVectorObject
		 * @param gisVectorObjectDto 
		 *		the given dto by which the entity should be found
		 * @return the found entity
		 * @throws ir.viratech.commons.api.search.InvalidDtoException
		 * 		If the given dto is not valid or is not representing an internal entity
		 */
		public final ir.viratech.pond_ms.model.map_object.vector.GISVectorObject findByDto_GisVectorObject(ir.viratech.pond_ms.api.map_object.vector.dto.GISVectorObjectMapDTO gisVectorObjectDto) throws ir.viratech.commons.api.search.InvalidDtoException {
			return this.getEntityByDtoFinder_GisVectorObject().findByDto(gisVectorObjectDto);
		}
		
		/**
		 * creates a DtoFieldInfo for dto-property "gisVectorObject".
		 * @param externalName the external name of the property in the DTO class
		 * @param internalName the internal name of the property in the entity class
		 * @param internalSearchExpression the internal search expression by which the property could be really searched
		 * @param bundleKey Used for i18n translation of the property
		 * @param searchable true if the property could be accessed in client search queries
		 * @param fieldInfoContext the FieldInfoContext of the dto-property: gisVectorObject
		 * @param entityByDtoFinder the EntityByDtoFinder for the dto-property: gisVectorObject
		 * @return the FieldInfo created for the property
		 */
		protected ir.viratech.commons.api.search.field.DtoFieldInfo<ir.viratech.pond_ms.model.map_object.vector.GISVectorObject, ir.viratech.pond_ms.api.map_object.vector.dto.GISVectorObjectMapDTO> createFieldInfo_GisVectorObject(
				String externalName, String internalName, String internalSearchExpression, String bundleKey, boolean searchable, 
				ir.viratech.commons.api.search.field.FieldInfoContext<ir.viratech.pond_ms.api.map_object.vector.dto.GISVectorObjectMapDTO> fieldInfoContext, 
				ir.viratech.commons.api.search.EntityByDtoFinder<ir.viratech.pond_ms.model.map_object.vector.GISVectorObject, ir.viratech.pond_ms.api.map_object.vector.dto.GISVectorObjectMapDTO> entityByDtoFinder) {
			return new ir.viratech.commons.api.search.field.types.FieldInfo_Dto<ir.viratech.pond_ms.model.map_object.vector.GISVectorObject, ir.viratech.pond_ms.api.map_object.vector.dto.GISVectorObjectMapDTO>(
						externalName, internalName, internalSearchExpression, bundleKey, searchable, fieldInfoContext, entityByDtoFinder);
		}
		
		
		// =========== END createFieldInfo methods ===========
		
		/**
		 * The default constructor for BaseFieldInfoContext.
		 */
		protected BaseFieldInfoContext() {
			this.putFieldInfo(this.createFieldInfo_Uid("uid", "extuid", "extuid", null, "uid", false, false));
			this.entityByDtoFinder_GisVectorObject = createEntityByDtoFinder_GisVectorObject();
			this.putFieldInfo(this.createFieldInfo_GisVectorObject("gisVectorObject", "gisVectorObject", "gisVectorObject", "gisVectorObject", false, 
					getFieldInfoContextInstance(ir.viratech.pond_ms.api.map_object.vector.dto.GISVectorObjectMapDTO.FieldInfoContext.class), this.getEntityByDtoFinder_GisVectorObject()));
		}
		
		/**
		 * Creates a DTO of type "CustomerFavoriteGISVectorObjectFullDTO".
		 *
		 * @return the created DTO
		 */
		@Override
		public CustomerFavoriteGISVectorObjectFullDTO createDto() {
			return new CustomerFavoriteGISVectorObjectFullDTO();
		}
		
	}
	
	/**
	 * Provides the corresponding FieldInfoContext of this DTO.
	 *
	 * @return the corresponding FieldInfoContext object
	 */
	public CustomerFavoriteGISVectorObjectFullDTO.FieldInfoContext getFieldInfoContext() {
		return getFieldInfoContextInstance(CustomerFavoriteGISVectorObjectFullDTO.FieldInfoContext.class);
	}
	
	
	
	
	////////////////////
	// DTO Properties //
	////////////////////
	
	// uid
	
	private String uid;
	
	/**
	 * Getter for property "uid".
	 *
	 * @return the value of property "uid"
	 */
	@JsonProperty
	public String getUid() {
		return this.uid;
	}
	
	
	// gisVectorObject
	
	private ir.viratech.pond_ms.api.map_object.vector.dto.GISVectorObjectMapDTO gisVectorObject;
	
	/**
	 * Getter for property "gisVectorObject".
	 *
	 * @return the value of property "gisVectorObject"
	 */
	@JsonProperty
	public ir.viratech.pond_ms.api.map_object.vector.dto.GISVectorObjectMapDTO getGisVectorObject() {
		return this.gisVectorObject;
	}
	
	/**
	 * Setter for property "gisVectorObject".
	 *
	 * @param gisVectorObject the new value for property "gisVectorObject"
	 */
	public void setGisVectorObject(ir.viratech.pond_ms.api.map_object.vector.dto.GISVectorObjectMapDTO gisVectorObject) {
		this.gisVectorObject = gisVectorObject;
	}
	
	/**
	 * Used for loading the property gisVectorObject from a given internal entity.
	 * 
	 * @param customerFavoriteGISVectorObject the given internal entity
	 * @return the value of property gisVectorObject based on the given internal entity
	 */
	protected ir.viratech.pond_ms.api.map_object.vector.dto.GISVectorObjectMapDTO load_GisVectorObject(CustomerFavoriteGISVectorObject customerFavoriteGISVectorObject) {
		ir.viratech.pond_ms.model.map_object.vector.GISVectorObject __internalProperty_gisVectorObject = customerFavoriteGISVectorObject.getGisVectorObject();
		if (__internalProperty_gisVectorObject == null)
			return null; 
		ir.viratech.pond_ms.api.map_object.vector.dto.GISVectorObjectMapDTO gisVectorObject = new ir.viratech.pond_ms.api.map_object.vector.dto.GISVectorObjectMapDTO();
		gisVectorObject.loadFrom(__internalProperty_gisVectorObject);
		return gisVectorObject;
	}
	
	/**
	/**
	 * Used for saving a given value of property gisVectorObject to a given internal entity.
	 * 
	 * @param customerFavoriteGISVectorObject
	 * 		the given internal entity
	 * @param gisVectorObjectDto 
	 * 		the value of property gisVectorObject which should be saved to the given internal entity
	 * @throws ir.viratech.commons.api.entity_modifier.BadDtoEntityModificationException 
	 * 		if the given value of property gisVectorObject is not appropriate for saving the entity
	 */
	protected void save_GisVectorObject(CustomerFavoriteGISVectorObject customerFavoriteGISVectorObject, ir.viratech.pond_ms.api.map_object.vector.dto.GISVectorObjectMapDTO gisVectorObjectDto)
			throws ir.viratech.commons.api.entity_modifier.BadDtoEntityModificationException {
		if (gisVectorObjectDto == null)
			throw new ir.viratech.commons.api.entity_modifier.BadDtoEntityModificationException("The given dto must not be null.");
		ir.viratech.pond_ms.model.map_object.vector.GISVectorObject __internalProperty_gisVectorObject = null;
		try {
			__internalProperty_gisVectorObject = findByDto_GisVectorObject(gisVectorObjectDto);
		} catch (ir.viratech.commons.api.search.InvalidDtoException e) {
			throw new ir.viratech.commons.api.entity_modifier.BadDtoEntityModificationException("The given dto is invalid: "+gisVectorObjectDto, e);
		}
		if (__internalProperty_gisVectorObject == null)
			throw new ir.viratech.commons.api.entity_modifier.BadDtoEntityModificationException("No entity was found for the given dto: "+gisVectorObjectDto);
		customerFavoriteGISVectorObject.setGisVectorObject(__internalProperty_gisVectorObject);
	}
	
	/**
	 * Finds entities based on the DTO property "gisVectorObject".
	 * It finds entities of type "ir.viratech.pond_ms.model.map_object.vector.GISVectorObject" 
	 * based on DTO's of type "ir.viratech.pond_ms.api.map_object.vector.dto.GISVectorObjectMapDTO",
	 * targeted on the DTO property "gisVectorObject".
	 * 
	 * @param gisVectorObjectDto 
	 *		the given dto by which the entity should be found
	 * @return the found entity
	 * @throws ir.viratech.commons.api.search.InvalidDtoException
	 * 		If the given dto is not valid or is not representing an internal entity  
	 */
	protected ir.viratech.pond_ms.model.map_object.vector.GISVectorObject findByDto_GisVectorObject(ir.viratech.pond_ms.api.map_object.vector.dto.GISVectorObjectMapDTO gisVectorObjectDto) throws ir.viratech.commons.api.search.InvalidDtoException {
		return this.getFieldInfoContext().findByDto_GisVectorObject(gisVectorObjectDto);
	}
	
	
	
	/////////////////////////
	// save/load functions //
	/////////////////////////
	
	/**
	 * Loads this DTO from an entity object of type "CustomerFavoriteGISVectorObject".
	 * 
	 * @param customerFavoriteGISVectorObject the entity object from which this DTO is loaded. 
	 */
	@Override
	public void loadFrom(CustomerFavoriteGISVectorObject customerFavoriteGISVectorObject) {
		this.uid = customerFavoriteGISVectorObject.getExtuid();
		this.gisVectorObject = this.load_GisVectorObject(customerFavoriteGISVectorObject);
	}
	
	/**
	 * Saves this DTO to an entity object of type "CustomerFavoriteGISVectorObject".
	 * 
	 * @param customerFavoriteGISVectorObject the entity object to which this DTO is saved. 
	 * @throws BadDtoEntityModificationException If this DTO is not valid for saving. 
	 */
	@Override
	public void saveTo(CustomerFavoriteGISVectorObject customerFavoriteGISVectorObject) throws ir.viratech.commons.api.entity_modifier.BadDtoEntityModificationException {
		//Disabled save for property: uid
		this.save_GisVectorObject(customerFavoriteGISVectorObject, this.gisVectorObject);
	}
	
	
	
	//////////////
	// toString //
	//////////////
	
	@Override
	protected Map<String, Object> toStringData() {
		Map<String, Object> data = super.toStringData();
		data.put("uid", this.uid);
		data.put("gisVectorObject", this.gisVectorObject);
		return data;
	}
	
}
