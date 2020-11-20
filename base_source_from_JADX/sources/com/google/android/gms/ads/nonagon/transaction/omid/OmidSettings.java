package com.google.android.gms.ads.nonagon.transaction.omid;

import org.json.JSONObject;

public class OmidSettings {
    private final JSONObject zzhja;

    public OmidSettings(JSONObject jSONObject) {
        this.zzhja = jSONObject;
    }

    public OmidMediaType getMediaType() {
        switch (this.zzhja.optInt("media_type", -1)) {
            case 0:
                return OmidMediaType.DISPLAY;
            case 1:
                return OmidMediaType.VIDEO;
            default:
                return OmidMediaType.UNKNOWN;
        }
    }

    public String getVideoEventsOwner() {
        if (zza.zzhiz[getMediaType().ordinal()] != 1) {
            return "javascript";
        }
        return null;
    }
}
