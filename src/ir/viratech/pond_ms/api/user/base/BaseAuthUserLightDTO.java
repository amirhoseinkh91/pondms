package ir.viratech.pond_ms.api.user.base;

import static ir.viratech.commons.api.field_info.FieldInfoContextProvider.getFieldInfoContextInstance;
import ir.viratech.pond_ms.api.user.dto.AuthUserLightDTO;
import ir.viratech.pond_ms.model.user.AuthUser;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * A base DTO for class "AuthUser".
 * Do not edit this file.
 * It is an automatically generated class.
 *
 */
public abstract class BaseAuthUserLightDTO extends ir.viratech.commons.api.dto.AbstractFullDTO<AuthUser> {
	
	
	/**
	 * 
	 * Base FieldInfoContext for "AuthUserLightDTO".
	 *
	 */
	public static abstract class BaseFieldInfoContext extends ir.viratech.commons.api.search.field.AbstractFieldInfoContext<AuthUserLightDTO> {
		
		
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
		 * creates a PrimitiveFieldInfo for primitive property "username".
		 * @param externalName the external name of the property in the DTO class
		 * @param internalName the internal name of the property in the entity class
		 * @param internalSearchExpression the internal search expression by which the property could be really searched
		 * @param typeKey a key showing the type of the property (used in client side) 
		 * @param bundleKey Used for i18n translation of the property
		 * @param searchable true if the property could be accessed in client search queries
		 * @param sortable true if the property could be used for sorting in client search queries
		 * @return the FieldInfo created for the property
		 */
		protected ir.viratech.commons.api.search.field.PrimitiveFieldInfo<?> createFieldInfo_Username(
				String externalName, String internalName, String internalSearchExpression, String typeKey, String bundleKey, boolean searchable, Boolean sortable) {
			return new ir.viratech.commons.api.search.field.types.FieldInfo_String(externalName, internalName, internalSearchExpression, typeKey, bundleKey, searchable, sortable);
		}
		
		
		// =========== END createFieldInfo methods ===========
		
		/**
		 * The default constructor for BaseFieldInfoContext.
		 */
		protected BaseFieldInfoContext() {
			this.putFieldInfo(this.createFieldInfo_Uid("uid", "extuid", "extuid", null, "uid", false, false));
			this.putFieldInfo(this.createFieldInfo_Username("username", "username", "username", null, "username", true, null));
		}
		
		/**
		 * Creates a DTO of type "AuthUserLightDTO".
		 *
		 * @return the created DTO
		 */
		@Override
		public AuthUserLightDTO createDto() {
			return new AuthUserLightDTO();
		}
		
	}
	
	/**
	 * Provides the corresponding FieldInfoContext of this DTO.
	 *
	 * @return the corresponding FieldInfoContext object
	 */
	public AuthUserLightDTO.FieldInfoContext getFieldInfoContext() {
		return getFieldInfoContextInstance(AuthUserLightDTO.FieldInfoContext.class);
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
	
	
	// username
	
	private String username;
	
	/**
	 * Getter for property "username".
	 *
	 * @return the value of property "username"
	 */
	@JsonProperty
	public String getUsername() {
		return this.username;
	}
	
	/**
	 * Setter for property "username".
	 *
	 * @param username the new value for property "username"
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	
	
	/////////////////////////
	// save/load functions //
	/////////////////////////
	
	/**
	 * Loads this DTO from an entity object of type "AuthUser".
	 * 
	 * @param authUser the entity object from which this DTO is loaded. 
	 */
	@Override
	public void loadFrom(AuthUser authUser) {
		this.uid = authUser.getExtuid();
		this.username = authUser.getUsername();
	}
	
	/**
	 * Saves this DTO to an entity object of type "AuthUser".
	 * 
	 * @param authUser the entity object to which this DTO is saved. 
	 * @throws BadDtoEntityModificationException If this DTO is not valid for saving. 
	 */
	@Override
	public void saveTo(AuthUser authUser) throws ir.viratech.commons.api.entity_modifier.BadDtoEntityModificationException {
		//Disabled save for property: uid
		authUser.setUsername(this.username);
	}
	
	
	
	//////////////
	// toString //
	//////////////
	
	@Override
	protected Map<String, Object> toStringData() {
		Map<String, Object> data = super.toStringData();
		data.put("uid", this.uid);
		data.put("username", this.username);
		return data;
	}
	
}
