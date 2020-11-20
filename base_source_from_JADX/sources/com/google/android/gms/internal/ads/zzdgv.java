package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzd;
import org.json.JSONException;
import org.json.JSONObject;

final class zzdgv implements zzdfi<zzdfj<JSONObject>> {
    private final JSONObject zzhcn;

    zzdgv(Context context) {
        this.zzhcn = zzatx.zzw(context);
    }

    public final zzdyz<zzdfj<JSONObject>> zzasm() {
        return zzdyr.zzag(new zzdgu(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzq(JSONObject jSONObject) {
        try {
            jSONObject.put("gms_sdk_env", this.zzhcn);
        } catch (JSONException unused) {
            zzd.zzee("Failed putting version constants.");
        }
    }
}
