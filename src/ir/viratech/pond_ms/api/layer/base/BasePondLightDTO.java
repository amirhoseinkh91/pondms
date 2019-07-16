package ir.viratech.pond_ms.api.layer.base;

import static ir.viratech.commons.api.field_info.FieldInfoContextProvider.getFieldInfoContextInstance;
import ir.viratech.pond_ms.api.layer.dto.PondLightDTO;
import ir.viratech.pond_ms.model.layer.Pond;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * A base DTO for class "Pond".
 * Do not edit this file.
 * It is an automatically generated class.
 *
 */
public abstract class BasePondLightDTO extends ir.viratech.commons.api.dto.AbstractFullDTO<Pond> {
	
	
	/**
	 * 
	 * Base FieldInfoContext for "PondLightDTO".
	 *
	 */
	public static abstract class BaseFieldInfoContext extends ir.viratech.commons.api.search.field.AbstractFieldInfoContext<PondLightDTO> {
		
		
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
		
		
		// =========== END createFieldInfo methods ===========
		
		/**
		 * The default constructor for BaseFieldInfoContext.
		 */
		protected BaseFieldInfoContext() {
			this.putFieldInfo(this.createFieldInfo_Uid("uid", "extuid", "extuid", null, "uid", true, false));
			this.putFieldInfo(this.createFieldInfo_Title("title", "title", "title", null, "title", true, null));
		}
		
		/**
		 * Creates a DTO of type "PondLightDTO".
		 *
		 * @return the created DTO
		 */
		@Override
		public PondLightDTO createDto() {
			return new PondLightDTO();
		}
		
	}
	
	/**
	 * Provides the corresponding FieldInfoContext of this DTO.
	 *
	 * @return the corresponding FieldInfoContext object
	 */
	public PondLightDTO.FieldInfoContext getFieldInfoContext() {
		return getFieldInfoContextInstance(PondLightDTO.FieldInfoContext.class);
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
	
	
	
	/////////////////////////
	// save/load functions //
	/////////////////////////
	
	/**
	 * Loads this DTO from an entity object of type "Pond".
	 * 
	 * @param pond the entity object from which this DTO is loaded. 
	 */
	@Override
	public void loadFrom(Pond pond) {
		this.uid = pond.getExtuid();
		this.title = pond.getTitle();
	}
	
	/**
	 * Saves this DTO to an entity object of type "Pond".
	 * 
	 * @param pond the entity object to which this DTO is saved. 
	 * @throws BadDtoEntityModificationException If this DTO is not valid for saving. 
	 */
	@Override
	public void saveTo(Pond pond) throws ir.viratech.commons.api.entity_modifier.BadDtoEntityModificationException {
		//Disabled save for property: uid
		pond.setTitle(this.title);
	}
	
	
	
	//////////////
	// toString //
	//////////////
	
	@Override
	protected Map<String, Object> toStringData() {
		Map<String, Object> data = super.toStringData();
		data.put("uid", this.uid);
		data.put("title", this.title);
		return data;
	}
	
}
