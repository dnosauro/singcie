package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.zzbk;
import com.google.android.gms.ads.internal.util.zzd;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzdgl implements zzdfj<JSONObject> {
    private String zzhcg;

    public zzdgl(String str) {
        this.zzhcg = str;
    }

    public final /* synthetic */ void zzs(Object obj) {
        try {
            JSONObject zzb = zzbk.zzb((JSONObject) obj, "pii");
            if (!TextUtils.isEmpty(this.zzhcg)) {
                zzb.put("attok", this.zzhcg);
            }
        } catch (JSONException e) {
            zzd.zza("Failed putting attestation token.", e);
        }
    }
}
