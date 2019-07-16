package ir.viratech.pond_ms.model.app_message.base;

import java.io.Serializable;


/**
 *  Base class for entity "ir.viratech.pond_ms.model.app_message.AppMessage".
 *  It is an automatically generated file and should not be edited.
 *
 * @hibernate.class
 *  table="pond_ms.APP_MESSAGES"
 */

public abstract class BaseAppMessage  implements Serializable {
	private static final long serialVersionUID = 1L;


	/** The constant referring the name of class "AppMessage". */
	public static final String REF = "AppMessage";
	
	/** The constant referring the property "id". */
	public static final String PROP_ID = "id";
	
	/** The constant referring the property "extuid". */
	public static final String PROP_EXTUID = "extuid";
	
	/** The constant referring the property "title". */
	public static final String PROP_TITLE = "title";
	
	/** The constant referring the property "message". */
	public static final String PROP_MESSAGE = "message";
	
	/** The constant referring the property "creationDate". */
	public static final String PROP_CREATION_DATE = "creationDate";
	
	/** The constant referring the property "expirationDate". */
	public static final String PROP_EXPIRATION_DATE = "expirationDate";
	
	/** The constant referring the property "enabled". */
	public static final String PROP_ENABLED = "enabled";
	
	/** The constant referring the property "videoUrl". */
	public static final String PROP_VIDEO_URL = "videoUrl";
	
	/** The constant referring the property "videoOnly". */
	public static final String PROP_VIDEO_ONLY = "videoOnly";
	
	/** The constant referring the property "images". */
	public static final String PROP_IMAGES = "images";
	
	/** The constant referring the property "urls". */
	public static final String PROP_URLS = "urls";
	
	
	/** The name of table for this class. */
	public static final String TABLE = "pond_ms.APP_MESSAGES";
	
	/** Name of column referring the property "id". */
	public static final String PROPCOLUMN_ID = "id";
	
	/** Name of column referring the property "extuid". */
	public static final String PROPCOLUMN_EXTUID = "extuid";
	
	/** Name of column referring the property "title". */
	public static final String PROPCOLUMN_TITLE = "title";
	
	/** Name of column referring the property "message". */
	public static final String PROPCOLUMN_MESSAGE = "message";
	
	/** Name of column referring the property "creationDate". */
	public static final String PROPCOLUMN_CREATION_DATE = "creationDate";
	
	/** Name of column referring the property "expirationDate". */
	public static final String PROPCOLUMN_EXPIRATION_DATE = "expirationDate";
	
	/** Name of column referring the property "enabled". */
	public static final String PROPCOLUMN_ENABLED = "enabled";
	
	/** Name of column referring the property "videoUrl". */
	public static final String PROPCOLUMN_VIDEO_URL = "videoUrl";
	
	/** Name of column referring the property "videoOnly". */
	public static final String PROPCOLUMN_VIDEO_ONLY = "videoOnly";
	
	/** Name of table referring the property "images". */
	public static final String PROPTABLE_IMAGES = "pond_ms.APP_MESSAGES_IMAGES";
	
	

	
	
	


	private int hashCode_ = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
	private java.lang.String extuid;
	private java.lang.String title;
	private java.lang.String message;
	private java.util.Date creationDate;
	private java.util.Date expirationDate;
	private boolean enabled;
	private java.lang.String videoUrl;
	private boolean videoOnly;

	// collections
	private java.util.Set<ir.viratech.commons.file.model.AbstractFile> images;
	private java.util.List<ir.viratech.pond_ms.model.app_message.AppMessageUrl> urls;



	/**
	 * Returns the identifier.
	 * 
	 * @return the value of id
     * @hibernate.id
     *  generator-class="increment"
     *  column="id"
     */
	public java.lang.Long getId() {
		return id;
	}

	/**
	 * Set the identifier.
	 * 
	 * @param id the new value of id
	 */
	public void setId(java.lang.Long id) {
		this.id = id;
		this.hashCode_ = Integer.MIN_VALUE;
	}




	/**
	 * Getter for "extuid".
	 * column= extuid
	 *
	 * @return the value of extuid
	 */
	public java.lang.String getExtuid() {
		return this.extuid;
	}

