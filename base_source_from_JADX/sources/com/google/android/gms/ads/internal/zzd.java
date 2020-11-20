package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.ads.zzdyb;
import com.google.android.gms.internal.ads.zzdyr;
import com.google.android.gms.internal.ads.zzdyz;
import org.json.JSONObject;

final /* synthetic */ class zzd implements zzdyb {
    static final zzdyb zzbon = new zzd();

    private zzd() {
    }

    public final zzdyz zzf(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        if (jSONObject.optBoolean("isSuccessful", false)) {
            zzp.zzku().zzwz().zzeh(jSONObject.getString("appSettingsJson"));
        }
        return zzdyr.zzag(null);
    }
}
