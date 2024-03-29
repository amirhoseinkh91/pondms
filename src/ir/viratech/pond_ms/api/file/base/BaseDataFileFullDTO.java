package ir.viratech.pond_ms.api.file.base;

import static ir.viratech.commons.api.field_info.FieldInfoContextProvider.getFieldInfoContextInstance;
import ir.viratech.pond_ms.api.file.dto.DataFileFullDTO;
import ir.viratech.pond_ms.model.file.DataFile;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * A base DTO for class "DataFile".
 * Do not edit this file.
 * It is an automatically generated class.
 *
 */
public abstract class BaseDataFileFullDTO extends ir.viratech.commons.api.dto.AbstractFullDTO<DataFile> {
	
	
	/**
	 * 
	 * Base FieldInfoContext for "DataFileFullDTO".
	 *
	 */
	public static abstract class BaseFieldInfoContext extends ir.viratech.commons.api.search.field.AbstractFieldInfoContext<DataFileFullDTO> {
		
		
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
		 * creates a PrimitiveFieldInfo for primitive property "hash".
		 * @param externalName the external name of the property in the DTO class
		 * @param internalName the internal name of the property in the entity class
		 * @param internalSearchExpression the internal search expression by which the property could be really searched
		 * @param typeKey a key showing the type of the property (used in client side) 
		 * @param bundleKey Used for i18n translation of the property
		 * @param searchable true if the property could be accessed in client search queries
		 * @param sortable true if the property could be used for sorting in client search queries
		 * @return the FieldInfo created for the property
		 */
		protected ir.viratech.commons.api.search.field.PrimitiveFieldInfo<?> createFieldInfo_Hash(
				String externalName, String internalName, String internalSearchExpression, String typeKey, String bundleKey, boolean searchable, Boolean sortable) {
			return new ir.viratech.commons.api.search.field.types.FieldInfo_String(externalName, internalName, internalSearchExpression, typeKey, bundleKey, searchable, sortable);
		}
		
		
		/**
		 * creates a PrimitiveFieldInfo for primitive property "dataReference".
		 * @param externalName the external name of the property in the DTO class
		 * @param internalName the internal name of the property in the entity class
		 * @param internalSearchExpression the internal search expression by which the property could be really searched
		 * @param typeKey a key showing the type of the property (used in client side) 
		 * @param bundleKey Used for i18n translation of the property
		 * @param searchable true if the property could be accessed in client search queries
		 * @param sortable true if the property could be used for sorting in client search queries
		 * @return the FieldInfo created for the property
		 */
		protected ir.viratech.commons.api.search.field.PrimitiveFieldInfo<?> createFieldInfo_DataReference(
				String externalName, String internalName, String internalSearchExpression, String typeKey, String bundleKey, boolean searchable, Boolean sortable) {
			return new ir.viratech.commons.api.search.field.types.FieldInfo_String(externalName, internalName, internalSearchExpression, typeKey, bundleKey, searchable, sortable);
		}
		
		
		/**
		 * creates a PrimitiveFieldInfo for primitive property "dataCollectionDate".
		 * @param externalName the external name of the property in the DTO class
		 * @param internalName the internal name of the property in the entity class
		 * @param internalSearchExpression the internal search expression by which the property could be really searched
		 * @param typeKey a key showing the type of the property (used in client side) 
		 * @param bundleKey Used for i18n translation of the property
		 * @param searchable true if the property could be accessed in client search queries
		 * @param sortable true if the property could be used for sorting in client search queries
		 * @return the FieldInfo created for the property
		 */
		protected ir.viratech.commons.api.search.field.PrimitiveFieldInfo<?> createFieldInfo_DataCollectionDate(
				String externalName, String internalName, String internalSearchExpression, String typeKey, String bundleKey, boolean searchable, Boolean sortable) {
			return new ir.viratech.commons.api.search.field.types.FieldInfo_Timestamp(externalName, internalName, internalSearchExpression, typeKey, bundleKey, searchable, sortable);
		}
		
		
		// =========== END createFieldInfo methods ===========
		
