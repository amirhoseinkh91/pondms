package ir.viratech.pond_ms.api.layer.base;

import static ir.viratech.commons.api.field_info.FieldInfoContextProvider.getFieldInfoContextInstance;
import ir.viratech.pond_ms.api.layer.dto.LayerLightDTO;
import ir.viratech.pond_ms.model.layer.Layer;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * A base DTO for class "Layer".
 * Do not edit this file.
 * It is an automatically generated class.
 *
 */
public abstract class BaseLayerLightDTO extends ir.viratech.commons.api.dto.AbstractFullDTO<Layer> {
	
	
	/**
	 * 
	 * Base FieldInfoContext for "LayerLightDTO".
	 *
	 */
	public static abstract class BaseFieldInfoContext extends ir.viratech.commons.api.search.field.AbstractFieldInfoContext<LayerLightDTO> {
		
		
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
		 * creates a PrimitiveFieldInfo for primitive property "name".
		 * @param externalName the external name of the property in the DTO class
		 * @param internalName the internal name of the property in the entity class
		 * @param internalSearchExpression the internal search expression by which the property could be really searched
		 * @param typeKey a key showing the type of the property (used in client side) 
		 * @param bundleKey Used for i18n translation of the property
		 * @param searchable true if the property could be accessed in client search queries
		 * @param sortable true if the property could be used for sorting in client search queries
		 * @return the FieldInfo created for the property
		 */
		protected ir.viratech.commons.api.search.field.PrimitiveFieldInfo<?> createFieldInfo_Name(
				String externalName, String internalName, String internalSearchExpression, String typeKey, String bundleKey, boolean searchable, Boolean sortable) {
			return new ir.viratech.commons.api.search.field.types.FieldInfo_String(externalName, internalName, internalSearchExpression, typeKey, bundleKey, searchable, sortable);
		}
		
		
		/**
		 * creates a PrimitiveFieldInfo for primitive property "type".
		 * @param externalName the external name of the property in the DTO class
		 * @param internalName the internal name of the property in the entity class
		 * @param internalSearchExpression the internal search expression by which the property could be really searched
		 * @param typeKey a key showing the type of the property (used in client side) 
		 * @param bundleKey Used for i18n translation of the property
		 * @param searchable true if the property could be accessed in client search queries
		 * @param sortable true if the property could be used for sorting in client search queries
		 * @return the FieldInfo created for the property
		 */
		protected ir.viratech.commons.api.search.field.PrimitiveFieldInfo<?> createFieldInfo_Type(
				String externalName, String internalName, String internalSearchExpression, String typeKey, String bundleKey, boolean searchable, Boolean sortable) {
			return new ir.viratech.commons.api.search.field.types.FieldInfo_String(externalName, internalName, internalSearchExpression, typeKey, bundleKey, searchable, sortable);
		}
		
		
		/**
		 * creates a PrimitiveFieldInfo for primitive property "childCount".
		 * @param externalName the external name of the property in the DTO class
		 * @param internalName the internal name of the property in the entity class
		 * @param internalSearchExpression the internal search expression by which the property could be really searched
		 * @param typeKey a key showing the type of the property (used in client side) 
		 * @param bundleKey Used for i18n translation of the property
		 * @param searchable true if the property could be accessed in client search queries
		 * @param sortable true if the property could be used for sorting in client search queries
		 * @return the FieldInfo created for the property
		 */
		protected ir.viratech.commons.api.search.field.PrimitiveFieldInfo<?> createFieldInfo_ChildCount(
				String externalName, String internalName, String internalSearchExpression, String typeKey, String bundleKey, boolean searchable, Boolean sortable) {
			return new ir.viratech.commons.api.search.field.types.FieldInfo_Integer(externalName, internalName, internalSearchExpression, typeKey, bundleKey, searchable, sortable);
		}
		
		
		/**
		 * creates a PrimitiveFieldInfo for primitive property "secret".
		 * @param externalName the external name of the property in the DTO class
		 * @param internalName the internal name of the property in the entity class
		 * @param internalSearchExpression the internal search expression by which the property could be really searched
		 * @param typeKey a key showing the type of the property (used in client side) 
		 * @param bundleKey Used for i18n translation of the property
		 * @param searchable true if the property could be accessed in client search queries
		 * @param sortable true if the property could be used for sorting in client search queries
		 * @return the FieldInfo created for the property
		 */
		protected ir.viratech.commons.api.search.field.PrimitiveFieldInfo<?> createFieldInfo_Secret(
				String externalName, String internalName, String internalSearchExpression, String typeKey, String bundleKey, boolean searchable, Boolean sortable) {
			return new ir.viratech.commons.api.search.field.types.FieldInfo_Boolean(externalName, internalName, internalSearchExpression, typeKey, bundleKey, searchable, sortable);
		}
		
		
		/**
		 * creates a PrimitiveFieldInfo for primitive property "isLabeled".
		 * @param externalName the external name of the property in the DTO class
		 * @param internalName the internal name of the property in the entity class
		 * @param internalSearchExpression the internal search expression by which the property could be really searched
		 * @param typeKey a key showing the type of the property (used in client side) 
		 * @param bundleKey Used for i18n translation of the property
		 * @param searchable true if the property could be accessed in client search queries
		 * @param sortable true if the property could be used for sorting in client search queries
		 * @return the FieldInfo created for the property
		 */
		protected ir.viratech.commons.api.search.field.PrimitiveFieldInfo<?> createFieldInfo_IsLabeled(
				String externalName, String internalName, String internalSearchExpression, String typeKey, String bundleKey, boolean searchable, Boolean sortable) {
			return new ir.viratech.commons.api.search.field.types.FieldInfo_Boolean(externalName, internalName, internalSearchExpression, typeKey, bundleKey, searchable, sortable);
		}
		
		
		/**
		 * creates a PrimitiveFieldInfo for primitive property "formSchemaKey".
		 * @param externalName the external name of the property in the DTO class
		 * @param internalName the internal name of the property in the entity class
		 * @param internalSearchExpression the internal search expression by which the property could be really searched
		 * @param typeKey a key showing the type of the property (used in client side) 
		 * @param bundleKey Used for i18n translation of the property
		 * @param searchable true if the property could be accessed in client search queries
		 * @param sortable true if the property could be used for sorting in client search queries
		 * @return the FieldInfo created for the property
		 */
		protected ir.viratech.commons.api.search.field.PrimitiveFieldInfo<?> createFieldInfo_FormSchemaKey(
				String externalName, String internalName, String internalSearchExpression, String typeKey, String bundleKey, boolean searchable, Boolean sortable) {
			return new ir.viratech.commons.api.search.field.types.FieldInfo_String(externalName, internalName, internalSearchExpression, typeKey, bundleKey, searchable, sortable);
		}
		
		
		// =========== END createFieldInfo methods ===========
		
