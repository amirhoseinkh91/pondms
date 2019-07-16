package ir.viratech.pond_ms.model.foursquare;

import ir.viratech.commons.model.UIDAndDisplayStringProvider;
import ir.viratech.pond_ms.model.foursquare.base.BaseFoursquareKey;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * The entity class "FoursquareKey".
 */

public class FoursquareKey extends BaseFoursquareKey implements UIDAndDisplayStringProvider {
    private static final long serialVersionUID = 1L;


    @Override
    public String getDisplayString() {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("clientId", this.getClientId());
            jsonObject.put("clientSecret", this.getClientSecret());
            jsonObject.put("usedCount" , this.getUsedCount());
            jsonObject.put("maxUsage", this.getMaxUsage());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject.toString();
    }
}