package ir.viratech.pond_ms.model.google_key.logic;


import ir.viratech.pond_ms.model.google_key.GoogleApiKey;
import ir.viratech.pond_ms.model.google_key.base.BaseGoogleApiKeyMgr;

/**
 * Mgr class for entity "ir.viratech.pond_ms.model.google_key.GoogleApiKey".
 */
public class GoogleApiKeyMgr extends BaseGoogleApiKeyMgr {

    public GoogleApiKey getAvailable(){
        return this.getDAO().getAvailable();
    }
}