		/**
		 * The default constructor for BaseFieldInfoContext.
		 */
		protected BaseFieldInfoContext() {
			this.putFieldInfo(this.createFieldInfo_Uid("uid", "extuid", "extuid", null, "uid", true, false));
			this.putFieldInfo(this.createFieldInfo_Name("name", "name", "name", null, "name", true, null));
			this.putFieldInfo(this.createFieldInfo_Type("type", "type", "type", null, "type", true, null));
			this.putFieldInfo(this.createFieldInfo_ChildCount("childCount", "childCount", "childCount", null, "childCount", true, null));
			this.putFieldInfo(this.createFieldInfo_Secret("secret", "secret", "secret", null, "secret", true, false));
			this.putFieldInfo(this.createFieldInfo_IsLabeled("isLabeled", "isLabeled", "isLabeled", null, "isLabeled", true, null));
			this.putFieldInfo(this.createFieldInfo_FormSchemaKey("formSchemaKey", "formSchemaKey", "formSchemaKey", null, "formSchemaKey", true, false));
		}
		
		/**
		 * Creates a DTO of type "LayerLightDTO".
		 *
		 * @return the created DTO
		 */
		@Override
		public LayerLightDTO createDto() {
			return new LayerLightDTO();
		}
		
	}
	
	/**
	 * Provides the corresponding FieldInfoContext of this DTO.
	 *
	 * @return the corresponding FieldInfoContext object
	 */
	public LayerLightDTO.FieldInfoContext getFieldInfoContext() {
		return getFieldInfoContextInstance(LayerLightDTO.FieldInfoContext.class);
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
	
	
	// name
	
	private String name;
	
	/**
	 * Getter for property "name".
	 *
	 * @return the value of property "name"
	 */
	@JsonProperty
	public String getName() {
		return this.name;
	}
	
	/**
	 * Setter for property "name".
	 *
	 * @param name the new value for property "name"
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	
	// type
	
	private String type;
	
	/**
	 * Getter for property "type".
	 *
	 * @return the value of property "type"
	 */
	@JsonProperty
	public String getType() {
		return this.type;
	}
	
	/**
	 * Used for loading the property type from a given internal entity.
	 * 
	 * @param layer the given internal entity
	 * @return the value of property type based on the given internal entity
	 */
	protected abstract String load_Type(Layer layer);
	
	
	// childCount
	
	private java.lang.Integer childCount;
	
	/**
	 * Getter for property "childCount".
	 *
	 * @return the value of property "childCount"
	 */
	@JsonProperty
	public java.lang.Integer getChildCount() {
		return this.childCount;
	}
	
	/**
	 * Used for loading the property childCount from a given internal entity.
	 * 
	 * @param layer the given internal entity
	 * @return the value of property childCount based on the given internal entity
	 */
	protected abstract java.lang.Integer load_ChildCount(Layer layer);
	
	
	// secret
	
	private java.lang.Boolean secret;
	
	/**
	 * Getter for property "secret".
	 *
	 * @return the value of property "secret"
	 */
	@JsonProperty
	public java.lang.Boolean isSecret() {
		return this.secret;
	}
	
	/**
	 * Used for loading the property secret from a given internal entity.
	 * 
	 * @param layer the given internal entity
	 * @return the value of property secret based on the given internal entity
	 */
	protected abstract java.lang.Boolean load_Secret(Layer layer);
	
	
	// isLabeled
	
	private java.lang.Boolean isLabeled;
	
	/**
	 * Getter for property "isLabeled".
	 *
	 * @return the value of property "isLabeled"
	 */
	@JsonProperty
	public java.lang.Boolean isIsLabeled() {
		return this.isLabeled;
	}
	
	/**
	 * Used for loading the property isLabeled from a given internal entity.
	 * 
	 * @param layer the given internal entity
	 * @return the value of property isLabeled based on the given internal entity
	 */
	protected abstract java.lang.Boolean load_IsLabeled(Layer layer);
	
	
	// formSchemaKey
	
	private String formSchemaKey;
	
	/**
	 * Getter for property "formSchemaKey".
	 *
	 * @return the value of property "formSchemaKey"
	 */
	@JsonProperty
	public String getFormSchemaKey() {
		return this.formSchemaKey;
	}
	
	/**
	 * Used for loading the property formSchemaKey from a given internal entity.
	 * 
	 * @param layer the given internal entity
	 * @return the value of property formSchemaKey based on the given internal entity
	 */
	protected abstract String load_FormSchemaKey(Layer layer);
	
	
	
	/////////////////////////
	// save/load functions //
	/////////////////////////
	
	/**
	 * Loads this DTO from an entity object of type "Layer".
	 * 
	 * @param layer the entity object from which this DTO is loaded. 
	 */
	@Override
	public void loadFrom(Layer layer) {
		this.uid = layer.getExtuid();
		this.name = layer.getName();
		this.type = this.load_Type(layer);
		this.childCount = this.load_ChildCount(layer);
		this.secret = this.load_Secret(layer);
		this.isLabeled = this.load_IsLabeled(layer);
		this.formSchemaKey = this.load_FormSchemaKey(layer);
	}
	
	/**
	 * Saves this DTO to an entity object of type "Layer".
	 * 
	 * @param layer the entity object to which this DTO is saved. 
	 * @throws BadDtoEntityModificationException If this DTO is not valid for saving. 
	 */
	@Override
	public void saveTo(Layer layer) throws ir.viratech.commons.api.entity_modifier.BadDtoEntityModificationException {
		//Disabled save for property: uid
		layer.setName(this.name);
		//Disabled save for property: type
		//Disabled save for property: childCount
		//Disabled save for property: secret
		//Disabled save for property: isLabeled
		//Disabled save for property: formSchemaKey
	}
	
	
	
	//////////////
	// toString //
	//////////////
	
	@Override
	protected Map<String, Object> toStringData() {
		Map<String, Object> data = super.toStringData();
		data.put("uid", this.uid);
		data.put("name", this.name);
		data.put("type", this.type);
		data.put("childCount", this.childCount);
		data.put("secret", this.secret);
		data.put("isLabeled", this.isLabeled);
		data.put("formSchemaKey", this.formSchemaKey);
		return data;
	}
	
}
