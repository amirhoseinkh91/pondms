package ir.viratech.pond_ms.model.review.base;

import java.io.Serializable;


/**
 *  Base class for entity "ir.viratech.pond_ms.model.review.ReviewVote".
 *  It is an automatically generated file and should not be edited.
 *
 * @hibernate.class
 *  table="pond_ms.REVIEW_VOTES"
 */

public abstract class BaseReviewVote  implements Serializable {
	private static final long serialVersionUID = 1L;


	/** The constant referring the name of class "ReviewVote". */
	public static final String REF = "ReviewVote";
	
	/** The constant referring the property "id". */
	public static final String PROP_ID = "id";
	
	/** The constant referring the property "extuid". */
	public static final String PROP_EXTUID = "extuid";
	
	/** The constant referring the property "vote". */
	public static final String PROP_VOTE = "vote";
	
	/** The constant referring the property "date". */
	public static final String PROP_DATE = "date";
	
	/** The constant referring the property "user". */
	public static final String PROP_USER = "user";
	
	/** The constant referring the property "review". */
	public static final String PROP_REVIEW = "review";
	
	
	/** The name of table for this class. */
	public static final String TABLE = "pond_ms.REVIEW_VOTES";
	
	/** Name of column referring the property "id". */
	public static final String PROPCOLUMN_ID = "id";
	
	/** Name of column referring the property "extuid". */
	public static final String PROPCOLUMN_EXTUID = "extuid";
	
	/** Name of column referring the property "vote". */
	public static final String PROPCOLUMN_VOTE = "vote";
	
	/** Name of column referring the property "date". */
	public static final String PROPCOLUMN_DATE = "date";
	
	/** Name of column referring the property "user". */
	public static final String PROPCOLUMN_USER = "userId";
	
	/** Name of column referring the property "review". */
	public static final String PROPCOLUMN_REVIEW = "reviewId";
	
	

	
	
	


	private int hashCode_ = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
	private java.lang.String extuid;
	private int vote;
	private java.util.Date date;

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
	 * Getter for "vote".
	 * column= vote
	 *
	 * @return the value of vote
	 */
	public int getVote() {
		return this.vote;
	}

	/**
	 * Setter for property "vote".
	 * column= vote
	 *
	 * @param vote the new value for vote
	 */
	public void setVote(int vote) {
		this.vote = vote;
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



	/**
	 * Getter for "user".
	 * column= userId
	 *
	 * @return the value of user
	 */
	public ir.viratech.pond_ms.model.user.User getUser() {
		return this.user;
	}

	/**
	 * Setter for property "user".
	 * column= userId
	 *
	 * @param user the new value for user
	 */
	public void setUser(ir.viratech.pond_ms.model.user.User user) {
		this.user = user;
	}



	/**
	 * Getter for "review".
	 * column= reviewId
	 *
	 * @return the value of review
	 */
	public ir.viratech.pond_ms.model.review.Review getReview() {
		return this.review;
	}

	/**
	 * Setter for property "review".
	 * column= reviewId
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
		if (!(obj instanceof ir.viratech.pond_ms.model.review.ReviewVote)) return false;
		else {
			ir.viratech.pond_ms.model.review.ReviewVote reviewVote = (ir.viratech.pond_ms.model.review.ReviewVote) obj;
			boolean isEqual = true;
			if (null == this.getExtuid() || null == reviewVote.getExtuid()) return false;
			else isEqual = isEqual && (this.getExtuid().equals(reviewVote.getExtuid()));
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