package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzbk;
import com.google.android.gms.ads.internal.util.zzd;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzdgw implements zzdfj<JSONObject> {
    private String zzhco;
    private String zzhcp;

    public zzdgw(String str, String str2) {
        this.zzhco = str;
        this.zzhcp = str2;
    }

    public final /* synthetic */ void zzs(Object obj) {
        try {
            JSONObject zzb = zzbk.zzb((JSONObject) obj, "pii");
            zzb.put("doritos", this.zzhco);
            zzb.put("doritos_v2", this.zzhcp);
        } catch (JSONException unused) {
            zzd.zzee("Failed putting doritos string.");
        }
    }
}
