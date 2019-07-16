package ir.viratech.pond_ms.model.review;

import ir.viratech.commons.model.UIDAndDisplayStringProvider;
import ir.viratech.pond_ms.model.review.base.BaseReplyReview;

/**
 * The entity class "ReplyReview".
 */

public class ReplyReview extends BaseReplyReview implements UIDAndDisplayStringProvider {
	private static final long serialVersionUID = 1L;


	@Override
	public String getDisplayString() {
		return getText();
	}
}