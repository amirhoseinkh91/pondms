package ir.viratech.pond_ms.model.google_key;

import ir.viratech.pond_ms.model.google_key.base.BaseGoogleApiKey;

/**
 * The entity class "GoogleApiKey".
 */

public class GoogleApiKey extends BaseGoogleApiKey {
	private static final long serialVersionUID = 1L;


	public void increaseUsedCounter(){
		setUsedCounter(this.getUsedCounter() + 1);
	}

	public void decreaseUsedCounter(){
		setUsedCounter(this.getUsedCounter() - 1);
	}


}