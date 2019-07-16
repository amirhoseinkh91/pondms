package ir.viratech.pond_ms.api.app_message.base;

import static ir.viratech.commons.api.field_info.FieldInfoContextProvider.getFieldInfoContextInstance;
import ir.viratech.pond_ms.api.app_message.dto.AppMessageFullDTO;
import ir.viratech.pond_ms.model.app_message.AppMessage;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * A base DTO for class "AppMessage".
 * Do not edit this file.
 * It is an automatically generated class.
 *
 */
public abstract class BaseAppMessageFullDTO extends ir.viratech.commons.api.dto.AbstractFullDTO<AppMessage> {
	
	
	/**
	 * 
	 * Base FieldInfoContext for "AppMessageFullDTO".
	 *
	 */
	public static abstract class BaseFieldInfoContext extends ir.viratech.commons.api.search.field.AbstractFieldInfoContext<AppMessageFullDTO> {
		
		
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
		 * creates a PrimitiveFieldInfo for primitive property "message".
		 * @param externalName the external name of the property in the DTO class
		 * @param internalName the internal name of the property in the entity class
		 * @param internalSearchExpression the internal search expression by which the property could be really searched
		 * @param typeKey a key showing the type of the property (used in client side) 
		 * @param bundleKey Used for i18n translation of the property
		 * @param searchable true if the property could be accessed in client search queries
		 * @param sortable true if the property could be used for sorting in client search queries
		 * @return the FieldInfo created for the property
		 */
		protected ir.viratech.commons.api.search.field.PrimitiveFieldInfo<?> createFieldInfo_Message(
				String externalName, String internalName, String internalSearchExpression, String typeKey, String bundleKey, boolean searchable, Boolean sortable) {
			return new ir.viratech.commons.api.search.field.types.FieldInfo_String(externalName, internalName, internalSearchExpression, typeKey, bundleKey, searchable, sortable);
		}
		
		
		/**
		 * creates a PrimitiveFieldInfo for primitive property "creationDate".
		 * @param externalName the external name of the property in the DTO class
		 * @param internalName the internal name of the property in the entity class
		 * @param internalSearchExpression the internal search expression by which the property could be really searched
		 * @param typeKey a key showing the type of the property (used in client side) 
		 * @param bundleKey Used for i18n translation of the property
		 * @param searchable true if the property could be accessed in client search queries
		 * @param sortable true if the property could be used for sorting in client search queries
		 * @return the FieldInfo created for the property
		 */
		protected ir.viratech.commons.api.search.field.PrimitiveFieldInfo<?> createFieldInfo_CreationDate(
				String externalName, String internalName, String internalSearchExpression, String typeKey, String bundleKey, boolean searchable, Boolean sortable) {
			return new ir.viratech.commons.api.search.field.types.FieldInfo_String(externalName, internalName, internalSearchExpression, typeKey, bundleKey, searchable, sortable);
		}
		
		
		/**
		 * creates a PrimitiveFieldInfo for primitive property "expirationDate".
		 * @param externalName the external name of the property in the DTO class
		 * @param internalName the internal name of the property in the entity class
		 * @param internalSearchExpression the internal search expression by which the property could be really searched
		 * @param typeKey a key showing the type of the property (used in client side) 
		 * @param bundleKey Used for i18n translation of the property
		 * @param searchable true if the property could be accessed in client search queries
		 * @param sortable true if the property could be used for sorting in client search queries
		 * @return the FieldInfo created for the property
		 */
		protected ir.viratech.commons.api.search.field.PrimitiveFieldInfo<?> createFieldInfo_ExpirationDate(
				String externalName, String internalName, String internalSearchExpression, String typeKey, String bundleKey, boolean searchable, Boolean sortable) {
			return new ir.viratech.commons.api.search.field.types.FieldInfo_Timestamp(externalName, internalName, internalSearchExpression, typeKey, bundleKey, searchable, sortable);
		}
		
		
		/**
		 * creates a PrimitiveFieldInfo for primitive property "enabled".
		 * @param externalName the external name of the property in the DTO class
		 * @param internalName the internal name of the property in the entity class
		 * @param internalSearchExpression the internal search expression by which the property could be really searched
		 * @param typeKey a key showing the type of the property (used in client side) 
		 * @param bundleKey Used for i18n translation of the property
		 * @param searchable true if the property could be accessed in client search queries
		 * @param sortable true if the property could be used for sorting in client search queries
		 * @return the FieldInfo created for the property
		 */
		protected ir.viratech.commons.api.search.field.PrimitiveFieldInfo<?> createFieldInfo_Enabled(
				String externalName, String internalName, String internalSearchExpression, String typeKey, String bundleKey, boolean searchable, Boolean sortable) {
			return new ir.viratech.commons.api.search.field.types.FieldInfo_Boolean(externalName, internalName, internalSearchExpression, typeKey, bundleKey, searchable, sortable);
		}
		
		
		/**
		 * creates a PrimitiveFieldInfo for primitive property "videoUrl".
		 * @param externalName the external name of the property in the DTO class
		 * @param internalName the internal name of the property in the entity class
		 * @param internalSearchExpression the internal search expression by which the property could be really searched
		 * @param typeKey a key showing the type of the property (used in client side) 
		 * @param bundleKey Used for i18n translation of the property
		 * @param searchable true if the property could be accessed in client search queries
		 * @param sortable true if the property could be used for sorting in client search queries
		 * @return the FieldInfo created for the property
		 */
		protected ir.viratech.commons.api.search.field.PrimitiveFieldInfo<?> createFieldInfo_VideoUrl(
				String externalName, String internalName, String internalSearchExpression, String typeKey, String bundleKey, boolean searchable, Boolean sortable) {
			return new ir.viratech.commons.api.search.field.types.FieldInfo_String(externalName, internalName, internalSearchExpression, typeKey, bundleKey, searchable, sortable);
		}
		
		
		/**
		 * creates a PrimitiveFieldInfo for primitive property "videoOnly".
		 * @param externalName the external name of the property in the DTO class
		 * @param internalName the internal name of the property in the entity class
		 * @param internalSearchExpression the internal search expression by which the property could be really searched
		 * @param typeKey a key showing the type of the property (used in client side) 
		 * @param bundleKey Used for i18n translation of the property
		 * @param searchable true if the property could be accessed in client search queries
		 * @param sortable true if the property could be used for sorting in client search queries
		 * @return the FieldInfo created for the property
		 */
		protected ir.viratech.commons.api.search.field.PrimitiveFieldInfo<?> createFieldInfo_VideoOnly(
				String externalName, String internalName, String internalSearchExpression, String typeKey, String bundleKey, boolean searchable, Boolean sortable) {
			return new ir.viratech.commons.api.search.field.types.FieldInfo_Boolean(externalName, internalName, internalSearchExpression, typeKey, bundleKey, searchable, sortable);
		}
		
		
		/**
		 * creates a PrimitiveFieldInfo for primitive property "urls".
		 * @param externalName the external name of the property in the DTO class
		 * @param internalName the internal name of the property in the entity class
		 * @param internalSearchExpression the internal search expression by which the property could be really searched
		 * @param typeKey a key showing the type of the property (used in client side) 
		 * @param bundleKey Used for i18n translation of the property
		 * @param searchable true if the property could be accessed in client search queries
		 * @param sortable true if the property could be used for sorting in client search queries
		 * @return the FieldInfo created for the property
		 */
		protected ir.viratech.commons.api.search.field.PrimitiveFieldInfo<?> createFieldInfo_Urls(
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
			this.putFieldInfo(this.createFieldInfo_Message("message", "message", "message", null, "message", true, null));
			this.putFieldInfo(this.createFieldInfo_CreationDate("creationDate", "creationDateString", "creationDateString", null, "creationDate", true, null));
			this.putFieldInfo(this.createFieldInfo_ExpirationDate("expirationDate", "expirationDate", "expirationDate", null, "expirationDate", true, null));
			this.putFieldInfo(this.createFieldInfo_Enabled("enabled", "enabled", "enabled", null, "enabled", true, null));
			//Disabled fieldInfo for property: images
			this.putFieldInfo(this.createFieldInfo_VideoUrl("videoUrl", "videoUrl", "videoUrl", null, "videoUrl", true, null));
			this.putFieldInfo(this.createFieldInfo_VideoOnly("videoOnly", "videoOnly", "videoOnly", null, "videoOnly", true, null));
			this.putFieldInfo(this.createFieldInfo_Urls("urls", "urls", "urls", null, "urls", true, null));
		}
		
