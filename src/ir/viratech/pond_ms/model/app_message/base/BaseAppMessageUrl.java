package ir.viratech.pond_ms.model.app_message.base;

import java.io.Serializable;


/**
 *  Base class for entity "ir.viratech.pond_ms.model.app_message.AppMessageUrl".
 *  It is an automatically generated file and should not be edited.
 *
 * @hibernate.class
 *  table="pond_ms.APP_MESSAGE_URLS"
 */

public abstract class BaseAppMessageUrl  implements Serializable {
	private static final long serialVersionUID = 1L;


	/** The constant referring the name of class "AppMessageUrl". */
	public static final String REF = "AppMessageUrl";
	
	/** The constant referring the property "id". */
	public static final String PROP_ID = "id";
	
	/** The constant referring the property "indexInAppMessage". */
	public static final String PROP_INDEX_IN_APP_MESSAGE = "indexInAppMessage";
	
	/** The constant referring the property "url". */
	public static final String PROP_URL = "url";
	
	/** The constant referring the property "appMessage". */
	public static final String PROP_APP_MESSAGE = "appMessage";
	
	
	/** The name of table for this class. */
	public static final String TABLE = "pond_ms.APP_MESSAGE_URLS";
	
	/** Name of column referring the property "id". */
	public static final String PROPCOLUMN_ID = "id";
	
	/** Name of column referring the property "indexInAppMessage". */
	public static final String PROPCOLUMN_INDEX_IN_APP_MESSAGE = "indexInAppMessage";
	
	/** Name of column referring the property "url". */
	public static final String PROPCOLUMN_URL = "url";
	
	/** Name of column referring the property "appMessage". */
	public static final String PROPCOLUMN_APP_MESSAGE = "appMessageId";
	
	

	
	
	


	private int hashCode_ = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
	private int indexInAppMessage;
	private java.lang.String url;

	// many to one
	private ir.viratech.pond_ms.model.app_message.AppMessage appMessage;



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
	 * Getter for "indexInAppMessage".
	 * column= indexInAppMessage
	 *
	 * @return the value of indexInAppMessage
	 */
	public int getIndexInAppMessage() {
		return this.indexInAppMessage;
	}

	/**
	 * Setter for property "indexInAppMessage".
	 * column= indexInAppMessage
	 *
	 * @param indexInAppMessage the new value for indexInAppMessage
	 */
	public void setIndexInAppMessage(int indexInAppMessage) {
		this.indexInAppMessage = indexInAppMessage;
	}



	/**
	 * Getter for "url".
	 * column= url
	 *
	 * @return the value of url
	 */
	public java.lang.String getUrl() {
		return this.url;
	}

	/**
	 * Setter for property "url".
	 * column= url
	 *
	 * @param url the new value for url
	 */
	public void setUrl(java.lang.String url) {
		this.url = url;
	}



	/**
	 * Getter for "appMessage".
	 * column= appMessageId
	 *
	 * @return the value of appMessage
	 */
	public ir.viratech.pond_ms.model.app_message.AppMessage getAppMessage() {
		return this.appMessage;
	}

	/**
	 * Setter for property "appMessage".
	 * column= appMessageId
	 *
	 * @param appMessage the new value for appMessage
	 */
	public void setAppMessage(ir.viratech.pond_ms.model.app_message.AppMessage appMessage) {
		this.appMessage = appMessage;
	}




	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (null == obj) return false;
		if (!(obj instanceof ir.viratech.pond_ms.model.app_message.AppMessageUrl)) return false;
		else {
			ir.viratech.pond_ms.model.app_message.AppMessageUrl appMessageUrl = (ir.viratech.pond_ms.model.app_message.AppMessageUrl) obj;
			if (null == this.getId() || null == appMessageUrl.getId()) return false;
			else return (this.getId().equals(appMessageUrl.getId()));
		}
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		if (Integer.MIN_VALUE == this.hashCode_) {
			if (null == this.getId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getId().hashCode();
				this.hashCode_ = hashStr.hashCode();
			}
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