		/**
		 * The default constructor for BaseFieldInfoContext.
		 */
		protected BaseFieldInfoContext() {
			this.putFieldInfo(this.createFieldInfo_Uid("uid", "extuid", "extuid", null, "uid", true, false));
			this.putFieldInfo(this.createFieldInfo_Name("name", "name", "name", null, "name", true, null));
			this.putFieldInfo(this.createFieldInfo_Hash("hash", "hash", "hash", null, "hash", true, null));
			this.putFieldInfo(this.createFieldInfo_DataReference("dataReference", "dataReference", "dataReference", null, "dataReference", true, null));
			this.putFieldInfo(this.createFieldInfo_DataCollectionDate("dataCollectionDate", "dataCollectionDate", "dataCollectionDate", null, "dataCollectionDate", true, null));
		}
		
		/**
		 * Creates a DTO of type "DataFileFullDTO".
		 *
		 * @return the created DTO
		 */
		@Override
		public DataFileFullDTO createDto() {
			return new DataFileFullDTO();
		}
		
	}
	
	/**
	 * Provides the corresponding FieldInfoContext of this DTO.
	 *
	 * @return the corresponding FieldInfoContext object
	 */
	public DataFileFullDTO.FieldInfoContext getFieldInfoContext() {
		return getFieldInfoContextInstance(DataFileFullDTO.FieldInfoContext.class);
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
	 * Used for loading the property name from a given internal entity.
	 * 
	 * @param dataFile the given internal entity
	 * @return the value of property name based on the given internal entity
	 */
	protected abstract String load_Name(DataFile dataFile);
	
	
	// hash
	
	private String hash;
	
	/**
	 * Getter for property "hash".
	 *
	 * @return the value of property "hash"
	 */
	@JsonProperty
	public String getHash() {
		return this.hash;
	}
	
	/**
	 * Used for loading the property hash from a given internal entity.
	 * 
	 * @param dataFile the given internal entity
	 * @return the value of property hash based on the given internal entity
	 */
	protected abstract String load_Hash(DataFile dataFile);
	
	
	// dataReference
	
	private String dataReference;
	
	/**
	 * Getter for property "dataReference".
	 *
	 * @return the value of property "dataReference"
	 */
	@JsonProperty
	public String getDataReference() {
		return this.dataReference;
	}
	
	/**
	 * Setter for property "dataReference".
	 *
	 * @param dataReference the new value for property "dataReference"
	 */
	public void setDataReference(String dataReference) {
		this.dataReference = dataReference;
	}
	
	
	// dataCollectionDate
	
	private java.util.Date dataCollectionDate;
	
	/**
	 * Getter for property "dataCollectionDate".
	 *
	 * @return the value of property "dataCollectionDate"
	 */
	@JsonProperty
	public java.util.Date getDataCollectionDate() {
		return this.dataCollectionDate;
	}
	
	/**
	 * Setter for property "dataCollectionDate".
	 *
	 * @param dataCollectionDate the new value for property "dataCollectionDate"
	 */
	public void setDataCollectionDate(java.util.Date dataCollectionDate) {
		this.dataCollectionDate = dataCollectionDate;
	}
	
	
	
	/////////////////////////
	// save/load functions //
	/////////////////////////
	
	/**
	 * Loads this DTO from an entity object of type "DataFile".
	 * 
	 * @param dataFile the entity object from which this DTO is loaded. 
	 */
	@Override
	public void loadFrom(DataFile dataFile) {
		this.uid = dataFile.getExtuid();
		this.name = this.load_Name(dataFile);
		this.hash = this.load_Hash(dataFile);
		this.dataReference = dataFile.getDataReference();
		this.dataCollectionDate = dataFile.getDataCollectionDate();
	}
	
	/**
	 * Saves this DTO to an entity object of type "DataFile".
	 * 
	 * @param dataFile the entity object to which this DTO is saved. 
	 * @throws BadDtoEntityModificationException If this DTO is not valid for saving. 
	 */
	@Override
	public void saveTo(DataFile dataFile) throws ir.viratech.commons.api.entity_modifier.BadDtoEntityModificationException {
		//Disabled save for property: uid
		//Disabled save for property: name
		//Disabled save for property: hash
		dataFile.setDataReference(this.dataReference);
		dataFile.setDataCollectionDate(this.dataCollectionDate);
	}
	
	
	
	//////////////
	// toString //
	//////////////
	
	@Override
	protected Map<String, Object> toStringData() {
		Map<String, Object> data = super.toStringData();
		data.put("uid", this.uid);
		data.put("name", this.name);
		data.put("hash", this.hash);
		data.put("dataReference", this.dataReference);
		data.put("dataCollectionDate", this.dataCollectionDate);
		return data;
	}
	
}
