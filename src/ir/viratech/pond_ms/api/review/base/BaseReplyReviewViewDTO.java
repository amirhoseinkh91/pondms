package ir.viratech.pond_ms.api.review.base;

import ir.viratech.pond_ms.model.review.ReplyReview;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * A base DTO for class "ReplyReview".
 * Do not edit this file.
 * It is an automatically generated class.
 *
 */
public abstract class BaseReplyReviewViewDTO extends ir.viratech.commons.api.dto.AbstractFullDTO<ReplyReview> {
	
	
	
	
	
	
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
	
	
	// position
	
	private String position;
	
	/**
	 * Getter for property "position".
	 *
	 * @return the value of property "position"
	 */
	@JsonProperty
	public String getPosition() {
		return this.position;
	}
	
	
	// text
	
	private String text;
	
	/**
	 * Getter for property "text".
	 *
	 * @return the value of property "text"
	 */
	@JsonProperty
	public String getText() {
		return this.text;
	}
	
	
	// creationDate
	
	private java.util.Date creationDate;
	
	/**
	 * Getter for property "creationDate".
	 *
	 * @return the value of property "creationDate"
	 */
	@JsonProperty
	public java.util.Date getCreationDate() {
		return this.creationDate;
	}
	
	
	
	/////////////////////////
	// save/load functions //
	/////////////////////////
	
	/**
	 * Loads this DTO from an entity object of type "ReplyReview".
	 * 
	 * @param replyReview the entity object from which this DTO is loaded. 
	 */
	@Override
	public void loadFrom(ReplyReview replyReview) {
		this.uid = replyReview.getExtuid();
		this.position = replyReview.getPosition();
		this.text = replyReview.getText();
		this.creationDate = replyReview.getCreationDate();
	}
	
	/**
	 * Saves this DTO to an entity object of type "ReplyReview".
	 * 
	 * @param replyReview the entity object to which this DTO is saved. 
	 * @throws BadDtoEntityModificationException If this DTO is not valid for saving. 
	 */
	@Override
	public void saveTo(ReplyReview replyReview) throws ir.viratech.commons.api.entity_modifier.BadDtoEntityModificationException {
		//Disabled save for property: uid
		//Disabled save for property: position
		//Disabled save for property: text
		//Disabled save for property: creationDate
	}
	
	
	
	//////////////
	// toString //
	//////////////
	
	@Override
	protected Map<String, Object> toStringData() {
		Map<String, Object> data = super.toStringData();
		data.put("uid", this.uid);
		data.put("position", this.position);
		data.put("text", this.text);
		data.put("creationDate", this.creationDate);
		return data;
	}
	
}