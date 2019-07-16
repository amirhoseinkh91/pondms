package ir.viratech.pond_ms.api.customer.base;

import static ir.viratech.commons.api.field_info.FieldInfoContextProvider.getFieldInfoContextInstance;
import ir.viratech.pond_ms.api.customer.dto.CustomerViewedGISVectorObjectFullDTO;
import ir.viratech.pond_ms.model.customer.CustomerViewedGISVectorObject;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * A base DTO for class "CustomerViewedGISVectorObject".
 * Do not edit this file.
 * It is an automatically generated class.
 *
 */
public abstract class BaseCustomerViewedGISVectorObjectFullDTO extends ir.viratech.commons.api.dto.AbstractFullDTO<CustomerViewedGISVectorObject> {
	
	
	/**
	 * 
	 * Base FieldInfoContext for "CustomerViewedGISVectorObjectFullDTO".
	 *
	 */
	public static abstract class BaseFieldInfoContext extends ir.viratech.commons.api.search.field.AbstractFieldInfoContext<CustomerViewedGISVectorObjectFullDTO> {
		
		
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
		 * creates a PrimitiveFieldInfo for primitive property "viewDate".
		 * @param externalName the external name of the property in the DTO class
		 * @param internalName the internal name of the property in the entity class
		 * @param internalSearchExpression the internal search expression by which the property could be really searched
		 * @param typeKey a key showing the type of the property (used in client side) 
		 * @param bundleKey Used for i18n translation of the property
		 * @param searchable true if the property could be accessed in client search queries
		 * @param sortable true if the property could be used for sorting in client search queries
		 * @return the FieldInfo created for the property
		 */
		protected ir.viratech.commons.api.search.field.PrimitiveFieldInfo<?> createFieldInfo_ViewDate(
				String externalName, String internalName, String internalSearchExpression, String typeKey, String bundleKey, boolean searchable, Boolean sortable) {
			return new ir.viratech.commons.api.search.field.types.FieldInfo_Timestamp(externalName, internalName, internalSearchExpression, typeKey, bundleKey, searchable, sortable);
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
			this.putFieldInfo(this.createFieldInfo_ViewDate("viewDate", "viewDate", "viewDate", null, "viewDate", true, true));
			this.putFieldInfo(this.createFieldInfo_GisVectorObject("gisVectorObject", "gisVectorObject", "gisVectorObject", "gisVectorObject", false, 
					getFieldInfoContextInstance(ir.viratech.pond_ms.api.map_object.vector.dto.GISVectorObjectMapDTO.FieldInfoContext.class), null));
		}
		
		/**
		 * Creates a DTO of type "CustomerViewedGISVectorObjectFullDTO".
		 *
		 * @return the created DTO
		 */
		@Override
		public CustomerViewedGISVectorObjectFullDTO createDto() {
			return new CustomerViewedGISVectorObjectFullDTO();
		}
		
	}
	
	/**
	 * Provides the corresponding FieldInfoContext of this DTO.
	 *
	 * @return the corresponding FieldInfoContext object
	 */
	public CustomerViewedGISVectorObjectFullDTO.FieldInfoContext getFieldInfoContext() {
		return getFieldInfoContextInstance(CustomerViewedGISVectorObjectFullDTO.FieldInfoContext.class);
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
	
	
	// viewDate
	
	private java.util.Date viewDate;
	
	/**
	 * Getter for property "viewDate".
	 *
	 * @return the value of property "viewDate"
	 */
	@JsonProperty
	public java.util.Date getViewDate() {
		return this.viewDate;
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
	 * Used for loading the property gisVectorObject from a given internal entity.
	 * 
	 * @param customerViewedGISVectorObject the given internal entity
	 * @return the value of property gisVectorObject based on the given internal entity
	 */
	protected ir.viratech.pond_ms.api.map_object.vector.dto.GISVectorObjectMapDTO load_GisVectorObject(CustomerViewedGISVectorObject customerViewedGISVectorObject) {
		ir.viratech.pond_ms.model.map_object.vector.GISVectorObject __internalProperty_gisVectorObject = customerViewedGISVectorObject.getGisVectorObject();
		if (__internalProperty_gisVectorObject == null)
			return null; 
		ir.viratech.pond_ms.api.map_object.vector.dto.GISVectorObjectMapDTO gisVectorObject = new ir.viratech.pond_ms.api.map_object.vector.dto.GISVectorObjectMapDTO();
		gisVectorObject.loadFrom(__internalProperty_gisVectorObject);
		return gisVectorObject;
	}
	
	
	
	/////////////////////////
	// save/load functions //
	/////////////////////////
	
	/**
	 * Loads this DTO from an entity object of type "CustomerViewedGISVectorObject".
	 * 
	 * @param customerViewedGISVectorObject the entity object from which this DTO is loaded. 
	 */
	@Override
	public void loadFrom(CustomerViewedGISVectorObject customerViewedGISVectorObject) {
		this.uid = customerViewedGISVectorObject.getExtuid();
		this.viewDate = customerViewedGISVectorObject.getViewDate();
		this.gisVectorObject = this.load_GisVectorObject(customerViewedGISVectorObject);
	}
	
	/**
	 * Saves this DTO to an entity object of type "CustomerViewedGISVectorObject".
	 * 
	 * @param customerViewedGISVectorObject the entity object to which this DTO is saved. 
	 * @throws BadDtoEntityModificationException If this DTO is not valid for saving. 
	 */
	@Override
	public void saveTo(CustomerViewedGISVectorObject customerViewedGISVectorObject) throws ir.viratech.commons.api.entity_modifier.BadDtoEntityModificationException {
		//Disabled save for property: uid
		//Disabled save for property: viewDate
		//Disabled save for property: gisVectorObject
	}
	
	
	
	//////////////
	// toString //
	//////////////
	
	@Override
	protected Map<String, Object> toStringData() {
		Map<String, Object> data = super.toStringData();
		data.put("uid", this.uid);
		data.put("viewDate", this.viewDate);
		data.put("gisVectorObject", this.gisVectorObject);
		return data;
	}
	
}
