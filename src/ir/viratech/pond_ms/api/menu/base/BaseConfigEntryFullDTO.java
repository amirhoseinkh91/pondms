package ir.viratech.pond_ms.api.menu.base;

import static ir.viratech.commons.api.field_info.FieldInfoContextProvider.getFieldInfoContextInstance;
import ir.viratech.pond_ms.api.menu.dto.ConfigEntryFullDTO;
import ir.viratech.pond_ms.model.config.ConfigEntry;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * A base DTO for class "ConfigEntry".
 * Do not edit this file.
 * It is an automatically generated class.
 *
 */
public abstract class BaseConfigEntryFullDTO extends ir.viratech.commons.api.dto.AbstractFullDTO<ConfigEntry> {
	
	
	/**
	 * 
	 * Base FieldInfoContext for "ConfigEntryFullDTO".
	 *
	 */
	public static abstract class BaseFieldInfoContext extends ir.viratech.commons.api.search.field.AbstractFieldInfoContext<ConfigEntryFullDTO> {
		
		
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
		 * creates a PrimitiveFieldInfo for primitive property "title".
		 * @param externalName the external name of the property in the DTO class
		 * @param internalName the internal name of the property in the entity class
		 * @param internalSearchExpression the internal search expression by which the property could be really searched
		 * @param typeKey a key showing the type of the property (used in client side) 
		 * @param bundleKey Used for i18n translation of the property
		 * @param searchable true if the property could be accessed in client search queries
		 * @param sortable true if the property could be used for sorting in client search queries
		 * @return the FieldInfo created for the property
		 */
		protected ir.viratech.commons.api.search.field.PrimitiveFieldInfo<?> createFieldInfo_Title(
				String externalName, String internalName, String internalSearchExpression, String typeKey, String bundleKey, boolean searchable, Boolean sortable) {
			return new ir.viratech.commons.api.search.field.types.FieldInfo_String(externalName, internalName, internalSearchExpression, typeKey, bundleKey, searchable, sortable);
		}
		
		
		/**
		 * creates a PrimitiveFieldInfo for primitive property "key".
		 * @param externalName the external name of the property in the DTO class
		 * @param internalName the internal name of the property in the entity class
		 * @param internalSearchExpression the internal search expression by which the property could be really searched
		 * @param typeKey a key showing the type of the property (used in client side) 
		 * @param bundleKey Used for i18n translation of the property
		 * @param searchable true if the property could be accessed in client search queries
		 * @param sortable true if the property could be used for sorting in client search queries
		 * @return the FieldInfo created for the property
		 */
		protected ir.viratech.commons.api.search.field.PrimitiveFieldInfo<?> createFieldInfo_Key(
				String externalName, String internalName, String internalSearchExpression, String typeKey, String bundleKey, boolean searchable, Boolean sortable) {
			return new ir.viratech.commons.api.search.field.types.FieldInfo_String(externalName, internalName, internalSearchExpression, typeKey, bundleKey, searchable, sortable);
		}
		
		
		/**
		 * creates a PrimitiveFieldInfo for primitive property "value".
		 * @param externalName the external name of the property in the DTO class
		 * @param internalName the internal name of the property in the entity class
		 * @param internalSearchExpression the internal search expression by which the property could be really searched
		 * @param typeKey a key showing the type of the property (used in client side) 
		 * @param bundleKey Used for i18n translation of the property
		 * @param searchable true if the property could be accessed in client search queries
		 * @param sortable true if the property could be used for sorting in client search queries
		 * @return the FieldInfo created for the property
		 */
		protected ir.viratech.commons.api.search.field.PrimitiveFieldInfo<?> createFieldInfo_Value(
				String externalName, String internalName, String internalSearchExpression, String typeKey, String bundleKey, boolean searchable, Boolean sortable) {
			return new ir.viratech.commons.api.search.field.types.FieldInfo_String(externalName, internalName, internalSearchExpression, typeKey, bundleKey, searchable, sortable);
		}
		
		
		// =========== END createFieldInfo methods ===========
		
