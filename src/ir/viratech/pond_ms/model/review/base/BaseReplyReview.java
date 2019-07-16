package ir.viratech.pond_ms.model.review.base;

import java.io.Serializable;


/**
 *  Base class for entity "ir.viratech.pond_ms.model.review.ReplyReview".
 *  It is an automatically generated file and should not be edited.
 *
 * @hibernate.class
 *  table="pond_ms.REPLY_REVIEWS"
 */

public abstract class BaseReplyReview  implements Serializable {
	private static final long serialVersionUID = 1L;


	/** The constant referring the name of class "ReplyReview". */
	public static final String REF = "ReplyReview";
	
	/** The constant referring the property "id". */
	public static final String PROP_ID = "id";
	
	/** The constant referring the property "extuid". */
	public static final String PROP_EXTUID = "extuid";
	
	/** The constant referring the property "position". */
	public static final String PROP_POSITION = "position";
	
	/** The constant referring the property "creationDate". */
	public static final String PROP_CREATION_DATE = "creationDate";
	
	/** The constant referring the property "text". */
	public static final String PROP_TEXT = "text";
	
	/** The constant referring the property "confirmed". */
	public static final String PROP_CONFIRMED = "confirmed";
	
	/** The constant referring the property "user". */
	public static final String PROP_USER = "user";
	
	/** The constant referring the property "review". */
	public static final String PROP_REVIEW = "review";
	
	
	/** The name of table for this class. */
	public static final String TABLE = "pond_ms.REPLY_REVIEWS";
	
	/** Name of column referring the property "id". */
	public static final String PROPCOLUMN_ID = "id";
	
	/** Name of column referring the property "extuid". */
	public static final String PROPCOLUMN_EXTUID = "extuid";
	
	/** Name of column referring the property "position". */
	public static final String PROPCOLUMN_POSITION = "position";
	
	/** Name of column referring the property "creationDate". */
	public static final String PROPCOLUMN_CREATION_DATE = "creationDate";
	
	/** Name of column referring the property "text". */
	public static final String PROPCOLUMN_TEXT = "text";
	
	/** Name of column referring the property "confirmed". */
	public static final String PROPCOLUMN_CONFIRMED = "confirmed";
	
	/** Name of column referring the property "user". */
	public static final String PROPCOLUMN_USER = "user_id";
	
	/** Name of column referring the property "review". */
	public static final String PROPCOLUMN_REVIEW = "review_id";
	
	

	
	
	


	private int hashCode_ = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
	private java.lang.String extuid;
	private java.lang.String position;
	private java.util.Date creationDate;
	private java.lang.String text;
	private boolean confirmed;

	// many to one
	private ir.viratech.pond_ms.model.user.User user;
	private ir.viratech.pond_ms.model.review.Review review;



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
	 * Getter for "position".
	 * column= position
	 *
	 * @return the value of position
	 */
	public java.lang.String getPosition() {
		return this.position;
	}

	/**
	 * Setter for property "position".
	 * column= position
	 *
	 * @param position the new value for position
	 */
	public void setPosition(java.lang.String position) {
		this.position = position;
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
	 * Getter for "text".
	 * column= text
	 *
	 * @return the value of text
	 */
	public java.lang.String getText() {
		return this.text;
	}

	/**
	 * Setter for property "text".
	 * column= text
	 *
	 * @param text the new value for text
	 */
	public void setText(java.lang.String text) {
		this.text = text;
	}



	/**
	 * Getter for "confirmed".
	 * column= confirmed
	 *
	 * @return the value of confirmed
	 */
	public boolean isConfirmed() {
		return this.confirmed;
	}

	/**
	 * Setter for property "confirmed".
	 * column= confirmed
	 *
	 * @param confirmed the new value for confirmed
	 */
	public void setConfirmed(boolean confirmed) {
		this.confirmed = confirmed;
	}



	/**
	 * Getter for "user".
	 * column= user_id
	 *
	 * @return the value of user
	 */
	public ir.viratech.pond_ms.model.user.User getUser() {
		return this.user;
	}

	/**
	 * Setter for property "user".
	 * column= user_id
	 *
	 * @param user the new value for user
	 */
	public void setUser(ir.viratech.pond_ms.model.user.User user) {
		this.user = user;
	}



	/**
	 * Getter for "review".
	 * column= review_id
	 *
	 * @return the value of review
	 */
	public ir.viratech.pond_ms.model.review.Review getReview() {
		return this.review;
	}

	/**
	 * Setter for property "review".
	 * column= review_id
	 *
	 * @param review the new value for review
	 */
	public void setReview(ir.viratech.pond_ms.model.review.Review review) {
		this.review = review;
	}




	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (null == obj) return false;
		if (!(obj instanceof ir.viratech.pond_ms.model.review.ReplyReview)) return false;
		else {
			ir.viratech.pond_ms.model.review.ReplyReview replyReview = (ir.viratech.pond_ms.model.review.ReplyReview) obj;
			boolean isEqual = true;
			if (null == this.getExtuid() || null == replyReview.getExtuid()) return false;
			else isEqual = isEqual && (this.getExtuid().equals(replyReview.getExtuid()));
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