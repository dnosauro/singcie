package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzd;
import org.json.JSONObject;

final /* synthetic */ class zzcox implements zzdqv {
    static final zzdqv zzgmk = new zzcox();

    private zzcox() {
    }

    public final Object apply(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        zzd.zzee("Ad request signals:");
        zzd.zzee(jSONObject.toString(2));
        return jSONObject;
    }
}
