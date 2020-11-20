package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzd;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzdgr implements zzdfj<JSONObject> {
    private JSONObject zzhck;

    public zzdgr(JSONObject jSONObject) {
        this.zzhck = jSONObject;
    }

    public final /* synthetic */ void zzs(Object obj) {
        try {
            ((JSONObject) obj).put("cache_state", this.zzhck);
        } catch (JSONException unused) {
            zzd.zzee("Unable to get cache_state");
        }
    }
}