		/**
		 * The default constructor for BaseFieldInfoContext.
		 */
		protected BaseFieldInfoContext() {
			this.putFieldInfo(this.createFieldInfo_Uid("uid", "extuid", "extuid", null, "uid", true, null));
			this.putFieldInfo(this.createFieldInfo_Title("title", "title", "title", null, "title", true, null));
			this.putFieldInfo(this.createFieldInfo_Key("key", "key", "key", null, "key", true, null));
			this.putFieldInfo(this.createFieldInfo_Value("value", "value", "value", null, "value", true, null));
		}
		
		/**
		 * Creates a DTO of type "ConfigEntryFullDTO".
		 *
		 * @return the created DTO
		 */
		@Override
		public ConfigEntryFullDTO createDto() {
			return new ConfigEntryFullDTO();
		}
		
	}
	
	/**
	 * Provides the corresponding FieldInfoContext of this DTO.
	 *
	 * @return the corresponding FieldInfoContext object
	 */
	public ConfigEntryFullDTO.FieldInfoContext getFieldInfoContext() {
		return getFieldInfoContextInstance(ConfigEntryFullDTO.FieldInfoContext.class);
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
	
	
	// title
	
	private String title;
	
	/**
	 * Getter for property "title".
	 *
	 * @return the value of property "title"
	 */
	@JsonProperty
	public String getTitle() {
		return this.title;
	}
	
	/**
	 * Setter for property "title".
	 *
	 * @param title the new value for property "title"
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	
	// key
	
	private String key;
	
	/**
	 * Getter for property "key".
	 *
	 * @return the value of property "key"
	 */
	@JsonProperty
	public String getKey() {
		return this.key;
	}
	
	/**
	 * Setter for property "key".
	 *
	 * @param key the new value for property "key"
	 */
	public void setKey(String key) {
		this.key = key;
	}
	
	
	// value
	
	private String value;
	private boolean __modified__Value = false;
	
	/**
	 * Getter for property "value".
	 *
	 * @return the value of property "value"
	 */
	@JsonProperty
	public String getValue() {
		return this.value;
	}
	
	/**
	 * Setter for property "value".
	 *
	 * @param value the new value for property "value"
	 */
	public void setValue(String value) {
		this.__modified__Value = true;
		this.value = value;
	}
	
	/**
	 * Shows the modification state of the property "value".
	 * 
	 * @return true if the property is modified
	 */
	public boolean hasModifiedValue() {
		return this.__modified__Value;
	}
	
	
	
	/////////////////////////
	// save/load functions //
	/////////////////////////
	
	/**
	 * Loads this DTO from an entity object of type "ConfigEntry".
	 * 
	 * @param configEntry the entity object from which this DTO is loaded. 
	 */
	@Override
	public void loadFrom(ConfigEntry configEntry) {
		this.uid = configEntry.getExtuid();
		this.title = configEntry.getTitle();
		this.key = configEntry.getKey();
		this.value = configEntry.getValue();
	}
	
	/**
	 * Saves this DTO to an entity object of type "ConfigEntry".
	 * 
	 * @param configEntry the entity object to which this DTO is saved. 
	 * @throws BadDtoEntityModificationException If this DTO is not valid for saving. 
	 */
	@Override
	public void saveTo(ConfigEntry configEntry) throws ir.viratech.commons.api.entity_modifier.BadDtoEntityModificationException {
		//Disabled save for property: uid
		configEntry.setTitle(this.title);
		configEntry.setKey(this.key);
		if (this.hasModifiedValue()) {
			configEntry.setValue(this.value);
		}
	}
	
	
	
	//////////////
	// toString //
	//////////////
	
	@Override
	protected Map<String, Object> toStringData() {
		Map<String, Object> data = super.toStringData();
		data.put("uid", this.uid);
		data.put("title", this.title);
		data.put("key", this.key);
		data.put("value", this.value);
		return data;
	}
	
}