		/**
		 * Creates a DTO of type "AppMessageFullDTO".
		 *
		 * @return the created DTO
		 */
		@Override
		public AppMessageFullDTO createDto() {
			return new AppMessageFullDTO();
		}
		
	}
	
	/**
	 * Provides the corresponding FieldInfoContext of this DTO.
	 *
	 * @return the corresponding FieldInfoContext object
	 */
	public AppMessageFullDTO.FieldInfoContext getFieldInfoContext() {
		return getFieldInfoContextInstance(AppMessageFullDTO.FieldInfoContext.class);
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
	
	
	// message
	
	private String message;
	
	/**
	 * Getter for property "message".
	 *
	 * @return the value of property "message"
	 */
	@JsonProperty
	public String getMessage() {
		return this.message;
	}
	
	/**
	 * Setter for property "message".
	 *
	 * @param message the new value for property "message"
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	// creationDate
	
	private String creationDate;
	
	/**
	 * Getter for property "creationDate".
	 *
	 * @return the value of property "creationDate"
	 */
	@JsonProperty
	public String getCreationDate() {
		return this.creationDate;
	}
	
	
	// expirationDate
	
	private java.util.Date expirationDate;
	
	/**
	 * Getter for property "expirationDate".
	 *
	 * @return the value of property "expirationDate"
	 */
	@JsonProperty
	public java.util.Date getExpirationDate() {
		return this.expirationDate;
	}
	
	/**
	 * Setter for property "expirationDate".
	 *
	 * @param expirationDate the new value for property "expirationDate"
	 */
	public void setExpirationDate(java.util.Date expirationDate) {
		this.expirationDate = expirationDate;
	}
	
	
	// enabled
	
	private boolean enabled;
	
	/**
	 * Getter for property "enabled".
	 *
	 * @return the value of property "enabled"
	 */
	@JsonProperty
	public boolean isEnabled() {
		return this.enabled;
	}
	
	/**
	 * Setter for property "enabled".
	 *
	 * @param enabled the new value for property "enabled"
	 */
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	
	// images
	
	private java.util.Set<java.lang.String> images;
	
	/**
	 * Getter for property "images".
	 *
	 * @return the value of property "images"
	 */
	@JsonProperty
	public java.util.Set<java.lang.String> getImages() {
		return this.images;
	}
	
	/**
	 * Setter for property "images".
	 *
	 * @param images the new value for property "images"
	 */
	public void setImages(java.util.Set<java.lang.String> images) {
		this.images = images;
	}
	
	/**
	 * Used for loading the property images from a given internal entity.
	 * 
	 * @param appMessage the given internal entity
	 * @return the value of property images based on the given internal entity
	 */
	protected abstract java.util.Set<java.lang.String> load_Images(AppMessage appMessage);
	
	/**
	/**
	 * Used for saving a given value of property images to a given internal entity.
	 * 
	 * @param appMessage
	 * 		the given internal entity
	 * @param images 
	 * 		the value of property images which should be saved to the given internal entity
	 * @throws ir.viratech.commons.api.entity_modifier.BadDtoEntityModificationException 
	 * 		if the given value of property images is not appropriate for saving the entity
	 */
	protected abstract void save_Images(AppMessage appMessage, java.util.Set<java.lang.String> images)
			throws ir.viratech.commons.api.entity_modifier.BadDtoEntityModificationException;
	
	
	// videoUrl
	
	private String videoUrl;
	private boolean __modified__VideoUrl = false;
	
	/**
	 * Getter for property "videoUrl".
	 *
	 * @return the value of property "videoUrl"
	 */
	@JsonProperty
	public String getVideoUrl() {
		return this.videoUrl;
	}
	
	/**
	 * Setter for property "videoUrl".
	 *
	 * @param videoUrl the new value for property "videoUrl"
	 */
	public void setVideoUrl(String videoUrl) {
		this.__modified__VideoUrl = true;
		this.videoUrl = videoUrl;
	}
	
	/**
	 * Shows the modification state of the property "videoUrl".
	 * 
	 * @return true if the property is modified
	 */
	public boolean hasModifiedVideoUrl() {
		return this.__modified__VideoUrl;
	}
	
	
	// videoOnly
	
	private boolean videoOnly;
	
	/**
	 * Getter for property "videoOnly".
	 *
	 * @return the value of property "videoOnly"
	 */
	@JsonProperty
	public boolean isVideoOnly() {
		return this.videoOnly;
	}
	
	/**
	 * Setter for property "videoOnly".
	 *
	 * @param videoOnly the new value for property "videoOnly"
	 */
	public void setVideoOnly(boolean videoOnly) {
		this.videoOnly = videoOnly;
	}
	
	
	// urls
	
	private java.util.List<java.lang.String> urls;
	
	/**
	 * Getter for property "urls".
	 *
	 * @return the value of property "urls"
	 */
	@JsonProperty
	public java.util.List<java.lang.String> getUrls() {
		return this.urls;
	}
	
	/**
	 * Setter for property "urls".
	 *
	 * @param urls the new value for property "urls"
	 */
	public void setUrls(java.util.List<java.lang.String> urls) {
		this.urls = urls;
	}
	
	/**
	 * Used for loading the property urls from a given internal entity.
	 * 
	 * @param appMessage the given internal entity
	 * @return the value of property urls based on the given internal entity
	 */
	protected abstract java.util.List<java.lang.String> load_Urls(AppMessage appMessage);
	
	/**
	/**
	 * Used for saving a given value of property urls to a given internal entity.
	 * 
	 * @param appMessage
	 * 		the given internal entity
	 * @param urls 
	 * 		the value of property urls which should be saved to the given internal entity
	 * @throws ir.viratech.commons.api.entity_modifier.BadDtoEntityModificationException 
	 * 		if the given value of property urls is not appropriate for saving the entity
	 */
	protected abstract void save_Urls(AppMessage appMessage, java.util.List<java.lang.String> urls)
			throws ir.viratech.commons.api.entity_modifier.BadDtoEntityModificationException;
	
	
	
	/////////////////////////
	// save/load functions //
	/////////////////////////
	
	/**
	 * Loads this DTO from an entity object of type "AppMessage".
	 * 
	 * @param appMessage the entity object from which this DTO is loaded. 
	 */
	@Override
	public void loadFrom(AppMessage appMessage) {
		this.uid = appMessage.getExtuid();
		this.title = appMessage.getTitle();
		this.message = appMessage.getMessage();
		this.creationDate = appMessage.getCreationDateString();
		this.expirationDate = appMessage.getExpirationDate();
		this.enabled = appMessage.isEnabled();
		this.images = this.load_Images(appMessage);
		this.videoUrl = appMessage.getVideoUrl();
		this.videoOnly = appMessage.isVideoOnly();
		this.urls = this.load_Urls(appMessage);
	}
	
	/**
	 * Saves this DTO to an entity object of type "AppMessage".
	 * 
	 * @param appMessage the entity object to which this DTO is saved. 
	 * @throws BadDtoEntityModificationException If this DTO is not valid for saving. 
	 */
	@Override
	public void saveTo(AppMessage appMessage) throws ir.viratech.commons.api.entity_modifier.BadDtoEntityModificationException {
		//Disabled save for property: uid
		appMessage.setTitle(this.title);
		appMessage.setMessage(this.message);
		//Disabled save for property: creationDate
		appMessage.setExpirationDate(this.expirationDate);
		appMessage.setEnabled(this.enabled);
		this.save_Images(appMessage, this.images);
		if (this.hasModifiedVideoUrl()) {
			appMessage.setVideoUrl(this.videoUrl);
		}
		appMessage.setVideoOnly(this.videoOnly);
		this.save_Urls(appMessage, this.urls);
	}
	
	
	
	//////////////
	// toString //
	//////////////
	
	@Override
	protected Map<String, Object> toStringData() {
		Map<String, Object> data = super.toStringData();
		data.put("uid", this.uid);
		data.put("title", this.title);
		data.put("message", this.message);
		data.put("creationDate", this.creationDate);
		data.put("expirationDate", this.expirationDate);
		data.put("enabled", this.enabled);
		data.put("images", this.images);
		data.put("videoUrl", this.videoUrl);
		data.put("videoOnly", this.videoOnly);
		data.put("urls", this.urls);
		return data;
	}
	
}