	/**
	 * Setter for property "extuid".
	 * column= extuid
	 *
	 * @param extuid the new value for extuid
	 */
	public void setExtuid(java.lang.String extuid) {
		this.extuid = extuid;
		this.hashCode_ = Integer.MIN_VALUE;
	}



	/**
	 * Getter for "title".
	 * column= title
	 *
	 * @return the value of title
	 */
	public java.lang.String getTitle() {
		return this.title;
	}

	/**
	 * Setter for property "title".
	 * column= title
	 *
	 * @param title the new value for title
	 */
	public void setTitle(java.lang.String title) {
		this.title = title;
	}



	/**
	 * Getter for "message".
	 * column= message
	 *
	 * @return the value of message
	 */
	public java.lang.String getMessage() {
		return this.message;
	}

	/**
	 * Setter for property "message".
	 * column= message
	 *
	 * @param message the new value for message
	 */
	public void setMessage(java.lang.String message) {
		this.message = message;
	}



	/**
	 * Getter for "creationDate".
	 * column= creationDate
	 *
	 * @return the value of creationDate
	 */
	public java.util.Date getCreationDate() {
		return this.creationDate;
	}

	/**
	 * Setter for property "creationDate".
	 * column= creationDate
	 *
	 * @param creationDate the new value for creationDate
	 */
	public void setCreationDate(java.util.Date creationDate) {
		this.creationDate = creationDate;
	}



	/**
	 * Getter for "expirationDate".
	 * column= expirationDate
	 *
	 * @return the value of expirationDate
	 */
	public java.util.Date getExpirationDate() {
		return this.expirationDate;
	}

	/**
	 * Setter for property "expirationDate".
	 * column= expirationDate
	 *
	 * @param expirationDate the new value for expirationDate
	 */
	public void setExpirationDate(java.util.Date expirationDate) {
		this.expirationDate = expirationDate;
	}



	/**
	 * Getter for "enabled".
	 * column= enabled
	 *
	 * @return the value of enabled
	 */
	public boolean isEnabled() {
		return this.enabled;
	}

