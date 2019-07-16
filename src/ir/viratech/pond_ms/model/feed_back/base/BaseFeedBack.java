package ir.viratech.pond_ms.model.feed_back.base;

import java.io.Serializable;


/**
 *  Base class for entity "ir.viratech.pond_ms.model.feed_back.FeedBack".
 *  It is an automatically generated file and should not be edited.
 *
 * @hibernate.class
 *  table="pond_ms.FEED_BACKS"
 */

public abstract class BaseFeedBack  implements Serializable {
	private static final long serialVersionUID = 1L;


	/** The constant referring the name of class "FeedBack". */
	public static final String REF = "FeedBack";
	
	/** The constant referring the property "id". */
	public static final String PROP_ID = "id";
	
	/** The constant referring the property "extuid". */
	public static final String PROP_EXTUID = "extuid";
	
	/** The constant referring the property "title". */
	public static final String PROP_TITLE = "title";
	
	/** The constant referring the property "email". */
	public static final String PROP_EMAIL = "email";
	
	/** The constant referring the property "comment". */
	public static final String PROP_COMMENT = "comment";
	
	/** The constant referring the property "date". */
	public static final String PROP_DATE = "date";
	
	
	/** The name of table for this class. */
	public static final String TABLE = "pond_ms.FEED_BACKS";
	
	/** Name of column referring the property "id". */
	public static final String PROPCOLUMN_ID = "id";
	
	/** Name of column referring the property "extuid". */
	public static final String PROPCOLUMN_EXTUID = "extuid";
	
	/** Name of column referring the property "title". */
	public static final String PROPCOLUMN_TITLE = "title";
	
	/** Name of column referring the property "email". */
	public static final String PROPCOLUMN_EMAIL = "email";
	
	/** Name of column referring the property "comment". */
	public static final String PROPCOLUMN_COMMENT = "comment";
	
	/** Name of column referring the property "date". */
	public static final String PROPCOLUMN_DATE = "date";
	
	

	
	
	


	private int hashCode_ = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
	private java.lang.String extuid;
	private java.lang.String title;
	private java.lang.String email;
	private java.lang.String comment;
	private java.util.Date date;



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
	 * Getter for "email".
	 * column= email
	 *
	 * @return the value of email
	 */
	public java.lang.String getEmail() {
		return this.email;
	}

	/**
	 * Setter for property "email".
	 * column= email
	 *
	 * @param email the new value for email
	 */
	public void setEmail(java.lang.String email) {
		this.email = email;
	}



	/**
	 * Getter for "comment".
	 * column= comment
	 *
	 * @return the value of comment
	 */
	public java.lang.String getComment() {
		return this.comment;
	}

	/**
	 * Setter for property "comment".
	 * column= comment
	 *
	 * @param comment the new value for comment
	 */
	public void setComment(java.lang.String comment) {
		this.comment = comment;
	}



	/**
	 * Getter for "date".
	 * column= date
	 *
	 * @return the value of date
	 */
	public java.util.Date getDate() {
		return this.date;
	}

	/**
	 * Setter for property "date".
	 * column= date
	 *
	 * @param date the new value for date
	 */
	public void setDate(java.util.Date date) {
		this.date = date;
	}




	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (null == obj) return false;
		if (!(obj instanceof ir.viratech.pond_ms.model.feed_back.FeedBack)) return false;
		else {
			ir.viratech.pond_ms.model.feed_back.FeedBack feedBack = (ir.viratech.pond_ms.model.feed_back.FeedBack) obj;
			boolean isEqual = true;
			if (null == this.getExtuid() || null == feedBack.getExtuid()) return false;
			else isEqual = isEqual && (this.getExtuid().equals(feedBack.getExtuid()));
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