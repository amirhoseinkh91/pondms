package ir.viratech.pond_ms.api.review.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ReviewVoteDTO {
	private int vote;

	@JsonProperty
	public int getVote() {
		return vote;
	}
	public void setVote(int vote) {
		this.vote = vote;
	}
}
