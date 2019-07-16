package ir.viratech.pond_ms.api.campaign.base;

import static ir.viratech.commons.api.field_info.FieldInfoContextProvider.getFieldInfoContextInstance;
import ir.viratech.pond_ms.api.campaign.dto.CampaignFullDTO;
import ir.viratech.pond_ms.model.campaign.Campaign;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * A base DTO for class "Campaign".
 * Do not edit this file.
 * It is an automatically generated class.
 *
 */
public abstract class BaseCampaignFullDTO extends ir.viratech.commons.api.dto.AbstractFullDTO<Campaign> {
	
	
	/**
	 * 
	 * Base FieldInfoContext for "CampaignFullDTO".
	 *
	 */
	public static abstract class BaseFieldInfoContext extends ir.viratech.commons.api.search.field.AbstractFieldInfoContext<CampaignFullDTO> {
		
		
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
		 * creates a PrimitiveFieldInfo for primitive property "device_name".
		 * @param externalName the external name of the property in the DTO class
		 * @param internalName the internal name of the property in the entity class
		 * @param internalSearchExpression the internal search expression by which the property could be really searched
		 * @param typeKey a key showing the type of the property (used in client side) 
		 * @param bundleKey Used for i18n translation of the property
		 * @param searchable true if the property could be accessed in client search queries
		 * @param sortable true if the property could be used for sorting in client search queries
		 * @return the FieldInfo created for the property
		 */
		protected ir.viratech.commons.api.search.field.PrimitiveFieldInfo<?> createFieldInfo_Device_name(
				String externalName, String internalName, String internalSearchExpression, String typeKey, String bundleKey, boolean searchable, Boolean sortable) {
			return new ir.viratech.commons.api.search.field.types.FieldInfo_String(externalName, internalName, internalSearchExpression, typeKey, bundleKey, searchable, sortable);
		}
		
		
		/**
		 * creates a PrimitiveFieldInfo for primitive property "destination".
		 * @param externalName the external name of the property in the DTO class
		 * @param internalName the internal name of the property in the entity class
		 * @param internalSearchExpression the internal search expression by which the property could be really searched
		 * @param typeKey a key showing the type of the property (used in client side) 
		 * @param bundleKey Used for i18n translation of the property
		 * @param searchable true if the property could be accessed in client search queries
		 * @param sortable true if the property could be used for sorting in client search queries
		 * @return the FieldInfo created for the property
		 */
		protected ir.viratech.commons.api.search.field.PrimitiveFieldInfo<?> createFieldInfo_Destination(
				String externalName, String internalName, String internalSearchExpression, String typeKey, String bundleKey, boolean searchable, Boolean sortable) {
			return new ir.viratech.commons.api.search.field.types.FieldInfo_String(externalName, internalName, internalSearchExpression, typeKey, bundleKey, searchable, sortable);
		}
		
		
		/**
		 * creates a PrimitiveFieldInfo for primitive property "days".
		 * @param externalName the external name of the property in the DTO class
		 * @param internalName the internal name of the property in the entity class
		 * @param internalSearchExpression the internal search expression by which the property could be really searched
		 * @param typeKey a key showing the type of the property (used in client side) 
		 * @param bundleKey Used for i18n translation of the property
		 * @param searchable true if the property could be accessed in client search queries
		 * @param sortable true if the property could be used for sorting in client search queries
		 * @return the FieldInfo created for the property
		 */
		protected ir.viratech.commons.api.search.field.PrimitiveFieldInfo<?> createFieldInfo_Days(
				String externalName, String internalName, String internalSearchExpression, String typeKey, String bundleKey, boolean searchable, Boolean sortable) {
			return new ir.viratech.commons.api.search.field.types.FieldInfo_String(externalName, internalName, internalSearchExpression, typeKey, bundleKey, searchable, sortable);
		}
		
		
		// =========== END createFieldInfo methods ===========
		
		/**
		 * The default constructor for BaseFieldInfoContext.
		 */
		protected BaseFieldInfoContext() {
			this.putFieldInfo(this.createFieldInfo_Uid("uid", "extuid", "extuid", null, "uid", true, false));
			this.putFieldInfo(this.createFieldInfo_Device_name("device_name", "device_name", "device_name", null, "device_name", true, null));
			this.putFieldInfo(this.createFieldInfo_Destination("destination", "destination", "destination", null, "destination", true, null));
			this.putFieldInfo(this.createFieldInfo_Days("days", "days", "days", null, "days", true, null));
		}
		
		/**
		 * Creates a DTO of type "CampaignFullDTO".
		 *
		 * @return the created DTO
		 */
		@Override
		public CampaignFullDTO createDto() {
			return new CampaignFullDTO();
		}
		
	}
	
	/**
	 * Provides the corresponding FieldInfoContext of this DTO.
	 *
	 * @return the corresponding FieldInfoContext object
	 */
	public CampaignFullDTO.FieldInfoContext getFieldInfoContext() {
		return getFieldInfoContextInstance(CampaignFullDTO.FieldInfoContext.class);
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
	
	
	// device_name
	
	private String device_name;
	
	/**
	 * Getter for property "device_name".
	 *
	 * @return the value of property "device_name"
	 */
	@JsonProperty
	public String getDevice_name() {
		return this.device_name;
	}
	
	
	// destination
	
	private String destination;
	
	/**
	 * Getter for property "destination".
	 *
	 * @return the value of property "destination"
	 */
	@JsonProperty
	public String getDestination() {
		return this.destination;
	}
	
	
	// days
	
	private com.fasterxml.jackson.databind.JsonNode days;
	
	/**
	 * Getter for property "days".
	 *
	 * @return the value of property "days"
	 */
	@JsonProperty
	public com.fasterxml.jackson.databind.JsonNode getDays() {
		return this.days;
	}
	
	/**
	 * Used for loading the property days from a given internal entity.
	 * 
	 * @param campaign the given internal entity
	 * @return the value of property days based on the given internal entity
	 */
	protected abstract com.fasterxml.jackson.databind.JsonNode load_Days(Campaign campaign);
	
	
	
	/////////////////////////
	// save/load functions //
	/////////////////////////
	
	/**
	 * Loads this DTO from an entity object of type "Campaign".
	 * 
	 * @param campaign the entity object from which this DTO is loaded. 
	 */
	@Override
	public void loadFrom(Campaign campaign) {
		this.uid = campaign.getExtuid();
		this.device_name = campaign.getDevice_name();
		this.destination = campaign.getDestination();
		this.days = this.load_Days(campaign);
	}
	
	/**
	 * Saves this DTO to an entity object of type "Campaign".
	 * 
	 * @param campaign the entity object to which this DTO is saved. 
	 * @throws BadDtoEntityModificationException If this DTO is not valid for saving. 
	 */
	@Override
	public void saveTo(Campaign campaign) throws ir.viratech.commons.api.entity_modifier.BadDtoEntityModificationException {
		//Disabled save for property: uid
		//Disabled save for property: device_name
		//Disabled save for property: destination
		//Disabled save for property: days
	}
	
	
	
	//////////////
	// toString //
	//////////////
	
	@Override
	protected Map<String, Object> toStringData() {
		Map<String, Object> data = super.toStringData();
		data.put("uid", this.uid);
		data.put("device_name", this.device_name);
		data.put("destination", this.destination);
		data.put("days", this.days);
		return data;
	}
	
}
