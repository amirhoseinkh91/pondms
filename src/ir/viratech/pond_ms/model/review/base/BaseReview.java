package ir.viratech.pond_ms.model.review.base;

import java.io.Serializable;


/**
 *  Base class for entity "ir.viratech.pond_ms.model.review.Review".
 *  It is an automatically generated file and should not be edited.
 *
 * @hibernate.class
 *  table="pond_ms.REVIEWS"
 */

public abstract class BaseReview  implements Serializable {
	private static final long serialVersionUID = 1L;


	/** The constant referring the name of class "Review". */
	public static final String REF = "Review";
	
	/** The constant referring the property "id". */
	public static final String PROP_ID = "id";
	
	/** The constant referring the property "extuid". */
	public static final String PROP_EXTUID = "extuid";
	
	/** The constant referring the property "title". */
	public static final String PROP_TITLE = "title";
	
	/** The constant referring the property "rate". */
	public static final String PROP_RATE = "rate";
	
	/** The constant referring the property "text". */
	public static final String PROP_TEXT = "text";
	
	/** The constant referring the property "creationDate". */
	public static final String PROP_CREATION_DATE = "creationDate";
	
	/** The constant referring the property "lastModifiedDate". */
	public static final String PROP_LAST_MODIFIED_DATE = "lastModifiedDate";
	
	/** The constant referring the property "visitedDate". */
	public static final String PROP_VISITED_DATE = "visitedDate";
	
	/** The constant referring the property "typeOfVisit". */
	public static final String PROP_TYPE_OF_VISIT = "typeOfVisit";
	
	/** The constant referring the property "confirmed". */
	public static final String PROP_CONFIRMED = "confirmed";
	
	/** The constant referring the property "deleted". */
	public static final String PROP_DELETED = "deleted";
	
	/** The constant referring the property "user". */
	public static final String PROP_USER = "user";
	
	/** The constant referring the property "gisVectorObject". */
	public static final String PROP_GIS_VECTOR_OBJECT = "gisVectorObject";
	
	/** The constant referring the property "replies". */
	public static final String PROP_REPLIES = "replies";
	
	
	/** The name of table for this class. */
	public static final String TABLE = "pond_ms.REVIEWS";
	
	/** Name of column referring the property "id". */
	public static final String PROPCOLUMN_ID = "id";
	
	/** Name of column referring the property "extuid". */
	public static final String PROPCOLUMN_EXTUID = "extuid";
	
	/** Name of column referring the property "title". */
	public static final String PROPCOLUMN_TITLE = "title";
	
	/** Name of column referring the property "rate". */
	public static final String PROPCOLUMN_RATE = "rate";
	
	/** Name of column referring the property "text". */
	public static final String PROPCOLUMN_TEXT = "text";
	
	/** Name of column referring the property "creationDate". */
	public static final String PROPCOLUMN_CREATION_DATE = "creationDate";
	
	/** Name of column referring the property "lastModifiedDate". */
	public static final String PROPCOLUMN_LAST_MODIFIED_DATE = "lastModifiedDate";
	
	/** Name of column referring the property "visitedDate". */
	public static final String PROPCOLUMN_VISITED_DATE = "visitedDate";
	
	/** Name of column referring the property "typeOfVisit". */
	public static final String PROPCOLUMN_TYPE_OF_VISIT = "typeOfVisit";
	
	/** Name of column referring the property "confirmed". */
	public static final String PROPCOLUMN_CONFIRMED = "confirmed";
	
	/** Name of column referring the property "deleted". */
	public static final String PROPCOLUMN_DELETED = "deleted";
	
	/** Name of column referring the property "user". */
	public static final String PROPCOLUMN_USER = "user_id";
	
	/** Name of column referring the property "gisVectorObject". */
	public static final String PROPCOLUMN_GIS_VECTOR_OBJECT = "vector_object_id";
	
	

	
	
	


	private int hashCode_ = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
	private java.lang.String extuid;
	private java.lang.String title;
	private int rate;
	private java.lang.String text;
	private java.util.Date creationDate;
	private java.util.Date lastModifiedDate;
	private java.util.Date visitedDate;
	private java.lang.String typeOfVisit;
	private int confirmed;
	private boolean deleted;

	// many to one
	private ir.viratech.pond_ms.model.user.User user;
	private ir.viratech.pond_ms.model.map_object.vector.GISVectorObject gisVectorObject;

	// collections
	private java.util.List<ir.viratech.pond_ms.model.review.ReplyReview> replies;



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
	 * Getter for "rate".
	 * column= rate
	 *
	 * @return the value of rate
	 */
	public int getRate() {
		return this.rate;
	}