	/**
	 * Setter for property "enabled".
	 * column= enabled
	 *
	 * @param enabled the new value for enabled
	 */
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}



	/**
	 * Getter for "videoUrl".
	 * column= videoUrl
	 *
	 * @return the value of videoUrl
	 */
	public java.lang.String getVideoUrl() {
		return this.videoUrl;
	}

	/**
	 * Setter for property "videoUrl".
	 * column= videoUrl
	 *
	 * @param videoUrl the new value for videoUrl
	 */
	public void setVideoUrl(java.lang.String videoUrl) {
		this.videoUrl = videoUrl;
	}



	/**
	 * Getter for "videoOnly".
	 * column= videoOnly
	 *
	 * @return the value of videoOnly
	 */
	public boolean isVideoOnly() {
		return this.videoOnly;
	}

	/**
	 * Setter for property "videoOnly".
	 * column= videoOnly
	 *
	 * @param videoOnly the new value for videoOnly
	 */
	public void setVideoOnly(boolean videoOnly) {
		this.videoOnly = videoOnly;
	}



	/**
	 * Getter for "images".
	 *
	 * @return the value of images
	 */
	public java.util.Set<ir.viratech.commons.file.model.AbstractFile> getImages() {
		return this.images;
	}

	/**
	 * Setter for property "images".
	 *
	 * @param images the new value for images
	 */
	public void setImages(java.util.Set<ir.viratech.commons.file.model.AbstractFile> images) {
		this.images = images;
	}
	/**
	 * Gets images, and creates and sets a new instance if it is null.
	 *
	 * @return the value of property images
	 */
	public java.util.Set<ir.viratech.commons.file.model.AbstractFile> getCreatedImages() {
		if (null == getImages()) this.setImages(new java.util.HashSet<ir.viratech.commons.file.model.AbstractFile>());
		return this.getImages();
	}
	
	/**
	 * Adds a member to "images".
	 * It creates the collection if it is null.
	 *
	 * @param abstractFile the new member to be added
	 */
	public void addToImages(ir.viratech.commons.file.model.AbstractFile abstractFile) {
		this.getCreatedImages().add(abstractFile);
	}
	
	/**
	 * Adds a member to "images".
	 * It creates the collection if it is null.
	 *
	 * @param abstractFile the new member to be added
	 * @deprecated Use {@link #addToImages(ir.viratech.commons.file.model.AbstractFile)} instead.
	 */
	@Deprecated
	public final void addToimages(ir.viratech.commons.file.model.AbstractFile abstractFile) {
		this.addToImages(abstractFile);
	}
	
	/**
	 * Removes a member from "images".
	 * It does nothing if the collection is null.
	 *
	 * @param abstractFile the member to be removed
	 */
	public void removeFromImages(ir.viratech.commons.file.model.AbstractFile abstractFile) {
		if (null != this.getImages()) {
			this.getImages().remove(abstractFile);
		}
	}



	/**
	 * Getter for "urls".
	 *
	 * @return the value of urls
	 */
	public java.util.List<ir.viratech.pond_ms.model.app_message.AppMessageUrl> getUrls() {
		return this.urls;
	}

	/**
	 * Setter for property "urls".
	 *
	 * @param urls the new value for urls
	 */
	public void setUrls(java.util.List<ir.viratech.pond_ms.model.app_message.AppMessageUrl> urls) {
		this.urls = urls;
	}
	/**
	 * Gets urls, and creates and sets a new instance if it is null.
	 *
	 * @return the value of property urls
	 */
	public java.util.List<ir.viratech.pond_ms.model.app_message.AppMessageUrl> getCreatedUrls() {
		if (null == getUrls()) this.setUrls(new java.util.ArrayList<ir.viratech.pond_ms.model.app_message.AppMessageUrl>());
		return this.getUrls();
	}
	
	/**
	 * Adds a member to "urls".
	 * It creates the collection if it is null.
	 *
	 * @param appMessageUrl the new member to be added
	 */
	public void addToUrls(ir.viratech.pond_ms.model.app_message.AppMessageUrl appMessageUrl) {
		this.getCreatedUrls().add(appMessageUrl);
	}
	
	/**
	 * Adds a member to "urls".
	 * It creates the collection if it is null.
	 *
	 * @param appMessageUrl the new member to be added
	 * @deprecated Use {@link #addToUrls(ir.viratech.pond_ms.model.app_message.AppMessageUrl)} instead.
	 */
	@Deprecated
	public final void addTourls(ir.viratech.pond_ms.model.app_message.AppMessageUrl appMessageUrl) {
		this.addToUrls(appMessageUrl);
	}
	
	/**
	 * Removes a member from "urls".
	 * It does nothing if the collection is null.
	 *
	 * @param appMessageUrl the member to be removed
	 */
	public void removeFromUrls(ir.viratech.pond_ms.model.app_message.AppMessageUrl appMessageUrl) {
		if (null != this.getUrls()) {
			this.getUrls().remove(appMessageUrl);
		}
	}




	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (null == obj) return false;
		if (!(obj instanceof ir.viratech.pond_ms.model.app_message.AppMessage)) return false;
		else {
			ir.viratech.pond_ms.model.app_message.AppMessage appMessage = (ir.viratech.pond_ms.model.app_message.AppMessage) obj;
			boolean isEqual = true;
			if (null == this.getExtuid() || null == appMessage.getExtuid()) return false;
			else isEqual = isEqual && (this.getExtuid().equals(appMessage.getExtuid()));
			return isEqual;
		}
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		if (Integer.MIN_VALUE == this.hashCode_) {
			StringBuilder hashStr = new StringBuilder();
			hashStr.append(this.getClass().getName() + ":");
			if (null == this.getExtuid()) return super.hashCode();
			else hashStr.append(this.getExtuid().toString() + ":");
			this.hashCode_ = hashStr.toString().hashCode();
		}
		return this.hashCode_;
	}


	
	protected String toStringData() {
		return "id: " + this.getId();
	}
	
	@Override
	public String toString() {
		return this.getClass().getSimpleName() + "{" + this.toStringData() + "}";
	}



}