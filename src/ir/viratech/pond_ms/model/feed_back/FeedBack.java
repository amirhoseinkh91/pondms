package ir.viratech.pond_ms.model.feed_back;

import ir.viratech.commons.api.dto.UidProviderDTO;
import ir.viratech.commons.model.UIDAndDisplayStringProvider;
import ir.viratech.pond_ms.model.feed_back.base.BaseFeedBack;

/**
 * The entity class "FeedBack".
 */

public class FeedBack extends BaseFeedBack implements UIDAndDisplayStringProvider {
	private static final long serialVersionUID = 1L;

	@Override
	public String getDisplayString() {
		return null;
	}
}