	/**
	 * Setter for property "rate".
	 * column= rate
	 *
	 * @param rate the new value for rate
	 */
	public void setRate(int rate) {
		this.rate = rate;
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
	 * Getter for "lastModifiedDate".
	 * column= lastModifiedDate
	 *
	 * @return the value of lastModifiedDate
	 */
	public java.util.Date getLastModifiedDate() {
		return this.lastModifiedDate;
	}

	/**
	 * Setter for property "lastModifiedDate".
	 * column= lastModifiedDate
	 *
	 * @param lastModifiedDate the new value for lastModifiedDate
	 */
	public void setLastModifiedDate(java.util.Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}



	/**
	 * Getter for "visitedDate".
	 * column= visitedDate
	 *
	 * @return the value of visitedDate
	 */
	public java.util.Date getVisitedDate() {
		return this.visitedDate;
	}

	/**
	 * Setter for property "visitedDate".
	 * column= visitedDate
	 *
	 * @param visitedDate the new value for visitedDate
	 */
	public void setVisitedDate(java.util.Date visitedDate) {
		this.visitedDate = visitedDate;
	}



	/**
	 * Getter for "typeOfVisit".
	 * column= typeOfVisit
	 *
	 * @return the value of typeOfVisit
	 */
	public java.lang.String getTypeOfVisit() {
		return this.typeOfVisit;
	}

	/**
	 * Setter for property "typeOfVisit".
	 * column= typeOfVisit
	 *
	 * @param typeOfVisit the new value for typeOfVisit
	 */
	public void setTypeOfVisit(java.lang.String typeOfVisit) {
		this.typeOfVisit = typeOfVisit;
	}



	/**
	 * Getter for "confirmed".
	 * column= confirmed
	 *
	 * @return the value of confirmed
	 */
	public int getConfirmed() {
		return this.confirmed;
	}

	/**
	 * Setter for property "confirmed".
	 * column= confirmed
	 *
	 * @param confirmed the new value for confirmed
	 */
	public void setConfirmed(int confirmed) {
		this.confirmed = confirmed;
	}



	/**
	 * Getter for "deleted".
	 * column= deleted
	 *
	 * @return the value of deleted
	 */
	public boolean isDeleted() {
		return this.deleted;
	}

	/**
	 * Setter for property "deleted".
	 * column= deleted
	 *
	 * @param deleted the new value for deleted
	 */
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
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
	 * Getter for "gisVectorObject".
	 * column= vector_object_id
	 *
	 * @return the value of gisVectorObject
	 */
	public ir.viratech.pond_ms.model.map_object.vector.GISVectorObject getGisVectorObject() {
		return this.gisVectorObject;
	}

	/**
	 * Setter for property "gisVectorObject".
	 * column= vector_object_id
	 *
	 * @param gisVectorObject the new value for gisVectorObject
	 */
	public void setGisVectorObject(ir.viratech.pond_ms.model.map_object.vector.GISVectorObject gisVectorObject) {
		this.gisVectorObject = gisVectorObject;
	}



	/**
	 * Getter for "replies".
	 *
	 * @return the value of replies
	 */
	public java.util.List<ir.viratech.pond_ms.model.review.ReplyReview> getReplies() {
		return this.replies;
	}

	/**
	 * Setter for property "replies".
	 *
	 * @param replies the new value for replies
	 */
	public void setReplies(java.util.List<ir.viratech.pond_ms.model.review.ReplyReview> replies) {
		this.replies = replies;
	}
	/**
	 * Gets replies, and creates and sets a new instance if it is null.
	 *
	 * @return the value of property replies
	 */
	public java.util.List<ir.viratech.pond_ms.model.review.ReplyReview> getCreatedReplies() {
		if (null == getReplies()) this.setReplies(new java.util.ArrayList<ir.viratech.pond_ms.model.review.ReplyReview>());
		return this.getReplies();
	}
	
	/**
	 * Adds a member to "replies".
	 * It creates the collection if it is null.
	 *
	 * @param replyReview the new member to be added
	 */
	public void addToReplies(ir.viratech.pond_ms.model.review.ReplyReview replyReview) {
		this.getCreatedReplies().add(replyReview);
	}
	
	/**
	 * Adds a member to "replies".
	 * It creates the collection if it is null.
	 *
	 * @param replyReview the new member to be added
	 * @deprecated Use {@link #addToReplies(ir.viratech.pond_ms.model.review.ReplyReview)} instead.
	 */
	@Deprecated
	public final void addToreplies(ir.viratech.pond_ms.model.review.ReplyReview replyReview) {
		this.addToReplies(replyReview);
	}
	
	/**
	 * Removes a member from "replies".
	 * It does nothing if the collection is null.
	 *
	 * @param replyReview the member to be removed
	 */
	public void removeFromReplies(ir.viratech.pond_ms.model.review.ReplyReview replyReview) {
		if (null != this.getReplies()) {
			this.getReplies().remove(replyReview);
		}
	}
	
	/**
	 * Adds a member to "replies" and synchronizes the reverse association.
	 *
	 * @param replyReview the new member to be added
	 */
	public void addToReplies_AndReverse(ir.viratech.pond_ms.model.review.ReplyReview replyReview) {
		this.addToReplies(replyReview);
		replyReview.setReview((ir.viratech.pond_ms.model.review.Review)this);
	}
	
	/**
	 * Removes a member from "replies" and synchronizes the reverse association.
	 *
	 * @param replyReview the member to be removed
	 */
	public void removeFromReplies_AndReverse(ir.viratech.pond_ms.model.review.ReplyReview replyReview) {
		this.removeFromReplies(replyReview);
		replyReview.setReview(null);
	}




	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (null == obj) return false;
		if (!(obj instanceof ir.viratech.pond_ms.model.review.Review)) return false;
		else {
			ir.viratech.pond_ms.model.review.Review review = (ir.viratech.pond_ms.model.review.Review) obj;
			boolean isEqual = true;
			if (null == this.getExtuid() || null == review.getExtuid()) return false;
			else isEqual = isEqual && (this.getExtuid().equals(review.getExtuid()));
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