package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzp;
import org.json.JSONObject;

public final class zzaua implements zzatp {
    private zzamd<JSONObject, JSONObject> zzdxq;
    private zzamd<JSONObject, JSONObject> zzdxr;

    public zzaua(Context context) {
        this.zzdxr = zzp.zzld().zza(context, zzazh.zzzi()).zza("google.afma.request.getAdDictionary", zzamg.zzdjy, zzamg.zzdjy);
        this.zzdxq = zzp.zzld().zza(context, zzazh.zzzi()).zza("google.afma.sdkConstants.getSdkConstants", zzamg.zzdjy, zzamg.zzdjy);
    }

    public final zzamd<JSONObject, JSONObject> zzvs() {
        return this.zzdxq;
    }
}
